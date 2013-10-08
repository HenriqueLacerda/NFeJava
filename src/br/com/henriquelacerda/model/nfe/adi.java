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
@XStreamAlias("adi")
public class adi {

    private String nAdicao;
    private String nSeqAdic;
    private String cFabricante;
    private String vDescDI;
    private String xPed;
    private String nItemPed;

    public String getnAdicao() {
        return nAdicao;
    }

    public void setnAdicao(String nAdicao) {
        this.nAdicao = nAdicao;
    }

    public String getnSeqAdic() {
        return nSeqAdic;
    }

    public void setnSeqAdic(String nSeqAdic) {
        this.nSeqAdic = nSeqAdic;
    }

    public String getcFabricante() {
        return cFabricante;
    }

    public void setcFabricante(String cFabricante) {
        this.cFabricante = cFabricante;
    }

    public String getvDescDI() {
        return vDescDI;
    }

    public void setvDescDI(String vDescDI) {
        this.vDescDI = vDescDI;
    }

    public String getxPed() {
        return xPed;
    }

    public void setxPed(String xPed) {
        this.xPed = xPed;
    }

    public String getnItemPed() {
        return nItemPed;
    }

    public void setnItemPed(String nItemPed) {
        this.nItemPed = nItemPed;
    }
}
