/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import java.util.List;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSEVENTOS.retEvento;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 *
 * @author Henrique
 */
public class XmlRetConsSitNFeEvento {

    public static void main(String args[]) {
        XmlRetConsSitNFeEvento TratamentoRetorno = new XmlRetConsSitNFeEvento();

        String NumeroRecibo = "";
        String Retorno = "";

        String T = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>0674</verAplic><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo><cUF>31</cUF><chNFe>31101109029577000109550010000002011317541129</chNFe><protNFe versao=\"2.00\"><infProt Id=\"ID131100023069448\"><tpAmb>2</tpAmb><verAplic>0674</verAplic><chNFe>31101109029577000109550010000002011317541129</chNFe><dhRecbto>2010-12-06T11:53:27</dhRecbto><nProt>131100023069448</nProt><digVal>xgrEPDrJQZzgaGSWoAuBcVuoQ2w=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe><retCancNFe versao=\"2.00\"><infCanc><tpAmb>2</tpAmb><verAplic>0674</verAplic><cStat>101</cStat><xMotivo>Cancelamento de NF-e homologado</xMotivo><cUF>31</cUF><chNFe>31101109029577000109550010000002011317541129</chNFe><dhRecbto>2010-12-09T10:07:29</dhRecbto><nProt>131100023120975</nProt></infCanc></retCancNFe></retConsSitNFe>";
        T = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.01\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>13_0_94</verAplic>"
                + "<cStat>100</cStat>"
                + "<xMotivo>Autorizado o uso da NF-e</xMotivo>"
                + "<cUF>31</cUF>"
                + "<chNFe>31130709029577000109550010000043661384782828</chNFe>"
                    + "<protNFe versao=\"2.00\">"
                        + "<infProt Id=\"ID131130034791738\">"
                        + "<tpAmb>2</tpAmb>"
                        + "<verAplic>13_0_94</verAplic>"
                        + "<chNFe>31130709029577000109550010000043661384782828</chNFe>"
                        + "<dhRecbto>2013-07-11T11:27:29</dhRecbto>"
                        + "<nProt>131130034791738</nProt>"
                        + "<digVal>N38TOFMndWRPSD7/PE9eM0yKUTc=</digVal>"
                        + "<cStat>100</cStat>"
                        + "<xMotivo>Autorizado o uso da NF-e</xMotivo>"
                        + "</infProt>"
                    + "</protNFe>"
                + "<procEventoNFe versao=\"1.00\">"
                    + "<evento versao=\"1.00\">"
                        + "<infEvento Id=\"ID1101103113070902957700010955001000004366138478282801\">"
                
                            + "<cOrgao>31</cOrgao>"
                            + "<tpAmb>2</tpAmb>"
                            + "<CNPJ>09029577000109</CNPJ>"
                            + "<chNFe>31130709029577000109550010000043661384782828</chNFe>"
                            + "<dhEvento>2013-07-11T11:27:49-03:00</dhEvento>"
                            + "<tpEvento>110110</tpEvento>"
                            + "<nSeqEvento>1</nSeqEvento>"
                            + "<verEvento>1.00</verEvento>"
                            + "<detEvento versao=\"1.00\">"
                                + "<descEvento>Carta de Correcao</descEvento>"
                                + "<xCorrecao>TESTE DE CARTA DE CORRECAO DE NOTA FISCAL</xCorrecao>"
                                + "<xCondUso>A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.</xCondUso>"
                            + "</detEvento>"
                        + "</infEvento>"
                        + "<Signature:Signature xmlns:Signature=\"http://www.w3.org/2000/09/xmldsig#\" xmlns=\"http://www.w3.org/2000/09/xmldsig#\">"
                        + "<SignedInfo>"
                        + "<CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"></CanonicalizationMethod>"
                        + "<SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"></SignatureMethod>"
                        + "<Reference URI=\"#ID1101103113070902957700010955001000004366138478282801\">"
                        + "<Transforms>"
                        + "<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"></Transform>"
                        + "<Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"></Transform>"
                        + "</Transforms>"
                        + "<DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"></DigestMethod>"
                        + "<DigestValue>Y0zzlHXeqytCHEsWl9eLE6hzPTM=</DigestValue>"
                        + "</Reference>"
                        + "</SignedInfo>"
                        + "<SignatureValue>ubEuh0YS/SddJk7OghTkrUnc5hHt2CQXJhkMC+hQkMy+lMJSuW/6C95gBxmLZg4kJRtGOQMW/mY+"
                        + "nhhQcInmcIO71i8w13kzjIF6caR8PSrGgAnGcGimJaHQeF889wigujWZymU9zx5O6Q5t4ebsb8"
                        + "OnrseUHf3QWYauO42Zio7J8or7P+M4rUfgnKRE+Em9+cGlzdRhPMDMKZRkUcYk5000is510Azh85"
                        + "Mg6TxYYAvP6WycUzzLiMqRHlPMkWwBcNd/ZzmT13MOGR+nunnSDNHXd2cKEaeQSyB5ffAf83XNgU"
                        + "YwYLL0TU6DyBR5RN1utW1LmSZnidQHyuLJzf/w==</SignatureValue>"
                        + "<KeyInfo>"
                        + "<X509Data>"
                        + "<X509Certificate>MIIIMTCCBhmgAwIBAgIQK9HUrZls0OvO2UBLzpcC5zANBgkqhkiG9w0BAQsFADB3MQswCQYDVQQG"
                        + "EwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBSZWNlaXRh"
                        + "EZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRswGQYDVQQDExJBQyBQUk9ERU1HRSBSRkIgRzMwHhcN"
                        + "MTMwMzEzMDAwMDAwWhcNMTUwMzExMjM1OTU5WjCB9DELMAkGA1UEBhMCQlIxEzARBgNVBAoUCklD"
                        + "C1CcmFzaWwxCzAJBgNVBAgTAk1HMR8wHQYDVQQHFBZTQU5UTyBBTlRPTklPIERPIE1PTlRFMTYw"
                        + "NAYDVQQLFC1TZWNyZXRhcmlhIGRhIFJlY2VpdGEgRmVkZXJhbCBkbyBCcmFzaWwgLSBSRkIxFjAU"
                        + "BgNVBAsUDVJGQiBlLUNOUEogQTMxITAfBgNVBAsUGEF1dGVudGljYWRvIHBvciBQUk9ERU1HRTEv"
                        + "gwh2ho+RAkWdplEiYCKCWAc/xxxfGara+gHoK4O7RzLPdDN6suP9PxGttfifMGRICQ==</X509Certificate>"
                        + "</X509Data>"
                        + "</KeyInfo>"
                        + "</Signature:Signature>"
                    + "</evento>"
                    + "<retEvento versao=\"1.00\">"
                        + "<infEvento Id=\"ID131130034791745\">"
                            + "<tpAmb>2</tpAmb>"
                            + "<verAplic>13_0_94</verAplic>"
                            + "<cOrgao>31</cOrgao>"
                            + "<cStat>135</cStat>"
                            + "<xMotivo>Evento registrado e vinculado a NF-e.</xMotivo>"
                            + "<chNFe>31130709029577000109550010000043661384782828</chNFe>"
                            + "<tpEvento>110110</tpEvento>"
                            + "<xEvento>CARTA DE CORRECAO</xEvento>"
                            + "<nSeqEvento>1</nSeqEvento>"
                            + "<CPFDest>09736314650</CPFDest>"
                            + "<dhRegEvento>2013-07-11T11:27:56-03:00</dhRegEvento>"
                            + "<nProt>131130034791745</nProt>"
                        + "</infEvento>"
                    + "</retEvento>"
                + "</procEventoNFe>"
                + "</retConsSitNFe>";
        T = T.replace("Signature:Signature", "Signature");

        TratamentoRetorno.setXML(T);
        TratamentoRetorno.BuscaDadosXML();

    }
    private String XML = "";
    private retConsSitNFe retConsSitNFe = new retConsSitNFe();

