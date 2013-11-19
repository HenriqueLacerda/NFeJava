/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.DI;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("prod")
public class prod {

    private String cProd;
    private String cEAN;
    private String xProd;
    private String NCM;
    private String EXTIPI;
    private String CFOP;
    private String uCom;
    private String qCom;
    private String vUnCom;
    private String vProd;
    private String cEANTrib;
    private String uTrib;
    private String qTrib;
    private String vUnTrib;
    private String vFrete;
    private String vSeg;
    private String vDesc;
    private String vOutro;
    private String indTot;
    private DI DI = new DI();
    private String xPed;
    private String nItemPed;

    public String getnItemPed() {
        return nItemPed;
    }

    public void setnItemPed(String nItemPed) {
        this.nItemPed = nItemPed;
    }

    public String getcProd() {
        return cProd;
    }

    public void setcProd(String cProd) {
        this.cProd = cProd;
    }

    public String getcEAN() {
        return cEAN;
    }

    public void setcEAN(String cEAN) {
        this.cEAN = cEAN;
    }

    public String getxProd() {
        return xProd;
    }

    public void setxProd(String xProd) {
        this.xProd = xProd;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getuCom() {
        return uCom;
    }

    public void setuCom(String uCom) {
        this.uCom = uCom;
    }

    public String getqCom() {
        return qCom;
    }

    public void setqCom(String qCom) {
        this.qCom = qCom;
    }

    public String getvUnCom() {
        return vUnCom;
    }

    public void setvUnCom(String vUnCom) {
        this.vUnCom = vUnCom;
    }

    public String getvProd() {
        return vProd;
    }

    public void setvProd(String vProd) {
        this.vProd = vProd;
    }

    public String getcEANTrib() {
        return cEANTrib;
    }

    public void setcEANTrib(String cEANTrib) {
        this.cEANTrib = cEANTrib;
    }

    public String getuTrib() {
        return uTrib;
    }

    public void setuTrib(String uTrib) {
        this.uTrib = uTrib;
    }

    public String getqTrib() {
        return qTrib;
    }

    public void setqTrib(String qTrib) {
        this.qTrib = qTrib;
    }

    public String getvUnTrib() {
        return vUnTrib;
    }

    public void setvUnTrib(String vUnTrib) {
        this.vUnTrib = vUnTrib;
    }

    public String getIndTot() {
        return indTot;
    }

    public void setIndTot(String indTot) {
        this.indTot = indTot;
    }

    public DI getDI() {
        return DI;
    }

    public void setDI(DI DI) {
        this.DI = DI;
    }

    public String getEXTIPI() {
        return EXTIPI;
    }

    public void setEXTIPI(String EXTIPI) {
        this.EXTIPI = EXTIPI;
    }

    public String getvDesc() {
        return vDesc;
    }

    public void setvDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public String getvFrete() {
        return vFrete;
    }

    public void setvFrete(String vFrete) {
        this.vFrete = vFrete;
    }

    public String getvOutro() {
        return vOutro;
    }

    public void setvOutro(String vOutro) {
        this.vOutro = vOutro;
    }

    public String getvSeg() {
        return vSeg;
    }

    public void setvSeg(String vSeg) {
        this.vSeg = vSeg;
    }

    public String getxPed() {
        return xPed;
    }

    public void setxPed(String xPed) {
        this.xPed = xPed;
    }
}
