package bit701.day0911;

class Hello{
	public static final String MESSAGE = "오늘은 월요일!";
	
	// 인스턴스 멤버 변수
	private String name;
	private int age;
	
	// setter method
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// getter method
	public String getName() { 
		return this.name; // this는 생략 가능
	}
	
	public int getAge() {
		return this.age;
	}
	
	// 일반 멤버 메서드
	public void show() {
		System.out.println("name = " + name + ", age = " + age);
	}
}

public class Ex1_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hello hello = new Hello();
		hello.show(); // 초기값 확인
		
		// 값 변경
		hello.setName("이영자");
		hello.setAge(34);
		
		// 출력
		// static 멤버 변수 출력
		System.out.println("static 변수 출력 : " + Hello.MESSAGE);
		System.out.println("이름 : " + hello.getName());
		System.out.println("나이 : " + hello.getAge());
		System.out.println();
		hello.show();
	}

}
