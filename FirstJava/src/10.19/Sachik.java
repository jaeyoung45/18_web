package chap04;

public class Sachik {

	//����
	public void sum(int a, int b) {
	System.out.println(a+"+"+b+"="+(a+b));	
	}
	
	//����
	public void sub(int a, int b) {
	System.out.println(a+"-"+b+"="+(a-b));	
	
	}
	
	//����
	public void mul(int a, int b) {
	System.out.println(a+"*"+b+"="+(a*b));	
		
	}
	
	//������
	public void div(int a, int b) {
	System.out.println(a+"/"+b+"="+(a/b));	
		
	}
	
	public static void main(String[] args) {
		Sachik s1 = new Sachik();
		s1.sum(10, 5);
		s1.sub(10, 5);
		s1.mul(10, 5);
		s1.div(10, 5);
	}

}
