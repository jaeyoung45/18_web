package objectArray;
import java.util.Scanner;
public class BookMaker {
	private String title;
	private String author;
	public void Book(String title, String author) {
		this.title= title;
		this.author = author;
		author = "���ڹ̻�";
	}
//public class BookMaker {
	public static void main(String[] args) {
		ex4_4 [] book = new ex4_4[2];
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<book.length; i++) {
			System.out.print("å����>>");
			String title = sc.next();
			System.out.print("������>>");
			String author = sc.next();
			book[i] = new ex4_4(title, author);
			
		}

		for(int i=0; i<book.length; i++)
			System.out.print("("+book[i].title+","+book[i].author+")");
		sc.close();
	}

}
