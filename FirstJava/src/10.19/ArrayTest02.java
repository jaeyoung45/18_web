package chap03;

public class ArrayTest02 {

	public static void main(String[] args) {
		
		double [][] d= new double[4][4]; 
		{
		//Math.random()0~1사이 난수->double형
		for(int i=0;i<d.length;i++) {
			for(int j=0;j<d[i].length;j++) {
				d[i][j]= (int)(Math.random()*10)+1;
				System.out.print(d[i][j]+"\t");
			}
				System.out.println();
		}
		}
	}
}	