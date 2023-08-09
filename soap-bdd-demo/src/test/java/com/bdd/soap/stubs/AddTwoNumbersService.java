
package com.bdd.soap.stubs;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AddTwoNumbersService", targetNamespace = "http://service.soap.bdd.com", wsdlLocation = "http://localhost:9090/soap-demo/services/AddTwoNumbers?wsdl")
public class AddTwoNumbersService
    extends Service
{

    private final static URL ADDTWONUMBERSSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADDTWONUMBERSSERVICE_EXCEPTION;
    private final static QName ADDTWONUMBERSSERVICE_QNAME = new QName("http://service.soap.bdd.com", "AddTwoNumbersService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/soap-demo/services/AddTwoNumbers?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADDTWONUMBERSSERVICE_WSDL_LOCATION = url;
        ADDTWONUMBERSSERVICE_EXCEPTION = e;
    }

    public AddTwoNumbersService() {
        super(__getWsdlLocation(), ADDTWONUMBERSSERVICE_QNAME);
    }

    public AddTwoNumbersService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADDTWONUMBERSSERVICE_QNAME, features);
    }

    public AddTwoNumbersService(URL wsdlLocation) {
        super(wsdlLocation, ADDTWONUMBERSSERVICE_QNAME);
    }

    public AddTwoNumbersService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADDTWONUMBERSSERVICE_QNAME, features);
    }

    public AddTwoNumbersService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AddTwoNumbersService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AddTwoNumbers
     */
    @WebEndpoint(name = "AddTwoNumbers")
    public AddTwoNumbers getAddTwoNumbers() {
        return super.getPort(new QName("http://service.soap.bdd.com", "AddTwoNumbers"), AddTwoNumbers.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AddTwoNumbers
     */
    @WebEndpoint(name = "AddTwoNumbers")
    public AddTwoNumbers getAddTwoNumbers(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.soap.bdd.com", "AddTwoNumbers"), AddTwoNumbers.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADDTWONUMBERSSERVICE_EXCEPTION!= null) {
            throw ADDTWONUMBERSSERVICE_EXCEPTION;
        }
        return ADDTWONUMBERSSERVICE_WSDL_LOCATION;
    }

}
