package chap09;

import java.util.Scanner;

public class ConsoleSachik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ���� >>");
		int a = sc.nextInt();
		System.out.println("�ι�° ���� >>");
		int b = sc.nextInt();
		System.out.println("������ �Է�(���� +, ���� -, ���� *, ������ /)>>�Է�");
		String op = sc.next();
		if(op.equals("+")) {
			System.out.println("���� ��� :"+(a+b));
		}else if(op.equals("-")) {
			System.out.println("���� ��� :"+(a-b));
		}else if(op.equals("*")) {
			System.out.println("���� ��� :"+(a*b));
		}
		else if(op.equals("/")){
			try {
				System.out.println("������ ��� : "+(a/b));
			}catch (ArithmeticException ar) {
				System.out.println("0���� ���� �� ����");
			}
		}else {
			System.out.println("�Է¿���");
		}
	}
}
	
		