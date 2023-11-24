package mini.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class BoardDto {
	private int num;
	private String writer;
	private String myid;
	private String subject;
	private String content;
	private int readcount;
	private int regroup;
	private int restep;
	private int relevel;
	private List<String> photoNames;
	private Timestamp writeday;
	private int photocount; // 첨부된 사진의 개수를 저장할 용도
}
