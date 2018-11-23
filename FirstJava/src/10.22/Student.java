package chap04;

public class Student {
	String name;
	int kor;
	int eng;
	int math;
	//생성자 (멤버변수 값 초기화 <- 할당)
	//생성자 오버로딩
	public Student() { //생성자 명은 클래스명, void 없어야 함.
		
	}
	public Student(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		math = m;
	}
	public int getTotal() {
		return kor+eng+math;
	}
	public int getAvg() {
		return (kor+eng+math)/3;
	}	
	public void printScore() {
		System.out.println(name +"님의 총점 : "+getTotal()+ "평균 : "+getAvg());
	}
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name="홍길동";
		s1.kor=100;
		s1.eng=80;
		s1.math=70;
		
		s1.getTotal(); //총점
		s1.getAvg(); //평균
		s1.printScore(); //성적출력 <- 홍길동 총점 : ???, 평균 : ???
		
		Student s2 = new Student(); //선언&생성
		s2.name="강감찬";
		s2.kor=100;
		s2.eng=85;
		s2.math=55;
		
		s2.printScore();
		
		Student s3;  //선언
		//디폴트 생성자 <- 인자가 없는 생성자 
		s3 = new Student(); //생성
		s3.name="김자바";
		s3.printScore();
		
		Student s4 = new Student("이순신",100,80,30); //생성자
		s4.printScore();
	}

}
