package chap04;
import java.util.Scanner;

public class Teacher {
	StudentBean[] arr = new StudentBean[30];
	static Scanner sc = new Scanner(System.in);
	int cnt;
		//�����Է�
	public void inputScore() {
		System.out.println("�������Է½���...");
		System.out.print("�̸�:");
		String name = sc.next();
		System.out.print("���� :");
		int kor = sc.nextInt();
		System.out.print("���� :");
		int eng = sc.nextInt();
		System.out.print("���� :");
		int math = sc.nextInt();
		arr[cnt] = new StudentBean(name, kor, eng, math);
		cnt++;
	}
		//��ü��������
	public void viewScore() {
		System.out.println("---�л� ���� ����---");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
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
		System.out.println("�� ���� :"+sum);
		System.out.println("�� ������� :"+sum/cnt);
		
	}
	//�޴�
	public void showMenu() {
		System.out.println("�����ϼ���....");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ��ü����");
		System.out.println("3. ����");
		System.out.println("���� :");
	}
	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		while(true) {
		t1.showMenu();
		int choice = sc.nextInt();
		switch(choice) {
		case 1: t1.inputScore();break;
		case 2: t1.viewScore();break;
		case 3: System.out.println("����");
			System.exit(0);
		default: System.out.println("�Է¿���");	
		}
	}
}
}	
