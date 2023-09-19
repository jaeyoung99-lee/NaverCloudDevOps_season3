package bit701.day0918;

// 자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를 사용하는 익명 내부클래스의 또다른 표현식이다.
// 단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다.

@FunctionalInterface // 해당 인터페이스를 함수형으로 사용하겠다는 의미
interface Orange{
	public void write();
	//	public void show(); // @FunctionalInterface는 메서드가 하나인지 아닌지 검증하는 역할, 오류 발생
}

@FunctionalInterface
interface DataAdd{
	public void add(int x, int y);
}

public class Ex4_Lambda {

	// 우리가 알고 있는 익명 내부클래스 형태로 객체를 생성
	public void abstMethod1() {
		Orange or = new Orange() {

			@Override
			public void write() {
				// TODO Auto-generated method stub

				System.out.println("안녕하세요 ^^");
			}
		};

		or.write();
	}

	// 람다식으로 오버라이드 해보기
	public void abstMethod2() {
		Orange or = () -> System.out.println("반가워요 ^^"); // 메서드의 코드가 한 줄일 경우 {} 생략
		or.write();

		// 오버라이드 메서드의 코드가 2줄 이상일 경우 {} 안에서 주면 된다.
		Orange or2 = () -> {
			System.out.println("람다람다~~");
			System.out.println("여러 줄 썼어요!!!");
		};
		
		or2.write();
	}
	
	// 람다식으로 오버라이드 해보기
	public void abstMethod3() {
		// 기존 방식 : 익명 내부 클래스
//		DataAdd add1 = new DataAdd() {
//			public void add(int x, int y) {
//				System.out.println(x + " + " + y + " = " + (x + y));
//			};
//		};
		
		// 람다식으로 변경해보기
		DataAdd add1 = (int x, int y) -> System.out.println(x + " + " + y + " = " + (x + y));
		
		add1.add(100, 200);
		add1.add(5, 7);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex4_Lambda ex = new Ex4_Lambda();
		ex.abstMethod1();
		ex.abstMethod2();
		ex.abstMethod3();
	}

}
