package bit701.day0831;

import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// 년도와 월을 입력하면 몇 일까지 있는지 출력
		// 일단 해당 년도가 윤년인지 아닌지부터 판단
		
		System.out.println("년도 4자리 숫자 입력");
		int year = sc.nextInt();
		
		System.out.println("월(1 ~ 12) 입력");
		int month = sc.nextInt();
		
		// 잘못 월을 입력한 경우 종료
		if (month < 1 || month >  12) {
			System.out.println("월을 잘못 입력했어요!!");
			return;
		}
		
		System.out.printf("입력한 년도와 월 : %d년 %d월\n", year, month);
		
		int days = 0;
		boolean b = year % 4 == 0 && year % 100 != 0 || year % 400 == 0; // 윤년 구하는 공식
		
		
		if(b) // if(b == true)라고 해도 되지만 true는 굳이 안쓰는 것이 관행, false일 경우 앞에 ! 붙임
			System.out.println("윤년");
		else
			System.out.println("평년");
		System.out.println();
		
		switch(month) {
			case 2 :
				days = b ? 29 : 28; // b가 true면 윤년이므로 29일, 아닐 경우 평년이므로 28을 days에 저장
				break;
			case 4, 6, 9, 11 :
				days = 30;
				break;
			default :
				days = 31;
		}
		
		System.out.printf("%d년 %d월은 %d일까지 있어요!\n", year, month, days);
	}

}
