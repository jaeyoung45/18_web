package chap13_thread;

public class GuguRunnable implements Runnable{
	private int dan;
	public GuguRunnable(int dan) {
		this.dan = dan;
	}
	@Override
	public void run() {
		for(int i=1; i<10; i++) {
			System.out.println(dan +"*"+i+"="+dan*i);
		}
		
	}
	public static void main(String[] args) {
		GuguRunnable gr1 = new GuguRunnable(3);
		GuguRunnable gr2 = new GuguRunnable(6);
		GuguRunnable gr3 = new GuguRunnable(9);
		Thread t1 = new Thread(gr1);
		Thread t2 = new Thread(gr2);
		Thread t3 = new Thread(gr3);
		t1.start();
		t2.start();
		t3.start();

	}
}