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
	}
}
