package sample.gold.chap10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Sample10_9 {
	public static void main(String[] args) {
		BlockingQueue<Double> queue = new LinkedBlockingQueue<>(3);
		new Thread(() -> { //キューに要素を追加するスレッド
			while (true) {
				try {
					queue.offer(Math.random(), 2, TimeUnit.SECONDS);
					System.out.println("offer() : " + queue.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> { //キューから要素を取得および削除するスレッド
			int count = 1;
			while (count <= 10) {
				try {
					double pNum = queue.poll(2, TimeUnit.SECONDS);
					System.out.println("poll() : " + pNum);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count++;
			}
		}).start();
	}
}