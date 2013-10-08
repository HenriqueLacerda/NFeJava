/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.prod;
import br.com.moveti.erpmove.fiscal.Xml.imposto;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("det")
public class det {

    private String nItem;
    private prod prod = new prod();
    private imposto imposto = new imposto();
    private infAdProd infAdProd = new infAdProd();

    public infAdProd getInfAdProd() {
        return infAdProd;
    }

    public void setInfAdProd(infAdProd infAdProd) {
        this.infAdProd = infAdProd;
    }

    public String getnItem() {
        return nItem;
    }

    public void setnItem(String nItem) {
        this.nItem = nItem;
    }

    public prod getProd() {
        return prod;
    }

    public void setProd(prod prod) {
        this.prod = prod;
    }

    public imposto getImposto() {
        return imposto;
    }

    public void setImposto(imposto imposto) {
        this.imposto = imposto;
    }
}
