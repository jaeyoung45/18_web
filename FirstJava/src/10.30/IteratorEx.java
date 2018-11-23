package chap07;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2,100);
		for(Integer i : v) {
			System.out.print(i +" ");
		}
		System.out.println();
		Iterator<Integer> it=v.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.print(i+ " ");
		}
		it = v.iterator();
		int sum = 0;
		while(it.hasNext()) {
			int a = it.next();
			sum += a;
		}
		System.out.println();
		System.out.println("гу╟Х :"+sum);
		int hap = 0;
		for(int b : v) {
			hap += b;
		}
		System.out.println("гу :"+hap);
	}


}
