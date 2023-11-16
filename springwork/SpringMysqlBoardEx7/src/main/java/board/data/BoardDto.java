package board.data;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	public int num;
	private String writer;
	private String subject;
	private String content;
	private String photo;
	private int readcount;
	private Timestamp writeday;
	private int acount; // 댓글 개수 추가
}
