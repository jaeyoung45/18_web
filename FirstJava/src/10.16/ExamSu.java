package day01;
import java.util.Scanner;

public class ExamSu {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("ù��° �� �Է�");
	int max = sc.nextInt();
	System.out.println("�ι�° �� �Է�");
	int min = sc.nextInt();
	
	if(min>max) {
		int tmp = min;
		min = max;
		max = tmp;
	}
	System.out.println("ū �� :"+max);
	System.out.println("���� �� :"+min);
	System.out.println("�μ��� :"+(max-min));
	}
}
