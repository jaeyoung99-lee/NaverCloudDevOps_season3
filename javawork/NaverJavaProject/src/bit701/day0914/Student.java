package bit701.day0914;

public class Student {
	private String name;
	private int score;
	private String blood;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int score, String blood) {
		super();
		this.name = name;
		this.score = score;
		this.blood = blood;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}
}
