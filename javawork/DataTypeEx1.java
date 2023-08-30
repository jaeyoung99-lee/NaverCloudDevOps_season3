public class DataTypeEx1 {
	public static void main(String[] args) {
		//이 라인은 비실행문입니다.
		/*
			2023.08.30
			데이터 타입 예제
			이 부분은 여러 라인 주석
		*/
		
		//byte는 1byte 크기의 정수형 타입
		//크기는 -128 ~ 127의 숫자만 저장이 가능
		byte a = 127;
		System.out.println("a = " + a);

		byte b = (byte)200; //오류 발생 -> '(byte)' 써서 강제 형변환
		System.out.println("b = " + b); //강제 형변환 했을 경우 값 손실 발생 -> MSB가 1이 되어서 2의 보수로 계산이 되어서 -56이 나옴

		//실행 시 인자로 넘어오는 문자열을 확인해보자
		System.out.println(args[0]); //배열의 첫 문자열 출력
	}
}