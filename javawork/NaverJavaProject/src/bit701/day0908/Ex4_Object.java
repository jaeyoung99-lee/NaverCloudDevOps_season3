package bit701.day0908;

public class Ex4_Object {
	// 인스턴스 멤버 변수
	private int score;
	
	//클래스 멤버 변수
	static public String message;
	
	// 인스턴스 멤버 메서드
	// score에 값을 넣는 메서드(setter method)
	public void setScore(int score) {
		// 멤버 변수 score에 인자로 받은 score를 전달
		// 매개변수명이 멤버 변수명이랑 같을 경우 멤버 변수 앞에 this 키워드를 붙임
		this.score = score;
	}
	
	// 점수를 반환하는 getter method
	public int getScore() {
		return score; // this.score에서 this 생략 가능
	}
	
	// static 메서드는 static 멤버 변수만 접근 가능
	public static void setMessage(String message) {
		Ex4_Object.message = message;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// main 메서드는 static 이므로 new로 객체를 생성을 해야 멤버 접근 가능
		// 단, static은 호출 가능
		Ex4_Object.setMessage("Hello World!");
		//public 이므로 바로 출력 가능
		System.out.println(Ex4_Object.message);
		
		Ex4_Object ex4 = new Ex4_Object();
		ex4.setScore(89);
		System.out.println("점수:" + ex4.getScore());
	}

}
