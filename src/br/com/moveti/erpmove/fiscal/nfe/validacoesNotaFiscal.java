/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe;

import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetCancNFe;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetCancNFeH;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetConsReciNFeFalha;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetConsReciNFeRecebimento;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetConsSitNFe;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetConsSitNFeFalha;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetConsSitNFeCancelamento;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetConsSitNFeEvento;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetEnviNFe;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetInutNFe;
import br.com.moveti.erpmove.fiscal.nfe.webservices.XMLSNFE200.XmlRetInutNFeH;

/**
 *
 * @author henriquelacerda
 */
public class validacoesNotaFiscal {

    private String notaFiscalXML = "";
    private String notaFiscalXMLAssinada = "";

    public static String validarCodigoStatus(String cStat) {
        if (cStat.equals("100")) {
            return "Autorizado o uso da NF-e";
        }
        if (cStat.equals("101")) {
            return "Cancelamento de NF-e homologado";
        }
        if (cStat.equals("102")) {
            return "Inutilização de número homologado";
        }
        if (cStat.equals("103")) {
            return "Lote recebido com sucesso";
        }
        if (cStat.equals("104")) {
            return "Lote processado";
        }
        if (cStat.equals("105")) {
            return "Lote em processamento";
        }
        if (cStat.equals("106")) {
            return "Lote não localizado";
        }
        if (cStat.equals("107")) {
            return "Serviço em Operação";
        }
        if (cStat.equals("108")) {
            return "Serviço Paralisado Momentaneamente (curto prazo)";
        }
        if (cStat.equals("109")) {
            return "Serviço Paralisado sem Previsão";
        }
        if (cStat.equals("110")) {
            return "Uso Denegado";
        }
        if (cStat.equals("111")) {
            return "Consulta cadastro com uma ocorrência";
        }
        if (cStat.equals("112")) {
            return "Consulta cadastro com mais de uma ocorrência";
        }
        if (cStat.equals("201")) {
            return "Rejeição: O numero máximo de numeração de NF-e a inutilizar ultrapassou o limite";
        }
        if (cStat.equals("202")) {
            return "Rejeição: Falha no reconhecimento da autoria ou integridade do arquivo digital";
        }
        if (cStat.equals("203")) {
            return "Rejeição: Emissor não habilitado para emissão da NF-e";
        }
        if (cStat.equals("204")) {
            return "Rejeição: Duplicidade de NF-e";
        }
        if (cStat.equals("205")) {
            return "Rejeição: NF-e está denegada na base de dados da SEFAZ";
        }
        if (cStat.equals("206")) {
            return "Rejeição: NF-e já está inutilizada na Base de dados da SEFAZ";
        }
        if (cStat.equals("207")) {
            return "Rejeição: CNPJ do emitente inválido";
        }
        if (cStat.equals("208")) {
            return "Rejeição: CNPJ do destinatário inválido";
        }
        if (cStat.equals("209")) {
            return "Rejeição: IE do emitente inválida";
        }
        if (cStat.equals("210")) {
            return "Rejeição: IE do destinatário inválida";
        }
        if (cStat.equals("211")) {
            return "Rejeição: IE do substituto inválida";
        }
        if (cStat.equals("212")) {
            return "Rejeição: Data de emissão NF-e posterior a data de recebimento";
        }
        if (cStat.equals("213")) {
            return "Rejeição: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital";
        }
        if (cStat.equals("214")) {
            return "Rejeição: Tamanho da mensagem excedeu o limite estabelecido";
        }
        if (cStat.equals("215")) {
            return "Rejeição: Falha no schema XML";
        }
        if (cStat.equals("216")) {
            return "Rejeição: Chave de Acesso difere da cadastrada";
        }
        if (cStat.equals("217")) {
            return "Rejeição: NF-e não consta na base de dados da SEFAZ";
        }
        if (cStat.equals("218")) {
            return "Rejeição: NF-e já esta cancelada na base de dados da SEFAZ";
        }
        if (cStat.equals("219")) {
            return "Rejeição: Circulação da NF-e verificada";
        }
        if (cStat.equals("220")) {
            return "Rejeição: NF-e autorizada há mais de 7 dias (168 horas)";
        }
        if (cStat.equals("221")) {
            return "Rejeição: Confirmado o recebimento da NF-e pelo destinatário";
        }
        if (cStat.equals("222")) {
            return "Rejeição: Protocolo de Autorização de Uso difere do cadastrado";
        }
        if (cStat.equals("223")) {
            return "Rejeição: CNPJ do transmissor do lote difere do CNPJ do transmissor da consulta";
        }
        if (cStat.equals("224")) {
            return "Rejeição: A faixa inicial é maior que a faixa final";
        }
        if (cStat.equals("225")) {
            return "Rejeição: Falha no Schema XML da NFe";
        }
        if (cStat.equals("226")) {
            return "Rejeição: Código da UF do Emitente diverge da UF autorizadora";
        }
        if (cStat.equals("227")) {
            return "Rejeição: Erro na Chave de Acesso - Campo ID";
        }
        if (cStat.equals("228")) {
            return "Rejeição: Data de Emissão muito atrasada";
        }
        if (cStat.equals("229")) {
            return "Rejeição: IE do emitente não informada";
        }
        if (cStat.equals("230")) {
            return "Rejeição: IE do emitente não cadastrada";
        }
        if (cStat.equals("231")) {
            return "Rejeição: IE do emitente não vinculada ao CNPJ";
        }
        if (cStat.equals("232")) {
            return "Rejeição: IE do destinatário não informada";
        }
        if (cStat.equals("233")) {
            return "Rejeição: IE do destinatário não cadastrada";
        }
        if (cStat.equals("234")) {
            return "Rejeição: IE do destinatário não vinculada ao CNPJ";
        }
        if (cStat.equals("235")) {
            return "Rejeição: Inscrição SUFRAMA inválida";
        }
        if (cStat.equals("236")) {
            return "Rejeição: Chave de Acesso com dígito verificador inválido";
        }
        if (cStat.equals("237")) {
            return "Rejeição: CPF do destinatário inválido";
        }
        if (cStat.equals("238")) {
            return "Rejeição: Cabeçalho - Versão do arquivo XML superior a Versão vigente";
        }
        if (cStat.equals("239")) {
            return "Rejeição: Cabeçalho - Versão do arquivo XML não suportada";
        }
        if (cStat.equals("240")) {
            return "Rejeição: Cancelamento/Inutilização - Irregularidade Fiscal do Emitente";
        }
        if (cStat.equals("241")) {
            return "Rejeição: Um número da faixa já foi utilizado";
        }
        if (cStat.equals("242")) {
            return "Rejeição: Cabeçalho - Falha no Schema XML";
        }
        if (cStat.equals("243")) {
            return "Rejeição: XML Mal Formado";
        }
        if (cStat.equals("244")) {
            return "Rejeição: CNPJ do Certificado Digital difere do CNPJ da Matriz e do CNPJ do Emitente";
        }
        if (cStat.equals("245")) {
            return "Rejeição: CNPJ Emitente não cadastrado";
        }
        if (cStat.equals("246")) {
            return "Rejeição: CNPJ Destinatário não cadastrado";
        }
        if (cStat.equals("247")) {
            return "Rejeição: Sigla da UF do Emitente diverge da UF autorizadora";
        }
        if (cStat.equals("248")) {
            return "Rejeição: UF do Recibo diverge da UF autorizadora";
        }
        if (cStat.equals("249")) {
            return "Rejeição: UF da Chave de Acesso diverge da UF autorizadora";
        }
        if (cStat.equals("250")) {
            return "Rejeição: UF diverge da UF autorizadora";
        }
        if (cStat.equals("251")) {
            return "Rejeição: UF/Município destinatário não pertence a SUFRAMA";
        }
        if (cStat.equals("252")) {
            return "Rejeição: Ambiente informado diverge do Ambiente de recebimento";
        }
        if (cStat.equals("253")) {
            return "Rejeição: Digito Verificador da chave de acesso composta inválida";
        }
        if (cStat.equals("254")) {
            return "Rejeição: NF-e complementar não possui NF referenciada";
        }
        if (cStat.equals("255")) {
            return "Rejeição: NF-e complementar possui mais de uma NF referenciada";
        }
        if (cStat.equals("256")) {
            return "Rejeição: Uma NF-e da faixa já está inutilizada na Base de dados da SEFAZ";
        }
        if (cStat.equals("257")) {
            return "Rejeição: Solicitante não habilitado para emissão da NF-e";
        }
        if (cStat.equals("258")) {
            return "Rejeição: CNPJ da consulta inválido";
        }
        if (cStat.equals("259")) {
            return "Rejeição: CNPJ da consulta não cadastrado como contribuinte na UF";
        }
        if (cStat.equals("260")) {
            return "Rejeição: IE da consulta inválida";
        }
        if (cStat.equals("261")) {
            return "Rejeição: IE da consulta não cadastrada como contribuinte na UF";
        }
        if (cStat.equals("262")) {
            return "Rejeição: UF não fornece consulta por CPF";
        }
        if (cStat.equals("263")) {
            return "Rejeição: CPF da consulta inválido";
        }
        if (cStat.equals("264")) {
            return "Rejeição: CPF da consulta não cadastrado como contribuinte na UF";
        }
        if (cStat.equals("265")) {
            return "Rejeição: Sigla da UF da consulta difere da UF do Web Service";
        }
        if (cStat.equals("266")) {
            return "Rejeição: Série utilizada não permitida no Web Service";
        }
        if (cStat.equals("267")) {
            return "Rejeição: NF Complementar referencia uma NF-e inexistente";
        }
        if (cStat.equals("268")) {
            return "Rejeição: NF Complementar referencia uma outra NF-e Complementar";
        }
        if (cStat.equals("269")) {
            return "Rejeição: CNPJ Emitente da NF Complementar difere do CNPJ da NF Referenciada";
        }
        if (cStat.equals("270")) {
            return "Rejeição: Código Município do Fato Gerador: dígito inválido";
        }
        if (cStat.equals("271")) {
            return "Rejeição: Código Município do Fato Gerador: difere da UF do emitente";
        }
        if (cStat.equals("272")) {
            return "Rejeição: Código Município do Emitente: dígito inválido";
        }
        if (cStat.equals("273")) {
            return "Rejeição: Código Município do Emitente: difere da UF do emitente";
        }
        if (cStat.equals("274")) {
            return "Rejeição: Código Município do Destinatário: dígito inválido";
        }
        if (cStat.equals("275")) {
            return "Rejeição: Código Município do Destinatário: difere da UF do Destinatário";
        }
        if (cStat.equals("276")) {
            return "Rejeição: Código Município do Local de Retirada: dígito inválido";
        }
        if (cStat.equals("277")) {
            return "Rejeição: Código Município do Local de Retirada: difere da UF do Local de Retirada";
        }
        if (cStat.equals("278")) {
            return "Rejeição: Código Município do Local de Entrega: dígito inválido";
        }
        if (cStat.equals("279")) {
            return "Rejeição: Código Município do Local de Entrega: difere da UF do Local de Entrega";
        }
        if (cStat.equals("280")) {
            return "Rejeição: Certificado Transmissor inválido";
        }
        if (cStat.equals("281")) {
            return "Rejeição: Certificado Transmissor Data Validade";
        }
        if (cStat.equals("282")) {
            return "Rejeição: IE da consulta inválidRejeição: Certificado Transmissor sem CNPJ";
        }
        if (cStat.equals("283")) {
            return "Rejeição: Certificado Transmissor - erro Cadeia de Certificação";
        }
        if (cStat.equals("284")) {
            return "Rejeição: Certificado Transmissor revogado";
        }
        if (cStat.equals("285")) {
            return "Rejeição: Certificado Transmissor difere ICP-Brasil";
        }
        if (cStat.equals("286")) {
            return "Rejeição: Certificado Transmissor erro no acesso a LCR";
        }
        if (cStat.equals("287")) {
            return "Rejeição: Código Município do FG - ISSQN: dígito inválido";
        }
        if (cStat.equals("288")) {
            return "Rejeição: Código Município do FG - Transporte: dígito inválido";
        }
        if (cStat.equals("289")) {
            return "Rejeição: Código da UF informada diverge da UF solicitada";
        }
        if (cStat.equals("290")) {
            return "Rejeição: Certificado Assinatura inválido";
        }
        if (cStat.equals("291")) {
            return "Rejeição: Certificado Assinatura Data Validade";
        }
        if (cStat.equals("292")) {
            return "Rejeição: Certificado Assinatura sem CNPJ";
        }
        if (cStat.equals("293")) {
            return "Rejeição: Certificado Assinatura - erro Cadeia de Certificação";
        }
        if (cStat.equals("294")) {
            return "Rejeição: Certificado Assinatura revogado";
        }
        if (cStat.equals("295")) {
            return "Rejeição: Certificado Assinatura difere ICP-Brasil";
        }
        if (cStat.equals("296")) {
            return "Rejeição: Certificado Assinatura erro no acesso a LCR";
        }
        if (cStat.equals("297")) {
            return "Rejeição: Assinatura difere do calculado";
        }
        if (cStat.equals("298")) {
            return "Rejeição: Assinatura difere do padrão do Projeto";
        }
        if (cStat.equals("299")) {
            return "Rejeição: XML da área de cabeçalho com codificação diferente de UTF-8";
        }
        if (cStat.equals("401")) {
            return "Rejeição: CPF do remetente inválido";
        }
        if (cStat.equals("402")) {
            return "Rejeição: XML da área de dados com codificação diferente de UTF-8";
        }
        if (cStat.equals("403")) {
            return "Rejeição: O grupo de informações da NF-e avulsa é de uso exclusivo do Fisco";
        }
        if (cStat.equals("404")) {
            return "Rejeição: Uso de prefixo de namespace não permitido";
        }
        if (cStat.equals("405")) {
            return "Rejeição: Código do país do emitente: dígito inválido";
        }
        if (cStat.equals("406")) {
            return "Rejeição: Código do país do destinatário: dígito inválido";
        }
        if (cStat.equals("407")) {
            return "Rejeição: O CPF só pode ser informado no campo emitente para a NF-e avulsa";
        }
        if (cStat.equals("453")) {
            return "Rejeição: Ano de inutilização não pode ser superior ao Ano atual";
        }
        if (cStat.equals("454")) {
            return "Rejeição: Ano de inutilização não pode ser inferior a 2006";
        }
        if (cStat.equals("478")) {
            return "Rejeição: Local da entrega não informado para faturamento direto de veículos novos";
        }
        if (cStat.equals("999")) {
            return "Lote em processamento";
            //return "Rejeição: Erro não catalogado (informar a mensagem de erro capturado no tratamento da exceção)";
        }
        if (cStat.equals("301")) {
            return "Uso Denegado : Irregularidade fiscal do emitente";
        }
        if (cStat.equals("302")) {
            return "Uso Denegado : Irregularidade fiscal do destinatário";
        }
        if (cStat.equals("502")) {
            return "Rejeição: Erro na Chave de Acesso - Campo Id não corresponde à concatenação dos campos correspondentes";
        }
        if (cStat.equals("503")) {
            return "Rejeição: Série utilizada fora da faixa permitida no SCAN (900-999)";
        }
        if (cStat.equals("504")) {
            return "Rejeição: Data de Entrada/Saída posterior ao permitido";
        }
        if (cStat.equals("505")) {
            return "Rejeição: Data de Entrada/Saída anterior ao permitido";
        }
        if (cStat.equals("506")) {
            return "Rejeição: Data de Saída menor que a Data de Emissão";
        }
        if (cStat.equals("507")) {
            return "Rejeição: O CNPJ do destinatário/remetente não deve ser informado em operação com o exterior ";
        }
        if (cStat.equals("508")) {
            return "Rejeição: O CNPJ com conteúdo nulo só é válido em operação com exterior";
        }
        if (cStat.equals("509")) {
            return "Rejeição: Informado código de município diferente de “9999999” para operação com o exterior ";
        }
        if (cStat.equals("510")) {
            return "Rejeição: Operação com Exterior e Código País destinatário é 1058 (Brasil) ou não informado ";
        }
        if (cStat.equals("511")) {
            return "Rejeição: Não é de Operação com Exterior e Código País destinatário difere de 1058 (Brasil) ";
        }
        if (cStat.equals("512")) {
            return "Rejeição: CNPJ do Local de Retirada inválido";
        }
        if (cStat.equals("513")) {
            return "Rejeição: Código Município do Local de Retirada deve ser 9999999 para UF retirada = EX ";
        }
        if (cStat.equals("514")) {
            return "Rejeição: CNPJ do Local de Entrega inválido ";
        }
        if (cStat.equals("515")) {
            return "Rejeição: Código Município do Local de Entrega deve ser 9999999 para UF entrega = EX ";
        }
        if (cStat.equals("516")) {
            return "Rejeição: Falha no schema XML – inexiste a tag raiz esperada para a mensagem ";
        }
        if (cStat.equals("517")) {
            return "Rejeição: Falha no schema XML – inexiste atributo versao na tag raiz da mensagem ";
        }
        if (cStat.equals("518")) {
            return "Rejeição: CFOP de entrada para NF-e de saída ";
        }
        if (cStat.equals("519")) {
            return "Rejeição: CFOP de saída para NF-e de entrada ";
        }
        if (cStat.equals("520")) {
            return "Rejeição: CFOP de Operação com Exterior e UF destinatário difere de EX ";
        }
        if (cStat.equals("521")) {
            return "Rejeição: CFOP não é de Operação com Exterior e UF destinatário é EX ";
        }
        if (cStat.equals("522")) {
            return "Rejeição: CFOP de Operação Estadual e UF emitente difere UF destinatário ";
        }
        if (cStat.equals("523")) {
            return "Rejeição: CFOP não é de Operação Estadual e UF emitente igual a UF destinatário ";
        }
        if (cStat.equals("524")) {
            return "Rejeição: CFOP de Operação com Exterior e não informado NCM ";
        }
        if (cStat.equals("525")) {
            return "Rejeição: CFOP de Importação e não informado dados da DI ";
        }
        if (cStat.equals("526")) {
            return "Rejeição: CFOP de Exportação e não informado Local de Embarque ";
        }
        if (cStat.equals("527")) {
            return "Rejeição: Operação de Exportação com informação de ICMS incompatível ";
        }
        if (cStat.equals("528")) {
            return "Rejeição: Valor do ICMS difere do produto BC e Alíquota";
        }
        if (cStat.equals("529")) {
            return "Rejeição: NCM de informação obrigatória para produto tributado pelo IPI ";
        }
        if (cStat.equals("530")) {
            return "Rejeição: Operação com tributação de ISSQN sem informar a Inscrição Municipal ";
        }
        if (cStat.equals("531")) {
            return "Rejeição: Total da BC ICMS difere do somatório dos itens ";
        }
        if (cStat.equals("532")) {
            return "Rejeição: Total do ICMS difere do somatório dos itens ";
        }
        if (cStat.equals("533")) {
            return "Rejeição: Total da BC ICMS-ST difere do somatório dos itens ";
        }
        if (cStat.equals("534")) {
            return "Rejeição: Total do ICMS-ST difere do somatório dos itens ";
        }
        if (cStat.equals("535")) {
            return "Rejeição: Total do Frete difere do somatório dos itens ";
        }
        if (cStat.equals("536")) {
            return "Rejeição: Total do Seguro difere do somatório dos itens";
        }
        if (cStat.equals("537")) {
            return "Rejeição: Total do Desconto difere do somatório dos itens";
        }
        if (cStat.equals("538")) {
            return "Rejeição: Total do IPI difere do somatório dos itens ";
        }
        if (cStat.equals("539")) {
            return "Rejeição: Duplicidade de NF-e, com diferença na Chave de Acesso [99999999999999999999999999999999999999999]";
        }
        if (cStat.equals("540")) {
            return "Rejeição: CPF do Local de Retirada inválido ";
        }
        if (cStat.equals("541")) {
            return "Rejeição: CPF do Local de Entrega inválido ";
        }
        if (cStat.equals("542")) {
            return "Rejeição: CNPJ do Transportador inválido";
        }
        if (cStat.equals("543")) {
            return "Rejeição: CPF do Transportador inválido ";
        }
        if (cStat.equals("544")) {
            return "Rejeição: IE do Transportador inválida ";
        }
        if (cStat.equals("545")) {
            return "Rejeição: Falha no schema XML – versão informada na versaoDados do SOAPHeader diverge da versão da mensagem";
        }
        if (cStat.equals("546")) {
            return "Rejeição: Erro na Chave de Acesso – Campo Id – falta a literal NFe ";
        }
        if (cStat.equals("547")) {
            return "Rejeição: Dígito Verificador da Chave de Acesso da NF-e Referenciada inválido ";
        }
        if (cStat.equals("548")) {
            return "Rejeição: CNPJ da NF referenciada inválido ";
        }
        if (cStat.equals("549")) {
            return "Rejeição: CNPJ da NF referenciada de produtor inválido ";
        }
        if (cStat.equals("550")) {
            return "Rejeição: CPF da NF referenciada de produtor inválido ";
        }
        if (cStat.equals("551")) {
            return "Rejeição: IE da NF referenciada de produtor inválido ";
        }
        if (cStat.equals("552")) {
            return "Rejeição: Dígito Verificador da Chave de Acesso do CT-e Referenciado inválido ";
        }
        if (cStat.equals("553")) {
            return "Rejeição: Tipo autorizador do recibo diverge do Órgão Autorizador ";
        }
        if (cStat.equals("554")) {
            return "Rejeição: Série difere da faixa 0-899 ";
        }
        if (cStat.equals("555")) {
            return "Rejeição: Tipo autorizador do protocolo diverge do Órgão Autorizador ";
        }
        if (cStat.equals("556")) {
            return "Rejeição: Justificativa de entrada em contingência não deve ser informada para tipo de emissão normal ";
        }
        if (cStat.equals("557")) {
            return "Rejeição: A Justificativa de entrada em contingência deve ser informada";
        }
        if (cStat.equals("558")) {
            return "Rejeição: Data de entrada em contingência posterior a data de emissão ";
        }
        if (cStat.equals("559")) {
            return "Rejeição: UF do Transportador não informada ";
        }
        if (cStat.equals("560")) {
            return "Rejeição: CNPJ base do emitente difere do CNPJ base da primeira NF-e do lote recebido ";
        }
        if (cStat.equals("561")) {
            return "Rejeição: Mês de Emissão informado na Chave de Acesso difere do Mês de Emissão da NF-e ";
        }
        if (cStat.equals("562")) {
            return "Rejeição: Código Numérico informado na Chave de Acesso difere do Código Numérico da NF-e ";
        }
        if (cStat.equals("563")) {
            return "Rejeição: Já existe pedido de Inutilização com a mesma faixa de inutilização ";
        }
        if (cStat.equals("564")) {
            return "Rejeição: Total do Produto / Serviço difere do somatório dos itens ";
        }
        if (cStat.equals("565")) {
            return "Rejeição: Falha no schema XML – inexiste a tag raiz esperada para o lote de NF-e ";
        }
        if (cStat.equals("567")) {
            return "Rejeição: Falha no schema XML – versão informada na versaoDados do SOAPHeader diverge da versão do lote de NF-e ";
        }
        if (cStat.equals("568")) {
            return "Rejeição: Falha no schema XML – inexiste atributo versao na tag raiz do lote de NF-e ";
        }
        if (cStat.equals("569")) {
            return "Rejeição: Data de entrada em contingência muito atrasada ";
        }
        if (cStat.equals("570")) {
            return "Rejeição: tpEmis = 2 só é válido na contingência SCAN ";
        }
        if (cStat.equals("571")) {
            return "Rejeição: O tpEmis informado diferente de 2 para contingência SCAN ";
        }
        if (cStat.equals("409")) {
            return "Rejeição: Campo cUF inexistente no elemento nfeCabecMsg do SOAP Header ";
        }
        if (cStat.equals("410")) {
            return "Rejeição: UF informada no campo cUF não é atendida pelo Web Service ";
        }
        if (cStat.equals("411")) {
            return "Rejeição: Campo versaoDados inexistente no elemento nfeCabecMsg do SOAP Header ";
        }
        if (cStat.equals("420")) {
            return "Rejeição: Cancelamento para NF-e já cancelada ";
        }
        if (cStat.equals("450")) {
            return "Rejeição: Modelo da NF-e diferente de 55 ";
        }
        if (cStat.equals("451")) {
            return "Rejeição: Processo de emissão informado inválido ";
        }
        if (cStat.equals("452")) {
            return "Rejeição: Tipo Autorizador do Recibo diverge do Órgão Autorizador ";
        }
        if (cStat.equals("595")) {
            return "Rejeição: A versão do leiaute da NF-e utilizada não é mais válida ";
        }
        if (cStat.equals("596")) {
            return "Rejeição: Ambiente de homologação indisponível para recepção de NF-e da versão 1.10 ";
        }
        if (cStat.equals("597")) {
            return "Rejeição: NF-e emitida em ambiente de homologação com CNPJ do destinatário diferente de 99999999000191 ";
        }
        if (cStat.equals("598")) {
            return "Rejeição: NF-e emitida em ambiente de homologação com Razão Social do destinatário diferente de NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
        }
        if (cStat.equals("599")) {
            return "Rejeição: NF-e emitida em ambiente de homologação com IE do destinatário diferente de vazio";
        }
        if (cStat.equals("129")) {
            return "Rejeição: Lote de Evento Processado ";
        }
        if (cStat.equals("135")) {
            return "Rejeição: Evento registrado e vinculado a NF-e";
        }
        if (cStat.equals("136")) {
            return "Rejeição: Evento registrado, mas não vinculado a NF-e ";
        }
        if (cStat.equals("489")) {
            return "Rejeição: CNPJ informado inválido (DV ou zeros) ";
        }
        if (cStat.equals("490")) {
            return "Rejeição: CPF informado inválido (DV ou zeros) ";
        }
        if (cStat.equals("491")) {
            return "Rejeição: O tpEvento informado inválido ";
        }
        if (cStat.equals("492")) {
            return "Rejeição: O verEvento informado inválido ";
        }
        if (cStat.equals("493")) {
            return "Rejeição: Evento não atende o Schema XML específico ";
        }
        if (cStat.equals("494")) {
            return "Rejeição: Chave de Acesso inexistente ";
        }

        if (cStat.equals("501")) {
            return "Rejeição: NF-e autorizada há mais de 30 dias (720 horas) ";
        }
        if (cStat.equals("572")) {
            return "Rejeição: Erro Atributo ID do evento não corresponde a concatenação dos campos (“ID” + tpEvento + chNFe + nSeqEvento)";
        }
        if (cStat.equals("573")) {
            return "Rejeição: Duplicidade de Evento ";
        }
        if (cStat.equals("574")) {
            return "Rejeição: O autor do evento diverge do emissor da NF-e ";
        }
        if (cStat.equals("575")) {
            return "Rejeição: O autor do evento diverge do destinatário da NF-e ";
        }
        if (cStat.equals("576")) {
            return "Rejeição: O autor do evento não é um órgão autorizado a gerar o evento ";
        }
        if (cStat.equals("577")) {
            return "Rejeição: A data do evento não pode ser menor que a data de emissão da NF-e ";
        }
        if (cStat.equals("578")) {
            return "Rejeição: A data do evento não pode ser maior que a data do processamento ";
        }
        if (cStat.equals("579")) {
            return "Rejeição: A data do evento não pode ser menor que a data de autorização para NF-e não emitida em contingência ";
        }
        if (cStat.equals("580")) {
            return "Rejeição: O evento exige uma NF-e autorizada ";
        }
        if (cStat.equals("587")) {
            return "Rejeição: Usar somente o namespace padrão da NF-e ";
        }
        if (cStat.equals("588")) {
            return "Rejeição: Não é permitida a presença de caracteres de edição no início/fim da mensagem ou entre as tags da mensagem ";
        }
        if (cStat.equals("590")) {
            return "Rejeição: Informado CST para emissor do Simples Nacional (CRT=1) ";
        }
        if (cStat.equals("591")) {
            return "Rejeição: Informado CSOSN para emissor que não é do Simples Nacional (CRT diferente de 1) ";
        }
        if (cStat.equals("592")) {
            return "Rejeição: A NF-e deve ter pelo menos um item de produto sujeito ao ICMS ";
        }
        if (cStat.equals("594")) {
            return "Rejeição: O número de seqüencia do evento informado é maior que o permitido ";
        }
        if (cStat.equals("601")) {
            return "Rejeição: CFOP de Importação e não informado dados de IPI";
        }
        if (cStat.equals("602")) {
            return "Rejeição: Total do PIS difere do somatório dos itens sujeitos ao ICMS";
        }
        if (cStat.equals("603")) {
            return "Rejeição: Total do COFINS difere do somatório dos itens sujeitos ao ICMS";
        }
        if (cStat.equals("604")) {
            return "Rejeição: Total do vOutro difere do somatório dos itens";
        }
        if (cStat.equals("605")) {
            return "Rejeição: Total do vServ difere do somatório do vProd dos itens sujeitos ao ISSQN";
        }
        if (cStat.equals("606")) {
            return "Rejeição: Total do vBC do ISS difere do somatório dos itens";
        }
        if (cStat.equals("607")) {
            return "Rejeição: Total do ISS difere do somatório dos itens";
        }
        if (cStat.equals("608")) {
            return "Rejeição: Total do PIS difere do somatório dos itens sujeitos ao ISSQN";
        }
        if (cStat.equals("609")) {
            return "Rejeição: Total do COFINS difere do somatório dos itens sujeitos ao ISSQN";
        }
        if (cStat.equals("610")) {
            return "Rejeição: Total da NF difere do somatório dos Valores compõe o valor Total da NF.";
        }
        if (cStat.equals("611")) {
            return "Rejeição: cEAN inválido";
        }
        if (cStat.equals("612")) {
            return "Rejeição: cEANTrib inválido";
        }
        if (cStat.equals("613")) {
            return "Rejeição: Chave de Acesso difere da existente em BD [9999999999999999999999999999]";
        }
        if (cStat.equals("614")) {
            return "Rejeição: Chave de Acesso inválida (Código UF inválido)";
        }
        if (cStat.equals("615")) {
            return "Rejeição: Chave de Acesso inválida (Ano < 05 ou Ano maior que Ano corrente)";
        }
        if (cStat.equals("616")) {
            return "Rejeição: Chave de Acesso inválida (Mês < 1 ou Mês > 12)";
        }
        if (cStat.equals("617")) {
            return "Rejeição: Chave de Acesso inválida (CNPJ zerado ou dígito inválido)";
        }
        if (cStat.equals("618")) {
            return "Rejeição: Chave de Acesso inválida (modelo diferente de 55)";
        }
        if (cStat.equals("619")) {
            return "Rejeição: Chave de Acesso inválida (número NF = 0)";
        }
        if (cStat.equals("621")) {
            return "Rejeição: CPF Emitente não cadastrado";
        }
        if (cStat.equals("622")) {
            return "Rejeição: IE emitente não vinculada ao CPF";
        }
        if (cStat.equals("623")) {
            return "Rejeição: CPF Destinatário não cadastrado";
        }
        if (cStat.equals("624")) {
            return "Rejeição: IE Destinatário não vinculada ao CPF";
        }
        if (cStat.equals("625")) {
            return "Rejeição: Inscrição SUFRAMA deve ser informada na venda com isenção para ZFM";
        }
        if (cStat.equals("626")) {
            return "Rejeição: O CFOP de operação isenta para ZFM deve ser 6109 ou 6110";
        }
        if (cStat.equals("627")) {
            return "Rejeição: O valor do ICMS desonerado deve ser informado";
        }
        if (cStat.equals("628")) {
            return "Rejeição: Total da NF superior ao valor limite estabelecido pela SEFAZ [Limite]";
        }
        if (cStat.equals("629")) {
            return "Rejeição: Valor do Produto difere do produto Valor Unitário de Comercialização e Quantidade Comercial";
        }
        if (cStat.equals("630")) {
            return "Rejeição: Valor do Produto difere do produto Valor Unitário de Tributação e Quantidade Tributável";
        }
        if (cStat.equals("635")) {
            return "Rejeição: NF-e com mesmo número e série já transmitida e aguardando processamento";
        }
        if (cStat.equals("128")) {
            return "Lote de Evento Processado";
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>1</tpAmb><verAplic>2.00</verAplic><cStat>217</cStat><xMotivo>Rejeicao: NF-e nao consta na base de dados da SEFAZ</xMotivo><cUF>31</cUF><chNFe>31121005202781000110550010000003941273845853</chNFe></retConsSitNFe>";
        s = "<retEnviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>13_0_63</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>31</cUF><dhRecbto>2013-02-28T19:33:58</dhRecbto><infRec><nRec>310000023957748</nRec><tMed>1</tMed></infRec></retEnviNFe>";
        s = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><nRec>310000023988358</nRec><cStat>104</cStat><xMotivo>Lote processado</xMotivo><cUF>31</cUF><protNFe versao=\"2.00\"><infProt><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><chNFe>31130286590536000120550010000105161878858249</chNFe><dhRecbto>2013-03-05T13:46:43</dhRecbto><digVal>+XvjnRJKJOlEpCEkFaZxyenZ+PY=</digVal><cStat>213</cStat><xMotivo>Rejeicao: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital</xMotivo></infProt></protNFe></retConsReciNFe>";

        s = "<retEnviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>31</cUF><dhRecbto>2013-03-06T11:19:34</dhRecbto><infRec><nRec>310000024001775</nRec><tMed>1</tMed></infRec></retEnviNFe>";
        s = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><nRec>310000024001775</nRec><cStat>104</cStat><xMotivo>Lote processado</xMotivo><cUF>31</cUF><protNFe versao=\"2.00\"><infProt><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><chNFe>31130311153703000176550010000105171115664876</chNFe><dhRecbto>2013-03-06T11:19:34</dhRecbto><nProt>131130033179973</nProt><digVal>UM+P/47cu7sc8uw1O7w59/Ok2IY=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe></retConsReciNFe>";
        s = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><nRec>310000024001775</nRec><cStat>104</cStat><xMotivo>Lote processado</xMotivo><cUF>31</cUF><protNFe versao=\"2.00\"><infProt><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><chNFe>31130311153703000176550010000105171115664876</chNFe><dhRecbto>2013-03-06T11:19:34</dhRecbto><nProt>131130033179973</nProt><digVal>UM+P/47cu7sc8uw1O7w59/Ok2IY=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe></retConsReciNFe>";

        s = "<retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.01\"><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo><cUF>31</cUF><chNFe>31130311153703000176550010000105171115664876</chNFe><protNFe versao=\"2.00\"><infProt Id=\"ID131130033179973\"><tpAmb>2</tpAmb><verAplic>13_0_64</verAplic><chNFe>31130311153703000176550010000105171115664876</chNFe><dhRecbto>2013-03-06T11:19:34</dhRecbto><nProt>131130033179973</nProt><digVal>UM+P/47cu7sc8uw1O7w59/Ok2IY=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe></retConsSitNFe>";
        java.util.List<String[]> a = validarRetornoTransmissaoXML(s, "consulta");
        System.out.println(a.get(0)[0]);
        System.out.println(a.get(0)[1]);
        System.out.println(a.get(0)[2]);
        System.out.println(a.get(0)[3]);

//        validacoesNotaFiscal v = new validacoesNotaFiscal();
//        System.out.println(v.TratarRetornoNfeValidarXML("cvc-pattern-valid: Value '' is not facet-valid with respect to pattern '[!-ￃ﾿]{1}[ -ￃ﾿]{0,}[!-ￃ﾿]{1}|[!-ￃ﾿]{1}' for type '#AnonType_espvoltranspinfNFeTNFe'."));
    }

    public static java.util.List<String[]> validarRetornoTransmissaoXML(String xml, String tipoMetodo) {
        String retorno[] = new String[6];
        java.util.List<String[]> retornoLista = new java.util.LinkedList<String[]>();
        System.err.println("validarRetornoXML XML :" + xml);

        if (tipoMetodo.equals("envio")) {

            XmlRetEnviNFe XmlRetEnviNFe = new XmlRetEnviNFe();
            // Trata o retorno dos dados do cancelamento
            // em uma classe para tratamento de xml
            XmlRetEnviNFe.setXML(xml);
            XmlRetEnviNFe.BuscaDadosXML();
            // Gravar os dados 
            // Codigo Status
            retorno[0] = XmlRetEnviNFe.cStat();
            // Motivo
            retorno[1] = XmlRetEnviNFe.xMotivo();
            // Numero recibo
            retorno[2] = XmlRetEnviNFe.nRec();
            // Protocolo
            retorno[3] = "";
            // Data hora recebimento
            retorno[4] = XmlRetEnviNFe.dhRecbto();
            // Chave de acesso
            retorno[5] = "";
            retornoLista.add(retorno);
        } else if (tipoMetodo.equals("cancelamento")) {
            XmlRetCancNFeH XmlRetCancNFeH = new XmlRetCancNFeH();
            XmlRetCancNFe XmlRetCancNFe = new XmlRetCancNFe();
            if (xml.contains("<cStat>101</cStat>")) {
                // Trata o retorno dos dados do cancelamento
                // em uma classe para tratamento de xml
                XmlRetCancNFeH.setXML(xml);
                XmlRetCancNFeH.BuscaDadosXML();
                // Gravar os dados caso cancele
                // Codigo Status
                retorno[0] = XmlRetCancNFeH.cStat();
                // Motivo
                retorno[1] = XmlRetCancNFeH.xMotivo();
                // Numero recibo
                retorno[2] = "";
                // Protocolo
                retorno[3] = XmlRetCancNFeH.nProt();
                // Data hora recibimento
                retorno[4] = XmlRetCancNFeH.dhRecbto();
                // Chave de acesso
                retorno[5] = XmlRetCancNFeH.chNFe();
                retornoLista.add(retorno);
            } else {
                // Trata o retorno dos dados do cancelamento
                // em uma classe para tratamento de xml
                XmlRetCancNFe.setXML(xml);
                XmlRetCancNFe.BuscaDadosXML();
                // Grava os dados caso nao seja
                // Codigo Status
                retorno[0] = XmlRetCancNFe.cStat();
                // Motivo
                retorno[1] = XmlRetCancNFe.xMotivo();
                // Numero recibo
                retorno[2] = "";
                // Protocolo
                retorno[3] = "";
                // Data hora recebimento
                retorno[4] = "";
                // Chave de acesso
                retorno[5] = "";
                retornoLista.add(retorno);
            }
        } else if (tipoMetodo.equals("inutilizacao")) {
            XmlRetInutNFeH XmlRetInutNFeH = new XmlRetInutNFeH();
            XmlRetInutNFe XmlRetInutNFe = new XmlRetInutNFe();

            if (xml.contains("<cStat>102</cStat>")) {
                // Trata o retorno dos dados do cancelamento
                // em uma classe para tratamento de xml
                XmlRetInutNFeH.setXML(xml);
                XmlRetInutNFeH.BuscaDadosXML();
                // Gravar os dados caso cancele
                // Codigo Status
                retorno[0] = XmlRetInutNFeH.cStat();
                // Motivo
                retorno[1] = XmlRetInutNFeH.xMotivo();
                // Numero recibo
                retorno[2] = "";
                // Protocolo
                retorno[3] = XmlRetInutNFeH.nProt();
                // Data hora recebimento
                retorno[4] = XmlRetInutNFeH.dhRecbto();
                // Chave de acesso
                retorno[5] = "";
                retornoLista.add(retorno);
            } else {
                // Trata o retorno dos dados do cancelamento
                // em uma classe para tratamento de xml
                XmlRetInutNFe.setXML(xml);
                XmlRetInutNFe.BuscaDadosXML();
                // Grava os dados caso nao sejas]
                // Codigo Status
                retorno[0] = XmlRetInutNFe.cStat();
                // Motivo
                retorno[1] = XmlRetInutNFe.xMotivo();
                // Numero recibo
                retorno[2] = "";
                // Protocolo
                retorno[3] = "";
                // Data hora recebimento
                retorno[4] = "";
                // Chave de acesso
                retorno[5] = "";
                retornoLista.add(retorno);
            }
        } else if (tipoMetodo.equals("consulta")) {

            // Consulta de recibo
            XmlRetConsReciNFeRecebimento XmlRetConsReciNFeRecebimento = new XmlRetConsReciNFeRecebimento();
            XmlRetConsReciNFeFalha XmlRetConsReciNFeFalha = new XmlRetConsReciNFeFalha();
            // Consulta da Chave de Acesso
            XmlRetConsSitNFe XmlRetConsSitNFe = new XmlRetConsSitNFe();
            XmlRetConsSitNFeFalha XmlRetConsSitNFeFalha = new XmlRetConsSitNFeFalha();
            XmlRetConsSitNFeCancelamento XmlRetConsSitNFeCancelamento = new XmlRetConsSitNFeCancelamento();
            XmlRetConsSitNFeEvento XmlRetConsSitNFeEvento = new XmlRetConsSitNFeEvento();
            // NFE Canceladas
            XmlRetCancNFe XmlRetCancNFe = new XmlRetCancNFe();
            XmlRetCancNFeH XmlRetCancNFeH = new XmlRetCancNFeH();
            // NFE Inutilizadas
            XmlRetInutNFe XmlRetInutNFe = new XmlRetInutNFe();
            XmlRetInutNFeH XmlRetInutNFeH = new XmlRetInutNFeH();
            //
            if (xml.contains("retConsReciNFe")) {
                if (xml.contains("<protNFe")) {

                    XmlRetConsReciNFeRecebimento.setXML(xml);
                    XmlRetConsReciNFeRecebimento.BuscaDadosXML();

                    for (int i = 0; i < XmlRetConsReciNFeRecebimento.getProtNFe().size(); i++) {
                        // Codigo Status
                        retorno[0] = XmlRetConsReciNFeRecebimento.infProt_cStat(i);
                        // Motivo
                        retorno[1] = XmlRetConsReciNFeRecebimento.infProt_xMotivo(i);
                        // Numero recibo
                        retorno[2] = "";
                        // Protocolo
                        retorno[3] = XmlRetConsReciNFeRecebimento.infProt_nProt(i);
                        // Data hora recibimento
                        retorno[4] = XmlRetConsReciNFeRecebimento.infProt_dhRecbto(i);
                        // Chave de acesso
                        retorno[5] = XmlRetConsReciNFeRecebimento.infProt_chNFe(i);
                        retornoLista.add(retorno);
                    }
                } else {
                    XmlRetConsReciNFeFalha.setXML(xml);
                    XmlRetConsReciNFeFalha.BuscaDadosXML();
                    // Codigo Status
                    retorno[0] = XmlRetConsReciNFeFalha.cStat();
                    // Motivo
                    retorno[1] = XmlRetConsReciNFeFalha.xMotivo();
                    // Numero recibo
                    retorno[2] = XmlRetConsReciNFeFalha.nRec();
                    // Protocolo
                    retorno[3] = "";
                    // Data hora recibimento
                    retorno[4] = "";
                    // Chave de acesso
                    retorno[5] = XmlRetConsReciNFeFalha.infProt_chNFe();
                    retornoLista.add(retorno);
                }
            } else if (xml.contains("retConsSitNFe")) {
                if (xml.contains("<protNFe")) {
                    XmlRetConsSitNFe.setXML(xml);
                    XmlRetConsSitNFe.BuscaDadosXML();
                    // Codigo Status
                    retorno[0] = XmlRetConsSitNFe.infProt_cStat();
                    // Motivo
                    retorno[1] = XmlRetConsSitNFe.infProt_xMotivo();
                    // Numero recibo
                    retorno[2] = "";
                    // Protocolo
                    retorno[3] = XmlRetConsSitNFe.infProt_nProt();
                    // Data hora recibimento
                    retorno[4] = XmlRetConsSitNFe.infProt_dhRecbto();
                    // Chave de acesso
                    retorno[5] = XmlRetConsSitNFe.infProt_chNFe();
                    retornoLista.add(retorno);
                } else if (xml.contains("<retCancNFe")) {
                    XmlRetConsSitNFeCancelamento.setXML(xml);
                    XmlRetConsSitNFeCancelamento.BuscaDadosXML();
                    // Codigo Status
                    retorno[0] = XmlRetConsSitNFeCancelamento.infCanc_cStat();
                    // Motivo
                    retorno[1] = XmlRetConsSitNFeCancelamento.infCanc_xMotivo();
                    // Numero recibo
                    retorno[2] = "";
                    // Protocolo
                    retorno[3] = XmlRetConsSitNFeCancelamento.infCanc_nProt();
                    // Data hora recibimento
                    retorno[4] = XmlRetConsSitNFeCancelamento.infCanc_dhRecbto();
                    // Chave de acesso
                    retorno[5] = XmlRetConsSitNFeCancelamento.infCanc_chNFe();
                    retornoLista.add(retorno);
                } else if (xml.contains("<procEventoNFe")) {
                    XmlRetConsSitNFeEvento.setXML(xml);
                    XmlRetConsSitNFeEvento.BuscaDadosXML();

                    // Codigo Status
                    retorno[0] = "";//XmlRetConsSitNFeEvento.infCanc_cStat();
                    // Motivo
                    retorno[1] = "";//XmlRetConsSitNFeEvento.infCanc_xMotivo();
                    // Numero recibo
                    retorno[2] = "";
                    // Protocolo
                    retorno[3] = "";//XmlRetConsSitNFeEvento.infCanc_nProt();
                    // Data hora recibimento
                    retorno[4] = "";//XmlRetConsSitNFeEvento.infCanc_dhRecbto();
                    // Chave de acesso
                    retorno[5] = "";//XmlRetConsSitNFeCancelamento.infCanc_chNFe();
                    retornoLista.add(retorno);
                } else {
                    XmlRetConsSitNFeFalha.setXML(xml);
                    XmlRetConsSitNFeFalha.BuscaDadosXML();
                    // Codigo Status
                    retorno[0] = XmlRetConsSitNFeFalha.cStat();
                    // Motivo
                    retorno[1] = XmlRetConsSitNFeFalha.xMotivo();
                    // Numero recibo
                    retorno[2] = "";
                    // Protocolo
                    retorno[3] = "";
                    // Data hora recibimento
                    retorno[4] = "";
                    // Chave de acesso
                    retorno[5] = XmlRetConsSitNFeFalha.chNFe();
                    retornoLista.add(retorno);
                }
            }
        }
        return retornoLista;
    }

    public static String validarRetornoXML(String Codigo) {

        if (Codigo.contains("TIdLote")) {
            return "Verifique o lote das Notas Fiscais";
        }
        if (Codigo.contains("#AnonType_IdinfNFeTNFe")) {
            return "Verifique os dados da Empresa na configuração do Sistema";
        }
        if (Codigo.contains("#AnonType_cNFideinfNFeTNFe")) {
            return "Verifique o código do municipio da empresa Emitente";
        }
        if (Codigo.contains("#AnonType_natOpideinfNFeTNFe")) {
            return "Verifique a Natureza de Operação da Nota Fiscal";
        }
        if (Codigo.contains("[55]")) {
            return "Verifique o Modelo da Nota Fiscal";
        }
        if (Codigo.contains("TSerie")) {
            return "Verifique a Serie da Nota Fiscal";
        }
        if (Codigo.contains("TData")) {
            return "Verifique as Datas de Emissão e Saída da Nota Fiscal";
        }
        if (Codigo.contains("TCodMunIBGE")) {
            return "Verifique o código do municipio do Emitente";
        }
        if (Codigo.contains("#AnonType_cDVideinfNFeTNFe")) {
            return "Verifique o Digito Verificador da Chave de acesso";
        }
        if (Codigo.contains("#AnonType_verProcideinfNFeTNFe")) {
            return "Falha ao Buscar Versão do Aplicativo";
        }
        if (Codigo.contains("TCnpj")) {
            return "Verifique o CNPJ do Emitente e do Destinatário";
        }
        if (Codigo.contains("#AnonType_xNomeemitinfNFeTNFe")) {
            return "Verifique o nome do Emitente";
        }
        if (Codigo.contains("#AnonType_xFantemitinfNFeTNFe")) {
            return "Verifique o nome Fantasia do Emitente";
        }
        if (Codigo.contains("#AnonType_xLgrTEnderEmi")) {
            return "Verifique o Logradouro do Emitente";
        }
        if (Codigo.contains("#AnonType_nroTEnderEmi")) {
            return "Verifique o Número do Emitente";
        }
        if (Codigo.contains("#AnonType_xCplTEnderEmi")) {
            return "Verifique o Complemento do endereço do Emitente";
        }
        if (Codigo.contains("#AnonType_xBairroTEnderEmi")) {
            return "Verifique o Bairro do Emitente";
        }
        if (Codigo.contains("TCodMunIBGE")) {
            return "Verifique os Códigos do Municipio do Emitente e Destinatário";
        }
        if (Codigo.contains("#AnonType_xMunTEnderEmi")) {
            return "Verifique o Municipio do Emitente";
        }
        if (Codigo.contains("#AnonType_CEPTEnderEmi")) {
            return "Verifique o CEP do Emitente";
        }
        if (Codigo.contains("#AnonType_cPaisTEnderEmi")) {
            return "Verifique o código do Pais do Emitente";
        }
        if (Codigo.contains("#AnonType_xPaisTEnderEmi")) {
            return "Verifique o Pais do Emitente";
        }
        if (Codigo.contains("#AnonType_foneTEnderEmi")) {
            return "Verifique o Telefone do Emitente";
        }
        if (Codigo.contains("TIe")) {
            return "Verifique a Inscrição Estadual do Emitente";
        }
        if (Codigo.contains("TCpf")) {
            return "Verifique o CPF do Emitente e do Destinatário";
        }
        if (Codigo.contains("#AnonType_xNomedestinfNFeTNFe")) {
            return "Verifique o Nome do Destinatário";
        }
        if (Codigo.contains("#AnonType_xLgrTEndereco")) {
            return "Verifique o Logradouro do Destinatário";
        }
        if (Codigo.contains("#AnonType_nroTEndereco")) {
            return "Verifique o Número do Destinatário";
        }
        if (Codigo.contains("#AnonType_xBairroTEndereco")) {
            return "Verifique o Bairro do Destinatário";
        }
        if (Codigo.contains("TCodMunIBGE")) {
            return "Verifique os Códigos do Municipio do Emitente e Destinatário";
        }
        if (Codigo.contains("#AnonType_xMunTEndereco")) {
            return "Verifique o Municipio do Destinatário";
        }
        if (Codigo.contains("#AnonType_CEPTEndereco")) {
            return "Verifique o CEP do Destinatário";
        }
        if (Codigo.contains("#AnonType_cPaisTEndereco")) {
            return "Verifique o Código do Pais do Destinatário";
        }
        if (Codigo.contains("#AnonType_xPaisTEndereco")) {
            return "Veririque o Pais do Destinatário";
        }
        if (Codigo.contains("#AnonType_foneTEndereco")) {
            return "Verifique o Telefone do Destinatario";
        }
        if (Codigo.contains("TIeDest")) {
            return "Verifique a Inscrição Estadual do Destinatário";
        }
        if (Codigo.contains("#AnonType_cProdproddetinfNFeTNFe")) {
            return "Erro no código do produto da Nota Fiscal";
        }
        if (Codigo.contains("#AnonType_xProdproddetinfNFeTNFe")) {
            return "Verifique o Nome dos produtos da Nota Fiscal";
        }
        if (Codigo.contains("#AnonType_uComproddetinfNFeTNFe")) {
            return "Verifique a Unidade dos produtos da Nota Fiscal";
        }
        if (Codigo.contains("TDec_0804")) {
            return "Verifique a quantidade dos Produtos na Nota Fiscal";
        }
        if (Codigo.contains("TDec_1204")) {
            return "Verifique o valor unitário dos Produtos na Nota Fiscal";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique o valor total dos Produtos na Nota Fiscal";
        }
        if (Codigo.contains("#AnonType_uTribproddetinfNFeTNFe")) {
            return "Verifique a Unidade tributável dos Produtos da Nota Fiscal";
        }
        if (Codigo.contains("TDec_0804")) {
            return "Verifique a quantidade tributável dos Produtos da Nota Fiscal";
        }
        if (Codigo.contains("TDec_1204")) {
            return "Verifique o valor total tributável dos Produtos na Nota Fiscal";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique o valor da Base de Calculo de ICMS";
        }
        if (Codigo.contains("TDec_0302")) {
            return "Verifique o valor da aliquota de ICMS";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique o valor do ICMS";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique a modalidade da Base de Calculo de ICMS ST";
        }
        if (Codigo.contains("TDec_0302")) {
            return "Verifique o valor da aliquota de ICMS";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique o valor do ICMS";
        }
        if (Codigo.contains("#AnonType_clEnqIPIimpostodetinfNFeTNFe")) {
            return "Verifique a classe de enquadramento do IPI";
        }
        if (Codigo.contains("#AnonType_cSeloIPIimpostodetinfNFeTNFe")) {
            return "Verifique o codigo do Selo de controle";
        }
        if (Codigo.contains("#AnonType_qSeloIPIimpostodetinfNFeTNFe")) {
            return "Verifique a quantidade do Selo de controle";
        }
        if (Codigo.contains("#AnonType_cEnqIPIimpostodetinfNFeTNFe")) {
            return "Verifique o código de Enquadramento Legal do IPI";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique o valor da Base de Calculo de ICMS";
        }
        if (Codigo.contains("TDec_0302")) {
            return "Verifique o valor da aliquota de ICMS";
        }
        if (Codigo.contains("TDec_1302")) {
            return "Verifique o valor do ICMS";
        }
        if (Codigo.contains("TCpf")) {
            return "Verifique o CPF do Emitente e do Destinatário";
        }
        if (Codigo.contains("#AnonType_xNometransportatranspinfNFeTNFe")) {
            return "Verifique o nome do Transportador";
        }
        if (Codigo.contains("#AnonType_IEtransportatranspinfNFeTNFe")) {
            return "Verifique a Inscrição Estadual do Tranportador";
        }
        if (Codigo.contains("#AnonType_xEndertransportatranspinfNFeTNFe")) {
            return "Verifique o Endereço do Transportador";
        }
        if (Codigo.contains("#AnonType_xMuntransportatranspinfNFeTNFe")) {
            return "Verifique o Municipio do Transportador";
        }
        if (Codigo.contains("#AnonType_placaTVeiculo")) {
            return "Verifique a placa do Veiculo do Transportador";
        }
        if (Codigo.contains("#AnonType_RNTCTVeiculo")) {
            return "Verifique o código ANTT do Transportador";
        }
        if (Codigo.contains("#AnonType_qVolvoltranspinfNFeTNFe")) {
            return "Verifique a Quantidade de Volume da Nota Fiscal";
        }
        if (Codigo.contains("espvoltranspinfNFeTNFe")) {
            return "Verifique a Especie da Nota Fiscal";
        }
        if (Codigo.contains("#AnonType_marcavoltranspinfNFeTNFe")) {
            return "Verifique a Marca da Nota Fiscal";
        }
        if (Codigo.contains("TDec_1203")) {
            return "Verifique o Peso da nota Fiscal";
        }
        if (Codigo.equals("Premature end of file.")) {
            return "Problema ao Validar o XML Assinado!";
        }
        if (Codigo.equals("PKCS11 KeyStore not available")) {
            return "Certificado/Token Inacessível!";
        }
        return "";
    }

    public static String validarExceptions(String excecao) {
        if (excecao.contains("pkcs11 not found")) {
            return "Não foi possível encontrar o Certificado Digital, verifique o dispositivo.";
        }
        if (excecao.contains("pkcs12 not found")) {
            return "Não foi possível encontrar o Certificado Digital, verifique o certificado.";
        }
        return "";
    }

    public String getNotaFiscalXML() {
        return notaFiscalXML;
    }

    public void setNotaFiscalXML(String notaFiscalXML) {
        this.notaFiscalXML = notaFiscalXML;
    }

    public String getNotaFiscalXMLAssinada() {
        return notaFiscalXMLAssinada;
    }

    public void setNotaFiscalXMLAssinada(String notaFiscalXMLAssinada) {
        this.notaFiscalXMLAssinada = notaFiscalXMLAssinada;
    }
}
