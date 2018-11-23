package objectArray;
import java.util.Scanner;

//이름, 주소, 나이, 키, 몸무게
//(name,address,age, height,weight)를 가지는 선수 클래스(Player)를 선언하고

class Player{
	private String name, address;
	private int age, height, weight;
	//생성자
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
//관리자(PlayerManager)는//-선수등록(insertData),
//-전체보기(viewData),
//-선수찾기(searchData)의 일을 한다고 하자.
//관리자는 최대 30명의 선수를 관리한다.

class PlayerManager{
	private final int MAX_INT=30;
	Player[] arr = new Player[30];
	private int cnt;
		public void insertData() {
			System.out.println("선수를 등록하세요.");
			System.out.print("이름  : ");
			String name = PlayerMain.sc.next();
			System.out.print("주소 : ");
			String address = PlayerMain.sc.next();
			System.out.print("나이 : ");
			int age = PlayerMain.sc.nextInt();
			System.out.print("키 : ");
			int height = PlayerMain.sc.nextInt();
			System.out.print("몸무게 : ");
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
			System.out.println("데이터 전체보기");		
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==null)break;
				System.out.println("이름 :"+arr[i].getName());
				System.out.print("나이 :"+arr[i].getAge());
			}
		}
		public void searchData() {
			System.out.println("선수 찾기");
			System.out.print("찾을 선수 이름...");
			String name = PlayerMain.sc.next();
			Player p = search(name);	
			if(p==null) {
				System.out.println("찾는 선수 없음");
				return;
			}
			//이름, 나이, 키, 몸무게
			System.out.println("이름 :"+p.getName());
			System.out.println("나이 :"+p.getAge());
			System.out.println("주소:"+p.getAddress());
			System.out.println("키 :"+p.getHeight());
			System.out.println("몸무게 :"+p.getWeight());
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
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.전체보기");
		System.out.println("3.선수찾기");
		System.out.println("4.종료");
		System.out.print("선택 :");
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
			case 4 :System.out.println("종료");
			System.exit(0);
			break;
			default : System.out.println("입력오류");
			}
		}
	}
}