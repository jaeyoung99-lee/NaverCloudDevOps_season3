public class ArgsArray {
	public static void main(String[] args) {
		//args�� �ΰ��� ���ڸ� �о ����غ���
		String str1 = args[0];
		String str2 = args[1];
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("�� ���� �� = " + (str1 + str2));
	
		//String�� �⺻�� int�� ��ȯ�ϴ� ���
		//Integer��� Wrapper class�� �̿��ؼ� ��ȯ�غ���
		// parseInt �̿��� ��, ���� ���·� �Ǿ��ִ� String�� ����(���� ������ �ȵ�)
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		System.out.println("�� ���� �� = " + (num1 + num2));	
	}
}