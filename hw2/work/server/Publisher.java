package server;

import javax.xml.ws.Endpoint;
import server.HWImpl;
 
//Endpoint publisher
public class HWPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8080/hello", new HWImpl());
    }
 
}