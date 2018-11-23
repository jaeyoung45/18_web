package chap06;

public class MathEx {

	public static void main(String[] args) {
		double a = Math.PI;
		System.out.println(a); //원주율
		System.out.println(Math.ceil(a)); //올림
		System.out.println(Math.floor(a)); //버림
		System.out.println(Math.round(a)); //반올림
		System.out.println(Math.round(3.6)); //반올림
		System.out.println(Math.sqrt(9)); //제곱근
		System.out.println(Math.exp(2)); //e의 2승
		//난수
		System.out.println(Math.random()); //0에서 1사이 난수
		
		//로또 번호 생성 -> 1에서 45사이의 수 6개 출력
////		int b = (int) (Math.random()*45);
//		System.out.println("---로또 번호---");
//		for(int i=0; i<6; i++)
//		System.out.print((int)(Math.random()*45 +1)+" ");
		System.out.println("------");
		int[]lotto = new int[45];
		int cnt=0;
		while(true) {
			if(cnt==6) break;
			int v= (int)(Math.random()*45)+1;
			if(lotto[v-1]==1)continue;
			lotto[v-1] = 1;
			cnt++;
	}
		//출력문
		for(int i=0; i<lotto.length; i++) {
			if(lotto[i]==1) {
				//system.out.println("lotto :"+lotto[i] );
				System.out.println("lotto :" +(i+1));
			}
		}
	}
}
