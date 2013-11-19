/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSCTE;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.ObjectInputStream;
import java.io.StringReader;

/**
 *
 * @author Henrique
 */
/*
<?xml version="1.0" encoding="UTF-8"?>
<XMLretEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.10">
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
</XMLretEnviNFe>
 */
public class XMLretEnviCte {
    private String XML = "";
    retEnviNFe xmlretEnviNFe;
    
    public void setXML(String xml)
    {
        this.XML = xml;
    }
    
    public void BuscaDadosXML()
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retEnviNFe", retEnviNFe.class);
        xstream.alias("infRec", infRec.class);
        xmlretEnviNFe = (retEnviNFe)xstream.fromXML(XML);
    }

    public String tpAmb()
    {
        return xmlretEnviNFe.tpAmb;
    }
    public String verAplic()
    {
        return xmlretEnviNFe.verAplic;
    }
    public String cStat()
    {
        return xmlretEnviNFe.cStat;
    }
    public String xMotivo()
    {
        return xmlretEnviNFe.xMotivo;
    }
    public String cUF()
    {
        return xmlretEnviNFe.cUF;
    }
    public String dhRecbto()
    {
        return xmlretEnviNFe.dhRecbto;
    }
    public String nRec()
    {
        return xmlretEnviNFe.infRec.nRec;
    }
    public String tMed()
    {
        return xmlretEnviNFe.infRec.tMed;
    }
}

class retEnviNFe
{
    String tpAmb;
    String verAplic;
    String cStat;
    String xMotivo;
    String cUF;
    String dhRecbto;
    infRec infRec = new infRec();
}
class infRec
{
    String nRec;
    String tMed;
}


