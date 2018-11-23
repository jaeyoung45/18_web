package objectArray;

import java.util.Scanner;

class Exam{
	private double x, y;
	private int radius;
	public Exam(double x, double y, int radius) {
		this.x= x;
		this.y= y;
		this.radius = radius;
	}
	public void show() {
		System.out.println("("+x+","+y+")" + radius);
	}
	public int  getRadius() { //������ getter
		return radius;
	}
}

public class Exam05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Exam c[] = new Exam[3];
		for(int i = 0 ;i<c.length;i++) {
			System.out.print("x,y,radius>>");
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int radius = scanner.nextInt();
			c[i] = new Exam(x,y,radius);
		}
		for(int i=0; i<c.length;i++)
			c[i].show();
		//��������� ū �� ���ϱ�
		int max = c[0].getRadius();
		int maxPos = 0;
		for(int i =1;i<c.length;i++) {
			if(c[i].getRadius()> max) {
				max= c[i].getRadius();
				maxPos = i;
			}
		}
		System.out.println("���� ū ������ :" + max);
		System.out.println("���� ������ ū �� : ");
		c[maxPos].show();
		
		
		scanner.close();

	}

}
