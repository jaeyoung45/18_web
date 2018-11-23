package examPac07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;


//p436 5번 1
//4명의 학생을 ArrayList<Student>에 저장하고 출력한뒤
//학생 이름을 입력받아 해당 학생의 학점 평균을 출력
public class StudentListMain {
	private Scanner sc = new Scanner(System.in);
	ArrayList<Student> arr = new ArrayList<>();
	public void insert() {
		//황기태, 모바일, 1, 4.1
		System.out.println("학생이름, 학과, 학번, 학점평균을 입력하세요");
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
			//StringTokenizer  사용하여  insert
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
			System.out.println("---학생정보---");
			System.out.println("이름 :"+s.getName());
			System.out.println("학과 :"+s.getDepartment());
			System.out.println("학번 :"+s.getId());
			System.out.println("학점 :"+s.getGrade());
			System.out.println();
		}
	}
	public void search() {
		while(true) {
			System.out.println("학생이름을 넣으세요. 종료는 x");
			String s = sc.next();
			if(s.toUpperCase().equals("X")) return;
//			for(int i=0; i<arr.size(); i++) {
//				Student st = arr.get(i);
//				if(arr.get(i).equals(s)) {
//					System.out.println("---검색 학생정보---");
//					System.out.println("이름 :"+st.getName());
//					System.out.println("학과 :"+st.getDepartment());
//					System.out.println("학번 :"+st.getId());
//					System.out.println("학점평균 :"+st.getGrade());
//					System.out.println();
//				}
//			}
			//for-each문
//			for(Student st : arr) {
//				if(st.getName().equals(s)) {
//					System.out.println("---검색 학생정보---");
//					System.out.println("이름 :"+st.getName());
//					System.out.println("학과 :"+st.getDepartment());
//					System.out.println("학번 :"+st.getId());
//					System.out.println("학점평균 :"+st.getGrade());
//					System.out.println();
//			}
//		}
//			//Iterator문
			Iterator<Student> it = arr.iterator();
			while(it.hasNext()) {
				Student st = it.next();
				if(st.getName().equals(s)) {
					System.out.println("---검색 학생정보---");
					System.out.println("이름 :"+st.getName());
					System.out.println("학과 :"+st.getDepartment());
					System.out.println("학번 :"+st.getId());
					System.out.println("학점평균 :"+st.getGrade());
					System.out.println();
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		StudentListMain sm = new StudentListMain();
		sm.insert();//저장
		sm.print();//출력
		sm.search();//검색

	}

}
