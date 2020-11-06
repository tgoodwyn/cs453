package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)

public interface ServerAPI{
 
	@WebMethod String studentEnter(int classId, int rectId, boolean wipes, boolean mask);
	@WebMethod String instructorEnter(int classId, int rectId, boolean wipes, boolean mask);
	@WebMethod String studentExit(int classId, int rectId, boolean wipes, boolean sanitizes);
	@WebMethod String instructorExit(int classId, int rectId, boolean wipes, boolean sanitizes);
 
}