package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // Builder를 이용해서 값을 넣음
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
	private String name;
	private String addr;
	private String hp;
}
