package sample.gold.chap10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample10_19 {
	void a() {
		System.out.print("a ");
	}

	void b() {
		System.out.print("b ");
	}

	void c() {
		System.out.print("c ");
	}

	void exec(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			a();
			c1.await();
			b();
			c2.await();
			c();
		} catch (BrokenBarrierException | InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(3);
			CyclicBarrier c1 = new CyclicBarrier(3);
			CyclicBarrier c2 = new CyclicBarrier(3,
					() -> System.out.print("task "));
			for (int i = 0; i < 3; i++) {
				service.execute(() -> new Sample10_19().exec(c1, c2));
			}
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}