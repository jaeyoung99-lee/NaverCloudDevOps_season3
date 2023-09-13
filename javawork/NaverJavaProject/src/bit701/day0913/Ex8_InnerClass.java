package bit701.day0913;

class OuterA{
	int a = 10;
	static int b = 20;
	
	// Member 내부 클래스
	class InnerA{
		int c = 30;
		static int d = 40; // jdk11버전까지는 오류 발생, 멤버 내부 클래스에서 static 선언 불가능, jdk17에서는 가능
		
		public void showInner() {
			System.out.println("** 내부 클래스의 메서드 **");
			System.out.println("외부의 변수 a = " + a);
			System.out.println("외부의 변수 b = " + b);
			System.out.println("내부의 변수 c = " + c);
			System.out.println("내부의 변수 d = " + d);
		}
	}
	
	static class InnerB{
		int e = 50;
		static int f = 60;
		public void showInnerB() {
			System.out.println("** static 내부 클래스의 메서드 **");
//			System.out.println("외부 a = " + a); // 외부의 일반 인스턴스 멤버 변수 접근 불가능
			System.out.println("외부 b = " + b);
			System.out.println("내부 e = " + e);
			System.out.println("내부 f = " + f);
		}
	}
	// 외부 클래스의 메서드
	public void showOuter() {
		InnerA inA = new InnerA();
		inA.showInner();
		InnerB inB = new InnerB();
		inB.showInnerB();
	}
}

public class Ex8_InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OuterA a = new OuterA();
		a.showOuter();
		
		System.out.println();
		
		// 다른 클래스에서 직접 내부 클래스의 메서드를 호출하고 싶을 경우
		OuterA.InnerA b = new OuterA().new InnerA();
		b.showInner();
		
		System.out.println("--------------");
		// static 내부 클래스를 직접 선언하여 메서드를 호출하고자 할 경우
		OuterA.InnerB c = new OuterA.InnerB();
		c.showInnerB();
	}

}
