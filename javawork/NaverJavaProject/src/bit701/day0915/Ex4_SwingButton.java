package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex4_SwingButton extends JFrame{
	JButton btn1, btn2, btn3;
	
	public Ex4_SwingButton(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출, 이것 때문에 이벤트 연습이라는 글자가 나옴
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(300, 300); // 프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.green); // Color 상수를 이용해서 변경
		this.getContentPane().setBackground(new Color(200, 255, 180)); // 0 ~ 255의 rgb
		
		// 디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		this.setVisible(true); // true : 프레임을 보이게 하기, false : 프레임 숨기기
		
		// 윈도우 이벤트 발생
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // x 버튼 클릭 시 호출되는 메서드
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0); // 정상종료
				super.windowClosing(e);
			}
		});
	}
	
	// 버튼 이벤트를 내부클래스로 만듦
	class MyColorButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == btn1) {
				Ex4_SwingButton.this.getContentPane().setBackground(Color.orange);
			}
			else {
				Ex4_SwingButton.this.getContentPane().setBackground(Color.magenta);
			}
				
		}
	}
	
	private void setDesign() {
		// 자바에서 제공하는 레이아웃을 안쓰고 직접 위치지정을 할 경우
		this.setLayout(null);
		
		// 버튼1 생성
		btn1 = new JButton("오렌지색");
		btn1.setBounds(20, 50, 100, 50); // x, y, width, height
		this.add(btn1);
		
		// 버튼2 생성
		btn2 = new JButton("분홍색");
		btn2.setBounds(130, 50, 100, 50); // x, y, width, height
		this.add(btn2);
		
		// 버튼 1, 2는 내부클래스 MyColorButton의 이벤트를 호출
		btn1.addActionListener(new MyColorButton());
		btn2.addActionListener(new MyColorButton());
		
		// 버튼3 생성
		btn3 = new JButton("버튼 글자·배경색 변경");
		btn3.setBounds(20, 120, 210, 50); // x, y, width, height
		this.add(btn3);

		// 버튼3은 익명 내부클래스 형태로 만듦
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				btn1.setBackground(Color.green);
				btn1.setForeground(Color.red);
				

				btn2.setBackground(Color.pink);
				btn2.setForeground(Color.blue);

				btn3.setBackground(Color.black);
				btn3.setForeground(Color.yellow);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex4_SwingButton s = new Ex4_SwingButton("이벤트 연습");
	}

}