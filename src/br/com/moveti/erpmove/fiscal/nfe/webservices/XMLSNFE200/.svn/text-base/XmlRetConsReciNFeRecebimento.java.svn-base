/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.List;

/**
 *
 * @author Henrique
 * 
 */
public class XmlRetConsReciNFeRecebimento {

    public static void main(String args[]) {
        XmlRetConsReciNFeRecebimento TratamentoRetorno = new XmlRetConsReciNFeRecebimento();

        String NumeroRecibo = "";
        String Retorno = "";
        
        String T = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>13_0_87</verAplic>"
                + "<nRec>310000024972085</nRec>"
                + "<cStat>104</cStat>"
                + "<xMotivo>Lote processado</xMotivo>"
                + "<cUF>31</cUF>"
                + "<protNFe versao=\"2.00\">"
                + "<infProt>"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>13_0_87</verAplic>"
                + "<chNFe>31130609029577000109550010000043591588665635</chNFe>"
                + "<dhRecbto>2013-06-07T14:12:18</dhRecbto>"
                + "<nProt>131130034292358</nProt>"
                + "<digVal>Jxt48tFeywYPl7l0DUxhqmg4QqM=</digVal>"
                + "<cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt>"
                + "</protNFe>"
                + "</retConsReciNFe>";
        //T = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>12_5_72</verAplic><nRec>310000021153233</nRec><cStat>105</cStat><xMotivo>Lote em processamento</xMotivo><cUF>31</cUF></retConsReciNFe>";
        TratamentoRetorno.setXML(T);
        TratamentoRetorno.BuscaDadosXML();
        
        System.out.println(TratamentoRetorno.infProt_xMotivo(0));
    }
    private String XML = "";
    public retConsReciNFe retConsReciNFe = new retConsReciNFe();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
//        xstream.alias("retConsReciNFe", retConsReciNFe.class);
//        xstream.alias("protNFe", protNFe.class);
//        xstream.alias("infProt", infProt.class);
        xstream.processAnnotations(retConsReciNFe.class);
        xstream.processAnnotations(protNFe.class);
        xstream.processAnnotations(infProt.class);
        //stream.processAnnotations
        System.out.println(XML);
        retConsReciNFe = (retConsReciNFe) xstream.fromXML(XML);
    }

    public String cStat() {
        return retConsReciNFe.cStat;
    }

    public String cUF() {
        return retConsReciNFe.cUF;
    }

    public String nRec() {
        return retConsReciNFe.nRec;
    }

//    public protNFe protNFe() {
//        return retConsReciNFe.protNFe;
//    }
    public String tpAmb() {
        return retConsReciNFe.tpAmb;
    }

    public String verAplic() {
        return retConsReciNFe.verAplic;
    }

    public String xMotivo() {
        return retConsReciNFe.xMotivo;
    }
    
    public List<protNFe> getProtNFe()
    {
        return retConsReciNFe.protNFe;
    }
    
    ///

    public String infProt_cStat(int i) {
        // Não exibir o erro 999 para o cliente
        if (retConsReciNFe.protNFe.get(i).infProt.cStat.equals("999"))
        {
            return "105";
        }
        return retConsReciNFe.protNFe.get(i).infProt.cStat;
    }

    public String infProt_chNFe(int i) {
        return retConsReciNFe.protNFe.get(i).infProt.chNFe;
    }

    
    public String infProt_nProt(int i) {
        return retConsReciNFe.protNFe.get(i).infProt.nProt;
    }
    
    public String infProt_dhRecbto(int i) {
        return retConsReciNFe.protNFe.get(i).infProt.dhRecbto;
    }

    public String infProt_digVal(int i) {
        return retConsReciNFe.protNFe.get(i).infProt.digVal;
    }

    public String infProt_tpAmb(int i) {
        return retConsReciNFe.protNFe.get(i).infProt.tpAmb;
    }

    public String infProt_verAplic(int i) {
        return retConsReciNFe.protNFe.get(i).infProt.verAplic;
    }

    public String infProt_xMotivo(int i) {
        if (retConsReciNFe.protNFe.get(i).infProt.cStat.equals("999"))
        {
            return "Lote em processamento";
        }
        return retConsReciNFe.protNFe.get(i).infProt.xMotivo;
    }
    
    @XStreamAlias("retConsReciNFe")
    class retConsReciNFe {
        @XStreamAlias("versao")
        String versao;
        @XStreamAlias("tpAmb")
        String tpAmb;
        @XStreamAlias("verAplic")
        String verAplic;
        @XStreamAlias("nRec")
        String nRec;
        @XStreamAlias("cStat")
        String cStat;
        @XStreamAlias("xMotivo")
        String xMotivo;
        @XStreamAlias("cUF")
        String cUF;
        @XStreamImplicit(itemFieldName = "protNFe")
        List<protNFe> protNFe;// = new java.util.ArrayList<protNFe>();
    }

    class protNFe {

        @XStreamAlias("versao")
        String versao;
        @XStreamAlias("infProt")
        public infProt infProt = new infProt();
    }

    class infProt {

        @XStreamAlias("tpAmb")
        public String tpAmb;
        @XStreamAlias("verAplic")
        public String verAplic;
        @XStreamAlias("chNFe")
        public String chNFe;
        
        @XStreamAlias("dhRecbto")
        public String dhRecbto;
        @XStreamAlias("nProt")
        public String nProt;
        @XStreamAlias("digVal")
        public String digVal;
        @XStreamAlias("cStat")
        public String cStat;
        @XStreamAlias("xMotivo")
        public String xMotivo;
    }
}
