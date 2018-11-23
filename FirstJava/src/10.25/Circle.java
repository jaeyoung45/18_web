package chap05;

public class Circle extends Shape {
	private int x;
	private int y;
	private int r;
	public Circle(int x, int y, int r) {
		super(x,y);
		this.r = r;
	}
	//��� -> x,y,r
	public void print() {
		super.print();
		System.out.println("\t������ :"+r);
	}
}
