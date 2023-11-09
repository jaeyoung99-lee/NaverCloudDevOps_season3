package myshop.dto;

import java.sql.Timestamp;

public class MyShopDto {
	private int num;
	private String sangpum;
	private String photo;
	private int price;
	private String color;
	
	public MyShopDto() {
		super();
	}
	
	public MyShopDto(int num, String sangpum, String photo, int price, String color) {
		super();
		this.num = num;
		this.sangpum = sangpum;
		this.photo = photo;
		this.price = price;
		this.color = color;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
