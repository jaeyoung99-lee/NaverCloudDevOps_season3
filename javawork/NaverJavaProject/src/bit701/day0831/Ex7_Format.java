package bit701.day0831;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex7_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 패턴을 이용해서 다양하게 날짜, 시간을 출력해보자
		Date date = new Date();
		
		// 패턴 1
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE"); // MM : 월, mm : 분, EEE : 요일 짧게, HH : 24시간 기준
		System.out.println(dateFormat1.format(date));

		// 패턴 2
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEEE"); // a : 오전, 오후, EEEE : 요일 길게, hh : 12시간 기준
		System.out.println(dateFormat2.format(date));
		
		// 숫자를 포맷 양식에 맞게 출력하기
		int money = 4567890;
		
		NumberFormat numberFormat1 = NumberFormat.getInstance(); // 단순 컴마(,)만 추가해서 출력
		System.out.println(numberFormat1.format(money)); // 4,567,890
		
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(); // 지역 설정된 화폐 단위 붙여서 출력
		System.out.println(numberFormat2.format(money));
		
		double num = 456.12345;
		System.out.println(numberFormat1.format(num)); // 456.123
		
		numberFormat1.setMaximumFractionDigits(1); // 소수점 한자리로 출력
		System.out.println(numberFormat1.format(num)); // 456.1
	}

}
