package client;


public class Client {
	public static void main(String[] args) {

	ServerService myHelloWorld = new ServerService();

	ServerAPI myinterface = myHelloWorld.getServerPort();

	String response;
	response = myinterface.studentEnter(Integer.parseInt(args[0]), Boolean.parseBoolean(args[1]));
 
    System.out.println(response);
   }
}
