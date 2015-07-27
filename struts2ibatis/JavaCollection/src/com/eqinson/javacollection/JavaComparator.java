/**
 * 
 */
package com.eqinson.javacollection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author eqinson
 *
 */
public final class JavaComparator {

	private static class Name implements Comparable<Name> {
		private final String firstName, lastName;

		public Name(String firstName, String lastName) {
			if (firstName == null || lastName == null)
				throw new NullPointerException();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String firstName() {
			return firstName;
		}

		public String lastName() {
			return lastName;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Name))
				return false;
			Name n = (Name) o;
			return n.firstName.equals(firstName) && n.lastName.equals(lastName);
		}

		public int hashCode() {
			return 31 * firstName.hashCode() + lastName.hashCode();
		}

		public String toString() {
			return firstName + " " + lastName;
		}

		public int compareTo(Name n) {
			int lastCmp = lastName.compareTo(n.lastName);
			return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
		}
	}

	private static class Employee implements Comparable<Employee> {
		public Name name;
		public int number;
		public Date hiredate;

		public Employee(Name name, int number, Date d) {
			this.name = name;
			this.number = number;
			this.hiredate = d;
		}

		public Name getName() {
			return name;
		}

		public int getNumber() {
			return number;
		}

		public Date getHireDate() {
			return hiredate;
		}

		public int compareTo(Employee e) {
			return name.compareTo(e.getName());
		}

		public String toString() {
			return name.firstName() + " " + name.lastName();
		}
	}

	static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			int dateCmp = e2.getHireDate().compareTo(e1.getHireDate());
			if (dateCmp != 0)
				return dateCmp;

			return (e1.getNumber() < e2.getNumber() ? -1
					: (e1.getNumber() == e2.getNumber() ? 0 : 1));
		}
	};

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date1 = new Date(111, 12, 20);
		Date date2 = new Date(110, 11, 10);
		Date date3 = new Date(110, 10, 15);
		Date date4 = new Date(112, 9, 2);

		Employee employees[] = {
				new Employee(new Name("John", "Smith"), 1234, date1),
				new Employee(new Name("Karl", "Ng"), 5678, date2),
				new Employee(new Name("Jeff", "Smith"), 12345, date3),
				new Employee(new Name("Tom", "Rich"), 12340, date4) };

		List<Employee> e = Arrays.asList(employees);
		Collections.sort(e, SENIORITY_ORDER);
		System.out.println(e);

	}
}
