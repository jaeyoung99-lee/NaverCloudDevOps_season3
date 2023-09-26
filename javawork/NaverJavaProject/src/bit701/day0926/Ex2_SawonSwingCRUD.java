package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DbConnect;

public class Ex2_SawonSwingCRUD extends JFrame {
	JTextField tfName, tfScore;
	JComboBox<String> cbGender, cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;
	
	DbConnect db = new DbConnect();
	
	public Ex2_SawonSwingCRUD() {
		super("사원관리");
		this.setBounds(1000, 100, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		// 상단
		tfName = new JTextField(4);
		tfScore = new JTextField(3);
		String[] cbTitle_Gender = {"남자", "여자"};
		cbGender = new JComboBox<String>(cbTitle_Gender);
		String[] cbTitle_Buseo = {"홍보부", "인사부", "교육부", "환경부"};
		cbBuseo = new JComboBox<String>(cbTitle_Buseo);
		
		JPanel pTop = new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("점수"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);
		
		this.add("North", pTop);
		
		// 하단
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearch = new JButton("검색");
		btnAll = new JButton("전체조회");
		
		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		
		// 버튼 이벤트
		
		// 추가
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터를 가져온다
				String name = tfName.getText();
				String score = tfScore.getText();
				String gender = (String) cbGender.getSelectedItem();
				String buseo = (String) cbBuseo.getSelectedItem();
				// 이름이나 전화번호 입력 안했을 경우 종료
				if(name.length() == 0 || score.length() == 0)
					return;
				
				
				// DB에 insert하는 메서드 호출
				insertSawon(name, score, gender, buseo);
				// DB로부터 다시 데이터를 가져와서 출력
				sawonSelectAll();
				// 입력값 초기화
				tfName.setText("");
				tfScore.setText("");
			}
		});
		
		// 삭제
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 행 번호를 얻는다
				int row = table.getSelectedRow();
				System.out.println(row); // 선택 안했을 경우 -1
				if(row == -1) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "삭제할 행을 선택해주세요");
				}
				else {
					// row행의 0번열이 num 값
					String num = table.getValueAt(row, 0).toString();
					deleteSawon(num);
					// 삭제 후 데이터 다시 불러온다
					sawonSelectAll();
				}
			}
		});
		
		// 검색
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 검색할 이름 입력 받기
				String searchBuseo = JOptionPane.showInputDialog("검색할 부서를 입력해주세요"); // showInputDialog : 자바스크립트의 prompt와 같음
				System.out.println(searchBuseo);
				if(searchBuseo == null)
					return; // 취소 누를 경우 이벤트 종료
				else
					searchSawon(searchBuseo); // 이름이 포함된 모든 데이터를 테이블에 출력
			}
		});
		
		
		// 전체 조회
		btnAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sawonSelectAll();
			}
		});
		
		this.add("South", pBottom);
		
		// Center Table
		String[] title = {"번호", "이름", "점수", "성별", "부서"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		
		// 초기 DB 데이터 가져오기
		sawonSelectAll();
	}
	
	public static void main(String[] args) {
		Ex2_SawonSwingCRUD ex = new Ex2_SawonSwingCRUD();
	}

	// DB method
	// DB에서 전체 데이터를 가져와서 테이블에 출력하는 메서드
	public void sawonSelectAll() {
		// 기존 테이블의 데이터를 모두 지움
		tableModel.setRowCount(0);
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon order by num asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				
				// Vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn); 
		}
	}
	
	private void searchSawon(String searchBuseo) {
		// 기존 테이블의 데이터를 모두 지움
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where buseo like ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchBuseo + "%부");
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");

				// Vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn); 
		}
	}
	
	// DB에 추가
	public void insertSawon(String name, String score, String gender, String buseo) {
//		System.out.println(name);
//		System.out.println(score);
//		System.out.println(gender);
//		System.out.println(buseo);
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into sawon values (null, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 4개 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// DB 삭제하는 메서드
	public void deleteSawon(String num) {
//		System.out.println(num);
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from sawon where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 1개 바인딩
			pstmt.setString(1, num);
			
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}