    public void setXML(String xml) {
        // FIXME 
        // 
        this.XML = xml.replace("Signature:Signature", "Signature");
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());

        xstream.processAnnotations(retConsSitNFe.class);
        xstream.processAnnotations(protNFe.class);
        xstream.processAnnotations(procEventoNFe.class);
        xstream.processAnnotations(evento.class);
        xstream.processAnnotations(detEvento.class);
        xstream.processAnnotations(infEvento.class);
        xstream.processAnnotations(retEvento.class);
        xstream.processAnnotations(Signature.class);
        xstream.processAnnotations(CanonicalizationMethod.class);
        xstream.processAnnotations(SignatureMethod.class);


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

//    public retCancNFe getRetCancNFe() {
//        return retConsSitNFe.retCancNFe;
//    }
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

//    public String infProt_cStat() {
//        return retConsSitNFe.protNFe.infProt.cStat;
//    }
//
//    public String infProt_chNFe() {
//        return retConsSitNFe.protNFe.infProt.chNFe;
//    }
//
//    public String infProt_dhRecbto() {
//        return retConsSitNFe.protNFe.infProt.dhRecbto;
//    }
//
//    public String infProt_digVal() {
//        return retConsSitNFe.protNFe.infProt.digVal;
//    }
//
//    public String infProt_nProt() {
//        return retConsSitNFe.protNFe.infProt.nProt;
//    }
//
//    public String infProt_tpAmb() {
//        return retConsSitNFe.protNFe.infProt.tpAmb;
//    }
//
//    public String infProt_verAplic() {
//        return retConsSitNFe.protNFe.infProt.verAplic;
//    }
//
//    public String infProt_xMotivo() {
//        return retConsSitNFe.protNFe.infProt.xMotivo;
//    }
//    ////
//
//    public String infCanc_cStat() {
//        return retConsSitNFe.retCancNFe.infCanc.cStat;
//    }
//
//    public String infCanc_cUF() {
//        return retConsSitNFe.retCancNFe.infCanc.cUF;
//    }
//
//    public String infCanc_chNFe() {
//        return retConsSitNFe.retCancNFe.infCanc.chNFe;
//    }
//
//    public String infCanc_dhRecbto() {
//        return retConsSitNFe.retCancNFe.infCanc.dhRecbto;
//    }
//
//    public String infCanc_nProt() {
//        return retConsSitNFe.retCancNFe.infCanc.nProt;
//    }
//
//    public String infCanc_tpAmb() {
//        return retConsSitNFe.retCancNFe.infCanc.tpAmb;
//    }
//
//    public String infCanc_verAplic() {
//        return retConsSitNFe.retCancNFe.infCanc.verAplic;
//    }
//
//    public String infCanc_xMotivo() {
//        return retConsSitNFe.retCancNFe.infCanc.xMotivo;
//    }
    public List<procEventoNFe> getProcEventoNFe() {
        return retConsSitNFe.procEventoNFe;
    }

