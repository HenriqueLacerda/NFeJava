/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.vol;
import br.com.moveti.erpmove.fiscal.Xml.transporta;
import br.com.moveti.erpmove.fiscal.Xml.veicTransp;
import br.com.moveti.erpmove.fiscal.Xml.reboque;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("transp")
public class transp {

    private String modFrete;
    public transporta transporta = new transporta();
    private retTransp retTransp = new retTransp();
    private veicTransp veicTransp = new veicTransp();
    private reboque reboque = new reboque();
    private vol vol = new vol();

    public String getModFrete() {
        return modFrete;
    }

    public void setModFrete(String modFrete) {
        this.modFrete = modFrete;
    }

    public transporta getTransporta() {
        return transporta;
    }

    public void setTransporta(transporta transporta) {
        this.transporta = transporta;
    }

    public veicTransp getVeicTransp() {
        return veicTransp;
    }

    public void setVeicTransp(veicTransp veicTransp) {
        this.veicTransp = veicTransp;
    }

    public reboque getReboque() {
        return reboque;
    }

    public void setReboque(reboque reboque) {
        this.reboque = reboque;
    }

    public vol getVol() {
        return vol;
    }

    public void setVol(vol vol) {
        this.vol = vol;
    }
}
