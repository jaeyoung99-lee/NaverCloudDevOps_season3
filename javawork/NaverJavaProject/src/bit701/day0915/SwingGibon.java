package bit701.day0915;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame{

	public SwingGibon(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출, 이것 때문에 안녕이라는 글자가 나옴
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
				JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다");
				// 실제 종료
				System.exit(0); // 정상종료
				super.windowClosing(e);
			}
		});
	}
	
	private void setDesign() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingGibon s = new SwingGibon("안녕");
	}

}
