package objectArray;
import java.util.Scanner;
public class p245_8 {
	private String name, tel;
	static Scanner sc = new Scanner(System.in);
	public p245_8() {}
	public p245_8(String name, String tel)  {
		this.name=name;
		this.tel=tel;
	}
	
	public String getName() {
		return name;
	}	
	public String getTel() {
		return tel;
	}
	public String searchPhone( p245_8[] arr) {
		System.out.println("ã�� ģ�� �̸�...");
		String name = sc.next();

		
		/*for(int i=0; i<arr.length;i++) {
			if(arr[i].getName().equals(name)) { //�迭�� name�� ã�� �̸� name ������?
			return "�̸� :"+name +"/��ȭ:" +((p245_8) arr[i]).getTel();
			}
		}
		return "ã�� ģ�� ����";
	}*/
		String str="";
		boolean flag = false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getName().equals(name)) {
				flag=true;
				str+="�̸� :"+ name +"/��ȭ :" +arr[i].getTel()+"\n";
			}
		}
		if(flag == false) str = "ã�� ģ�� ����";
		return str;
	}	
	public static void main(String[] args) {
		
		 System.out.println("�Է¼� >>");
		 int num = sc.nextInt();
		 p245_8[] arr= new p245_8[num];
		 for(int i=0; i<arr.length; i++) {
			 System.out.println("�̸� >>");
			 String name = sc.next();
			 System.out.println("��ȭ>>");
			 String tel = sc.next();
			 arr[i] = new p245_8(name,tel);
			 
		 }
		 for(int i=0; i<arr.length; i++) {
			 System.out.println("�̸� :"+arr[i].getName());
			 System.out.println("��ȭ :"+arr[i].getTel());
			 System.out.println();
			 
			
		 }
		 p245_8 p = new  p245_8();
		 System.out.println("ã��ģ�� :"+p.searchPhone(arr));
		 sc.close();
	}
}	
