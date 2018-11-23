package day01;
import java.util.Scanner;

public class ExamSu {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("첫번째 수 입력");
	int max = sc.nextInt();
	System.out.println("두번째 수 입력");
	int min = sc.nextInt();
	
	if(min>max) {
		int tmp = min;
		min = max;
		max = tmp;
	}
	System.out.println("큰 수 :"+max);
	System.out.println("작은 수 :"+min);
	System.out.println("두수차 :"+(max-min));
	}
}
