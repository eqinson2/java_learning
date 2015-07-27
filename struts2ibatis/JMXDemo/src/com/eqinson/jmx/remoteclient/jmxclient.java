package com.eqinson.jmx.remoteclient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.management.AttributeChangeNotification;
import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.eqinson.jmx.mbean.HelloMBean;
import com.eqinson.jmx.mxbean.QueueSample;
import com.eqinson.jmx.mxbean.QueueSamplerMXBean;

public class jmxclient {

	public static class ClientListener implements NotificationListener {

		public void handleNotification(Notification notification,
				Object handback) {
			System.out.println("\nReceived notification:");
			System.out.println("\tClassName: "
					+ notification.getClass().getName());
			System.out.println("\tSource: " + notification.getSource());
			System.out.println("\tType: " + notification.getType());
			System.out.println("\tMessage: " + notification.getMessage());
			if (notification instanceof AttributeChangeNotification) {
				AttributeChangeNotification acn = (AttributeChangeNotification) notification;
				System.out
						.println("\tAttributeName: " + acn.getAttributeName());
				System.out
						.println("\tAttributeType: " + acn.getAttributeType());
				System.out.println("\tNewValue: " + acn.getNewValue());
				System.out.println("\tOldValue: " + acn.getOldValue());
			}
		}

	}

	private static void getDomains(MBeanServerConnection mbsc)
			throws IOException {
		System.out.println("\nDomains:");
		String domains[] = mbsc.getDomains();
		Arrays.sort(domains);
		for (String domain : domains) {
			System.out.println("\tDomain = " + domain);
		}

		System.out.println("\nMBeanServer default domain = "
				+ mbsc.getDefaultDomain());

		System.out.println("\nMBean count = " + mbsc.getMBeanCount());
		System.out.println("\nQuery MBeanServer MBeans:");
		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null,
				null));
		for (ObjectName name : names) {
			System.out.println("\tObjectName = " + name);
		}
	}

	private static void performOperationsOnRemoteMBeans() throws IOException,
			InstanceNotFoundException, MalformedObjectNameException {

		JMXServiceURL url = new JMXServiceURL(
				"service:jmx:rmi:///jndi/rmi://:9998/jmxrmi");
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
		
		getDomains(mbsc);

		ObjectName mbeanName = new ObjectName(
				"com.eqinson.jmx.mbean:type=Hello");
		HelloMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName,
				HelloMBean.class, true);

		System.out.println("\nAdd notification listener...");
		mbsc.addNotificationListener(mbeanName, new ClientListener(), null,
				null);

		System.out.println("\nCacheSize = " + mbeanProxy.getCacheSize());

		mbeanProxy.setCacheSize(150);

		System.out.println("\nWaiting for notification...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nCacheSize = " + mbeanProxy.getCacheSize());
		System.out.println("\nInvoke sayHello() in Hello MBean...");
		mbeanProxy.sayHello();

		System.out.println("\nInvoke add(2, 3) in Hello MBean...");
		System.out.println("\nadd(2, 3) = " + mbeanProxy.add(2, 3));
		
		jmxc.close();
	}

	private static void performOperationsOnRemoteMBeans2() throws IOException,
			InstanceNotFoundException, MalformedObjectNameException {
		JMXServiceURL url = new JMXServiceURL(
				"service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
		
		getDomains(mbsc);

		ObjectName mxbeanName = new ObjectName(
				"com.eqinson.jmx.mxbean:type=QueueSampler");
		QueueSamplerMXBean mxbeanProxy = JMX.newMXBeanProxy(mbsc, mxbeanName,
				QueueSamplerMXBean.class);
		QueueSample queue1 = mxbeanProxy.getQueueSample();
		System.out.println("\nQueueSample.Date = " + queue1.getDate());
		System.out.println("QueueSample.Head = " + queue1.getHead());
		System.out.println("QueueSample.Size = " + queue1.getSize());
		System.out.println("\nInvoke clearQueue() in QueueSampler MXBean...");
		mxbeanProxy.clearQueue();

		QueueSample queue2 = mxbeanProxy.getQueueSample();
		System.out.println("\nQueueSample.Date = " + queue2.getDate());
		System.out.println("QueueSample.Head = " + queue2.getHead());
		System.out.println("QueueSample.Size = " + queue2.getSize());
		
		jmxc.close();
	}

	public static void main(String[] args) throws Exception {

		System.out.println("\nCreate an RMI connector client and "
				+ "connect it to the RMI connector server");
		
		performOperationsOnRemoteMBeans();
		performOperationsOnRemoteMBeans2();
	}
}
