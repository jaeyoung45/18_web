package examPac05;

public class PointMain {

	public static void main(String[] args) {
		System.out.println("-----5��-----");
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10,20);
		cp.setColor("RED");
		String str = cp.toString();
		System.out.println(str+"�Դϴ�.");
	
		System.out.println("-----6��-----");
	ColorPoint zeroPoint = new ColorPoint();
	System.out.println(zeroPoint.toString()+"�Դϴ�.");
	
	ColorPoint cp2 = new ColorPoint(10, 10);
	cp2.setXY(5, 5);
	cp2.setColor("RED");
	System.out.println(cp2.toString()+"�Դϴ�.");
	
	System.out.println("-----7��-----");
	Point3D p = new Point3D(1,2,3);
	System.out.println(p.toString() + "�Դϴ�.");
	
	p.moveUp();
	System.out.println(p.toString() + "�Դϴ�.");
	p.moveDown();
	p.move(10, 10);
	System.out.println(p.toString() + "�Դϴ�.");
	
	p.move(100, 200, 300);
	System.out.println(p.toString() + "�Դϴ�.");
	
	System.out.println("-----8��-----");
	PositivePoint po = new PositivePoint();
	po.move(10, 10);
	System.out.println(po.toString() + "�Դϴ�.");
	
	po.move(-5, 5);
	System.out.println(po.toString() + "�Դϴ�.");
	
	PositivePoint p2 = new PositivePoint(-10, -10);
	System.out.println(p2.toString() + "�Դϴ�.");
	}
}
