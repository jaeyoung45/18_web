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
		System.out.println("찾을 친구 이름...");
		String name = sc.next();

		
		/*for(int i=0; i<arr.length;i++) {
			if(arr[i].getName().equals(name)) { //배열의 name과 찾는 이름 name 같은가?
			return "이름 :"+name +"/전화:" +((p245_8) arr[i]).getTel();
			}
		}
		return "찾는 친구 없음";
	}*/
		String str="";
		boolean flag = false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getName().equals(name)) {
				flag=true;
				str+="이름 :"+ name +"/전화 :" +arr[i].getTel()+"\n";
			}
		}
		if(flag == false) str = "찾는 친구 없음";
		return str;
	}	
	public static void main(String[] args) {
		
		 System.out.println("입력수 >>");
		 int num = sc.nextInt();
		 p245_8[] arr= new p245_8[num];
		 for(int i=0; i<arr.length; i++) {
			 System.out.println("이름 >>");
			 String name = sc.next();
			 System.out.println("전화>>");
			 String tel = sc.next();
			 arr[i] = new p245_8(name,tel);
			 
		 }
		 for(int i=0; i<arr.length; i++) {
			 System.out.println("이름 :"+arr[i].getName());
			 System.out.println("전화 :"+arr[i].getTel());
			 System.out.println();
			 
			
		 }
		 p245_8 p = new  p245_8();
		 System.out.println("찾는친구 :"+p.searchPhone(arr));
		 sc.close();
	}
}	
