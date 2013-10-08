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
@XStreamAlias("imposto")
public class imposto {

    private ICMS ICMS = new ICMS();
    private IPI IPI = new IPI();
    private II II = new II();
    private PIS PIS = new PIS();
    private PISST PISST = new PISST();
    private COFINS COFINS = new COFINS();
    private COFINSST COFINSST = new COFINSST();
    private ISSQN ISSQN = new ISSQN();

    public ICMS getICMS() {
        return ICMS;
    }

    public void setICMS(ICMS ICMS) {
        this.ICMS = ICMS;
    }

    public IPI getIPI() {
        return IPI;
    }

    public void setIPI(IPI IPI) {
        this.IPI = IPI;
    }

    public II getII() {
        return II;
    }

    public void setII(II II) {
        this.II = II;
    }

    public PIS getPIS() {
        return PIS;
    }

    public void setPIS(PIS PIS) {
        this.PIS = PIS;
    }

    public COFINS getCOFINS() {
        return COFINS;
    }

    public void setCOFINS(COFINS COFINS) {
        this.COFINS = COFINS;
    }

    public COFINSST getCOFINSST() {
        return COFINSST;
    }

    public void setCOFINSST(COFINSST COFINSST) {
        this.COFINSST = COFINSST;
    }

    public PISST getPISST() {
        return PISST;
    }

    public void setPISST(PISST PISST) {
        this.PISST = PISST;
    }

    public ISSQN getISSQN() {
        return ISSQN;
    }

    public void setISSQN(ISSQN ISSQN) {
        this.ISSQN = ISSQN;
    }
}
