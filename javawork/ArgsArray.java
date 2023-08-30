public class ArgsArray {
	public static void main(String[] args) {
		//args로 두개의 숫자를 읽어서 출력해보자
		String str1 = args[0];
		String str2 = args[1];
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("두 수의 합 = " + (str1 + str2));
	
		//String을 기본형 int로 변환하는 방법
		//Integer라는 Wrapper class를 이용해서 변환해보자
		// parseInt 이용할 때, 숫자 형태로 되어있는 String만 가능(공백 있으면 안됨)
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		System.out.println("두 수의 합 = " + (num1 + num2));	
	}
}