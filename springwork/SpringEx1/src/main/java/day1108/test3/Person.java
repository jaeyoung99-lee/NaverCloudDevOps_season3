package day1108.test3;

import lombok.Getter;

@Getter
public class Person {
	private String name;
	private String addr;
	private MyShop myShop;
	
	public Person(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void setMyShop(MyShop myShop) {
		this.myShop = myShop;
	}
	
	public void writeProcee() {
		System.out.println("�̸� : " + name);
		System.out.println("�ּ� : " + addr);
		System.out.println("���� ����");
		System.out.println(myShop.getSangpum() + " ��ǰ");
		System.out.println(myShop.getPrice() + "��");
		System.out.println(myShop.getColor() + " ����");
	}
}
