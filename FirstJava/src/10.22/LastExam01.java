package chap04;
import java.util.Scanner;
public class LastExam01 {

	public static void main(String[] args) {
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		    	
				Scanner sc = new Scanner(System.in);
		        System.out.println("금액을 입력하세요.");
		        int won = sc.nextInt();            
		        for(int i=0; i<unit.length; i++) {
		        	if(won/unit[i]>0) {	     
		        	System.out.println(unit[i]+"원 짜리 :"+won/unit[i]);
		        	}
		        	won = won%unit[i];
		        }
	}
}	