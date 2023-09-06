package bit701.day0906;

import java.util.Random;

public class Ex16_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 6개 할당된 lotto 변수에 1 ~ 45 사이의 난수를 발생하는데
		 * 중복된 경우 다시 발생
		 * 오름차순으로 정렬
		 */

		Random r = new Random();
		int[] num = new int[6];

		Loop:
			for(int i = 0; i < num.length; i++) {
				num[i] = r.nextInt(45) + 1;
				for(int j = 0; j < i; j++) {
					if(num[i] == num[j]) {
						i--;
						continue Loop;
					}
				}
			}

		for(int i = 0; i < num.length; i++) {
			for(int j = i + 1; j < num.length; j++) {
				if(num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}

			System.out.printf("%d ", num[i]);

		}
	}
}