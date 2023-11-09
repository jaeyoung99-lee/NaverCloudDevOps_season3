package day1108.test1;

public class TestMainEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDto dto = new TestDto();
		dto.setName("이상아");
		dto.setAddr("강남");
		dto.setAge(23);
		
		System.out.println("이름 : " + dto.getName());
		System.out.println("주소 : " + dto.getAddr());
		System.out.println("나이 : " + dto.getAge());
		
		System.out.println("toString() 호출");
		System.out.println(dto); // dto.toString(), toString() 생략 가능
		
		TestDto dto2 = new TestDto("강호동", "제주도", 45);
		System.out.println(dto2);
		
		TestDto dto3=new TestDto("윤현수");
		System.out.println(dto3);
	}

}
