package day01;

public class Exam01 {
	public static void main(String[] args) {
		System.out.println("2+5");
		System.out.println(2+5);
		System.out.println("2+5="+2+5);
		System.out.println("2+5="+(2+5));
		int a=10; //int는 4바이트
		int b=20;
		System.out.println("a+b="+(a+b));
		int num;//선언
		num=100;//할당
		int num1=50; //선언&할당(4바이트)
		int sum = num+num1;
		System.out.println("100+50="+(num+num1));
		System.out.println(num+"+"+num1+"="+sum);
		long c = 100000000000000L;  // long 8바이트
		
		float f = 1.05f; //4바이트
		double d = 1.05; //8바이트
		char ch='A'; //문자하나(2바이트-홑따옴표)
		//char ch1= "A" ; //오류
	}
}
