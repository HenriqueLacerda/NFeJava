/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200;

import br.com.moveti.erpmove.fiscal.Xml.infProt;
import br.com.moveti.erpmove.fiscal.Xml.protNFe;
import br.com.moveti.erpmove.fiscal.Xml.retConsSitNFe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

/**
 *
 * @author Henrique
 */
/*<?xml version="1.0" encoding="UTF-8"?>
<XMLretConsSitNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.10">
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
</XMLretConsSitNFe>*/
public class XMLretConsSitNFe_FalhaSchemaChNFE200 {

    public static void main(String args[]) {
        XMLretConsSitNFe_FalhaSchemaChNFE200 TratamentoRetorno = new XMLretConsSitNFe_FalhaSchemaChNFE200();

        String NumeroSitbo = "";
        String Retorno = "";

        String S = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>1</tpAmb><verAplic>2.00</verAplic><cStat>217</cStat><xMotivo>Rejeicao: NF-e nao consta na base de dados da SEFAZ</xMotivo><cUF>31</cUF><chNFe>31120701916534000125550010000000341880577209</chNFe></retConsSitNFe>";

        TratamentoRetorno.setXML(S);
        TratamentoRetorno.BuscaDadosXML();

    }
    private String XML = "";
    private retConsSitNFe xmlretConsSitNFe = new retConsSitNFe();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {

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
