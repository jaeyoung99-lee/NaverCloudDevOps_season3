package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean을 자동 등록해주는 어노테이션 -> dao에 붙임
public class BoardDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="board.data.BoardDao.";
	
	// 전체 개수 반환하는 메서드
	public int getTotalCount() {
		
		return session.selectOne(nameSpace + "totalCountOfBoard");
	}
	
	public void insertBoard(BoardDto dto) {
		session.insert(nameSpace + "insertBoard", dto);
	}
	
	public List<BoardDto> getAllDatas(){
		return session.selectList(nameSpace + "selectAllBoard");
	}
	
	public void updateReadCount(int num) {
		session.update(nameSpace + "updateReadCount", num);
	}
	
	public BoardDto getData(int num) {
		return session.selectOne(nameSpace + "selectOneData", num);
	}
	
	public void deleteBoard(int num) {
		session.delete(nameSpace + "deleteBoard", num);
	}
	
	public void updateBoard(BoardDto dto) {
		session.update(nameSpace + "updateBoard", dto);
	}
}
