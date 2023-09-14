package bit701.day0914;

public class Ex1_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10, 20, 30};
		for(int i = 0; i <= arr.length; i++) {
			try {
				System.out.println(arr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("배열 번지를 벗어났어요: " + e.getMessage());
				e.printStackTrace(); // 에러 메시지를 추적해서 출력
			}

		}
		System.out.println("정상종료!");
	}
}