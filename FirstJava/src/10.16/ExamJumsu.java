package day01;
import java.util.Scanner;

public class ExamJumsu {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		int jumsu = sc.nextInt();
		sc.close();
		
		char grade;
		switch (jumsu/10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
		}
		System.out.println("������" + grade + "�Դϴ�");
/*	if(jumsu >= 90) {
			System.out.println("�Է��� ����� "+jumsu+"��"+" ������ A�Դϴ�.");
		}else if(jumsu>=80) {
			System.out.println("�Է��� ����� "+jumsu+"��"+" ������ B�Դϴ�.");
		}else if(jumsu>=70) {
			System.out.println("�Է��� ����� "+jumsu+"��"+" ������ C�Դϴ�.");
		}else if(jumsu>=60){ 
			System.out.println("�Է��� ����� "+jumsu+"��"+" ������ D�Դϴ�.");
		}else{
			System.out.println("�Է��� ����� "+jumsu+"��"+"������ F�Դϴ�.");
		} */
	}
 }
