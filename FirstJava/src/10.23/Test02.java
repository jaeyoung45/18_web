package objectArray;

public class Test02 {
	public void method1(int[] arr) {
		System.out.println("method1...");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("method1 ��� ��");
		arr[0]=500;
	}
	public static void main(String[] args) {
		int[] arr = {30,25,3,6,90};
		Test02 t = new Test02();
		t.method1(arr);//�ּ�(���۷���) ����
		System.out.println("main...");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("main ��� ��");
	}

}
