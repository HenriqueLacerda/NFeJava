/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

/**
 *
 * @author Henrique
 */
public class avulsa {

    private String CNPJ;
    private String xOrgao;
    private String matr;
    private String xAgente;
    private String fone;
    private String UF;
    private String nDAR;
    private String dEmi;
    private String vDAR;
    private String repEmi;
    private String dPag;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getdEmi() {
        return dEmi;
    }

    public void setdEmi(String dEmi) {
        this.dEmi = dEmi;
    }

    public String getdPag() {
        return dPag;
    }

    public void setdPag(String dPag) {
        this.dPag = dPag;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }

    public String getnDAR() {
        return nDAR;
    }

    public void setnDAR(String nDAR) {
        this.nDAR = nDAR;
    }

    public String getRepEmi() {
        return repEmi;
    }

    public void setRepEmi(String repEmi) {
        this.repEmi = repEmi;
    }

    public String getvDAR() {
        return vDAR;
    }

    public void setvDAR(String vDAR) {
        this.vDAR = vDAR;
    }

    public String getxAgente() {
        return xAgente;
    }

    public void setxAgente(String xAgente) {
        this.xAgente = xAgente;
    }

    public String getxOrgao() {
        return xOrgao;
    }

    public void setxOrgao(String xOrgao) {
        this.xOrgao = xOrgao;
    }
}
