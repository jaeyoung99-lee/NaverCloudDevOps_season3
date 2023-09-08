package bit701.day0908;

public class Ex5_SawonCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sawon sa1 = new Sawon();
		sa1.setSawonNo("bit1234");
		sa1.setName("홍길동");
		sa1.setAge(23);

		System.out.println("** 신입사원 #1 정보 **");
		Ex5_SawonCall.printSawon(sa1); // 같은 클래스 내의 메서드는 클래스명 생략 가능

		Sawon sa2 = new Sawon();
		sa2.setSawonNo("bit9999");
		sa2.setName("강호동");
		sa2.setAge(35);

		System.out.println("** 신입사원 #2 정보 **");
		Ex5_SawonCall.printSawon(sa2); // 같은 클래스 내의 메서드는 클래스명 생략 가능
	}
	public static void printSawon(Sawon s) {
		System.out.println("사원번호 : " + s.getSawonNo());
		System.out.println("사원번호 : " + s.getName());
		System.out.println("사원번호 : " + s.getAge());
		System.out.println();
	}
}
