package examPac07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class StudentMapMain {
	private Scanner sc = new Scanner(System.in);
	HashMap<String,Student> map = new HashMap<>();
	public void insert() { //�߰�
		System.out.println("�л� �̸�,�а�,�й�,�й���� �Է��ϼ���.");
		for(int i=0; i<4; i++) {
		System.out.print(">>");
		String str = sc.nextLine();
		StringTokenizer stk = new StringTokenizer(str,",");
		Student s = new Student();
		s.setName(stk.nextToken());
		s.setDepartment(stk.nextToken());
		s.setId(stk.nextToken());
		s.setGrade(Double.parseDouble(stk.nextToken()));
		map.put(s.getName(),s);
		}
	}	
	
	public void print() { //���
		Set<String> set= map.keySet();
		Iterator<String> it= set.iterator();
		while(it.hasNext()) {
			String n = it.next();
			Student s = map.get(n);
			System.out.println("---�л�����---");
			System.out.println("�̸� :"+s.getName());
			System.out.println("�а� :"+s.getDepartment());
			System.out.println("�й� :"+s.getId());
			System.out.println("�������:"+s.getGrade());
			System.out.println();
		}
	}
	public void search() { //�˻�
		while(true) {
			System.out.println("�˻��̸� ��������. ���� X");
			String str = sc.nextLine();		
			if(str.toUpperCase().equals("X")) return;
//			Student s = map.get(str);
//			if(s==null) {
//				System.out.println("ã�� �л� ����");
//			}else {
//				System.out.println("---ã�� �л�����---");
//				System.out.println("�̸� :"+s.getName());
//				System.out.println("�а� :"+s.getDepartment());
//				System.out.println("�й� :"+s.getId());
//				System.out.println("������� :"+s.getGrade());
//				System.out.println();
//			}
			if(map.containsKey(str)) {
				Student s = map.get(str);
				System.out.println("---ã�� �л�����---");
				System.out.println("�̸� :"+s.getName());
				System.out.println("�а� :"+s.getDepartment());
				System.out.println("�й� :"+s.getId());
				System.out.println("������� :"+s.getGrade());
				System.out.println();
			}else {
				System.out.println("ã�� �л� ����");
			}
		}
}
	public static void main(String[] args) {
		StudentMapMain sm = new StudentMapMain();
		sm.insert();
		sm.print();
		sm.search();

	}

}
