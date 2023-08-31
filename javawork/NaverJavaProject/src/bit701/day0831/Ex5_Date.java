package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//자바에서 시간이나 날짜 출력하는 방법
		
		System.out.println("Date 클래스를 이용해서 시간, 날짜 구하기");
		
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();
		
		int hh = date.getHours();
		int mm = date.getMinutes();
		int ss = date.getSeconds();
		
		System.out.printf("현재 년도 : %d-%2d-%2d\n", year, month, day);
		System.out.printf("현재 년도 : %d-%02d-%02d\n", year, month, day);
		System.out.printf("현재 시간 : %02d:%02d:%02d\n",hh, mm, ss);
		
		System.out.println();
		System.out.println("Calendar 클래스를 이용해서 시간, 날짜 구하기");
	
		// Calendar cal = new Calendar(); // 오류 발생, 생성자가 public이 아니고 protected라서 생성 안됨
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1; // year는 안 더해도 되는데 month는 더해야 함(0 ~ 11의 값을 반환)
		day = cal.get(Calendar.DATE);
		
		hh = cal.get(Calendar.HOUR_OF_DAY); // HOUR로 하면 02시로 나옴, HOUR_OF_DAY가 24시간 기준
		mm = cal.get(Calendar.MINUTE);
		ss = cal.get(Calendar.SECOND);
		
		System.out.printf("현재 년도 : %d-%02d-%02d\n", year, month, day);
		System.out.printf("현재 시간 : %02d:%02d:%02d\n",hh, mm, ss);
		
		// 요일 구하기
		System.out.println();
		System.out.println("요일 구하기");
		int weekint = date.getDay(); // 0 : 일, 1 : 월, ... , 6 : 토
		System.out.println("요일숫자 : " + weekint);
		
		String week = weekint == 0 ? "일" : weekint == 1 ? "월" : weekint == 2 ? "화" : weekint == 3 ? "수" : weekint == 4 ? "목" : weekint == 5 ? "금" : "토";
		System.out.println("오늘은 " + week + "요일입니다");
	}

}
