package bit701.day0904;

import java.util.Scanner;

public class Ex2_While {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			// 점수를 입력받아 총점과 평균을 구해보자(0이 입력되면 점수 입력을 종료)
			
			Scanner sc = new Scanner(System.in);
			
			int score;
			int sum = 0, count = 0;
			double avg = 0;
			
			while(true) {
				System.out.println("점수를 입력하세요(종료 : 0)");
				score = sc.nextInt();
				if(score == 0)
					break; // 0 입력 시 while 문 빠져나감
				if(score < 1 || score > 100) {
					System.out.println("\t1~100 사이의 점수만 입력해주세요");
					continue; // 하던 작업을 중단하고 다시 처음으로 돌아간다
				}
				count++; //입력한 개수 구하기
				sum += score; // 총점 구하기
			}
			// 0 입력 시 빠져나온 후 평균 구하기
			avg = (double)sum/count;
			System.out.println("입력된 점수 개수 : " + count);
			System.out.println("총 합계 : " + sum);
			System.out.println("평균 : " + avg);
		}
}
