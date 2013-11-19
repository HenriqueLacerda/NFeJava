/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.KeyInfo;
import br.com.moveti.erpmove.fiscal.Xml.SignedInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jéssica
 */
@XStreamAlias("Signature")
public class Signature {

    private String xmlns;
    private SignedInfo SignedInfo;
    private String SignatureValue;
    private KeyInfo KeyInfo;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getSignatureValue() {
        return SignatureValue;
    }

    public void setSignatureValue(String SignatureValue) {
        this.SignatureValue = SignatureValue;
    }

    public KeyInfo getKeyInfo() {
        return KeyInfo;
    }

    public void setKeyInfo(KeyInfo KeyInfo) {
        this.KeyInfo = KeyInfo;
    }

    public SignedInfo getSignedInfo() {
        return SignedInfo;
    }

    public void setSignedInfo(SignedInfo SignedInfo) {
        this.SignedInfo = SignedInfo;
    }
   
}
