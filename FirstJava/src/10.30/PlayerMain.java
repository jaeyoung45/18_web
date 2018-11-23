package chap07;

import java.util.ArrayList;
import java.util.Scanner;
class Player{
	private String name;
	private String address;
	private int age;
	private double height;
	private double weight;
	
	//생성자
	public Player() {
	
	}
   public Player(String name, String address, int age, double height, double weight) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
//getter
public String getName() {
	return name;
}
public String getAddress() {
	return address;
}
public int getAge() {
	return age;
}
public double getHeight() {
	return height;
}
public double getWeight() {
	return weight;
}
//setter
public void setName(String name) {
	this.name = name;
}
public void setAddress(String address) {
	this.address = address;
}
public void setAge(int age) {
	this.age = age;
}
public void setHeight(double height) {
	this.height = height;
}
public void setWeight(double weight) {
	this.weight = weight;
}

  
	
}
class PlayerManager{
/*	선수등록(insertData),
	-전체보기(viewData),
	-선수찾기(searchData)*/
	
	ArrayList<Player> alist = new ArrayList<Player>();
	private int cnt;
	public void insertData() {
		System.out.println("선수등록....");
		System.out.print("이름>>"); //홍길동
		String name = PlayerMain.sc.next();
		System.out.print("주소>>");
		String addr = PlayerMain.sc.next();
		System.out.print("나이>>");
		int  age = PlayerMain.sc.nextInt();
		System.out.print("몸무게>>");
		double  w = PlayerMain.sc.nextDouble();
		System.out.print("키>>");
		double h = PlayerMain.sc.nextDouble();
	//	arr[cnt] = new Player(name,addr,age,w,h);
		Player p = new Player();
		p.setAddress(addr);
		p.setAge(age);
		p.setHeight(h);
		p.setName(name);
		p.setWeight(w);
		alist.add(p);

	}
	public void viewData() {
		System.out.println("데이터전체보기");
//		for(int i=0; i<alist.size();i++) { //i<cnt
//				//이름 , 나이
//				System.out.println("이름 : " + (alist.get(i)).getName());
//				System.out.println("나이 : " + (alist.get(i)).getAge());
//		}
//	}
		for(Player p : alist) {
			System.out.println("이름 :"+p.getName());
			System.out.println("나이 :"+p.getAge());
		}
	}
	public void searchData() {//같은이름 없음
		System.out.println("선수찾기");
		System.out.print("선수 이름 : ");
		String name = PlayerMain.sc.next();
		Player p = seach(name);
		if(p==null) {
			System.out.println("찾는 선수 없음");
			return;
		}
		//이름, 나이, 키, 몸무게
	    System.out.println("이름 : "+p.getName());
	    System.out.println("나이 : "+p.getAge());
	    System.out.println("키 : "+p.getHeight());
	    System.out.println("몸무게 : "+p.getWeight());
	}
	private Player seach(String name) {
		for(int i=0;i<alist.size();i++) {
			if((alist.get(i)).getName().equals(name)){
				return alist.get(i);
			}//if
		}//for
		return null;
	}
}

public class PlayerMain {
	public static Scanner sc = new Scanner(System.in);
	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 전체보기");
		System.out.println("3. 선수찾기");
		System.out.println("4. 종료");
		System.out.print("선택 : ");
	}
	public static void main(String[] args) {
		PlayerManager pm =new PlayerManager();
		while(true){
			PlayerMain.showMenu();
			int choice = PlayerMain.sc.nextInt();
			PlayerMain.sc.nextLine();
			switch(choice){
			case 1: pm.insertData();break;
			case 2: pm.viewData();break;
			case 3: pm.searchData();break;
			case 4:System.out.println("종료");
					System.exit(0);
					break;
			default:System.out.println("입력오류");;	
			}
		}

	}

}
