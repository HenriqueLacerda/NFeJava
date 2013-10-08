/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("infCanc")
public class infCanc {

    private String tpAmb;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private String cUF;
    private String chNFe;
    private String dhRecbto;
    private String nProt;

    /**
     * @return the tpAmb
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * @param tpAmb the tpAmb to set
     */
    public void setTpAmb(String tpAmb) {
        this.tpAmb = tpAmb;
    }

    /**
     * @return the verAplic
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * @param verAplic the verAplic to set
     */
    public void setVerAplic(String verAplic) {
        this.verAplic = verAplic;
    }

    /**
     * @return the cStat
     */
    public String getcStat() {
        return cStat;
    }

    /**
     * @param cStat the cStat to set
     */
    public void setcStat(String cStat) {
        this.cStat = cStat;
    }

    /**
     * @return the xMotivo
     */
    public String getxMotivo() {
        return xMotivo;
    }

    /**
     * @param xMotivo the xMotivo to set
     */
    public void setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
    }

    /**
     * @return the cUF
     */
    public String getcUF() {
        return cUF;
    }

    /**
     * @param cUF the cUF to set
     */
    public void setcUF(String cUF) {
        this.cUF = cUF;
    }

    /**
     * @return the chNFe
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * @param chNFe the chNFe to set
     */
    public void setChNFe(String chNFe) {
        this.chNFe = chNFe;
    }

    /**
     * @return the dhRecbto
     */
    public String getDhRecbto() {
        return dhRecbto;
    }

    /**
     * @param dhRecbto the dhRecbto to set
     */
    public void setDhRecbto(String dhRecbto) {
        this.dhRecbto = dhRecbto;
    }

    /**
     * @return the nProt
     */
    public String getnProt() {
        return nProt;
    }

    /**
     * @param nProt the nProt to set
     */
    public void setnProt(String nProt) {
        this.nProt = nProt;
    }
}
