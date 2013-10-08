
package br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM;

import br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM.CancelarNfse;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _ConsultarNfsePorRpsXmlEnvio_QNAME = new QName("http://tempuri.org/", "xmlEnvio");
    private final static QName _ConsultarLoteRpsResponseConsultarLoteRpsResult_QNAME = new QName("http://tempuri.org/", "ConsultarLoteRpsResult");
    private final static QName _ConsultarNfsePorRpsResponseConsultarNfsePorRpsResult_QNAME = new QName("http://tempuri.org/", "ConsultarNfsePorRpsResult");
    private final static QName _ConsultarSituacaoLoteRpsResponseConsultarSituacaoLoteRpsResult_QNAME = new QName("http://tempuri.org/", "ConsultarSituacaoLoteRpsResult");
    private final static QName _CancelarNfseResponseCancelarNfseResult_QNAME = new QName("http://tempuri.org/", "CancelarNfseResult");
    private final static QName _ConsultarNfseResponseConsultarNfseResult_QNAME = new QName("http://tempuri.org/", "ConsultarNfseResult");
    private final static QName _RecepcionarLoteRpsResponseRecepcionarLoteRpsResult_QNAME = new QName("http://tempuri.org/", "RecepcionarLoteRpsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CancelarNfseResponse }
     * 
     */
    public CancelarNfseResponse createCancelarNfseResponse() {
        return new CancelarNfseResponse();
    }

    /**
     * Create an instance of {@link ConsultarSituacaoLoteRpsResponse }
     * 
     */
    public ConsultarSituacaoLoteRpsResponse createConsultarSituacaoLoteRpsResponse() {
        return new ConsultarSituacaoLoteRpsResponse();
    }

    /**
     * Create an instance of {@link ConsultarNfse }
     * 
     */
    public ConsultarNfse createConsultarNfse() {
        return new ConsultarNfse();
    }

    /**
     * Create an instance of {@link RecepcionarLoteRps }
     * 
     */
    public RecepcionarLoteRps createRecepcionarLoteRps() {
        return new RecepcionarLoteRps();
    }

    /**
     * Create an instance of {@link ConsultarNfseResponse }
     * 
     */
    public ConsultarNfseResponse createConsultarNfseResponse() {
        return new ConsultarNfseResponse();
    }

    /**
     * Create an instance of {@link ConsultarLoteRpsResponse }
     * 
     */
    public ConsultarLoteRpsResponse createConsultarLoteRpsResponse() {
        return new ConsultarLoteRpsResponse();
    }

    /**
     * Create an instance of {@link ConsultarNfsePorRpsResponse }
     * 
     */
    public ConsultarNfsePorRpsResponse createConsultarNfsePorRpsResponse() {
        return new ConsultarNfsePorRpsResponse();
    }

    /**
     * Create an instance of {@link ConsultarSituacaoLoteRps }
     * 
     */
    public ConsultarSituacaoLoteRps createConsultarSituacaoLoteRps() {
        return new ConsultarSituacaoLoteRps();
    }

    /**
     * Create an instance of {@link CancelarNfse }
     * 
     */
    public CancelarNfse createCancelarNfse() {
        return new CancelarNfse();
    }

    /**
     * Create an instance of {@link ConsultarLoteRps }
     * 
     */
    public ConsultarLoteRps createConsultarLoteRps() {
        return new ConsultarLoteRps();
    }

    /**
     * Create an instance of {@link RecepcionarLoteRpsResponse }
     * 
     */
    public RecepcionarLoteRpsResponse createRecepcionarLoteRpsResponse() {
        return new RecepcionarLoteRpsResponse();
    }

    /**
     * Create an instance of {@link ConsultarNfsePorRps }
     * 
     */
    public ConsultarNfsePorRps createConsultarNfsePorRps() {
        return new ConsultarNfsePorRps();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlEnvio", scope = ConsultarNfsePorRps.class)
    public JAXBElement<String> createConsultarNfsePorRpsXmlEnvio(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsXmlEnvio_QNAME, String.class, ConsultarNfsePorRps.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarLoteRpsResult", scope = ConsultarLoteRpsResponse.class)
    public JAXBElement<String> createConsultarLoteRpsResponseConsultarLoteRpsResult(String value) {
        return new JAXBElement<String>(_ConsultarLoteRpsResponseConsultarLoteRpsResult_QNAME, String.class, ConsultarLoteRpsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlEnvio", scope = ConsultarNfse.class)
    public JAXBElement<String> createConsultarNfseXmlEnvio(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsXmlEnvio_QNAME, String.class, ConsultarNfse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlEnvio", scope = ConsultarLoteRps.class)
    public JAXBElement<String> createConsultarLoteRpsXmlEnvio(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsXmlEnvio_QNAME, String.class, ConsultarLoteRps.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlEnvio", scope = RecepcionarLoteRps.class)
    public JAXBElement<String> createRecepcionarLoteRpsXmlEnvio(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsXmlEnvio_QNAME, String.class, RecepcionarLoteRps.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarNfsePorRpsResult", scope = ConsultarNfsePorRpsResponse.class)
    public JAXBElement<String> createConsultarNfsePorRpsResponseConsultarNfsePorRpsResult(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsResponseConsultarNfsePorRpsResult_QNAME, String.class, ConsultarNfsePorRpsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarSituacaoLoteRpsResult", scope = ConsultarSituacaoLoteRpsResponse.class)
    public JAXBElement<String> createConsultarSituacaoLoteRpsResponseConsultarSituacaoLoteRpsResult(String value) {
        return new JAXBElement<String>(_ConsultarSituacaoLoteRpsResponseConsultarSituacaoLoteRpsResult_QNAME, String.class, ConsultarSituacaoLoteRpsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CancelarNfseResult", scope = CancelarNfseResponse.class)
    public JAXBElement<String> createCancelarNfseResponseCancelarNfseResult(String value) {
        return new JAXBElement<String>(_CancelarNfseResponseCancelarNfseResult_QNAME, String.class, CancelarNfseResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarNfseResult", scope = ConsultarNfseResponse.class)
    public JAXBElement<String> createConsultarNfseResponseConsultarNfseResult(String value) {
        return new JAXBElement<String>(_ConsultarNfseResponseConsultarNfseResult_QNAME, String.class, ConsultarNfseResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlEnvio", scope = ConsultarSituacaoLoteRps.class)
    public JAXBElement<String> createConsultarSituacaoLoteRpsXmlEnvio(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsXmlEnvio_QNAME, String.class, ConsultarSituacaoLoteRps.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "xmlEnvio", scope = CancelarNfse.class)
    public JAXBElement<String> createCancelarNfseXmlEnvio(String value) {
        return new JAXBElement<String>(_ConsultarNfsePorRpsXmlEnvio_QNAME, String.class, CancelarNfse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "RecepcionarLoteRpsResult", scope = RecepcionarLoteRpsResponse.class)
    public JAXBElement<String> createRecepcionarLoteRpsResponseRecepcionarLoteRpsResult(String value) {
        return new JAXBElement<String>(_RecepcionarLoteRpsResponseRecepcionarLoteRpsResult_QNAME, String.class, RecepcionarLoteRpsResponse.class, value);
    }

}
