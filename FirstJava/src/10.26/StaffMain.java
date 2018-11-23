package chap05;
/*�ӽ���(Temp) Ŭ����
������(Emp) Ŭ����
��¹��� �������� �������� �⺻ ������ ���� ���
�ӽ����� �⺻������ ���� ���
�⺻���� : �̸�,����,�ּ�,�μ�
name/age/addr/part
����Ŭ���� : StaffMain*/
class Staff{
	private String name;
	private int age;
	private String addr;
	private String part;
	public Staff(String name, int age, String addr, String part) {
		this.name=name;
		this.age=age;
		this.addr=addr;
		this.part=part;
	}
	public void show() {
		System.out.println("�̸� :"+name + "���� :"+age);
		System.out.println("�ּ� :"+addr + "�μ� :"+part);
}	
	}	
class Emp extends Staff{
	 private int salary;
	 public Emp(String name, int age, String addr, String part, int salary) {
		 super(name,age,addr,part);
		 this.salary=salary;
	 }
public void show() {
		super.show();
		System.out.println("������ ���� :"+salary);
		System.out.println();
}
}
class Temp extends Staff{
	private int hourPay;
	private int workhour;
	public Temp(String name, int age, String addr, String part, int hourPay) {
		super(name,age,addr,part);
		this.hourPay=hourPay;
}
public void show() {
	super.show();
	System.out.println("�ӽ��� �ð������� :"+hourPay);
	System.out.println("�ӽ��� ���� :"+(hourPay*workhour));
	System.out.println();
 }
public void setWorkhour(int workhour) {
	this.workhour = workhour;
}
}
public class StaffMain {
		public static void main(String[] args) {
		Staff e1 = new Emp("ȫ�浿",30,"����","�λ��",5000000);
		Temp t1 = new Temp("�̼���",25,"�λ�","������",12000);
		t1.setWorkhour(5);
		e1.show();
		t1.show();
	}
}

