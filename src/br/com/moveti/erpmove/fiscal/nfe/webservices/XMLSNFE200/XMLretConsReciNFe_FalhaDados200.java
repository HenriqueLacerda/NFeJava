/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Henrique
 */
/*<?xml version="1.0" encoding="UTF-8"?>
<XMLretConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.10">
  <tpAmb>2</tpAmb>
  <verAplic>0582</verAplic>
  <nRec>310000008329250</nRec>
  <cStat>104</cStat>
  <xMotivo>Lote processado</xMotivo>
  <cUF>31</cUF>
  <protNFe versao="1.10">
    <infProt>
      <tpAmb>2</tpAmb>
      <verAplic>0582</verAplic>
      <chNFe>31100309029577000109550010000000382708851179</chNFe>
      <dhRecbto>2010-03-29T20:44:59</dhRecbto>
      <digVal>S3kYVzorYTouhS/+eA6k2S0FGVY=</digVal>
      <cStat>277</cStat>
      <xMotivo>Rejeicao: Codigo Municipio do Local de Retirada: difere da UF do Local deRetirada</xMotivo>
    </infProt>
  </protNFe>
</XMLretConsReciNFe>*/
public class XMLretConsReciNFe_FalhaDados200 {

    public static void main(String args[])
    {
        XMLretConsReciNFe_FalhaDados200 TratamentoRetorno = new XMLretConsReciNFe_FalhaDados200();

        String NumeroRecibo = "";
        String Retorno = "";


        TratamentoRetorno.setXML("<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>12_5_72</verAplic><nRec>310000021153233</nRec><cStat>105</cStat><xMotivo>Lote em processamento</xMotivo><cUF>31</cUF></retConsReciNFe>");
        TratamentoRetorno.BuscaDadosXML();

        System.out.println(TratamentoRetorno.cStat());
//        System.out.println(TratamentoRetorno.infProtcStat());
//        System.out.println(TratamentoRetorno.infProtxMotivo());
    }

    private String XML = "";
    private retConsReciNFe xmlretConsReciNFe;

    public void setXML(String xml)
    {
        this.XML = xml;
    }

    public void BuscaDadosXML()
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retConsReciNFe", retConsReciNFe.class);
        //xstream.alias("protNFe", protNFe.class);
       // xstream.alias("infProt", infProt.class);
        System.out.println(XML);
        xmlretConsReciNFe = (retConsReciNFe)xstream.fromXML(XML);
    }
    public String tpAmb()
    {
        return xmlretConsReciNFe.tpAmb;
    }
    public String verAplic()
    {
        return xmlretConsReciNFe.verAplic;
    }
    public String nRec()
    {
        return xmlretConsReciNFe.nRec;
    }
    public String cStat()
    {
        return xmlretConsReciNFe.cStat;
    }
    public String xMotivo()
    {
        return xmlretConsReciNFe.xMotivo;
    }
    public String cUF()
    {
        return xmlretConsReciNFe.cUF;
    }

//    public String infProttpAmb()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.tpAmb;
//    }
//    public String infProtverAplic()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.verAplic;
//    }
//    public String infProtchNFe()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.chNFe;
//    }
//    public String infProtdhRecbto()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.dhRecbto;
//    }
//    public String infProtdigVal()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.digVal;
//    }
//    public String infProtcStat()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.cStat;
//    }
//    public String infProtxMotivo()
//    {
//        return xmlretConsReciNFe.protNFe.infProt.xMotivo;
//    }

    class retConsReciNFe
    {
        String tpAmb;
        String verAplic;
        String nRec;
        String cStat;
        String xMotivo;
        String cUF;
        
        //protNFe protNFe = new protNFe();
    }
    class protNFe
    {
        infProt infProt = new infProt();
    }
    class infProt
    {
        String tpAmb;
        String verAplic;
        String chNFe;
        String dhRecbto;
        String digVal;
        String cStat;
        String xMotivo;
    }
}


