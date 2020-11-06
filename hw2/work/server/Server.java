package server;

import server.model.Classroom;
import javax.jws.WebService;
import java.util.ArrayList;

//Service Implementation
@WebService(endpointInterface = "server.ServerAPI")
public class Server implements ServerAPI{
	
	ArrayList<Classroom> rooms; 

	Server() {
		rooms = new ArrayList<Classroom>();
		for (int i = 0; i < 3; i++) {
			rooms.add(new Classroom());
		}
	}

	@Override
	public String helloWorld(String name) {
		System.out.println(name+" says hello");
		return "Hello World " + name;
	}

	@Override
    public String studentEnter(int classId, int rectId, boolean wipes, boolean mask) {
        String response = "";
        if (rectId == 8) {
            response = "Student attempts to enter the instructor's rectangle and is rebuffed\n";
            return response;
        }

        String rectName = (rectId == 9) ? "for questions" : Integer.toString(rectId);
        response = "Student enters rectangle " + rectName +"\n";
        int count = ++rooms.get(classId).rectangles[rectId];
        if (count > 1) response += "ALERT: Failure to social distance\n";
        if (!wipes) response += "ALERT: Failure to wipe\n";
        return response;

    }
	
	@Override
	public String instructorEnter(int classId, int rectId, boolean wipes, boolean mask) {
		return "";
	}

	@Override
	public String studentExit(int classId, int rectId, boolean wipes, boolean sanitizes){
		return "";
	}

	@Override
	public String instructorExit(int classId, int rectId, boolean wipes, boolean sanitizes){
		return "";
	}

 
}