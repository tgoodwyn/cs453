package client;
import java.util.Scanner;
public class Client {

  public static void main(String[] args) {
    ServerService service = new ServerService();
    ServerAPI myinterface = service.getServerPort();

    String response = "";
    while (true) {
        System.out.println("Enter server request> ");
        Scanner input = new Scanner(System.in);
        int request = input.nextInt();
        if (request == 0) {
            break;
        }
        switch (request) {
            case 1:
                response = myinterface.studentEnter(0, 1, false, false);
                break;
            case 2:
                response = myinterface.studentEnter(1, 2, false, false);
                break;
            case 3:
                response = myinterface.studentEnter(0, 1, true, false);

                break;
            case 4:
                response = myinterface.studentEnter(0, 1, false, true);

                break;
            case 5:
                response = myinterface.studentExit(0, 1, false, false);

                break;
            case 6:
                response = myinterface.instructorEnter(0, 0, false, false);
                break;
            // instructor tries to enter student rect
            case 7:
                response = myinterface.instructorEnter(0, 1, false, false);
                break;
            // student tries to enter instructor rect

            case 8:
                response = myinterface.studentEnter(0, 0, false, false);
                break;
            case 9:
                response = myinterface.studentExit(0, 1, true, false);

                break;
            case 10:
                response = myinterface.instructorExit(0, false, false);
                break;

        }
        System.out.println(response);
    }
    }
}
