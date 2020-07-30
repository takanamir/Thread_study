package sample.gold.chap10;

import java.util.Arrays;

public class Sample10_27 {
	public static void main(String[] args) {
		Integer total = Arrays.asList(10, 20, 30, 40, 50)
				.parallelStream()
				.reduce(0,
						(sum, a) -> {
							System.out.println("sum:" + sum + " a:" + a);
							return sum += a;
						},
						(b, c) -> {
							System.out.println("b:" + b + " c:" + c);
							return b + c;
						});
		System.out.println("total : " + total);
	}
}