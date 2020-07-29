package sample.gold.chap10;

import java.util.HashMap;
import java.util.Map;

public class Sample10_8 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "tanaka");
		map.put(2, "urai");
		//map.remove(1);      map.remove(2);
		for (Integer key : map.keySet()) {
			map.remove(key);
		}
	}
}