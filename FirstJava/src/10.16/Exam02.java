package day01;

public class Exam02 {
public static void main(String[] args) {
	int a =10;
	float f ;
	
	f= 10; //형변환(캐스팅) //  자동형변환
	float f1 = 10.5f;
	a = (int)f1; //int = float 형변환(캐스팅) <-  명시적형변환
	System.out.println(a);
	System.out.println(f);
	
	//원 넓이 : 반지름*반지름*3.14
	final double PI = 3.14; //원주율(final <- 상수 : 변하면 안됨)
	double r = 10.5;
	double area  = r*r*PI;
	//pi = 4.5;
	System.out.println("원 넓이 :" +area);
}
}
