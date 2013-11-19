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
@XStreamAlias("nfeProc")
public class nfeProc {
    private String versao;
    private NFe NFe;
    private protNFe protNFe;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public NFe getNFe() {
        return NFe;
    }

    public void setNFe(NFe NFe) {
        this.NFe = NFe;
    }

    public protNFe getProtNFe() {
        return protNFe;
    }

    public void setProtNFe(protNFe protNFe) {
        this.protNFe = protNFe;
    }
}
