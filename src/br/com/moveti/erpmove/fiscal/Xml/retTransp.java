/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class retTransp {

    private String vServ;
    private String vBCRet;
    private String pICMSRet;
    private String vICMSRet;
    private String CFOP;
    private String cMunFG;

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getcMunFG() {
        return cMunFG;
    }

    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    public String getpICMSRet() {
        return pICMSRet;
    }

    public void setpICMSRet(String pICMSRet) {
        this.pICMSRet = pICMSRet;
    }

    public String getvBCRet() {
        return vBCRet;
    }

    public void setvBCRet(String vBCRet) {
        this.vBCRet = vBCRet;
    }

    public String getvICMSRet() {
        return vICMSRet;
    }

    public void setvICMSRet(String vICMSRet) {
        this.vICMSRet = vICMSRet;
    }

    public String getvServ() {
        return vServ;
    }

    public void setvServ(String vServ) {
        this.vServ = vServ;
    }
}
