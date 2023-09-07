package bit701.day0907;

import java.util.Scanner;

public class Ex3_ArrayBinggo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//3행 3열의 배열 선언 후 1 ~ 3 사이의 난수를 넣고 가로, 세로, 대각선으로 비교하여 같은 숫자가 나온 개수를 구함

		Scanner sc = new Scanner(System.in);
		int[][] data = new int[3][3];
		int binggo;

		while(true) {
			binggo = 0;
			// 3행 3열의 1 ~ 3의 숫자 임의로 넣기
			for(int i = 0; i < data.length; i++) {
				for(int j = 0; j < data[i].length; j++) {
					data[i][j] = (int)((Math.random() * 3) + 1);
				}
			}

			// 출력
			for(int i = 0; i < data.length; i++) {
				for(int j = 0; j < data[i].length; j++) {
					System.out.printf("%3d", data[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			// 빙고 계산(0이면 꽝, 아닐 경우 빙고 : n개...
			// 가로
			for(int i = 0; i < data.length;i++) {
				for(int j = 0; j < data[i].length - 2 ; j++) {
					if((data[i][j] == data[i][j+1]) && (data[i][j]== data[i][j+2])) {
						binggo++;
					}
				}
			}

			// 세로
			for(int i = 0; i < data.length - 2;i++) {
				for(int j = 0; j < data[i].length; j++) {
					if((data[i][j] == data[i+1][j]) && (data[i][j]== data[i+2][j])) {
						binggo++;
					}
				}
			}

			// 대각선
			if((data[0][0] == data[1][1]) && (data[0][0] == data[2][2])) {
				binggo++;
			}
			if((data[0][2] == data[1][1]) && (data[0][2] == data[2][0])) {
				binggo++;
			}
			if(binggo != 0) {
				System.out.println("빙고 개수 : " + binggo);
			}
			if(binggo == 0) {
				System.out.println("빙고 개수 : " + binggo);
				System.out.println("꽝!");
			}
			System.out.println("종료(q)>");
			String ans = sc.nextLine();
			if(ans.equalsIgnoreCase("q")) {
				break;
			}
			System.out.println("-".repeat(10));
		}
		System.out.println("** 빙고 게임 끝!! **");
	}

}
