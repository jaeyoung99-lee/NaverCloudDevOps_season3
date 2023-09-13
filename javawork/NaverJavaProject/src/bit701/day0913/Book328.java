package bit701.day0913;
// 교재 p.328 예제

abstract class Animal{
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}
	
	public abstract void sound(); // 이것을 상속받는 클래스는 무조건 이 메서드를 오버라이드 해야 함 -> abstract이기 때문
}

// 추상 클래스 상속
class Dog extends Animal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
}
public class Book328 {
	public static void animalSound(Animal animal) {
		animal.sound();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		animalSound(cat);
		
		Dog dog = new Dog();
		animalSound(dog);
	}

}
