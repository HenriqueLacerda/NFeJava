/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

/**
 *
 * @author Henrique
 * 
 */
public class XmlRetConsReciNFeFalha {

    public static void main(String args[]) {
        XmlRetConsReciNFeFalha XmlRetConsReciNFeFalha = new XmlRetConsReciNFeFalha();

        String NumeroRecibo = "";
        String Retorno = "";

        String S = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>12_5_72</verAplic><nRec>310000021153233</nRec><cStat>105</cStat><xMotivo>Lote em processamento</xMotivo><cUF>31</cUF></retConsReciNFe>";
        S = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>13_0_63</verAplic><nRec>310000023939546</nRec><cStat>225</cStat><xMotivo>Rejeicao: Falha no Schema XML do lote de NFe</xMotivo><cUF>31</cUF></retConsReciNFe>";
        S = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>12_5_72</verAplic><nRec>310000021153233</nRec><cStat>105</cStat><xMotivo>Lote em processamento</xMotivo><cUF>31</cUF></retConsReciNFe>";

        XmlRetConsReciNFeFalha.setXML(S);
        XmlRetConsReciNFeFalha.BuscaDadosXML();

        System.out.println(XmlRetConsReciNFeFalha.cStat());
        System.out.println(XmlRetConsReciNFeFalha.xMotivo());
    }
    private String XML = "";
    retConsReciNFe retConsReciNFe;

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retConsReciNFe", retConsReciNFe.class);
        //xstream.alias("protNFe", protNFe.class);
        //xstream.alias("infProt", infProt.class);
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

    public protNFe protNFe() {
        return retConsReciNFe.protNFe;
    }

    public String tpAmb() {
        return retConsReciNFe.tpAmb;
    }

    public String verAplic() {
        return retConsReciNFe.verAplic;
    }

    public String xMotivo() {
        return retConsReciNFe.xMotivo;
    }
    ///
    public String infProt_cStat() {
        return retConsReciNFe.protNFe.infProt.cStat;
    }

    public String infProt_chNFe() {
        return retConsReciNFe.protNFe.infProt.chNFe;
    }

    public String infProt_dhRecbto() {
        return retConsReciNFe.protNFe.infProt.dhRecbto;
    }

    public String infProt_digVal() {
        return retConsReciNFe.protNFe.infProt.digVal;
    }

    public String infProt_tpAmb() {
        return retConsReciNFe.protNFe.infProt.tpAmb;
    }

    public String infProt_verAplic() {
        return retConsReciNFe.protNFe.infProt.verAplic;
    }

    public String infProt_xMotivo() {
        return retConsReciNFe.protNFe.infProt.xMotivo;
    }

    class retConsReciNFe {
        String tpAmb;
        String verAplic;
        String nRec;
        String cStat;
        String xMotivo;
        String cUF;
        protNFe protNFe = new protNFe();
    }

    class protNFe {
        String versao;
        infProt infProt = new infProt();
    }

    class infProt {
        String tpAmb;
        String verAplic;
        String chNFe;
        String dhRecbto;
        String digVal;
        String cStat;
        String xMotivo;
    }
}
