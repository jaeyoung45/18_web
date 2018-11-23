package chap03;
import java.util.Scanner;
public class ArrayTest2 {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("몇개의 정수를 입력할까요?");
	int su = sc.nextInt();
	int[] arr = new int[su];
	System.out.println("데이터 입력");
	int hap = 0;
	for(int i=0; i<su;i++) {
		arr[i] = sc.nextInt();
		hap+= arr[i];
	}
System.out.println("입력합계 :"+hap);
for(int i=0;i<arr.length;i++) {
	System.out.print(arr[i]+"\t");
	}
}
}