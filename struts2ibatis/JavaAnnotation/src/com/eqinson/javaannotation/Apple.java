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

	@FruitProvider(id = 1, name = "�����츻ʿ����", address = "����ʡ�������Ӱ�·89�ź츻ʿ����")
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
		System.out.println("ˮ���������ǣ�ƻ��");
	}
}
