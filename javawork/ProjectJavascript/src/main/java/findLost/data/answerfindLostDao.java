package findLost.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class answerfindLostDao {
	DbConnect db = new DbConnect();
	
	public void insertAnswer(answerfindLostDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into answerfindLost values (null, ?, ?, ?, now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, dto.getFindLostId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteAnswer(int id) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from answerfindLost where id = ?";
		
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
	
	public List<answerfindLostDto> getFindLostAnswers(int findLostId){
		List<answerfindLostDto> list = new Vector<answerfindLostDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from answerfindLost where findLostId=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, findLostId);
			// 실행
			rs = pstmt.executeQuery();
			while(rs.next()){
				answerfindLostDto dto = new answerfindLostDto();
				dto.setId(rs.getInt("id"));
				dto.setFindLostId(rs.getInt("findLostId"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				// list에 추가
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
}
