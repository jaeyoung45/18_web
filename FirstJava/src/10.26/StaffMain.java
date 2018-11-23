package chap05;
/*임시직(Temp) 클래스
정규직(Emp) 클래스
출력문은 정규직은 정규직의 기본 정보와 월급 출력
임시직은 기본정보와 월급 출력
기본정보 : 이름,나이,주소,부서
name/age/addr/part
메인클래스 : StaffMain*/
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
		System.out.println("이름 :"+name + "나이 :"+age);
		System.out.println("주소 :"+addr + "부서 :"+part);
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
		System.out.println("정규직 월급 :"+salary);
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
	System.out.println("임시직 시간당페이 :"+hourPay);
	System.out.println("임시직 월급 :"+(hourPay*workhour));
	System.out.println();
 }
public void setWorkhour(int workhour) {
	this.workhour = workhour;
}
}
public class StaffMain {
		public static void main(String[] args) {
		Staff e1 = new Emp("홍길동",30,"서울","인사부",5000000);
		Temp t1 = new Temp("이순신",25,"부산","영업부",12000);
		t1.setWorkhour(5);
		e1.show();
		t1.show();
	}
}

