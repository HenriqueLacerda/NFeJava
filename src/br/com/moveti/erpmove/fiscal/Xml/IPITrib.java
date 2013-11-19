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
@XStreamAlias("IPITrib")
public class IPITrib {

    private String CST;
    private String vBC;
    private String pIPI;
    private String qUnid;
    private String vUnid;
    private String vIPI;

    public String getCST() {
        return CST;
    }

    public void setCST(String CST) {
        this.CST = CST;
    }

    public String getvBC() {
        return vBC;
    }

    public void setvBC(String vBC) {
        this.vBC = vBC;
    }

    public String getpIPI() {
        return pIPI;
    }

    public void setpIPI(String pIPI) {
        this.pIPI = pIPI;
    }

    public String getvIPI() {
        return vIPI;
    }

    public void setvIPI(String vIPI) {
        this.vIPI = vIPI;
    }

    public String getqUnid() {
        return qUnid;
    }

    public void setqUnid(String qUnid) {
        this.qUnid = qUnid;
    }

    public String getvUnid() {
        return vUnid;
    }

    public void setvUnid(String vUnid) {
        this.vUnid = vUnid;
    }
}
