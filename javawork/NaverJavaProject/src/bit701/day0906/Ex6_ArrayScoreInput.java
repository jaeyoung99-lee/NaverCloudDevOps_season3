package bit701.day0906;

import java.util.Scanner;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// score에 5개의 배열 할당 후 키보드로 직접 점수를 입력하여 배열에 저장 후 총점과 평균 구하기
	
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		int sum = 0;
		double avg;
		for(int i = 0; i < score.length;  i++) {
			System.out.print(i + "번 인덱스 점수 입력 : ");
			score[i] = sc.nextInt();
			// 조건 추가 : 0보다 작거나 100보다 크면 "0 ~ 100 사이 점수로 입력바람!" 출력 후 다시 입력
			if(score[i] < 0 || score[i] > 100) {
				System.out.println("0 ~100 사이 점수로 입력바람!");
				i--; // 미리 1 감소 후 i++에서 1 증가되므로 다시 제자리에 입력
				continue; // i++로 이동
			}
			sum += score[i];
		}
		avg = (double)sum / score.length;
		System.out.print("입력한 점수들 : ");
		for(int n : score) {
			System.out.printf("%5d", n);
		}
		System.out.println("\n총점 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
