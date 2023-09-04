package bit701.day0904;

public class Ex3_Random {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 자바에서 난수 발생시키는 방법 2가지
		 * 1. Math.random()
		 * 2. new Random()
		 */		
		
		for(int i = 0; i < 5; i++) {
			double r = Math.random(); // 0.0 <= r < 1.0
			System.out.println(r);
		}
		System.out.println("=".repeat(30));
		
		for(int i = 0; i < 5; i++) {
			int n = (int)(Math.random() * 10); // 0 ~ 9 사이의 난수 발생
//			int n = (int)(Math.random() * 10) + 1; // 1 ~ 10 사이의 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
		
		for(int i = 0; i < 5; i++) {
			int n = (int)(Math.random() * 26) + 65; // 65 ~ 90 사이의 난수 발생(대문자)
			System.out.println((char)n);
		}
		System.out.println("=".repeat(30));
		
		for(int i = 0; i < 5; i++) {
			int n = (int)(Math.random() * 26) + 97; // 97 ~ 122 사이의 난수 발생(소문자)
			System.out.println((char)n);
		}
		System.out.println("=".repeat(30));
	}

}
