package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.DbConnect;

public class Ex1_OracleShopInsert {
	
	DbConnect db = new DbConnect();
	
	public void shopInsert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명 입력");
		String sang = sc.nextLine();
		
		System.out.println("가격 입력");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.println("색상 입력");
		String color = sc.nextLine();
		
		String sql = "insert into shop values (seq_shop.nextval, '" + sang + "', " + price + ", '" + color + "')";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		// db 연결
		conn = db.getOracleConnection();
		
		// statement
		try {
			stmt = conn.createStatement();
			// 실행
//			boolean b = stmt.execute(sql); // 반환타입이 boolean, 결과 : false(실행 결과가 없을 경우 - select가 없을 경우)
//			int n = stmt.executeUpdate(sql); // 반환타입이 int, 결과 : sql문을 성공한 개수
//			System.out.println(b + ", " + n);
//			System.out.println("데이터 두 번 insert 됨");
			
			// 위의 주석 코드는 확인차 해본 것이고 평소에 쓸 때는 아래 stmt.execute(sql);만 쓰면 됨
			stmt.execute(sql);
			System.out.println("shop에 데이터 추가됨");
		} catch (SQLException e) {
			System.out.println("insert sql문 오류 : " + e.getMessage());
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		Ex1_OracleShopInsert ex = new Ex1_OracleShopInsert();
		ex.shopInsert();
	}

}
