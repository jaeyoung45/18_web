package objectArray;

public class BBS {
	private String name;
	private String date;
	private String title;
	private String content;
	private static int no;
	public BBS(String name, String date, String title, String content) {
	this.name = name; //4������ = 5������
	this.date = date;
	this.title = title;
	this.content = content;
}
	public  void print() {
		System.out.println("�۹�ȣ :"+ ++BBS.no);
		System.out.println("���� :"+ name); //4������ = 9������
		System.out.println("�ۼ��� :"+ date);
		System.out.println("���� :"+ title);
		System.out.println("���� :"+ content);
		System.out.println();
	}
	
	public static void main(String[] args) {
		BBS b1 = new BBS("ȫ�浿","2014","����1","����3");
		b1.print(); //�۾���, ��¥, ����, ����
		BBS b2 = new BBS("�̼���","2013","����2","����2");
		b2.print();
		BBS b3 = new BBS("������","2012","����3","����1");
		b3.print();

	}

}
