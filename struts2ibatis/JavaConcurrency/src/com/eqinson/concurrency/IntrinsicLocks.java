/**
 * 
 */
package com.eqinson.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author eqinson
 *
 */
public final class IntrinsicLocks {

	static class MsLunch {
		private long c1 = 0;
		private long c2 = 100;
		private Object lock1 = new Object();
		private Object lock2 = new Object();

		public void inc1() {
			synchronized (lock1) {
				System.out.println(c1++);
			}
		}

		public void inc2() {
			synchronized (lock2) {
				System.out.println(c2++);
			}
		}
	}

	private static class Task1 implements Callable<String> {
		private MsLunch mslunch;

		public Task1(MsLunch m) {
			this.mslunch = m;
		}

		@Override
		public String call() throws Exception {
			mslunch.inc1();
			mslunch.inc2();
			return "";
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		MsLunch m = new MsLunch();
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 1000; i++)
			service.submit(new Task1(m));

		service.shutdown();

		while (!service.awaitTermination(1, TimeUnit.SECONDS)) {
			System.out.println("Thread pool failed to close!");
		}
		System.out.println("Thread pool closed!");

	}

}
