package collectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("이숭무", 35);
		int age = map1.get("이숭무");
		System.out.println(age);
		
		Map<Integer, Double> map2 = new HashMap<Integer, Double>();
		map2.put(1, 10.5);
		double d = map2.get(1);
		System.out.println(d);
		
		Map<String , Member> map = new HashMap<String, Member>();
		map.put("이숭무", new Member("이숭무", 30));
		map.put("이상범", new Member("이상범", 15));
		map.put("이장범", new Member("이장범", 18));
		map.put("이길무", new Member("이길무", 85));
				
		Member m = map.get("이숭무");
		System.out.println(m.getAge());
						
	}

}
