/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class comb {

    private String cProdANP;
    private String CODIF;
    private String qTemp;
    private String UFCons;
    private CIDE CIDE = new CIDE();

    public CIDE getCIDE() {
        return CIDE;
    }

    public void setCIDE(CIDE CIDE) {
        this.CIDE = CIDE;
    }

    public String getCODIF() {
        return CODIF;
    }

    public void setCODIF(String CODIF) {
        this.CODIF = CODIF;
    }

    public String getUFCons() {
        return UFCons;
    }

    public void setUFCons(String UFCons) {
        this.UFCons = UFCons;
    }

    public String getcProdANP() {
        return cProdANP;
    }

    public void setcProdANP(String cProdANP) {
        this.cProdANP = cProdANP;
    }

    public String getqTemp() {
        return qTemp;
    }

    public void setqTemp(String qTemp) {
        this.qTemp = qTemp;
    }
}
