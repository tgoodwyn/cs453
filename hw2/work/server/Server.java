package server;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "server.ServerAPI")
public class Server implements ServerAPI{
 
	@Override
	public String HelloWorld(String name) {

		System.out.println(name+" says hello");
		return "Hello World " + name;
	}

	@Override
	public String StudentEnter(int rectId, boolean wipes) {
		String response = "Student enters rectangle " + rectID;
		if (!wipes) response += ". ALERT: Failure to wipe";

	}
 
}