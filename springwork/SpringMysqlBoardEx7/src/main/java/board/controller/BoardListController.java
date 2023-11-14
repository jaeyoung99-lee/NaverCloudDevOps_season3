package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.BoardDao;

@Controller
// @AllArgsConstructor // @Autowired 대신 써도 됨 
public class BoardListController {
	@Autowired
	private BoardDao boardDao;
	
	@GetMapping("/simple/list")
	public String list(Model model) {
		// 전체 개수 가져오기
		int totalCount = boardDao.getTotalCount();
		
		// model에 저장
		model.addAttribute("totalCount", totalCount);
		
		return "list";
	}
}
