/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSEVENTOS;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Jéssica
 */
public class XMLretDownloadNFe {

    private String XML = "";
    retDownloadNfe retDownloadNfe = new retDownloadNfe();

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(retDownloadNfe.class);
        xstream.processAnnotations(retNFe.class);
        retDownloadNfe = (retDownloadNfe) xstream.fromXML(XML);
    }

    @XStreamAlias("retDownloadNfe")
    public class retDownloadNfe {

        @XStreamAlias("versao")
        private String versao;
        @XStreamAlias("tpAmb")
        private String tpAmb;
        @XStreamAlias("verAplic")
        private String verAplic;
        @XStreamAlias("cStat")
        private String cStat;
        @XStreamAlias("xMotivo")
        private String xMotivo;
        @XStreamAlias("dhResp")
        private String dhResp;
        retNFe retNFe = new retNFe();
    }

    @XStreamAlias("retNFe")
    public class retNFe {

        @XStreamAlias("chNFe")
        private String chNFe;
        @XStreamAlias("cStat")
        private String cStat;
        @XStreamAlias("xMotivo")
        private String xMotivo;
        @XStreamAlias("procNFeZip")
        private String procNFeZip;
        @XStreamAlias("procNFeGrupoZip")
        private String procNFeGrupoZip;
        @XStreamAlias("NFeZip")
        private String NFeZip;
        @XStreamAlias("protNFeZip")
        private String protNFeZip;
    }

    public String getVersao() {
        return retDownloadNfe.versao;
    }

    public void setVersao(String versao) {
        this.retDownloadNfe.versao = versao;
    }

    public String getTpAmb() {
        return retDownloadNfe.tpAmb;
    }

    public void setTpAmb(String tpAmb) {
        this.retDownloadNfe.tpAmb = tpAmb;
    }

    public String getVerAplic() {
        return retDownloadNfe.verAplic;
    }

    public void setVerAplic(String verAplic) {
        this.retDownloadNfe.verAplic = verAplic;
    }

    public String getcStat() {
        return retDownloadNfe.cStat;
    }

    public void setcStat(String cStat) {
        this.retDownloadNfe.cStat = cStat;
    }

    public String getxMotivo() {
        return retDownloadNfe.xMotivo;
    }

    public void setxMotivo(String xMotivo) {
        this.retDownloadNfe.xMotivo = xMotivo;
    }

    public String getDhResp() {
        return retDownloadNfe.dhResp;
    }

    public void setDhResp(String dhResp) {
        this.retDownloadNfe.dhResp = dhResp;
    }

    public String getChNFe() {
        return retDownloadNfe.retNFe.chNFe;
    }

    public void setChNFe(String chNFe) {
        this.retDownloadNfe.retNFe.chNFe = chNFe;
    }

    public String getretNfecStat() {
        return retDownloadNfe.retNFe.cStat;
    }

    public void setretNfecStat(String cStat) {
        this.retDownloadNfe.retNFe.cStat = cStat;
    }

    public String getretNfexMotivo() {
        return retDownloadNfe.retNFe.xMotivo;
    }

    public void setretNfexMotivo(String xMotivo) {
        this.retDownloadNfe.retNFe.xMotivo = xMotivo;
    }

    public String getProcNFeZip() {
        return retDownloadNfe.retNFe.procNFeZip;
    }

    public void setProcNFeZip(String procNFeZip) {
        this.retDownloadNfe.retNFe.procNFeZip = procNFeZip;
    }

    public String getProcNFeGrupoZip() {
        return retDownloadNfe.retNFe.procNFeGrupoZip;
    }

    public void setProcNFeGrupoZip(String procNFeGrupoZip) {
        this.retDownloadNfe.retNFe.procNFeGrupoZip = procNFeGrupoZip;
    }

    public String getNFeZip() {
        return retDownloadNfe.retNFe.NFeZip;
    }

    public void setNFeZip(String NFeZip) {
        this.retDownloadNfe.retNFe.NFeZip = NFeZip;
    }

    public String getProtNFeZip() {
        return retDownloadNfe.retNFe.protNFeZip;
    }

    public void setProtNFeZip(String protNFeZip) {
        this.retDownloadNfe.retNFe.protNFeZip = protNFeZip;
    }
}
