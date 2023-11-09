package day1108.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. ���� Java ������� MessageInter ����");
		MessageInter m1 = new Message1();
		m1.sayHello("�̿���");
		MessageInter m2 = new Message2();
		m2.sayHello("��ȣ��");
		
		System.out.println("2. Spring�� xml ���� ������� ��ü ����");
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext1.xml");
		MessageInter m3 = (Message1)context.getBean("mes1"); // ��ȯ Ÿ���� Object �̹Ƿ� Ÿ���� �����ϰų� �� ��ȯ�� �ؼ� Ÿ���� ����
		MessageInter m3_1 = (Message1)context.getBean("mes1"); // ��ȯ Ÿ���� Object �̹Ƿ� Ÿ���� �����ϰų� �� ��ȯ�� �ؼ� Ÿ���� ����
		m3.sayHello("����Ŭ");
		MessageInter m4 = context.getBean("mes2", Message2.class);
		MessageInter m4_1 = context.getBean("mes2", Message2.class);
		m4.sayHello("ĳ����");
		
		System.out.println("�ּ� ��");
		System.out.println(m3.hashCode() + ", " + m3_1.hashCode()); // singletone�� ���� �� �����ص� �ּҰ� ����
		System.out.println(m4.hashCode() + ", " + m4_1.hashCode()); // prototype�� ������ ������ �ּҰ� �ٸ�
	}

}
