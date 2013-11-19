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
@XStreamAlias("ICMS10")
public class ICMS10 {

    private String orig;
    private String CST;
    private String modBC;
    private String vBC;
    private String pICMS;
    private String vICMS;
    private String modBCST;
    private String vBCST;
    private String pICMSST;
    private String vICMSST;
    private String pMVAST;

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getCST() {
        return CST;
    }

    public void setCST(String CST) {
        this.CST = CST;
    }

    public String getModBC() {
        return modBC;
    }

    public void setModBC(String modBC) {
        this.modBC = modBC;
    }

    public String getvBC() {
        return vBC;
    }

    public void setvBC(String vBC) {
        this.vBC = vBC;
    }

    public String getpICMS() {
        return pICMS;
    }

    public void setpICMS(String pICMS) {
        this.pICMS = pICMS;
    }

    public String getvICMS() {
        return vICMS;
    }

    public void setvICMS(String vICMS) {
        this.vICMS = vICMS;
    }

    public String getModBCST() {
        return modBCST;
    }

    public void setModBCST(String modBCST) {
        this.modBCST = modBCST;
    }

    public String getvBCST() {
        return vBCST;
    }

    public void setvBCST(String vBCST) {
        this.vBCST = vBCST;
    }

    public String getpICMSST() {
        return pICMSST;
    }

    public void setpICMSST(String pICMSST) {
        this.pICMSST = pICMSST;
    }

    public String getvICMSST() {
        return vICMSST;
    }

    public void setvICMSST(String vICMSST) {
        this.vICMSST = vICMSST;
    }

    public String getpMVAST() {
        return pMVAST;
    }

    public void setpMVAST(String pMVAST) {
        this.pMVAST = pMVAST;
    }
}
