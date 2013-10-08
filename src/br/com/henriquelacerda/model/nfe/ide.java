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
@XStreamAlias("ide")
public class ide {

    private String cUF;
    private String cNF;
    private String natOp;
    private String indPag;
    private String mod;
    private String serie;
    private String nNF;
    private String dEmi;
    private String dSaiEnt;
    private String hSaiEnt;
    private String tpNF;
    private String cMunFG;
    private NFref NFref;
    private String tpImp;
    private String tpEmis;
    private String cDV;
    private String tpAmb;
    private String finNFe;
    private String procEmi;
    private String verProc;
    private String dhCont;
    private String xJust;

    public String getcUF() {
        return cUF;
    }

    public void setcUF(String cUF) {
        this.cUF = cUF;
    }

    public String getcNF() {
        return cNF;
    }

    public void setcNF(String cNF) {
        this.cNF = cNF;
    }

    public String getNatOp() {
        return natOp;
    }

    public void setNatOp(String natOp) {
        this.natOp = natOp;
    }

    public String getIndPag() {
        return indPag;
    }

    public void setIndPag(String indPag) {
        this.indPag = indPag;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getnNF() {
        return nNF;
    }

    public void setnNF(String nNF) {
        this.nNF = nNF;
    }

    public String getdEmi() {
        return dEmi;
    }

    public void setdEmi(String dEmi) {
        this.dEmi = dEmi;
    }

    public String getdSaiEnt() {
        return dSaiEnt;
    }

    public void setdSaiEnt(String dSaiEnt) {
        this.dSaiEnt = dSaiEnt;
    }

    public String gethSaiEnt() {
        return hSaiEnt;
    }

    public void sethSaiEnt(String hSaiEnt) {
        this.hSaiEnt = hSaiEnt;
    }

    public String getTpNF() {
        return tpNF;
    }

    public void setTpNF(String tpNF) {
        this.tpNF = tpNF;
    }

    public String getcMunFG() {
        return cMunFG;
    }

    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    public String getTpImp() {
        return tpImp;
    }

    public void setTpImp(String tpImp) {
        this.tpImp = tpImp;
    }

    public String getTpEmis() {
        return tpEmis;
    }

    public void setTpEmis(String tpEmis) {
        this.tpEmis = tpEmis;
    }

    public String getcDV() {
        return cDV;
    }

    public void setcDV(String cDV) {
        this.cDV = cDV;
    }

    public String getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(String tpAmb) {
        this.tpAmb = tpAmb;
    }

    public String getFinNFe() {
        return finNFe;
    }

    public void setFinNFe(String finNFe) {
        this.finNFe = finNFe;
    }

    public String getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(String procEmi) {
        this.procEmi = procEmi;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    public NFref getNFref() {
        return NFref;
    }

    public void setNFref(NFref NFref) {
        this.NFref = NFref;
    }

    public String getDhCont() {
        return dhCont;
    }

    public void setDhCont(String dhCont) {
        this.dhCont = dhCont;
    }

    public String getxJust() {
        return xJust;
    }

    public void setxJust(String xJust) {
        this.xJust = xJust;
    }
}
