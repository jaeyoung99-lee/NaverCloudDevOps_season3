package findLost.data;

import java.sql.Timestamp;

public class findLostDto {
	private int id;
	private String name;
	private String photo;
	private String lostplace;
	private String lostday;
	private String money;
	private int readcount;
	private int answercount;
	private Timestamp writeday;
	
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLostplace() {
		return lostplace;
	}
	public void setLostplace(String lostplace) {
		this.lostplace = lostplace;
	}
	public String getLostday() {
		return lostday;
	}
	public void setLostday(String lostday) {
		this.lostday = lostday;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getAnswercount() {
		return answercount;
	}
	public void setAnswercount(int answercount) {
		this.answercount = answercount;
	}
}
