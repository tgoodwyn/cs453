This example uses a file called web.xml
to set up its deployment information for
Glassfish.  This file must be copied into
the directory WEB-INF before the war file
is created.


do:
./compile_servlet
./create_the_war

deploy on Glassfish

Then access using a web browser:

http://localhost:8080/myservlet/myservlet


Helpful References
http://javahowto.blogspot.com/2009/10/servlet-without-webxml.html
