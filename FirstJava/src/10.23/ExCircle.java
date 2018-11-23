package objectArray;

public class ExCircle {
	private int r;
	public ExCircle(int r) {
		this.r =r;
	}
	public double getArea() {
		//System.out.println("¸éÀû :" +r*r*3.14);
		return r*r*3.14;
	}
	
	public static void main(String[] args) {
		ExCircle[] arr = new ExCircle[5];
		/*Circle c1 = new Circle(0);
		Circle c2 = new Circle(1);
		Circle c3 = new Circle(2);
		Circle c4 = new Circle(3);
		Circle c5 = new Circle(4);*/
		//ExCircle[] arr = new ExCircle[5];
		for(int i=0; i<5; i++) {
			arr[i]= new ExCircle(i);
	}
		for(int i=0; i<arr.length; i++) {
		System.out.println((arr[i].getArea()));
		/*c1.getArea();
		c2.getArea();
		c3.getArea();
		c4.getArea();
		c5.getArea();*/
		
			//arr[i].getArea();
			
		}
	}

}
