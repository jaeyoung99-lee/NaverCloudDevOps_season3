package mycar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;

@Repository
@AllArgsConstructor
public class MyCarCommentDao {
	
	private MyCarCommentDaoInter commentDaoInter;
	
	// ��� ����
	public void insertComment(MyCarCommentDto dto)
	{
		commentDaoInter.save(dto);
	}
	
	// ��� ���
	public List<MyCarCommentDto> getMyCarCommentList(Long num)
	{
		return commentDaoInter.getMyCarCommentList(num);
	}

}







