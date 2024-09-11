package com.hexaware.hibernate.com.hexaware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	Book b1 = (Book) context.getBean("book1");
    	System.out.println( b1.toString() );
    	System.out.println();
    	
    	
    	Student s1=(Student) context.getBean("stud1");

    	System.out.println( s1.toString() );
    	System.out.println();
    	
    	Result res=s1.getRes();
    	
        System.out.println( res.toString() );
    	System.out.println();
    	
    	Student s2 = (Student) context.getBean("stud2");
    	
    	System.out.println( s2.toString() );
    	System.out.println();
    	
    }
}