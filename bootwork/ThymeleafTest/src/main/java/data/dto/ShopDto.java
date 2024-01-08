package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Argument 없는 생성자 - 디폴트 생성자
@AllArgsConstructor // 전체 Argument 생성자 - 파라미터 있는 생성자
@Builder
public class ShopDto {
	String sangpum;
	String color;
	int su;
	int dan;
}
