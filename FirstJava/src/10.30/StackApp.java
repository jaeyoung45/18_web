package chap06;

import java.util.Scanner;
interface Stack {
	int length(); //개수 리턴
	int capcity(); // 전체 저장 가능한 개수 리턴
	String pop(); //리턴
	boolean push(String val); //저장
}
public class StackApp {
	
 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("총 스택 저장 공간의 크기 입력 >>");
		int n = sc.nextInt();
		StringApp ss = new StringApp(n);
		while(true) {
			System.out.print("문자열 입력 >>");
			String str = sc.next();
			if(str.equals("그만"))
				break;
			boolean res = ss.push(str);
			if(res == false) {
				System.out.println("스택이 꽉 차서 차서 푸시 불가!");
			}
		}
		System.out.print("스택에 저장된 모든 문자열 팝 :");
		int len = ss.length();
		for(int i=0; i<len; i++) {
			System.out.print(ss.pop() +" ");
		}
			sc.close();
	 }
}

class StringApp implements Stack{
	private String[] arr;
	private int top;
	public StringApp(int n) {
		arr = new String[n];
		top = -1;
	}
	@Override
	public int length() { //arr 저장된 개수
		return top+1;
	}
	@Override
	public int capcity() { //배열의 크기
		return arr.length;
	}
	@Override
	public String pop() { //빼는거
		if(top==-1) //스택 비어있음
		return "비어있음";
		String s = arr[top];
		top--; //스택포인터 감소
		return s;
	}
	@Override
	public boolean push(String val) { //저장
		if(top == arr.length-1) { //찼을때
		return false;
		}else { //안 찼을때
		top++;
		arr[top] = val;
		return true;
	}
}
}

