package day01;
import java.util.Scanner;

public class TestScore {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("시험 점수를 입력하세요.");
	int score=sc.nextInt();
	System.out.println("합격 점수를 입력하세요.");
	int cutline = sc.nextInt();
	if(score>=cutline) {
		System.out.println("합격");
	}else {
		System.out.println("불합격");
	}
	sc.close();
	
}
}
