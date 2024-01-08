package data.controller;

import java.util.List;
import java.util.Vector;

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
	
	@GetMapping("/list")
	public String list(Model model) {
		List<ShopDto> list = new Vector<>();
		list.add(new ShopDto("블라우스", "pink", 3, 50000));
		list.add(new ShopDto("청바지", "blue", 2, 43000));
		list.add(new ShopDto("자켓", "gray", 1, 150000));
		list.add(new ShopDto("주름 스커트", "orange", 5, 34000));
		list.add(new ShopDto("스카프", "red", 3, 230000));
		
		model.addAttribute("list", list);
		
		return "list";
	}
}