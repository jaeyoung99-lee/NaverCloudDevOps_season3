package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("내 이름은 " + args[0] + "입니다.");
		System.out.println("우리집은 " + args[1] + "입니다.");
		System.out.println("내 혈액형은 " + args[2] + "형입니다.");
		System.out.println();
		System.out.println("실수형 데이터 타입");
		float f1 = 1234.567891234f; // 4바이트 float으로 값을 지정하려면 마지막에 f 추가해야 함
		double f2 = 1234.567891234;
		System.out.println("float형으로 출력 : " + f1); // float은 유효숫자 8자리만 나오고 나머지 부분은 반올림
		System.out.println("double형으로 출력 : " + f2); // double은 15자리까지 정확하게 출력
		System.out.println();
		// char 타입은 2바이트라 한글 한글자도 저장 가능
		char ch1 = 'A';
		char ch2 = '가';
		System.out.println(ch1);
		System.out.println(ch2);
	}

}
