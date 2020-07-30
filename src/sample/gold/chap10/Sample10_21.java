package sample.gold.chap10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample10_21 {
	public static void main(String[] args) {
		List<String> data = Arrays.asList("aaa", "bb", "c");

		Stream<String> pStream1 = data.parallelStream();
		System.out.println("pStream1 : " + pStream1.isParallel());

		Stream<String> sStream2 = data.stream();
		System.out.println("sStream2 : " + sStream2.isParallel());
		Stream<String> pStream2 = sStream2.parallel();
		System.out.println("pStream2 : " + pStream2.isParallel());

		IntStream pStream3 = IntStream.range(0, 10).parallel();
		System.out.println("pStream3 : " + pStream3.isParallel());
	}
}