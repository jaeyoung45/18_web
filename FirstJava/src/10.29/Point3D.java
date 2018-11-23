package examPac05;

public class Point3D extends Point{
	private int z;
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
 }
	public void moveUp() {
		z++; //z�� ����	
	}
	public void moveDown() {
		z--; //z�� ����
	}
	public void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}
	public String toString() {
		return "("+getX()+","+getY()+","+z+")�� ��";
	}

}

