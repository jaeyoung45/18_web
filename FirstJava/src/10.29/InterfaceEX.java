package examPac05;
interface PhoneInterface{
	final int TIMEOUT=10000;
	void sendCall();
	void receiveCall();
	default void printLogo(){ //default 메소드 버전 8부터 가능
		System.out.println("** Phone **");
	}
}
interface MobileInterface extends PhoneInterface{
	void sendSMS();
	void receiveSMS();
}
interface MP3Interface{
	void play();
	void stop();
}
class PDA{
	public int calculate(int x, int y) {
		return x+y;
	}
}
//클래스 상속 받고 인터페이스 다중(여러 개) 상속 받음
class SmartPhone extends PDA implements MobileInterface,MP3Interface{

	@Override
	public void sendCall() {
		System.out.println("sendCall");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("receiveCall");
		
	}

	@Override
	public void play() {
		System.out.println("play");

		
	}

	@Override
	public void stop() {
		System.out.println("stop");
		
	}

	@Override
	public void sendSMS() {
		System.out.println("sendSMS");

		
	}

	@Override
	public void receiveSMS() {
		System.out.println("receiveSMS");

		
	}
	
}
public class InterfaceEX {

	public static void main(String[] args) {
	SmartPhone s= new SmartPhone();
	s.printLogo();
	s.sendCall();
	s.sendSMS();
	s.play();
	System.out.println("3+5 ="+s.calculate(3, 5));
	}

}
