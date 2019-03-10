package com.my.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.util.UriComponentsBuilder;

import com.my.common.dao.EmployeeDAO;
import com.my.common.model.Employee;

import antlr.collections.List;

@Controller
public class HelloWorldController {
 
	@Autowired
	EmployeeDAO emdao;
	
	@RequestMapping("/hello")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@RequestMapping("/manual")
	void manual(HttpServletResponse response) throws IOException {
	    response.setHeader("Custom-Header", "foo");
	    response.setStatus(201);
	    response.getWriter().println("Hello World!");
	}
    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Employee>> listAllUsers() {
    	ArrayList<Employee> newEmployees = emdao.findAllEmployee();
        
;
/*        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }*/
        return new ResponseEntity<>(newEmployees, HttpStatus.OK);
    }
     
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        Employee user = emdao.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Employee emp,    UriComponentsBuilder ucBuilder) {

 
   /*     if (userService.isUserExist(emp)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 */
    	System.out.println("adding");
    	
       emdao.save(emp);
 
        HttpHeaders headers = new HttpHeaders();
          headers.setLocation(ucBuilder.path("/emp/{id}").buildAndExpand(emp.getId()).toUri());
          return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Integer id, @RequestBody Employee em) {
        System.out.println("Updating User " + id);
         
        Employee currentUser = emdao.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
 

        emdao.updateRecord(em, id);
        return new ResponseEntity<Employee>(currentUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteUser(@PathVariable("id") Integer id) {
     
 
        Employee user = emdao.findById(id);
        if (user == null) {
           
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
 
        emdao.deleteRecord(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping("/test3")
	protected String handleRequestInternal(ModelMap model) throws Exception {
		//EmployeeDAO emdao =new EmployeeDAOImpl();

//System.out.println(emdao);
		Employee emp=new Employee();
		//emp.setId(1);
		emp.setFirstName("rms");
		emdao.save(emp);
		
/*		try{
		Session session = this.sessionFactory.openSession();
		System.out.println("rrr");
		System.out.println(session);
		Transaction tx = session.beginTransaction();
		session.persist(emp);
		tx.commit();
		System.out.println("Employee saved successfully, Person Details=");
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			//e.printStackTrace();
		}finally{
			if(this.sessionFactory != null && !this.sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				this.sessionFactory.close();
			}
		}
	*/
		//ModelAndView model = new ModelAndView("HelloWorldPage");
	//	model.addObject("msg", "msg");
	    model.addAttribute("msg", "Hello World Again, from Spring 4 MVC");
		return "HelloWorldPage";
		//return "t1";
	}

	
/*	@RequestMapping("/test2")
	@ResponseBody
	protected ArrayList<Employee>  handleRequestInternal() {
		ArrayList<Employee> newEmployees=new ArrayList<Employee>();
		newEmployees.add(new Employee(3, "Intern"));
		newEmployees.add(new Employee(4, "CEO"));
		System.out.println("test2");
		//System.out.println(newEmployees);
		List newEmployees = (List) new ArrayList<Object>();
		newEmployees.add(new Employee(3, "Intern"));
		newEmployees.add(new Employee(4, "CEO"));
		System.out.println(newEmployees);
		
		return newEmployees;//"{\"dd\":3}";
	}*/

}