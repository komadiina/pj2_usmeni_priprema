package net.etfbl.concurrency.additional;

import java.util.concurrent.TimeUnit;

public class StopThread2 {
	private static volatile boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested)
					i++;
			}
		});
		Thread backgroundThread2 = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested)
					i++;
			}
		});
		backgroundThread.start();
		backgroundThread2.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}

