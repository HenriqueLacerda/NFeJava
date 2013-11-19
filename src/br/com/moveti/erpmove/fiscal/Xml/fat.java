/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author move
 */
@XStreamAlias("fat")
public class fat {
    private String nFat;
    private String vOrig;
    private String vDesc;
    private String vLiq;

    public String getnFat() {
        return nFat;
    }

    public void setnFat(String nFat) {
        this.nFat = nFat;
    }

    public String getvDesc() {
        return vDesc;
    }

    public void setvDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public String getvLiq() {
        return vLiq;
    }

    public void setvLiq(String vLiq) {
        this.vLiq = vLiq;
    }

    public String getvOrig() {
        return vOrig;
    }

    public void setvOrig(String vOrig) {
        this.vOrig = vOrig;
    }
    
            
}
