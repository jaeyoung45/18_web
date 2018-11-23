package chap09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ConsoleBank {

	public static void main(String[] args) {
		String name;
		int money;
		HashMap<String,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("1.계좌생성 2.입/출금 3.확인/파일저장");
		int num =sc.nextInt();
		if(num==1) {
			System.out.println("이름을입력하세요>>");
			name = sc.next();
			money = 0;
			map.put(name, 0);
			
		}else if(num==2) {
			System.out.println("1. 입금 2.출금");
			int su = sc.nextInt();
			if(su==1) {
				System.out.println("이름은?");
				name = sc.next();
				if(map.containsKey(name)) {
				System.out.println("입금금액>>");
				int don=sc.nextInt();
				map.put(name,map.get(name)+don);
				}else {System.out.println("없는 계좌입니다.");}
			}else if(su==2) {
				System.out.println("이름은?");
				name = sc.next();
				if(map.containsKey(name)) {
				System.out.println("출금금액>>");
				int don=sc.nextInt();
				map.put(name,map.get(name)-don);
				}else {System.out.println("없는 계좌입니다.");}
			}else {System.out.println("다시입력하세요"); return;}
		}else if(num==3) {
			File dir = new File("src\\chap09");
			File file = new File(dir,"myBank.txt");
			System.out.println(map);
			try {
				FileWriter tw = new FileWriter(file);
				Set<String> keys = map.keySet(); // 모든 키를 가진 셋 컬렉션 리턴
				Iterator<String> it = keys. iterator();
				while(it.hasNext()) {
					name = it.next().trim();
					money = map.get(name);
					tw.write(name+":"+money+"\n");
					}
				tw.close();
				}catch(FileNotFoundException f) {
					new MessageBox("파일저장오류!","파일없음");
					f.printStackTrace(); 
			    } catch (IOException e1) {
					e1.printStackTrace();
			    }
			}
		}
	}
}
