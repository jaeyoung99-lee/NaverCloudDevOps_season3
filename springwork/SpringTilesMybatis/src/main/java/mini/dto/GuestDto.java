package mini.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GuestDto {
	private int guest_num;
	private String guest_nickname;
	private String guest_photo;
	private String guest_content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp guest_writeday;
}
