package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest02 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("단어입력... 종료는 X");
			String str = sc.next();
			if(str.toUpperCase().equals("X")) break;
			//int value;
//			if(map.get(str)==null) { //값이 없을때
//				value = 1;
//			}else { //값이 있을때
//				value = map.get(str) +1;
//			}
//			map.put(str, value);
			map.put(str, map.get(str)==null?1:map.get(str)+1); //3항 연산자
			
		
		}//while
		System.out.println(map);
	}

}
