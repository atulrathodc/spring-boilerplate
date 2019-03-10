package com.my.common.APItestutil;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;

import com.my.common.model.Employee;
 

public class SpringRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8081/spring4/";
    
    private static void getUser(){
        System.out.println("ALL Employee----------");
        RestTemplate restTemplate = new RestTemplate();
        String emp = restTemplate.getForObject(REST_SERVICE_URI+"/emps", String.class);
        //restTemplate.get
        
     System.out.println(emp);
    }
    
    private static void getEmployee(int id){
        System.out.println("\n\n\nloading one Employee by ID"+id+"----------");
        RestTemplate restTemplate = new RestTemplate();
        String em = restTemplate.getForObject(REST_SERVICE_URI+"/emp/"+id, String.class);
        //System.out.println(em);
    }
   
    private static void createUser() {
        System.out.println("\n\n\nTesting create Employee API----------");
        RestTemplate restTemplate = new RestTemplate();
        Employee user =  new Employee("Tomy",33, 70000.0);
        //user.setFirstName("rama");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/emp/", user, Employee.class);
        //System.out.println("Location : "+uri.toASCIIString());
    }
 
    private static void updateUser(int id) {
        System.out.println("\n\n\nTesting update Employee API----------");
        RestTemplate restTemplate = new RestTemplate();
        Employee em  = new Employee("Tomy updated",33, 70000.0);
        restTemplate.put(REST_SERVICE_URI+"/emp/"+id, em);
        //System.out.println(em);
    }
    
    private static void deleteUser(int id) {
        System.out.println("Testing delete Employee API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/emp/"+id);
    }
    private static void add(int id) {
      
    }
 
    public static void main(String args[]){
    	//http://localhost:8081/spring4/emps
    int id=9;
    getUser();
    	getEmployee(id);
    	getUser();
    	createUser();
    	getUser();
        updateUser(id);
    	getUser();
    	deleteUser(id);
    	getUser();
    
    // 

}
}