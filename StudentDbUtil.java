package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	public List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStat = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			
			//create sql statement
			String sql = "Select * from student order by last_name" ;
			myStat = myConn.createStatement();
			//execute sql query
			myRs = myStat.executeQuery(sql);
			
			// Process the result set
			//System.out.print("hello");
			while(myRs.next())
			{
				int id = myRs.getInt("id");
				String firstname = myRs.getString("first_name");
				String lastname = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				Student tempStudent = new Student(id,firstname,lastname,email);
				
				students.add(tempStudent);

			}
			return students;

		}
		finally {
			close(myConn,myStat,myRs);
		}

	}
	private void close(Connection myConn, Statement myStat, ResultSet myRs) {
		try {
			if(myRs!=null)
			{
				myRs.close();
			}
			if(myStat!=null)
			{
				myStat.close();
			}
			if(myConn!=null)
			{
				myConn.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public void addStudent(Student theStudent) throws Exception {
		Connection myConn = null;
		PreparedStatement myStat = null;
		//ResultSet myRs = null;
		
		try {
myConn = dataSource.getConnection();
			
			
			String sql = "insert into student " + "(first_name,last_name,email)" + "values(?,?,?)";
			myStat = myConn.prepareStatement(sql);
			
			myStat.setString(1,theStudent.getFirstname());
			myStat.setString(2,theStudent.getLastname());
			myStat.setString(3,theStudent.getEmail());

			//execute sql query
			 myStat.execute();
		}
			
			 
			 finally {
				 close(myConn,myStat,null);
			 }
		    
	}
	public Student getStudent(String theStudentId) throws Exception {
		Student theStudent=null;
		Connection myConn = null;
		PreparedStatement myStat = null;
		ResultSet myRs = null;
		int studentId;
		try {
			studentId = Integer.parseInt(theStudentId);
			
			myConn = dataSource.getConnection();
			
			String sql = "SELECT * from student WHERE id="+studentId;
			System.out.print(sql);
			myStat = myConn.prepareStatement(sql);
			
			//myStat.setInt(1,studentId);
			
	        myRs = myStat.executeQuery(sql);
			
			// Process the result set
			   
			if(myRs.next())
			{
				int id = myRs.getInt("id");
				String firstname = myRs.getString("first_name");
				String lastname = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				theStudent = new Student(studentId,firstname,lastname,email);
			}
			else {
				throw new Exception("Could not find id:" + studentId);
			}
			return theStudent;
		}
		finally {
			close(myConn,myStat,myRs);
		}
		
		
	}
	public void updateStudent(Student theStudent) throws Exception{
		Connection myConn = null;
		PreparedStatement myStat = null;
		//ResultSet myRs = null;
		
		try {
         myConn = dataSource.getConnection();
			
			//System.out.print("theStudent:"+theStudent);
			String sql = "update student " + "set first_name=? , last_name=? , email=? "+"where id = ?";
			myStat = myConn.prepareStatement(sql);
			
			myStat.setString(1,theStudent.getFirstname());
			myStat.setString(2,theStudent.getLastname());
			myStat.setString(3,theStudent.getEmail());
			myStat.setInt(4,theStudent.getId());
			//execute sql query
			System.out.print(theStudent.getId());
			 myStat.execute();
		}
			
			 
			 finally {
				 close(myConn,myStat,null);
			 }
		
	}
	public void deleteStudent(String theStudentId) throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStat = null;
		//ResultSet myRs = null;
		
		try {
         myConn = dataSource.getConnection();
			
			//System.out.print("theStudent:"+theStudent);
			String sql = "delete from student where id="+theStudentId;
			myStat = myConn.prepareStatement(sql);
			
			 myStat.execute();
		}
			
			 
			 finally {
				 close(myConn,myStat,null);
			 }
	}
	
	
}
