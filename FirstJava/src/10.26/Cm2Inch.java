package examPac05;

public class Cm2Inch extends Converter {
		public Cm2Inch(double ratio) {
			this.ratio= ratio;
		}

		@Override
		protected double convert(double src) {
			// TODO Auto-generated method stub
			return src/ratio;
		}
		@Override
		protected String getSrcString() {
			// TODO Auto-generated method stub
			return "cm";
		}
		@Override
		protected String getDestString() {
			// TODO Auto-generated method stub
			return "inch";
		}

		}



