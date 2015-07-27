/**
 * 
 */
package com.eqinson.bio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author eqinson
 *
 */
public final class ObjectStream {

	private static class Student implements Serializable {
		private static final long serialVersionUID = 1L;
		final String name;
		final int id;
		final int age;
		final String department;

		public Student(final String name, final int id, final int age,
				final String department) {
			this.age = age;
			this.department = department;
			this.id = id;
			this.name = name;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Student s1 = new Student("张三", 1, 15, "化学");
		Student s2 = new Student("李四", 2, 19, "生物");
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream("student.txt");
			out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			out.writeObject(s2);
			out.close();

			FileInputStream fin = new FileInputStream("student.txt");
			ObjectInputStream in = new ObjectInputStream(fin);
			try {
				s1 = (Student) in.readObject();
				s2 = (Student) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			in.close();
			System.out.print("name:" + s1.name);
			System.out.print(" id:" + s1.id);
			System.out.print(" age:" + s1.age);
			System.out.println(" department:" + s1.department);
			System.out.print("name:" + s2.name);
			System.out.print(" id:" + s2.id);
			System.out.print(" age:" + s2.age);
			System.out.println(" department:" + s2.department);

		} finally {

		}
	}
}
