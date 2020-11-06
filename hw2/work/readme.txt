
command line copy pasta:
javac ./*.java ./model/*.java
javac *.java
java -cp . client.Client
java -cp . server.Publisher

wsimport -keep http://localhost:8080/hello?wsdl -p client
