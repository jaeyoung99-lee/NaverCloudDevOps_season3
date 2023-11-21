package mini.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberDto {
	private int num;
	private String name;
	private String myid;
	private String pass;
	private String photo;
	private String hp;
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp gaipday;
}
