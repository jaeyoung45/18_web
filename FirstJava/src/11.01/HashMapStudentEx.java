package chap07;

import java.util.HashMap;

class Student{
	private int id;
	private String tel;
	
	public Student(int id, String tel) {
		this.setId(id);
		this.setTel(tel);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}

public class HashMapStudentEx {

	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<>();
		map.put("ȫ�浿", new Student(1,"010-1111-1111"));
		map.put("�̼���", new Student(2,"010-2222-2222"));
		map.put("������", new Student(3,"010-3333-3333"));
		Student s = map.get("�̼���");
		System.out.println(s);
		System.out.println("id :" +s.getId()+ "��ȭ :"+s.getTel());
	}

}
