package examPac07;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CapitalApp {
	static Scanner sc = new Scanner(System.in);
	private HashMap<String, String> map = new HashMap<>();
	CapitalApp(){
		map.put("한국", "서울");
		map.put("일본", "동경");
		map.put("중국", "베이징");
		map.put("호주", "시드니");
		map.put("멕시코", "멕시코시티");
		map.put("북한", "평양");
		map.put("영국", "런던");
		map.put("프랑스", "파리");
		map.put("독일", "베를린");
	}
	public static void showMenu() {
		System.out.println("**** 수도 맞추기 게임을 시작합니다.****");
			System.out.print("입력:1,퀴즈:2,종료:3>>");
	}
	public void input() {
		int n= map.size();
		System.out.println("현재 "+map.size()+"개 나라와 수도 입력");
		System.out.println("종료하려면  X");
		n++;
		while(true) {
			System.out.println("나라와 수도 입력 "+n+">>");
			String str = sc.next(); //나라
			if(str.toUpperCase().equals("X"))
				break;
			if(map.containsKey(str)) { //입력한 나라가 있으면
				System.out.println("이미 입력한 나라입니다.");
				continue;
			}
			String str1 = sc.next(); //수도
			map.put(str, str1);
			n++;
		}
	}
	public void test()  {
		Set<String> set = map.keySet();
		Object[] arr = set.toArray(); //set 형을 배열로 변환
		while(true) {
			int n = (int)(Math.random()*map.size()); //랜덤위치 구하기
			String city= (String)arr[n]; //나라
			String dosi= map.get(city); //도시
			
			//문제출력
			System.out.println(city+"의 수도는 ? 종료하려면 X");
			String dap = sc.next();
			if(dap.toUpperCase().equals("X"))
				break;
			if(dosi.equals(dap)) {
				System.out.println("정답");
			}else {
				System.out.println("틀렸습니다.!!!!");
			}
		}
	}
	public static void main(String[] args) {
		CapitalApp ca = new CapitalApp();
		while(true) {
			CapitalApp.showMenu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1:ca.input(); break;
			case 2:ca.test(); break;
			case 3:System.out.println("종료");
			System.exit(0);
			default : System.out.println("입력오류");
			}
		}
		

	}

}
