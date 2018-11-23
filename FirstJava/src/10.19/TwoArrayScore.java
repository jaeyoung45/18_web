package chap04;

import java.util.Scanner;

public class TwoArrayScore {
	int[][] arr = new int[50][7];
	int row;
	static Scanner sc = new Scanner(System.in);
	//menu
	public void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ��ü����/����");
		System.out.println("���� :");
		
	}
	//�������Է�
	public void inputData() {
		System.out.println("������ �Է½���.....");
		System.out.println("�й� : ");
		int yearNum = sc.nextInt();
		System.out.print("����: ");
		int kor = sc.nextInt();
		System.out.print("����: ");
		int ma = sc.nextInt();
		System.out.print("����: ");
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
	//�������ϱ�
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
	//������ ���
	public void outputData() {
	rankMethod();
	System.out.println("---- ���� ���� ----");
	System.out.println("�й�\t����\t����\t����\t����\t���\t����");
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
			case 1: manager.inputData(); break;//������ �Է�
			case 2: manager.outputData();
				System.exit(0); //����
			default :	System.out.println("�Է¿���");	
			}
		}

	}

}
