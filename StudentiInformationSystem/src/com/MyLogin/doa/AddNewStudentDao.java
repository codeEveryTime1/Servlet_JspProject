package com.MyLogin.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import PojoClass.AddNewStudentPojo;

public class AddNewStudentDao 
{
	
	public int addnewstudent(AddNewStudentPojo ans)  {
		
		String url="jdbc:mysql://localhost:3306/myproject";
		String sql="insert into student values(?,?,?,?,?,?)";	
		String username="root";
		String password="root";
		int result=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ans.getCoursename());
			ps.setString(2, ans.getBranchname());
			ps.setString(3, ans.getRollnumber());
			ps.setString(4, ans.getName());
			ps.setString(5, ans.getFathername());
			ps.setString(6, ans.getGender());
			result=ps.executeUpdate();
			System.out.println(ps);
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return result;
		
	}

}
