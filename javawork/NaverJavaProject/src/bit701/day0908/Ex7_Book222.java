package bit701.day0908;

public class Ex7_Book222 {
	public static void main(String[] args) {
		// Korean 객체 생성
		Ex7_Book221 k1 = new Ex7_Book221("박자바", "011225-1234567");
		// Korean 객체 데이터 읽기
		System.out.println("k1.nation : " + k1.nation);
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		System.out.println();
		
		// 또 다른 Korean 객체 생성
		Ex7_Book221 k2 = new Ex7_Book221("김자바", "930525-0654321");
		// 또 다른 Korean 객체 데이터 읽기
		System.out.println("k2.nation : " + k2.nation);
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
		System.out.println();
	}
}
