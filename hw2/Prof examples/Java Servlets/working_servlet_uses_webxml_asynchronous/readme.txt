do:
./compile_servlet
./create_the_war

deploy on Glassfish

Then access using a web browser:

http://localhost:8080/myservlet/myservlet

or you can do:
./send_curl_get

You won't be able to really see what this is doing unless you look at the log file.
If you look at the log file, you will be able to see the various strategically
set print statements that show that the doGet completes BEFORE the thread
is finished, and that the thread is where the response is actually created.


This is an example of an asynchronous HttpServlet.  What happens is the doGet
creates a separate thread to do the actual work. Just before the doGet
creates the thread, it creates a listener routine to wait for a signal that
the thread has completed (or alternately that some error has happened).
WHen the doGet is just about to exit, it writes a statement to the log so
you can see that it is exiting before the thread completes its work.

The thread does a sleep to pretend that it's doing a lot of really involved work.
At the end, the thread writes some stuff into the response, so you can see
that it's really the thread creating the response to the user.


Helpful References
http://javahowto.blogspot.com/2009/10/servlet-without-webxml.html
