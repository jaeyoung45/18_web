package chap06;

import java.util.StringTokenizer;

public class StringTok {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("1 0 14 15 8");
		System.out.println(st.countTokens());
		//System.out.println(st.nextToken());//
		while(st.hasMoreTokens()) {
			System.out.println(st.countTokens());
			//System.out.println(st.nextToken());
			System.out.println(Integer.toHexString(Integer.parseInt(st.nextToken())));
			System.out.println();
		}
		StringTokenizer stk = new StringTokenizer("È«±æµ¿/ÀåÈ­/È«·Ã/ÄáÁã/ÆÏÁã/ÁÖÀÎ°ø","/");
		System.out.println(stk.countTokens());
	}

}
