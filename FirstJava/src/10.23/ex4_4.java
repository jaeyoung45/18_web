package objectArray;

public class ex4_4 {
	String title;
	String author;
	
	public ex4_4(String title) {
		this.title = title;
		author = "���ڹ̻�";
		
	}
	public ex4_4(String title,String author) {
		this.title = title;
		this.author = author;
	}
	
	public static void main(String[] args) {
		ex4_4 b1 = new ex4_4("�����","�������丮");
		ex4_4 b2 = new ex4_4("������");
		System.out.println("å���� :"+b1.title+"���� :"+b1.author);
		System.out.println("å���� :"+b2.title+"���� :"+b2.author);
	
}

}
