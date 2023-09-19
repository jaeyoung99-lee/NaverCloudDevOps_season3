package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bit701.day0915.Ex4_SwingButton.MyColorButton;

public class HomeWork extends JFrame{

	JButton btn1, btn2, btn3, btn4;
	
	public HomeWork(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출, 이것 때문에 안녕이라는 글자가 나옴
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(500, 600); // 프레임의 너비, 높이
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
				JOptionPane.showMessageDialog(HomeWork.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0); // 정상종료
				super.windowClosing(e);
			}
		});
	}
	
	private void setDesign() {
		// 자바에서 제공하는 레이아웃을 안쓰고 직접 위치지정을 할 경우
		this.setLayout(null);
		
		// 버튼1 생성
		btn1 = new JButton("사람");
		btn1.setBounds(70, 10, 70, 25); // x, y, width, height
		this.add(btn1);
		
		// 버튼2 생성
		btn2 = new JButton("동물");
		btn2.setBounds(150, 10, 70, 25); // x, y, width, height
		this.add(btn2);
		
		// 버튼3 생성
		btn3 = new JButton("음식");
		btn3.setBounds(230, 10, 70, 25); // x, y, width, height
		this.add(btn3);

		// 버튼4 생성
		btn4 = new JButton("쇼핑몰");
		btn4.setBounds(310, 10, 100, 25); // x, y, width, height
		this.add(btn4);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HomeWork s = new HomeWork("HomeWork");
	}

}
