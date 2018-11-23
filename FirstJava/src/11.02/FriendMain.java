package chap08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendMain {
	ArrayList<Friend> arr = new ArrayList<>();
	File dir, file;
	public FriendMain() throws IOException, ClassNotFoundException {
		dir = new File("src\\chap08\\");
		file = new File(dir, "friend.txt");
		if(file.exists()) {
			ObjectInputStream ois = 
			new ObjectInputStream(new FileInputStream(file));
		arr=(ArrayList<Friend>)ois.readObject();
		}else { //���� ����
			file.createNewFile(); //���� ���� ����.
		}
	}
	private void fileuse() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.ģ����� 2.ģ������ 3.����/����");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice==1) { //ģ�����
				System.out.println("�̸�>>");
				String name = sc.nextLine();
				System.out.println("����>>");
				String birth = sc.nextLine();
				System.out.println("�ּ�>>");
				String addr = sc.nextLine();
				System.out.println("��ȭ>>");
				String tel = sc.nextLine();
				Friend f = new Friend();
				f.setAddr(addr);
				f.setBirth(birth);
				f.setName(name);
				f.setTel(tel);
				arr.add(f);
	
			}else if(choice==2) { //ģ������
				for(Friend f : arr) {
					System.out.println("�̸� :"+ f.getName());
					System.out.println("���� :"+ f.getBirth());
					System.out.println("�ּ�:"+ f.getAddr());
					System.out.println("��ȭ :"+ f.getTel());
					System.out.println();
				}
				
			}else if(choice==3) { //����/����
				//����
				ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(arr);
				//����
				System.out.println("����");
				System.exit(0);
			}else { //�Է¿���
				System.out.println("�Է¿���");
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FriendMain fm = new FriendMain();
		fm.fileuse();

	}

}
