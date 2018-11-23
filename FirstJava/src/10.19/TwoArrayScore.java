package chap04;

import java.util.Scanner;

public class TwoArrayScore {
	int[][] arr = new int[50][7];
	int row;
	static Scanner sc = new Scanner(System.in);
	//menu
	public void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 전체보기/종료");
		System.out.println("선택 :");
		
	}
	//데이터입력
	public void inputData() {
		System.out.println("데이터 입력시작.....");
		System.out.println("학번 : ");
		int yearNum = sc.nextInt();
		System.out.print("국어: ");
		int kor = sc.nextInt();
		System.out.print("수학: ");
		int ma = sc.nextInt();
		System.out.print("영어: ");
		int eng = sc.nextInt();
		arr[row][0] = yearNum;
		arr[row][1] = kor;
		arr[row][2] = ma;
		arr[row][3] = eng;
		arr[row][4] = kor+ma+eng;
		arr[row][5] =arr[row][4]/3;
		arr[row][6] =1;
		row++;
	}	
	//석차구하기
	public void rankMethod() {
	for(int i=0; i<row-1;i++) {
		for(int j=i+1; j<row; j++) {
			if(arr[i][4]>arr[j][4]) {
				arr[j][6]++;
			}else if(arr[i][4]<arr[j][4]){
				arr[i][6]++;
		}
	}
}
	}
	//데이터 출력
	public void outputData() {
	rankMethod();
	System.out.println("---- 성적 보기 ----");
	System.out.println("학번\t국어\t수학\t영어\t총점\t평균\t순위");
	for(int i=0; i<row; i++) {
		for(int j=0; j<arr[i].length; j++) {
			System.out.print(arr[i][j]+"\t");
		}
		System.out.println();
	}
}
	public static void main(String[] args) {
		TwoArrayScore manager = new TwoArrayScore();
		while(true) {
			manager.showMenu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1: manager.inputData(); break;//데이터 입력
			case 2: manager.outputData();
				System.exit(0); //종류
			default :	System.out.println("입력오류");	
			}
		}

	}

}
