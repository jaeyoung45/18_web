package examPac07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class StudentMapMain {
	private Scanner sc = new Scanner(System.in);
	HashMap<String,Student> map = new HashMap<>();
	public void insert() { //추가
		System.out.println("학생 이름,학과,학번,학번평균 입력하세요.");
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
	
	public void print() { //출력
		Set<String> set= map.keySet();
		Iterator<String> it= set.iterator();
		while(it.hasNext()) {
			String n = it.next();
			Student s = map.get(n);
			System.out.println("---학생정보---");
			System.out.println("이름 :"+s.getName());
			System.out.println("학과 :"+s.getDepartment());
			System.out.println("학번 :"+s.getId());
			System.out.println("학점평균:"+s.getGrade());
			System.out.println();
		}
	}
	public void search() { //검색
		while(true) {
			System.out.println("검색이름 넣으세요. 종료 X");
			String str = sc.nextLine();		
			if(str.toUpperCase().equals("X")) return;
//			Student s = map.get(str);
//			if(s==null) {
//				System.out.println("찾는 학생 없음");
//			}else {
//				System.out.println("---찾는 학생정보---");
//				System.out.println("이름 :"+s.getName());
//				System.out.println("학과 :"+s.getDepartment());
//				System.out.println("학번 :"+s.getId());
//				System.out.println("학점평균 :"+s.getGrade());
//				System.out.println();
//			}
			if(map.containsKey(str)) {
				Student s = map.get(str);
				System.out.println("---찾는 학생정보---");
				System.out.println("이름 :"+s.getName());
				System.out.println("학과 :"+s.getDepartment());
				System.out.println("학번 :"+s.getId());
				System.out.println("학점평균 :"+s.getGrade());
				System.out.println();
			}else {
				System.out.println("찾는 학생 없음");
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
