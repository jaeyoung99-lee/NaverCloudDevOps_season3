package day0904;

import java.util.Scanner;

public class Ex6_RandomWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
	
		int rnd, count, num;
		
		Exit:
		while(true) {
			rnd = (int)(Math.random() * 100) + 1;
			count = 0;
			while(true) {
				System.out.print(++count + " : ");
				// num = sc.nextInt(); // nextInt()부터 하고 nextLine()을 하면 enter 값이 들어가서 아래쪽에서 입력 불가
				num = Integer.parseInt(sc.nextLine());
				if(num > rnd) {
					System.out.println("\t" + num + "보다 작습니다");
				}
				else if(num < rnd) {
					System.out.println("\t" + num + "보다 큽니다");
				}
				else {
					System.out.println("\t**정답입니다(" + rnd + ")**");
					//계속할지 묻는다
					System.out.println("계속하려면 y를 입력해주세요, y가 아닐 경우 종료!");
					String ans = sc.nextLine();
					if(ans.equalsIgnoreCase("y")) { // 대소문자 상관없이 철자만 맞으면 true
						System.out.println("새로운 난수를 발생하겠습니다");
						continue Exit; // 바깥쪽 while 문의 조건식으로 이동한다
					}
					else {
						break Exit; // 두 개의 while 문을 모두 빠져나간다
					}
				}
			}
		}
		System.out.println("** 프로그램 종료 **");
	}

}
