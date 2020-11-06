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
    public String studentEnter(int classId, int rectId, boolean wipes, boolean mask) {

        String response = "";
        response += "Classroom " + (classId + 1) + "\n";
        if (rectId == 0) {
            response += "Student mistakenly enters  instructor's rectangle and immediately leaves\n";
            return response;
        }

        String rectName = (rectId == 5) ? "for questions" : Integer.toString(rectId);
        response += "Student enters rectangle " + rectName + "\n";
        int count = ++rooms.get(classId).rectangles[rectId];
        if (count > 1) {
            response += "ALERT: Failure to social distance\nCurrently " + count + " occupants\n";
        }
        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!mask) {
            response += "ALERT: Failure to wear a mask\n";
        }
        return response;

    }

	@Override
    public String instructorEnter(int classId, int rectId, boolean wipes, boolean mask) {
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";
        if (rectId != 0) {
            response += "Instructor mistakenly enters a student rectangle and immediately leaves\n";
            return response;
        }

        if (rooms.get(classId).instructorHasEntered) {
            response += "Instructor has already entered the room\n";
            return response;
        }
        rooms.get(classId).instructorHasEntered = true;
        response += "Instructor has entered the room\n";

        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!mask) {
            response += "ALERT: Failure to wear a mask\n";
        }
        return response;
    }

	@Override
    public String studentExit(int classId, int rectId, boolean wipes, boolean sanitizes) {
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";

        int count = rooms.get(classId).rectangles[rectId];
        if (rectId == 0 || count == 0) {
            response += "There is no student in rectangle "+rectId+" to exit.\n";
            return response;
        }

        String rectName = (rectId == 5) ? "for questions" : Integer.toString(rectId);
        response += "Student exits rectangle " + rectName + "\n";
        count = --rooms.get(classId).rectangles[rectId];
        response += "Now there are " + count + " occupants\n";
        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!sanitizes) {
            response += "ALERT: Failure to sanitize\n";
        }
        return response;
    }

	@Override     
    public String instructorExit(int classId, boolean wipes, boolean sanitizes) {
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";
        if (!rooms.get(classId).instructorHasEntered) {
            response += "Instructor not yet in the room\n";
            return response;
        }

        rooms.get(classId).instructorHasEntered = false;
        response += "Instructor has left the room\n";
        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!sanitizes) {
            response += "ALERT: Failure to sanitize\n";
        }
        return response;

    }

}