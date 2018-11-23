package chap06;

public class StringTest02 {

	public static void main(String[] args) {
		String str = "안녕하세요 Hello 지금은 자바공부!!!";
		System.out.println("str 길이 :"+str.length());
		System.out.println("H위치 :"+str.indexOf('H'));
		System.out.println("Hello위치 :"+str.indexOf("Hello"));
		System.out.println("4번째 문자:"+str.charAt(4));
		String tmp = "열심히 합시다";
		System.out.println("str tmp 연결:"+str.concat(tmp));
		System.out.println("str tmp 연결:"+str+tmp);
		int value = 7;
		System.out.println("str과 value 연결 :"+str+value);
		String s = String.valueOf(value);
		System.out.println(s);
		
		//tmp와 value 연결
		System.out.println("tmp와 value 연결 :"+tmp.concat(String.valueOf(value)));
	
	}

}
