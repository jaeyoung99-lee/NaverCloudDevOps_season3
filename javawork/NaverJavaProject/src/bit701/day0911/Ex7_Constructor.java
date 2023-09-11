package bit701.day0911;

public class Ex7_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 방법1 : 메모리에 할당을 먼저 하고 생성
//		Student[] stu = new Student[3]; // 3개로 배열 할당, 초기값은 null
//		stu[0] = new Student();
//		stu[1] = new Student("강호동");
//		stu[2] = new Student("이진", 1999, 99);
		
		// 방법2 : 배열 변수에 직접 생성
		Student[] stu = {new Student(), new Student("유재석"), new Student("강호동", 1989, 89), new Student("캔디", 1979, 100)};
		
		// 출력 방법 1
//		for(int i = 0; i < stu.length; i++) {
//			stu[i].studentInfo();
//		}
		
		// 출력 방법 2
		for(Student s : stu) {
			s.studentInfo();
		}
	}

}
