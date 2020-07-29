package sample.gold.chap10;

public class Sample10_7 {
	public static void main(String[] args) {
		Share3 share3 = new Share3();
		Thread9 thread9 = new Thread9(share3);
		Thread10 thread10 = new Thread10(share3);
		thread9.start();
		thread10.start();
	}
}

class Share3 { // 共有して使用されるオブジェクト
	private int a = 0;
	private String b;

	public synchronized void set() {
		while (a != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		notify();
		a++;
		b = "data";
		System.out.println("set() a : " + a + " b: " + b);
	}

	public synchronized void print() {
		while (b == null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		notify();
		a--;
		b = null;
		System.out.println("  print() a : " + a + " b: " + b);
	}
}

class Thread9 extends Thread {
	private Share3 share3;

	public Thread9(Share3 share3) {
		this.share3 = share3;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			share3.set();
		}
	}
}

class Thread10 extends Thread {
	private Share3 share3;

	public Thread10(Share3 share3) {
		this.share3 = share3;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			share3.print();
		}
	}
}