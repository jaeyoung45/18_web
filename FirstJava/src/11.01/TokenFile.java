package chap08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenFile {

	public static void main(String[] args) {
		//aa.txt -> bb.txt (16진수로 변환시켜 파일로 출력)
		
		//a 14 17 5 8 7 a 43 4 9 2 6 22 17 b 16
		Scanner sc = null;
		PrintStream ps = null;
		try {
		sc = new Scanner(new File("aa.txt"));
		ps = new PrintStream("bb.txt");
		while(sc.hasNext()) {
			String line = sc.nextLine(); //한줄 읽기 10:20
//			String[] tmp = line.split(":"); //10 20
//			for(int i=0; i<tmp.length; i++) {
//				String v1 = Integer.toHexString(Integer.parseInt(tmp[i]));
//				ps.print(v1 + " ");
//			}
			StringTokenizer st = new StringTokenizer(line, ":");
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				String su = Integer.toHexString(Integer.parseInt(s));
				ps.print(su + " ");
			}
		}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			ps.close();
		}
	}
}
				
			
	
