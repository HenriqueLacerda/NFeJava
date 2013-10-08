/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class cana {

    private String safra;
    private String ref;
    private forDia forDia;

    public forDia getForDia() {
        return forDia;
    }

    public void setForDia(forDia forDia) {
        this.forDia = forDia;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }
}
