
package br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM;

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
@WebServiceClient(name = "NFSEServices", targetNamespace = "http://tempuri.org/", wsdlLocation = "file:/C:/Users/Henrique/Desktop/NfsContagem.wsdl")
public class NFSEServices
    extends Service
{

    private final static URL NFSESERVICES_WSDL_LOCATION;
    private final static WebServiceException NFSESERVICES_EXCEPTION;
    private final static QName NFSESERVICES_QNAME = new QName("http://tempuri.org/", "NFSEServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Henrique/Desktop/NfsContagem.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NFSESERVICES_WSDL_LOCATION = url;
        NFSESERVICES_EXCEPTION = e;
    }

    public NFSEServices() {
        super(__getWsdlLocation(), NFSESERVICES_QNAME);
    }

//    public NFSEServices(WebServiceFeature... features) {
//        super(__getWsdlLocation(), NFSESERVICES_QNAME, features);
//    }

    public NFSEServices(URL wsdlLocation) {
        super(wsdlLocation, NFSESERVICES_QNAME);
    }

//    public NFSEServices(URL wsdlLocation, WebServiceFeature... features) {
//        super(wsdlLocation, NFSESERVICES_QNAME, features);
//    }

    public NFSEServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

//    public NFSEServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     * 
     * @return
     *     returns INFSEConsultas
     */
    @WebEndpoint(name = "basic_INFSEConsultas")
    public INFSEConsultas getBasicINFSEConsultas() {
        return super.getPort(new QName("http://tempuri.org/", "basic_INFSEConsultas"), INFSEConsultas.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns INFSEConsultas
     */
    @WebEndpoint(name = "basic_INFSEConsultas")
    public INFSEConsultas getBasicINFSEConsultas(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "basic_INFSEConsultas"), INFSEConsultas.class, features);
    }

    /**
     * 
     * @return
     *     returns INFSEGeracao
     */
    @WebEndpoint(name = "basic_INFSEGeracao")
    public INFSEGeracao getBasicINFSEGeracao() {
        return super.getPort(new QName("http://tempuri.org/", "basic_INFSEGeracao"), INFSEGeracao.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns INFSEGeracao
     */
    @WebEndpoint(name = "basic_INFSEGeracao")
    public INFSEGeracao getBasicINFSEGeracao(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "basic_INFSEGeracao"), INFSEGeracao.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NFSESERVICES_EXCEPTION!= null) {
            throw NFSESERVICES_EXCEPTION;
        }
        return NFSESERVICES_WSDL_LOCATION;
    }

}
