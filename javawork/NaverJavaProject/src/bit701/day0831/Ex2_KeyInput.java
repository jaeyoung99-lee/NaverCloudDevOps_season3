package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex2_KeyInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Date 클래스를 이용해서 현재 년도를 구해보자(jdk1.1에서 deprecate(반대)되었지만 여전히 많이 사용함)
		// 권장 : Calendar를 권장
		Date date = new Date();
		
		// getYear는 1900을 뺀 값을 반환하므로 1900을 더해야함
		int curYear = date.getYear() + 1900;
		System.out.println("현재 년도 : " + curYear);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 태어난 년도는?");
		
		//문자열로 읽은 후 숫자로 변환하면 다음에 문자열이 입력될 경우에도 문제가 발생하지 않는다
		int birthYear = Integer.parseInt(sc.nextLine());
		
		System.out.println("지금 사는 곳은 어디입니까?");
		String address = sc.nextLine();
		
		// 나이 구하기
		int age = curYear - birthYear;
		
		System.out.println("저는 " + address + "에 사는 " + birthYear + "년생(만" + age + "세) 학생입니다");
		System.out.printf("저는 %s에 사는 %d년생(만%d세) 학생입니다", address, birthYear, age);
		
		System.out.println();
		
		// 20세 이상이면 "성인", 미만이면 "미성년자"라는 글자를 출력
		// if문으로 해도 되고 조건(삼항)연산자(조건식?참일 때 값:거짓일 때 값)로 해도된다
		
		// 삼항 연산자로 할 경우
		// String msg = age >= 20 ? "성인" : "미성년자";
		
		// if문으로 할 경우
		// 지역 변수는 자동 초기화가 안되고 쓰레기 값이 들어있으므로 값이 안들어갈 경우를 대비해서 초기값을 지정하는 것이 좋음
		// 지역 변수는 그 구역을 빠져나가게 되면 자동 소멸되므로 사용이 불가능
		String msg = "";
		if(age >= 20) { // 한 문장만 쓸 경우 {} 구역 설정 생략 가능하지만 두 문장 이상일 경우는 반드시 구역 설정({})
			msg = "성인";
		}
		else {
			msg = "미성년자";
		}
		System.out.println("당신은 " + msg);
	}

}
