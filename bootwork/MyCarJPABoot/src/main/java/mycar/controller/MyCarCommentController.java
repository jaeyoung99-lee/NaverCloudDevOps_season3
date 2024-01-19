package mycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;

@RestController // �̰� �Ⱦ��� ajax ���� �� responsebody�� �޾ƾ� �ϴµ� �װ� �����ϱ� ���ؼ� ��
@RequiredArgsConstructor  //final �Ǵ� @NonNull ��� ������ �����ڷ� ���� �ڵ� ����
public class MyCarCommentController {
	private final MyCarCommentDao commentDao;
	
	@GetMapping("/addcomment")
	public void addComment(@RequestParam("num") Long num,@RequestParam("comment") String comment)
	{
		// ���� MyCarDto�� num ���� ���� �� MyCarCommentDto�� �߰��Ѵ�(�ܺ�Ű�� ������ ��)
		MyCarDto dto=MyCarDto.builder().num(num).build();
		
		//dto�� ���� �����Ѵ�
		MyCarCommentDto commentDto=MyCarCommentDto.builder()
				.comment(comment)
				.mycar(dto)
				.build();
		//db insert
		commentDao.insertComment(commentDto);
	}
	
	// Ư�� �ۿ� �޸� ��� ��ȯ
	@GetMapping("/commentlist")
	public List<MyCarCommentDto> commnetList(@RequestParam("num") Long num)
	{
		return commentDao.getMyCarCommentList(num);
	}
}





















