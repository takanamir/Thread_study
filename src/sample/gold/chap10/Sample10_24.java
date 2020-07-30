package sample.gold.chap10;

import java.util.Arrays;

public class Sample10_24 {
	public static void main(String[] args) {
		Arrays.asList("hana", "ken", "mika")
				.stream()
				.map(s -> s.toUpperCase())
				.forEach(s -> System.out.print(s + " "));
		System.out.println();
		Arrays.asList("hana", "ken", "mika")
				.parallelStream()
				.map(
						s -> {
							System.out.print(s + " ");
							return s.toUpperCase();
						})
				.forEach(s -> System.out.print(s + " "));
	}
}