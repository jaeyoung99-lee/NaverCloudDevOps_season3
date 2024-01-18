package mycar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;

@Repository
@AllArgsConstructor
public class MyCarCommentDao {
	
	private MyCarCommentDaoInter commentDaoInter;
	
	//댓글 저장
	public void insertComment(MyCarCommentDto dto)
	{
		commentDaoInter.save(dto);
	}
	
	//댓글 목록
	public List<MyCarCommentDto> getMyCarCommentList(Long num)
	{
		return commentDaoInter.getMyCarCommentList(num);
	}

}







