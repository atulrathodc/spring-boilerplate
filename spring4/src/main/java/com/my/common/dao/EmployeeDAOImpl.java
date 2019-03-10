package com.my.common.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.common.model.Employee;

import java.util.List;



public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
/*	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
*/
	public void save(Employee p) {

		
		Session session = this.sessionFactory.openSession();
	  	//Session sessionObj =this.sessionFactory.openSession();;
       // try {
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		// TODO Auto-generated method stub
		
	}
/*	@Override
	public List<Employee> lists() {
		Session session = this.sessionFactory.openSession();
		List<Employee> EmployeeList = session.createQuery("from Person").list();
		session.close();
		return EmployeeList;
	}*/
	
	@Override
	public Employee findById(Integer find_Employee_id) {
    	Employee findStudentObj = null;
    	Session sessionObj =this.sessionFactory.openSession();;
        try {
            // Getting Session Object From SessionFactory
         //sessionObj = this.sessionFactory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
 System.out.println(find_Employee_id);
            findStudentObj = (Employee) sessionObj.get(Employee.class, find_Employee_id);
         
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
              
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } 
        return findStudentObj;
    }
	
	@Override
    public void updateRecord(Employee p,int student_id) {   
    	Session sessionObj =this.sessionFactory.openSession();;
        try {
 
            sessionObj.beginTransaction();
 
        
            Employee stuObj = (Employee) sessionObj.get(Employee.class, student_id);
            stuObj.setFirstName(p.getFirstName());
          
 
         
            sessionObj.getTransaction().commit();
           
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
               
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    
@Override
public ArrayList<Employee> findAllEmployee() {
	// TODO Auto-generated method stub
	Session session = this.sessionFactory.openSession();
	ArrayList<Employee> newEmployees = (ArrayList<Employee>) session.createQuery("from Employee").list();
	session.close();
	
/*	ArrayList<Employee> newEmployees=new ArrayList<Employee>();
	newEmployees.add(new Employee(3, "Intern"));
	newEmployees.add(new Employee(4, "CEO"));*/
	return newEmployees;
}

@Override
public void deleteRecord(Integer empid) {
	Session sessionObj = this.sessionFactory.openSession();
    try {
        // Getting Session Object From SessionFactory
     
        // Getting Transaction Object From Session Object
        sessionObj.beginTransaction();

        Employee studObj = findById(empid);
        sessionObj.delete(studObj);
       // sessionObj.delete(studObj);

        // Committing The Transactions To The Database
        sessionObj.getTransaction().commit();
       
    } catch(Exception sqlException) {
        if(null != sessionObj.getTransaction()) {
           
            sessionObj.getTransaction().rollback();
        }
        sqlException.printStackTrace();
    } finally {
        if(sessionObj != null) {
            sessionObj.close();
        }
    }
}




/*	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}*/

}





/*package com.mkyong.common.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println("add2");
    	System.out.println(sessionFactory);
    }
    
public void save(Employee p) {
		// TODO Auto-generated method stub
		System.out.println("add2");
		//	logger.info("Employee saved successfully, Person Details="+p);
			try{
				
				System.out.println(sessionFactory);
			Session session = this.sessionFactory.openSession();
			System.out.println("rrr");
			System.out.println(session);
			Transaction tx = session.beginTransaction();
			session.persist(p);
			tx.commit();
			
			}catch(Exception e){
				System.out.println("Exception occured. "+e.getMessage());
				//e.printStackTrace();
			}finally{
				if(this.sessionFactory != null && !this.sessionFactory.isClosed()){
					System.out.println("Closing SessionFactory");
					this.sessionFactory.close();
				}
			}
	}

}
*/