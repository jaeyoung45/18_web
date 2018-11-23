package objectArray;

	class One{
		private int r;
		
		public One(int r) {
			this.r = r;
		}
		public double getArea() {
			return r*r*3.14;
		}
	}
	public class CircleMain {
	public static void main(String[] args) {
		One[] arr= new One[5];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new One(i);
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].getArea());
		}

	}
}


