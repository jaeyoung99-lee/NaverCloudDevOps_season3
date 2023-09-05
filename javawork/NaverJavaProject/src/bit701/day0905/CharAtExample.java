// 교재 p.158
package bit701.day0905;

import java.util.Scanner;

public class CharAtExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		String ssn = "9506241230123";
		//		char sex = ssn.charAt(6);
		//		switch(sex) {
		//			case '1':
		//			case '3':
		//				System.out.println("남자입니다");
		//				break;
		//			case '2':
		//			case '4':
		//				System.out.println("여자입니다");
		//				break;
		//		}


		// 응용문제
		Scanner sc = new Scanner(System.in);
		Exit: 
			while(true) {
				System.out.println("주민번호 입력");
				String num = sc.nextLine();
				if(num.equalsIgnoreCase("q")) {
					System.out.println("프로그램을 종료합니다");
					break Exit;
				}
				if(num.length() != 14) {
					System.out.println("형식에 맞게 다시 입력해주세요");
					System.out.println("형식 : ______-_______ (6자리-7자리)");
					System.out.println();
					continue;
				}
				System.out.println(num.substring(0, 2) + "년 " + num.substring(2, 4) + "월 " + num.substring(4, 6) + "일생" );
				char check = num.charAt(7);

				switch(check) {
				case '1':
					System.out.println("내국인");
					System.out.println("남성");
					System.out.println();
					break;
				case '2':
					System.out.println("내국인");
					System.out.println("여성");
					System.out.println();
					break;
				case '3':
					System.out.println("내국인");
					System.out.println("남성");
					System.out.println();
					break;
				case '4':
					System.out.println("내국인");
					System.out.println("여성");
					System.out.println();
					break;
				case '5':
				case '7':
					System.out.println("외국인");
					System.out.println("남성");
					System.out.println();
					break;
				case '6':
				case '8':
					System.out.println("외국인");
					System.out.println("여성");
					System.out.println();
					break;
				}
			}
	}
}

