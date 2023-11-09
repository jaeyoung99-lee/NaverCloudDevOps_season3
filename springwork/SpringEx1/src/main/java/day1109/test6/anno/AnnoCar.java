package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // id : annoCar
// @Component("myCar") // id : myCar
public class AnnoCar {
	
	// @Autowired // �ڵ� ���� -> ���� �߻� : ��Ī ������ Ŭ������ 2���̹Ƿ� ������ �߻�
	// AnnoTire annoTire;
	
	// �������̽��� ������ Ŭ������ ���� ���� ��� ��Ȯ�ϰ� Ŭ���������� �����ϸ� ��
	// �����ϱ� ������ �˾Ƽ� �ڵ� ����
	@Autowired
	// AnnoCanadaTire annoTire;
	// AnnoKoreaTire annoTire;
	
	//@Resource�� �������̽��� ������ Ŭ������ ���� ���� ��� �� ��� �����ش�(������ ��������)
	// @Resource(name = "annoCanadaTire")
	@Resource(name = "annoKoreaTire")
	AnnoTire annoTire;
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + annoTire.getTireName() + "�Դϴ�.");
	}
}
