package chap04;

public class PersonMain {
	Person[] parr = new Person[10];
	int cnt;
 public void insertData(String name, int age, String department) {
	 //parr[cnt] = new Person(name, age, department);
	 parr[cnt] = new Person();
	 parr[cnt].setName(name);
	 parr[cnt].setAge(age);
	 parr[cnt].setDepartment(department);
	
	 cnt++;
 }
 public void avgAge() {
	 double avg = 0;
	 for(int i=0; i<parr.length; i++) {
		 if(parr[i]==null) break;
		 avg += parr[i].getAge();
	 }
	 System.out.println("��� ���� :"+avg/cnt);
 }
	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		pm.insertData("ȫ�浿",30,"������");
		pm.insertData("�̼���",35,"�λ��");
		pm.insertData("������",28,"���ߺ�");
		pm.avgAge(); // ������ ��� ����

	}

}
