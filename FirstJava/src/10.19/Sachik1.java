package chap04;

public class Sachik1 {
	int a; //¸â¹öº¯¼ö
	int b;
	//µ¡¼À
	public void sum() {
	System.out.println(a+"+"+b+"="+(a+b));	
	}
	
	//»¬¼À
	public void sub() {
	System.out.println(a+"-"+b+"="+(a-b));	
	
	}
	
	//°ö¼À
	public void mul() {
	System.out.println(a+"*"+b+"="+(a*b));	
		
	}
	
	//³ª´°¼À
	public void div() {
	System.out.println(a+"/"+b+"="+(a/b));	
		
	}
	
	public static void main(String[] args) {
		Sachik1 s1 = new Sachik1();
		s1.a = 100;
		s1.b = 50;
		s1.sum();
		s1.sub();
		s1.mul();
		s1.div();
	}

}
