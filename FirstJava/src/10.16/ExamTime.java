package day01;
import java.util.Scanner;

public class ExamTime {
public static void main(String[] args) {

	Scanner sc= new Scanner(System.in);
	System.out.println("���� �Է��ϼ���");
	int time = sc.nextInt();
	int sec= time % 60;;
	int min= (time/60) / 60;
	int hour = (time/60) / 60;
	
	
	System.out.println(hour+"�ð�"+min+"��"+sec+"��");
 }
}


