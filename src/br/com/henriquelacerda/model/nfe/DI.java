/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.adi;

/**
 *
 * @author Jéssica
 */
public class DI {

    private String nDI;
    private String dDI;
    private String xLocDesemb;
    private String UFDesemb;
    private String dDesemb;
    private String cExportador;
    private adi adi = new adi();

    public String getnDI() {
        return nDI;
    }

    public void setnDI(String nDI) {
        this.nDI = nDI;
    }

    public String getdDI() {
        return dDI;
    }

    public void setdDI(String dDI) {
        this.dDI = dDI;
    }

    public String getxLocDesemb() {
        return xLocDesemb;
    }

    public void setxLocDesemb(String xLocDesemb) {
        this.xLocDesemb = xLocDesemb;
    }

    public String getUFDesemb() {
        return UFDesemb;
    }

    public void setUFDesemb(String UFDesemb) {
        this.UFDesemb = UFDesemb;
    }

    public String getdDesemb() {
        return dDesemb;
    }

    public void setdDesemb(String dDesemb) {
        this.dDesemb = dDesemb;
    }

    public String getcExportador() {
        return cExportador;
    }

    public void setcExportador(String cExportador) {
        this.cExportador = cExportador;
    }

    public adi getAdi() {
        return adi;
    }

    public void setAdi(adi adi) {
        this.adi = adi;
    }
}
