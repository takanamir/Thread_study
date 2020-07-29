package sample.gold.chap10;

public class Sample10_1 {
	public static void main(String[] args) {
		// スレッドの作成
		Thread1 a = new Thread1();
		Thread2 b = new Thread2();
		// スレッドの実行開始
		a.start();
		b.start();
	}
}

class Thread1 extends Thread {//スレッドクラス
	public void run() { // スレッドが実行する処理
		for (int i = 0; i < 10; i++) {
			System.out.print("A:" + i + " ");
		}
	}
}

class Thread2 extends Thread {//スレッドクラス
	public void run() { // スレッドが実行する処理
		for (int i = 0; i < 10; i++) {
			System.out.print("B:" + i + " ");
		}
	}
}