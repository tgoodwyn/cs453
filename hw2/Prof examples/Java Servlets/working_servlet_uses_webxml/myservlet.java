package example.myservlet;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

public class myservlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
       throws ServletException, IOException
   {
    // put a text/html header in the HTTP response
    response.setContentType("text/html");

    // Following output will show up in Glassfish log file
    // because System.out is standard output it will show up
    // on the console
    System.out.println("Inside myservlet in doGet method");

    // Write a small simple web page into the HTTP response
    PrintWriter myout = response.getWriter();
    myout.println("<html><body><i>Happily working</i><b> myservlet</b> using web.xml file</body></html>");
  
   }
}
