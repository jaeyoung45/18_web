package chap05;

public class PointManger {
	private Shape[] arr = new Shape[10];
	private int cnt;
	
	public void inputData(int num) {
		System.out.println("�����Է�.....");
		System.out.print("x��ǥ");
		int x = PointMain.sc.nextInt();
		System.out.print("y��ǥ");
		int y = PointMain.sc.nextInt();
		if(num==1) { //��
			System.out.print("������ :");
			int r= PointMain.sc.nextInt();
			//Circle c = new Circle(x,y,r);
			arr[cnt] = new Circle(x,y,r);
			cnt++;
		}else if(num==2) {
			System.out.println("�� :");
			int w = PointMain.sc.nextInt();
			System.out.print("���� :");
			int h = PointMain.sc.nextInt();
			//Square s = new Square(x, y, h, w);
			arr[cnt] = new Square(x, y, h, w);
			cnt++;
		}
	
	}
	public void viewData() {
		for(int i=0; i<cnt; i++) {
			arr[i].print();
		}
	}
}
