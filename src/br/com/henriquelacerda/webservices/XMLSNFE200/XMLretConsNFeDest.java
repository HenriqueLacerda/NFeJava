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
<retConsNFeDest versao="1.07" xmlns="http://www.portalfiscal.inf.br/nfe">
<tpAmb>2</tpAmb>
<verAplic>0635</verAplic>
<cStat>107</cStat>
<xMotivo>Servico em operacao</xMotivo>
<cUF>31</cUF>
<dhRecbto>2010-06-01T19:53:14</dhRecbto>
<tMed>1</tMed>
</retConsNFeDest>*/
public class XMLretConsNFeDest
{
    // <editor-fold defaultstate="collapsed" desc="main">
    public static void main(String args[]) {
        XMLretConsNFeDest TratamentoRetorno = new XMLretConsNFeDest();

        String NumeroRecibo = "";
        String Retorno = "";

        String T = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><retConsNFeDest versao=\"1.07\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>0635</verAplic>"
                + "<cStat>107</cStat>"
                + "<xMotivo>Servico em operacao</xMotivo>"
                + "<cUF>31</cUF>"
                + "<dhRecbto>2010-06-01T19:53:14</dhRecbto>"
                + "<tMed>1</tMed>"
                + "</retConsNFeDest>";
        //TratamentoRetorno.setXML("<?xml version=\"1.0\" encoding=\"UTF-8\"?><retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.10\">  <tpAmb>2</tpAmb>  <verAplic>0582</verAplic>  <nRec>310000008342017</nRec>  <cStat>104</cStat>  <xMotivo>Lote processado</xMotivo>  <cUF>31</cUF>  <protNFe versao=\"1.10\">    <infProt>      <tpAmb>2</tpAmb>      <verAplic>0582</verAplic>      <chNFe>31100309029577000109550010000000412385327100</chNFe>      <dhRecbto>2010-03-30T15:11:05</dhRecbto>      <nProt>131100016637014</nProt>      <digVal>FTtACO+EZ5pf4wO34/mcOWYoLOw=</digVal>      <cStat>100</cStat>      <xMotivo>Autorizado o uso da NF-e</xMotivo>    </infProt>  </protNFe></retConsReciNFe>");
        TratamentoRetorno.setXML(T);
        TratamentoRetorno.BuscaDadosXML();

        /*System.out.println(TratamentoRetorno.cStat());
        for (int i = 0; i < TratamentoRetorno.getProtNFe().size(); i++)
        {
        System.out.println(TratamentoRetorno.getProtNFe().elementAt(i).infProt.nProt);
        }*/        
    }// </editor-fold>

    private String XML = "";
    private retConsNFeDest xmlretConsNfeDest;

    public void setXML(String xml)
    {
        this.XML = xml;
    }

    public retConsNFeDest getxmlretConsNfeDest() {
        return xmlretConsNfeDest;
    }

    public void setxmlretConsNfeDest(retConsNFeDest xmlretConsNfeDest) {
        this.xmlretConsNfeDest = xmlretConsNfeDest;
    }

    public void BuscaDadosXML()
    {
        XStream xstream = new XStream(new DomDriver());       
        xstream.processAnnotations(retConsNFeDest.class);
        xstream.processAnnotations(XmlRetCancNFe.class);
        xstream.processAnnotations(ret.class);
        xstream.processAnnotations(retEnviNFe.class);
        System.out.println(XML);
        xmlretConsNfeDest=(retConsNFeDest) xstream.fromXML(XML);
    }
        
    @XStreamAlias("retConsNFeDest")
    class retConsNFeDest {
        @XStreamAlias("versao")
        String versao;
        @XStreamAlias("tpAmb")
        String tpAmb;
        @XStreamAlias("verAplic")
        String verAplic;
        @XStreamAlias("cStat")
        String cStat;
        @XStreamAlias("xMotivo")
        String xMotivo;
        @XStreamAlias("dhResp")
        String dhResp;
        @XStreamAlias("indCont")
        String indCont;
        @XStreamAlias("ultNSU")
        String ultNSU;
        ret ret = new ret();
    }
    
    @XStreamAlias("ret")
    class ret{
        resNFe resNFe = new resNFe();
        resCanc resCanc = new resCanc();
    }
    
    @XStreamAlias("resNFe")
    class resNFe{
        @XStreamAlias("NSU")
        String NSU;
        @XStreamAlias("chNFe")
        String chNFe;
        @XStreamAlias("CNPJ")
        String CNPJ;
        @XStreamAlias("CPF")
        String CPF;
        @XStreamAlias("xNome")
        String xNome;
        @XStreamAlias("IE")
        String IE;
        @XStreamAlias("dEmi")
        String dEmi;
        @XStreamAlias("tpNF")
        String tpNF;
        @XStreamAlias("vNF")
        String vNF;
        @XStreamAlias("digVal")
        String digVal;
        @XStreamAlias("dhRecbto")
        String dhRecbto;
        @XStreamAlias("cSitNfe")
        String cSitNfe;
        @XStreamAlias("cSitConf")
        String cSitConf;                
    }
    
    @XStreamAlias("resCanc")
    class resCanc{
        @XStreamAlias("NSU")
        String NSU;
        @XStreamAlias("chNFe")
        String chNFe;
        @XStreamAlias("CNPJ")
        String CNPJ;
        @XStreamAlias("CPF")
        String CPF;
        @XStreamAlias("xNome")
        String xNome;
        @XStreamAlias("IE")
        String IE;
        @XStreamAlias("dEmi")
        String dEmi;
        @XStreamAlias("tpNF")
        String tpNF;
        @XStreamAlias("vNF")
        String vNF;
        @XStreamAlias("digVal")
        String digVal;
        @XStreamAlias("dhRecbto")
        String dhRecbto;
        @XStreamAlias("cSitNfe")
        String cSitNfe;
        @XStreamAlias("cSitConf")
        String cSitConf; 
    }


}


