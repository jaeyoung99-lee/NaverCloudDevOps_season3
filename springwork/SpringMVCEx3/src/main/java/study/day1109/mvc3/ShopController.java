package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/shop/{path}")
	// public String list(@PathVariable("path") String path) : path와 변수명이 같을 경우 생략
	public String list(@PathVariable String path, Model model) {
		System.out.println(path);
		String shopinfo="";
		if(path.equals("list1"))
			shopinfo="원피스 상품 목록";
		else if(path.equals("list2"))
			shopinfo="슈즈 상품 목록";
		else
			shopinfo="악세서리 상품 목록";
		
		// 상품 목록 담기
		List<ShopDto> list = new ArrayList<ShopDto>();
		if(path.equals("list1")) {
			list.add(new ShopDto("화이트원피스", "2.jpg", 99000));
			list.add(new ShopDto("스포티원피스", "25.jpg", 45000));
			list.add(new ShopDto("레이스원피스", "28.jpg", 68000));
			list.add(new ShopDto("청원피스", "33.jpg", 23000));
		}
		else if(path.equals("list2")) {
			list.add(new ShopDto("샤넬슈즈", "12.jpg", 1500000));
			list.add(new ShopDto("구찌슈즈", "14.jpg", 980000));
			list.add(new ShopDto("플렛슈즈", "15.jpg", 33000));
		}
		else {
			list.add(new ShopDto("리본핀", "19.jpg", 11000));
			list.add(new ShopDto("머리띠", "30.jpg", 23000));
			list.add(new ShopDto("진주반지", "21.jpg", 55000));
			list.add(new ShopDto("머리끈", "26.jpg", 9000));
		}
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("shopinfo", shopinfo);
		
		return "list1";
	}
	
	@GetMapping("/food/morning/brunch")
	// public String list(@PathVariable("path") String path) : path와 변수명이 같을 경우 생략
	public String list(Model model) {
		String shopinfo="브런치 목록";
		// 상품 목록 담기
		List<ShopDto> list = new ArrayList<ShopDto>();

		list.add(new ShopDto("와플", "K-035.png", 23000));
		list.add(new ShopDto("핫케이크", "K-036.png", 55000));
		list.add(new ShopDto("파스타", "K-045.png", 11000));
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("shopinfo", shopinfo);
		model.addAttribute("message", "오늘의 브런치 메뉴들");
		model.addAttribute("today", new Date());
		
		return "list2";
	}
	
	@GetMapping("/food/photo/detail")
	// public String list(@PathVariable("path") String path) : path와 변수명이 같을 경우 생략
	public String list1(Model model) {
		String shopinfo="음식 목록";
		// 상품 목록 담기
		List<FoodDto> list = new ArrayList<FoodDto>();

		list.add(new FoodDto("스팸계란밥", "10.jpg", "강남"));
		list.add(new FoodDto("한라봉 스무디", "11.jpg", "제주"));
		list.add(new FoodDto("순두부 라면", "12.jpg", "부산"));
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("shopinfo", shopinfo);
		model.addAttribute("today", new Date());
		
		return "list3";
	}
}
