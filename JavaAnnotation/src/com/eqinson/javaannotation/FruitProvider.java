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
@interface FruitProvider {
	/**
	 * @return
	 */
	int id() default -1;

	/**
	 * @return
	 */
	String name() default "";

	/**
	 * @return
	 */
	String address() default "";
}
