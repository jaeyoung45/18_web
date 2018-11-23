package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest03 {
	public static void main(String[] args) {
		HashMap <String,String> hm = new HashMap<String,String>();
		Scanner sc = new Scanner(System.in);
		hm.put("java", "1111");
		hm.put("oracle", "1234");
		hm.put("jsp", "abcd");
		System.out.println("id/password를 입력하세요");
		System.out.println("id :");
		String id = sc.next();
		
		//입력하신 id가 없습니다.
		if(hm.containsKey(id)==false) {
			System.out.println("입력하신 id가 없습니다.");
			return;
		}
		System.out.println("password :");
		String pwd = sc.next();
		if(!hm.get(id).equals(pwd)){ //비밀번호가 일치하지 않습니다.
			System.out.println("비밀번호가 일치하지 않습니다.");
		}else { //id/password가 일치합니다.
			System.out.println("모두 일치");
		}	
	}
}
