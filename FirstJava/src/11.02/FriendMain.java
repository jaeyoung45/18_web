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
		}else { //파일 없음
			file.createNewFile(); //파일 새로 만듬.
		}
	}
	private void fileuse() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.친구등록 2.친구보기 3.저장/종료");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice==1) { //친구등록
				System.out.println("이름>>");
				String name = sc.nextLine();
				System.out.println("생일>>");
				String birth = sc.nextLine();
				System.out.println("주소>>");
				String addr = sc.nextLine();
				System.out.println("전화>>");
				String tel = sc.nextLine();
				Friend f = new Friend();
				f.setAddr(addr);
				f.setBirth(birth);
				f.setName(name);
				f.setTel(tel);
				arr.add(f);
	
			}else if(choice==2) { //친구보기
				for(Friend f : arr) {
					System.out.println("이름 :"+ f.getName());
					System.out.println("생일 :"+ f.getBirth());
					System.out.println("주소:"+ f.getAddr());
					System.out.println("전화 :"+ f.getTel());
					System.out.println();
				}
				
			}else if(choice==3) { //저장/종료
				//저장
				ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(arr);
				//종료
				System.out.println("종료");
				System.exit(0);
			}else { //입력오류
				System.out.println("입력오류");
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FriendMain fm = new FriendMain();
		fm.fileuse();

	}

}
