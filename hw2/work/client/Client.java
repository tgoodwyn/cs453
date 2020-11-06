package client;

public class Client {

  public static void main(String[] args) {
    ServerService myHelloWorld = new ServerService();

    ServerAPI myinterface = myHelloWorld.getServerPort();

    String response = "";

    switch (args[0]) {
      case 2:
        response =
          myinterface.studentEnter()
          );
        break;
      case 4:
        System.out.println("4");
        break;
    }
    response =
      myinterface.studentEnter(
        Integer.parseInt(args[0]),
        Boolean.parseBoolean(args[1])
      );

    System.out.println(response);
  }
}
