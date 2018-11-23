package chap03;

public class ArrayTest03 {

	public static void main(String[] args) {
		int [][] a= new int[4][4]; 
		//초기값을 0으로 셋팅 ->생략가능
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=0;
			}
		}
		
		//배열에 난수 값 넣기
		int num = 0;
		while(num<16) {
			int row = (int)(Math.random()*4);
			int col = (int)(Math.random()*4);	
		
			
		//배열에 난수 값 넣기
		if(a [row][col]!=0) { //배열값이 0이 아닐때
			continue;
		}else{
			a [row][col]=(int)(Math.random()*10)+1;
			num++;
		}	
	}
		//배열 출력
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
		}
			System.out.println();
	}
	
}
}