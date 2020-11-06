package client;
import java.util.Scanner;
public class Client {

  public static void main(String[] args) {
    ServerService myHelloWorld = new ServerService();
    ServerAPI myinterface = myHelloWorld.getServerPort();

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
                System.out.println("4");
                break;
            case 8:
                response = myinterface.studentEnter(0, 8, false, false);
                break;
            case 9:
                response = myinterface.studentEnter(0, 9, false, false);
                break;                              
        }
        System.out.println(response);
    }
}
}
