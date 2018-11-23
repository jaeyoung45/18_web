package chap13_thread;

public class SaramThread extends Thread{
	private String name;
	public SaramThread(String name) {
		this.name = name;
	}
@Override
public void run() {
	for(int i=0; i<5; i++) {
		System.out.println(name+ " 말한다.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	public static void main(String[] args) {
		SaramThread st1 = new SaramThread("홍길동");
		SaramThread st2 = new SaramThread("이순신");
		SaramThread st3 = new SaramThread("강감찬");
		st1.start();
		st2.start();
		st3.start();
	}

}
