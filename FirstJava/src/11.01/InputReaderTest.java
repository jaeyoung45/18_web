package chap08;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderTest {

	public static void main(String[] args) {
		InputStreamReader isr
		=new InputStreamReader(System.in);
		try {
		int i ;
		while((i=isr.read())!=-1) {
			System.out.print((char)i);
			
		}
	}catch(IOException e) {
		e.printStackTrace();
	}

	}

}
