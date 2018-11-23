package chap07;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		List<Integer> list = new LinkedList<Integer>(set);
		System.out.println("정렬전:"+list);
		Collections.sort(list);
		System.out.println("정렬후:"+list);
	}

}
