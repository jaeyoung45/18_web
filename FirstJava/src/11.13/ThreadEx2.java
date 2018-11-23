package chap13_thread;
/*
 * ������ ����  
 * */

public class ThreadEx2 extends Thread{ //Thread�� ��ӹް�
	private int dan;
	public ThreadEx2(int dan) {
		this.dan = dan;
	}
	public void run() { //run �Լ� �����ؾ� ��.
		for(int i=1; i<10; i++) {
			System.out.println(dan+"*"+i+"="+dan*i);
		}
	}
	public static void main(String[] args) {
		ThreadEx2 t1 = new ThreadEx2(5);
		ThreadEx2 t2 = new ThreadEx2(7);
		ThreadEx2 t3 = new ThreadEx2(3);
		t1.start(); //start �Լ��� ���
		t2.start();
		t3.start();

	}

}
