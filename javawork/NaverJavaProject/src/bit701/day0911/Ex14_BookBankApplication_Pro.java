// 강사님 코드
// 교재 p.281 20번 문제

package bit701.day0911;

import java.util.Scanner;

public class Ex14_BookBankApplication_Pro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account_Pro[] account = new Account_Pro[10];
		Scanner sc = new Scanner(System.in);
		//배열 10개가 꽉차면 "더이상 계좌생성이 안됩니다" 라고 출력
		String accountNo = "";
		String accountName = "";
		int money = 0;
		int idx=0;
		Exit:
			while(true) {
				System.out.println("-".repeat(50));
				System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
				System.out.println("-".repeat(50));
				System.out.print("선택> ");
				int num = Integer.parseInt(sc.nextLine());
				switch(num) {
				case 1:
					if(idx >= 10) {
						System.out.println("** 더이상 계좌생성이 안됩니다 **");
						break;
					}
					System.out.println("-".repeat(8));
					System.out.println("계좌생성");
					System.out.println("-".repeat(8));
					System.out.print("계좌번호: ");
					accountNo = sc.nextLine();
					System.out.print("계좌주: ");
					accountName = sc.nextLine();
					System.out.print("초기입금액: ");
					money = Integer.parseInt(sc.nextLine());
					account[idx] = new Account_Pro(accountNo, accountName, money);
					System.out.println("결과: 계좌가 생성되었습니다");
					idx++;
					break;
				case 2:
					System.out.println("-".repeat(8));
					System.out.println("계좌목록");
					System.out.println("-".repeat(8));
					for(int i = 0; i < idx; i++) {
						account[i].accountWrite();
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
					// 계좌번호를 찾은후 그 배열번지의 money에 추가
					for(int i=0;i < idx;i++) {
						if(account[i].isAccount(accountNo)) {
							account[i].addMoney(money);
							break;
						}
					}
					System.out.println("결과: 예금되었습니다");
					break;
				case 4:
					System.out.println("-".repeat(8));
					System.out.println("출금");
					System.out.println("-".repeat(8));
					System.out.print("계좌번호: ");
					accountNo = sc.nextLine();
					System.out.print("출금액: ");
					money = Integer.parseInt(sc.nextLine());
					//계좌번호를 찾은후 그 배열번지의 money에서 빼기
					for(int i=0;i<idx;i++)
					{
						if(account[i].isAccount(accountNo)) {
							account[i].subMoney(money);
							break;
						}
					}
					System.out.println("결과:출금이 성공되었습니다");
					break;
				case 5:
					System.out.println("프로그램 종료");
					break Exit;
				}
			}
	}
}
