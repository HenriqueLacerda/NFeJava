/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Jéssica
 */
public class XMLretEnvConfRecebto {
     private String XML = "";
     private retEnvEvento retEnvEvento = new retEnvEvento();
     
     public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());      
        xstream.processAnnotations(retEnvEvento.class);
        xstream.processAnnotations(retEvento.class);
        retEnvEvento = (retEnvEvento) xstream.fromXML(XML);
    }
     
     @XStreamAlias("retEnvEvento")
     class retEnvEvento{
         @XStreamAlias("idLote")
         String idLote;
         @XStreamAlias("tpAmb")
         String tpAmb;
         @XStreamAlias("verAplic")
         String verAplic;
         @XStreamAlias("cOrgao")
         String cOrgao;
         @XStreamAlias("cStat")
         String cStat;
         @XStreamAlias("xmotivo")
         String xmotivo;
         
     }
     
     @XStreamAlias("retEvento")
     class retEvento{
         @XStreamAlias("versao")
         String versao;
     }
     
     @XStreamAlias("infEvento")
     class infEvento{
         @XStreamAlias("id")
         String id;
         @XStreamAlias("tpAmb")
         String tpAmb;
         @XStreamAlias("verAplic")
         String verAplic;
         @XStreamAlias("cOrgao")
         String cOrgao;
         @XStreamAlias("cStat")
         String cStat;
         @XStreamAlias("xMotivo")
         String xMotivo;
         @XStreamAlias("chNFe")
         String chNFe;
         @XStreamAlias("tpEvento")
         String tpEvento;
         @XStreamAlias("xEvento")
         String xEvento;
         @XStreamAlias("nSeqEvento")                 
         String nSeqEvento;
         @XStreamAlias("CNPJDest")
         String CNPJDest;
         @XStreamAlias("CPFDest")
         String CPFDest;
         @XStreamAlias("emailDest")
         String emailDest;
         @XStreamAlias("dhRegEvento")
         String dhRegEvento;
         @XStreamAlias("nProt")
         String nProt;
         @XStreamAlias("Signature")
         String Signature;
         
     }
}
