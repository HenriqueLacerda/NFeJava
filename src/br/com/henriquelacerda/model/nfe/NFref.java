/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class NFref {

    private String refNFe;
    private refNF refNF;
    private refNFP refNFP;
    private refECF refECF;

    public refECF getRefECF() {
        return refECF;
    }

    public void setRefECF(refECF refECF) {
        this.refECF = refECF;
    }

    public refNF getRefNF() {
        return refNF;
    }

    public void setRefNF(refNF refNF) {
        this.refNF = refNF;
    }

    public refNFP getRefNFP() {
        return refNFP;
    }

    public void setRefNFP(refNFP refNFP) {
        this.refNFP = refNFP;
    }

    public String getRefNFe() {
        return refNFe;
    }

    public void setRefNFe(String refNFe) {
        this.refNFe = refNFe;
    }
}
