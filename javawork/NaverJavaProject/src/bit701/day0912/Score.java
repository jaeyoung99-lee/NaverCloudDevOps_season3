package bit701.day0912;

public class Score {
	private String name;
	private int kor;
	private int eng;
	
	public Score(String name, int kor, int eng) {
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
	
}
