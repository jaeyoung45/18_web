package chap05;

public class Square extends Shape {
	private int x;
	private int y;
	private int width;
	private int height;
	public Square(int x, int y, int h, int w) {
		super(x, y);
		this.height =h;
		this.width =w;
	}
	//��� ->x, y, width, height
	public void print() {
		super.print();
		System.out.println("\t �� :"+width+"���� :"+height);
	}
}
