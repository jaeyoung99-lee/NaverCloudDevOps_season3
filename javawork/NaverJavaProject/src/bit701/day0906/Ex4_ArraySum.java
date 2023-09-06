package bit701.day0906;

public class Ex4_ArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 배열에 5개의 점수를 저장 후 총점과 평점을 구해보자
		int[] score = {78, 100, 90, 89, 69};
		int sum = 0;
		double avg =0;
		
		// 방법 1
//		for(int i = 0; i < score.length; i++) {
//			sum += score[i];
//		}
		
		// 방법 2
		for(int n : score) {
			sum += n;
		}
		
		// sum 계산이 모두 끝난 후 평균 구하기
		avg = (double)sum / score.length;
		
		System.out.println("총점수개수 : " + score.length);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
