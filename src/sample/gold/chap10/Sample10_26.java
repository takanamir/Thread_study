package sample.gold.chap10;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Sample10_26 {
	public static void main(String[] args) {
		List<String> data1 = Arrays.asList("c", "a", "d", "b");
		Optional<String> rerult1 = data1.parallelStream().findFirst();
		Optional<String> rerult2 = data1.parallelStream().findAny();
		System.out.println(rerult1.get() + " " + rerult2.get());

		List<String> data2 = Arrays.asList("c", "a", "d", "b");
		Optional<String> rerult3 = data2.parallelStream().findFirst();
		Optional<String> rerult4 = data2.parallelStream().findAny();
		System.out.println(rerult3.get() + " " + rerult4.get());
	}
}