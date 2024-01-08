package myshop.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myshop.mapper.MyShopMapper;

@Service
@AllArgsConstructor
public class MyShopService {
	private MyShopMapper shopMapper;
	
	public int getTotalCount() {
		return shopMapper.getTotalCount();
	}
}
