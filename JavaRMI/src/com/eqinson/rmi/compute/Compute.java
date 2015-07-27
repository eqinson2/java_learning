/**
 * 
 */
package com.eqinson.rmi.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author eqinson
 *
 */
public interface Compute extends Remote {
	<T> T executeTask(Task<T> t) throws RemoteException;

}
