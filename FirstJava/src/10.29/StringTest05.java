package chap06;

public class StringTest05 {

	public static void main(String[] args) {
		String msg = "This is a Java";
		String[] arr = msg.split(" ");
		//Java a is This
		for(int i= arr.length-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		//avaJ a si sihT
		for(int i= arr.length-1; i>=0; i--) { //Java i=3
			for(int j=arr[i].length()-1 ; j>=0 ; j--) //j=3
			System.out.print(arr[i].charAt(j));
		}
		System.out.print(" ");
	}	
}

