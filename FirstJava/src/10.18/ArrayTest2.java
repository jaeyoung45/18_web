package chap03;
import java.util.Scanner;
public class ArrayTest2 {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("��� ������ �Է��ұ��?");
	int su = sc.nextInt();
	int[] arr = new int[su];
	System.out.println("������ �Է�");
	int hap = 0;
	for(int i=0; i<su;i++) {
		arr[i] = sc.nextInt();
		hap+= arr[i];
	}
System.out.println("�Է��հ� :"+hap);
for(int i=0;i<arr.length;i++) {
	System.out.print(arr[i]+"\t");
	}
}
}