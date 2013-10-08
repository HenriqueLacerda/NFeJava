/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.Reference;
import br.com.moveti.erpmove.fiscal.Xml.SignatureMethod;
import br.com.moveti.erpmove.fiscal.Xml.CanonicalizationMethod;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("SignedInfo")
public class SignedInfo {

    private CanonicalizationMethod CanonicalizationMethod;
    private SignatureMethod SignatureMethod;
    private Reference Reference;

    public CanonicalizationMethod getCanonicalizationMethod() {
        return CanonicalizationMethod;
    }

    public void setCanonicalizationMethod(CanonicalizationMethod CanonicalizationMethod) {
        this.CanonicalizationMethod = CanonicalizationMethod;
    }

    public SignatureMethod getSignatureMethod() {
        return SignatureMethod;
    }

    public void setSignatureMethod(SignatureMethod SignatureMethod) {
        this.SignatureMethod = SignatureMethod;
    }

    public Reference getReference() {
        return Reference;
    }

    public void setReference(Reference Reference) {
        this.Reference = Reference;
    }
}
