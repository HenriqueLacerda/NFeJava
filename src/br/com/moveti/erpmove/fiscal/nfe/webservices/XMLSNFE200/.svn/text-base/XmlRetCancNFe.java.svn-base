/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.ObjectInputStream;
import java.io.StringReader;

/**
 *
 * @author Henrique
 * 
 */
public class XmlRetCancNFe {

    private String XML = "";
    retCancNFe retCancNFe;

    public static void main(String args[]) {
        XmlRetCancNFe XmlRetCancNFe = new XmlRetCancNFe();

        String NumeroRecibo = "";
        String Retorno = "";

        String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<retCancNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
                + "<infCanc>"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>13_0_68</verAplic>"
                + "<cStat>213</cStat>"
                + "<xMotivo>Rejeicao: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital</xMotivo>"
                + "<cUF>31</cUF>"
                + "</infCanc>"
                + "</retCancNFe>";

        XmlRetCancNFe.setXML(XML);
        XmlRetCancNFe.BuscaDadosXML();

        System.out.println(XmlRetCancNFe.cStat());
    }

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retCancNFe", retCancNFe.class);
        xstream.alias("infCanc", infCanc.class);
        retCancNFe = (retCancNFe) xstream.fromXML(XML);
    }

    public String tpAmb() {
        return retCancNFe.infCanc.tpAmb;
    }

    public String verAplic() {
        return retCancNFe.infCanc.verAplic;
    }

    public String cStat() {
        return retCancNFe.infCanc.cStat;
    }

    public String xMotivo() {
        return retCancNFe.infCanc.xMotivo;
    }

    public String cUF() {
        return retCancNFe.infCanc.cUF;
    }

    class retCancNFe {
        String versao;
        infCanc infCanc = new infCanc();
    }

    class infCanc {
        String tpAmb;
        String verAplic;
        String cStat;
        String xMotivo;
        String cUF;
    }
}
