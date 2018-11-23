package chap09;

import java.util.Scanner;

public class ConsoleGugudan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단을 입력하세요.");
		
		int dan = sc.nextInt();
		for(int i=1; i<=9; i++) {
			System.out.println(dan+"*"+i+"="+dan*i+"\n");
		}
		

	}

}
