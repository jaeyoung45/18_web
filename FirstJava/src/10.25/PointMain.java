package chap05;

import java.util.Scanner;

public class PointMain {

		public static Scanner sc = new Scanner(System.in);
		public static void showMeu() {
			System.out.println("�����ϼ���....");
			System.out.println("1.�� 2.�簢�� 3.���� 4.����");
			System.out.print("���� :");
		}
	
		public static void main(String[] args) {
			PointManger pm = new PointManger();
			while(true) {
				PointMain.showMeu();
				int choice = PointMain.sc.nextInt();
				switch(choice) {
				case 1:				//���Է�
				case 2: pm.inputData(choice); break; //�簢���Է�
				case 3: pm.viewData(); break; //����
				case 4:System.out.println("����");System.exit(0);
				}
			}
		}
}
