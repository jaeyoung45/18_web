package chap04;

public class Person {
	private String name;
	private int age;
	private int tot;
	private String department;
	Person(){
	 
	}
	public Person(String name, int age, String part){
		this.name = name;
		this.age = age;
		department = part;
	}
 //getter <- age�� �˷��ְ� ����
	public int getAge() {
		return age;
 }
//setter <- �����ڿ� ���� ���� (������� �� �ʱ�ȭ)
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;	
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}

