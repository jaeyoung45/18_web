package chap06;

public class StringTest01 {

	public static void main(String[] args) {
		String str = "안녕";
		String str1 = "안녕";
		String tmp = new String("안녕");
		if(str==str1) {
			System.out.println("str==str1 주소 같다");
		}else {
			System.out.println("str==str1 주소 다르다");
		}
		if(str==tmp) {
			System.out.println("str==tmp 주소 같다");
		}else {
			System.out.println("str==tmp 주소 다르다");
		}
		if(str.equals(tmp)) {
			System.out.println("str tmp 내용 같다");
		}else {
			System.out.println("str tmp 내용 다르다");
		}
	}
}
