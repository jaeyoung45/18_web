package chap04;

public class Student {
	String name;
	int kor;
	int eng;
	int math;
	//������ (������� �� �ʱ�ȭ <- �Ҵ�)
	//������ �����ε�
	public Student() { //������ ���� Ŭ������, void ����� ��.
		
	}
	public Student(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		math = m;
	}
	public int getTotal() {
		return kor+eng+math;
	}
	public int getAvg() {
		return (kor+eng+math)/3;
	}	
	public void printScore() {
		System.out.println(name +"���� ���� : "+getTotal()+ "��� : "+getAvg());
	}
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name="ȫ�浿";
		s1.kor=100;
		s1.eng=80;
		s1.math=70;
		
		s1.getTotal(); //����
		s1.getAvg(); //���
		s1.printScore(); //������� <- ȫ�浿 ���� : ???, ��� : ???
		
		Student s2 = new Student(); //����&����
		s2.name="������";
		s2.kor=100;
		s2.eng=85;
		s2.math=55;
		
		s2.printScore();
		
		Student s3;  //����
		//����Ʈ ������ <- ���ڰ� ���� ������ 
		s3 = new Student(); //����
		s3.name="���ڹ�";
		s3.printScore();
		
		Student s4 = new Student("�̼���",100,80,30); //������
		s4.printScore();
	}

}
