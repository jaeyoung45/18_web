package chap08;

import java.io.IOException;

public class inputTest {

	public static void main(String[] args) {
		try {
			
		
		while(true) {
			int i= System.in.read();
			if(i==-1) break;
			System.out.print((char)i);
		}
		}catch(IOException e){
			System.out.println("���ܹ߻�");
		}
	}

}
