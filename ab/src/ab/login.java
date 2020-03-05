package ab;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class login extends HttpServlet {
	
	public void service (HttpServletRequest req,HttpServletResponse res)
	{int fl =0;
	 String s1= req.getParameter("a");
	 String s2= req.getParameter("b");
	 try {
	  Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-J1JVIV6:1521:XE","test","12345");
	  PreparedStatement ps= conn.prepareStatement("select 'true' from project where NAME=? AND PHONE=?");
	
	  ps.setString(1, s1);
	  
	  ps.setString(2, s2);
	 
	ResultSet rs=ps.executeQuery();
	 while(rs.next())
	 {
		
		fl=1;	
		
	 }
     if(fl==1)
     {
    	   RequestDispatcher  rq=req.getRequestDispatcher("front.html");
		   rq.forward(req, res);
     }
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	}

}
