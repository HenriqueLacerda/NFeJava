/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 *
 * @author Henrique
 */
/*<?xml version="1.0" encoding="UTF-8"?>
<retConsStatServ versao="1.07" xmlns="http://www.portalfiscal.inf.br/nfe">
<tpAmb>2</tpAmb>
<verAplic>0635</verAplic>
<cStat>107</cStat>
<xMotivo>Servico em operacao</xMotivo>
<cUF>31</cUF>
<dhRecbto>2010-06-01T19:53:14</dhRecbto>
<tMed>1</tMed>
</retConsStatServ>*/
public class XMLretConsStatServ200
{
    // <editor-fold defaultstate="collapsed" desc="main">
    public static void main(String args[]) {
        XMLretConsStatServ200 TratamentoRetorno = new XMLretConsStatServ200();

        String NumeroRecibo = "";
        String Retorno = "";

        String T = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><retConsStatServ versao=\"1.07\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>0635</verAplic>"
                + "<cStat>107</cStat>"
                + "<xMotivo>Servico em operacao</xMotivo>"
                + "<cUF>31</cUF>"
                + "<dhRecbto>2010-06-01T19:53:14</dhRecbto>"
                + "<tMed>1</tMed>"
                + "</retConsStatServ>";
        //TratamentoRetorno.setXML("<?xml version=\"1.0\" encoding=\"UTF-8\"?><retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.10\">  <tpAmb>2</tpAmb>  <verAplic>0582</verAplic>  <nRec>310000008342017</nRec>  <cStat>104</cStat>  <xMotivo>Lote processado</xMotivo>  <cUF>31</cUF>  <protNFe versao=\"1.10\">    <infProt>      <tpAmb>2</tpAmb>      <verAplic>0582</verAplic>      <chNFe>31100309029577000109550010000000412385327100</chNFe>      <dhRecbto>2010-03-30T15:11:05</dhRecbto>      <nProt>131100016637014</nProt>      <digVal>FTtACO+EZ5pf4wO34/mcOWYoLOw=</digVal>      <cStat>100</cStat>      <xMotivo>Autorizado o uso da NF-e</xMotivo>    </infProt>  </protNFe></retConsReciNFe>");
        TratamentoRetorno.setXML(T);
        TratamentoRetorno.BuscaDadosXML();

        /*System.out.println(TratamentoRetorno.cStat());
        for (int i = 0; i < TratamentoRetorno.getProtNFe().size(); i++)
        {
        System.out.println(TratamentoRetorno.getProtNFe().elementAt(i).infProt.nProt);
        }*/
        System.out.println(TratamentoRetorno.getinfProttpAmb());
        System.out.println(TratamentoRetorno.getinfProtxMotivo());
    }// </editor-fold>

    private String XML = "";
    private retConsStatServ xmlretConsStatServ;

    public void setXML(String xml)
    {
        this.XML = xml;
    }

    public retConsStatServ getXmlretConsStatServ() {
        return xmlretConsStatServ;
    }

    public void setXmlretConsStatServ(retConsStatServ xmlretConsStatServ) {
        this.xmlretConsStatServ = xmlretConsStatServ;
    }

    public void BuscaDadosXML()
    {
        XStream xstream = new XStream(new DomDriver());       
        xstream.processAnnotations(XMLretConsStatServ200.class);
        xstream.processAnnotations(XMLretConsStatServ200.retConsStatServ.class);
        System.out.println(XML);
        xmlretConsStatServ=(retConsStatServ) xstream.fromXML(XML);
    }
        
    @XStreamAlias("retConsStatServ")
    class retConsStatServ {

        @XStreamAlias("tpAmb")
        String tpAmb;
        @XStreamAlias("verAplic")
        String verAplic;
        @XStreamAlias("cStat")
        String cStat;
        @XStreamAlias("xMotivo")
        String xMotivo;
        @XStreamAlias("cUF")
        String cUF;
        @XStreamAlias("dhRecbto")
        private String dhRecbto;
        @XStreamAlias("tMed")
        private String tMed;
    }

    public String getinfProttpAmb() {
        return getXmlretConsStatServ().tpAmb;
    }

    public String getinfProtverAplic() {
        return xmlretConsStatServ.verAplic;
    }

    public String getinfProtcStat() {
        return xmlretConsStatServ.cStat;
    }

    public String getinfProtxMotivo()
    {
        return xmlretConsStatServ.xMotivo;
    }

    public String getinfProtcUF()
    {
        return xmlretConsStatServ.cUF;
    }

    public String getinfProtdhRecbto()
    {
        return xmlretConsStatServ.dhRecbto;
    }

    public String getinfProttMed()
    {
        return xmlretConsStatServ.tMed;
    }

}


