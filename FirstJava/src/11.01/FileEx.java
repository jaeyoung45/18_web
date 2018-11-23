package chap08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) {
		FileReader fi=null;
		FileOutputStream fo =null;
		try {
	 fi = new FileReader("src\\chap08\\InputTest.java");
	 fo = new FileOutputStream("output.txt");
	 int c;
	 while((c=fi.read())!=-1) {
		 System.out.print((char)c);
		 fo.write(c);
	 }//while
		}catch(FileNotFoundException f) {
			System.out.println("파일이 없어요.");
		}catch(IOException e) {
			System.out.println("파일 읽기 실패");
	}
  }
	
}
