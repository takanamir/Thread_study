package sample.gold.chap10;

public class Sample10_5 {
	public static void main(String[] args) {
		Share3 share = new Share3();
		Thread5 thread5 = new Thread5(share);
		Thread6 thread6= new Thread6(share);
		thread5.start();
		thread6.start();
	}
}

class Share { // 共有して使用されるオブジェクト
	private int a = 0;
	private String b;

	public void set() {
		a++;
		b = "data";
		System.out.println("set() a : " + a + " b: " + b);
	}

	public void print() {
		a--;
		b = null;
		System.out.println(" print() a : " + a + " b: " + b);
	}
}

class Thread5 extends Thread {
	private Share3 share;

	public Thread5(Share3 share) {
		this.share = share;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			share.set();
		}
	}
}

class Thread6 extends Thread {
	private Share3 share;

	public Thread6(Share3 share) {
		this.share = share;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			share.print();
		}
	}
}