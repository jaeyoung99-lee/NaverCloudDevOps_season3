package bit701.day0911;

public class Ex12_StudentCallBy {

	// 주소가 넘어오므로 여기서 준 초기값은 main의 stu로 값이 전달됨
	public static void dataInput(Student[] stu) {
		stu[0] = new Student("김씨");
		stu[1] = new Student("이씨", 2000, 90);
		stu[2] = new Student("박씨", 1989, 89);
	}
	
	public static void dataWrite(Student[]  stu) {
		for(Student s : stu) {
			s.studentInfo();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student[] stu = new Student[3];
		dataInput(stu);
		dataWrite(stu);
		
		int a = 100;
		int b = changeInt(a); // Call by Value로 값을 변경한 경우 리턴으로 변경된 값을 얻어야만 알 수 있음
		System.out.println(a + "(을)를 " + b + "(으)로 변경했어요");
	}
		
	private static int changeInt(int a) {
		a = 200;
		return a;
	}

}
