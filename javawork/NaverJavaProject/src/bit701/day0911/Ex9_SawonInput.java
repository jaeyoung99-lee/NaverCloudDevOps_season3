package bit701.day0911;

import java.util.Scanner;

public class Ex9_SawonInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Sawon[] sa = new Sawon[3];
		
		// 3명의 사원에 대한 정보 입력 후 배열 생성하기
		for(int i = 0; i < 3; i++) {
			System.out.print(i + "번의 이름은? >>");
			String name = sc.nextLine();
			System.out.print(i + "번의 기본급은? >>");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.print(i + "번의 수당은? >>");
			int sudang = Integer.parseInt(sc.nextLine());
			System.out.print(i + "번의 가족수는? >>");
			int familySu = Integer.parseInt(sc.nextLine());
			
			// 객체 생성
			sa[i] = new Sawon(name, gibon, sudang, familySu);
		}
		
		// 출력
		System.out.println("\n이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
		for(int i = 0; i < 3; i++) {
			System.out.println(sa[i].getName() + "\t" + sa[i].getGibon() + "\t" + sa[i].getSudang() + "\t  " + sa[i].getFamilySu() + "\t" + sa[i].getFamilySudang() + "\t\t" + sa[i].getTax() + "\t" + sa[i].getNetPay());
		}
	}

}
