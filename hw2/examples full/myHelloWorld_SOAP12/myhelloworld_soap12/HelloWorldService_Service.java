
package myhelloworld_soap12;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloWorldService", targetNamespace = "http://myHelloWorld_SOAP12/", wsdlLocation = "http://localhost:8080/hello?wsdl")
public class HelloWorldService_Service
    extends Service
{

    private final static URL HELLOWORLDSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(myhelloworld_soap12.HelloWorldService_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = myhelloworld_soap12.HelloWorldService_Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/hello?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/hello?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HELLOWORLDSERVICE_WSDL_LOCATION = url;
    }

    public HelloWorldService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldService_Service() {
        super(HELLOWORLDSERVICE_WSDL_LOCATION, new QName("http://myHelloWorld_SOAP12/", "HelloWorldService"));
    }

    /**
     * 
     * @return
     *     returns HelloWorldService
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorldService getHelloWorldImplPort() {
        return super.getPort(new QName("http://myHelloWorld_SOAP12/", "HelloWorldImplPort"), HelloWorldService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldService
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorldService getHelloWorldImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://myHelloWorld_SOAP12/", "HelloWorldImplPort"), HelloWorldService.class, features);
    }

}
