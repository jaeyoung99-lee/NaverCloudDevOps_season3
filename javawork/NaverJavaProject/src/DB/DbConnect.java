package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	// MySQL
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	// static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String MYSQL_URL = "jdbc:mysql://db-jbnls-kr.vpc-pub-cdb.ntruss.com/studydb?serverTimezone=Asia/Seoul";
	
	// Oracle
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public DbConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql Driver Error : " + e.getMessage());
		}
		
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Oracle Driver Error : " + e.getMessage());
		}
	}
	
	// Oracle 연결
	public Connection getOracleConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Oracle Connection Error : " + e.getMessage());
		}
		return conn;
	}
	
	// MySQL 연결
	public Connection getMysqlConnection() {
		Connection conn = null;
		try {
			// local 연결
			// conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			
			// 원격 mysql 연결
			conn = DriverManager.getConnection(MYSQL_URL, "study", "bitcamp123!@#");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL Connection Error : " + e.getMessage());
		}
		return conn;
	}
	
	// close #1
	public void dbClose(Statement stmt, Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException|NullPointerException e) {
			System.out.println("Error while 'close' : " + e.getMessage());
		}
	}
	
	// close #2
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException|NullPointerException e) {
			System.out.println("Error while 'close' : " + e.getMessage());
		}
	}

	// close #3
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException|NullPointerException e) {
			System.out.println("Error while 'close' : " + e.getMessage());
		}
	}

	// close #4
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException|NullPointerException e) {
			System.out.println("Error while 'close' : " + e.getMessage());
		}
	}
}
