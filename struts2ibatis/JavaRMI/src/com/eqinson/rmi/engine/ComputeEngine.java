/**
 * 
 */
package com.eqinson.rmi.engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.eqinson.rmi.compute.Compute;
import com.eqinson.rmi.compute.Task;

/**
 * @author eqinson
 *
 */
public final class ComputeEngine implements Compute {

	public ComputeEngine() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eqinson.rmi.compute.Compute#executeTask(com.eqinson.rmi.compute.Task)
	 */
	@Override
	public <T> T executeTask(Task<T> t) throws RemoteException {
		// TODO Auto-generated method stub
		return t.execute();
	}

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject
					.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}

}
