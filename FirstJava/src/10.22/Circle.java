package chap04;

public class Circle {
	String name;
	int r;
	public Circle() {
	}
	public Circle(int r) {
		this.r=r;
	}
	public Circle(String name, int r) {
		this.name=name;
		this.r=r;
	}
	//면적을 알려주는 메소드
	public void getArea() {
		System.out.println(name +"면적 :"+(r*r*3.14));
	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.name= "피자";
		c1.r = 10;
		c1.getArea();
		Circle c2 = new Circle();
		c2.name= "도넛";
		c2.r = 2;
		c2.getArea();
		Circle c3= new Circle(5);
		c3.name="케익";
		c3.getArea();
		Circle c4= new Circle("김치전", 15);
		c4.getArea();		
	}
}
