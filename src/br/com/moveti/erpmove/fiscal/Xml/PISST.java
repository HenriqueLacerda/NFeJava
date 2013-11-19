/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author move
 */
@XStreamAlias("PISST")
public class PISST {
    private String vBC;
    private String pPIS;
    private String qBCProd;
    private String vAliqProd;
    private String vPIS;

    public String getpPIS() {
        return pPIS;
    }

    public void setpPIS(String pPIS) {
        this.pPIS = pPIS;
    }

    public String getqBCProd() {
        return qBCProd;
    }

    public void setqBCProd(String qBCProd) {
        this.qBCProd = qBCProd;
    }

    public String getvAliqProd() {
        return vAliqProd;
    }

    public void setvAliqProd(String vAliqProd) {
        this.vAliqProd = vAliqProd;
    }

    public String getvBC() {
        return vBC;
    }

    public void setvBC(String vBC) {
        this.vBC = vBC;
    }

    public String getvPIS() {
        return vPIS;
    }

    public void setvPIS(String vPIS) {
        this.vPIS = vPIS;
    }
}
