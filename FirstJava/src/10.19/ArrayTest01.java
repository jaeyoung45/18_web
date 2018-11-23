package chap03;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		String[] str = {"one", "two", "three"};
		
		for(int i=0; i<str.length; i++) {
			System.out.println(str[i]);
		}
			System.out.println();
		//for-each
		for(String s:str) {
			System.out.println(s);
		}
		System.out.println();
	//for-each 문 이용하여 arr 출력
		for(int a:arr) {
			System.out.print(a);
		}
		System.out.println();
		int [][] a= new int[4][4]; //2차원배열
		int [][] b= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(b);
		System.out.println(b[0]);
		System.out.println(b[0][0]);
		for(int i=0 ; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		//
		//int [][] c= {{1,2,3,4},{5},{9,10},{13,14,15}};
		int[][] c = new int[4][];
		c[0] = new int[4];
		c[1] = new int[1];
		c[2] = new int[2];
		c[3] = new int[3];
		// c[0][0]=1;
		for(int i=0 ; i<c.length; i++) {
			for(int j=0; j<c[i].length; j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
	}
}
}	

