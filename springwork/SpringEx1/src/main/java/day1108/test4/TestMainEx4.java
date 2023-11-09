package day1108.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext1.xml");
		
		Bitcamp bit = (Bitcamp)context.getBean("bit");
		bit.infoProcess();
	}

}
