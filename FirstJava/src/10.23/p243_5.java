package objectArray;
import java.util.Scanner;
public class p243_5 {
	private double x, y;
	private int radius;
	public p243_5(double x, double y, int radius)  {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public void show() {
		System.out.println("("+x+","+y+")"+radius+"");
	}	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		p243_5 c [] = new p243_5[3];
		for(int i=0; i<c.length; i++) {
			System.out.print("x, y, radius >>");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			int radius = sc.nextInt();
			c[i]= new p243_5(x, y, radius);
		}
		for(int i=0; i<c.length; i++) {
			c[i].show();
		sc.close();
		}
	}
}
