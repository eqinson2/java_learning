/**
 * 
 */
package com.eqinson.javaannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author eqinson
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitColor {
	/**
	 * 颜色枚举
	 * 
	 * @author peida
	 *
	 */
	enum Color {
		BULE, RED, GREEN
	};

	/**
	 * 颜色属性
	 * 
	 * @return
	 */
	Color fruitColor() default Color.GREEN;

}