package bit701.day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex4_ServerChat extends JFrame implements Runnable{

	JTextArea area;
	
	// 접속하는 클라이언트들을 저장할 Vector
	Vector<ClientMember> listMember = new Vector<ClientMember>();
	
	public Ex4_ServerChat() {
		super("채팅 서버");
		this.setBounds(1300, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	// 1번 스레드의 run 메서드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// 서버 소켓 생성
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			area.append("서버 소켓 생성 성공!!\n");
			
			// 접속하는 클라이언트들 허용
			while(true) {
				// 대기중이다가 접속 요청하는 클라이언트 허용
				// 허용이 되면 Socket이 만들어짐
				Socket socket = serverSocket.accept();
				// 허용된 클라이언트들을 벡터에 추가
				ClientMember clientMember = new ClientMember(socket);
				listMember.add(clientMember);
				// 각 클라이언트의 run 메서드 호출
				clientMember.start();
				
				area.append("접속 허용 IP : " + socket.getInetAddress().getHostAddress() + "\n");
				this.autoScroll();
			}
		} catch (IOException e) {
			area.append("서버 소켓 생성 실패 : " + e.getMessage());
		} 
	}
	
	// 접속한 클라이언트와 대화를 주고 받을 내부 클래스
	class ClientMember extends Thread{
		Socket mySocket;
		BufferedReader br;
		PrintWriter pw;
		String nickName;
		
		public ClientMember(Socket socket) {
			// TODO Auto-generated constructor stub
			
			mySocket = socket;
			// 대화를 주고 받을 수 있게  io 클래스 얻기
			InputStream is = null;
			try {
				is = mySocket.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(mySocket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// 언제 클라이언트들이 메시지를 보낼지 모르므로 while문을 열어놓는다
			while(true) {
				// 클라이언트들이 보낸 메시지를 읽는다
				try {
					String message = br.readLine();
					// 처음 접속 시 : 1|닉네임           메시지 : 2|메시지
					System.out.println(message);
					String[] arr = message.split("\\|");
//					System.out.println(arr[0] + ", " + arr[1]);
					
					switch(arr[0]) {
					case "1":
						this.nickName = arr[1];
						// 접속한 모든 클라이언트들한테 누가 입장했는지를 알린다
						for(ClientMember mem : listMember) {
							mem.pw.println(this.nickName + " >> 님이 입장하였습니다\n");
							mem.pw.flush(); // 이때 비로소 전송이 된다
						}
						break;
					case "2":
						// 보낸 메시지가 arr[1]에 들어있다
						// 접속한 모든 클라이언트들한테 누가 어떤 메시지를 보냈는지를 알린다
						for(ClientMember mem : listMember) {
							mem.pw.println(this.nickName + " >> " + arr[1] + "\n");
							mem.pw.flush(); // 이때 비로소 전송이 된다
						}
						break;						
					}
				} catch (IOException|ArrayIndexOutOfBoundsException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
			}
		}
	}
	
	public void autoScroll() {
		int n = area.getDocument().getLength(); // 총 라인 수
		area.setCaretPosition(n); // 마지막 줄로 위치 변경
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		
		area = new JTextArea();
		this.add(new JScrollPane(area));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex4_ServerChat serverChat = new Ex4_ServerChat();
		Thread th = new Thread(serverChat);
		th.start(); // 1번 run 메서드 호출
	}

}
