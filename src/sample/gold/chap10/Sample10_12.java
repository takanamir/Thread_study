package sample.gold.chap10;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Sample10_12 {
	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		new Thread(() -> {
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				System.out.println("ThreadA : " + itr.next());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add("E");
		System.out.println("main : add()");
		list.remove(2);
		System.out.println("main : remove()");
	}
}