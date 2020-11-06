
command line copy pasta:

RUNNING SERVER
cd /work
java -cp . server.Publisher

RUNNING CLIENT
cd /work
java -cp . client.Client

RELOADING SERVER CODE
cd /work/server
javac ./*.java ./model/*.java

REGENERATING CLIENT CODE
cd /work
java -cp . server.Publisher
wsimport -keep http://localhost:8080/hello?wsdl -p client
cd /work/client
javac *.




