
package br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.gov.pbh.bhiss.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarNfseResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarNfseResponse");
    private final static QName _CancelarNfseRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "CancelarNfseRequest");
    private final static QName _ConsultarNfsePorRpsResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarNfsePorRpsResponse");
    private final static QName _CancelarNfseResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "CancelarNfseResponse");
    private final static QName _ConsultarNfsePorRpsRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarNfsePorRpsRequest");
    private final static QName _RecepcionarLoteRpsRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "RecepcionarLoteRpsRequest");
    private final static QName _GerarNfseResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "GerarNfseResponse");
    private final static QName _ConsultarLoteRpsResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsResponse");
    private final static QName _ConsultarNfseRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarNfseRequest");
    private final static QName _ConsultarNfsePorFaixaRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarNfsePorFaixaRequest");
    private final static QName _ConsultarLoteRpsRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarLoteRpsRequest");
    private final static QName _ConsultarSituacaoLoteRpsResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarSituacaoLoteRpsResponse");
    private final static QName _RecepcionarLoteRpsResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "RecepcionarLoteRpsResponse");
    private final static QName _ConsultarNfsePorFaixaResponse_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarNfsePorFaixaResponse");
    private final static QName _GerarNfseRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "GerarNfseRequest");
    private final static QName _ConsultarSituacaoLoteRpsRequest_QNAME = new QName("http://ws.bhiss.pbh.gov.br", "ConsultarSituacaoLoteRpsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.gov.pbh.bhiss.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Input }
     * 
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link Output }
     * 
     */
    public Output createOutput() {
        return new Output();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarNfseResponse")
    public JAXBElement<Output> createConsultarNfseResponse(Output value) {
        return new JAXBElement<Output>(_ConsultarNfseResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "CancelarNfseRequest")
    public JAXBElement<Input> createCancelarNfseRequest(Input value) {
        return new JAXBElement<Input>(_CancelarNfseRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarNfsePorRpsResponse")
    public JAXBElement<Output> createConsultarNfsePorRpsResponse(Output value) {
        return new JAXBElement<Output>(_ConsultarNfsePorRpsResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "CancelarNfseResponse")
    public JAXBElement<Output> createCancelarNfseResponse(Output value) {
        return new JAXBElement<Output>(_CancelarNfseResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarNfsePorRpsRequest")
    public JAXBElement<Input> createConsultarNfsePorRpsRequest(Input value) {
        return new JAXBElement<Input>(_ConsultarNfsePorRpsRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "RecepcionarLoteRpsRequest")
    public JAXBElement<Input> createRecepcionarLoteRpsRequest(Input value) {
        return new JAXBElement<Input>(_RecepcionarLoteRpsRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "GerarNfseResponse")
    public JAXBElement<Output> createGerarNfseResponse(Output value) {
        return new JAXBElement<Output>(_GerarNfseResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarLoteRpsResponse")
    public JAXBElement<Output> createConsultarLoteRpsResponse(Output value) {
        return new JAXBElement<Output>(_ConsultarLoteRpsResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarNfseRequest")
    public JAXBElement<Input> createConsultarNfseRequest(Input value) {
        return new JAXBElement<Input>(_ConsultarNfseRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarNfsePorFaixaRequest")
    public JAXBElement<Input> createConsultarNfsePorFaixaRequest(Input value) {
        return new JAXBElement<Input>(_ConsultarNfsePorFaixaRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarLoteRpsRequest")
    public JAXBElement<Input> createConsultarLoteRpsRequest(Input value) {
        return new JAXBElement<Input>(_ConsultarLoteRpsRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarSituacaoLoteRpsResponse")
    public JAXBElement<Output> createConsultarSituacaoLoteRpsResponse(Output value) {
        return new JAXBElement<Output>(_ConsultarSituacaoLoteRpsResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "RecepcionarLoteRpsResponse")
    public JAXBElement<Output> createRecepcionarLoteRpsResponse(Output value) {
        return new JAXBElement<Output>(_RecepcionarLoteRpsResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Output }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarNfsePorFaixaResponse")
    public JAXBElement<Output> createConsultarNfsePorFaixaResponse(Output value) {
        return new JAXBElement<Output>(_ConsultarNfsePorFaixaResponse_QNAME, Output.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "GerarNfseRequest")
    public JAXBElement<Input> createGerarNfseRequest(Input value) {
        return new JAXBElement<Input>(_GerarNfseRequest_QNAME, Input.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.bhiss.pbh.gov.br", name = "ConsultarSituacaoLoteRpsRequest")
    public JAXBElement<Input> createConsultarSituacaoLoteRpsRequest(Input value) {
        return new JAXBElement<Input>(_ConsultarSituacaoLoteRpsRequest_QNAME, Input.class, null, value);
    }

}
