package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started" );
        
        // spring jdbc=> JdbcTemplate
      //  ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
      ApplicationContext context =new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);

//        //insert
        Student s=new Student();
        s.setId(102);
        s.setName("Alex");
        s.setCity("Mumbai");
        int result=studentDao.insert(s);
        System.out.println("student added"+ result);
//        
//        //update
//        Student student=new Student();
//        student.setId(101);
//        student.setName("Bob");
//        student.setCity("Delhi");
//        int result=StudentDao.change(student);
//        System.out.println("data changed"+result);
//        
//        //Delete
//        int result= studentDao.delete(102);
//        System.out.println("deleted"+result);
        
      /*  Student student =StudentDao.getStudent(101);
        System.out.println(student);
    */
        List<Student> student=studentDao.getAllStudents();
        for(Student s1 :student) {
        	System.out.println(s1);
        }
        
    }
}


