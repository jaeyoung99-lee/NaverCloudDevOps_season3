package bit701.day0901;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex5_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1번 문제 : 숫자 n을 입력 받은 후 1부터 n까지의 총 합계를 출력 - 단일 for문 
		 * 
		 * 2번 문제 :  구구단 숫자 2 ~ 9 사이의 숫자를 입력 받은 후 범위를 벗어날 경우
		 *             "잘못 입력하여 종료합니다"라고 종료 
		 *             제대로 입력 시 해당 구구단 출력
		 * 			   예시 ** 5단 **
		 * 		            5 x 1 =  5
		 * 		            5 x 2 = 10
		 * 			            .
		 * 			            .
		 * 		            5 x 9 = 45 
		 */

		
		// 1번 문제
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력");
		int n = sc.nextInt();
		int sum = 0;

		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("총 합계 : " + sum);

		System.out.println();

		// 2번 문제
		System.out.println("구구단 숫자 입력");
		int num = sc.nextInt();

		if (num < 2 || num > 9) {
			System.out.println("잘못 입력하여 종료합니다");
			return;
		}

		System.out.println("** " + num + "단 **");
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %2d\n", num, i, (num * i));
		}
		
		
		
		// 강사님 코드
		
		/*
		// 1번 문제
		
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int sum = 0;
		System.out.println("합계를 구할 숫자 입력");
		n = sc.nextInt();
		
		// 1부터 n까지의 총합 구하기
		for(int a =1; a <= n; a++)
			sum += a;
		
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다");
		
		
		// 2번 문제
		
		int dan;
		System.out.println("출력할 구구단은?");
		dan = sc.nextInt();
		
		if(dan < 2 || dan > 9) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		System.out.println("\t** " + dan + "단 **\n");
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%8d x %d = %2d\n", dan, i, dan * i);
		}
		*/
	}

}
