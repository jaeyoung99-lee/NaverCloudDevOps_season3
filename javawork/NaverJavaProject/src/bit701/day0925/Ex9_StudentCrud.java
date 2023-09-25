package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import DB.DbConnect;

public class Ex9_StudentCrud {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	public int getMenu() {
		System.out.println("1.추가  2.삭제  3.수정  4.전체 출력  5.검색  6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	// insert
	public void insertStudent() {
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("혈액형");
		String blood = sc.nextLine();
		System.out.println("폰번호");
		String phone = sc.nextLine();

		String sql = "insert into student (num, name, blood, phone, writeday) values (null, ?, ?, ?, now())";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql); // 이때 sql문 검사

			// ? 개수만큼 값을 넣어줌
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);

			// 실행
			pstmt.execute(); // 주의 : sql문 없음
			System.out.println("학생 정보를 추가하였습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deleteStudent() {
		System.out.println("삭제할 학생의 이름은?");
		String name = sc.nextLine();

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		String sql = "delete from student where name = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			// ? 개수만큼 바인딩 -> 항상 execute 하기 전에 위치해야 함
			pstmt.setString(1, name);

			// 삭제된 인원을 알고 싶을 경우 executeUpdate
			int n = pstmt.executeUpdate();
			if (n == 0)
				System.out.println("삭제할 학생이 존재하지 않습니다.");
			else
				System.out.println(n + "명 학생 정보 삭제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// update
	public void updateStudent() {
		System.out.println("수정할 학생 번호를 입력하세요");
		String num = sc.nextLine();
		System.out.println("수정할 이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("수정할 혈액형을 입력하세요");
		String blood = sc.nextLine();
		System.out.println("수정할 폰번호를 입력하세요");
		String phone = sc.nextLine();

		String sql = "update student set name = ? , blood = ?, phone = ? where num = ?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩 4개
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			pstmt.setString(4, num);

			// 실행
			int n = pstmt.executeUpdate();
			if(n == 0)
				System.out.println("해당 데이터가 없습니다.");
			else
				System.out.println("수정 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 전체 출력
	public void selectAllStudent() {
		System.out.println("번호\t학생명\t혈액형\t폰번호\t날짜");
		System.out.println("=".repeat(50));

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from student order by num";
		conn = db.getMysqlConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
//				String writeday = rs.getString("writeday"); // 날짜 타입도 String 타입으로 가져와도 된다
				Timestamp ts = rs.getTimestamp("writeday");

				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" +	sdf.format(ts));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}


	// 검색 : 번호 끝 4자리로 검색
	public void searchPhone() {
		System.out.println("검색할 폰번호 끝 4자리 입력");
		String phone = sc.nextLine();

		String sql = "select * from student where phone like ?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1,  "%" + phone);
			// 실행
			rs = pstmt.executeQuery();

			System.out.println(phone + " 검색 결과");

			int cnt = 0;
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone1 = rs.getString("phone");

				System.out.println(cnt++);
				System.out.println("번호 : " + num);
				System.out.println("이름 : " + name);
				System.out.println("혈액형 : " + blood);
				System.out.println("폰번호 : " + phone1);
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
		Ex9_StudentCrud ex = new Ex9_StudentCrud();

		while(true) {
			System.out.println("-".repeat(40));
			int menu = ex.getMenu();
			System.out.println("-".repeat(40));
			switch(menu) {
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;
			case 5:
				ex.searchPhone();
				break;
			default:
				System.out.println("** 프로그램 종료 **");
				System.exit(0);
			}
		}
	}

}
