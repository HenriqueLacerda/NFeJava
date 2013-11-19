/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSEVENTOS;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Henrique
 */
/*
<?xml version="1.0" encoding="UTF-8"?>
<XMLretEnviNFe200 xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.10">
<tpAmb>2</tpAmb>
<verAplic>0582</verAplic>
<cStat>103</cStat>
<xMotivo>Lote recebido com sucesso</xMotivo>
<cUF>31</cUF>
<dhRecbto>2010-10-01T00:24:34</dhRecbto>
<infRec>
<nRec>310000008329250</nRec>
<tMed>1</tMed>
</infRec>
</XMLretEnviNFe200>
 */



public class XMLretEnvCCe200 {

    String XML = "";
    retEnviCCe retEnviCCe = new retEnviCCe();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public retEnviCCe getRetEnviCCe() {
        return retEnviCCe;
    }

    public void setRetEnviCCe(retEnviCCe retEnviCCe) {
        this.retEnviCCe = retEnviCCe;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retEnvEvento", retEnviCCe.class);
        setRetEnviCCe((retEnviCCe) xstream.fromXML(XML));
    }

    public class retEnviCCe {

        String idLote;
        String tpAmb;
        String verAplic;
        String cOrgao;
        String cStat;
        String xMotivo;
        private retEvento retEvento = new retEvento();

        public retEvento getRetEvento() {
            return retEvento;
        }

        public void setRetEvento(retEvento retEvento) {
            this.retEvento = retEvento;
        }
    }

    public class retEvento {

        String versao;
        private infEvento infEvento;

        public infEvento getInfEvento() {
            return infEvento;
        }
    }

    public class infEvento {

        String Id;
        String tpAmb;
        String verAplic;
        String cOrgao;
        String cStat;
        String xMotivo;
        String chNFe;
        String tpEvento;
        String xEvento;
        String nSeqEvento;
        String CNPJDest;
        String CPFDest;
        String emailDest;
        String dhRegEvento;
        String nProt;
    }

    public String get_CStat() {
        return retEnviCCe.getRetEvento().getInfEvento().cStat;
    }

    public String get_xMotivo() {
        return retEnviCCe.getRetEvento().getInfEvento().xMotivo;
    }
    
    public String get_nProt() {
        return retEnviCCe.getRetEvento().getInfEvento().nProt;
    }
}
