package day01;

public class Exam04 {
	public static void main(String[] args) {
		int num=50;
		if(num>0 && num%2==0) {
			System.out.println("0���� ũ�� ¦��");
		}else if(num==0){
			System.out.println("0�̴�");	
		}else {
			System.out.println("0���� �۰� Ȧ��");
		}
		
		
		int su = 252;
		if(su < 0) {
			System.out.println("0�̸�");
		}else if(su<100) {
			System.out.println("0�̻� 100�̸�");
		}else if(su<200) {
			System.out.println("100�̻� 200�̸�");
		}else if(su<300){ 
			System.out.println("200�̻� 300�̸�");
		}else{
			System.out.println("300�̻�");
		}
	}		
	
}