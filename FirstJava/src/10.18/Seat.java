package chap03;
import java.util.Scanner;
public class Seat {
	public static void main(String[] args) {
		
	System.out.println("���ο����� ��������");
	Scanner sc= new Scanner(System.in);
	int tot=sc.nextInt();
	System.out.println("�� �ٿ� ��� �������?");
	int line = sc.nextInt();
	for(int i=1; i<=tot; i++) {
		System.out.print("No"+i+"\t");
		if(i%line==0) {
			System.out.println();
		}
	}
	//�� ���� �� ���
	int row = tot/line;
	if(tot%line!=0) {
		row=row+1;
	}
	System.out.println("�Ѷ��� ��:"+row);
	//���ǿ�����
	int r= (tot%line==0)? tot/line : (tot/line+1);
	System.out.println("�Ѷ��μ�1 :"+r);
	
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
