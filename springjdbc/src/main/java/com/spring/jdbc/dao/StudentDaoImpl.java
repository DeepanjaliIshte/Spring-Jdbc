package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.spring.jdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbctemplate;

	public int insert(Student student) {

        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
       int r =this.jdbctemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return r;
	}
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	@Override
	public int change(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delete(int studentId) {
		//delete operation 
		String query="delete from student where id=?";
		int r=this.jdbctemplate.update(query,studentId);
		return r;
	}
	
	public Student getStudent(int studentId) {
		// select single student data
		String query="select * from student where id=?";
		RowMapper <Student>rowMapper=new RowMapperImpl();
		Student student =this.jdbctemplate.queryForObject(query, rowMapper,studentId);
		
		return null;
	}
	
	public List<Student> getAllStudent()
	{
		//Select multiple student
		String query="Select * from  student";
		List<Student> students =this.jdbctemplate.query(query,new RowMapperImpl());
		return null;
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
