package bit701.day0911;

public class Ex3_VarArg {

	public static int sum(int ... n) {
		System.out.println("총 " + n.length + "개");
		int s = 0;
		for(int i = 0; i < n.length; i++) {
			System.out.println(i + " : " + n[i]);
			s += n[i];
		}
		return s;
	}
	
	public static void stringWrite(String ...str) {
		System.out.println("총 " + str.length + "개의 문자열");
		for(String s : str) {
			System.out.println(s);
		}
		System.out.println("=".repeat(30));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int s1 = sum(4, 6, 8);
		System.out.println("총합 = " + s1);
		System.out.println();
		int s2 = sum(10, 20, 30, 40, 50);
		System.out.println("총합 = " + s2);
		System.out.println();
		
		stringWrite("빨강", "노랑", "초록");
		stringWrite("소나타");
	}

}
