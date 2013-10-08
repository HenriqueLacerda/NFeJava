/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.IPITrib;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("IPI")
public class IPI {

    private String clEnq;
    private String CNPJProd;
    private String cSelo;
    private String qSelo;
    private String cEnq;
    private IPITrib IPITrib = new IPITrib();
    private IPINT IPINT = new IPINT();

    public IPINT getIPINT() {
        return IPINT;
    }

    public void setIPINT(IPINT IPINT) {
        this.IPINT = IPINT;
    }

    public String getClEnq() {
        return clEnq;
    }

    public void setClEnq(String clEnq) {
        this.clEnq = clEnq;
    }

    public String getCNPJProd() {
        return CNPJProd;
    }

    public void setCNPJProd(String CNPJProd) {
        this.CNPJProd = CNPJProd;
    }

    public String getcSelo() {
        return cSelo;
    }

    public void setcSelo(String cSelo) {
        this.cSelo = cSelo;
    }

    public String getqSelo() {
        return qSelo;
    }

    public void setqSelo(String qSelo) {
        this.qSelo = qSelo;
    }

    public String getcEnq() {
        return cEnq;
    }

    public void setcEnq(String cEnq) {
        this.cEnq = cEnq;
    }

    public IPITrib getIPITrib() {
        return IPITrib;
    }

    public void setIPITrib(IPITrib IPITrib) {
        this.IPITrib = IPITrib;
    }
}
