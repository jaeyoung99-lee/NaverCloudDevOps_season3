package naver.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@Data
@PropertySource("classpath:/naver.properties")
// properties 파일에서 선언된 값 중에서 ncp.* 이름으로 된 property 값을 받을 필드를 선언
@ConfigurationProperties(prefix = "ncp")
public class NaverConfig {
	private String accessKey;
	private String secretKey;
	private String regionName;
	private String endPoint;
}
