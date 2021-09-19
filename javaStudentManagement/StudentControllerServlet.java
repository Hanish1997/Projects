package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 private StudentDbUtil studentDbUtil;
	 @Resource(name="jdbc/web_student_tracker")
	 private DataSource dataSource;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			// if the command is missing then route to listing as default
			if(theCommand==null)
			{
				theCommand="LIST";
			}
			switch(theCommand) {
			case "LIST":
				listStudents(request,response);
				break;
			case "ADD":
				addStudents(request,response);
				break;
			case "LOAD":	
				loadstudent(request,response);
				break;
			case "UPDATE":
				updatestudent(request,response);
				break;
			case "DELETE":
				deletestudent(request,response);
				break;
			default:
				listStudents(request,response);
				
			}
			
		
		
		}
		catch(Exception e){
			throw new ServletException(e);
		}
	}

	private void deletestudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theStudentId = request.getParameter("studentId");
		
		 studentDbUtil.deleteStudent(theStudentId);
	        
	        listStudents(request,response);
		
	}

	private void updatestudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		Student theStudent = new Student(id,firstname,lastname,email);
		
        studentDbUtil.updateStudent(theStudent);
        
        listStudents(request,response);
		
	}

	private void loadstudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.print("hellodd");
	//read studentId from form data
		String theStudentId = request.getParameter("studentId");
	
	//get student from database
	//	System.out.print(theStudentId);
		Student theStudent = studentDbUtil.getStudent(theStudentId);
		
	// place student in request attribute
		request.setAttribute("THE_STUDENT", theStudent);
		

	//send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
          
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		Student theStudent = new Student(firstname,lastname,email);
		
        studentDbUtil.addStudent(theStudent);
        
        listStudents(request,response);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch(Exception e){
			throw new ServletException(e);
		}
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Student> students = studentDbUtil.getStudents();
		

		request.setAttribute("STUDENT_LIST", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_students.jsp");
		dispatcher.forward(request, response);
	}

}