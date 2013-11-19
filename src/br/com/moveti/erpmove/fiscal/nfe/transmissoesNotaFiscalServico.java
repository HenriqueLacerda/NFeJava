/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe;

import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeCancelamento2.HNfeCancelamento2Stub;
import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeCartaCorrecao2.HNfeCartaCorrecao2Stub;
import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeConsulta2.HNfeConsulta2Stub;
import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeInutilizacao2.HNfeInutilizacao2Stub;
import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeRecepcao2.HNfeRecepcao2Stub;
import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeRetRecepcao2.HNfeRetRecepcao2Stub;
import br.com.moveti.erpmove.fiscal.nfe.webservices.HNFE.NfeStatusServico2.HNfeStatusServico2Stub;
//import crnatdb.msg;
import br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Input;
import br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Nfse;
import br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.NfseWSService;
import br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Output;
import crncomp.geral;
import crncomp.msg;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

/**
 *
 * @author henriquelacerda
 */
public class transmissoesNotaFiscalServico {

    private Provider p;
    private Provider op;
    private KeyStore ks;
    private static final int SSL_PORT = 443;
    private String XML = "";
    private String XMLAssinado = "";
    private String XMLEventoCCe = "";
    private String tipoCertificado = "";
    private String senhaCertificado = "";
    private String configuracaoCertificadoA1 = "";
    private String configuracaoCertificadoA3 = "";
    private String CaminhoKeyStoreTodos = "key.jks";
    private InputStream stream = null;
    private String configuracaoVersaoAmbiente = "";
    private String configuracaoModeloNf = "";
    private String configuracaoSerieNf = "";
    private String configuracaoAmbienteEmissaoNf = "";
    private String empresaCodEstado = "";
    private String empresaCnpj = "";
    private String estado = "";
    private String tipo = "";
    private String arquivoCacertsGeradoTodosOsEstados;
    private boolean ProtocoloAdicionado = false;
    private String aliasCertificado = "";

