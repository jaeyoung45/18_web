package chap08;

//aa.txt -> bb.txt (������ �о� ���ι�ȣ�� �Բ� ���)
		//��) aa.txt 
		//�ȳ��ϼ���
		//�ݰ����ϴ�.
		//bb.txt
		//1:�ȳ��ϼ���
		//2:�ݰ����ϴ�.

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
