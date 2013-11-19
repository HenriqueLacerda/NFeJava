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
@XStreamAlias("SignatureMethod")
public class SignatureMethod {

    String Algorithm;

    public String getAlgorithm() {
        return Algorithm;
    }

    public void setAlgorithm(String Algorithm) {
        this.Algorithm = Algorithm;
    }
}
