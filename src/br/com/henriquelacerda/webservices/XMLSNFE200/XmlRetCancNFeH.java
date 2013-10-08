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
 */
public class XmlRetCancNFeH {

    private String XML = "";
    retCancNFe retCancNFe;

    public static void main(String args[]) {
        XmlRetCancNFeH XmlRetCancNFeH = new XmlRetCancNFeH();

        String NumeroRecibo = "";
        String Retorno = "";
        XmlRetCancNFeH.setXML("<?xml version=\"1.0\" encoding=\"UTF-8\"?><retCancNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.07\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">   <infCanc>    <tpAmb>2</tpAmb>    <verAplic>0598</verAplic>    <cStat>101</cStat>    <xMotivo>Cancelamento de NF-e homologado</xMotivo>    <cUF>31</cUF>    <chNFe>31100409029577000109550010000000090752334457</chNFe>    <dhRecbto>2010-04-08T16:18:44</dhRecbto>    <nProt>131100016946779</nProt>  </infCanc></retCancNFe>");
        XmlRetCancNFeH.BuscaDadosXML();
        System.out.println(XmlRetCancNFeH.cStat());
        System.out.println(XmlRetCancNFeH.nProt());
    }

    public void setXML(String xml) {
        this.XML = xml;
        System.out.println("XML:" + XML);
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

    public String chNFe() {
        return retCancNFe.infCanc.chNFe;
    }

    public String dhRecbto() {
        return retCancNFe.infCanc.dhRecbto;
    }

    public String nProt() {
        return retCancNFe.infCanc.nProt;
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
        String chNFe;
        String dhRecbto;
        String nProt;
    }
}
