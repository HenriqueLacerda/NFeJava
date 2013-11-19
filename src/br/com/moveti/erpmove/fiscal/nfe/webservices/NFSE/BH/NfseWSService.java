
package br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NfseWSService", targetNamespace = "http://ws.bhiss.pbh.gov.br", wsdlLocation = "file:/C:/Users/Henrique/Desktop/NfsBh.wsdl")
public class NfseWSService
    extends Service
{

    private final static URL NFSEWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException NFSEWSSERVICE_EXCEPTION;
    private final static QName NFSEWSSERVICE_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "NfseWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Henrique/Desktop/NfsBh.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFSEWSSERVICE_WSDL_LOCATION = url;
        NFSEWSSERVICE_EXCEPTION = e;
    }

    public NfseWSService() {
        super(__getWsdlLocation(), NFSEWSSERVICE_QNAME);
    }

//    public NfseWSService(WebServiceFeature... features) {
//        super(__getWsdlLocation(), NFSEWSSERVICE_QNAME, features);
//    }

    public NfseWSService(URL wsdlLocation) {
        super(wsdlLocation, NFSEWSSERVICE_QNAME);
    }

//    public NfseWSService(URL wsdlLocation, WebServiceFeature... features) {
//        super(wsdlLocation, NFSEWSSERVICE_QNAME, features);
//    }

    public NfseWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

//    public NfseWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     * 
     * @return
     *     returns Nfse
     */
    @WebEndpoint(name = "nfseSOAP")
    public Nfse getNfseSOAP() {
        return super.getPort(new QName("http://ws.bhiss.pbh.gov.br", "nfseSOAP"), Nfse.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Nfse
     */
    @WebEndpoint(name = "nfseSOAP")
    public Nfse getNfseSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.bhiss.pbh.gov.br", "nfseSOAP"), Nfse.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFSEWSSERVICE_EXCEPTION!= null) {
            throw NFSEWSSERVICE_EXCEPTION;
        }
        return NFSEWSSERVICE_WSDL_LOCATION;
    }

}