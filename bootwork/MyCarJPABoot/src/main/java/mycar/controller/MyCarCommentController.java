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
@RequiredArgsConstructor  //final 또는 @NonNull 멤버변수만 자동주입
public class MyCarCommentController {
	private final MyCarCommentDao commentDao;
	
	@GetMapping("/addcomment")
	public void addComment(@RequestParam("num") Long num,@RequestParam("comment") String comment)
	{
		//먼저 MyCarDto 에 num 값을 넣은후 MyCarCommentDto 에 넣는다(외부키로 지정된값)
		MyCarDto dto=MyCarDto.builder().num(num).build();
		
		//dto 에 값을 저장한다
		MyCarCommentDto commentDto=MyCarCommentDto.builder()
				.comment(comment)
				.mycar(dto)
				.build();
		//db insert
		commentDao.insertComment(commentDto);
	}
	
	//특정글에 달린 댓글 반환
	@GetMapping("/commentlist")
	public List<MyCarCommentDto> commnetList(@RequestParam("num") Long num)
	{
		return commentDao.getMyCarCommentList(num);
	}
}





















