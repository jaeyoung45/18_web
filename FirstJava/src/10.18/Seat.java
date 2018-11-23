package chap03;
import java.util.Scanner;
public class Seat {
	public static void main(String[] args) {
		
	System.out.println("총인원수를 넣으세요");
	Scanner sc= new Scanner(System.in);
	int tot=sc.nextInt();
	System.out.println("한 줄에 몇명 앉을까요?");
	int line = sc.nextInt();
	for(int i=1; i<=tot; i++) {
		System.out.print("No"+i+"\t");
		if(i%line==0) {
			System.out.println();
		}
	}
	//총 라인 수 출력
	int row = tot/line;
	if(tot%line!=0) {
		row=row+1;
	}
	System.out.println("총라인 수:"+row);
	//조건연산자
	int r= (tot%line==0)? tot/line : (tot/line+1);
	System.out.println("총라인수1 :"+r);
	
	int a=5;
	while(a<10) {
		System.out.print(a+"\t");
		a++;
	}
		System.out.println();
		for(int n=5; n<10; n++) {
			System.out.print(n +"\t");
		}
		}
	}
