package sample.gold.chap10;

public class Sample10_6 {
	public static void main(String[] args) {
		Share2 share2 = new Share2();
		Thread7 thread7 = new Thread7(share2);
		Thread8 thread8 = new Thread8(share2);
		thread7.start();
		thread8.start();
	}
}

class Share2 { // 共有して使用されるオブジェクト
	private int a = 0;
	private String b;

	public synchronized void set() {
		a++;
		b = "data";
		System.out.println("set() a : " + a + " b: " + b);
	}

	public synchronized void print() {
		a--;
		b = null;
		System.out.println("  print() a : " + a + " b: " + b);
	}
}

class Thread7 extends Thread {
	private Share2 share2;

	public Thread7(Share2 share2) {
		this.share2 = share2;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			share2.set();
		}
	}
}

class Thread8 extends Thread {
	private Share2 share2;
	public Thread8(Share2 share2) {
		this.share2 = share2;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			share2.print();
		}
	}
}