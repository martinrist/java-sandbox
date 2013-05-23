package com.martinrist.sandbox.lang;

import java.util.Objects;

public class Employee {

	private String name;
	private int salary;
	private String jobTitle;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, salary);

		// final int prime = 31;
		// int result = 1;
		// result = prime * result + ((name == null) ? 0 : name.hashCode());
		// result = prime * result + salary;
		// return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (!(Objects.equals(this.name, other.name)))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

}
