package day1109.test6.anno;

import org.springframework.stereotype.Component;

@Component
public class AnnoKoreaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "어노테이션 코리아 타이어";
	}

}
