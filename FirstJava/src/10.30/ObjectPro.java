package chap06;
class Point{
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	
	}
public String toString() {
	return "("+x+","+y+")";
 }

public boolean equals(Object obj) {
	//두 좌표가 같으면 같은걸로
	Point p = (Point)obj;
	if(x == p.x && y == p.y)
		return true;
	else return false;
  }
}
public class ObjectPro {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		Point p = new Point(2,3);
		print(p);
		Point p1 = new Point(2,3);
		Point p2 = new Point(2,3);
		Point p3 = new Point(2,3);
		if(p==p1) { //주소 비교
			System.out.println("a==b");
		}
		if(p.equals(p1)) { //내용 비교
			System.out.println("p equals p1");	
		}
		if(p.equals(p2)) {
			System.out.println("p equals p2");
		}
	}
}
