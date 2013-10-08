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
<XMLretEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.10">
<tpAmb>2</tpAmb>
<verAplic>0582</verAplic>
<cStat>103</cStat>
<xMotivo>Lote recebido com sucesso</xMotivo>
<cUF>31</cUF>
<infRec>
<nRec>310000008329250</nRec>
<dhRecbto>2010-03-29T20:44:59</dhRecbto>
<tMed>1</tMed>
</infRec>
</XMLretEnviNFe>
 */
public class XmlRetInutNFe {

    private String XML = "";
    retInutNFe retInutNFe;

    public static void main(String args[]) {
        XmlRetInutNFe XmlRetInutNFe = new XmlRetInutNFe();

        String NumeroRecibo = "";
        String Retorno = "";


        //XmlRetInutNFe.setXML("<retInutNFe versao=\"1.07\" xmlns=\"http://www.portalfiscal.inf.br/nfe\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">  <infInut>    <tpAmb>2</tpAmb>    <verAplic>0604</verAplic>    <cStat>102</cStat>    <xMotivo>Inutilizacao de numero homologado</xMotivo>    <cUF>31</cUF></infInut></retInutNFe>");
         XmlRetInutNFe.setXML("<retInutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" versao=\"2.00\">"
                + "<infInut Id=\"ID31256\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>13_0_94</verAplic>"
                + "<cStat>256</cStat>"
                + "<xMotivo>Rejeicao: Numero da NFe ja foi inutilizado anteriormente</xMotivo>"
                + "<cUF>31</cUF>"
                + "</infInut>"
                + "</retInutNFe>");
        XmlRetInutNFe.BuscaDadosXML();

        System.out.println(XmlRetInutNFe.cStat());
        System.out.println(XmlRetInutNFe.xMotivo());
        //System.out.println(TratamentoRetorno.nProt());

        /*<?xml version="1.0" encoding="UTF-8"?>
        <retInutNFe versao="2.00" xmlns="http://www.portalfiscal.inf.br/nfe" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
        <infInut Id="IDnull239">
        <tpAmb>2</tpAmb>
        <verAplic>0604</verAplic>
        <cStat>239</cStat>
        <xMotivo>Rejeicao: Cabecalho - Versao do arquivo XML nao suportada</xMotivo>
        <cUF>null</cUF>
        </infInut>
        </retInutNFe>*/


    }

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retInutNFe", retInutNFe.class);
        xstream.alias("infInut", infInut.class);
        retInutNFe = (retInutNFe) xstream.fromXML(XML);
    }

    public String tpAmb() {
        return retInutNFe.infInut.tpAmb;
    }

    public String verAplic() {
        return retInutNFe.infInut.verAplic;
    }

    public String cStat() {
        return retInutNFe.infInut.cStat;
    }

    public String xMotivo() {
        return retInutNFe.infInut.xMotivo;
    }

    public String cUF() {
        return retInutNFe.infInut.cUF;
    }

    class retInutNFe {
        infInut infInut = new infInut();
    }

    class infInut {
        String tpAmb;
        String verAplic;
        String cStat;
        String xMotivo;
        String cUF;
    }
}


