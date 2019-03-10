package com.my.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
   @Id	
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   
   @Column(name = "NAME")
   @NotNull
   @Size(min=2, max=30) 
   private String firstName; 

    @NotNull
	private int age;
	
    @NotNull
	private Double salary;
   
   public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

public Employee() {}
   
   public Employee(String fname,int age,Double salary) {
	      this.firstName = fname;
	      this.salary = salary;
	      this.age = age;
	   }
	   
   public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


 
  
   
   public String getFirstName() {
      return firstName;
   }
   
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   

}