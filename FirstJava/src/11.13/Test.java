package chap09;

public class Test {

	public static void main(String[] args) {
		int x = 10, y=2 , z=2;
		z=++x/y;
		System.out.println("x :"+x); //11
		System.out.println("y :"+y); //2 
		System.out.println("z :"+z); //5
		System.out.println("------");
		
		x*=y+1;
		System.out.println("x :"+x); //33 x=11*3=33
		System.out.println("y :"+y); //2 
		System.out.println("z :"+z); //5
		System.out.println("------");
		
		z=++x + y++;
		System.out.println("x :"+x); //34
		System.out.println("y :"+y); //2 (3) 
		System.out.println("z :"+z); //36
		System.out.println("------");
		
		int[] a= {1,2,3,4,5,6};
		int i = a.length-1; //5
		while(i>=0) {
			System.out.println(a[i]);
			i--;
		}
		String city="����";
		String country="";
		switch(city) {
		case"����":
		case"�λ�": country="�ѱ�";
		case"�ϰ�": country="�߱�";
		case"����": country="�Ϻ�"; break;
		default : country="������";
		}
		System.out.println(country);
	
	Account account = new Account();
	try {
		account.withdraw(0);
		System.out.println("b");
	}catch(Exception e) {
		System.out.println("c");
	}finally {
		System.out.println("d");
	}
	System.out.println("e");
	}
}
class Account{
	public void withdraw(int money)throws Exception{
		if(money<=0) throw new Exception();
		System.out.println("a");
	}

}
