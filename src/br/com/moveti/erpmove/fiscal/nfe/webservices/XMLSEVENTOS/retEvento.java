/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSEVENTOS;

/**
 *
 * @author Henrique
 */
public class retEvento {

    public String versao;
    public infEvento infEvento = new infEvento();

    public String getCNPJDest() {
        return infEvento.CNPJDest;
    }

    public String getCPFDest() {
        return infEvento.CPFDest;
    }

    public String getId() {
        return infEvento.Id;
    }

    public String getcOrgao() {
        return infEvento.cOrgao;
    }

    public String getcStat() {
        return infEvento.cStat;
    }

    public String getChNFe() {
        return infEvento.chNFe;
    }

    public String getDhRegEvento() {
        return infEvento.dhRegEvento;
    }

    public String getnProt() {
        return infEvento.nProt;
    }

    public String getnSeqEvento() {
        return infEvento.nSeqEvento;
    }

    public String getTpAmb() {
        return infEvento.tpAmb;
    }

    public String getTpEvento() {
        return infEvento.tpEvento;
    }

    public String getVerAplic() {
        return infEvento.verAplic;
    }

    public String getxEvento() {
        return infEvento.xEvento;
    }

    public String getxMotivo() {
        return infEvento.xMotivo;
    }
}

class infEvento {

    public String Id;
    public String tpAmb;
    public String verAplic;
    public String cOrgao;
    public String cStat;
    public String xMotivo;
    public String chNFe;
    public String tpEvento;
    public String xEvento;
    public String nSeqEvento;
    public String CNPJDest;
    public String CPFDest;
    public String dhRegEvento;
    public String nProt;
}
