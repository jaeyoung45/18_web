package examPac05;

public class Won2Dollar extends Converter {
	public Won2Dollar(int don) {
		super.ratio=don;
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return src/ratio;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "¿ø";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "´Þ·¯";
	}
}	
		
	

