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
@XStreamAlias("ICMSSN101")
public class ICMSSN101 {

    private String orig;
    private String CSOSN;
    private String pCredSN;
    private String vCredICMSSN;

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getCSOSN() {
        return CSOSN;
    }

    public void setCSOSN(String CSOSN) {
        this.CSOSN = CSOSN;
    }

    public String getpCredSN() {
        return pCredSN;
    }

    public void setpCredSN(String pCredSN) {
        this.pCredSN = pCredSN;
    }

    public String getvCredICMSSN() {
        return vCredICMSSN;
    }

    public void setvCredICMSSN(String vCredICMSSN) {
        this.vCredICMSSN = vCredICMSSN;
    }
}
