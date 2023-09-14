package bit701.day0914;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set 인터페이스의 특징
		// 1. 순차적이 아니다
		// 2. 중복 허용을 안한다

//		Set<Integer> set = new HashSet<Integer>(); // 비순차적
		Set<Integer> set = new TreeSet<Integer>(); // 오름차순 정렬됨
		
		System.out.println(set.size()); // size는 데이터의 개수(배열은 length)
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size()); //3 (5는 한 번으로 계산됨)
		
		System.out.println();
		
		// 컬렉션들을 출력하는 방법에는 여러가지가 있다
		// 출력1
		for(Integer n:set) {
			System.out.println(n);
		}
		
		System.out.println();
		
		// 출력2
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
