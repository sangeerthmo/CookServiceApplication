package com.me.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Cook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cookid;
	
	@Column(name="nameCook")
	@NotBlank
	private String name;
	
	
	//private String salary
	private String cookEmail;
	private int age;

	public Cook() {
		super();
	}

	public Cook(int cookid, String name, String cookEmail, int age) {
		super();
		this.cookid = cookid;
		this.name = name;
		this.cookEmail = cookEmail;
		this.age = age;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public float getSalary() {
//		return salary;
//	}
//
//	public void setSalary(float salary) {
//		this.salary = salary;
//	}
//
//	public int getEmpid() {
//		return empid;
//	}

	
	
//	@Override
//	public int hashCode() {
//		return empid;
//	}

	public int getCookid() {
		return cookid;
	}

	public void setCookid(int cookid) {
		this.cookid = cookid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCookEmail() {
		return cookEmail;
	}

	public void setCookEmail(String cookEmail) {
		this.cookEmail = cookEmail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return cookid;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cook other = (Cook) obj;
		if (cookid != other.cookid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		
		if (!cookEmail.equals(other.cookEmail))
			return false;
		if (age != other.age)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Cook [cookid=" + cookid + ", name=" + name + ", cookEmail=" + cookEmail + ", age=" + age + "]";
	}
	
	

//	@Override
//	public String toString() {
//		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
//	}
	
	
	
	
}