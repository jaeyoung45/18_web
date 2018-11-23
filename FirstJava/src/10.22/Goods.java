package chap04;

public class Goods {
	String code;
	String name;
	String maker;
	int price;
	double discountRate;
	
	public Goods(String code, String name, String maker, int price) {
		this.code=code;
		this.name=name;
		this.maker=maker;
		this.price=price;
	}
	
	public void updateDiscountRate(double rate) {
		discountRate = rate;
	}
	public double getSellPrice() {
		return price-(price*discountRate);
	}
	
	public static void main(String[] args) {
		Goods g1 = new Goods("0001","�ڹ�","�ڹ����ǻ�",10000);
		g1.updateDiscountRate(0.2);
		System.out.println("�Ǹž� :"+g1.getSellPrice());

		Goods g2 = new Goods("0002","����Ŭ","����Ŭ���ǻ�",20000);
		g2.updateDiscountRate(0.3);
		System.out.println("�Ǹž� :"+g2.getSellPrice());
		
		g1.updateDiscountRate(0.4);
		System.out.println("�Ǹž� :" +g1.getSellPrice());

	}

}
