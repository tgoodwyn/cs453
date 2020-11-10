package client;

import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        // Setting up service
        ServerService service = new ServerService();
        ServerAPI myinterface = service.getServerPort();

        String response = "";

        boolean run = true;

        // Printing out information
        System.out.println("-----------------------------------");
        System.out.println("             Arguments             ");
        System.out.println("  student\\instructor:enter\\exit  ");
        System.out.println("          classroom:(1-3)          ");
        System.out.println("       rectangle:(1-5 or q|i)      ");
        System.out.println("'Wipes', 'sanitize', and 'mask' only need the word they do not need a pair.");
        System.out.println();
        System.out.println("The arguments and pairs can be in any order.");

        while (run) {
            // Take in input for the current command
            System.out.println("Enter server request> ");
            Scanner input = new Scanner(System.in);
            String request = input.nextLine();

            // Split into list of the arguments to be parsed
            String[] arguments = request.split(" ");

            // Populate the variables for our argument generation
            boolean teacher = false;
            boolean student = false;
            boolean enter = false;
            boolean exit = false;

            int classroom = -1;
            int rectNum = -1;
            boolean wipes = false;
            boolean mask = false;
            boolean germX = false;

            for (String pairs : arguments) {
                // Exit case if quit is anywhere in the argument
                if (pairs.toLowerCase().equals("quit")) {
                    run = false;
                    break;
                }

                // Parsing out values
                String[] currentArg = pairs.split(":");
                switch (currentArg[0].toLowerCase()) {
                    // Sets the booleans for the student\instructor entering or exiting for the
                    // right cmd call later
                    case "student":
                        student = true;
                        if (currentArg[1].toLowerCase().equals("enter")) {
                            enter = true;
                        } else {
                            exit = true;
                        }
                        break;
                    case "instructor":
                        teacher = true;
                        if (currentArg[1].toLowerCase().equals("enter")) {
                            enter = true;
                        } else {
                            exit = true;
                        }
                        break;
                    // Begins parsin classroom and rectangle
                    case "classroom":
                        classroom = Integer.parseInt(currentArg[1]) - 1;
                        break;
                    case "rectangle":
                        if (currentArg[1].toLowerCase().equals("i")) {
                            rectNum = 0;
                        } else if (currentArg[1].toLowerCase().equals("q")) {
                            rectNum = 6;
                        } else {
                            rectNum = Integer.parseInt(currentArg[1]);
                        }
                        break;
                    // These are also arguments but they are set by only specifying them
                    case "mask":
                        mask = true;
                        break;
                    case "wipes":
                        wipes = true;
                        break;
                    case "sanitize":
                        germX = true;
                        break;

                    default:
                        break;
                }
            }
        
            // Calling the server with arguments
            if(student) {
                if(enter) {
                    response = myinterface.studentEnter(classroom, rectNum, wipes, mask);
                } else {
                    response = myinterface.studentExit(classroom, rectNum, wipes, germX);
                }
            } else if(teacher) {
                if(enter) {
                    response = myinterface.instructorEnter(classroom, rectNum, wipes, mask);
                } else {
                    response = myinterface.instructorExit(classroom, wipes, germX);
                }
            }

            // Output the information from the server
            System.out.println(response);
        
        }
    }
}
