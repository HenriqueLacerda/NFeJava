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
@XStreamAlias("NFe")
public class NFe {

    private Signature Signature;
    private infNFe infNFe;
   
    public infNFe getInfNFe() {
        return infNFe;
    }

    public void setInfNFe(infNFe infNFe) {
        this.infNFe = infNFe;
    }

    public Signature getSignature() {
        return Signature;
    }

    public void setSignature(Signature Signature) {
        this.Signature = Signature;
    }
}
