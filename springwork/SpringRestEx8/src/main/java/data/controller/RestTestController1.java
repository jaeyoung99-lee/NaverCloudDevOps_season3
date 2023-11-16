package data.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import data.dto.MemoDto2;

/*
@Controller
public class RestTestController1 {
	@GetMapping("/test/list1")
	@ResponseBody
	public List<MemoDto2> list1(){
		List<MemoDto2> list = new ArrayList<MemoDto2>();
		list.add(new MemoDto2(1, "캔디", "1.jpg", "안녕", 5, "2023-10-10"));
		list.add(new MemoDto2(2, "안소니", "2.jpg", "헬로", 2, "2022-10-10"));
		list.add(new MemoDto2(3, "테리우스", "3.jpg", "굿모닝", 6, "2021-10-10"));
		return list;
	}
	
	@GetMapping("/test/add")
	@ResponseBody // json 형태로 받기 위해 필요
	public MemoDto2 add(String nickname, String photo, String memo) {
		MemoDto2 dto = new MemoDto2(1, nickname, photo, memo, 10, "2022-12-25");
		return dto;
	}
}
*/

@RestController
public class RestTestController1 {
	@GetMapping("/test/list1")
	public List<MemoDto2> list1(){
		List<MemoDto2> list = new ArrayList<MemoDto2>();
		list.add(new MemoDto2(1, "캔디", "1.jpg", "안녕", 5, "2023-10-10"));
		list.add(new MemoDto2(2, "안소니", "2.jpg", "hello", 2, "2022-10-10"));
		list.add(new MemoDto2(3, "테리우스", "3.jpg", "굿모닝", 6, "2021-10-10"));
		return list;
	}
	
	@GetMapping("/test/add")
	public MemoDto2 add(String nickname, String photo, String memo) {
		MemoDto2 dto = new MemoDto2(1, nickname, photo, memo, 10, "2022-12-25");
		return dto;
	}
	
	@PostMapping("/test/list2")
	public Map<String, String> test(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("age", "35");
		return map;
	}
}
