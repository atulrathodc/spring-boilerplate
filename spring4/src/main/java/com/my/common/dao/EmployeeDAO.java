package com.my.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.my.common.model.Employee;

 
 
public interface EmployeeDAO { 

	public void save(Employee p);
	public ArrayList<Employee>  findAllEmployee();
	Employee findById(Integer find_Employee_id); 
/*	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);*/
	void deleteRecord(Integer id);
	void updateRecord(Employee p, int student_id);
	
}
