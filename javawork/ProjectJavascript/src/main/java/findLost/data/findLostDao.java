package findLost.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;
import simpleboard.data.simpleBoardDTO;

public class findLostDao {
	DbConnect db = new DbConnect();
	
	// 검색 결과 출력
	public List<findLostDto> getSearchName(String name){
		List<findLostDto> list = new Vector<findLostDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from findLost where name like ? order by id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 바인딩
			pstmt.setString(1, "%" + name.trim() + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				findLostDto dto = new findLostDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setLostplace(rs.getString("lostplace"));
				dto.setLostday(rs.getString("lostday"));
				dto.setMoney(rs.getString("money"));
				dto.setReadcount(rs.getInt("readcount"));
	
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 전체 출력
	public List<findLostDto> getAllInfo(){
		List<findLostDto> list = new Vector<findLostDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from findLost order by id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				findLostDto dto = new findLostDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setLostplace(rs.getString("lostplace"));
				dto.setLostday(rs.getString("lostday"));
				dto.setMoney(rs.getString("money"));
				dto.setReadcount(rs.getInt("readcount"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// insert
	public void insertLost(findLostDto dto) {
		String sql = "insert into findLost (name, photo, lostplace, lostday, money) values (?, ?, ?, ?, ?)";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getLostplace());
			pstmt.setString(4, dto.getLostday());
			pstmt.setString(5, dto.getMoney());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// delete
	public void deleteLost(String id) {
		String sql = "delete from findLost where id = ?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 수정
	public void updateLost(findLostDto dto) {
		String sql = "";
		
		// 사진은 수정하지 않았을 경우 null 값을 가짐
		// null이 아닐 경우에만 photo를 수정
		if(dto.getPhoto()==null) {
			// 사진 수정 안함
			sql="update findLost set name=?, lostplace=?, lostday=? money=? where id=?";
		}
		else {
			// 사진을 수정하는 경우
			sql="update findLost set name=?, lostplace=?, lostday=?, money=?, photo='" + dto.getPhoto() + "' " + " where id=?";
		}
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getLostplace());
			pstmt.setString(3, dto.getLostday());
			pstmt.setString(4, dto.getMoney());
			pstmt.setInt(5, dto.getId());
			
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 내용 보기
	public findLostDto getData(int id) {
		findLostDto dto = new findLostDto();
		String sql = "select * from findLost where id=?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setLostplace(rs.getString("lostplace"));
				dto.setLostday(rs.getString("lostday"));
				dto.setMoney(rs.getString("money"));
				dto.setReadcount(rs.getInt("readcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	// 조회 수 증가
	public void updateReadcount(int id) {
		String sql = "update findLost set readcount = readcount + 1 where id=?";
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, id);
			
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
