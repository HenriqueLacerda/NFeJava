/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.infProt;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("protNFe")
public class protNFe {
    private infProt infProt;

    public infProt getInfProt() {
        return infProt;
    }

    public void setInfProt(infProt infProt) {
        this.infProt = infProt;
    }
}
