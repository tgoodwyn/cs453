package server;

import javax.xml.ws.Endpoint;
import server.HW;
 
//Endpoint publisher
public class Publisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8080/hello", new HW());
    }
 
}