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

/*
<?xml version="1.0" encoding="UTF-8"?>
<XMLretEnviNFe200 xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.10">
<tpAmb>2</tpAmb>
<verAplic>0582</verAplic>
<cStat>103</cStat>
<xMotivo>Lote recebido com sucesso</xMotivo>
<cUF>31</cUF>
<dhRecbto>2010-10-01T00:24:34</dhRecbto>
<infRec>
<nRec>310000008329250</nRec>
<tMed>1</tMed>
</infRec>
</XMLretEnviNFe200>
 */
public class XmlRetEnviNFe {

    public static void main(String[] args) {
        XmlRetEnviNFe XmlRetEnviNFe = new XmlRetEnviNFe();

        String NumeroRecibo = "";
        String Retorno = "";

        String XML = "<retEnviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>12_5_72</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>31</cUF><dhRecbto>2012-01-13T15:20:51</dhRecbto><infRec><nRec>310000021153233</nRec><tMed>1</tMed></infRec></retEnviNFe>";
        XmlRetEnviNFe.setXML(XML);
        XmlRetEnviNFe.BuscaDadosXML();

        System.out.println(XmlRetEnviNFe.cStat());

    }
    private String XML = "";
    retEnviNFe retEnviNFe;

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retEnviNFe", retEnviNFe.class);
        xstream.alias("infRec", infRec.class);
        retEnviNFe = (retEnviNFe) xstream.fromXML(XML);
    }

    public String tpAmb() {
        return retEnviNFe.tpAmb;
    }

    public String verAplic() {
        return retEnviNFe.verAplic;
    }

    public String cStat() {
        return retEnviNFe.cStat;
    }

    public String xMotivo() {
        return retEnviNFe.xMotivo;
    }

    public String cUF() {
        return retEnviNFe.cUF;
    }

    public String dhRecbto() {
        return retEnviNFe.dhRecbto;
    }

    public String nRec() {
        return retEnviNFe.infRec.nRec;
    }

    public String tMed() {
        return retEnviNFe.infRec.tMed;
    }
}

class retEnviNFe {

    String tpAmb;
    String verAplic;
    String cStat;
    String xMotivo;
    String cUF;
    String dhRecbto;
    infRec infRec = new infRec();
}

class infRec {

    String nRec;
    String tMed;
}
