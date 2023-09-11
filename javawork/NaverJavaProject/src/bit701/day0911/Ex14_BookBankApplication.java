// 교재 p.281 20번 문제

package bit701.day0911;

import java.util.Scanner;

public class Ex14_BookBankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account[] account = new Account[10];
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String accountNo = "";
		String accountName = "";
		int money = 0;
		Exit:
		while(true) {
			System.out.println("-".repeat(50));
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-".repeat(50));
			System.out.print("선택> ");
			n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 1:
				System.out.println("-".repeat(8));
				System.out.println("계좌생성");
				System.out.println("-".repeat(8));
				for(int i = 0; i < 1; i++) {
					if(account[i] == null) {
						System.out.print("계좌번호: ");
						accountNo = sc.nextLine();
						System.out.print("계좌주: ");
						accountName = sc.nextLine();
						System.out.print("초기입금액: ");
						money = Integer.parseInt(sc.nextLine());
						account[i] = new Account(accountNo, accountName, money);
					}
					else {
						System.out.print("계좌번호: ");
						accountNo = sc.nextLine();
						System.out.print("계좌주: ");
						accountName = sc.nextLine();
						System.out.print("초기입금액: ");
						money = Integer.parseInt(sc.nextLine());
						account[i+1] = new Account(accountNo, accountName, money);
					}
				}
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			case 2:
				System.out.println("-".repeat(8));
				System.out.println("계좌목록");
				System.out.println("-".repeat(8));
				for(int i = 0; i < account.length; i++) {
					if(account[i] != null) {
						System.out.println(account[i].getAccountNo() + "\t" + account[i].getAccountName() + "\t" + account[i].getMoney());
					}
				}
				break;
			case 3:
				System.out.println("-".repeat(8));
				System.out.println("예금");
				System.out.println("-".repeat(8));
				System.out.print("계좌번호: ");
				accountNo = sc.nextLine();
				System.out.print("예금액: ");
				money = Integer.parseInt(sc.nextLine());
				account[0].addMoney(money);	
				break;
			case 4:
				System.out.println("-".repeat(8));
				System.out.println("출금");
				System.out.println("-".repeat(8));
				System.out.print("계좌번호: ");
				accountNo = sc.nextLine();
				System.out.print("예금액: ");
				money = Integer.parseInt(sc.nextLine());
				account[1].subMoney(money);
				System.out.println("결과: 출금이 성공되었습니다.");
				break;
			case 5:
				System.out.println("프로그램 종료");
				break Exit;
			}
		}
	}

}
