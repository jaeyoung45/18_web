package chap13_thread;

public class SaramRunnable implements Runnable{
	private String name;
	public SaramRunnable(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		SaramRunnable sr1 = new SaramRunnable("홍길동");
		SaramRunnable sr2 = new SaramRunnable("이순신");
		SaramRunnable sr3 = new SaramRunnable("강감찬");
		Thread t1 = new Thread(sr1);
		Thread t2 = new Thread(sr2);
		Thread t3 = new Thread(sr3);
		t1.start();
		t2.start();
		t3.start();
	}
	@Override
	public void run() {
		for(int i=1; i<5; i++) {
		System.out.println(name+ "말한다.");
	try {
		Thread.sleep(1000);
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
		}
	}
}
		

		
