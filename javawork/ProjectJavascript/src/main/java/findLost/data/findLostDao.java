package findLost.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class findLostDao {
	DbConnect db = new DbConnect();
	
	// 검색 결과 출력
	public List<findLostDto> getSearchName(String name){
		List<findLostDto> list = new Vector<findLostDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from findLost where name like ? order by num";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 바인딩
			pstmt.setString(1, "%" + name.trim() + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				findLostDto dto = new findLostDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setLostplace(rs.getString("lostplace"));
				dto.setLostday(rs.getString("lostday"));
				dto.setMoney(rs.getString("money"));
	
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
		String sql = "select * from findLost order by num";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				findLostDto dto = new findLostDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setLostplace(rs.getString("lostplace"));
				dto.setLostday(rs.getString("lostday"));
				dto.setMoney(rs.getString("money"));
				
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
	public void deleteLost(String num) {
		String sql = "delete from findLost where num = ?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}