    public String procEventoNFe_retEvento_tpAmb(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getTpAmb();
    }

    public String procEventoNFe_retEvento_verAplic(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getVerAplic();
    }

    public String procEventoNFe_retEvento_cOrgao(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getcOrgao();
    }

    public String procEventoNFe_retEvento_cStat(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getcStat();
    }

    public String procEventoNFe_retEvento_xMotivo(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getxMotivo();
    }

    public String procEventoNFe_retEvento_chNFe(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getChNFe();
    }

    public String procEventoNFe_retEvento_tpEvento(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getTpEvento();
    }

    public String procEventoNFe_retEvento_xEvento(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getxEvento();
    }

    public String procEventoNFe_retEvento_nSeqEvento(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getnSeqEvento();
    }

    public String procEventoNFe_retEvento_CNPJDest(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getCNPJDest();
    }

    public String procEventoNFe_retEvento_CPFDest(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getCPFDest();
    }

    public String procEventoNFe_retEvento_dhRegEvento(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getDhRegEvento();
    }

    public String procEventoNFe_retEvento_nProt(int i) {
        return retConsSitNFe.procEventoNFe.get(i).retEvento.getnProt();
    }

    @XStreamAlias("retConsSitNFe")
    class retConsSitNFe {

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
        @XStreamAlias("chNFe")
        String chNFe;
        @XStreamAlias("protNFe")
        protNFe protNFe = new protNFe();
        @XStreamAlias("procEventoNFe")
        @XStreamImplicit(itemFieldName = "procEventoNFe")
        public List<procEventoNFe> procEventoNFe = new java.util.ArrayList<procEventoNFe>();
        //retCancNFe retCancNFe = new retCancNFe();
    }

    @XStreamAlias("retConsReciNFe")
    public class retConsReciNFe {

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
        @XStreamAlias("protNFe")
        protNFe protNFe;
        //
    }

    class protNFe {

        @XStreamAlias("infProt")
        public infProt infProt = new infProt();
    }

    public class procEventoNFe {

        @XStreamAlias("versao")
        String versao;
        @XStreamAlias("evento")
        evento evento;
        @XStreamAlias("retEvento")
        public retEvento retEvento;
    }

    class evento {

        @XStreamAlias("versao")
        String versao;
        @XStreamAlias("infEvento")
        infEvento infEvento;
        @XStreamAlias("Signature")
        Signature Signature;
    }

    
    class Signature {

