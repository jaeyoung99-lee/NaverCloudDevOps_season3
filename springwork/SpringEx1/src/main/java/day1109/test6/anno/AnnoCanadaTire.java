package day1109.test6.anno;

import org.springframework.stereotype.Component;

@Component // xml에 자동으로 bean을 등록 -> id가 클래스명이 됨(첫글자는 소문자로 등록이 됨 : annoCanadaTire)
public class AnnoCanadaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "어노테이션 캐나다 타이어";
	}

}
