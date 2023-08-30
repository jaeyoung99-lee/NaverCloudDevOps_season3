package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// money 변수에 args[0] 값을 대입한 후(급여 : 백만단위 : 5674321)
		/*
		 * 출력
		 * money : 5674321 원
		 * 만원짜리 567 장
		 * 천원짜리 4 장
		 * 백원짜리 3 개
		 * 십원짜리 2 개
		 * 일원짜리 1 개
		 * 
		 * : 산술연산자를 사용해서 출력
		 * 
		 */
		
		int money = Integer.parseInt(args[0]);
		
		System.out.printf("money : %d 원\n", money);
		System.out.printf("만원짜리 %d 장\n", money / 10000 );
		money %= 10000;
		System.out.printf("천원짜리 %d 장\n", money / 1000 );
		money %= 1000;
		System.out.printf("백원짜리 %d 개\n", money /100 );
		money %= 100;
		System.out.printf("십원짜리 %d 개\n", money / 10 );
		money %= 10;
		System.out.printf("일원짜리 %d 개\n", money / 1);
	}

}
