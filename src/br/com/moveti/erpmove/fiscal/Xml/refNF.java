/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class refNF {

    private String cUF;
    private String AAMM;
    private String CNPJ;
    private String mod;
    private String serie;
    private String nNF;

    public String getAAMM() {
        return AAMM;
    }

    public void setAAMM(String AAMM) {
        this.AAMM = AAMM;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getcUF() {
        return cUF;
    }

    public void setcUF(String cUF) {
        this.cUF = cUF;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getnNF() {
        return nNF;
    }

    public void setnNF(String nNF) {
        this.nNF = nNF;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
