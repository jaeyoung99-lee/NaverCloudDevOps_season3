public class DataTypeEx1 {
	public static void main(String[] args) {
		//�� ������ ����๮�Դϴ�.
		/*
			2023.08.30
			������ Ÿ�� ����
			�� �κ��� ���� ���� �ּ�
		*/
		
		//byte�� 1byte ũ���� ������ Ÿ��
		//ũ��� -128 ~ 127�� ���ڸ� ������ ����
		byte a = 127;
		System.out.println("a = " + a);

		byte b = (byte)200; //���� �߻� -> '(byte)' �Ἥ ���� ����ȯ
		System.out.println("b = " + b); //���� ����ȯ ���� ��� �� �ս� �߻� -> MSB�� 1�� �Ǿ 2�� ������ ����� �Ǿ -56�� ����

		//���� �� ���ڷ� �Ѿ���� ���ڿ��� Ȯ���غ���
		System.out.println(args[0]); //�迭�� ù ���ڿ� ���
	}
}