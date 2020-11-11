package server;

import server.model.Classroom;
import javax.jws.WebService;
import java.util.ArrayList;

//Service Implementation
@WebService(endpointInterface = "server.ServerAPI")
public class Server implements ServerAPI{
	
    // List to hold the roomos 
    ArrayList<Classroom> rooms;

    Server() {
        // Adds new classrooms as they are needed up to 3
        rooms = new ArrayList<Classroom>();
        for (int i = 0; i < 3; i++) {
            rooms.add(new Classroom());
        }
    }

	@Override
    public String studentEnter(int classId, int rectId, boolean wipes, boolean mask) {
        // Function to handle student entry
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";
        
        // Case to handle student entering instructors space
        if (rectId == 0) {
            response += "Student mistakenly enters  instructor's rectangle and immediately leaves\n";
            System.out.println(response);
        return response;
        }

        // Generating string for the student entry into chosen rectangle
        String rectName = (rectId == 6) ? "for questions" : Integer.toString(rectId);
        response += "Student enters rectangle " + rectName + "\n";
        int count = ++rooms.get(classId).rectangles[rectId];

        // Appending extra strings for values or things that were failed to be done
        if (count > 1) {
            response += "ALERT: Failure to social distance\nCurrently " + count + " occupants\n";
        }
        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!mask) {
            response += "ALERT: Failure to wear a mask\n";
        }
        System.out.println(response);
        return response;

    }

	@Override
    public String instructorEnter(int classId, int rectId, boolean wipes, boolean mask) {
        // Function to handle instructor entry
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";

        // Case to handle the instructor not going to only his space
        if (rectId != 0) {
            response += "Instructor mistakenly enters a student rectangle and immediately leaves\n";
            System.out.println(response);
        return response;
        }

        // Case for trying to pass in more than one instructor
        if (rooms.get(classId).instructorHasEntered) {
            response += "Instructor has already entered the room\n";
            System.out.println(response);
        return response;
        }

        // Else send the entry comfirmation and check for the other failures that could not have been done
        rooms.get(classId).instructorHasEntered = true;
        response += "Instructor has entered the room\n";

        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!mask) {
            response += "ALERT: Failure to wear a mask\n";
        }
        System.out.println(response);
        return response;
    }

	@Override
    public String studentExit(int classId, int rectId, boolean wipes, boolean sanitizes) {
        // Function to handle a student leaving classroom
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";

        // Check to see if there any students in the desired rectangle that can be exited
        int count = rooms.get(classId).rectangles[rectId];
        if (rectId == 0 || count == 0) {
            response += "There is no student in rectangle "+rectId+" to exit.\n";
            System.out.println(response);
        return response;
        }

        // Generate new count of students in the rectangle and generate string
        String rectName = (rectId == 6) ? "for questions" : Integer.toString(rectId);
        response += "Student exits rectangle " + rectName + "\n";
        count = --rooms.get(classId).rectangles[rectId];
        response += "Now there are " + count + " occupants\n";

        // Check to see if student performed required items
        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!sanitizes) {
            response += "ALERT: Failure to sanitize\n";
        }
        System.out.println(response);
        return response;
    }

	@Override     
    public String instructorExit(int classId, boolean wipes, boolean sanitizes) {
        // Function to handle instructor exiting
        String response = "";
        response += "Classroom " + (classId + 1) + "\n";

        // Check to see if the instructor is present to be able to leave
        if (!rooms.get(classId).instructorHasEntered) {
            response += "Instructor not yet in the room\n";
            System.out.println(response);
        return response;
        }

        // Generate the string to return and check to see if instructor performed exiting requirements
        rooms.get(classId).instructorHasEntered = false;
        response += "Instructor has left the room\n";
        if (!wipes) {
            response += "ALERT: Failure to wipe\n";
        }
        if (!sanitizes) {
            response += "ALERT: Failure to sanitize\n";
        }
        System.out.println(response);
        return response;

    }

}