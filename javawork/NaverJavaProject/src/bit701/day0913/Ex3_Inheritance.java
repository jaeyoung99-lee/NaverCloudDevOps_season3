package bit701.day0913;
// 다형성 처리 시 부모가 하는 일이 없을 경우 어떻게 할까?
// 오버라이딩을 위해서 일단 메서드는 만들어야 함

// 추상 클래스의 특징
// 1. 일반 메서드와 미완성의 abstract 메서드 둘 다 구현 가능
// 2. abstract(추상) 클래스는 new로 객체 생성을 할 수 없다
// 3. 추상 클래스를 상속 받는 클래스는 반드시 추상 메서드를 오버라이드해서 기능을 구현해야만 한다
// 4. 만약 추상 메서드를 오버라이드 안할 경우 서브 클래스도 역시 추상화시켜야만 한다


abstract class SuperColor{
//	public void draw() {
//		// 부모 클래스가 하는 일이 없으므로 안에 내용이 없음
//	}
	
	// 추상 메서드
	// 오버라이드를 위해서 {} 부분을 없앤다
	// abstract : 추상화 - 미완성적인 메서드라는 의미
	// class의 멤버 메서드 중 한 개 이상의 추상 메서드가 있는 경우 반드시 클래스도 추상화 시켜야 한다
	// 즉, class 앞에 abstract를 붙인다
	abstract public void draw();
	
	// 오버라이드를 안할 경우 호출 가능
	// 서브 클래스에만 있는 메서드는 호출 불가능(부모로 선언 시)
	public void parentJob() {
		System.out.println("부모는 오늘도 돈을 벌어온다");
	}
}

// 3개의 서브 클래스들
class SubRed extends SuperColor{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("집 안 청소를 한다");
	}
}

class SubGreen extends SuperColor{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("식사 준비를 한다");
	}
}

class SubBlue extends SuperColor{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("설거지를 한다");
	}
}

public class Ex3_Inheritance {

	public static void draw(SuperColor s) {
		s.parentJob(); // 부모가 가지고 있는 메서드 호출(오버라이드 x)
		s.draw();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		draw(new SubBlue());
		draw(new SubGreen());
		draw(new SubRed());
	}

}
