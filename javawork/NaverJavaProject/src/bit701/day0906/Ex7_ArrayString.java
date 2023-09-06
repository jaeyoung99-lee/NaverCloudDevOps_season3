package bit701.day0906;

import java.util.Scanner;

public class Ex7_ArrayString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 입력한 숫자만큼 String 배열을 할당하고 이름 입력 받아서 출력하기
		Scanner sc = new Scanner(System.in);
		String[] names;
		int count;
		
		System.out.println("할당할 개수를 입력하세요");
		count = Integer.parseInt(sc.nextLine());
		
		// names 배열을 count 개수만큼 할당
		names = new String[count];
		
		// 할당한 개수만큼 이름 입력
		for(int i = 0; i < names.length; i++) {
			System.out.println(i + 1 + "번 이름은?");
			names[i] = sc.nextLine();
		}
		
		// 출력
		System.out.println("번호\t이름");
		for(int i = 0; i < names.length; i++) {
			System.out.println(i + 1 + "\t" + names[i]);
		}
	}

}
