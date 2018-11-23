package chap06;

import java.util.Scanner;
public class P386_8 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("문장 입력...");
	String sr = sc.nextLine();
//	for(int i=0; i<sr.length(); i++) {
//		String f = sr.substring(0,1);
//		String res = sr.substring(1);
//		sr = res+f;
//		System.out.println(sr);
//	}
	for(int i=0; i<sr.length(); i++) {
		//char f = sr.charAt(0); charAt()를 사용해도 결과 값은 같음.
		String f = String.valueOf(sr.charAt(0));
		String res = sr.substring(1);
		sr = res+f;
		System.out.println(sr);
	}
	}
}	
