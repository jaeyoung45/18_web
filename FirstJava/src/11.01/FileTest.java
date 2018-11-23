package chap08;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) {
		Scanner sc = null;
		PrintStream ps = null;
		try {
		sc = new Scanner(new File("output.txt"));
		ps = new PrintStream("test.txt");
		while(sc.hasNext()) {
			String line = sc.nextLine();
			ps.println(line);
		}
	}catch (IOException e) {
		e.printStackTrace();
	}finally {
		ps.close();
	}
	}
}
