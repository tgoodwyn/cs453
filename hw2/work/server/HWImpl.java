package server;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "server.ServerFunc")
public class HWImpl implements ServerFunc{
 
	@Override
	public String HelloWorld(String name) {

		System.out.println(name+" says hello");
		return "Hello World " + name;
	}
 
}