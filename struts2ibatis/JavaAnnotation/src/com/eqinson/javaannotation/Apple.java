/**
 * 
 */
package com.eqinson.javaannotation;

import com.eqinson.javaannotation.FruitColor.Color;

/**
 * @author eqinson
 *
 */
class Apple {

	@FruitName("Apple")
	private String appleName;

	@FruitColor(fruitColor = Color.RED)
	private String appleColor;

	@FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
	private String appleProvider;

	void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	String getAppleColor() {
		return appleColor;
	}

	void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	String getAppleName() {
		return appleName;
	}

	void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}

	String getAppleProvider() {
		return appleProvider;
	}

	void displayName() {
		System.out.println("水果的名字是：苹果");
	}
}
