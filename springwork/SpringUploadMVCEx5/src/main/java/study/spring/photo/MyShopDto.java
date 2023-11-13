package study.spring.photo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MyShopDto {
	private String sangpum;
	private String color;
	private int price;
	private String ipgoday;
	private MultipartFile photo;
	private String filename;
}
