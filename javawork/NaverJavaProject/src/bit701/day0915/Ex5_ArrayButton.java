package bit701.day0915;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex5_ArrayButton extends JFrame{
	JButton[] btn = new JButton[6];
	String[] buttonTitle = {"노랑", "오렌지", "분홍", "핫핑크", "초록", "빨강"};
	Color[] buttonColor = {Color.yellow, Color.orange, Color.pink, Color.magenta, Color.green, Color.red};
	
	public Ex5_ArrayButton(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출, 이것 때문에 배열 버튼이라는 글자가 나옴
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
				JOptionPane.showMessageDialog(Ex5_ArrayButton.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0); // 정상종료
				super.windowClosing(e);
			}
		});
	}
	
	// 배열 버튼 이벤트를 위한 내부 클래스
	class MyButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			for(int i = 0; i < btn.length; i++) {
				if(e.getSource() == btn[i]) {
					Ex5_ArrayButton.this.getContentPane().setBackground(buttonColor[i]);
				}
			}
		}
	}
	
	private void setDesign() {
		// 레이아웃 변경
		this.setLayout(new FlowLayout()); // 순서대로 나열
		
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(buttonTitle[i]);
			btn[i].setBackground(buttonColor[i]);
			this.add(btn[i]);
			
			// 버튼 이벤트 발생
			btn[i].addActionListener(new MyButton());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex5_ArrayButton s = new Ex5_ArrayButton("배열 버튼");
	}

}
