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
public class XmlRetConsSitNFeCancelamento {

    public static void main(String args[]) {
        XmlRetConsSitNFeCancelamento TratamentoRetorno = new XmlRetConsSitNFeCancelamento();

        String NumeroRecibo = "";
        String Retorno = "";

        String T = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>0674</verAplic><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo><cUF>31</cUF><chNFe>31101109029577000109550010000002011317541129</chNFe><protNFe versao=\"2.00\"><infProt Id=\"ID131100023069448\"><tpAmb>2</tpAmb><verAplic>0674</verAplic><chNFe>31101109029577000109550010000002011317541129</chNFe><dhRecbto>2010-12-06T11:53:27</dhRecbto><nProt>131100023069448</nProt><digVal>xgrEPDrJQZzgaGSWoAuBcVuoQ2w=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe><retCancNFe versao=\"2.00\"><infCanc><tpAmb>2</tpAmb><verAplic>0674</verAplic><cStat>101</cStat><xMotivo>Cancelamento de NF-e homologado</xMotivo><cUF>31</cUF><chNFe>31101109029577000109550010000002011317541129</chNFe><dhRecbto>2010-12-09T10:07:29</dhRecbto><nProt>131100023120975</nProt></infCanc></retCancNFe></retConsSitNFe>";

        TratamentoRetorno.setXML(T);
        TratamentoRetorno.BuscaDadosXML();

    }
    private String XML = "";
    private retConsSitNFe retConsSitNFe = new retConsSitNFe();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("retConsSitNFe", retConsSitNFe.class);
        //xstream.alias("protNFe", protNFe.class);
        //xstream.alias("infProt", infProt.class);

        xstream.alias("retCancNFe", retCancNFe.class);
        xstream.alias("infCanc", infCanc.class);

        System.out.println(XML);
        retConsSitNFe = (retConsSitNFe) xstream.fromXML(XML);
    }

    public String getcStat() {
        return retConsSitNFe.cStat;
    }

    public String getcUF() {
        return retConsSitNFe.cUF;
    }

    public String getChNFe() {
        return retConsSitNFe.chNFe;
    }

    public protNFe getProtNFe() {
        return retConsSitNFe.protNFe;
    }

    public retCancNFe getRetCancNFe() {
        return retConsSitNFe.retCancNFe;
    }

    public String getTpAmb() {
        return retConsSitNFe.tpAmb;
    }

    public String getVerAplic() {
        return retConsSitNFe.verAplic;
    }

    public String getxMotivo() {
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

    public class retConsReciNFe {

        String versao;
        String tpAmb;
        String verAplic;
        String nRec;
        String cStat;
        String xMotivo;
        String cUF;
        protNFe protNFe;
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
