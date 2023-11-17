package data.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PhotoDto {
	private int num;
	private String title;
	private String photo;
	private String photo80;
	private String photo150;
	private Timestamp writeday;
}
