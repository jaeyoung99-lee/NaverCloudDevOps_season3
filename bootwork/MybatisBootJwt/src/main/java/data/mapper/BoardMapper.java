package data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import data.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int getTotalCount(String search);
	public List<BoardDto> getAllDatas(HashMap<String, Object> map);
	public void insertBoard(BoardDto dto);
	
	@Select("select * from simpleboard where num = #{num}")
	public BoardDto getSelectPage(int num);
	
	@Update("update simpleboard set readcount = readcount + 1 where num = #{num}")
	public void updateReadcount(int num);
}
