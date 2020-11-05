package client;
// import ServerFunc;
// import HWImplService;

public class Client {
	public static void main(String[] args) {

	HWImplService myHelloWorld = new HWImplService();

	ServerFunc myinterface = myHelloWorld.getHWImplPort();

        //Note the format of the operation call "helloWorld".  This
	//matches the format in the wsimport-generated HelloWorld.java file.
	String response = myinterface.helloWorld(args[0]);
 
        System.out.println(response);
   }
}
