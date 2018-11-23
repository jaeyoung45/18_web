package chap05;


class Point{
	private int x, y;
	public void set(int x, int y) {
		this.x = x; this.y =y;
	}
	public void showPoint() {
		System.out.println("(" +x+","+y+")");
	}
}	
	class ColorPoint extends Point{
		private String color;
		public void setColor(String color) {
			this.color = color;
		}
		public void showPoint() {
			System.out.print(color);
			super.showPoint(); //super, super()
		}
	}

	
	public class ColorPointEx {
		public static void main(String [] args) {
			Point p = new Point();
			p.set(1, 2);
			p.showPoint();
			
	ColorPoint cp = new ColorPoint(); 
	cp.set(3, 4);
	cp.setColor("red");
	cp.showPoint();
	
	Point p1 = new ColorPoint() ;
	p1.set(5, 6);
	//p1.setColor("black");
	p1.showPoint();
	}
}
