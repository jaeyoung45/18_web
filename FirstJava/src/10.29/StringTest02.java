package chap06;

public class StringTest02 {

	public static void main(String[] args) {
		String str = "�ȳ��ϼ��� Hello ������ �ڹٰ���!!!";
		System.out.println("str ���� :"+str.length());
		System.out.println("H��ġ :"+str.indexOf('H'));
		System.out.println("Hello��ġ :"+str.indexOf("Hello"));
		System.out.println("4��° ����:"+str.charAt(4));
		String tmp = "������ �սô�";
		System.out.println("str tmp ����:"+str.concat(tmp));
		System.out.println("str tmp ����:"+str+tmp);
		int value = 7;
		System.out.println("str�� value ���� :"+str+value);
		String s = String.valueOf(value);
		System.out.println(s);
		
		//tmp�� value ����
		System.out.println("tmp�� value ���� :"+tmp.concat(String.valueOf(value)));
	
	}

}
