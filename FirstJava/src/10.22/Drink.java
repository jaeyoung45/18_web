package chap04;

public class Drink {
	
	String menu;
	int price;
	int count;
	
	public Drink(String menu, int price, int count) {
		this.menu=menu;
		this.price=price;
		this.count=count;
	}
	public int getTotal() {
		return price*count;
	}
		
	public void printDrink() {
		System.out.println(menu+"\t"+price+"��"+"\t"+count+"��"+"\t"+ "�հ� :"+getTotal()+"��");
	}
	
	public static void main(String[] args) {
		Drink[] arr = new Drink[100]; //�迭 ����& ����
		arr[0]= new Drink("Ŀ��",3000,3); // �迭 �ʱ�ȭ
		arr[1]= new Drink("ī�����",4000,2);
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==null) break;
			arr[i].printDrink();
			sum += arr[i].getTotal();
		}
		System.out.println("���Ǹž�:"+sum);
		//Drink d1 = new Drink("Ŀ��",3000,3);
		//d1.printDrink();
		
		//Drink d2 = new Drink("ī�����",4000,2);
		//d2.printDrink();
		//System.out.println("���Ǹž� :"+(d1.getTotal()+(d2.getTotal()))+"��");
	}

}
