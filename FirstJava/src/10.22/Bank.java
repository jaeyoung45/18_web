package chap04;

public class Bank {
	String name;
	int money; //�ܾ�
	public Bank() {} //������
	public Bank(String name) { //������
		this.name = name;
	}
	public Bank(String name, int money) { //������
		this.name = name;
		this.money = money;
	}
	
	//�Ա�
	public void inputMoney(int won) {
		money +=won;
	}
	//���
	public void outputMoney(int won) { //����� �ܾ׸�ŭ ����
		/*if(money>=won) {
			money -=won;
		}else {
			System.out.println(name +"�� �ܾ׺���");
		}*/	
		if(money-won<0) {
		return;
		}
		money -=won;
	}
	
	//�ܾ�Ȯ��
	public void getMoney() {
		
	
		if(money<0) {
			System.out.println("�ܾ��� �����մϴ�.");
		}else {
			System.out.println(name+"�� �ܾ��� :"+money+" �Դϴ�." );
			}
		}
	
	
	public static void main(String[] args) {
		Bank b1 = new Bank();
		b1.name="ȫ�浿";
		b1.inputMoney(5000); //5000�� �Ա�
		b1.outputMoney(3000); //3000�� �Ա�
		b1.getMoney(); //�ܾ�Ȯ�� <- ȫ�浿�� �ܾ��� 2000�� �Դϴ�.
		
		Bank b2 = new Bank();
		b2.name="������";
		b2.inputMoney(10000);
		b2.outputMoney(15000);
		b2.getMoney();
		
		Bank b3 = new Bank("�̼���");
		b3.getMoney();
		Bank b4 = new Bank("ȫ���",1000);
		b4.getMoney();
		Bank b5 = new Bank("�̵���",20000);
		b5.outputMoney(5000);
		b5.getMoney();
	}
}
