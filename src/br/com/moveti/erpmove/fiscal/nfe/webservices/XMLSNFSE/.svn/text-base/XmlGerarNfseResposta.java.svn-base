/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFSE;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Henrique
 */
public class XmlGerarNfseResposta {

    public static void main(String args[]) {
        XmlGerarNfseResposta XmlGerarNfseResposta = new XmlGerarNfseResposta();

        String NumeroRecibo = "";
        String Retorno = "";

        String T = "<?xml version='1.0' encoding='UTF-8'?>"
                + "<GerarNfseResposta xmlns=\"http://www.abrasf.org.br/nfse.xsd\">"
                + "<NumeroLote>1</NumeroLote><DataRecebimento>2009-09-25T12:57:07</DataRecebimento><Protocolo>Ak0591217L2009q000000006</Protocolo>"
                + "</GerarNfseResposta>";
        XmlGerarNfseResposta.setXML(T);
        XmlGerarNfseResposta.BuscaDadosXML();
        System.out.println(XmlGerarNfseResposta.getCodigo());
    }
    
    private String XML = "";
    private GerarNfseResposta GerarNfseResposta = new GerarNfseResposta();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("GerarNfseResposta", GerarNfseResposta.class);
        GerarNfseResposta = (GerarNfseResposta) xstream.fromXML(XML);
    }

    public String getCodigo() {
        return GerarNfseResposta.NumeroLote;
    }

    class GerarNfseResposta {
        String NumeroLote;
        String DataRecebimento;
        String Protocolo;
    }
}
