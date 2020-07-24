package com.MyLogin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyLogin.doa.AddNewStudentDao;

import PojoClass.AddNewStudentPojo;

@WebServlet("/AddNewStudent")
public class AddNewStudent extends HttpServlet{
	
	AddNewStudentDao ansd=new AddNewStudentDao();
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse  response) throws IOException {
		 
		 String course= request.getParameter("course");
		 String branch= request.getParameter("branch");
		 String rollno= request.getParameter("rollno");
		 String name= request.getParameter("name");
		 String fathername= request.getParameter("fathername");
		 String gender= request.getParameter("gender");
		 
		 AddNewStudentPojo ans=new AddNewStudentPojo();
		 ans.setCoursename(course);
		 ans.setBranchname(branch);
		 ans.setName(name);
		 ans.setRollnumber(rollno);
		 ans.setFathername(fathername);
		 ans.setGender(gender);
		 
		 ansd.addnewstudent(ans);
		 response.sendRedirect("adminhome.jsp");
		 
	 }

}
