/**
 * 
 */
package com.eqinson.concurrency;

/**
 * Which of these idioms should you use? The first idiom, which employs a
 * Runnable object, is more general, because the Runnable object can subclass a
 * class other than Thread. The second idiom is easier to use in simple
 * applications, but is limited by the fact that your task class must be a
 * descendant of Thread. This lesson focuses on the first approach, which
 * separates the Runnable task from the Thread object that executes the task.
 * Not only is this approach more flexible, but it is applicable to the
 * high-level thread management APIs covered later.
 */
public final class CreateThread {
	private static class HelloRunnable implements Runnable {
		public void run() {
			System.out.println("Hello from a thread!");
		}
	}

	private static class HelloThread extends Thread {
		public void run() {
			System.out.println("Hello from a thread!");
		}
	}

	public static void main(String args[]) {
		(new Thread(new HelloRunnable())).start();
		(new HelloThread()).start();
	}
}
