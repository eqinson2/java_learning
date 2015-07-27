/**
 * 
 */
package com.eqinson.javacollection;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author eqinson
 *
 */
public final class JavaSortedMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedMap<String, String> map = null;
		map = new TreeMap<String, String>(); // ͨ������ʵ�����ӿڶ���
		map.put("D��jiangker", "http://www.jiangker.com/");
		map.put("A��mldn", "www.mldn.cn");
		map.put("C��zhinangtuan", "www.zhinangtuan.net.cn");
		map.put("B��mldnjava", "www.mldnjava.cn");
		System.out.print("��һ��Ԫ�ص����ݵ�key��" + map.firstKey());
		System.out.println("����Ӧ��ֵ��" + map.get(map.firstKey()));
		System.out.print("���һ��Ԫ�ص����ݵ�key��" + map.lastKey());
		System.out.println("����Ӧ��ֵ��" + map.get(map.lastKey()));
		System.out.println("����С��ָ����Χ�ļ��ϣ�");
		for (Map.Entry<String, String> me : map.headMap("B��mldnjava")
				.entrySet()) {
			System.out.println("\t|- " + me.getKey() + " --> " + me.getValue());
		}
		System.out.println("���ش���ָ����Χ�ļ��ϣ�");
		for (Map.Entry<String, String> me : map.tailMap("B��mldnjava")
				.entrySet()) {
			System.out.println("\t|- " + me.getKey() + " --> " + me.getValue());
		}
		System.out.println("���ּ��ϣ�");
		for (Map.Entry<String, String> me : map.subMap("A��mldn",
				"C��zhinangtuan").entrySet()) {
			System.out.println("\t|- " + me.getKey() + " --> " + me.getValue());
		}

	}

}
