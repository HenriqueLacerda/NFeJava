/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.DigestMethod;
import br.com.moveti.erpmove.fiscal.Xml.Transforms;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("Reference")
public class Reference {

    private String URI;
    private Transforms Transforms;
    private DigestMethod DigestMethod;
    private String DigestValue;

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public Transforms getTransforms() {
        return Transforms;
    }

    public void setTransforms(Transforms Transforms) {
        this.Transforms = Transforms;
    }

    public DigestMethod getDigestMethod() {
        return DigestMethod;
    }

    public void setDigestMethod(DigestMethod DigestMethod) {
        this.DigestMethod = DigestMethod;
    }

    public String getDigestValue() {
        return DigestValue;
    }

    public void setDigestValue(String DigestValue) {
        this.DigestValue = DigestValue;
    }
}
