package chap06;

public class StringTest04 {

	public static void main(String[] args) {
		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		String[] arr= tmp.split(" ");
		String hex ="";
		String oct ="";
		String bin ="";
		for(String s:arr) {
			int num = Integer.parseInt(s);
			hex += Integer.toHexString(num)+"\t";
			oct += Integer.toOctalString(num)+"\t";
			bin += Integer.toBinaryString(num)+"\t";
		}
		
		System.out.println("16진수 :");
		for(int i=0; i<arr.length; i++) {
			int v1 = Integer.parseInt(arr[i]);
		System.out.print(Integer.toHexString(v1).toUpperCase()+"\t");
		}
		System.out.println();
		System.out.println("8진수 :");
		for(int i=0; i<arr.length; i++) {
			int v2 = Integer.parseInt(arr[i]);
		System.out.print(Integer.toOctalString(v2).toUpperCase()+"\t");
		}
		System.out.println();
		System.out.println("2진수 :");
		for(int i=0; i<arr.length; i++) {
			int v3 = Integer.parseInt(arr[i]);
		System.out.print(Integer.toBinaryString(v3).toUpperCase()+"\t");
		}

	}

}
