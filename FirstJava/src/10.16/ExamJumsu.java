package day01;
import java.util.Scanner;

public class ExamJumsu {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
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
		System.out.println("학점은" + grade + "입니다");
/*	if(jumsu >= 90) {
			System.out.println("입력한 결과는 "+jumsu+"점"+" 학점은 A입니다.");
		}else if(jumsu>=80) {
			System.out.println("입력한 결과는 "+jumsu+"점"+" 학점은 B입니다.");
		}else if(jumsu>=70) {
			System.out.println("입력한 결과는 "+jumsu+"점"+" 학점은 C입니다.");
		}else if(jumsu>=60){ 
			System.out.println("입력한 결과는 "+jumsu+"점"+" 학점은 D입니다.");
		}else{
			System.out.println("입력한 결과는 "+jumsu+"점"+"학점은 F입니다.");
		} */
	}
 }
