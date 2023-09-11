package bit701.day0911;

public class MyStudent {
	private String name;
	private int kor, eng;
	
	public MyStudent(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	// 두 과목의 합계를 구해서 리턴
	public int getTotal() {
		return kor + eng;
	}
	
	// 두 과목의 평균
	public double getAverage() {
		return getTotal() / 2.0;
	}
	
	// 평균에 따른 등급 리턴(90 이상 : "A그룹", 80 이상 : "B그룹", 나머지 : "탈락")
	public String getScore() {
		if(getAverage() >= 90)
			return "A그룹";
		else if(getAverage() >= 80)
			return "B그룹";
		else
			return "탈락";
	}
	
	// 강사님 코드
	/*
	public String getGrade() {
		double avg = this.getAverage();
		if(avg >= 90)
			return "A그룹";
		else if(avg >= 80)
			return "B그룹";
		else
			return "탈락";
	}
	*/
}
