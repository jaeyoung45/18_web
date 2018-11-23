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
		System.out.println(menu+"\t"+price+"원"+"\t"+count+"개"+"\t"+ "합계 :"+getTotal()+"원");
	}
	
	public static void main(String[] args) {
		Drink[] arr = new Drink[100]; //배열 선언& 생성
		arr[0]= new Drink("커피",3000,3); // 배열 초기화
		arr[1]= new Drink("카페라테",4000,2);
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==null) break;
			arr[i].printDrink();
			sum += arr[i].getTotal();
		}
		System.out.println("총판매액:"+sum);
		//Drink d1 = new Drink("커피",3000,3);
		//d1.printDrink();
		
		//Drink d2 = new Drink("카페라테",4000,2);
		//d2.printDrink();
		//System.out.println("총판매액 :"+(d1.getTotal()+(d2.getTotal()))+"원");
	}

}
