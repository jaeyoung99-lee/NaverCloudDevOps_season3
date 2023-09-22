package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlGroupSawon {

	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex3_MysqlGroupSawon() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패 : " + e.getMessage());
		}
	}
	
	public void sawonBunseok() {
		String sql = "select buseo, count(*) count, max(score) maxScore, min(score) minScore, avg(score) avgScore from sawon group by buseo";
		
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null; // select일 경우에만 필요
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			System.out.println("Mysql 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // select일 경우는 무조건 executeQuery(반환타입이 ResultSet)
			
			// rs.next() : 다음 데이터로 이동을 하고 true 반환, 이동할 데이터가 없을 경우 false 반환
			
			System.out.println("buseo\tcount\tmaxScore\tminScore\tavgScore");
			System.out.println("=".repeat(40));
			int total = 0;
			int count = 0;
			double avg;
			
			while(rs.next()) {
				//데이터를 가져올 때 인덱스로 가져오거나 컬럼명으로 가져온다
				
				// 컬럼명으로 가져오기
				String buseo = rs.getString("buseo");
				String num = rs.getString("count");
				int minscore = rs.getInt("minScore");
				int maxscore = rs.getInt("maxScore");
				int avgscore = rs.getInt("avgScore");
				
				System.out.println(buseo + "\t" + num + "\t" + maxscore + "\t" + minscore + "\t" + avgscore);
			}
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패 : " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex3_MysqlGroupSawon ex = new Ex3_MysqlGroupSawon();
		ex.sawonBunseok();
	}

}
