package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/board/list")
	public String login() {
		return "board/boardlist";
	}
}
