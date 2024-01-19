package mycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;

@RestController // 이거 안쓰면 ajax 받을 때 responsebody로 받아야 하는데 그걸 생략하기 위해서 씀
@RequiredArgsConstructor  //final 또는 @NonNull 멤버 변수만 생성자로 만들어서 자동 주입
public class MyCarCommentController {
	private final MyCarCommentDao commentDao;
	
	@GetMapping("/addcomment")
	public void addComment(@RequestParam("num") Long num,@RequestParam("comment") String comment)
	{
		// 먼저 MyCarDto에 num 값을 넣은 후 MyCarCommentDto에 추가한다(외부키로 지정된 값)
		MyCarDto dto=MyCarDto.builder().num(num).build();
		
		//dto에 값을 저장한다
		MyCarCommentDto commentDto=MyCarCommentDto.builder()
				.comment(comment)
				.mycar(dto)
				.build();
		//db insert
		commentDao.insertComment(commentDto);
	}
	
	// 특정 글에 달린 댓글 반환
	@GetMapping("/commentlist")
	public List<MyCarCommentDto> commnetList(@RequestParam("num") Long num)
	{
		return commentDao.getMyCarCommentList(num);
	}
}





















