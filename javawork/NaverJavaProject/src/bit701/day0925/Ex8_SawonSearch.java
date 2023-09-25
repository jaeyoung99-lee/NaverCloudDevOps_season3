package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import DB.DbConnect;

public class Ex8_SawonSearch {
	
	DbConnect db = new DbConnect();
	
	public void searchSawon() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름 입력");
		String name = sc.nextLine();
		
		String sql = "select * from sawon where name like ?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1,  "%" + name + "%");
			// 실행
			rs = pstmt.executeQuery();
			
			System.out.println(name + " 검색 결과");
			
			int cnt = 0;
			while(rs.next()) {
			int num = rs.getInt("num");
			String name1 = rs.getString("name");
			int score = rs.getInt("score");
			String gender = rs.getString("gender");
			String buseo = rs.getString("buseo");
			
			System.out.println(cnt++);
			System.out.println("번호 : " + num);
			System.out.println("이름 : " + name);
			System.out.println("성별 : " + gender);
			System.out.println("부서 : " + buseo);
			System.out.println("점수 : " + score);
			System.out.println("-".repeat(20));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	public static void main(String[] args) {
		Ex8_SawonSearch ex = new Ex8_SawonSearch();
		ex.searchSawon();
	}

}
