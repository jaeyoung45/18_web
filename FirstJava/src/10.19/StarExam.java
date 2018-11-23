package chap03;
import java.util.Scanner;
public class StarExam {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int i=10; i>0; i--) {
			for(int j=1; j<i; j++) {
				System.out.print("*");
				}
			System.out.println();		
		}
		System.out.println();
		
		for(char i='z'; i>='a'; i--){
			for(char j='a'; j<=i; j++){
				System.out.print(j);
				}
			System.out.println();
	}
		for(char i='z'; i>='a'; i--){
			for(char j='a'; j<='z'; j++){
				if(i>j) {
					System.out.print("*");
				}else {
				System.out.print(j);
				}
			}	
			System.out.println();
		}
	}		
}
