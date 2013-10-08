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
public class XMLretEnvConfRecebto {

    private String XML = "";
    private retEnvEvento retEnvEvento = new retEnvEvento();

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(retEnvEvento.class);
        xstream.processAnnotations(retEvento.class);
        setRetEnvEvento((retEnvEvento) xstream.fromXML(getXML()));
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }

    public retEnvEvento getRetEnvEvento() {
        return retEnvEvento;
    }

    public void setRetEnvEvento(retEnvEvento retEnvEvento) {
        this.retEnvEvento = retEnvEvento;
    }

    @XStreamAlias("retEnvEvento")
    public class retEnvEvento {

        @XStreamAlias("idLote")
        private String idLote;
        @XStreamAlias("tpAmb")
        private String tpAmb;
        @XStreamAlias("verAplic")
        private String verAplic;
        @XStreamAlias("cOrgao")
        private String cOrgao;
        @XStreamAlias("cStat")
        private String cStat;
        @XStreamAlias("xmotivo")
        private String xmotivo;

        public String getIdLote() {
            return idLote;
        }

        public void setIdLote(String idLote) {
            this.idLote = idLote;
        }

        public String getTpAmb() {
            return tpAmb;
        }

        public void setTpAmb(String tpAmb) {
            this.tpAmb = tpAmb;
        }

        public String getVerAplic() {
            return verAplic;
        }

        public void setVerAplic(String verAplic) {
            this.verAplic = verAplic;
        }

        public String getcOrgao() {
            return cOrgao;
        }

        public void setcOrgao(String cOrgao) {
            this.cOrgao = cOrgao;
        }

        public String getcStat() {
            return cStat;
        }

        public void setcStat(String cStat) {
            this.cStat = cStat;
        }

        public String getXmotivo() {
            return xmotivo;
        }

        public void setXmotivo(String xmotivo) {
            this.xmotivo = xmotivo;
        }
    }

    @XStreamAlias("retEvento")
    public class retEvento {

        @XStreamAlias("versao")
        private String versao;

        public String getVersao() {
            return versao;
        }

        public void setVersao(String versao) {
            this.versao = versao;
        }
    }

    @XStreamAlias("infEvento")
    public class infEvento {

        @XStreamAlias("id")
        private String id;
        @XStreamAlias("tpAmb")
        private String tpAmb;
        @XStreamAlias("verAplic")
        private String verAplic;
        @XStreamAlias("cOrgao")
        private String cOrgao;
        @XStreamAlias("cStat")
        private String cStat;
        @XStreamAlias("xMotivo")
        private String xMotivo;
        @XStreamAlias("chNFe")
        private String chNFe;
        @XStreamAlias("tpEvento")
        private String tpEvento;
        @XStreamAlias("xEvento")
        private String xEvento;
        @XStreamAlias("nSeqEvento")
        private String nSeqEvento;
        @XStreamAlias("CNPJDest")
        private String CNPJDest;
        @XStreamAlias("CPFDest")
        private String CPFDest;
        @XStreamAlias("emailDest")
        private String emailDest;
        @XStreamAlias("dhRegEvento")
        private String dhRegEvento;
        @XStreamAlias("nProt")
        private String nProt;
        @XStreamAlias("Signature")
        private String Signature;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTpAmb() {
            return tpAmb;
        }

        public void setTpAmb(String tpAmb) {
            this.tpAmb = tpAmb;
        }

        public String getVerAplic() {
            return verAplic;
        }

        public void setVerAplic(String verAplic) {
            this.verAplic = verAplic;
        }

        public String getcOrgao() {
            return cOrgao;
        }

        public void setcOrgao(String cOrgao) {
            this.cOrgao = cOrgao;
        }

        public String getcStat() {
            return cStat;
        }

        public void setcStat(String cStat) {
            this.cStat = cStat;
        }

        public String getxMotivo() {
            return xMotivo;
        }

        public void setxMotivo(String xMotivo) {
            this.xMotivo = xMotivo;
        }

        public String getChNFe() {
            return chNFe;
        }

        public void setChNFe(String chNFe) {
            this.chNFe = chNFe;
        }

        public String getTpEvento() {
            return tpEvento;
        }

        public void setTpEvento(String tpEvento) {
            this.tpEvento = tpEvento;
        }

        public String getxEvento() {
            return xEvento;
        }

        public void setxEvento(String xEvento) {
            this.xEvento = xEvento;
        }

        public String getnSeqEvento() {
            return nSeqEvento;
        }

        public void setnSeqEvento(String nSeqEvento) {
            this.nSeqEvento = nSeqEvento;
        }

        public String getCNPJDest() {
            return CNPJDest;
        }

        public void setCNPJDest(String CNPJDest) {
            this.CNPJDest = CNPJDest;
        }

        public String getCPFDest() {
            return CPFDest;
        }

        public void setCPFDest(String CPFDest) {
            this.CPFDest = CPFDest;
        }

        public String getEmailDest() {
            return emailDest;
        }

        public void setEmailDest(String emailDest) {
            this.emailDest = emailDest;
        }

        public String getDhRegEvento() {
            return dhRegEvento;
        }

        public void setDhRegEvento(String dhRegEvento) {
            this.dhRegEvento = dhRegEvento;
        }

        public String getnProt() {
            return nProt;
        }

        public void setnProt(String nProt) {
            this.nProt = nProt;
        }

        public String getSignature() {
            return Signature;
        }

        public void setSignature(String Signature) {
            this.Signature = Signature;
        }
    }
}
