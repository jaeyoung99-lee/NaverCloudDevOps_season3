package bit701.day0911;

public class Ex6_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student stu1 = new Student();
		Student stu2 = new Student("강호동");
		Student stu3 = new Student("홍길동", 1989, 90);
		
		stu1.studentInfo();
		stu2.studentInfo();
		stu3.studentInfo();
	}

}
