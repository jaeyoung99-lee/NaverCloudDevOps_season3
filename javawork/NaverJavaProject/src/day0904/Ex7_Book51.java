package day0904;

public class Ex7_Book51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// json 데이터 형식 : {"키":"값"}
		String jdata = "{\"name\":\"홍길동\"}";
		System.out.println(jdata);
		
		// jdk13에서 추가된 텍스트 불록 문법 """
		String jdata2 = 
				"""
				{"name":"홍길동", "address":"역삼동"}
				""";
		System.out.println(jdata2);
		
		String name = "마이클잭슨";
		int age = 32;
		String jdata3 = "{\"name\":\"" + name + "\", \"age\":" + age + "}";
		System.out.println(jdata3);
		
		// 텍스트 블록 문법에 변수값을 넣는 방법
		String jdata4 = 
				"""
				{"name":"%s", "age":%d}
				""".formatted(name, age);
		System.out.println(jdata4);
		
		String str1 = "red\nblue\ngreen";
		System.out.println(str1);
		
		String str2 = 
				"""
				red
				blue
				green
				pink
				""";
		System.out.println(str2);
	}

}
