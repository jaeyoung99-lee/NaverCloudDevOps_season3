package day1109.test6.anno;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("mycar2")
@AllArgsConstructor // ������ ���� ������� �ڵ� ����
public class AnnoCar2 {
	AnnoKoreaTire koreaTire;
	AnnoCanadaTire canadaTire;
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + koreaTire.getTireName() + "�Դϴ�.");
		System.out.println("�ܿ�� Ÿ�̾�� " + canadaTire.getTireName() + "�Դϴ�.");
	}
}
