package collectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		set.add(new Member("全辨悼", 30)); // Member
		set.add(new Member("捞件公", 50)); // Member
		System.out.println(set.size());
		
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m.getName());
			if(m.getName().equals("捞件公")) {
				set.remove(m);
				break;
			}
		}
		System.out.println(set.size());
		
		for(Member m : set) {
			if(m.getName().equals("全辨悼")) {
				set.remove(m);
				break;
			}
		}
		System.out.println(set.size());
	}
}
