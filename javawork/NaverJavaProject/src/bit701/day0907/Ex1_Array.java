package bit701.day0907;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex1_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("배열 복습 예제");
		/*  
		 * 처음에 인원수(count)를 입력 후 그 인원수만큼
		 * names, kor, eng를 배열 할당한 후
		 * 인원수만큼 이름, 국어점수, 영어점수를 입력하면
		 * 아래와 같이 출력되도록 프로그램 작성
		 * 
		 * 번호  이름  국어  영어  총점  평균
		 * ----------------------------------
		 * 1     김    89    90    179   89.5
		 * 2     이    100   100   200   100
		 */
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String[] names;
		int[] kor;
		int[] eng;
		
		System.out.print("인원수를 입력해주세요>");
		count = Integer.parseInt(sc.nextLine());
		
		names = new String[count];
		kor = new int[count];
		eng = new int[count];
		
		for(int i = 0; i < count; i++) {
			System.out.print("이름 입력>");
			names[i] = sc.nextLine();
			System.out.print("국어 점수 입력>");
			kor[i] = Integer.parseInt(sc.nextLine());
			System.out.print("영어 점수 입력>");
			eng[i] = Integer.parseInt(sc.nextLine());
			System.out.println();
		}
		System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
		System.out.println("--------------------------------------------");
		for(int i = 0; i < count; i++) {
			System.out.println(i + 1 + "\t" + names[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + (kor[i] + eng[i]) + "\t" + (kor[i] + eng[i]) / 2.0);
		}
	}

}
