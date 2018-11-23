package day01;
import java.util.Scanner;
public class ExamCoffee {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("무슨 커피를 드릴까요?");
	
	String menu = sc.next();
	int price=0;
	switch (menu) {
	case "에스페레소":
	case "카푸치노":
	case "카페라떼":	price =3500; break;
	case "아메리카노":	price =2000; break;
	}	
		System.out.println("메뉴에 없습니다!");
		System.out.println(menu+":"+price);
	
		System.out.println("체중 입력");
		double weight = sc.nextDouble();
		System.out.println("노트북 유무 :있으면 true/없으면 false");
		boolean flag = sc.nextBoolean();
		if(flag) {
			System.out.println("노트북 있음");	
		}else {
			System.out.println("노트북 없음");
		}
		System.out.println("체중 :" +weight);	
		sc.close();	
		}
}
