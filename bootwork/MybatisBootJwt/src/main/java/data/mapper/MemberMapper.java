package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import data.dto.MemberDto;

@Mapper
public interface MemberMapper {
	@Select("select count(*) from memberdb")
	public int getTotalCount();
	
	@Select("select * from memberdb order by num desc")
	public List<MemberDto> getAllMembers();
	
	// @Insert로 쿼리문을 여기서 직접 써도 되지만 xml에서 해보자
	public void insertMember(MemberDto dto);
}
