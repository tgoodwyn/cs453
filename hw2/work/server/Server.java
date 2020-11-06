package server;

import javax.jws.WebService;
import java.util.ArrayList;

//Service Implementation
@WebService(endpointInterface = "server.ServerAPI")
public class Server implements ServerAPI{
	
	ArrayList<Classroom> rooms = new ArrayList<Classroom>();
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

		rooms.get(classId).rectangles[rectId]
		String rectName = (rectId == 9) ? "for questions" : Integer.toString(rectId)
		if (rectId == 8) {
			response = "Student attempts to enter the instructor's rectangle and is rebuffed";
			return response;
		}

		String response = "Student enters rectangle " + rectId;
		if (!wipes) response += ". ALERT: Failure to wipe";
		return response;

	}
	
	@Override
	public String instructorEnter(int classId, int rectId, boolean wipes, boolean mask) {

	}

	@Override
	public String studentExit(int classId, int rectId, boolean wipes, boolean sanitizes){
		
	}

	@Override
	public String instructorExit(int classId, int rectId, boolean wipes, boolean sanitizes){

	}

 
}