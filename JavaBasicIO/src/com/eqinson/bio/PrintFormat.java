package com.eqinson.bio;

public final class PrintFormat {

	public static void main(String[] args) {
		int i = 2;
		double r = Math.sqrt(i);

		System.out.format("The square root of %d is %f.%n", i, r);
		System.out.format("%f, %1$+020.10f %n", Math.PI);
	}
}
