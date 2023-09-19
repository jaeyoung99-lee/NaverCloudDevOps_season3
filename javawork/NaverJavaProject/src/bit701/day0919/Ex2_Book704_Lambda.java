package bit701.day0919;

// 리턴 타입이 있는 람다식

@FunctionalInterface
interface Calcuable{
	double calc(double x, double y);
}

class Person{
	public void action(Calcuable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println("결과 : " + result);
	}
}

public class Ex2_Book704_Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = new Person();

		// 실행문이 두 개 이상일 경우
		person.action((x, y) -> {
			double result = x + y;
			return result;
		});

		// 리턴문이 하나만 있을 경우(연산식)
		// person.action((x, y) -> {
		// return (x + y);
		// });

		// 위 호출문과 같은 로직 처리
		// 리턴 코드 한 줄일 경우  return 생략 가능
		person.action((x, y) -> (x + y));

		// 리턴문이 하나만 있을 경우(메서드 호출)
		// person.action((x, y) -> {
		// return sum(x, y);
		// });
		person.action((x, y) -> sum(x, y));

	}
	
	public static double sum(double x, double y) {
		return (x + y);
	}

}
