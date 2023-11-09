package day1108.test4;

import lombok.Setter;

@Setter
public class Bitcamp {
	private Student stu;
	private Sawon sawon;
	
	public void infoProcess() {
		System.out.println("** 학생 정보 **");
		System.out.println("이름 : " + stu.getName());
		System.out.println("혈액형 : " + stu.getBlood());
		System.out.println("나이 : " + stu.getAge());
		System.out.println();
		System.out.println("** 사원 정보 **");
		System.out.println("사원명 : " + sawon.getName());
		System.out.println("지역 : " + sawon.getCity());
		System.out.println("취미 : ");
		for(String h : sawon.getHobby()) {
			System.out.println(h);
		}
		System.out.println();
	}
}
