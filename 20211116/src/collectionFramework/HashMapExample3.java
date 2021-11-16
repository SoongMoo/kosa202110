package collectionFramework;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapExample3 {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, String> map = new Hashtable<String, String>();
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
	}
}
