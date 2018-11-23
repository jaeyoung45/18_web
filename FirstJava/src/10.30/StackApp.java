package chap06;

import java.util.Scanner;
interface Stack {
	int length(); //���� ����
	int capcity(); // ��ü ���� ������ ���� ����
	String pop(); //����
	boolean push(String val); //����
}
public class StackApp {
	
 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ���� ���� ������ ũ�� �Է� >>");
		int n = sc.nextInt();
		StringApp ss = new StringApp(n);
		while(true) {
			System.out.print("���ڿ� �Է� >>");
			String str = sc.next();
			if(str.equals("�׸�"))
				break;
			boolean res = ss.push(str);
			if(res == false) {
				System.out.println("������ �� ���� ���� Ǫ�� �Ұ�!");
			}
		}
		System.out.print("���ÿ� ����� ��� ���ڿ� �� :");
		int len = ss.length();
		for(int i=0; i<len; i++) {
			System.out.print(ss.pop() +" ");
		}
			sc.close();
	 }
}

class StringApp implements Stack{
	private String[] arr;
	private int top;
	public StringApp(int n) {
		arr = new String[n];
		top = -1;
	}
	@Override
	public int length() { //arr ����� ����
		return top+1;
	}
	@Override
	public int capcity() { //�迭�� ũ��
		return arr.length;
	}
	@Override
	public String pop() { //���°�
		if(top==-1) //���� �������
		return "�������";
		String s = arr[top];
		top--; //���������� ����
		return s;
	}
	@Override
	public boolean push(String val) { //����
		if(top == arr.length-1) { //á����
		return false;
		}else { //�� á����
		top++;
		arr[top] = val;
		return true;
	}
}
}

