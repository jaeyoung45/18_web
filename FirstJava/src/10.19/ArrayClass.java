package chap04;

public class ArrayClass {
	//�迭�� ������ �հ�
	//����
	public void sum(int[] arr1) {
		int hap=0;
		for(int i=0;i<arr1.length;i++) {
			hap += arr1[i];
		}
		System.out.println("�հ� :" +hap);
	}
	//�ִ밪 ���ϱ�
	public int max(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}return max;
	}	
	//�ּҰ� ���ϱ�
		public int min(int[] arr4) {
			int min = arr4[0];
		for(int i=1; i<arr4.length; i++) {
			if(min > arr4[i]) {
				min = arr4[i];
			}
		}
		return min;		
}		
public static void main(String[] args) {
		int[] arr= {10, 5, 3, 36, 45, 9};
		ArrayClass ac = new ArrayClass();
		ac.sum(arr);
		ac.max(arr);
		int m = ac.max(arr);
		System.out.println("�ִ밪 :" +m);
		System.out.println("�ּҰ� :" +ac.min(arr));
}
	}
