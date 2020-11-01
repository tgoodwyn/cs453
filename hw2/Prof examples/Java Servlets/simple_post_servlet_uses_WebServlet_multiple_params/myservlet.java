package example.myservlet;
import java.io.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet (
 urlPatterns="/myservlet"
) 
public class myservlet extends HttpServlet {
  
  @Override
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
       throws ServletException, IOException
  {
    // Following output will show up in Glassfish log file
    System.out.println("Inside myservlet in doPost method");

    String mystring;

    // Get the data items from the HTTP post, by name
    mystring=request.getParameter("mystring");

    int myint;
         
    // Get the data items from the HTTP post, by name
    myint=Integer.parseInt(request.getParameter("myint"));

    // Prepare a writer to the response
    PrintWriter myout = response.getWriter();

    // Write the data you just received to the response 
    myout.println("received data is "+mystring+" and "+myint);

  }
}
