package chap06;

public class EncryptTest {
	private String encrypt(String msg) {
		String value="";
		for(int i=0; i<msg.length(); i++) {
			if(msg.charAt(i)==' '){
			value+=(char)(msg.charAt(i));
			}else {
			}value+=(char)(msg.charAt(i)+2);
		}
		return value;
	}
	public String decrypt(String str1) {
		String value="";
		for(int i=0; i<str1.length(); i++) {
			if(str1.charAt(i)==' '){
				value+=str1.charAt(i);
			}else {
			}
			value+=(char)(str1.charAt(i)-2);
		}
		return value;
	}
	
	public static void main(String[] args) {
		EncryptTest enc = new EncryptTest();
		String msg = "Hi.. Glad to meet you!!";
		//암호화 전 : Hi.. Glad to meet you!!
		System.out.println("암호화 전 :"+msg);
		String str1 = enc.encrypt(msg);
		
		//Jk00
		System.out.println("암호화 후 :"+str1); //+2
		//복호화 : Hi.. Glad to meet you!!
		System.out.println("복호화 후 :"+enc.decrypt(str1)); //-2
		System.out.println(msg.substring(4));
		System.out.println(msg.substring(0, 3));

	}

}
