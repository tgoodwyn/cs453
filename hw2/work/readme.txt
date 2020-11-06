
command line copy pasta:

full path to /work:
~/cs453/hw2/work

RUNNING SERVER
cd /work
java -cp . server.Publisher

RUNNING CLIENT
cd /work
java -cp . client.Client

RELOADING SERVER CODE
cd /work/server
javac ./*.java ./model/*.java

REGENERATING CLIENT INTERFACE CODE
cd /work
java -cp . server.Publisher
wsimport -keep http://localhost:8080/hello?wsdl -p client
cd /work/client
javac *.




