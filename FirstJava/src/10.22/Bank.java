package chap04;

public class Bank {
	String name;
	int money; //잔액
	public Bank() {} //생성자
	public Bank(String name) { //생성자
		this.name = name;
	}
	public Bank(String name, int money) { //생성자
		this.name = name;
		this.money = money;
	}
	
	//입금
	public void inputMoney(int won) {
		money +=won;
	}
	//출금
	public void outputMoney(int won) { //출금은 잔액만큼 가능
		/*if(money>=won) {
			money -=won;
		}else {
			System.out.println(name +"님 잔액부족");
		}*/	
		if(money-won<0) {
		return;
		}
		money -=won;
	}
	
	//잔액확인
	public void getMoney() {
		
	
		if(money<0) {
			System.out.println("잔액이 부족합니다.");
		}else {
			System.out.println(name+"님 잔액은 :"+money+" 입니다." );
			}
		}
	
	
	public static void main(String[] args) {
		Bank b1 = new Bank();
		b1.name="홍길동";
		b1.inputMoney(5000); //5000원 입금
		b1.outputMoney(3000); //3000원 입금
		b1.getMoney(); //잔액확인 <- 홍길동님 잔액은 2000원 입니다.
		
		Bank b2 = new Bank();
		b2.name="강감찬";
		b2.inputMoney(10000);
		b2.outputMoney(15000);
		b2.getMoney();
		
		Bank b3 = new Bank("이순신");
		b3.getMoney();
		Bank b4 = new Bank("홍길순",1000);
		b4.getMoney();
		Bank b5 = new Bank("이동숙",20000);
		b5.outputMoney(5000);
		b5.getMoney();
	}
}
