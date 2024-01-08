package myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import myshop.service.MyShopService;

@Controller
@RequiredArgsConstructor // final인 변수나 @notnull인 것만 주입시킨다
public class MyShopController {
	private final MyShopService shopService;
	
	@GetMapping("/")
	public String list(Model model) {
		// 총 개수를 얻어온다
		int totalCount = shopService.getTotalCount();
		
		// model에 저장한다
		model.addAttribute("totalCount", totalCount);
		
		return "myshop/shoplist";
	}
}
