package ab;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class e extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		System.out.println("hello");
		String f1=req.getParameter("v1"),L1=req.getParameter("v2"),E1=req.getParameter("v3");
		int P1=Integer.parseInt(req.getParameter("v4"));
		String C1=req.getParameter("v5");
		try {
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-J1JVIV6:1521:XE","test","12345");
		PreparedStatement ps=conn.prepareStatement("Insert into info values(?,?,?,?,?)"); 
		ps.setString(1, f1);
		ps.setString(2, L1);
		ps.setString(3, E1);
		ps.setInt(4, P1);
		ps.setString(5, C1);
		boolean b=ps.execute();
if(b==false)
{
	PrintWriter p=res.getWriter();
	p.println("your data has been entered successfully");
	
}
		
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("select * from info");
	while(rs.next())
	{
		System.out.println(rs.getString(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5));
	}
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}

}
