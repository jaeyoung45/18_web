package objectArray;

import java.util.Scanner;

class Book{
	private String title;
	private String writer;
	public Book(String title, String writer) {
		this.title=title;
		this.writer=writer;
	}

//getter
public String getTitle() {
	return title;
}
public String getWrite() {
	return writer;
	}
}
public class BookMain {
	public static Scanner sc = new Scanner(System.in);
	Book[] arr = new Book[50];
	private int cnt;
//�޴�
public void showMenu() {
	System.out.println("�����ϼ���...");
	System.out.println("1. ������ �Է�");
	System.out.println("2. ��ü����");
	System.out.println("3. ����");
	System.out.println("���� :");
}
//������ �Է�
public void bookInsert() {
	System.out.println("������ �Է��ϼ���.....");
	System.out.println("å���� :");
	String title = sc.nextLine();
	System.out.println("å���� :");
	String writer = sc.nextLine();
	arr[cnt] = new Book(title,writer);
	cnt++;
}
//��ü����
public void bookList() {
	System.out.println("å ����Ʈ��......");
	for(int i=0; i<arr.length; i++) {
		if(arr[i]==null) break;
		System.out.println("å���� :"+arr[i].getTitle());
		System.out.println("å���� :"+arr[i].getWrite());
		System.out.println();
	}
}
	public static void main(String[] args) {
	
	BookMain bm = new BookMain();
	while(true) {
		bm.showMenu();
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:bm.bookInsert(); break;
		case 2:bm.bookList(); break;
		case 3:System.out.println("����");
				System.exit(0);
				break;
		default : System.out.println("�Է¿���");		
	}
	}
	}
}	
