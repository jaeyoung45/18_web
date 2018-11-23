package objectArray;
import java.util.Scanner;
public class BookMaker {
	private String title;
	private String author;
	public void Book(String title, String author) {
		this.title= title;
		this.author = author;
		author = "작자미상";
	}
//public class BookMaker {
	public static void main(String[] args) {
		ex4_4 [] book = new ex4_4[2];
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<book.length; i++) {
			System.out.print("책제목>>");
			String title = sc.next();
			System.out.print("지은이>>");
			String author = sc.next();
			book[i] = new ex4_4(title, author);
			
		}

		for(int i=0; i<book.length; i++)
			System.out.print("("+book[i].title+","+book[i].author+")");
		sc.close();
	}

}
