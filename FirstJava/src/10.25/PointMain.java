package chap05;

import java.util.Scanner;

public class PointMain {

		public static Scanner sc = new Scanner(System.in);
		public static void showMeu() {
			System.out.println("선택하세요....");
			System.out.println("1.원 2.사각형 3.보기 4.종료");
			System.out.print("선택 :");
		}
	
		public static void main(String[] args) {
			PointManger pm = new PointManger();
			while(true) {
				PointMain.showMeu();
				int choice = PointMain.sc.nextInt();
				switch(choice) {
				case 1:				//원입력
				case 2: pm.inputData(choice); break; //사각형입력
				case 3: pm.viewData(); break; //보기
				case 4:System.out.println("종료");System.exit(0);
				}
			}
		}
}
