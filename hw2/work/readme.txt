
command line copy pasta:

full path to /work:
~/cs453/hw2/work

RUNNING SERVER
cd /work
java -cp . server.Publisher

RUNNING CLIENT
cd /work
java -cp . client.Client


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




