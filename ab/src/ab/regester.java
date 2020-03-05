package ab;

import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regester extends HttpServlet {
	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		System.out.println(req.getParameter("name"));
		String s1=req.getParameter("name");
		String s2=req.getParameter("phone");
		String s3=req.getParameter("e-mail");
		String s4=req.getParameter("address");
		String s5=req.getParameter("city");
	
		try {
		
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-J1JVIV6:1521:XE","test","12345");
		   PreparedStatement pt=conn.prepareStatement("insert into project values( ?,?,?,?,?)");
		   pt.setString(1,s1);
		   pt.setString(2,s2);
		   pt.setString(3,s3);
		   pt.setString(4,s4);
		   pt.setString(5,s5);
		   pt.execute();
		    System.out.println("your data has been entered successfully");
		    RequestDispatcher  rq=req.getRequestDispatcher("/done.html");
		   rq.forward(req, res);
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	

}
