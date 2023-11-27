package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Setter
@Getter
public class NaverConfig {
	
	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	@Value("kr-standard")
	private String regionName;
	
	// 내꺼
	@Value("mqLfd61mcXaM1ALWJd8N")
	private String accessKey;
	
	/* 
	// 강사님꺼
	@Value("8yt6c0uo9is9HLAN1BZH")
	private String accessKey;
	*/
	
	// 내꺼
	@Value("W8thHH4AhT7gnSb2YFvdEHnrp16mYl2OJXxwfOth")
	private String secretKey;
	
	/*
	// 강사님꺼
	@Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0")
	private String secretKey;
	*/
}
