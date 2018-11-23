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
	 System.out.println("평균 나이 :"+avg/cnt);
 }
	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		pm.insertData("홍길동",30,"영업부");
		pm.insertData("이순신",35,"인사부");
		pm.insertData("강감찬",28,"개발부");
		pm.avgAge(); // 세명의 평균 나이

	}

}
