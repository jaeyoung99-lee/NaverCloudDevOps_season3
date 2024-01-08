package data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.ShopDto;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "start"; // templates 패키지의 start.html로 포워드
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		ShopDto dto = ShopDto.builder()
				.sangpum("체크남방")
				.color("orange")
				.su(5)
				.dan(23000)
				.build();
		
		model.addAttribute("dto", dto);
		
		return "hello"; // templates 패키지의 hello.html로 포워드
	}
}