/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.henriquelacerda.webservices.XMLSEVENTOS;

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
        xstream.processAnnotations(resCanc.class);
        xstream.processAnnotations(ret.class);
        xstream.processAnnotations(resNFe.class);
        xstream.processAnnotations(resCce.class);
        System.out.println(XML);
        xmlretConsNfeDest=(retConsNFeDest) xstream.fromXML(XML);
    }
        
    @XStreamAlias("retConsNFeDest")
    public class retConsNFeDest {
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
    public class ret{
        resNFe resNFe = new resNFe();
        resCanc resCanc = new resCanc();
        resCce resCce = new resCce();
    }
    
    @XStreamAlias("resNFe")
    public class resNFe{
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
    public class resCanc{
        @XStreamAlias("NSU")
        private String NSU;
        @XStreamAlias("chNFe")
        private String chNFe;
        @XStreamAlias("CNPJ")
        private String CNPJ;
        @XStreamAlias("CPF")
        private String CPF;
        @XStreamAlias("xNome")
        private String xNome;
        @XStreamAlias("IE")
        private String IE;
        @XStreamAlias("dEmi")
        private String dEmi;
        @XStreamAlias("tpNF")
        private String tpNF;
        @XStreamAlias("vNF")
        private String vNF;
        @XStreamAlias("digVal")
        private String digVal;
        @XStreamAlias("dhRecbto")
        private String dhRecbto;
        @XStreamAlias("cSitNfe")
        private String cSitNfe;
        @XStreamAlias("cSitConf")
        private String cSitConf;

        public String getNSU() {
            return NSU;
        }

        public void setNSU(String NSU) {
            this.NSU = NSU;
        }

        public String getChNFe() {
            return chNFe;
        }

        public void setChNFe(String chNFe) {
            this.chNFe = chNFe;
        }

        public String getCNPJ() {
            return CNPJ;
        }

        public void setCNPJ(String CNPJ) {
            this.CNPJ = CNPJ;
        }

        public String getCPF() {
            return CPF;
        }

        public void setCPF(String CPF) {
            this.CPF = CPF;
        }

        public String getxNome() {
            return xNome;
        }

        public void setxNome(String xNome) {
            this.xNome = xNome;
        }

        public String getIE() {
            return IE;
        }

        public void setIE(String IE) {
            this.IE = IE;
        }

        public String getdEmi() {
            return dEmi;
        }

        public void setdEmi(String dEmi) {
            this.dEmi = dEmi;
        }

        public String getTpNF() {
            return tpNF;
        }

        public void setTpNF(String tpNF) {
            this.tpNF = tpNF;
        }

        public String getvNF() {
            return vNF;
        }

        public void setvNF(String vNF) {
            this.vNF = vNF;
        }

        public String getDigVal() {
            return digVal;
        }

        public void setDigVal(String digVal) {
            this.digVal = digVal;
        }

        public String getDhRecbto() {
            return dhRecbto;
        }

        public void setDhRecbto(String dhRecbto) {
            this.dhRecbto = dhRecbto;
        }

        public String getcSitNfe() {
            return cSitNfe;
        }

        public void setcSitNfe(String cSitNfe) {
            this.cSitNfe = cSitNfe;
        }

        public String getcSitConf() {
            return cSitConf;
        }

        public void setcSitConf(String cSitConf) {
            this.cSitConf = cSitConf;
        }
    }
    
    @XStreamAlias("resCce")
    public class resCce {

        @XStreamAlias("NSU")
        private String NSU;
        @XStreamAlias("chNFe")
        private String chNFe;
        @XStreamAlias("dhEvento")
        private String dhEvento;
        @XStreamAlias("tpEvento")
        private String tpEvento;
        @XStreamAlias("nSeqEvento")
        private String nSeqEvento;
        @XStreamAlias("descEvento")
        private String descEvento;
        @XStreamAlias("xCorrecao")
        private String xCorrecao;
        @XStreamAlias("tpNF")
        private String tpNF;
        @XStreamAlias("dhRecbto")
        private String dhRecbto;

        public String getNSU() {
            return NSU;
        }

        public void setNSU(String NSU) {
            this.NSU = NSU;
        }

        public String getChNFe() {
            return chNFe;
        }

        public void setChNFe(String chNFe) {
            this.chNFe = chNFe;
        }

        public String getDhEvento() {
            return dhEvento;
        }

        public void setDhEvento(String dhEvento) {
            this.dhEvento = dhEvento;
        }

        public String getTpEvento() {
            return tpEvento;
        }

        public void setTpEvento(String tpEvento) {
            this.tpEvento = tpEvento;
        }

        public String getnSeqEvento() {
            return nSeqEvento;
        }

        public void setnSeqEvento(String nSeqEvento) {
            this.nSeqEvento = nSeqEvento;
        }

        public String getDescEvento() {
            return descEvento;
        }

        public void setDescEvento(String descEvento) {
            this.descEvento = descEvento;
        }

        public String getxCorrecao() {
            return xCorrecao;
        }

        public void setxCorrecao(String xCorrecao) {
            this.xCorrecao = xCorrecao;
        }

        public String getTpNF() {
            return tpNF;
        }

        public void setTpNF(String tpNF) {
            this.tpNF = tpNF;
        }

        public String getDhRecbto() {
            return dhRecbto;
        }

        public void setDhRecbto(String dhRecbto) {
            this.dhRecbto = dhRecbto;
        }
         
     }


}


