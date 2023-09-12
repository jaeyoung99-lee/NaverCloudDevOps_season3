package bit701.day0912;

class SuperC{
	protected String name;
	protected int age;
	
	public SuperC() {
		System.out.println("부모 디폴트 생성자 호출");
		name = "홍길동";
		age = 10;
	}
	
	SuperC(String name, int age){
		System.out.println("부모의 두 번째 생성자 호출");
		this.name = name;
		this.age = age;
	}
}

class SubC extends SuperC{
	String hp;
	
	SubC(){
		super(); // 부모의 디폴트 생성자 호출, 기본으로 쓰지 않아도 내부적으로 호출된다 -> 숨겨져있음(생략가능 -> 디폴트인 경우에만)
		System.out.println("서브클래스의 디폴트 생성자 호출");
		hp = "010-1111-1111";
	}
	
	SubC(String hp){
//		super; // 생략되어 있음
		System.out.println("sub의 두 번째 생성자 호출");
		this.hp = hp;
	}
	
	/*
	SubC(String name, int age, String hp){
		System.out.println("sub의 세 번째 생성자 호출");
		this.name = name;
		this.age = age;
		this.hp = hp;
	}
	*/
	
	// 위의 방법보다는 아래의 방법으로 부모 생성자를 호출하는 경우가 많음
	SubC(String name, int age, String hp){
		super(name, age); // 부모의 두 번째 생성자 호출됨, 생략안됨 -> 반드시 첫 줄
		System.out.println("sub의 세 번째 생성자 호출");
		this.hp = hp;
	}
	
	public void dataShow() {
		// 부모 클래스의 멤버 변수가 protected이므로 패키지 상관없이 접근 가능
//		System.out.println("이름 : " + this.name);
//		System.out.println("나이 : " + this.age);
		System.out.println("이름 : " + super.name); // 부모가 가진 변수는 this, super 모두 가능
		System.out.println("나이 : " + super.age);
		System.out.println("핸드폰 : " + this.hp);
		System.out.println("----------------------");
	}
}
public class Ex8_InheritanceConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubC sub1 = new SubC();
		sub1.dataShow();
		
		SubC sub2 = new SubC("010-1234-5678");
		sub2.dataShow();
		
		SubC sub3 = new SubC("캔디", 12, "010-7878-4545");
		sub3.dataShow();
	}

}
