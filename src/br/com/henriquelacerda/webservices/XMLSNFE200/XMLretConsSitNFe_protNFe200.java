/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import br.com.moveti.erpmove.fiscal.Xml.infProt;
import br.com.moveti.erpmove.fiscal.Xml.protNFe;
import br.com.moveti.erpmove.fiscal.Xml.retConsSitNFe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.annotations.XStreamAlias;
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
public class XMLretConsSitNFe_protNFe200
{

    public static void main(String args[])
    {
        XMLretConsSitNFe_protNFe200 TratamentoRetorno = new XMLretConsSitNFe_protNFe200();

        String NumeroRecibo = "";
        String Retorno = "";

        String T =
                
                "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>2.00</verAplic><cStat>217</cStat><xMotivo>Rejeicao: NF-e nao consta na base de dados da SEFAZ</xMotivo><cUF>31</cUF><chNFe>31101009029577000109550010000001681231265328</chNFe></retConsSitNFe>";
//                "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
//                + "<tpAmb>2</tpAmb>"
//                + "<verAplic>2.00</verAplic>"
//                + "<cStat>100</cStat>"
//                + "<xMotivo>AUTORIZADA</xMotivo>"
//                + "<cUF>31</cUF>"
//                + "<chNFe>31101009029577000109550010000001631765303870</chNFe>"
//                + "<protNFe versao=\"2.00\">"
//                + "                <infProt Id=\"ID31101009029577000109550010000001631765303870\">"
//                + "                    <tpAmb>2</tpAmb>"
//                + "                    <verAplic>2.00</verAplic>"
//                + "                    <chNFe>31101009029577000109550010000001631765303870</chNFe>"
//                +"                     <dhRecbto>2010-10-01T13:06:15</dhRecbto>"
//                + "                    <nProt>131100020755236</nProt>"
//                + "                    <digVal>4/SOCazY3envkhvjsrcFcBHXfLk=</digVal>"
//                + "                    <cStat>100</cStat>"
//                + "                    <xMotivo>AUTORIZADA</xMotivo>"
//                + "                </infProt>"
//                + "            </protNFe>"
//                + "            </retConsSitNFe>";
        //TratamentoRetorno.setXML("<?xml version=\"1.0\" encoding=\"UTF-8\"?><retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.10\">  <tpAmb>2</tpAmb>  <verAplic>0582</verAplic>  <nRec>310000008342017</nRec>  <cStat>104</cStat>  <xMotivo>Lote processado</xMotivo>  <cUF>31</cUF>  <protNFe versao=\"1.10\">    <infProt>      <tpAmb>2</tpAmb>      <verAplic>0582</verAplic>      <chNFe>31100309029577000109550010000000412385327100</chNFe>      <dhRecbto>2010-03-30T15:11:05</dhRecbto>      <nProt>131100016637014</nProt>      <digVal>FTtACO+EZ5pf4wO34/mcOWYoLOw=</digVal>      <cStat>100</cStat>      <xMotivo>Autorizado o uso da NF-e</xMotivo>    </infProt>  </protNFe></retConsReciNFe>");
        TratamentoRetorno.setXML(T);
        TratamentoRetorno.BuscaDadosXML();
          
    }
    private String XML = "";
    private retConsSitNFe xmlretConsSitNFe = new retConsSitNFe();

    public void setXML(String xml)
    {
        this.XML = xml;
    }

    public void BuscaDadosXML()
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("retConsSitNFe", retConsSitNFe.class);
        xstream.alias("protNFe", protNFe.class);
        xstream.alias("infProt", infProt.class); 
        System.out.println(XML);
        setXmlretConsSitNFe((retConsSitNFe) xstream.fromXML(XML));
    }

    /**
     * @return the xmlretConsSitNFe
     */
    public retConsSitNFe getXmlretConsSitNFe() {
        return xmlretConsSitNFe;
    }

    /**
     * @param xmlretConsSitNFe the xmlretConsSitNFe to set
     */
    public void setXmlretConsSitNFe(retConsSitNFe xmlretConsSitNFe) {
        this.xmlretConsSitNFe = xmlretConsSitNFe;
    }
   
}
