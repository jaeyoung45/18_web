package chap08;

public class ExceptionTest {
	
	public static void main(String[] args) {
		String[] msg= {"�ȳ�", "����", "Hi", "Hello"};
		String str=null;
		try {
		for(int i=0; i<10; i++) {
			System.out.println(msg[i]);
		}
			
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("�迭 ���� �ʰ�");
		}catch(NullPointerException n) {
			System.out.println("null ���̳׿�");
		}finally {
			System.out.println("�ݵ�� ����Ǵ� ����");
		}
	}
}
