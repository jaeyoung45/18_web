package chap09;

import java.util.Scanner;

public class ConsoleSachik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ã¹¹øÂ° ¼ýÀÚ >>");
		int a = sc.nextInt();
		System.out.println("µÎ¹øÂ° ¼ýÀÚ >>");
		int b = sc.nextInt();
		System.out.println("¿¬»êÀÚ ÀÔ·Â(µ¡¼À +, »¬¼À -, °ö¼À *, ³ª´©±â /)>>ÀÔ·Â");
		String op = sc.next();
		if(op.equals("+")) {
			System.out.println("µ¡¼À °á°ú :"+(a+b));
		}else if(op.equals("-")) {
			System.out.println("»¬¼À °á°ú :"+(a-b));
		}else if(op.equals("*")) {
			System.out.println("°ö¼À °á°ú :"+(a*b));
		}
		else if(op.equals("/")){
			try {
				System.out.println("³ª´©±â °á°ú : "+(a/b));
			}catch (ArithmeticException ar) {
				System.out.println("0À¸·Î ³ª´­ ¼ö ¾øÀ½");
			}
		}else {
			System.out.println("ÀÔ·Â¿À·ù");
		}
	}
}
	
		