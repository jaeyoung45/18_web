package chap04;
import java.util.Scanner;

public class Teacher {
	StudentBean[] arr = new StudentBean[30];
	static Scanner sc = new Scanner(System.in);
	int cnt;
		//성적입력
	public void inputScore() {
		System.out.println("데이터입력시작...");
		System.out.print("이름:");
		String name = sc.next();
		System.out.print("국어 :");
		int kor = sc.nextInt();
		System.out.print("영어 :");
		int eng = sc.nextInt();
		System.out.print("수학 :");
		int math = sc.nextInt();
		arr[cnt] = new StudentBean(name, kor, eng, math);
		cnt++;
	}
		//전체성적보기
	public void viewScore() {
		System.out.println("---학생 성적 보기---");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==null) break;
			System.out.print(arr[i].name+"\t");
			System.out.print(arr[i].kor+"\t");
			System.out.print(arr[i].eng+"\t");
			System.out.print(arr[i].math+"\t");
			System.out.print(arr[i].getTotal()+"\t");
			System.out.println(arr[i].getAvg()+"\t");
			sum += arr[i].getTotal();
		}
		System.out.println("반 총점 :"+sum);
		System.out.println("반 총점평균 :"+sum/cnt);
		
	}
	//메뉴
	public void showMenu() {
		System.out.println("선택하세요....");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 전체보기");
		System.out.println("3. 종료");
		System.out.println("선택 :");
	}
	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		while(true) {
		t1.showMenu();
		int choice = sc.nextInt();
		switch(choice) {
		case 1: t1.inputScore();break;
		case 2: t1.viewScore();break;
		case 3: System.out.println("종료");
			System.exit(0);
		default: System.out.println("입력오류");	
		}
	}
}
}	
