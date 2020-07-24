package com.MyLogin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyLogin.doa.LoginDao;

import PojoClass.SingUpPojo;

@WebServlet("/login")
public class login extends HttpServlet
{
	
	LoginDao dao=new LoginDao();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		
		String uname= req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		SingUpPojo sup=new SingUpPojo();
		sup.setUname(uname);
		sup.setPass(pass);
		if(dao.check(sup)){
			
			HttpSession session=req.getSession();
			session.setAttribute("uname", uname);
			res.sendRedirect("adminhome.jsp");
		}
		
		else{
			
			res.sendRedirect("erroradminlogin.html");
		}
		
	}

}
