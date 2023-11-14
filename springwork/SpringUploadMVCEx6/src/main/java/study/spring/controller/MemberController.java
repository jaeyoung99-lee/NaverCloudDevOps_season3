package study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@GetMapping("/")
	public String home() {
		return "member/start";
	}
	
	@GetMapping("/member/form1")
	public String form1() {
		return "member/uploadform1";
	}
	
	@GetMapping("/member/form2")
	public String form2() {
		return "member/uploadform2";
	}
	
	@GetMapping("/member/form3")
	public String form3() {
		return "member/uploadform3";
	}
	
}
