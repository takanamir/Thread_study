package sample.gold.chap10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Sample10_10 {
	public static void main(String[] args) {
		Map<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "tanaka");
		map.put(2, "urai");
		for (Integer key : map.keySet()) {
			map.remove(key);
		}
	}
}