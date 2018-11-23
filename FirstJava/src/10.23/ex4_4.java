package objectArray;

public class ex4_4 {
	String title;
	String author;
	
	public ex4_4(String title) {
		this.title = title;
		author = "작자미상";
		
	}
	public ex4_4(String title,String author) {
		this.title = title;
		this.author = author;
	}
	
	public static void main(String[] args) {
		ex4_4 b1 = new ex4_4("어린왕자","생텍쥐페리");
		ex4_4 b2 = new ex4_4("춘향전");
		System.out.println("책제목 :"+b1.title+"저자 :"+b1.author);
		System.out.println("책제목 :"+b2.title+"저자 :"+b2.author);
	
}

}
