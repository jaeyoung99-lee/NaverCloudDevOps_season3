package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		System.out.println("Happy!");
		System.out.print("apple"); // ln 없으면 줄바꿈이 적용이 안되서 옆으로 바로 써지게 됨
		System.out.print("banana");
		System.out.println("orange");
		
		// printf
		// 변환기호에 의한 출력 방법
		// 정수 : %d, 실수 : %f, 문자 : %c, 문자열 : %s
		// jdk5.0부터 자바에 새롭게 추가됨
		
		// \n : 줄바꿈, \t : 다음 탭 위치로 이동
		
		int age = 23;
		double weight = 56.712;
		char blood = 'A';
		String name = "캐서린";
		System.out.printf("이름 : %s\n", name);
		System.out.printf("나이 : %d세\n", age);
		System.out.printf("몸무게 : %fKg\n", weight);
		// %a.bf : 전체자릿수 : a자리, 소수점자리수 : b자리 (남는 자리는 왼쪽 앞에 공백으로 출력됨)
		// 예시) %5.1f : 전체자릿수 : 5자리, 소수점자리수 : 1자리
		System.out.printf("몸무게 : %5.1fKg\n", weight);
		System.out.printf("혈액형 : %c형\n", blood);
		System.out.println("========================================");
		System.out.printf("이름 : %s\n혈액형 : %c형\n나이 : %d세\n", name, blood, age);
	}

}
