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
	private String readcount;
	private String regroup;
	private String restep;
	private String relevel;
	private List<String> photoNames;
	private Timestamp writeday;
}
