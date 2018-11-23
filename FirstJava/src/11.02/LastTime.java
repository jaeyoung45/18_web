package chap08;

//aa.txt -> bb.txt (파일을 읽어 라인번호와 함께 출력)
		//예) aa.txt 
		//안녕하세요
		//반갑습니다.
		//bb.txt
		//1:안녕하세요
		//2:반갑습니다.

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class LastTime {

		public static void main(String[] args) {
			Scanner sc = null;
			PrintStream ps = null;
			try {
				sc = new Scanner(new File("aaa.txt"));
				ps = new PrintStream("bbb.txt");
				int cnt=1;
				while(sc.hasNext()) {
					String line = sc.nextLine();
					ps.println(cnt+ ":"+line);
					cnt++;
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				ps.close();
			}
		}
}
