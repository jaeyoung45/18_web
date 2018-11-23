package chap08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Exam10 {
	HashMap<String,String> map = new HashMap<>();
	
	private void read() {
		//파일로 부터 읽어서 map에 저장
		try {
			Scanner sc = new Scanner(new File("phone.txt"));
			while(sc.hasNext()) {
				String name = sc.next(); //이름
				String phone = sc.next(); //전화번호
				map.put(name, phone); //맵에 저장
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(map.size()+"개 전화번호 입력");
	}
	private void search() {
		//map 에서 입력한 내용이 있는지 검사
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("찾을 이름 >> 종료하려면 X");
			String name = scanner.next();
			if(name.toUpperCase().equals("X"))
				break;
			if(map.containsKey(name)) {
				System.out.println(map.get(name));
			}else {
				System.out.println("찾는 이름 없음");
			}
		}
		scanner.close();
	}
	
	
	public static void main(String[] args) {
		Exam10 exam = new Exam10();
		exam.read();
		exam.search();
		
	}
}
