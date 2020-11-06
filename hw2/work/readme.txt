
command line copy pasta:
cd server
javac ./*.java ./model/*.java

cd ..
java -cp . server.Publisher
wsimport -keep http://localhost:8080/hello?wsdl -p client

cd client
javac *.java
cd ..
java -cp . client.Client


