package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.DbConnect;

public class Ex3_OracleShopDelete {

	DbConnect db = new DbConnect();
	
	public void shopDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 상품명 입력");
		String sang = sc.nextLine();
		String sql = "delete from shop where sang_name = '" + sang + "'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		conn = db.getOracleConnection();
		try {
			stmt = conn.createStatement();
			// 실행 - 성공적으로 삭제된 레코드의 개수를 알고 싶다면 executeUpdate
			int n =stmt.executeUpdate(sql);
			
			if(n == 0)
				System.out.println(sang + "상품은 목록에 없습니다.");
			else
				System.out.println("총 " + n + "개의 " + sang + "상품을 삭제했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		Ex3_OracleShopDelete ex = new Ex3_OracleShopDelete();
		ex.shopDelete();
	}

}
