/**
 * 
 */
package com.eqinson.jmx.mbean;

/**
 * @author eqinson
 *
 */
public interface HelloMBean {
	public void sayHello();

	public int add(int x, int y);

	public String getName();

	public int getCacheSize();

	public void setCacheSize(int size);
}
