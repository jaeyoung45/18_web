package examPac05;

public class ConverterMain {

	public static void main(String args[]) {
		Won2Dollar toDollar = new Won2Dollar(1200);
		toDollar.run();

		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();
		
		Cm2Inch toInch = new Cm2Inch(2.5);
		toInch.run();
 }
}

	
	
	

