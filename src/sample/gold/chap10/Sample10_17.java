package sample.gold.chap10;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sample10_17 {
	public static void main(String[] args) {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			Runnable task = () -> System.out.println(new Date());
			service.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}