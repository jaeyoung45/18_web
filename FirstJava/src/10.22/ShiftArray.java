package chap04;

public class ShiftArray {
	public static void shiftArray(int[][] arr) { //�̵��޼ҵ�
	int[] tmp = arr[arr.length-1];
	for(int i=arr.length-2; i>=0; i--) {
		arr[i+1] = arr[i];
	}
	arr[0] = tmp;
	/*for(int i=arr.length-1; i>0; i--) {
		arr[i] = arr[i-1]; 
	}*/
	}
	
	public static void showArray(int[][] arr) { //��¸޼ҵ�
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
}

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("1��  shift......");
		ShiftArray.shiftArray(arr);
		ShiftArray.showArray(arr);

	}

}
