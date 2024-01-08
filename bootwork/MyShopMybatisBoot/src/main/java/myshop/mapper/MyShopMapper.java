package myshop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyShopMapper {
	@Select("select count(*) from myshop")
	public int getTotalCount();
}
