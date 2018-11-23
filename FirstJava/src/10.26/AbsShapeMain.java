package examPac05;

public class AbsShapeMain {
	public static void main(String[] args) {
		AbsCircle c1 = new AbsCircle();
		c1.draw();
		c1.print();
		c1.move();
		
		AbsSquare s1 = new AbsSquare();
		s1.draw(); //사각형 그리기
		s1.print();
		s1.move(); //사각형 이동하기

	}

}
