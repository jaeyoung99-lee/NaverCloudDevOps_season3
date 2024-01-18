package mycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;

@RestController
@RequiredArgsConstructor // final 멤버 변수 또는 @Nonnull이 붙은 멤버 변수만 자동 주입
public class MyCarCommentController {
	private final MyCarCommentDao commentDao;
	
	@GetMapping("/addcomment")
	public void addComment(@RequestParam("num") Long num, @RequestParam("comment") String comment) {
		
		// 먼저 MyCarDto에 num 값을 넣은 후 MyCarCommentDto에 넣는다.
		MyCarDto dto = MyCarDto.builder()
				.num(num)
				.build();
		
		// dto에 값을 저장
		MyCarCommentDto commentDto = MyCarCommentDto.builder()
				.comment(comment)
				.mycar(dto)
				.build();
		
		// db insert
		commentDao.insertComment(commentDto);
	}
	
	@GetMapping("/commentlist")
	public List<MyCarCommentDto> commentList(@RequestParam("num") Long num){
		return commentDao.getMyCarCommentList(num);
	}
}
