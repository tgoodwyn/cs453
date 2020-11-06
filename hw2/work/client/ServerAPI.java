
package client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServerAPI", targetNamespace = "http://server/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServerAPI {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/ServerAPI/instructorExitRequest", output = "http://server/ServerAPI/instructorExitResponse")
    public String instructorExit(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        boolean arg2,
        @WebParam(name = "arg3", partName = "arg3")
        boolean arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/ServerAPI/studentEnterRequest", output = "http://server/ServerAPI/studentEnterResponse")
    public String studentEnter(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        boolean arg2,
        @WebParam(name = "arg3", partName = "arg3")
        boolean arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/ServerAPI/helloWorldRequest", output = "http://server/ServerAPI/helloWorldResponse")
    public String helloWorld(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/ServerAPI/instructorEnterRequest", output = "http://server/ServerAPI/instructorEnterResponse")
    public String instructorEnter(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        boolean arg2,
        @WebParam(name = "arg3", partName = "arg3")
        boolean arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/ServerAPI/studentExitRequest", output = "http://server/ServerAPI/studentExitResponse")
    public String studentExit(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        boolean arg2,
        @WebParam(name = "arg3", partName = "arg3")
        boolean arg3);

}
