package student_강사.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class StudentDao {
	DbConnect db=new DbConnect();
	//검색 결과 출력
	public List<StudentDto> getSearchStudent(String search)
	{
		List<StudentDto> list=new Vector<StudentDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from student where name like ? order by num desc";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+search.trim()+"%");
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				StudentDto dto=new StudentDto();//반드시 while문 안에 선언
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setBlood(rs.getString("blood"));
				dto.setPhone(rs.getString("phone"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	//insert
	public void insertStudent(StudentDto dto)
	{
		String sql="insert into student (name,blood,phone,writeday) values (?,?,?,now())";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setString(3, dto.getPhone());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//delete
	public void deleteStudent(String num)
	{
		String sql="delete from student where num=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}