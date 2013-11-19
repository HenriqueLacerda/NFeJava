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
<retInutNFe versao="1.07" xmlns="http://www.portalfiscal.inf.br/nfe" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<infInut>
<tpAmb>2</tpAmb>
<verAplic>0604</verAplic>
<cStat>102</cStat>
<xMotivo>Inutilizacao de numero homologado</xMotivo>
<cUF>31</cUF>
<ano>10</ano>
<CNPJ>09029577000109</CNPJ>
<mod>55</mod>
<serie>1</serie>
<nNFIni>27</nNFIni>
<nNFFin>27</nNFFin>
<dhRecbto>2010-04-22T11:36:01</dhRecbto>
<nProt>131100017311467</nProt>
</infInut>
</retInutNFe>
 */
public class XmlRetInutNFeH {

    private String XML = "";
    retInutNFe retInutNFe;

    public static void main(String args[]) {
        XmlRetInutNFeH XmlRetInutNFeH = new XmlRetInutNFeH();

        String NumeroRecibo = "";
        String Retorno = "";


        //XmlRetInutNFeH.setXML("<retInutNFe versao=\"1.07\" xmlns=\"http://www.portalfiscal.inf.br/nfe\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">  <infInut>    <tpAmb>2</tpAmb>    <verAplic>0604</verAplic>    <cStat>102</cStat>    <xMotivo>Inutilizacao de numero homologado</xMotivo>    <cUF>31</cUF>    <ano>10</ano>    <CNPJ>09029577000109</CNPJ>    <mod>55</mod>    <serie>1</serie>    <nNFIni>27</nNFIni>    <nNFFin>27</nNFFin>    <dhRecbto>2010-04-22T11:36:01</dhRecbto>    <nProt>131100017311467</nProt>  </infInut></retInutNFe>");
        XmlRetInutNFeH.setXML("<retInutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" versao=\"2.00\">"
                + "<infInut Id=\"ID31256\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>13_0_94</verAplic>"
                + "<cStat>256</cStat>"
                + "<xMotivo>Rejeicao: Numero da NFe ja foi inutilizado anteriormente</xMotivo>"
                + "<cUF>31</cUF>"
                + "</infInut>"
                + "</retInutNFe>");
        
        XmlRetInutNFeH.BuscaDadosXML();

        System.out.println(XmlRetInutNFeH.cStat());
        System.out.println(XmlRetInutNFeH.nProt());
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

    public String ano() {
        return retInutNFe.infInut.ano;
    }

    public String CNPJ() {
        return retInutNFe.infInut.CNPJ;
    }

    public String mod() {
        return retInutNFe.infInut.mod;
    }

    public String serie() {
        return retInutNFe.infInut.serie;
    }

    public String nNFIni() {
        return retInutNFe.infInut.nNFIni;
    }

    public String nNFFin() {
        return retInutNFe.infInut.nNFFin;
    }

    public String dhRecbto() {
        return retInutNFe.infInut.dhRecbto;
    }

    public String nProt() {
        return retInutNFe.infInut.nProt;
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
        String ano;
        String CNPJ;
        String mod;
        String serie;
        String nNFIni;
        String nNFFin;
        String dhRecbto;
        String nProt;
    }
}
