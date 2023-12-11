package findLost.data;

import java.sql.Timestamp;

public class answerfindLostDto {
	private int id;
	private int findLostId;
	private String nickname;
	private String content;
	private Timestamp writeday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFindLostId() {
		return findLostId;
	}
	public void setFindLostId(int findLostId) {
		this.findLostId = findLostId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
}
