package myshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import myshop.data.MyShopDto;

@Mapper
public interface MyShopMapper {
	
	// 방법 1 : sql을 직접 정의
	/*
	@Select("select count(*) from myshop")
	public int getTotalCount();
	*/
	
	// 방법 2 : sql을 xml에서 정의
	public int getTotalCount();
	
	// 직접 insert 쿼리문 설정하기
	@Insert("""
			insert into myshop (sangpum, color, photo, price, writeday)
			values (#{sangpum}, #{color}, #{photo}, #{price}, now())
			""")
	public void insertShop(MyShopDto dto);
	
	// 전체 목록 출력(직접 sql문으로 설정하기)
	@Select("select * from myshop order by num desc")
	public List<MyShopDto> getSangpumList();
	
	// xml로 설정
	public MyShopDto getData(int num);
	
	// delete는 직접 sql문으로 설정해서 삭제
	@Delete("delete from myshop where num = #{num}")
	public void deleteShop(int num);
}
