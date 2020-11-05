package client;


public class Client {
	public static void main(String[] args) {

	ServerService myHelloWorld = new ServerService();

	ServerAPI myinterface = myHelloWorld.getServerPort();

        //Note the format of the operation call "helloWorld".  This
	//matches the format in the wsimport-generated HelloWorld.java file.
	String response = myinterface.helloWorld(args[0]);
 
        System.out.println(response);
   }
}
