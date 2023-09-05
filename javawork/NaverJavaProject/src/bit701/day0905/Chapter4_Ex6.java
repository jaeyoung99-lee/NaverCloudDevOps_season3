// 교재 Chapter4 문제 6번 p.139
package bit701.day0905;

public class Chapter4_Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 결과
//		*
//		**
//		***
//		****
//		*****
//		for(int i = 1; i <= 5; i++) { // 행
//			for(int j = 1; j <= i; j++) { // 열
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		// 결과
//		*****
//		****
//		***
//		**
//		*
//		for(int i = 1; i <= 5; i++) { // 행
//			for(int j = i; j <= 5; j++) { // 열
//				System.out.print("*");
//			}
//			System.out.println();
		
		
		// 결과
//		1****
//		*2***
//		**3**
//		***4*
//		****5
		for(int i = 1; i <= 5; i++) { // 행
			for(int j = 1; j <= 5; j++) { // 열
				if(i == j) {
					System.out.print(i);
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
