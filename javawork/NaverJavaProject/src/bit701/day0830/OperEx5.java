package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 증감연산자 : ++(1씩 증가), --(1씩 감소)
		// 변수 앞에 붙일 경우(전치) 1순위
		// 변수 뒤에 붙일 경우(후치) 끝순위
		// 단항으로 사용할 경우 앞에 붙이든 뒤에 붙이든 순위가 상관 없음
		
		int a = 5;
		int b = 5;
		
		// 단항으로 연산할 경우
		++a; // 1증가
		System.out.println(a); // 6
		b++; // 1증가
		System.out.println(b); // 6

		System.out.println(++a); // 7, 먼저 증가 후 출력
		System.out.println(b++); // 6, 먼저 출력 후 증가
		System.out.println("a = " + a + ", b = " + b); // a = 7, b = 7
		
		a = b = 5;
		int m = ++a; // 증가 후 대입
		int n = b++; // 대입 후 증가
		System.out.printf("a = %d, b = %d, m = %d, n = %d\n", a, b, m, n); // a = 6, b = 6, m = 6, n = 5
		
	}

}
