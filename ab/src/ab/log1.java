package ab;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class log1 extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
	
		String  s1=req.getParameter("a"),s2=req.getParameter("b");
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-J1JVIV6:1521:XE","test","12345");
		System.out.println("conn");
		PreparedStatement st = conn.prepareStatement("select 'true ' from info where EMAIL_ID=? ");
         st.setString(1, s1);
         Boolean s3=st.execute();
         
         System.out.println(s3);
         if(s3==true)
         {
        	 
         }
         else
         {
        	 PrintWriter pt=res.getWriter();
        	 pt.print("your user id is incorrect");
         }
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	
	
	}

}
