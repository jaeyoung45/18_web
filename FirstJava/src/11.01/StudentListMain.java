package examPac07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;


//p436 5�� 1
//4���� �л��� ArrayList<Student>�� �����ϰ� ����ѵ�
//�л� �̸��� �Է¹޾� �ش� �л��� ���� ����� ���
public class StudentListMain {
	private Scanner sc = new Scanner(System.in);
	ArrayList<Student> arr = new ArrayList<>();
	public void insert() {
		//Ȳ����, �����, 1, 4.1
		System.out.println("�л��̸�, �а�, �й�, ��������� �Է��ϼ���");
		for(int i=0; i<4; i++) {
			System.out.print(">>");
			String str = sc.nextLine();
//			String[] tmp = str.split(",");
//			Student s = new Student();
//				s.setName(tmp[0]);
//				s.setDepartment(tmp[1]);
//				s.setId(tmp[2]);
//				s.setGrade(Double.parseDouble(tmp[3]));
//				arr.add(s);
			//StringTokenizer  ����Ͽ�  insert
			StringTokenizer stk = new StringTokenizer(str,",");
			Student s = new Student();
			s.setName(stk.nextToken());
			s.setDepartment(stk.nextToken());
			s.setId(stk.nextToken());
			s.setGrade(Double.parseDouble(stk.nextToken()));
			arr.add(s);
			}
		}
	public void print() {
		Iterator<Student> it = arr.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			System.out.println("---�л�����---");
			System.out.println("�̸� :"+s.getName());
			System.out.println("�а� :"+s.getDepartment());
			System.out.println("�й� :"+s.getId());
			System.out.println("���� :"+s.getGrade());
			System.out.println();
		}
	}
	public void search() {
		while(true) {
			System.out.println("�л��̸��� ��������. ����� x");
			String s = sc.next();
			if(s.toUpperCase().equals("X")) return;
//			for(int i=0; i<arr.size(); i++) {
//				Student st = arr.get(i);
//				if(arr.get(i).equals(s)) {
//					System.out.println("---�˻� �л�����---");
//					System.out.println("�̸� :"+st.getName());
//					System.out.println("�а� :"+st.getDepartment());
//					System.out.println("�й� :"+st.getId());
//					System.out.println("������� :"+st.getGrade());
//					System.out.println();
//				}
//			}
			//for-each��
//			for(Student st : arr) {
//				if(st.getName().equals(s)) {
//					System.out.println("---�˻� �л�����---");
//					System.out.println("�̸� :"+st.getName());
//					System.out.println("�а� :"+st.getDepartment());
//					System.out.println("�й� :"+st.getId());
//					System.out.println("������� :"+st.getGrade());
//					System.out.println();
//			}
//		}
//			//Iterator��
			Iterator<Student> it = arr.iterator();
			while(it.hasNext()) {
				Student st = it.next();
				if(st.getName().equals(s)) {
					System.out.println("---�˻� �л�����---");
					System.out.println("�̸� :"+st.getName());
					System.out.println("�а� :"+st.getDepartment());
					System.out.println("�й� :"+st.getId());
					System.out.println("������� :"+st.getGrade());
					System.out.println();
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		StudentListMain sm = new StudentListMain();
		sm.insert();//����
		sm.print();//���
		sm.search();//�˻�

	}

}
