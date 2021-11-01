
import java.util.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet5 extends HttpServlet {
    
    
    
    

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String u=request.getParameter("Username");
            String p=request.getParameter("password");
            if(uaun(u,p)){              
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Congratulations !!!!!!</h1>");
            out.println("<p>Welcome User</p>");
            out.println("<p>You have Successfully Logged In</p>");
            out.println("</body>");
            out.println("</html>");
        }
            else{
              out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>OOPS!!!!!!!!!!!!!!</h1>");
            out.println("<p>Sorry</p>");
            out.println("<p>Invalid User</p>");
            out.println("</body>");
            out.println("</html>");  
            }
    }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
     boolean uaun(String user,String pass){
    boolean torf=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ass1_2?characterEncoding=latin1","root","19032001");
            Statement stm=con.createStatement();
        ResultSet rs=stm.executeQuery("select *from owner where username='"+user+"' AND password='"+pass+"'");
        if(rs.next())
			{
				if(rs.getString(1).equals(user) && rs.getString(2).equals(pass))
				{
					torf=true;
				}
                                else
                                    torf=false;
			}

           con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return torf;
    }
    }