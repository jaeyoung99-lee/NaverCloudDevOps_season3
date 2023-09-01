package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex2_Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 이름, 3과목의 점수(kor, eng, mat)를 입력 받은 후 총점과 평균(소수점 1자리 출력 - NumberFormat) 
		 * 등급을 출력(grade : 평균이 90이상이면 "Excellent!", 80이상이면 "Good!", 나머지는 "Try!"라고 출력) - if-else 사용
		 */
		
		Scanner sc = new Scanner(System.in);
		NumberFormat NF = NumberFormat.getInstance();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("kor 점수 : ");
		double kor_score = sc.nextDouble();
		
		System.out.print("eng 점수 : ");
		double eng_score = sc.nextDouble();
		
		System.out.print("mat 점수 : ");
		double mat_score = sc.nextDouble();
		System.out.println();
		
		double total_score = kor_score + eng_score + mat_score;
		double score_avg = total_score / 3;
		NF.setMaximumFractionDigits(1);
		System.out.printf("총점 : %s점\n", NF.format(total_score));
		System.out.printf("평균 : %s점\n", NF.format(score_avg));
		
		if (score_avg >= 90) {
			System.out.println("Excellent!");
		}
		else if (score_avg >= 80) {
			System.out.println("Good!");
		}
		else
			System.out.println("Try!");
		
		// 강사님 코드
		/*
		// 선언
		Scanner sc = new Scanner(System.in);
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(1);
		String name = "";
		int kor, eng, mat, total = 0;
		double avg = 0;
		String grade = "";
		
		// 입력
		System.out.println("이름 입력");
		name = sc.nextLine();
		System.out.println("국어점수는?");
		kor = sc.nextInt();
		System.out.println("영어점수는?");
		eng = sc.nextInt();
		System.out.println("수학점수는?");
		mat = sc.nextInt();
		
		// 계산
		total = kor + eng + mat;
		avg = total / 3.0;
		if(avg >= 90)
			grade = "Excellent!";
		else if (avg >= 80)
			grade = "Good!";
		else
			grade = "Try!";
		
		// 출력
		System.out.println("이름 : " + name);
		System.out.println("국어점수 : " + kor + "점");
		System.out.println("영어점수 : " + eng + "점");
		System.out.println("수학점수 : " + mat + "점");
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + format.format(avg) + "점");
		System.out.println("평가 : " + grade);
		*/
	}

}
