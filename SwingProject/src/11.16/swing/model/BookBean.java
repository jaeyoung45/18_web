package swing3.model;

import java.util.ArrayList;

public class BookBean {	
	private int num;
	private String title;
	private String writer;
	private String indate;
	private String outdate;
	private String gubun;
	private int price;
	
	//getter
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public String getIndate() {
		return indate;
	}
	public String getOutdate() {
		return outdate;
	}
	public String getGubun() {
		return gubun;
	}
	public int getPrice() {
		return price;
	}
	//setter
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void bookInsert(BookBean b) {
		
	}
	public ArrayList<BookBean> BookView() {
		return null;
	}

	
}
