package bit701.day0901;

public class Ex4_BreakContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int a = 1; a <= 10; a++) {
			if(a == 5)
				break; // 5 출력 전 반복문을 빠져나간다
			System.out.printf("%3d", a);
		}
		System.out.println();
		System.out.println("-".repeat(30));

		for(int a = 1; a <= 10; a++) {
			if(a % 2 == 0) // 짝수일경우 출력하지 않고 다음 숫자로 가고자 할 경우
				continue; // a++ 증감식으로 이동
			System.out.printf("%3d", a);
		}
		System.out.println();
		System.out.println("-".repeat(30));

		// 다중 for문일경우 한꺼번에 2개의 반복문을 빠져나가고자 할 경우
		Exit: // 레이블명은 자기 마음대로 지정한다
			for(int i =1; i <= 3; i++) {
				System.out.println("i = " + i);
				for(int j = 1; j<= 5; j++) {
					System.out.printf("%3d", j);
					if(j == 3)
						break Exit; // j가 3이 되면 2개의 반복문을 모두 빠져나간다
				}
			}
		System.out.println();
	}

}
