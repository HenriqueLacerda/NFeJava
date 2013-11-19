/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.enderEmit;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */

@XStreamAlias("emit")
public class emit {

    private String CNPJ;
    private String CPF;
    private String xNome;
    private String xFant;
    private enderEmit enderEmit = new enderEmit();
    private String IE;
    private String IEST;
    private String IM;
    private String CNAE;
    private String CRT;
    

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getxNome() {
        return xNome;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }

    public String getxFant() {
        return xFant;
    }

    public void setxFant(String xFant) {
        this.xFant = xFant;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getCRT() {
        return CRT;
    }

    public void setCRT(String CRT) {
        this.CRT = CRT;
    }

    public enderEmit getEnderEmit() {
        return enderEmit;
    }

    public void setEnderEmit(enderEmit enderEmit) {
        this.enderEmit = enderEmit;
    }

    public String getCNAE() {
        return CNAE;
    }

    public void setCNAE(String CNAE) {
        this.CNAE = CNAE;
    }

    public String getIEST() {
        return IEST;
    }

    public void setIEST(String IEST) {
        this.IEST = IEST;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }
    
}
