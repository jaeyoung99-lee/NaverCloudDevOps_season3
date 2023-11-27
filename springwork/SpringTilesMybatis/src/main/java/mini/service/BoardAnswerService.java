package mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardAnswerDao;
import mini.dto.BoardAnswerDto;

@Service
@AllArgsConstructor
public class BoardAnswerService {
	private BoardAnswerDao answerDao;
	
	public void insertAnswer(BoardAnswerDto dto) {
		answerDao.insertAnswer(dto);
	}
	
	public List<BoardAnswerDto> getAnswerBoard(int num) {
		return answerDao.getAnswerBoard(num);
	}
	
	public void deleteAnswer(int ansidx) {
		answerDao.deleteAnswer(ansidx);
	}
}
