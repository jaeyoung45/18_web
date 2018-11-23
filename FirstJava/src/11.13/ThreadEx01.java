package chap13_thread;
/*
 * 쓰레드 예제  
 * */

public class ThreadEx01 {
	private int dan;
	public ThreadEx01(int dan) {
		this.dan = dan;
	}
	public void cal() {
		for(int i=1; i<10; i++) {
			System.out.println(dan+"*"+i+"="+dan*i);
		}
	}
	
	
	public static void main(String[] args) {
		ThreadEx01 t1 = new ThreadEx01(5);
		ThreadEx01 t2 = new ThreadEx01(7);
		ThreadEx01 t3 = new ThreadEx01(3);
		t1.cal();
		t2.cal();
		t3.cal();

	}

}
