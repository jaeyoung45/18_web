package examPac05;

public class GCalc implements Cal{
	public static void main(String[] args) {
		GoodCalc c= new GoodCalc();
		//Cal cc = new Cal();
		Cal cc = new GCalc();
		System.out.println(c.add(2,3));
		System.out.println(c.subtract(2,3));
		System.out.println(c.average(new int [] {2,3,4}));
	
	
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double average(int[] a) {
		// TODO Auto-generated method stub
		int hap = 0;
		for(int i:a) {
			hap +=i;
		}
		return hap/a.length;
	}

}
