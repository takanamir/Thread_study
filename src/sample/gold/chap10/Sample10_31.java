package sample.gold.chap10;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class ExamRecursiveTask extends RecursiveTask<Double> {
	private Double[] nums;
	private int start;
	private int end;

	public ExamRecursiveTask(String name, Double[] nums,
			int start, int end) {
		System.out.println("name : " + name + " " +
				start + " " + end);
		this.nums = nums;
		this.start = start;
		this.end = end;
	}

	protected Double compute() {
		if (end - start <= 3) {
			double sum = 0.0;
			for (int i = start; i < end; i++) {
				nums[i] = Math.random() * 100;
				System.out.println("nums[" + i + "] " + nums[i]);
				sum += nums[i];
			}
			return sum;
		} else {
			int middle = start + (end - start) / 2;
			System.out.println("start:" + start +
					" middle:" + middle +
					" end:" + end);
			ExamRecursiveTask task1 = new ExamRecursiveTask("f1", nums, start, middle);
			ExamRecursiveTask task2 = new ExamRecursiveTask("f2", nums, middle, end);
			task1.fork();
			Double sum1 = task2.compute();
			Double sum2 = task1.join();
			return sum1 + sum2;
		}
	}
}

public class Sample10_31 {
	public static void main(String[] args) {
		Double[] nums = new Double[10];
		ForkJoinTask<Double> task = new ExamRecursiveTask("main", nums, 0, 10);
		ForkJoinPool pool = new ForkJoinPool();
		Double sum = pool.invoke(task);
		System.out.println("sum : " + sum);
	}
}