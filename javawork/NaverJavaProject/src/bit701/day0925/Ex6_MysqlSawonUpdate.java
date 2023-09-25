package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.DbConnect;

public class Ex6_MysqlSawonUpdate {

	DbConnect db = new DbConnect();
	
	public void  sawonUpdate() {
		Scanner sc = new Scanner(System.in);
		
		// num, name, score, buseo를 입력 받은 후 num에 해당하는 name, score, buseo를 수정하기
		// num이 없으면 '해당 데이터가 없습니다' 출력
		
		System.out.println("수정할 사원 번호를 입력하세요");
		String num = sc.nextLine();
		System.out.println("수정할 이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("수정할 점수를 입력하세요");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 부서를 입력하세요");
		String buseo = sc.nextLine();
		
		String sql = "update sawon set name = '" + name + "', score = " + score + ", buseo = '" + buseo+ "' where num = " + num;
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if(n == 0)
				System.out.println("해당 데이터가 없습니다");
			else
				System.out.println("수정 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	
	public static void main(String[] args) {
		Ex6_MysqlSawonUpdate ex = new Ex6_MysqlSawonUpdate();
		ex.sawonUpdate();
	}

}
