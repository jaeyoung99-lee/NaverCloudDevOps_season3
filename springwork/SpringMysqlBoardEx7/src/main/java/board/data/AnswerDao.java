package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="board.data.AnswerDao.";
	
	public void insertAnswer(AnswerDto dto) {
		session.insert(nameSpace + "insertAnswer", dto);
	}
	
	public List<AnswerDto> getAnswers(int num) {
		return session.selectList(nameSpace + "selectAnswerByNum", num);
	}
}
