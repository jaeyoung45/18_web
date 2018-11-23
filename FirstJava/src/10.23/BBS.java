package objectArray;

public class BBS {
	private String name;
	private String date;
	private String title;
	private String content;
	private static int no;
	public BBS(String name, String date, String title, String content) {
	this.name = name; //4번라인 = 5번라인
	this.date = date;
	this.title = title;
	this.content = content;
}
	public  void print() {
		System.out.println("글번호 :"+ ++BBS.no);
		System.out.println("저자 :"+ name); //4번라인 = 9번라인
		System.out.println("작성일 :"+ date);
		System.out.println("제목 :"+ title);
		System.out.println("내용 :"+ content);
		System.out.println();
	}
	
	public static void main(String[] args) {
		BBS b1 = new BBS("홍길동","2014","제목1","내용3");
		b1.print(); //글쓴이, 날짜, 제목, 내용
		BBS b2 = new BBS("이순신","2013","제목2","내용2");
		b2.print();
		BBS b3 = new BBS("강감찬","2012","제목3","내용1");
		b3.print();

	}

}
