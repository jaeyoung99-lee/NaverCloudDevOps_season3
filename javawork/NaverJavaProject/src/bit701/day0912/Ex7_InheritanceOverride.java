package bit701.day0912;

class SuperB{
	public void processA() {
		System.out.println("부모가 가진 메서드 A");
	}
}

class SubB extends SuperB{
	@Override // 어노테이션
	public void processA() {
		// TODO Auto-generated method stub
		// this로 하면 자신이 호출되기 때문에 무한의 늪에 빠져버림
		super.processA(); // 부모가 먼저 작업을 하고 
		System.out.println("자식이 가진 오버라이드 메서드 A"); // 나머지는 자식 클래스에서 작업을 완성하겠다라는 뜻
	}
	
	public void processB() {
		System.out.println("자식만이 갖고 있는 메서드 B");
	}
}

public class Ex7_InheritanceOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SubB sub1 = new SubB();
		sub1.processA();
		sub1.processB();
		
		// 다형성의 기본 원리
		// 선언은 부모 클래스로, 생성은 자식 클래스로
		// processB는 호출할 수 없음 -> 자식 클래스가 가진 것 중 오버라이드된 것만 호출 가능
		SuperB sub2 = new SubB();
		sub2.processA(); // 오버라이드된 자식이 가진 메서드가 호출
	}

}
