package naver.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@Data
@PropertySource("classpath:/naver.properties")
// ������Ƽ ���Ͽ��� ����� �� �߿���
// ncp.* �̸����� �� ������Ƽ ���� ���� �ʵ带 �����Ѵ�.
@ConfigurationProperties(prefix = "ncp")
public class NaverConfig {
	private String endPoint;
	private String regionName;
	private String accessKey;
	private String secretKey;	
}
