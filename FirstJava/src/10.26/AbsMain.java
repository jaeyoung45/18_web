package examPac05;

public class AbsMain {

	public static void main(String[] args) {
		//AbsProduct absP = new AbsProduct();
		AbsComputer com = new AbsComputer();
		com.turnOn();
		com.turnOff();
		
		AbsProduct com1 = new AbsComputer();
		com1.turnOn();
		com1.turnOff();
		com1.print();
	}

}
