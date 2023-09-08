package bit701.day0908;

public class Ex6_Book217_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Car 객체 생성
		Ex6_Book217_1 myCar = new Ex6_Book217_1();
		
		// Car 객체의 필드값 일기
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색깔 : " + myCar.color);
		System.out.println("최고속도 : " + myCar.maxSpeed);
		System.out.println("현재속도 : " + myCar.speed);
		
		// Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도 : " + myCar.speed);
	}

}
