package bit701.day0914;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex8_Set {
	public static void main(String[] args) {
//		Set<String> set = new HashSet<String>();
		Set<String> set = new TreeSet<String>();
		
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("green");
		set.add("green");
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("yellow");
		System.out.println(set.size()); // 중복된 거 빼고 4개
		
		for(String s:set) {
			System.out.println(s);
		}
	}
}
