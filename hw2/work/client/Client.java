package client;
// import ServerFunc;
// import HWService;

public class Client {
	public static void main(String[] args) {

	HWService myHelloWorld = new HWService();

	ServerFunc myinterface = myHelloWorld.getHWPort();

        //Note the format of the operation call "helloWorld".  This
	//matches the format in the wsimport-generated HelloWorld.java file.
	String response = myinterface.helloWorld(args[0]);
 
        System.out.println(response);
   }
}
