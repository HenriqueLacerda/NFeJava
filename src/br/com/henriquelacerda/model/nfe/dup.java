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
@XStreamAlias("dup")
public class dup {

    private String nDup;
    private String dVenc;
    private String vDup;

    public String getnDup() {
        return nDup;
    }

    public void setnDup(String nDup) {
        this.nDup = nDup;
    }

    public String getdVenc() {
        return dVenc;
    }

    public void setdVenc(String dVenc) {
        this.dVenc = dVenc;
    }

    public String getvDup() {
        return vDup;
    }

    public void setvDup(String vDup) {
        this.vDup = vDup;
    }
}
