package chap06;

public class StringTest06 {

	public static void main(String[] args) {
		String str = "string";
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb);
		sb.append("java");
		System.out.println(sb);
		sb.insert(2, " oracle");
		System.out.println(sb);
		sb.replace(1, 3, " database");
		System.out.println(sb);
		sb.delete(2, 5);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.charAt(3));
		
		StringBuffer sf = new StringBuffer("java");
		sf.append(" oracle ");
		System.out.println(sf);
		sf.reverse();
		System.out.println(sf);
	}

}
