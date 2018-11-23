package chap08;

public class ExceptionTest01 {

	public static void main(String[] args) 
			throws ArrayIndexOutOfBoundsException {
		String[] msg= {"æ»≥Á", "«œ¿Ã", "Hi", "Hello"};
		for(int i=0; i<10; i++) {
			System.out.println(msg[i]);
		}

	}

}
