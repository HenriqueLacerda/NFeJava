/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFSE;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Henrique
 */
public class XmlGerarNfseRespostaMensagem {

    public static void main(String args[]) {
        XmlGerarNfseRespostaMensagem XmlGerarNfseResposta = new XmlGerarNfseRespostaMensagem();

        String NumeroRecibo = "";
        String Retorno = "";

        String T = "<?xml version='1.0' encoding='UTF-8'?><GerarNfseResposta xmlns=\"http://www.abrasf.org.br/nfse.xsd\"><ListaMensagemRetorno><MensagemRetorno><Codigo>E182</Codigo><Mensagem>Erro na autenticação.</Mensagem></MensagemRetorno></ListaMensagemRetorno></GerarNfseResposta>";
        XmlGerarNfseResposta.setXML(T);
        XmlGerarNfseResposta.BuscaDadosXML();
        System.out.println(XmlGerarNfseResposta.getCodigo());
    }
    private String XML = "";
    private GerarNfseResposta GerarNfseResposta = new GerarNfseResposta();

    public void setXML(String xml) {
        this.XML = xml;
    }

    public void BuscaDadosXML() {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("GerarNfseResposta", GerarNfseResposta.class);
        xstream.alias("ListaMensagemRetorno", ListaMensagemRetorno.class);
        xstream.alias("MensagemRetorno", MensagemRetorno.class);
        GerarNfseResposta = (GerarNfseResposta) xstream.fromXML(XML);
    }

    public String getCodigo() {
        return GerarNfseResposta.ListaMensagemRetorno.MensagemRetorno.Codigo;
    }

    class GerarNfseResposta {
        ListaMensagemRetorno ListaMensagemRetorno = new ListaMensagemRetorno();
    }

    class ListaMensagemRetorno {
        MensagemRetorno MensagemRetorno = new MensagemRetorno();
    }

    class MensagemRetorno {
        String Codigo;
        String Mensagem;
    }
}
