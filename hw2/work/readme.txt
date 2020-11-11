
command line copy pasta:

full path to /work:
~/cs453/hw2/work

RUNNING SERVER
cd /work
java -cp . server.Publisher

RUNNING CLIENT
cd /work
java -cp . client.Client

--------------------------client examples-------------------
student:enter classroom:1 rectangle:q
instructor:enter classroom:1 rectangle:q
student:enter classroom:1 rectangle:q wipes mask
student:exit classroom:1 rectangle:q
instructor:exit classroom:1 rectangle:q
student:exit classroom:1 rectangle:q wipes sanitize

---------------------ONLY REQUIRED IF SERVER CODE IS CHANGED---------------------
RELOADING SERVER CODE
cd /work/server
javac ./*.java ./model/*.java

---------------------ONLY REQUIRED IF SERVER INTERFACE IS CHANGED---------------------
REGENERATING CLIENT INTERFACE CODE
cd /work
java -cp . server.Publisher
wsimport -keep http://localhost:8080/hello?wsdl -p client
cd /work/client
javac *.




