package objectArray;
import java.util.Scanner;

//�̸�, �ּ�, ����, Ű, ������
//(name,address,age, height,weight)�� ������ ���� Ŭ����(Player)�� �����ϰ�

class Player{
	private String name, address;
	private int age, height, weight;
	//������
	public Player() {
		
	}
public Player(String name, String address, int age, int height, int weight) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
//	public Player(String name, String address, int age, int height, int weight){
//		this.name=name;
//		this.address=address;
//		this.age=age;
//		this.height=height;
//		this.weight=weight;
//	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
}
}
//������(PlayerManager)��//-�������(insertData),
//-��ü����(viewData),
//-����ã��(searchData)�� ���� �Ѵٰ� ����.
//�����ڴ� �ִ� 30���� ������ �����Ѵ�.

class PlayerManager{
	private final int MAX_INT=30;
	Player[] arr = new Player[30];
	private int cnt;
		public void insertData() {
			System.out.println("������ ����ϼ���.");
			System.out.print("�̸�  : ");
			String name = PlayerMain.sc.next();
			System.out.print("�ּ� : ");
			String address = PlayerMain.sc.next();
			System.out.print("���� : ");
			int age = PlayerMain.sc.nextInt();
			System.out.print("Ű : ");
			int height = PlayerMain.sc.nextInt();
			System.out.print("������ : ");
			int weight = PlayerMain.sc.nextInt();
			//arr[cnt]= new Player(name,address,age,height,weight);
			arr[cnt] = new Player();
			arr[cnt].setName(name);
			arr[cnt].setAge(age);
			arr[cnt].setAddress(address);
			arr[cnt].setWeight(weight);
			arr[cnt].setHeight(height);
			cnt++;
		}
		public void viewData() {
			System.out.println("������ ��ü����");		
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==null)break;
				System.out.println("�̸� :"+arr[i].getName());
				System.out.print("���� :"+arr[i].getAge());
			}
		}
		public void searchData() {
			System.out.println("���� ã��");
			System.out.print("ã�� ���� �̸�...");
			String name = PlayerMain.sc.next();
			Player p = search(name);	
			if(p==null) {
				System.out.println("ã�� ���� ����");
				return;
			}
			//�̸�, ����, Ű, ������
			System.out.println("�̸� :"+p.getName());
			System.out.println("���� :"+p.getAge());
			System.out.println("�ּ�:"+p.getAddress());
			System.out.println("Ű :"+p.getHeight());
			System.out.println("������ :"+p.getWeight());
			}
		private Player search(String name) {
			for(int i=0;i<cnt;i++) {
				if(arr[i].getName().equals(name)) {
					return arr[i];
				}
			}
			return null;
		}
}

public  class PlayerMain{
	public static Scanner sc = new Scanner(System.in);	
	public static void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1.������ �Է�");
		System.out.println("2.��ü����");
		System.out.println("3.����ã��");
		System.out.println("4.����");
		System.out.print("���� :");
		}	

	public static void main(String[] args) {
		PlayerManager pm = new PlayerManager();
		while(true) {
			PlayerMain.showMenu();
			int choice=PlayerMain.sc.nextInt();
			PlayerMain.sc.nextLine();
			switch(choice) {
			case 1 :pm.insertData();break;
			case 2 :pm.viewData();break;
			case 3 :pm.searchData();break;
			case 4 :System.out.println("����");
			System.exit(0);
			break;
			default : System.out.println("�Է¿���");
			}
		}
	}
}