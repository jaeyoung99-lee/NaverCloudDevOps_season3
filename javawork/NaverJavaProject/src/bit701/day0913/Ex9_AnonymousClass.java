package bit701.day0913;

// 익명 내부 클래스(Anonymous Inner Class)
abstract class AnonySuper{
	abstract public void show();
	abstract public void play();
}

interface BitInter{
	public void study();
	public void draw();
}

class AnonyClass{
	// 이 형태가 바로 익명 내부 클래스 형태이다
	// 탐색기에서 보면 외부클래스명$1 이런 식으로 class 이름이 만들어져있다
	AnonySuper anony = new AnonySuper() {

		@Override
		public void show() {
			System.out.println("오늘은 N-Time 날");
		}

		@Override
		public void play() {
			System.out.println("노는 날 아닙니다!!");
		}

	};
	
	// interface BitInter를 익명 내부 클래스 형태로 구현하여 메인에서 호출
	BitInter bit = new BitInter() {

		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("자바 공부를 하고 있어요~");
		}

		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("그림도 그리고 있어요!");
		}
		
	};
}

public class Ex9_AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnonyClass a = new AnonyClass();
		a.anony.show();
		a.anony.play();
		
		a.bit.study();
		a.bit.draw();
	}

}
