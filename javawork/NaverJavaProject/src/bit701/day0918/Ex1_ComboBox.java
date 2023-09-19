package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex1_ComboBox extends JFrame{

	JPanel p = new JPanel();
	JComboBox<String> combo;
	JRadioButton rbYellow, rbMagenta, rbGray, rbBlue;
	JLabel lblMessage;
	
	public Ex1_ComboBox(String title) {
		super(title);
		this.setBounds(1300, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 종료해주는 메서드
		this.setDesion();
		this.setVisible(true);
	}
	
	private void setDesion() {
		Vector<String> list = new Vector<String>();
		list.add("빨강");
		list.add("초록");
		list.add("분홍");
		list.add("오렌지");
		
		// 콤보박스 생성
		combo = new JComboBox<String>(list);
		// 상단에 추가
//		this.add("North", combo); // 상단 전체에 추가된다
		JPanel pTop = new JPanel();
		pTop.add(combo);
		this.add("North", pTop);
		
		// p 패널에 라벨 추가
		lblMessage = new JLabel("Have a Nice Day!!!");
		lblMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		p.add(lblMessage);
		
		//Center에는 JPanel p를 추가
		p.setBackground(Color.red);
		this.add("Center",p);
		
		// 콤보박스 이벤트
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
		
				// 선택한 문자열을 얻어보자
				String selectColor = (String)combo.getSelectedItem();
//				System.out.println(selectColor);
				
				// jdk8부터 switch에서 String도 가능
				switch(selectColor) {
					case "빨강":
						p.setBackground(Color.red);
						break;
					case "분홍":
						p.setBackground(Color.pink);
						break;
					case "오렌지":
						p.setBackground(Color.orange);
						break;
					case "초록":
						p.setBackground(Color.green);
						break;
				}
			}
		});
		
		// 하단에 4개의 라디오 버튼 추가하기
		ButtonGroup bg = new ButtonGroup();
		rbYellow = new JRadioButton("노랑");
		rbMagenta = new JRadioButton("분홍");
		rbGray = new JRadioButton("회색");
		rbBlue = new JRadioButton("파랑");
		
		// 라디오 버튼들을 같은 그룹으로 묶기(그래야 4개 중 한 개만 선택된다)
		bg.add(rbYellow);
		bg.add(rbMagenta);
		bg.add(rbGray);
		bg.add(rbBlue);
		
		// 4개의 라디오 버튼을 일단 패널에 묶어서 넣은 후 프레임에 추가하기
		JPanel pBottom = new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbMagenta);
		pBottom.add(rbGray);
		pBottom.add(rbBlue);
		
		this.add("South", pBottom);
		
		// 글자색 변경 이벤트(배열이 아니므로 각각 이벤트 추가)
		rbYellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				lblMessage.setForeground(Color.yellow);
			}
		});

		rbMagenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				lblMessage.setForeground(Color.magenta);
			}
		});

		rbGray.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				lblMessage.setForeground(Color.gray);
			}
		});

		rbBlue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				lblMessage.setForeground(Color.blue);
			}
		});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex1_ComboBox ex = new Ex1_ComboBox("ComboBox");
	}

}
