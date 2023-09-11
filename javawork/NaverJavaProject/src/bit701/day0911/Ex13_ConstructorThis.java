package bit701.day0911;

/*
 * this : 자기 자신을 의미하는 인스턴스 변수
 *        인스턴스 멤버 메서드는 this 라는 변수를 기본적으로 갖고 있음
 *        
 * this() : this()는 생성자에서 다른 생성자 호출 시 사용하는 이름
 *          반드시 첫 줄에 나와야 함 
 */

class Kiwi{
	String name;
	int age;
	
	Kiwi(){
		this("홍길동", 20); // 3번째 생성자가 호출됨
	}
	
	Kiwi(String name){
		this(name, 30); // 3번째 생성자가 호출됨
	}
	
	Kiwi(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void writeData() {
		System.out.println("name : " + name + "\tage : " + age);
	}
}

public class Ex13_ConstructorThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Kiwi[] karr = {new Kiwi(), new Kiwi("kim"), new Kiwi("Lee", 35)};
		
		for(Kiwi k : karr) {
			k.writeData();
		}
			
	}

}
