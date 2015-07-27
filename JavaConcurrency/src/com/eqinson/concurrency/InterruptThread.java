/**
 * 
 */
package com.eqinson.concurrency;

/**
 * @author eqinson
 *
 */
public final class InterruptThread {

	private static class HelloRunnable implements Runnable {
		String importantInfo[] = { "Mares eat oats", "Does eat oats",
				"Little lambs eat ivy", "A kid will eat ivy too" };

		public void run() {
			for (int i = 0; i < importantInfo.length; i++) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
				System.out.println(importantInfo[i]);
			}

			/**
			 * heavyCrunch(inputs[i]); 
			 * if (Thread.interrupted()) { // We've been
			 * interrupted: no more crunching. return; }
			 */
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new HelloRunnable());
		t.start();
		Thread.sleep(1000);
		t.interrupt();
	}

}
