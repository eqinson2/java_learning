package com.eqinson.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class JoinForkSortTask extends RecursiveAction {
	private static final long serialVersionUID = -472080785565337314L;

	final long[] array;
	final int start;
	final int end;
	private int THRESHOLD = 100; // For demo only

	public JoinForkSortTask(long[] array) {
		this.array = array;
		this.start = 0;
		this.end = array.length - 1;
	}

	public JoinForkSortTask(long[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	protected void compute() {
		if (end - start < THRESHOLD)
			sequentiallySort(array, start, end);
		else {
			int pivot = partition(array, start, end);
			JoinForkSortTask left = new JoinForkSortTask(array, start,
					pivot - 1);
			JoinForkSortTask right = new JoinForkSortTask(array, pivot + 1, end);
			left.fork();
			right.fork();
		}
	}

	private int partition(long[] array, int start, int end) {
		long x = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j] <= x) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

	private void swap(long[] array, int i, int j) {
		if (i != j) {
			long temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	private void sequentiallySort(long[] array, int lo, int hi) {
		Arrays.sort(array, lo, hi + 1);
	}

	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Random rnd = new Random();
		final int SIZE = 20000000;
		long[] array = new long[SIZE];
		long[] array2 = new long[SIZE];
		for (int i = 0; i < SIZE; i++) {
			array[i] = rnd.nextInt();
			array2[i] = array[i];
		}

		long startTimestamp = System.currentTimeMillis();
		forkJoinPool.submit(new JoinForkSortTask(array));
		forkJoinPool.shutdown();
		forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS);
		System.out.println(System.currentTimeMillis() - startTimestamp);

		startTimestamp = System.currentTimeMillis();
		Arrays.sort(array2, 0, SIZE);
		System.out.println(System.currentTimeMillis() - startTimestamp);

		for (int i = 1; i < SIZE; i++) {
			if (array[i - 1] > array[i])
				System.out.println(false);
			if (array2[i - 1] > array2[i])
				System.out.println(false);
		}
	}
}