package day1108.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Setter
@Getter
@ToString
*/

// ���� 3���� ������̼��� �ϳ��� ������̼����� ǥ�� ����
@Data

@NoArgsConstructor // ����Ʈ ������
@AllArgsConstructor // ��� ����� ���ڷ� ���� ������
@RequiredArgsConstructor //�ʿ��� ���ڸ� �����ڷ� ����(Injection)-@NonNull ���ڸ� ����
public class TestDto {
	@NonNull
	private String name;
	private String addr;
	private int age;
}