    // Assinar Nota Fiscal
    public String assinarNotaFiscal() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(getXML().toString().getBytes("UTF-8")));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            NodeList elements = doc.getElementsByTagName("InfRps");
            Element el = (Element) elements.item(0);
            String id = el.getAttribute("Id");
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
            stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());
            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);

            String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
            if (!resultado.equals("")) {
                msg.alertInf(resultado, "Atenção");
                return "";
            }
            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;
            KeyStore.PasswordProtection asdf = new KeyStore.PasswordProtection(senhaCertificado.toCharArray());

            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }

            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
            XMLSignature signature = fac.newXMLSignature(si, ki);
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));
            XMLAssinado = os.toString();
            return "OK";
        } catch (Exception e) {
            System.out.println(e.toString());
            return e.getCause().getMessage();
        }
    }

    private void assinarElementoInfRps(XMLSignatureFactory fac, ArrayList transformList, PrivateKey privateKey, KeyInfo ki, Document doc, int i) throws Exception {
        NodeList elements = doc.getElementsByTagName("InfRps");
        Element el = (Element) elements.item(i);
        String id = el.getAttribute("Id");

        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                DigestMethod.SHA1, null), transformList, null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(ref));
        XMLSignature signature = fac.newXMLSignature(si, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement().getElementsByTagName("NFe").item(i));
        signature.sign(dsc);
    }

    public static void main(String[] args) {
        transmissoesNotaFiscalServico t = new transmissoesNotaFiscalServico();

        //t.setAliasCertificado("EXPLOSIVOS MAJAS LTDA:41800707000160'sAC PRODEMGE RFB G2 ID");

        //t.buscarDadosConfiguracaoEmpresa();
        t.buscarDadosCertificado();

        t.setConfiguracaoAmbienteEmissaoNf("2");
        // UF
        t.setEstado("MG");
        // Codigo UF
        t.setEmpresaCodEstado("31");
        // Dados do Certificado
        //t.buscarDadosConfiguracaoEmpresa();
        // XML

        String XML = //"<CompNfse xmlns=\"http://www.abrasf.org.br/nfse.xsd\">"
                "<Rps>"
                + "<InfRps Id=\"999999990001911733160024200900000000464\">"
                + "<IdentificacaoRps>"
                + "<Numero>1</Numero>"
                + "<Serie>ABCDZ</Serie>"
                + "<Tipo>1</Tipo>"
                + "</IdentificacaoRps>"
                + "<DataEmissao>2009-09-29T15:31:23</DataEmissao>"
                + "<NaturezaOperacao>1</NaturezaOperacao>"
                + "<RegimeEspecialTributacao>6</RegimeEspecialTributacao>"
                + "<OptanteSimplesNacional>1</OptanteSimplesNacional>"
                + "<IncentivadorCultural>2</IncentivadorCultural>"
                + "<Status>1</Status>"
                
                + "<Servico>"
                + "<Valores>"
                
//  + "<ValorServicos>140.00</ValorServicos>"
//  + "<ValorDeducoes>0.00</ValorDeducoes>"
//  + "<ValorPis>0.00</ValorPis>"
//  + "<ValorCofins>0.00</ValorCofins>"
//  + "<ValorInss>0.00</ValorInss>"
//  + "<ValorIr>0.00</ValorIr>"
//  + "<ValorCsll>0.00</ValorCsll>"
//  + "<IssRetido>1</IssRetido>"
//  + "<BaseCalculo>140.00</BaseCalculo>"
//  + "<Aliquota>0.03</Aliquota>"
//                
//  /*+ "<ValorIssRetido>4.20</ValorIssRetido>"
//  + "<DescontoCondicionado>0</DescontoCondicionado>"
//  + "<DescontoIncondicionado>0</DescontoIncondicionado>"*/
//                
//  + "<ValorLiquidoNfse>140.00</ValorLiquidoNfse>"
  
  
          
                + "<ValorServicos>100000.00</ValorServicos>"
                + "<ValorDeducoes>10.00</ValorDeducoes>"
                + "<ValorPis>10.00</ValorPis>"
                + "<ValorCofins>10.00</ValorCofins>"
                + "<ValorInss>10.00</ValorInss>"
                + "<ValorIr>10.00</ValorIr>"
                + "<ValorCsll>10.00</ValorCsll>"
                + "<IssRetido>1</IssRetido>"
                + "<ValorIss>3499.30</ValorIss>"
                
                + "<OutrasRetencoes>10.00</OutrasRetencoes>"
                + "<BaseCalculo>99980.00</BaseCalculo>"
                + "<Aliquota>0.035</Aliquota>"
//                + "<ValorIssRetido>3499.30</ValorIssRetido>"
//
//                + "<DescontoCondicionado>10.00</DescontoCondicionado>"
//                + "<DescontoIncondicionado>10.00</DescontoIncondicionado>"
                
                + "<ValorLiquidoNfse>96420.70</ValorLiquidoNfse>"
                
                + "</Valores>"
                + "<ItemListaServico>11.01</ItemListaServico>"
                + "<CodigoTributacaoMunicipio>522310000</CodigoTributacaoMunicipio>"
                + "<Discriminacao>Teste.</Discriminacao>"
                + "<CodigoMunicipio>3106200</CodigoMunicipio>"
                + "</Servico>"
                
                + "<Prestador>"
                //+ "<Cnpj>07595825000226</Cnpj>"
                //+ "<InscricaoMunicipal>1970280023</InscricaoMunicipal>"
                + "<Cnpj>07595825000145</Cnpj>"
                + "<InscricaoMunicipal>72059084</InscricaoMunicipal>"
                + "</Prestador>"
                
                + "<Tomador>"
                + "<IdentificacaoTomador>"
                + "<CpfCnpj>"
                + "<Cnpj>99999999000191</Cnpj>"
                + "</CpfCnpj>"
                + "<InscricaoMunicipal>1733160032</InscricaoMunicipal>"
                + "</IdentificacaoTomador>"
                + "<RazaoSocial>INSCRICAO DE TESTE SIATU - DAGUA -PAULINOS"
                + "</RazaoSocial>"
                + "<Endereco>"
                + "<Endereco>DA BAHIA</Endereco>"
                + "<Numero>200</Numero>"
                + "<Complemento>ANDAR 14</Complemento>"
                + "<Bairro>CENTRO</Bairro>"
                + "<CodigoMunicipio>3106200</CodigoMunicipio>"
                + "<Uf>MG</Uf>"
                + "<Cep>30160010</Cep>"
                + "</Endereco>"
                + "</Tomador>"
                + "<IntermediarioServico>"
                + "<RazaoSocial>INSCRICAO DE TESTE SIATU - DAGUA -PAULINOS"
                + "</RazaoSocial>"
                + "<CpfCnpj>"
                + "<Cnpj>99999999000191</Cnpj>"
                + "</CpfCnpj>"
                + "<InscricaoMunicipal>8041700010</InscricaoMunicipal>"
                + "</IntermediarioServico>"
                + "<ConstrucaoCivil>"
                + "<CodigoObra>1234</CodigoObra>"
                + "<Art>1234</Art>"
                + "</ConstrucaoCivil>"
                + "</InfRps>"
                + "</Rps>";

        t.setXML(XML);

        try {

            t.assinarNotaFiscal();
            System.out.println(t.enviarNotasFiscais(1));

        } catch (Exception e) {
            System.out.println(e.toString());
        }

//        String result2 = "";
//        try {
//            //result2 = t.assinarNotaFiscal();
//        } catch (Exception ex) {
//            Logger.getLogger(transmissoesNotaFiscalServico.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(result2);
//        System.out.println(t.getXMLAssinado());


    }
    // Validar Nota Fiscal

    public String validarXMLNotasFiscais() {
        try {
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DBF.setNamespaceAware(true);
            DocumentBuilder parser = DBF.newDocumentBuilder();
            InputStream IS = new ByteArrayInputStream(getXMLAssinado().getBytes());
            Document document = parser.parse(IS);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            String Path = new crncomp.parametros._verificaParametro(11).getValorString();
            Source schemaFile = new StreamSource(new File(Path + "/Schema/nfe_v2.00.xsd"));
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
            return "OK";
        } catch (ParserConfigurationException e) {
            return e.getMessage();
        } catch (SAXException e) {
            return e.getMessage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String assinarEnviarLoteRpsEnvio(String TipoCertificado, String Senha, String XML) throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(XML.toString().getBytes("UTF-8")));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            NodeList elements = doc.getElementsByTagName("LoteRps");
            Element el = (Element) elements.item(0);
            String id = el.getAttribute("Id");
            //String id = el.getAttribute("ListaRps");
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
            stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());
            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);

            String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
            if (!resultado.equals("")) {
                msg.alertInf(resultado, "Atenção");
                return "";
            }
            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;
            KeyStore.PasswordProtection asdf = new KeyStore.PasswordProtection(senhaCertificado.toCharArray());

            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }

            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            System.out.println("ID: "+id);
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
            //Reference ref = fac.newReference("#", fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
            XMLSignature signature = fac.newXMLSignature(si, ki);
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));
            
            
            return os.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            return e.getCause().getMessage();
        }
    }

    public String enviarNotasFiscais(int numeracaoLote) {
        String Resultado = "0";
        try {
            URL url;
            if (configuracaoAmbienteEmissaoNf.equals("2")) {
                if ("S".equals(tipo)) {
                    url = new URL("https://hom.nfe.fazenda.gov.br/SCAN/NfeRecepcao2/NfeRecepcao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/NfeRecepcao2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeRecepcao2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRecepcao2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRecepcao2?wsdl");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRecepcao2?wsdl");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRecepcao2");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRecepcao2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeRecepcao2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRecepcao2");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/Nferecepcao/NFeRecepcao2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeRecepcao2.asmx");
                    } else {
                        url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NfeRecepcao2/NfeRecepcao2.asmx");
                    }
                }
            } else {
                if ("S".equals(tipo)) {
                    url = new URL("https://www.scan.fazenda.gov.br/NfeRecepcao2/NfeRecepcao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeRecepcao2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeRecepcao2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRecepcao2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRecepcao2?wsdl");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRecepcao2");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeRecepcao2");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRecepcao2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRecepcao2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://nfe2.fazenda.pr.gov.br/nfe/NFeRecepcao2?wsdl");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://nfe.sefaz.rs.gov.br/ws/Nferecepcao/NFeRecepcao2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nferecepcao2.asmx");
                    } else {
                        url = new URL("https://www.sefazvirtual.fazenda.gov.br/NfeRecepcao2/NfeRecepcao2.asmx");
                    }
                }
            }
            try {

                NfseWSService _service = new NfseWSService();
                Nfse nfse = _service.getNfseSOAP();
                br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Input parametro = new br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Input();
                //
                String CabecMsg = "<?xml version='1.0' encoding='UTF-8'?>"
                        + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">"
                        + "<versaoDados>1.00</versaoDados>"
                        + "</cabecalho>";

//                String CabecMsg = "<nfseCabecMsg>"
//                        + "<?xml version='1.0' encoding='UTF-8'?>"
//                        + "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"0.01\">"
//                        + "<versaoDados>1.00</versaoDados>"
//                        + "</cabecalho>"
//                        + "</nfseCabecMsg>";

                parametro.setNfseCabecMsg(CabecMsg);
                //
                String DadosMsg = ""
                        // Contagem
                        //+ "<EnviarLoteRpsEnvio xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">"
                        // BH
                        + "<EnviarLoteRpsEnvio xmlns=\"http://www.abrasf.org.br/nfse.xsd\">"
                        // Contagem
                        //+ "<LoteRps id=\"12341234\">"
                        // BH
                        + "<LoteRps Id=\"12341234\" versao=\"1.00\">"
                        + "<NumeroLote>1</NumeroLote>"
                        //+ "<Cnpj>07595825000226</Cnpj>"
                        //+ "<InscricaoMunicipal>1970280023</InscricaoMunicipal>"
                        + "<Cnpj>07595825000145</Cnpj>"
                        + "<InscricaoMunicipal>72059084</InscricaoMunicipal>"
                        + "<QuantidadeRps>1</QuantidadeRps>"
                        + "<ListaRps>"
                        + XML
                        + "</ListaRps>"
                        + "</LoteRps>"
                        + "</EnviarLoteRpsEnvio>";
                
                System.out.println(DadosMsg);
                DadosMsg = assinarEnviarLoteRpsEnvio("A3", "12345678", DadosMsg);
                System.out.println("DADOS");
                System.out.println(DadosMsg);
                
                parametro.setNfseDadosMsg(DadosMsg);
                
                System.out.println("------------------------------------------");
                System.out.println(DadosMsg);
                
//                br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Output O = new br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.BH.Output();
                
                //O = nfse.gerarNfse(parametro);
                System.out.println("RETORNO BH");
                System.out.println(nfse.recepcionarLoteRps(parametro).getOutputXML());
                
                
//                // Contagem
//                // Service
//                br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM.NFSEServices service = new br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM.NFSEServices();
//                // Metodo
//                br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM.ObjectFactory RecepcionarLoteRps = new br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM.ObjectFactory();
//                // XML
//                RecepcionarLoteRps.createRecepcionarLoteRpsXmlEnvio("");
//                //
//                br.com.moveti.erpmove.fiscal.nfe.webservices.NFSE.CONTAGEM.INFSEGeracao Geracao = service.getBasicINFSEGeracao();
//                System.out.println(Geracao.recepcionarLoteRps(DadosMsg));
                
                
                


//                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
//                if (!resultado.equals("")) {
//                    msg.alertInf(resultado, "Atenção");
//                    return Resultado;
//                }
//                String xml = getXMLAssinado().replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
//                xml = xml.replace("xmlns=\"http://www.portalfiscal.inf.br/nfe\"", "");
//                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
//                        + "<enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
//                        + "<idLote>" + numeracaoLote + "</idLote>"
//                        + getXMLAssinado().replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "").replace("xmlns=\"http://www.portalfiscal.inf.br/nfe\"", "")
//                        + "</enviNFe>";
//                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
//                HNfeRecepcao2Stub.NfeDadosMsg dadosMsg = new HNfeRecepcao2Stub.NfeDadosMsg();
//                dadosMsg.setExtraElement(ome);
//                HNfeRecepcao2Stub.NfeCabecMsg nfeCabecMsg = new HNfeRecepcao2Stub.NfeCabecMsg();
//                nfeCabecMsg.setCUF(empresaCodEstado);
//                nfeCabecMsg.setVersaoDados("2.00");
//                HNfeRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeRecepcao2Stub.NfeCabecMsgE();
//                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
//                HNfeRecepcao2Stub stub = new HNfeRecepcao2Stub(url.toString());
//                HNfeRecepcao2Stub.NfeRecepcaoLote2Result result = stub.nfeRecepcaoLote2(dadosMsg, nfeCabecMsgE);
//                Resultado = result.getExtraElement().toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
            Resultado = "FalhaComunicarSefaz";
        }
        return Resultado;
    }

    public String retornoEnviaNFe(String transmitidaNumeroRecibo) {
        String Resultado = "0";
        try {
            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("2")) {
                if ("S".equals(tipo)) {
                    url = new URL("https://hom.nfe.fazenda.gov.br/SCAN/NfeRetRecepcao2/NfeRetRecepcao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/NfeRetRecepcao2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeRetRecepcao2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetRecepcao2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetRecepcao2?wsdl");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetRecepcao2?wsdl");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRetRecepcao2");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRetRecepcao2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeRetRecepcao2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRetRecepcao2");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeRetRecepcao/NfeRetRecepcao2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeRetRecepcao2.asmx");
                    } else {
                        url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NfeRetRecepcao2/NfeRetRecepcao2.asmx");
//                } else if ("MG".equals(estado)) {
//                    url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeRetRecepcao/NfeRetRecepcao2.asmx");
                    }
                }
            } else {
                if ("S".equals(tipo)) {
                    url = new URL("https://www.scan.fazenda.gov.br/NfeRetRecepcao2/NfeRetRecepcao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeRetRecepcao2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeRetRecepcao2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetRecepcao2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetRecepcao2?wsdl");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRetRecepcao2");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeRetRecepcao2");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetRecepcao2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRetRecepcao2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://nfe2.fazenda.pr.gov.br/nfe/NFeRetRecepcao2?wsdl");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://nfe.sefaz.rs.gov.br/ws/NfeRetRecepcao/NfeRetRecepcao2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nferetrecepcao2.asmx");
                    } else {
                        url = new URL("https://www.sefazvirtual.fazenda.gov.br/NfeRetRecepcao2/NfeRetRecepcao2.asmx");
                    }
                }
            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                /**
                 * Xml de Consulta.
                 */
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                        + "<consReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
                        + "<tpAmb>" + configuracaoAmbienteEmissaoNf + "</tpAmb>"
                        + "<nRec>" + transmitidaNumeroRecibo + "</nRec>"
                        + "</consReciNFe>";
                //System.out.println(nfeDadosMsg);

                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeRetRecepcao2Stub.NfeDadosMsg dadosMsg = new HNfeRetRecepcao2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);

                HNfeRetRecepcao2Stub.NfeCabecMsg nfeCabecMsg = new HNfeRetRecepcao2Stub.NfeCabecMsg();
                /**
                 * Código do Estado.
                 */
                nfeCabecMsg.setCUF(empresaCodEstado);
                /**
                 * Versao do XML
                 */
                nfeCabecMsg.setVersaoDados("2.00");
                HNfeRetRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeRetRecepcao2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);

                HNfeRetRecepcao2Stub stub = new HNfeRetRecepcao2Stub(url.toString());
                HNfeRetRecepcao2Stub.NfeRetRecepcao2Result result = stub.nfeRetRecepcao2(dadosMsg, nfeCabecMsgE);


                Resultado = result.getExtraElement().toString();

            } catch (Exception e) {
                System.err.println("- +transmissoesNotaFiscal.:retornoEnviaNFe Retorno:" + e.toString());
                e.printStackTrace();
                Resultado = "FalhaComunicarSefaz";
            }
        } catch (Exception e) {
            System.err.println("- -transmissoesNotaFiscal.:retornoEnviaNFe Retorno:" + e.toString());
            Resultado = "FalhaComunicarSefaz";
        }

        System.err.println("-transmissoesNotaFiscal.:retornoEnviaNFe Retorno:" + Resultado);
        return Resultado;

    }

    public String consultarNFe(String chaveAcesso) {
        System.err.println("- Tentando transmissoesNotaFiscal.:consultarNFe");
        String Resultado = "0";

        try {
            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("2")) {

                url = new URL("https://hom.nfe.fazenda.gov.br/SCAN/NfeConsulta2/NfeConsulta2.asmx");

                if ("AM".equals(estado)) {
                    url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2");
                } else if ("BA".equals(estado)) {
                    url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeConsulta2.asmx");
                } else if ("CE".equals(estado)) {
                    url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2");
                } else if ("GO".equals(estado)) {
                    url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl");
                } else if ("MT".equals(estado)) {
                    url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl");
                } else if ("MS".equals(estado)) {
                    url = new URL("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2");
                } else if ("MG".equals(estado)) {
                    url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2");
                } else if ("PR".equals(estado)) {
                    url = new URL("https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeConsulta2?wsdl");
                } else if ("PE".equals(estado)) {
                    url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2");
                } else if ("RS".equals(estado)) {
                    url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx");
                } else if ("SP".equals(estado)) {
                    url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeConsulta2.asmx");
                } else {
                    url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx");
//                } else if ("BA".equals(estado)) {
//                    url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx");
//                } else if ("BA".equals(estado)) {

                }
            } else {

                url = new URL("https://www.scan.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx");

                if ("AM".equals(estado)) {
                    url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2");
                } else if ("BA".equals(estado)) {
                    url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeConsulta2.asmx");
                } else if ("CE".equals(estado)) {
                    url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2");
                } else if ("GO".equals(estado)) {
                    url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl");
                } else if ("MG".equals(estado)) {
                    url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2");
                } else if ("MS".equals(estado)) {
                    url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2");
                } else if ("MT".equals(estado)) {
                    url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl");
                } else if ("PE".equals(estado)) {
                    url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2");
                } else if ("PR".equals(estado)) {
                    url = new URL("https://nfe2.fazenda.pr.gov.br/nfe/NFeConsulta2?wsdl");
                } else if ("RS".equals(estado)) {
                    url = new URL("https://nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx");
                } else if ("SP".equals(estado)) {
                    url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfeconsulta2.asmx");
                } else {
                    url = new URL("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx");
//                } else if ("BA".equals(estado)) {
//                    url = new URL("https://nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx");
//                } else if ("BA".equals(estado)) {

                }

            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                /**
                 * Xml de Consulta.
                 */
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> "
                        //                        + "<consSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"" + Login._sessao.configuracao.getVersaoAmbiente() + "\">"
                        + "<consSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.01\">"
                        + "<tpAmb>" + configuracaoAmbienteEmissaoNf + "</tpAmb> "
                        + "<xServ>CONSULTAR</xServ> "
                        + "<chNFe>" + chaveAcesso + "</chNFe> "
                        + "</consSitNFe>";

                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeConsulta2Stub.NfeDadosMsg dadosMsg = new HNfeConsulta2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);

                HNfeConsulta2Stub.NfeCabecMsg nfeCabecMsg = new HNfeConsulta2Stub.NfeCabecMsg();
                /**
                 * Código do Estado.
                 */
                nfeCabecMsg.setCUF(empresaCodEstado);
                /**
                 * Versao do XML
                 */
                nfeCabecMsg.setVersaoDados("2.01");
                HNfeConsulta2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeConsulta2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);

                HNfeConsulta2Stub stub = new HNfeConsulta2Stub(url.toString());
                HNfeConsulta2Stub.NfeConsultaNF2Result result = stub.nfeConsultaNF2(dadosMsg, nfeCabecMsgE);

                Resultado = result.getExtraElement().toString();

            } catch (Exception e) {
                System.err.println("- +transmissoesNotaFiscal.:consultarNFe Retorno:" + e.toString());
                e.printStackTrace();
                Resultado = "FalhaComunicarSefaz";
            }
        } catch (Exception e) {
            System.err.println("- -transmissoesNotaFiscal.:consultarNFe Retorno:" + e.toString());
            Resultado = "FalhaComunicarSefaz";
        }
        System.err.println("-transmissoesNotaFiscal.:consultarNFe Retorno:" + Resultado);
        return Resultado;
    }

    public String assinarCancNFe(String TipoCertificado, String Senha, String XML) throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            Node element = doc.getDocumentElement().getFirstChild();
            Element el = (Element) element;
            String id = el.getAttribute("Id");
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);
//            KeyStore ks = KeyStore.getInstance("PKCS12");
//            char[] pin;
//            p = null;
//            Provider p2[];
//            stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());
//            if (TipoCertificado.equals("A1")) {
//                pin = senhaCertificado.toCharArray();
//                ks = KeyStore.getInstance("PKCS12");
//                ks.load(new FileInputStream(configuracaoCertificadoA1.replace("\\", "\\\\")), pin);
//            } else {
//                p = new sun.security.pkcs11.SunPKCS11(stream);
//                Security.addProvider(p);
//                ks = KeyStore.getInstance("pkcs11");
//                try {
//                    ks.load(null, senhaCertificado.toCharArray());
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
            String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
            if (!resultado.equals("")) {
                msg.alertInf(resultado, "Atenção");
                return "";
            }
            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;
            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }
            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
            XMLSignature signature = fac.newXMLSignature(si, ki);
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));
            return os.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

    }
    // Cancelar Nota Fiscal

    public String cancelarNFe(String chaveAcesso, String transmitidaProtocoloAutorizacao, String motivoCancelamento) {
        String Resultado = "0";
        System.err.println("- Tentando transmissoesNotaFiscal.:cancelarNFe:");
        try {
            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("1")) {
                if ("S".equals(tipo)) {
                    url = new URL("https://www.scan.fazenda.gov.br/NfeCancelamento2/NfeCancelamento2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeCancelamento2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeCancelamento2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeCancelamento2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeCancelamento2?wsdl");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeCancelamento2");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeCancelamento2");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeCancelamento2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeCancelamento2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://nfe2.fazenda.pr.gov.br/nfe/NFeCancelamento2?wsdl");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://nfe.sefaz.rs.gov.br/ws/NfeCancelamento/NfeCancelamento2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfecancelamento2.asmx");
                    } else {
                        url = new URL("https://www.sefazvirtual.fazenda.gov.br/NfeCancelamento2/NfeCancelamento2.asmx");
//                } else if ("BA".equals(estado)) {
//                    url = new URL("https://nfe.sefazvirtual.rs.gov.br/ws/NfeCancelamento/NfeCancelamento2.asmx");
//                } else if ("BA".equals(estado)) {

                    }
                }
            } else {
                if ("S".equals(tipo)) {

                    url = new URL("https://hom.nfe.fazenda.gov.br/SCAN/NfeCancelamento2/NfeCancelamento2.asmx");
                } else {

                    if ("AM".equals(estado)) {
                        url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/NfeCancelamento2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeCancelamento2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeCancelamento2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeCancelamento2?wsdl");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeCancelamento2?wsdl");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeCancelamento2");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeCancelamento2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeCancelamento2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeCancelamento2");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeCancelamento/NfeCancelamento2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeCancelamento2.asmx");
                    } else {
                        url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NfeCancelamento2/NfeCancelamento2.asmx");
//                } else if ("BA".equals(estado)) {
//                    url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeCancelamento/NfeCancelamento2.asmx");
//                } else if ("BA".equals(estado)) {
//                    
                    }

                }

            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                String cabecMsgEnvia = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<cabecMsg xmlns=\"http://www.portalfiscal.inf.br/nfe\" "
                        + "versao=\"1.02\">" + "<versaoDados>" + getConfiguracaoVersaoAmbiente() + "</versaoDados>"
                        + "</cabecMsg>";
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> "
                        + "<cancNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
                        + "<infCanc Id=\"ID" + chaveAcesso + "\">"
                        + "<tpAmb>" + configuracaoAmbienteEmissaoNf + "</tpAmb> "
                        + "<xServ>CANCELAR</xServ> "
                        + "<chNFe>" + chaveAcesso + "</chNFe> "
                        + "<nProt>" + transmitidaProtocoloAutorizacao + "</nProt> "
                        + "<xJust>" + motivoCancelamento + "</xJust> "
                        + "</infCanc>"
                        + "</cancNFe>";
                System.out.println(nfeDadosMsg);
                try {
                    nfeDadosMsg = this.assinarCancNFe(tipoCertificado, senhaCertificado, nfeDadosMsg);
                } catch (Exception e) {
                    System.err.println(e.toString());
                }
                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeCancelamento2Stub.NfeDadosMsg dadosMsg = new HNfeCancelamento2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);
                HNfeCancelamento2Stub.NfeCabecMsg nfeCabecMsg = new HNfeCancelamento2Stub.NfeCabecMsg();
                nfeCabecMsg.setCUF(empresaCodEstado);
                nfeCabecMsg.setVersaoDados("2.00");
                HNfeCancelamento2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeCancelamento2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
                HNfeCancelamento2Stub stub = new HNfeCancelamento2Stub(url.toString());
                HNfeCancelamento2Stub.NfeCancelamentoNF2Result result = stub.nfeCancelamentoNF2(dadosMsg, nfeCabecMsgE);
                Resultado = result.getExtraElement().toString();

            } catch (Exception e) {
                System.err.println("- **transmissoesNotaFiscal.:cancelarNFe: Erro !");
                e.printStackTrace();
                Resultado = "FalhaComunicarSefaz";

            }
        } catch (Exception e) {
            System.err.println("- *transmissoesNotaFiscal.:cancelarNFe: Retorno:" + Resultado);
            System.err.println(e.toString());
            Resultado = "FalhaComunicarSefaz";
        }

        System.err.println("- transmissoesNotaFiscal.:cancelarNFe: Retorno:" + Resultado);
        return Resultado;
    }
    // Assinar Cancelamento Nota Fiscal

    public String assinarInutNFe(String TipoCertificado, String Senha, String XML) throws Exception {
        System.err.println("- Tentando transmissoesNotaFiscal.:assinarInutNFe:");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            Node element = doc.getDocumentElement().getFirstChild();
            Element el = (Element) element;
            String id = el.getAttribute("Id");
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] pin;
            stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());
            if (TipoCertificado.equals("A1")) {
                pin = senhaCertificado.toCharArray();
                ks = KeyStore.getInstance("PKCS12");
                ks.load(new FileInputStream(configuracaoCertificadoA1.replace("\\", "\\\\")), pin);
            } else {
                Provider p = new sun.security.pkcs11.SunPKCS11(stream);
                Security.addProvider(p);
                ks = KeyStore.getInstance("pkcs11");
                try {
                    ks.load(null, senhaCertificado.toCharArray());
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new Exception("*Senha do Certificado Digital esta incorreta ou Certificado inválido.");
                }
            }
            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;

            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }

            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
            XMLSignature signature = fac.newXMLSignature(si, ki);
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));
            return os.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            return "";
        }
    }

    // Inutilizar Nota Fiscal
    public String inutilizaNFE(String numeracaoInicial, String numeracaoFinal, String motivoInutilizacao) {
        String Resultado = "0";
        try {

            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("1")) {
                if ("S".equals(tipo)) {
                    url = new URL("https://hom.nfe.fazenda.gov.br/SCAN/NfeCancelamento2/NfeCancelamento2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeInutilizacao2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://nfe2.fazenda.pr.gov.br/nfe/NFeInutilizacao2?wsdl");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://nfe.sefaz.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfeinutilizacao2.asmx");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfeinutilizacao2.asmx");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.sefazvirtual.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://www.scan.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx");
                    }
                }
            } else {
                if ("S".equals(tipo)) {
                    url = new URL("https://hom.nfe.fazenda.gov.br/SCAN/NfeInutilizacao2/NfeInutilizacao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeInutilizacao2.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeInutilizacao2");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2");
                    } else if ("PR".equals(estado)) {
                        url = new URL("https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeInutilizacao2?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeInutilizacao2.asmx");
                    } else {
                        url = new URL("https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx");
                    }
                }
            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> "
                        + "<inutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"" + getConfiguracaoVersaoAmbiente() + "\">"
                        + "<infInut Id=\"ID" + empresaCodEstado + (new SimpleDateFormat("yy").format(new Date())) + getEmpresaCnpj().replace(".", "").replace("-", "").replace("/", "").trim() + getConfiguracaoModeloNf() + _Funcoes.FormataString(getConfiguracaoSerieNf(), 3, "0", "E") + _Funcoes.FormataString(numeracaoInicial, 9, "0", "E") + _Funcoes.FormataString(numeracaoFinal, 9, "0", "E") + "\">"
                        + "<tpAmb>" + configuracaoAmbienteEmissaoNf + "</tpAmb>"
                        + "<xServ>INUTILIZAR</xServ>"
                        + "<cUF>" + empresaCodEstado + "</cUF>"
                        + "<ano>" + new SimpleDateFormat("yy").format(new Date()) + "</ano>"
                        + "<CNPJ>" + getEmpresaCnpj().replace(".", "").replace("-", "").replace("/", "").trim() + "</CNPJ>"
                        + "<mod>" + getConfiguracaoModeloNf() + "</mod>"
                        + "<serie>" + getConfiguracaoSerieNf() + "</serie>"
                        + "<nNFIni>" + numeracaoInicial + "</nNFIni>"
                        + "<nNFFin>" + numeracaoFinal + "</nNFFin>"
                        + "<xJust>" + motivoInutilizacao + "</xJust>"
                        + "</infInut>"
                        + "</inutNFe>";
                try {
                    nfeDadosMsg = this.assinarInutNFe(tipoCertificado, senhaCertificado, nfeDadosMsg);
                    System.err.println(nfeDadosMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("- +transmissoesNotaFiscal.:inutilizaNFE Retorno:" + e.toString());
                }

                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeInutilizacao2Stub.NfeDadosMsg dadosMsg = new HNfeInutilizacao2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);

                HNfeInutilizacao2Stub.NfeCabecMsg nfeCabecMsg = new HNfeInutilizacao2Stub.NfeCabecMsg();
                nfeCabecMsg.setCUF(empresaCodEstado);
                nfeCabecMsg.setVersaoDados("2.00");
                HNfeInutilizacao2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeInutilizacao2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
                HNfeInutilizacao2Stub stub = new HNfeInutilizacao2Stub(url.toString());
                HNfeInutilizacao2Stub.NfeInutilizacaoNF2Result result = stub.nfeInutilizacaoNF2(dadosMsg, nfeCabecMsgE);
                Resultado = result.getExtraElement().toString();
            } catch (Exception e) {
                e.printStackTrace();
                Resultado = "FalhaComunicarSefaz";
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            Resultado = "FalhaComunicarSefaz";
        }
        return Resultado;
    }
    // Assinar Inutilizacao Nota Fiscal

    public String assinarInutNFe() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            Node element = doc.getDocumentElement().getFirstChild();
            Element el = (Element) element;
            String id = el.getAttribute("Id");
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] pin;
            p = null;
            Provider p2[];

            if ("A1".equals(tipoCertificado)) {
                pin = senhaCertificado.toCharArray();
                ks = KeyStore.getInstance("PKCS12");
                ks.load(new FileInputStream(configuracaoCertificadoA1.replace("\\", "\\\\")), pin);
            } else {
                p = new sun.security.pkcs11.SunPKCS11(configuracaoCertificadoA3);
                // procura e remove o ultimo provider                
                Security.addProvider(p);
//                pin = senhaCertificado.toCharArray();
                //ks = KeyStore.getInstance("PKCS11", p);
                ks = KeyStore.getInstance("pkcs11");
                try {
                    ks.load(null, senhaCertificado.toCharArray());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;
            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }
            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            // Create the KeyInfo containing the X509Data.
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            // x509Content.add(cert.getSubjectX500Principal().getName());
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            //System.err.println("Teste 04 ");
            // doc.getDocumentElement().removeAttribute("xmlns:ns2");
            // ((Element)
            // doc.getDocumentElement().getElementsByTagName("NFe").item(0))
            // .setAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe");

            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.

            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            //System.err.println("Teste 05 ");
            // Create the SignedInfo.
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));

            // Create the XMLSignature, but don't sign it yet.
            XMLSignature signature = fac.newXMLSignature(si, ki);
            // Marshal, generate, and sign the enveloped signature.
            // Create a DOMSignContext and specify the RSA PrivateKey and
            // location of the resulting XMLSignature's parent element.
            System.err.println(signature.toString());
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);

            // Output the resulting document.
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));

            //this.setNotaFiscalXMLAssinada(new StringBuffer(os.toString()));
            if (!"A1".equals(tipoCertificado)) {
                //Security.removeProvider(p.getName());
            }
            return os.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public String assinarRaiz_CartaCorrecao() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Document docs = builder.parse(new File(
            // "c:/xml/430802017886010001735500000000010000030371-nfe.xml"));
            //System.err.println(getNotaFiscalXML());            
            Document doc = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            //Document doc = builder.parse(new ByteArrayInputStream(getNotaFiscalXML().toString().getBytes()));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            //NodeList elements = doc.getElementsByTagName("infCanc");
            //Node element = doc.getDocumentElement().getFirstChild().getNextSibling();
            NodeList elements = doc.getElementsByTagName("infEvento");
            // elements.getLength();            
            //Element el = (Element) element;
            Element el = (Element) elements.item(0);
            // Element el =
            // doc.getDocumentElement().getFirstChild().getChildNodes();
            String id = el.getAttribute("Id");

            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.        
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            // Create a Reference to the enveloped document (in this case,
            // you are signing the whole document, so a URI of "" signifies
            // that, and also specify the SHA1 digest algorithm and
            // the ENVELOPED Transform.
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);
            // Load the KeyStore and get the signing key and certificate.
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] pin;
            stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());
            if ("A1".equals(tipoCertificado)) {
                pin = senhaCertificado.toCharArray();
                ks = KeyStore.getInstance("PKCS12");
                ks.load(new FileInputStream(configuracaoCertificadoA1.replace("\\", "\\\\")), pin);
            } else {
                Provider p = new sun.security.pkcs11.SunPKCS11(stream);
                Security.addProvider(p);
                ks = KeyStore.getInstance("pkcs11");
                try {
                    ks.load(null, senhaCertificado.toCharArray());
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new Exception("*Senha do Certificado Digital esta incorreta ou Certificado inválido.");
                }
            }
            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;

            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }
            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            // Create the KeyInfo containing the X509Data.
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            // x509Content.add(cert.getSubjectX500Principal().getName());
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
            XMLSignature signature = fac.newXMLSignature(si, ki);
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));
//            if (!"A1".equals(tipoCertificado)) {
//                Security.removeProvider(p.getName());
//            }
            return os.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String assinarRaizEvento() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Document docs = builder.parse(new File(
            // "c:/xml/430802017886010001735500000000010000030371-nfe.xml"));
            //System.err.println(getNotaFiscalXML());            
            System.out.println("XML --- " + XML);
            Document doc = builder.parse(new ByteArrayInputStream(XML.getBytes("UTF-8")));
            //Document doc = builder.parse(new ByteArrayInputStream(getNotaFiscalXML().toString().getBytes()));
            doc.setXmlStandalone(true);
            doc.getDocumentElement().removeAttribute("xmlns:ns2");
            //NodeList elements = doc.getElementsByTagName("infCanc");
            //Node element = doc.getDocumentElement().getFirstChild().getNextSibling();
            NodeList elements = doc.getElementsByTagName("infEvento");
            // elements.getLength();            
            //Element el = (Element) element;
            Element el = (Element) elements.item(0);
            // Element el =
            // doc.getDocumentElement().getFirstChild().getChildNodes();
            String id = el.getAttribute("Id");

            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.        
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            // Create a Reference to the enveloped document (in this case,
            // you are signing the whole document, so a URI of "" signifies
            // that, and also specify the SHA1 digest algorithm and
            // the ENVELOPED Transform.
            ArrayList transformList = new ArrayList();
            TransformParameterSpec tps = null;
            Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED, tps);
            Transform c14NTransform = fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

            transformList.add(envelopedTransform);
            transformList.add(c14NTransform);
            this.buscarDadosCertificado();
            // Load the KeyStore and get the signing key and certificate.
//            KeyStore ks = KeyStore.getInstance("PKCS12");
//            char[] pin;
//            p = null;
//            Provider p2[];

            //stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());

//            if ("A1".equals(tipoCertificado)) {
//                pin = senhaCertificado.toCharArray();
//                ks = KeyStore.getInstance("PKCS12");
//                ks.load(new FileInputStream(configuracaoCertificadoA1.replace("\\", "\\\\")), pin);
//            } else {
//                p = new sun.security.pkcs11.SunPKCS11(configuracaoCertificadoA3);
//                Security.addProvider(p);
//                ks = KeyStore.getInstance("pkcs11");
//                try {
//                    ks.load(null, senhaCertificado.toCharArray());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    throw new Exception("-++ Senha do Certificado Digital esta incorreta ou Certificado inválido.");
//                }
//            }
            KeyStore.PrivateKeyEntry pkEntry = null;
            Enumeration aliasesEnum = ks.aliases();
            PrivateKey privateKey = null;
            if (aliasCertificado.isEmpty()) {
                while (aliasesEnum.hasMoreElements()) {
                    aliasCertificado = (String) aliasesEnum.nextElement();
                    if (ks.isKeyEntry(aliasCertificado)) {
                        pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                                senhaCertificado.toCharArray()));
                        privateKey = pkEntry.getPrivateKey();
                        break;
                    }
                }
            } else {
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliasCertificado, new KeyStore.PasswordProtection(
                        senhaCertificado.toCharArray()));
                privateKey = pkEntry.getPrivateKey();
            }
            X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
            // Create the KeyInfo containing the X509Data.
            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            // x509Content.add(cert.getSubjectX500Principal().getName());
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
            Reference ref = fac.newReference("#" + id, fac.newDigestMethod(
                    DigestMethod.SHA1, null), transformList, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(
                    CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));
            XMLSignature signature = fac.newXMLSignature(si, ki);
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
            signature.sign(dsc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(os));
