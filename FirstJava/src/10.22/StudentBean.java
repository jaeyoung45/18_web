package chap04;

public class StudentBean {
	String name;
	int kor, eng, math;
	int tot;
	double avg;
	
	public StudentBean(String name, int kor, int eng, int math) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	//ÃÑÁ¡
	public int getTotal() {
		tot= kor+eng+math;
		return tot;
	}
	
	//Æò±Õ
	public double getAvg() {
		avg = tot/3;
		return avg;
	}
	
	
	public static void main(String[] args) {
	

	}

}
