package examPac05;

public class ColorPoint extends Point {
	private String color;
	//�����ε�
	public ColorPoint() {
		super(0,0);
		color="BLACK";
	}
	public ColorPoint(int x,int y) {
		super(x,y);
		color="BLACK";
	}
	public ColorPoint(int x,int y,String color) {
		super(x, y);
		this.color=color;
	}
	public void setXY(int x, int y) {
		move(x,y);
		
	}
	public void setColor(String color) {
		this.color=color;
	}
	//RED���� (10,20)�� ���Դϴ�. 
	//�������̵�
	public String toString() {
		return color+"����("+getX()+","+getY()+")�� ��";
	}
}