//            if (!"A1".equals(tipoCertificado)) {
//                Security.removeProvider(p.getName());
//            }
            return os.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void buscarDadosConfiguracaoEmpresa() {
        // Busca dados no NFeCacerts
        String Path = new crncomp.parametros._verificaParametro(11).getValorString();
        arquivoCacertsGeradoTodosOsEstados = Path + File.separator + "NFeCacertsss";

        System.out.println("CAMINHO CONFIGURAÇÃO PARA NFECERTS: " + arquivoCacertsGeradoTodosOsEstados);

        //if (crncomp._sessao.hostServidor.equals(crncomp._sessao.hostPadraoVerificaEspecial.toLowerCase())) {
        arquivoCacertsGeradoTodosOsEstados = "C:\\PROJETO\\storeadmin\\NFeCacertsss";
        configuracaoCertificadoA3 = "name = SmartCard<BR>library = c:\\windows\\system32\\ngp11v211.dll".replace("<BR>", "\n");
        senhaCertificado = "12345678";
        //}

        System.out.println("CAMINHO ARQUIVO CADEIAS TODOS OS CERTIFICADOS (NFeCacertsss): " + arquivoCacertsGeradoTodosOsEstados);
    }

    public String buscarDadosCertificado() {
        this.buscarDadosConfiguracaoEmpresa();
        String retorno = "";
        try {
            System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            X509Certificate certificate = null;
            PrivateKey privateKey = null;
            if ("A1".equals(tipoCertificado)) {
                try {
                    InputStream entrada = new FileInputStream(configuracaoCertificadoA1.replace("\\", "\\\\"));
                    ks = KeyStore.getInstance("pkcs12");
                    try {
                        ks.load(entrada, senhaCertificado.toCharArray());
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new Exception("Senha do Certificado Digital esta incorreta ou Certificado inválido.");
                    }
                    Enumeration<String> aliasesEnum = ks.aliases();
                    if (aliasCertificado.isEmpty()) {
                        while (aliasesEnum.hasMoreElements()) {
                            aliasCertificado = (String) aliasesEnum.nextElement();
                            certificate = (X509Certificate) ks.getCertificate(aliasCertificado);
                            privateKey = (PrivateKey) ks.getKey(aliasCertificado, senhaCertificado.toCharArray());
                            break;

                        }
                    } else {
                        certificate = (X509Certificate) ks.getCertificate(aliasCertificado);
                        privateKey = (PrivateKey) ks.getKey(aliasCertificado, senhaCertificado.toCharArray());
                    }

                    SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);
                    socketFactoryDinamico.setFileCacerts(arquivoCacertsGeradoTodosOsEstados);
                    setProtocoloAdicionado(true);
                    Protocol protocol = new Protocol("https", socketFactoryDinamico, SSL_PORT);
                    Protocol.registerProtocol("https", protocol);
                    System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
                    System.setProperty("javax.net.ssl.keyStore", configuracaoCertificadoA1.replace("\\", "\\\\"));
                    System.setProperty("javax.net.ssl.keyStorePassword", senhaCertificado);

                } catch (Exception e) {
                    e.printStackTrace();
                    retorno = e.toString();
                }
            } else {
                System.out.println(configuracaoCertificadoA3);
                stream = new ByteArrayInputStream(configuracaoCertificadoA3.getBytes());
//                System.out.println(configuracaoCertificadoA3);
//                System.out.println(senhaCertificado);
                p = new sun.security.pkcs11.SunPKCS11(stream);
                Security.addProvider(p);
                ks = KeyStore.getInstance("pkcs11");
                try {
                    ks.load(null, senhaCertificado.toCharArray());
                } catch (Exception ex) {
                    System.out.println("PROBLEMA EM CARREGAR CERTIFICADO (SENHA) ");
                    ex.printStackTrace();
                }

                //String alias = "";
                Enumeration<String> aliasesEnum = ks.aliases();
                if (aliasCertificado.isEmpty()) {
                    while (aliasesEnum.hasMoreElements()) {
                        aliasCertificado = (String) aliasesEnum.nextElement();
                        certificate = (X509Certificate) ks.getCertificate(aliasCertificado);
                        privateKey = (PrivateKey) ks.getKey(aliasCertificado, senhaCertificado.toCharArray());
                        break;

                    }
                } else {
                    certificate = (X509Certificate) ks.getCertificate(aliasCertificado);
                    privateKey = (PrivateKey) ks.getKey(aliasCertificado, senhaCertificado.toCharArray());
                }

                System.setProperty("javax.net.ssl.keyStoreType", ks.getType());
                System.setProperty("javax.net.ssl.keyStoreProvider", ks.getProvider().getName());
                certificate = (X509Certificate) ks.getCertificate(aliasCertificado);
                privateKey = (PrivateKey) ks.getKey(aliasCertificado, senhaCertificado.toCharArray());
                SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);
                socketFactoryDinamico.setFileCacerts(arquivoCacertsGeradoTodosOsEstados);
                setProtocoloAdicionado(true);
                Protocol protocol = new Protocol("https", socketFactoryDinamico, SSL_PORT);
                Protocol.registerProtocol("https", protocol);
                System.setProperty("javax.net.ssl.trustStoreType", "JKS");
                System.setProperty("javax.net.ssl.trustStore", arquivoCacertsGeradoTodosOsEstados);
            }
        } catch (Exception e) {
            e.printStackTrace();
            retorno = e.toString();
        }
        return retorno;
    }

    public String enviaCCe(int idLote) {
        String Resultado = "0";
        try {
            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("2")) {

                if ("S".equals(tipo)) {
                    url = new URL("https://www.scan.fazenda.gov.br/NfeRecepcao2/NfeRecepcao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/sre/nferecepcaoevento.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRecepcaoEvento?wsdl");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRecepcaoEvento");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://homologacao.nfe.sefaz.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/eventosWEB/services/RecepcaoEvento.asmx");
                    } else {
                        url = new URL("https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx");
                    }
                }
            } else {
                if ("S".equals(tipo)) {
                    url = new URL("https://www.scan.fazenda.gov.br/NfeRecepcao2/NfeRecepcao2.asmx");
                } else {
                    if ("AM".equals(estado)) {
                        url = new URL("https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento");
                    } else if ("BA".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ba.gov.br/webservices/sre/nferecepcaoevento.asmx");
                    } else if ("CE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento");
                    } else if ("GO".equals(estado)) {
                        url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRecepcaoEvento?wsdl");
                    } else if ("MG".equals(estado)) {
                        url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRecepcaoEvento");
                    } else if ("MS".equals(estado)) {
                        url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeRecepcaoEvento");
                    } else if ("MT".equals(estado)) {
                        url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl");
                    } else if ("PE".equals(estado)) {
                        url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento");
                    } else if ("RS".equals(estado)) {
                        url = new URL("https://nfe.sefaz.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx");
                    } else if ("SP".equals(estado)) {
                        url = new URL("https://nfe.fazenda.sp.gov.br/eventosWEB/services/RecepcaoEvento.asmx");
                    } else {
                        url = new URL("https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx");
                    }
                }
            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                        + "<envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.00\">"
                        + "<idLote>" + idLote + "</idLote>"
                        + getXMLEventoCCe().substring(38)
                        + "</envEvento>";
                System.err.println(nfeDadosMsg);
                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeCartaCorrecao2Stub.NfeDadosMsg dadosMsg = new HNfeCartaCorrecao2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);
                HNfeCartaCorrecao2Stub.NfeCabecMsg nfeCabecMsg = new HNfeCartaCorrecao2Stub.NfeCabecMsg();
                nfeCabecMsg.setCUF(empresaCodEstado);
                nfeCabecMsg.setVersaoDados("1.00");
                HNfeCartaCorrecao2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeCartaCorrecao2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
                HNfeCartaCorrecao2Stub stub = new HNfeCartaCorrecao2Stub(url.toString());
                HNfeCartaCorrecao2Stub.NfeCartaCorrecao2Result result = stub.nfeCartaCorrecao2(dadosMsg, nfeCabecMsgE);
                Resultado = result.getExtraElement().toString();
                System.err.println(Resultado);
            } catch (Exception e) {
                e.printStackTrace();
                Resultado = "FalhaComunicarSefaz";
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            Resultado = "FalhaComunicarSefaz";
        }
        return Resultado;
    }

    public String consultaCadastro(String clienteCpf, String clienteCnpj, String clienteInscricaoEstadual, String clienteEstado) {
        String Resultado = "0";
        try {
            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("2")) {
                if ("AM".equals(estado)) {
                    url = new URL("https://nfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2");
                } else if ("BA".equals(estado)) {
                    url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx");
                } else if ("CE".equals(estado)) {
                    url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2");
                } else if ("GO".equals(estado)) {
                    url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl");
                } else if ("MG".equals(estado)) {
                    url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2");
                } else if ("MS".equals(estado)) {
                    url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/CadConsultaCadastro2");
                } else if ("MT".equals(estado)) {
                    url = new URL("https://nfe.sefaz.mt.gov.br/nfews/CadConsultaCadastro");
                } else if ("PE".equals(estado)) {
                    url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2");
                } else if ("RS".equals(estado)) {
                    url = new URL("https://sef.sefaz.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx");
                } else if ("SP".equals(estado)) {
                    url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/cadconsultacadastro2.asmx");
                }
            } else {
                if ("AM".equals(estado)) {
                    url = new URL("https://homnfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2");
                } else if ("BA".equals(estado)) {
                    url = new URL("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx");
                } else if ("CE".equals(estado)) {
                    url = new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2");
                } else if ("GO".equals(estado)) {
                    url = new URL("https://homolog.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl");
                } else if ("MS".equals(estado)) {
                    url = new URL("https://homologacao.nfe.ms.gov.br/homologacao/services2/CadConsultaCadastro2");
                } else if ("MG".equals(estado)) {
                    url = new URL("https://hnfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2");
                } else if ("SP".equals(estado)) {
                    url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/CadConsultaCadastro2.asmx");
                }
            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\" ?> "
                        + "<consCad xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"" + getConfiguracaoVersaoAmbiente() + "\">"
                        + "<infCons>"
                        + "<xServ>CONS-CAD</xServ> "
                        + "<UF>" + clienteEstado + "</UF> "
                        + "<IE>" + clienteInscricaoEstadual + "</IE> "
                        + "<CNPJ>" + clienteCnpj + "</CNPJ> "
                        + "<CPF>" + clienteCpf + "</CPF> "
                        + "</infCons>"
                        + "</consCad>";

                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeConsulta2Stub.NfeDadosMsg dadosMsg = new HNfeConsulta2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);
                HNfeConsulta2Stub.NfeCabecMsg nfeCabecMsg = new HNfeConsulta2Stub.NfeCabecMsg();
                nfeCabecMsg.setCUF(empresaCodEstado);
                nfeCabecMsg.setVersaoDados("2.00");
                HNfeConsulta2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeConsulta2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
                HNfeConsulta2Stub stub = new HNfeConsulta2Stub(url.toString());
                HNfeConsulta2Stub.NfeConsultaNF2Result result = stub.nfeConsultaNF2(dadosMsg, nfeCabecMsgE);
            } catch (Exception e) {
                e.printStackTrace();
                Resultado = "FalhaComunicarSefaz";
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            Resultado = "FalhaComunicarSefaz";
        }
        return Resultado;
    }

    public String statusServico(String TipoCertificado, String senhaCertificado) {
        String Resultado = "0";
        try {
            String codigoDoEstado = "";
            URL url = null;
            if (configuracaoAmbienteEmissaoNf.equals("2")) {
                url = new URL("https://www.scan.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx");
                if ("AM".equals(estado)) {
                    url = new URL("https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2");
                } else if ("BA".equals(estado)) {
                    url = new URL("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeStatusServico2.asmx");
                } else if ("CE".equals(estado)) {
                    url = new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2");
                } else if ("GO".equals(estado)) {
                    url = new URL("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl");
                } else if ("MG".equals(estado)) {
                    url = new URL("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatus2");
                } else if ("MS".equals(estado)) {
                    url = new URL("https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2");
                } else if ("MT".equals(estado)) {
                    url = new URL("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl");
                } else if ("PE".equals(estado)) {
                    url = new URL("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2");
                } else if ("PR".equals(estado)) {
                    url = new URL("https://nfe2.fazenda.pr.gov.br/nfe/NFeStatusServico2?wsdl");
                } else if ("RS".equals(estado)) {
                    url = new URL("https://nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx");
                } else if ("SP".equals(estado)) {
                    url = new URL("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfestatusservico2.asmx");
                } else {
                    url = new URL("https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx");
                }
            }
            // Realiza a conexao com WebService
            try {
                String resultado = validacoesNotaFiscal.validarExceptions(this.buscarDadosCertificado());
                if (!resultado.equals("")) {
                    msg.alertInf(resultado, "Atenção");
                    return Resultado;
                }
                String nfeDadosMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                        + "<consStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" " + " versao=\"" + getConfiguracaoVersaoAmbiente() + "\">"
                        + "<tpAmb>" + configuracaoAmbienteEmissaoNf + "</tpAmb>"
                        + "<cUF>" + empresaCodEstado + "</cUF>"
                        //+ "<cUF>51</cUF>"
                        + "<xServ>STATUS</xServ>"
                        + "</consStatServ>";

                OMElement ome = AXIOMUtil.stringToOM(nfeDadosMsg);
                HNfeStatusServico2Stub.NfeDadosMsg dadosMsg = new HNfeStatusServico2Stub.NfeDadosMsg();
                dadosMsg.setExtraElement(ome);
                HNfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new HNfeStatusServico2Stub.NfeCabecMsg();
                nfeCabecMsg.setCUF(empresaCodEstado);
                nfeCabecMsg.setVersaoDados("2.00");
                HNfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new HNfeStatusServico2Stub.NfeCabecMsgE();
                nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
                HNfeStatusServico2Stub stub = new HNfeStatusServico2Stub(url.toString());
                HNfeStatusServico2Stub.NfeStatusServicoNF2Result result = stub.nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);
                Resultado = (result.getExtraElement().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            Resultado = "FalhaComunicarSefaz";
        }
        return Resultado;
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }

    public String getXMLAssinado() {
        return XMLAssinado;
    }

    public void setXMLAssinado(String XMLAssinado) {
        this.XMLAssinado = XMLAssinado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public void setSenhaCertificado(String senhaCertificado) {
        this.senhaCertificado = senhaCertificado;
    }

    public void setconfiguracaoCertificadoA1(String configuracaoCertificadoA1) {
        this.configuracaoCertificadoA1 = configuracaoCertificadoA1;
    }

    public void setConfiguracaoCertificadoA3(String configuracaoCertificadoA3) {
        this.configuracaoCertificadoA3 = configuracaoCertificadoA3;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConfiguracaoVersaoAmbiente() {
        return configuracaoVersaoAmbiente;
    }

    public void setConfiguracaoVersaoAmbiente(String confVersaoAmbiente) {
        this.configuracaoVersaoAmbiente = confVersaoAmbiente;
    }

    public String getConfiguracaoModeloNf() {
        return configuracaoModeloNf;
    }

    public void setConfiguracaoModeloNf(String confModeloNf) {
        this.configuracaoModeloNf = confModeloNf;
    }

    public void setConfiguracaoAmbienteEmissaoNf(String confAmbienteEmissaoNf) {
        this.configuracaoAmbienteEmissaoNf = confAmbienteEmissaoNf;
    }

    public void setEmpresaCodEstado(String empresaCodEstado) {
        this.empresaCodEstado = empresaCodEstado;
    }

    public String getEmpresaCnpj() {
        return empresaCnpj;
    }

    public void setEmpresaCnpj(String empresaCnpj) {
        this.empresaCnpj = empresaCnpj;
    }

    public String getConfiguracaoSerieNf() {
        return configuracaoSerieNf;
    }

    public void setConfiguracaoSerieNf(String confSerieNf) {
        this.configuracaoSerieNf = confSerieNf;
    }

    public boolean isProtocoloAdicionado() {
        return ProtocoloAdicionado;
    }

    public void setProtocoloAdicionado(boolean ProtocoloAdicionado) {
        this.ProtocoloAdicionado = ProtocoloAdicionado;
    }

    public String getXMLEventoCCe() {
        return XMLEventoCCe;
    }

    public void setXMLEventoCCe(String XMLEventoCCe) {
        this.XMLEventoCCe = XMLEventoCCe;
    }

    public String getAliasCertificado() {
        return aliasCertificado;
    }

    public void setAliasCertificado(String aliasCertificado) {
        this.aliasCertificado = aliasCertificado;
    }
}
