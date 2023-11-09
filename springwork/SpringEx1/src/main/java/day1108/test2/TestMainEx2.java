package day1108.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. 기존 Java 방식으로 MessageInter 생성");
		MessageInter m1 = new Message1();
		m1.sayHello("이영자");
		MessageInter m2 = new Message2();
		m2.sayHello("강호동");
		
		System.out.println("2. Spring의 xml 설정 방식으로 객체 생성");
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext1.xml");
		MessageInter m3 = (Message1)context.getBean("mes1"); // 반환 타입이 Object 이므로 타입을 지정하거나 형 변환을 해서 타입을 맞춤
		MessageInter m3_1 = (Message1)context.getBean("mes1"); // 반환 타입이 Object 이므로 타입을 지정하거나 형 변환을 해서 타입을 맞춤
		m3.sayHello("마이클");
		MessageInter m4 = context.getBean("mes2", Message2.class);
		MessageInter m4_1 = context.getBean("mes2", Message2.class);
		m4.sayHello("캐서린");
		
		System.out.println("주소 비교");
		System.out.println(m3.hashCode() + ", " + m3_1.hashCode()); // singletone은 여러 번 생성해도 주소가 같음
		System.out.println(m4.hashCode() + ", " + m4_1.hashCode()); // prototype은 생성할 때마다 주소가 다름
	}

}
