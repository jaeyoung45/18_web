package chap08;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class InputSreamScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = null;
		try {
			ps = new PrintStream("file.txt");
			while(sc.hasNext()) {
				String str = sc.nextLine();
				System.out.println(str);
				ps.println(str);
			}
	}catch (FileNotFoundException f) {
		f.printStackTrace();
		}finally {
			ps.close();
		}

	}

}
