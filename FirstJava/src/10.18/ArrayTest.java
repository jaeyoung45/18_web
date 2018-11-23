package chap03;

import java.util.Scanner;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		int[] arr= new int[5];
		System.out.println(arr);
		arr[0]=100;
		arr[1]=200;
		arr[2]=300;
		arr[3]=400;
		arr[4]=500;
		for(int i=0; i<5; i++) {
			System.out.println(arr[i]);
		}
		int arr1[] = new int[5];
		int[] arr2 = {10,20,30,40,50};
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	
	int data[] = {10,5,90,100,250,30,77};
		//배열원소 중 최대값과 그 위치
	
	int max= data[0];
	int pos= 0; //위치
	int sum = data[0]; //합계	
	for(int i=1;i<data.length;i++) {
		sum += data[i];
		if(max<data[i]) { //max와 data[i] 비교
		max = data[i];
		pos =i;
		}
	}			
	System.out.println("최대값 :" +max);
	System.out.println("최대값위치 :" +pos);
	System.out.println("배열합계 :"+sum);
	System.out.println("배열평균 :"+(float)sum/data.length);
	System.out.println("찾을 숫자를 입력하세요");
	Scanner sc= new Scanner(System.in);
	int search = sc.nextInt();
		boolean flag = false;
		for(int i=0; i<data.length;i++) {
			if(search == data[i]) {
				flag =true;

			System.out.println(data[i]+ ":" +i+"번째 있습니다.");
						}
		}	
		if(flag==false) {
				System.out.println("찾는 값:"+search+"없습니다.");	
		
			}
		}
	}	
