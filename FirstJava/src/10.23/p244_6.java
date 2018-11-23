package objectArray;
import java.util.Scanner;
public class p244_6 {
	private double x, y;
	private int radius;
	public p244_6(double x, double y, int radius)  {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public void show() {
		System.out.println("("+x+","+y+")"+radius+"");
		System.out.print("���� ������ ū �� ��?");
	}	
	public int getRadius() { //������ getter
		return radius;
	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		p244_6 arr [] = new p244_6[3];
		for(int i=0; i<arr.length; i++) {	
			System.out.print("���� ������ ū �� ��");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			int radius = sc.nextInt();
			arr[i]= new p244_6(x, y, radius);
		}
		for(int i=0; i<arr.length; i++) {
			arr[i].show();
		//���� ������ ū �� ���ϱ�
			int max = arr[0].getRadius();
			int maxPos = 0;
			for(int i=1;i<arr.length;i++) {
				if(arr[i].getRadius()>max) {
					max = arr[i].getRadius();
					maxPos = i;
				}
			}
			System.out.println("���� ū ������ :"+max);
			System.out.println("���� ū �� :");
			arr[maxPos].show();
		}
	}
}
