package board.data;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnswerDto {
	private int idx;
	private int num;
	private String nickname;
	private String content;
	private Timestamp writeday;
}
