package server;

import javax.jws.WebService;
import java.util.ArrayList;

//Service Implementation
@WebService(endpointInterface = "server.ServerAPI")
public class Server implements ServerAPI{
	
	ArrayList<Classroom> rooms;
	for (int i = 0; i < 3; i++) {
		rooms.add(new Classroom());
	}
	@Override
	public String helloWorld(String name) {

		System.out.println(name+" says hello");
		return "Hello World " + name;
	}

	@Override
	public String studentEnter(int classId, int rectId, boolean wipes, boolean mask) {
		String response = "Student enters rectangle " + rectId;
		if (!wipes) response += ". ALERT: Failure to wipe";
		return response;

	}

	public String studentExit()
 
}