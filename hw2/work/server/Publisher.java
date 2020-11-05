package server;

import javax.xml.ws.Endpoint;
import server.Server;
 
//Endpoint publisher
public class Publisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8080/hello", new Server());
    }
 
}