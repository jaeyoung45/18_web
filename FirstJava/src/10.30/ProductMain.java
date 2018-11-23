package chap07;

import java.util.ArrayList;


class Product{
	protected int price;
	protected double bonus;
	public Product(int price) {
		this.price= price;
		//bonus = (int)(price*0.1);
		bonus = (int) (price/10);
}
}
class TV extends Product{
	private int price;
	public TV(int price) {
		super(price);
		
	}
	public String toString() {
		return "TV";
	}
}
class Computer extends Product{
	private int price;
	public Computer(int price) {
		super(price);
	}
	public String toString() {
		return "컴퓨터";
	}
}
class Audio extends Product{
	private int price;
	public Audio(int price) {
		super(price);
	}
	public String toString() {
		return "오디오";
	}
}
class Buyer{
	private int money;
	private int bonusPoint;
	private int sum;
	//ArrayList alist 생성해서 수정하기
	ArrayList <Product> alist = new ArrayList<Product>();
	
	public Buyer(int money) {
		this.money = money;
	}
	//물건사기
	public void buy(Product p) { //TV Computer Audio
		alist.add(p);
		money-=p.price;
		bonusPoint +=p.bonus;
 }
	//구매한 상품 리스트
	public void show() {
		int sum=0;
		/*for(int i=0; i<cnt; i++) {
			System.out.println(arr[i]);
			sum += arr[i].price;
		}*/
		for(Product p :arr) {
			if(p==null) break;
			System.out.println(p);
			sum += p.price;
		}
	System.out.println("포인트 :"+bonusPoint);
	System.out.println("구매금액 :" +sum);
	}
	//반품
//	public void refund(Product p) {
//		for(int i=0; i<cnt; i++) {
//			if(arr[i].equals(p)) {
//				for(int j=i; j<cnt; j++) {
//					arr[j] = arr[j+1];
//				}
//				break;
//			}
//		}
//	money +=p.price;
//	bonusPoint -=p.bonus;
//	}
//}
	public void refund(Product p) {
		for(int i=0; i<alist.size(); i++) {
			if(alist.get(i).equals(p)) {
				money += p.price;
				bonusPoint -= p.bonus;
				alist.remove(p);
				System.out.println("반품 :"+p);
				break;
			}
		}
	}
}
public class ProductMain {
	public static void main(String[] args) {
	Buyer b1 = new Buyer(1000);
	TV tv = new TV(100);
	Computer com = new Computer(50);
	Audio audio = new Audio(70);
	b1.buy(tv);
	b1.buy(com);
	b1.buy(audio);
	b1.show();
	System.out.println();
	
	//b1.refund(audio); //audio 반품
	b1.refund(com);
	b1.show();
	}
}