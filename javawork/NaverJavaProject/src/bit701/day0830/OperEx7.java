package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 비교 연산자와 논리 연산자 : 결과값은 무조건 참(true) 또는 거짓(false)
		int kor = 100, eng = 90, math = 100;
		
		System.out.println(kor >= 80); // true
		System.out.println(kor >= 80 || kor != math); // true
		System.out.println(kor < 80 || kor != math); // false
		System.out.println(kor >= 80 && kor != math); // false
		System.out.println(kor < 80 && kor != math); // false
		System.out.println(!(kor == math)); // false
		System.out.println(kor >= 95 && eng >= 95 && math >= 95); // false
		System.out.println(kor >= 95 && eng >= 95 || math >= 95); // true
		System.out.println(kor >= 95 || eng >= 95 && math >= 95); // true
		
		int year = 2024;
		// 위의 연도가 윤년인지 확인하기
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
	}

}
