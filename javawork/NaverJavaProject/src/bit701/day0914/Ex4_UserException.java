package bit701.day0914;

import java.util.Scanner;

class NicknameException extends Exception{
	public NicknameException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

public class Ex4_UserException {

	public static void dataInput() throws NicknameException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		String nickName;
		System.out.println("닉네임이 무엇인가요?");
		nickName = sc.nextLine();
		if(nickName.equals("바보") || nickName.equals("이놈")){
			throw new NicknameException("고운 말을 씁시다!!"); // 강제로 예외 발생 시킴
		}
		
		Thread.sleep(1000); // 1초 후 출력
		System.out.println("당신의 닉네임이 " + nickName + "이군요!!!");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		try {
			dataInput();
		} catch (NicknameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
