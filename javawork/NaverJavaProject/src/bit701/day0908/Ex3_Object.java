package bit701.day0908;

public class Ex3_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bitcamp[] bit = new Bitcamp[3]; // 3개의 데이터가 들어갈 변수로 할당, 초기값은 null
		//배열 개수만큼 Bitcamp 객체 생성
		for(int i = 0; i < bit.length; i++) {
			bit[i] = new Bitcamp();
		}
		// 0번 데이터
		bit[0].name = "캔디";
		bit[0].address = "대구";

		// 1번 데이터
		bit[1].name = "안쏘니";
		bit[1].address = "서울";

		// 2번 데이터
		bit[2].name = "테리우스";
		bit[2].address = "부산";


		// 출력 #1
		/*
		for(int i = 0; i < bit.length; i++) {
			System.out.println("** 학생 정보 " + (i + 1) + " **");
			System.out.println("이름 : " + bit[i].name);
			System.out.println("주소 : " + bit[i].address);
			System.out.println("스터디반 : " + Bitcamp.STUDYNAME);
			System.out.println("=".repeat(30));
		}
		*/
		
		// 출력 #2
		for(Bitcamp b : bit) {
			System.out.println("** 학생 정보 **");
			System.out.println("이름 : " + b.name);
			System.out.println("주소 : " + b.address);
			System.out.println("스터디반 : " + Bitcamp.STUDYNAME);
			System.out.println("=".repeat(30));
		}
	}
}
