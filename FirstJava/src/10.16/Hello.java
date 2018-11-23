package day01;

public class Hello { //클래스 대문자로 시작
	public static int sum(int n, int m) { //메소드 소문자로 시작
			return n + m; // n=20, m=10
	}
	public static void main(String[] args) { 
		int i = 20;
		int s ;
		char a;
		
		s= sum(i, 10);
		a = '?';
		System.out.println(a);
		System.out.println("Hello");
		System.out.println(s);
		System.out.println("\\");
	}
}
