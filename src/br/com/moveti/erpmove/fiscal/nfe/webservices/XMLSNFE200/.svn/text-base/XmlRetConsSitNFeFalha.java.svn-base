/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Henrique
 */
public class XmlRetConsSitNFeFalha {

    public static void main(String args[]) {
        XmlRetConsSitNFeFalha XmlRetConsSitNFeFalha = new XmlRetConsSitNFeFalha();

        String NumeroSitbo = "";
        String Retorno = "";

        String S = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>12_5_72</verAplic><cStat>105</cStat><xMotivo>Lote em processamento</xMotivo><cUF>31</cUF><chNFe>31101109029577000109550010000002011317541129</chNFe></retConsSitNFe>";

        XmlRetConsSitNFeFalha.setXML(S);
        XmlRetConsSitNFeFalha.BuscaDadosXML();

    }
    private String XML = "";
    public retConsSitNFe retConsSitNFe = new retConsSitNFe();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retConsSitNFe", retConsSitNFe.class);
        //xstream.alias("protNFe", protNFe.class);
        //xstream.alias("infProt", infProt.class);
        System.out.println(XML);
        retConsSitNFe = (retConsSitNFe) xstream.fromXML(XML);
    }

    public String cStat() {
        return retConsSitNFe.cStat;
    }

    public String cUF() {
        return retConsSitNFe.cUF;
    }

    public String chNFe() {
        return retConsSitNFe.chNFe;
    }

    public protNFe protNFe() {
        return retConsSitNFe.protNFe;
    }

    public retCancNFe retCancNFe() {
        return retConsSitNFe.retCancNFe;
    }

    public String tpAmb() {
        return retConsSitNFe.tpAmb;
    }

    public String verAplic() {
        return retConsSitNFe.verAplic;
    }

    public String xMotivo() {
        return retConsSitNFe.xMotivo;
    }
    ////

    public String infProt_cStat() {
        return retConsSitNFe.protNFe.infProt.cStat;
    }

    public String infProt_chNFe() {
        return retConsSitNFe.protNFe.infProt.chNFe;
    }

    public String infProt_dhRecbto() {
        return retConsSitNFe.protNFe.infProt.dhRecbto;
    }

    public String infProt_digVal() {
        return retConsSitNFe.protNFe.infProt.digVal;
    }

    public String infProt_nProt() {
        return retConsSitNFe.protNFe.infProt.nProt;
    }

    public String infProt_tpAmb() {
        return retConsSitNFe.protNFe.infProt.tpAmb;
    }

    public String infProt_verAplic() {
        return retConsSitNFe.protNFe.infProt.verAplic;
    }

    public String infProt_xMotivo() {
        return retConsSitNFe.protNFe.infProt.xMotivo;
    }
    ////

    public String infCanc_cStat() {
        return retConsSitNFe.retCancNFe.infCanc.cStat;
    }

    public String infCanc_cUF() {
        return retConsSitNFe.retCancNFe.infCanc.cUF;
    }

    public String infCanc_chNFe() {
        return retConsSitNFe.retCancNFe.infCanc.chNFe;
    }

    public String infCanc_dhRecbto() {
        return retConsSitNFe.retCancNFe.infCanc.dhRecbto;
    }

    public String infCanc_nProt() {
        return retConsSitNFe.retCancNFe.infCanc.nProt;
    }

    public String infCanc_tpAmb() {
        return retConsSitNFe.retCancNFe.infCanc.tpAmb;
    }

    public String infCanc_verAplic() {
        return retConsSitNFe.retCancNFe.infCanc.verAplic;
    }

    public String infCanc_xMotivo() {
        return retConsSitNFe.retCancNFe.infCanc.xMotivo;
    }

    class retConsSitNFe {

        String tpAmb;
        String verAplic;
        String cStat;
        String xMotivo;
        String cUF;
        String chNFe;
        protNFe protNFe = new protNFe();
        retCancNFe retCancNFe = new retCancNFe();
    }

    class protNFe {

        public infProt infProt = new infProt();
    }

    class infProt {

        String tpAmb;
        String verAplic;
        String chNFe;
        String dhRecbto;
        String nProt;
        String digVal;
        String cStat;
        String xMotivo;
    }

    class retCancNFe {

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
