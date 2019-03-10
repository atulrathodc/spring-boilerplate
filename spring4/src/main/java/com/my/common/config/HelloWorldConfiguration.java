package com.my.common.config;




import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.my.common.dao.EmployeeDAOImpl;
import com.my.common.model.Employee;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.my.common.controller")
public class HelloWorldConfiguration {
	
    Properties hibernateProperties() {
        return new Properties() {
           {
              setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
              setProperty("hibernate.globally_quoted_identifiers", "true");
              setProperty("hibernate.show_sql", "true");
         
           }
        };
     }
    
	   @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	       // viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/pages/");
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
	    }
	   
	   @Bean()    
	    public DataSource getDataSource()
	    {
	        DriverManagerDataSource ds = new DriverManagerDataSource();        
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/TestDB");
	        ds.setUsername("root");
	        ds.setPassword("root");        
	        
	        return ds;
	    }
	   
	   @Bean
	   @Autowired
	    public LocalSessionFactoryBean sessionFactory(DataSource ds) {
	        System.out.println("Create SessionFactory");
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	       // sessionFactory.setMappingResources("employee.hbm.xml");

	       sessionFactory.setAnnotatedClasses(new Class[]{Employee.class});
	   
	  
	 //set annotated classes.0
	
	     //  addAnnotatedClass(Employee.class);
	        sessionFactory.setDataSource(ds);
	    /*    sessionFactory.setPackagesToScan(new String[] {
	                    "com.mkyong.common.controller"
	        });*/
	        sessionFactory.setHibernateProperties(hibernateProperties());

	        return sessionFactory;
	    }
	   
	
	   
	   @Bean()
	   @Autowired
	    public EmployeeDAOImpl EmployeeDAO(LocalSessionFactoryBean  hb)
	    {
	          
	        return new EmployeeDAOImpl();
	    }

}