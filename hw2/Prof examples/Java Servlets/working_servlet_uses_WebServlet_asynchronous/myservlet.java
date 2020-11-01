package example.myservlet;
import java.io.*;
import java.lang.Thread;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;


class doWork implements Runnable {
    private AsyncContext ac;

    public doWork(AsyncContext the_ac) {
       // set the context of the thread to the original context
       this.ac=the_ac;
    }

    public void run() {
       System.out.println("inside doWork thread");
       // do a lot of hard work
       try {
          Thread.sleep(10000);  // sleep for 10 sec to simulate hard work


         // Put some stuff in the response so it get done after completion
         PrintWriter myout = ac.getResponse().getWriter();
         myout.println("this is really useful stuff");

         System.out.println("just wrote some stuff into response");

       } catch (Exception e)  { 
            System.out.println("Some kind of Exception");
       }
       ac.complete();        // when hard work is done, signify completion
    }
}


@WebServlet (
 urlPatterns="/myservlet",asyncSupported = true
) 
public class myservlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
       throws ServletException, IOException
   {
    // Following output will show up in Glassfish log file
    // because System.out is standard output it will show up
    // on the console
    System.out.println("Inside myservlet in doGet method");

    AsyncContext ac = request.startAsync();

    ac.addListener(new AsyncListener()  
       { 
         @Override
         public void onComplete(AsyncEvent event) throws IOException {
            System.out.println("onComplete: Asynchronous task is now done");
         }
   
         @Override
         public void onTimeout(AsyncEvent event) throws IOException {
            System.out.println("onTimeout");
         }

         @Override
         public void onStartAsync(AsyncEvent event) throws IOException {
            System.out.println("onStartAsync");
         }

         @Override
         public void onError(AsyncEvent event) throws IOException {
            System.out.println("onError");
         }
              

       }
    );

    System.out.println("just before thread start");

    new Thread (new doWork(ac) ).start(); 

    System.out.println("just after thread start");
    System.out.println("very end of doGet");
  
   }
}
