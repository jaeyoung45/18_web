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
//메뉴
public void showMenu() {
	System.out.println("선택하세요...");
	System.out.println("1. 데이터 입력");
	System.out.println("2. 전체보기");
	System.out.println("3. 종료");
	System.out.println("선택 :");
}
//데이터 입력
public void bookInsert() {
	System.out.println("데이터 입력하세요.....");
	System.out.println("책제목 :");
	String title = sc.nextLine();
	System.out.println("책저자 :");
	String writer = sc.nextLine();
	arr[cnt] = new Book(title,writer);
	cnt++;
}
//전체보기
public void bookList() {
	System.out.println("책 리시트는......");
	for(int i=0; i<arr.length; i++) {
		if(arr[i]==null) break;
		System.out.println("책제목 :"+arr[i].getTitle());
		System.out.println("책저자 :"+arr[i].getWrite());
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
		case 3:System.out.println("종료");
				System.exit(0);
				break;
		default : System.out.println("입력오류");		
	}
	}
	}
}	
