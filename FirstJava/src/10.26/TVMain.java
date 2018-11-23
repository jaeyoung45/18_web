package examPac05;

class TV {
	private int size;
	public TV(int size) {// ������
		this.size=size;		
	}
	protected int getSize() {
		return size;
	}	
}

class ColorTV extends TV{	
	protected int color;
	public ColorTV(int size, int color) {
		super(size);
		this.color=color;		
	}
	public void printProperty() {
		System.out.println(getSize()+"��ġ"+color+"�÷�");
	}
}

class IPTV extends ColorTV{
	private String ip;
	public IPTV(String ip, int size, int color) {
		super(size, color);
		this.ip=ip;
	}
	@Override
	public void printProperty() {		
		super.printProperty();
		System.out.println("���� IPTV�� "+ip+"�ּ��� "+getSize()+"��ġ"+color+"�÷�");
	}	
}


public class TVMain {

	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048); 
		myTV.printProperty();
		iptv.printProperty();
	}
}

