package client;


public class Client {
	public static void main(String[] args) {

	ServerService myHelloWorld = new ServerService();

	ServerAPI myinterface = myHelloWorld.getServerPort();

	String response = myinterface.helloWorld(args[0]);
 
    System.out.println(response);
   }
}
