package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.AnswerDao;
import board.data.BoardDao;
import board.data.BoardDto;

@Controller
// @AllArgsConstructor // @Autowired 대신 써도 됨 
public class BoardListController {
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@GetMapping("/simple/list")
	public String list(Model model) {
		// 전체 개수 가져오기
		int totalCount = boardDao.getTotalCount();
		
		// 전체 데이터 가져오기
		List<BoardDto> list = boardDao.getAllDatas();
		
		// list의 acount에 각 글에 대한 댓글 개수 저장하기
		for(BoardDto dto : list) {
			dto.setAcount(answerDao.getAnswers(dto.getNum()).size());
		}
		
		// model에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "list";
	}
}
