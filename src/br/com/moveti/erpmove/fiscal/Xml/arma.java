/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class arma {

    private String tpArma;
    private String nSerie;
    private String nCano;
    private String descr;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getnCano() {
        return nCano;
    }

    public void setnCano(String nCano) {
        this.nCano = nCano;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getTpArma() {
        return tpArma;
    }

    public void setTpArma(String tpArma) {
        this.tpArma = tpArma;
    }
}
