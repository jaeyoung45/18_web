package examPac05;

public class PointMain {

	public static void main(String[] args) {
		System.out.println("-----5번-----");
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10,20);
		cp.setColor("RED");
		String str = cp.toString();
		System.out.println(str+"입니다.");
	
		System.out.println("-----6번-----");
	ColorPoint zeroPoint = new ColorPoint();
	System.out.println(zeroPoint.toString()+"입니다.");
	
	ColorPoint cp2 = new ColorPoint(10, 10);
	cp2.setXY(5, 5);
	cp2.setColor("RED");
	System.out.println(cp2.toString()+"입니다.");
	
	System.out.println("-----7번-----");
	Point3D p = new Point3D(1,2,3);
	System.out.println(p.toString() + "입니다.");
	
	p.moveUp();
	System.out.println(p.toString() + "입니다.");
	p.moveDown();
	p.move(10, 10);
	System.out.println(p.toString() + "입니다.");
	
	p.move(100, 200, 300);
	System.out.println(p.toString() + "입니다.");
	
	System.out.println("-----8번-----");
	PositivePoint po = new PositivePoint();
	po.move(10, 10);
	System.out.println(po.toString() + "입니다.");
	
	po.move(-5, 5);
	System.out.println(po.toString() + "입니다.");
	
	PositivePoint p2 = new PositivePoint(-10, -10);
	System.out.println(p2.toString() + "입니다.");
	}
}
