package chap03;

public class ArrayTest03 {

	public static void main(String[] args) {
		int [][] a= new int[4][4]; 
		//�ʱⰪ�� 0���� ���� ->��������
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=0;
			}
		}
		
		//�迭�� ���� �� �ֱ�
		int num = 0;
		while(num<16) {
			int row = (int)(Math.random()*4);
			int col = (int)(Math.random()*4);	
		
			
		//�迭�� ���� �� �ֱ�
		if(a [row][col]!=0) { //�迭���� 0�� �ƴҶ�
			continue;
		}else{
			a [row][col]=(int)(Math.random()*10)+1;
			num++;
		}	
	}
		//�迭 ���
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+"\t");
		}
			System.out.println();
	}
	
}
}