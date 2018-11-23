package chap05;

public class Circle extends Shape {
	private int x;
	private int y;
	private int r;
	public Circle(int x, int y, int r) {
		super(x,y);
		this.r = r;
	}
	//출력 -> x,y,r
	public void print() {
		super.print();
		System.out.println("\t반지름 :"+r);
	}
}
