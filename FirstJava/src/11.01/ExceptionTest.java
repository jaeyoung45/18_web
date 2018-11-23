package chap08;

public class ExceptionTest {
	
	public static void main(String[] args) {
		String[] msg= {"안녕", "하이", "Hi", "Hello"};
		String str=null;
		try {
		for(int i=0; i<10; i++) {
			System.out.println(msg[i]);
		}
			
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("배열 범위 초과");
		}catch(NullPointerException n) {
			System.out.println("null 값이네요");
		}finally {
			System.out.println("반드시 수행되는 문장");
		}
	}
}
