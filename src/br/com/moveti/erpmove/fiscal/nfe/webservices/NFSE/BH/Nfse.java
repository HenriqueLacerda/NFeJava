package br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "nfse", targetNamespace = "http://ws.bhiss.pbh.gov.br")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Nfse {

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "CancelarNfse", action = "http://ws.bhiss.pbh.gov.br/CancelarNfse")
    @WebResult(name = "CancelarNfseResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output cancelarNfse(
            @WebParam(name = "CancelarNfseRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "ConsultarLoteRps", action = "http://ws.bhiss.pbh.gov.br/ConsultarLoteRps")
    @WebResult(name = "ConsultarLoteRpsResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output consultarLoteRps(
            @WebParam(name = "ConsultarLoteRpsRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "ConsultarNfse", action = "http://ws.bhiss.pbh.gov.br/ConsultarNfse")
    @WebResult(name = "ConsultarNfseResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output consultarNfse(
            @WebParam(name = "ConsultarNfseRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "ConsultarNfsePorFaixa", action = "http://ws.bhiss.pbh.gov.br/ConsultarNfsePorFaixa")
    @WebResult(name = "ConsultarNfsePorFaixaResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output consultarNfsePorFaixa(
            @WebParam(name = "ConsultarNfsePorFaixaRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "ConsultarNfsePorRps", action = "http://ws.bhiss.pbh.gov.br/ConsultarNfsePorRps")
    @WebResult(name = "ConsultarNfsePorRpsResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output consultarNfsePorRps(
            @WebParam(name = "ConsultarNfsePorRpsRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "ConsultarSituacaoLoteRps", action = "http://ws.bhiss.pbh.gov.br/ConsultarSituacaoLoteRps")
    @WebResult(name = "ConsultarSituacaoLoteRpsResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output consultarSituacaoLoteRps(
            @WebParam(name = "ConsultarSituacaoLoteRpsRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "RecepcionarLoteRps", action = "http://ws.bhiss.pbh.gov.br/RecepcionarLoteRps")
    @WebResult(name = "RecepcionarLoteRpsResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output recepcionarLoteRps(
            @WebParam(name = "RecepcionarLoteRpsRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns br.gov.pbh.bhiss.ws.Output
     */
    @WebMethod(operationName = "GerarNfse", action = "http://ws.bhiss.pbh.gov.br/GerarNfse")
    @WebResult(name = "GerarNfseResponse", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters")
    public Output gerarNfse(
            @WebParam(name = "GerarNfseRequest", targetNamespace = "http://ws.bhiss.pbh.gov.br", partName = "parameters") Input parameters);
}