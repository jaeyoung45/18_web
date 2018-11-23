package chap06;

public class StringTest03 {

	public static void main(String[] args) {
		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		//tmp길이 출력
		System.out.println("tmp 길이 :"+tmp.length());
		String[] arr = tmp.split(" ");
		//arr 배열의 길이
		System.out.println("arr 길이 :"+arr.length);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		//a 값을 16진수로 출력
		int a = 15;
		System.out.println(Integer.toHexString(a));
		String b= "14";
		//b 값을 16진수로 출력
		int v = Integer.parseInt(b);
		System.out.println(Integer.toHexString(v));
		System.out.println(Integer.toHexString(Integer.parseInt(b)));
		//arr를 16진수로 변환
		System.out.println("arr 길이 :"+arr.length);
		System.out.println("----16진수----");
		for(int i=0; i<arr.length; i++) {
			//System.out.print(arr[i]+"\t");
			int y = Integer.parseInt(arr[i]);
			System.out.print(Integer.toHexString(y)+"\t");
		}
		System.out.println();
		//arr를 16진수로 변환 ->대문자로
				System.out.println("arr 길이 :"+arr.length);
				System.out.println("----16진수----");
				for(int i=0; i<arr.length; i++) {
					//System.out.print(arr[i]+"\t");
					int y = Integer.parseInt(arr[i]);
					System.out.print(Integer.toHexString(y).toUpperCase()+"\t");
				}
				System.out.println();
	}

}
