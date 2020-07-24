package com.MyLogin.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import PojoClass.SingUpPojo;

public class LoginDao {
	
//	SingUpPojo sp= new SingUpPojo();
	String sql="select * from login where uname=? and pass=?";
	String  url="jdbc:mysql://localhost:3306/MyProject";
	String username="root";
	String password="root";
	public boolean check(SingUpPojo sup) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, sup.getUname());
			st.setString(2, sup.getPass());
			ResultSet rs= st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		
		
		
		return false;
		
	}
	

}
