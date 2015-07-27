/**
 * 
 */
package com.eqinson.javacollection;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author eqinson
 *
 */
public final class JavaBlockingQueue {

	static class Consumer implements Runnable {
		private BlockingQueue<String> queue;
		private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			System.out.println("�����������̣߳�");
			Random r = new Random();
			boolean isRunning = true;
			try {
				while (isRunning) {
					System.out.println("���Ӷ��л�ȡ����...");
					String data = queue.poll(2, TimeUnit.SECONDS);
					if (null != data) {
						System.out.println("�õ����ݣ�" + data);
						System.out.println("�����������ݣ�" + data);
						Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
					} else {
						// ����2s��û���ݣ���Ϊ���������̶߳��Ѿ��˳����Զ��˳������̡߳�
						isRunning = false;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				System.out.println("�˳��������̣߳�");
			}
		}
	}

	static class Producer implements Runnable {
		private volatile boolean isRunning = true;
		private BlockingQueue<String> queue;
		private static AtomicInteger count = new AtomicInteger();
		private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			String data = null;
			Random r = new Random();

			System.out.println("�����������̣߳�");
			try {
				while (isRunning) {
					System.out.println("������������...");
					Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));

					data = "data:" + count.incrementAndGet();
					System.out.println("�����ݣ�" + data + "�������...");
					if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
						System.out.println("��������ʧ�ܣ�" + data);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				System.out.println("�˳��������̣߳�");
			}
		}

		public void stop() {
			isRunning = false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		// ����һ������Ϊ10�Ļ������
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		// ����Executors
		ExecutorService service = Executors.newCachedThreadPool();
		// �����߳�
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);

		// ִ��10s
		Thread.sleep(10 * 1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();

		Thread.sleep(2000);
		// �˳�Executor
		service.shutdown();
	}
}
