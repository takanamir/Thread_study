package sample.gold.chap10;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample10_11 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
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