package chap06;

public class StringTest03 {

	public static void main(String[] args) {
		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		//tmp���� ���
		System.out.println("tmp ���� :"+tmp.length());
		String[] arr = tmp.split(" ");
		//arr �迭�� ����
		System.out.println("arr ���� :"+arr.length);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		//a ���� 16������ ���
		int a = 15;
		System.out.println(Integer.toHexString(a));
		String b= "14";
		//b ���� 16������ ���
		int v = Integer.parseInt(b);
		System.out.println(Integer.toHexString(v));
		System.out.println(Integer.toHexString(Integer.parseInt(b)));
		//arr�� 16������ ��ȯ
		System.out.println("arr ���� :"+arr.length);
		System.out.println("----16����----");
		for(int i=0; i<arr.length; i++) {
			//System.out.print(arr[i]+"\t");
			int y = Integer.parseInt(arr[i]);
			System.out.print(Integer.toHexString(y)+"\t");
		}
		System.out.println();
		//arr�� 16������ ��ȯ ->�빮�ڷ�
				System.out.println("arr ���� :"+arr.length);
				System.out.println("----16����----");
				for(int i=0; i<arr.length; i++) {
					//System.out.print(arr[i]+"\t");
					int y = Integer.parseInt(arr[i]);
					System.out.print(Integer.toHexString(y).toUpperCase()+"\t");
				}
				System.out.println();
	}

}
