package bit701.day0915;

// 인터페이스 Runnable을 이용해서 Thread 구현하기
public class Ex2_RunnableTest implements Runnable {
	
	String name;
	int count;
	
	public Ex2_RunnableTest(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(name + " : " + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex2_RunnableTest ex1 = new Ex2_RunnableTest("one", 300);
		Ex2_RunnableTest ex2 = new Ex2_RunnableTest("two", 300);
		Ex2_RunnableTest ex3 = new Ex2_RunnableTest("three", 300);
		
		// Thread 생성자에 Runnable 타입의 현재 클래스 인스턴스를 보내서 생성한다
		Thread th1 = new Thread(ex1);
		Thread th2 = new Thread(ex2);
		Thread th3 = new Thread(ex3);
		
		th1.start();
		th2.start();
		th3.start();
	}

}