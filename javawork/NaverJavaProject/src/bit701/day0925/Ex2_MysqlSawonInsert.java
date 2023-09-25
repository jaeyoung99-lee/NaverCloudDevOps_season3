package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.DbConnect;

public class Ex2_MysqlSawonInsert {

	DbConnect db = new DbConnect();
	
	public void sawonInsert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("1 ~ 100 사이 점수");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별");
		String gender = sc.nextLine();
		System.out.println("부서");
		String buseo = sc.nextLine();
		
		// null 값 넣어서 auto_increment로 자동으로 숫자 늘어나게 함
		String sql = "insert into sawon values (null, '" + name + "', " + score + ", '" + gender + "', '" + buseo + "')";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			// 실행
			stmt.execute(sql);
			System.out.println("사원 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		Ex2_MysqlSawonInsert ex = new Ex2_MysqlSawonInsert();
		ex.sawonInsert();
	}

}
