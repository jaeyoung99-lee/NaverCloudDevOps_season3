// 교재 Chapter4 문제 7번 p.139
package bit701.day0905;

import java.util.Scanner;

public class Chapter4_Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int money = 0, total = 0, num;
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			num = scanner.nextInt();

			switch(num) {
			case 1:
				System.out.print("예금액> ");
				int in = scanner.nextInt();
				money += in;
				break;
			case 2:
				System.out.print("출금액> ");
				int out = scanner.nextInt();
				money -= out;
				break;
			case 3:
				System.out.print("잔고> ");
				System.out.println(money);
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("숫자를 1 ~ 4 중에서 다시 입력하세요!");
				continue;
			}
			if (num == 4)
				break;
		}
	}
}
