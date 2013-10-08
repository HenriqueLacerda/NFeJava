/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class ISSQNtot {

    private String vServ;
    private String vBC;
    private String vISS;
    private String vPIS;
    private String vCOFINS;

    public String getvBC() {
        return vBC;
    }

    public void setvBC(String vBC) {
        this.vBC = vBC;
    }

    public String getvCOFINS() {
        return vCOFINS;
    }

    public void setvCOFINS(String vCOFINS) {
        this.vCOFINS = vCOFINS;
    }

    public String getvISS() {
        return vISS;
    }

    public void setvISS(String vISS) {
        this.vISS = vISS;
    }

    public String getvPIS() {
        return vPIS;
    }

    public void setvPIS(String vPIS) {
        this.vPIS = vPIS;
    }

    public String getvServ() {
        return vServ;
    }

    public void setvServ(String vServ) {
        this.vServ = vServ;
    }
}
