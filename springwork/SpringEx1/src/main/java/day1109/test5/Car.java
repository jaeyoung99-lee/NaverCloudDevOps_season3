package day1109.test5;

public class Car {
	Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + tire.getTireName() + "�Դϴ�.");
	}
}
