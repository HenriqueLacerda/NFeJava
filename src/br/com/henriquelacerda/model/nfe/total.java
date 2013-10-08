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
@XStreamAlias("total")
public class total {

    private ICMSTot ICMSTot;
    private ISSQNtot ISSQNtot;
    private retTrib retTrib;

    public ICMSTot getICMSTot() {
        return ICMSTot;
    }

    public void setICMSTot(ICMSTot ICMSTot) {
        this.ICMSTot = ICMSTot;
    }

    public ISSQNtot getISSQNtot() {
        return ISSQNtot;
    }

    public void setISSQNtot(ISSQNtot ISSQNtot) {
        this.ISSQNtot = ISSQNtot;
    }

    public retTrib getRetTrib() {
        return retTrib;
    }

    public void setRetTrib(retTrib retTrib) {
        this.retTrib = retTrib;
    }
}
