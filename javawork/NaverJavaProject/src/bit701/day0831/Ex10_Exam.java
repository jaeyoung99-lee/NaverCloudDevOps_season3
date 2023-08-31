package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 상품명과 수량, 단가를 각각 입력받은 후 총 금액을 출력하시오. 
		 * 그리고 수량이 5개 이상일 경우 10프로 할인된 최종 금액도 출력하시오.
		 * 추가로 가격은 컴마와 함께 찍히게 출력하시오.
		 * 
		 * 예시 
		 * 상품명 : 딸기 
		 * 수량 : 6 
		 * 단가 : 1000
		 * 
		 * 총금액 : 6,000원 
		 * 5개 이상 10프로 할인된 금액 : 5,400원
		 */
		
		NumberFormat NF = NumberFormat.getInstance();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명 : ");
		String name = sc.nextLine();
		
		System.out.print("수량 : ");
		int count = sc.nextInt();
		
		System.out.print("단가 : ");
		int price = sc.nextInt();
		System.out.println();
		
		System.out.printf("총금액 : %s원\n", NF.format(count * price));
		if (count >= 5)
			System.out.printf("5개 이상 10프로 할인된 금액 : %s원", NF.format((int)(count * price * 0.9)));
		
		}

}
