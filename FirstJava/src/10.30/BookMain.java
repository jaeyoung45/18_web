package chap07;

import java.util.Scanner;
import java.util.Vector;

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
	Vector<Book> vc = new Vector<Book>();
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
	Book b = new Book(title,writer);
	vc.add(b);
}
//전체보기
public void bookList() {
	System.out.println("책 리시트는......");
	for(int i=0; i<vc.size(); i++) {
		
		System.out.println("책제목 :"+vc.get(i).getTitle());
		System.out.println("책저자 :"+vc.elementAt(i).getWrite());
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
