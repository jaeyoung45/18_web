package chap06;

public class MathEx {

	public static void main(String[] args) {
		double a = Math.PI;
		System.out.println(a); //������
		System.out.println(Math.ceil(a)); //�ø�
		System.out.println(Math.floor(a)); //����
		System.out.println(Math.round(a)); //�ݿø�
		System.out.println(Math.round(3.6)); //�ݿø�
		System.out.println(Math.sqrt(9)); //������
		System.out.println(Math.exp(2)); //e�� 2��
		//����
		System.out.println(Math.random()); //0���� 1���� ����
		
		//�ζ� ��ȣ ���� -> 1���� 45������ �� 6�� ���
////		int b = (int) (Math.random()*45);
//		System.out.println("---�ζ� ��ȣ---");
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
		//��¹�
		for(int i=0; i<lotto.length; i++) {
			if(lotto[i]==1) {
				//system.out.println("lotto :"+lotto[i] );
				System.out.println("lotto :" +(i+1));
			}
		}
	}
}
