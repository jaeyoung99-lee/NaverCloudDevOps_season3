package day1109.test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext2.xml");
		
		Car car1 = (Car)context.getBean("car1");
		car1.myCarInfo();
		
		Car car2 = (Car)context.getBean("car2");
		car2.myCarInfo();
	}

}
