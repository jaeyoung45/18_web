package day01;

public class Exam04 {
	public static void main(String[] args) {
		int num=50;
		if(num>0 && num%2==0) {
			System.out.println("0보다 크고 짝수");
		}else if(num==0){
			System.out.println("0이다");	
		}else {
			System.out.println("0보다 작고 홀수");
		}
		
		
		int su = 252;
		if(su < 0) {
			System.out.println("0미만");
		}else if(su<100) {
			System.out.println("0이상 100미만");
		}else if(su<200) {
			System.out.println("100이상 200미만");
		}else if(su<300){ 
			System.out.println("200이상 300미만");
		}else{
			System.out.println("300이상");
		}
	}		
	
}