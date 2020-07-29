package sample.gold.chap10;

public class Sample10_2 {
	public static void main(String[] args) {
		// スレッドの作成
		Thread3 thread3 = new Thread3();
		Thread4 thread4 = new Thread4();
		Thread a = new Thread(thread3);
		Thread b = new Thread(thread4);
		// スレッドの実行開始
		a.start();
		b.start();
	}
}

//Runnableインタフェースの実装クラス
class Thread3 implements Runnable {
	public void run() { // スレッドが実行する処理
		for (int i = 0; i < 10; i++) {
			System.out.print("A:" + i + " ");
		}
	}
}

// Runnableインタフェースの実装クラス
class Thread4 implements Runnable {
	public void run() { // スレッドが実行する処理
		for (int i = 0; i < 10; i++) {
			System.out.print("B:" + i + " ");
		}
	}
}