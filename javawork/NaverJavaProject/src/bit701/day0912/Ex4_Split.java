package bit701.day0912;

import java.util.StringTokenizer;

public class Ex4_Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "red,blue,green,orange,gray";
		
		// 문자열을 콤마(,)로 분리해서 배열에 담아보자
		String[] strArray = str1.split(",");
		System.out.println("총 " + strArray.length + "개로 분리됨");
		for(int i = 0; i < strArray.length; i++) {
			System.out.println(i + " : "+ strArray[i]);
		}
		
		System.out.println("-".repeat(20));
		
		String str2 = "sea.jpg";
		// 도트(.)로 분리하고 싶으면 아래 두 개 중 하나로 쓰면 됨
//		String[] str2Array = str2.split("[.]");
		String[] str2Array = str2.split("\\.");
		System.out.println(str2Array[0]);
		System.out.println(str2Array[1]);
		
		System.out.println("-".repeat(20));
		
		String str3 = "red|green|yellow";
		// 파이프(|)로 분리하고 싶으면 아래 두 개 중 하나로 쓰면 됨
//		String[] str3Array = str3.split("[|]");
		String[] str3Array = str3.split("\\|");
		for(int i = 0; i < str3Array.length; i++) {
			System.out.println(i + " : "+ str3Array[i]);
		}
		
		System.out.println("-".repeat(20));
		
		// 자바의 클래스를 이용해서 분리하기
		StringTokenizer st = new StringTokenizer(str1, ",");
		System.out.println("총 " + st.countTokens() + "개로 분리");
		while(st.hasMoreTokens()) { // 다음 분리할 토큰이 있으면 true, 더이상 없으면 false
			System.out.println(st.nextToken());
		}
		
		// for문을 이용한 분리
		StringTokenizer st2 = new StringTokenizer(str1, ",");
		System.out.println("-".repeat(20));
		int count = st2.countTokens();
		for(int i = 0; i < count; i++) {
			System.out.println(st2.nextToken());
		}
	}

}