        @XStreamAlias("SignedInfo")
        SignedInfo SignedInfo;
        @XStreamAlias("SignatureValue")
        String SignatureValue;
        @XStreamAlias("KeyInfo")
        KeyInfo KeyInfo;
//                + "<SignedInfo>"
//                + "<CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />"
//                + "<SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\" />"
//                + "<Reference URI=\"#ID1101113113040902957700010955001000010532108782275001\">"
//                + "<Transforms>"
//                + "<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" />"
//                + "<Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\" />"
//                + "</Transforms>"
//                + "<DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\" />"
//                + "<DigestValue>HXYG3IFKPXuDEHkB2nXZW4tsHi8=</DigestValue>"
//                + "</Reference>"
//                + "</SignedInfo>"
//                
//                + "<SignatureValue>weufHgwH1DZ9rKw5r/vDrxKiC2GBfhc1L1WOVkyIEKn2tBN45LSZVUSPqCvGueu54pddZV3xNrX65mzF1nRr40HHRB9/Kpz2q90K4LXzsPVXyfqe5FzU/RggmS7MQjtdzAnvwq0sP55FC0iOphrXPpmRRPzwRG4/fpiSiYQQK/9kZL8Up1+2n2a+gZOiZqJ20mzAs9DrEyfCIUBJ7MwydVAzaPMn69b/6UULctlghtaSTyXpgBwmhilwcqBP00Gcw8FyuejISYc/PSritCFYbktjGWwVHOUOhwXwx2jYM+Ym0a8bfMCmYGA9IQeEp6by8ioQYaOD9NcU/8Yo4zoGYg==</SignatureValue>"
//                + "<KeyInfo>"
//                + "<X509Data>"
//                + "<X509Certificate>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</X509Certificate>"
//                + "</X509Data>"
//                + "</KeyInfo>"
//                + "</Signature>"
    }

    class SignedInfo {

        @XStreamAlias("CanonicalizationMethod")
        CanonicalizationMethod CanonicalizationMethod;
        @XStreamAlias("SignatureMethod")
        SignatureMethod SignatureMethod;
        @XStreamAlias("Reference")
        Reference Reference;
    }

    class CanonicalizationMethod {

        @XStreamAlias("Algorithm")
        String Algorithm;
    }

    class SignatureMethod {

        @XStreamAlias("Algorithm")
        String Algorithm;
    }

    class Reference {

        @XStreamAlias("Transforms")
        Transforms Transforms;
        @XStreamAlias("DigestMethod")
        DigestMethod DigestMethod;
        @XStreamAlias("DigestValue")
        String DigestValue;
    }

    class DigestMethod {

        @XStreamAlias("Algorithm")
        String Algorithm;
    }

    class Transforms {

        @XStreamImplicit(itemFieldName = "Transform")
        List<Transform> Transform = new java.util.ArrayList<Transform>();
    }

    class Transform {

        @XStreamAlias("Algorithm")
        String Algorithm;
    }

    class KeyInfo {

        @XStreamAlias("X509Data")
        X509Data X509Data;
    }

    class X509Data {

        @XStreamAlias("X509Certificate")
        String X509Certificate;
    }

    class infEvento {

        
        @XStreamAlias("Id")
        String Id;
        @XStreamAlias("cOrgao")
        String cOrgao;
        @XStreamAlias("tpAmb")
        String tpAmb;
        @XStreamAlias("CNPJ")
        String CNPJ;
        @XStreamAlias("chNFe")
        String chNFe;
        @XStreamAlias("dhEvento")
        String dhEvento;
        @XStreamAlias("tpEvento")
        String tpEvento;
        @XStreamAlias("nSeqEvento")
        String nSeqEvento;
        @XStreamAlias("CPFDest")
        String CPFDest;
        @XStreamAlias("verEvento")
        String verEvento;
        @XStreamAlias("detEvento")
        detEvento detEvento;
    }

    class detEvento {

        @XStreamAlias("descEvento")
        String descEvento;
        @XStreamAlias("xCorrecao")
        String xCorrecao;
        @XStreamAlias("xCondUso")
        String xCondUso;
        @XStreamAlias("nProt")
        String nProt;
        @XStreamAlias("xJust")
        String xJust;
    }

    class infProt {

        @XStreamAlias("tpAmb")
        String tpAmb;
        @XStreamAlias("verAplic")
        String verAplic;
        @XStreamAlias("chNFe")
        String chNFe;
        @XStreamAlias("dhRecbto")
        String dhRecbto;
        @XStreamAlias("nProt")
        String nProt;
        @XStreamAlias("digVal")
        String digVal;
        @XStreamAlias("cStat")
        String cStat;
        @XStreamAlias("xMotivo")
        String xMotivo;
    }
}
