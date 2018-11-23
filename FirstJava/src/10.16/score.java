package day01;
import java.util.Scanner;

public class score {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("국어 점수를 입력하세요.");
	int kor = sc.nextInt();
	
	System.out.println("영어 점수를 입력하세요.");
	int eng = sc.nextInt();
	
	System.out.println("수학 점수를 입력하세요.");
	int mat = sc.nextInt();
	sc.close();
	
	int sum = kor+eng+mat;
	int avg = sum/3;
	System.out.println("총점 :"+sum+"\t평균 :"+avg);
	}
}
