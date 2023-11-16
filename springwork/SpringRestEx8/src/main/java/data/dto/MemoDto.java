package data.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	private int num;
	private String nickname;
	private String photo;
	private String memo;
	private int likes;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone ="Asia/Seoul")
	private Timestamp writeday;
}
