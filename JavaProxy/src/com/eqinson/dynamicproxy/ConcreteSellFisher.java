package com.eqinson.dynamicproxy;

public class ConcreteSellFisher implements SellFisher {

	public int sellFish() {
		System.out.println("my fish is delicious!!");
		return 10;
	}

}