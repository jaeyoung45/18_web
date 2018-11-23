package chap07;

import java.util.ArrayList;
import java.util.Scanner;
class Player{
	private String name;
	private String address;
	private int age;
	private double height;
	private double weight;
	
	//������
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
/*	�������(insertData),
	-��ü����(viewData),
	-����ã��(searchData)*/
	
	ArrayList<Player> alist = new ArrayList<Player>();
	private int cnt;
	public void insertData() {
		System.out.println("�������....");
		System.out.print("�̸�>>"); //ȫ�浿
		String name = PlayerMain.sc.next();
		System.out.print("�ּ�>>");
		String addr = PlayerMain.sc.next();
		System.out.print("����>>");
		int  age = PlayerMain.sc.nextInt();
		System.out.print("������>>");
		double  w = PlayerMain.sc.nextDouble();
		System.out.print("Ű>>");
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
		System.out.println("��������ü����");
//		for(int i=0; i<alist.size();i++) { //i<cnt
//				//�̸� , ����
//				System.out.println("�̸� : " + (alist.get(i)).getName());
//				System.out.println("���� : " + (alist.get(i)).getAge());
//		}
//	}
		for(Player p : alist) {
			System.out.println("�̸� :"+p.getName());
			System.out.println("���� :"+p.getAge());
		}
	}
	public void searchData() {//�����̸� ����
		System.out.println("����ã��");
		System.out.print("���� �̸� : ");
		String name = PlayerMain.sc.next();
		Player p = seach(name);
		if(p==null) {
			System.out.println("ã�� ���� ����");
			return;
		}
		//�̸�, ����, Ű, ������
	    System.out.println("�̸� : "+p.getName());
	    System.out.println("���� : "+p.getAge());
	    System.out.println("Ű : "+p.getHeight());
	    System.out.println("������ : "+p.getWeight());
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
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ��ü����");
		System.out.println("3. ����ã��");
		System.out.println("4. ����");
		System.out.print("���� : ");
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
			case 4:System.out.println("����");
					System.exit(0);
					break;
			default:System.out.println("�Է¿���");;	
			}
		}

	}

}
