/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped.efdpiscofins;

import crncomp.conexao;
import crncomp.geral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dev - Breno
 */
public class BlocoM {
    private RegistroM001 registroM001 = new RegistroM001();
    private RegistroM200 registroM200 = new RegistroM200();
    private RegistroM350 registroM350 = new RegistroM350();
    private RegistroM600 registroM600 = new RegistroM600();
    private RegistroM990 registroM990 = new RegistroM990();
    private List<RegistroM100> resgistrosM100 = new ArrayList<RegistroM100>();
    private List<RegistroM300> resgistrosM300 = new ArrayList<RegistroM300>();
    private List<RegistroM400> resgistrosM400 = new ArrayList<RegistroM400>();
    private List<RegistroM500> resgistrosM500 = new ArrayList<RegistroM500>();
    private List<RegistroM700> resgistrosM700 = new ArrayList<RegistroM700>();
    private List<RegistroM800> resgistrosM800 = new ArrayList<RegistroM800>();
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;

    public BlocoM() {
        conexao = new conexao();
        conteudo = new StringBuilder();

        // Busca dos dados
    }
    
}

//APURAÇÃO DA CONTRIBUIÇÃO E CRÉDITO DO PIS/PASEP E DA COFINS
class RegistroM001 {

    //Texto fixo contendo "M001"
    private String REG;
    /*Indicador de movimento:
    0- Bloco com dados informados;
    1- Bloco sem dados informados*/
    private String IND_MOV;
    
    private StringBuilder conteudo;

    RegistroM001 registroM001 = new RegistroM001();
    List<RegistroM001> registrosM001 = new ArrayList<RegistroM001>();
    
    protected List<RegistroM001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM001 = new RegistroM001();
                registroM001.setIND_MOV(RS.getString(""));                         
                
                registrosM001.add(registroM001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM001;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M001").append("|");
            conteudo.append(geral.efdRemoveSinais(getIND_MOV())).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM001.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getIND_MOV() {
        return IND_MOV;
    }

    public void setIND_MOV(String IND_MOV) {
        this.IND_MOV = IND_MOV;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
    
}


class RegistroM100{
    //Texto fixo contendo "M100"
    private String REG;
    //Código de Tipo de Crédito apurado no período, conforme a Tabela 4.3.6.
    private String COD_CRED;
    //Indicador de Crédito Oriundo de:
    //0 – Operações próprias
    //1 – Evento de incorporação, cisão ou fusão
    private String IND_CRED_ORI;
    //Valor da Base de Cálculo do Crédito
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Quantidade – Base de cálculo PIS
    private String QUANT_BC_PIS;
    //Alíquota do PIS (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor total do crédito apurado no período
    private String VL_CRED;
    //Valor total dos ajustes de acréscimo
    private String VL_AJUS_ACRES;
    //Valor total dos ajustes de redução
    private String VL_AJUS_REDUC;
    //Valor total do crédito diferido no período
    private String VL_CRED_DIF;
    //Valor Total do Crédito Disponível relativo ao Período (08 + 09 – 10 – 11)
    private String VL_CRED_DISP;
    /*Indicador de opção de utilização do crédito disponível no
    período:
    0 – Utilização do valor total para desconto da
    contribuição apurada no período, no Registro M200;
    1 – Utilização de valor parcial para desconto da
    contribuição apurada no período, no Registro M200.*/
    private String IND_DESC_CRED;
    /*Valor do Crédito disponível, descontado da contribuição
    apurada no próprio período.
    Se IND_DESC_CRED=0, informar o valor total do
    Campo 12;
    Se IND_DESC_CRED=1, informar o valor parcial do
    Campo 12.*/
    private String VL_CRED_DESC;
    //Saldo de créditos a utilizar em períodos futuros (12 – 14)
    private String SLD_CRED;
    
    private List<RegistroM105> resgistrosM105 = new ArrayList<RegistroM105>();
    private List<RegistroM110> resgistrosM110 = new ArrayList<RegistroM110>();
    
    private StringBuilder conteudo;
    
    RegistroM100 registroM100 = new RegistroM100();
    List<RegistroM100> registrosM100 = new ArrayList<RegistroM100>();
    
    protected List<RegistroM100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM100 = new RegistroM100();
                registroM100.setCOD_CRED(RS.getString(""));
                registroM100.setIND_CRED_ORI(RS.getString(""));
                registroM100.setVL_BC_PIS(RS.getString(""));
                registroM100.setALIQ_PIS(RS.getString(""));
                registroM100.setQUANT_BC_PIS(RS.getString(""));
                registroM100.setALIQ_PIS_QUANT(RS.getString(""));
                registroM100.setVL_CRED(RS.getString(""));
                registroM100.setVL_AJUS_ACRES(RS.getString(""));
                registroM100.setVL_AJUS_REDUC(RS.getString(""));
                registroM100.setVL_CRED_DIF(RS.getString(""));
                registroM100.setVL_CRED_DISP(RS.getString(""));
                registroM100.setIND_DESC_CRED(RS.getString(""));
                registroM100.setVL_CRED_DESC(RS.getString(""));
                registroM100.setSLD_CRED(RS.getString(""));
                registrosM100.add(registroM100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM100;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M100").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CRED(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_CRED_ORI(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_ACRES()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_REDUC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DIF()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DISP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getIND_DESC_CRED(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getSLD_CRED()), 2)).append("|");
            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM100.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getIND_CRED_ORI() {
        return IND_CRED_ORI;
    }

    public void setIND_CRED_ORI(String IND_CRED_ORI) {
        this.IND_CRED_ORI = IND_CRED_ORI;
    }

    public String getVL_BC_PIS() {
        return VL_BC_PIS;
    }

    public void setVL_BC_PIS(String VL_BC_PIS) {
        this.VL_BC_PIS = VL_BC_PIS;
    }

    public String getALIQ_PIS() {
        return ALIQ_PIS;
    }

    public void setALIQ_PIS(String ALIQ_PIS) {
        this.ALIQ_PIS = ALIQ_PIS;
    }

    public String getQUANT_BC_PIS() {
        return QUANT_BC_PIS;
    }

    public void setQUANT_BC_PIS(String QUANT_BC_PIS) {
        this.QUANT_BC_PIS = QUANT_BC_PIS;
    }

    public String getALIQ_PIS_QUANT() {
        return ALIQ_PIS_QUANT;
    }

    public void setALIQ_PIS_QUANT(String ALIQ_PIS_QUANT) {
        this.ALIQ_PIS_QUANT = ALIQ_PIS_QUANT;
    }

    public String getVL_CRED() {
        return VL_CRED;
    }

    public void setVL_CRED(String VL_CRED) {
        this.VL_CRED = VL_CRED;
    }

    public String getVL_AJUS_ACRES() {
        return VL_AJUS_ACRES;
    }

    public void setVL_AJUS_ACRES(String VL_AJUS_ACRES) {
        this.VL_AJUS_ACRES = VL_AJUS_ACRES;
    }

    public String getVL_AJUS_REDUC() {
        return VL_AJUS_REDUC;
    }

    public void setVL_AJUS_REDUC(String VL_AJUS_REDUC) {
        this.VL_AJUS_REDUC = VL_AJUS_REDUC;
    }

    public String getVL_CRED_DIF() {
        return VL_CRED_DIF;
    }

    public void setVL_CRED_DIF(String VL_CRED_DIF) {
        this.VL_CRED_DIF = VL_CRED_DIF;
    }

    public String getVL_CRED_DISP() {
        return VL_CRED_DISP;
    }

    public void setVL_CRED_DISP(String VL_CRED_DISP) {
        this.VL_CRED_DISP = VL_CRED_DISP;
    }

    public String getIND_DESC_CRED() {
        return IND_DESC_CRED;
    }

    public void setIND_DESC_CRED(String IND_DESC_CRED) {
        this.IND_DESC_CRED = IND_DESC_CRED;
    }

    public String getVL_CRED_DESC() {
        return VL_CRED_DESC;
    }

    public void setVL_CRED_DESC(String VL_CRED_DESC) {
        this.VL_CRED_DESC = VL_CRED_DESC;
    }

    public String getSLD_CRED() {
        return SLD_CRED;
    }

    public void setSLD_CRED(String SLD_CRED) {
        this.SLD_CRED = SLD_CRED;
    }
    
}

//DETALHAMENTO DA BASE DE CALCULO DO CRÉDITO APURADO NO PERÍODO – PIS/PASEP - 
//Depende do campo COD_CRED do Registro M100
class RegistroM105{
    //Texto fixo contendo "M105"
    private String REG;
    /*Código da Base de Cálculo do Crédito apurado no período, conforme a Tabela 4.3.7.*/
    private String NAT_BC_CRED;
    /*Código da Situação Tributária referente ao crédito de
    PIS/Pasep (Tabela 4.3.3) vinculado ao tipo de crédito
    escriturado em M100.*/
    private String CST_PIS;
    /*Valor Total da Base de Cálculo escriturada nos
    documentos e operações (Blocos “A”, “C”, “D” e “F”),
    referente ao CST_PIS informado no Campo 03.*/
    private String VL_BC_PIS_TOT;
    /*Parcela do Valor Total da Base de Cálculo informada no
    Campo 04, vinculada a receitas com incidência
    cumulativa.
    Campo de preenchimento específico para a pessoa
    jurídica sujeita ao regime cumulativo e não-cumulativo da
    contribuição (COD_INC_TRIB = 3 do Registro 0110)*/
    private String VL_BC_PIS_CUM;
    /*Valor Total da Base de Cálculo do Crédito, vinculada a
    receitas com incidência não-cumulativa (Campo 04 –
    Campo 05).*/
    private String VL_BC_PIS_NC;
    /*Valor da Base de Cálculo do Crédito, vinculada ao tipo de
    Crédito escriturado em M100.
    - Para os CST_PIS = “50”, “51”, “52”, “60”, “61” e “62”:
    Informar o valor do Campo 06 (VL_BC_PIS_NC);
    - Para os CST_PIS = “53”, “54”, “55”, “56”, “63”, “64”
    “65” e “66” (Crédito sobre operações vinculadas a mais
    de um tipo de receita): Informar a parcela do valor do
    Campo 06 (VL_BC_PIS_NC) vinculada especificamente
    ao tipo de crédito escriturado em M100.
    O valor deste campo será transportado para o Campo 04
    (VL_BC_PIS) do registro M100.*/
    private String VL_BC_PIS;
    /*Quantidade Total da Base de Cálculo do Crédito apurado
    em Unidade de Medida de Produto, escriturada nos
    documentos e operações (Blocos “A”, “C”, “D” e “F”),
    referente ao CST_PIS informado no Campo 03*/
    private String QUANT_BC_PIS_TOT;
    
    /*Parcela da base de cálculo do crédito em quantidade
    (campo 08) vinculada ao tipo de crédito escriturado em
    M100.
    - Para os CST_PIS = “50”, “51” e “52”: Informar o valor
    do Campo 08 (QUANT_BC_PIS);
    - Para os CST_PIS = “53”, “54”, “55” e “56” (crédito
    vinculado a mais de um tipo de receita): Informar a
    parcela do valor do Campo 08 (QUANT_BC_PIS)
    vinculada ao tipo de crédito escriturado em M100.
    O valor deste campo será transportado para o Campo 06
    (QUANT_BC_PIS) do registro M100.*/
    private String QUANT_BC_PIS;
    //Descrição do crédito
    private String DESC_CRED;
    
    private StringBuilder conteudo;

    RegistroM105 registroM105 = new RegistroM105();
    List<RegistroM105> registrosM105 = new ArrayList<RegistroM105>();
    
    protected List<RegistroM105> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM105 = new RegistroM105();
                registroM105.setNAT_BC_CRED(RS.getString(""));
                registroM105.setCST_PIS(RS.getString(""));
                registroM105.setVL_BC_PIS_TOT(RS.getString(""));
                registroM105.setVL_BC_PIS_CUM(RS.getString(""));
                registroM105.setVL_BC_PIS_NC(RS.getString(""));
                registroM105.setVL_BC_PIS(RS.getString(""));
                registroM105.setQUANT_BC_PIS_TOT(RS.getString(""));
                registroM105.setQUANT_BC_PIS(RS.getString(""));
                registroM105.setDESC_CRED(RS.getString(""));                
                registrosM105.add(registroM105);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM105.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM105;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M105").append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS_TOT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS_CUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS_NC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS_TOT()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(getDESC_CRED(), 60)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM105.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNAT_BC_CRED() {
        return NAT_BC_CRED;
    }

    public void setNAT_BC_CRED(String NAT_BC_CRED) {
        this.NAT_BC_CRED = NAT_BC_CRED;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_BC_PIS_TOT() {
        return VL_BC_PIS_TOT;
    }

    public void setVL_BC_PIS_TOT(String VL_BC_PIS_TOT) {
        this.VL_BC_PIS_TOT = VL_BC_PIS_TOT;
    }

    public String getVL_BC_PIS_CUM() {
        return VL_BC_PIS_CUM;
    }

    public void setVL_BC_PIS_CUM(String VL_BC_PIS_CUM) {
        this.VL_BC_PIS_CUM = VL_BC_PIS_CUM;
    }

    public String getVL_BC_PIS_NC() {
        return VL_BC_PIS_NC;
    }

    public void setVL_BC_PIS_NC(String VL_BC_PIS_NC) {
        this.VL_BC_PIS_NC = VL_BC_PIS_NC;
    }

    public String getVL_BC_PIS() {
        return VL_BC_PIS;
    }

    public void setVL_BC_PIS(String VL_BC_PIS) {
        this.VL_BC_PIS = VL_BC_PIS;
    }

    public String getQUANT_BC_PIS_TOT() {
        return QUANT_BC_PIS_TOT;
    }

    public void setQUANT_BC_PIS_TOT(String QUANT_BC_PIS_TOT) {
        this.QUANT_BC_PIS_TOT = QUANT_BC_PIS_TOT;
    }

    public String getQUANT_BC_PIS() {
        return QUANT_BC_PIS;
    }

    public void setQUANT_BC_PIS(String QUANT_BC_PIS) {
        this.QUANT_BC_PIS = QUANT_BC_PIS;
    }

    public String getDESC_CRED() {
        return DESC_CRED;
    }

    public void setDESC_CRED(String DESC_CRED) {
        this.DESC_CRED = DESC_CRED;
    }
    
}


class RegistroM110 {
    //Texto fixo contendo "M110"
    private String REG;
    /*Indicador do tipo de ajuste:
    0- Ajuste de redução;
    1- Ajuste de acréscimo.*/
    private String IND_AJ;
    //Valor do ajuste
    private String VL_AJ;
    //Código do ajuste, conforme a Tabela indicada no item 4.3.8.
    private String COD_AJ;
    /*Número do processo, documento ou ato concessório ao qual o
    ajuste está vinculado, se houver.*/
    private String NUM_DOC;
    //Descrição resumida do ajuste.
    private String DESCR_AJ;
    //Data de referência do ajuste (ddmmaaaa)
    private String DT_REF;

    private StringBuilder conteudo;

    RegistroM110 registroM110 = new RegistroM110();
    List<RegistroM110> registrosM110 = new ArrayList<RegistroM110>();
    
    protected List<RegistroM110> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM110 = new RegistroM110();
                registroM110.setIND_AJ(RS.getString(""));
                registroM110.setVL_AJ(RS.getString(""));
                registroM110.setCOD_AJ(RS.getString(""));
                registroM110.setNUM_DOC(RS.getString(""));
                registroM110.setDESCR_AJ(RS.getString(""));
                registroM110.setDT_REF(RS.getString(""));                              
                registrosM110.add(registroM110);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM110.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM110;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M110").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_AJ(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJ()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_AJ(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC())).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESCR_AJ())).append("|");
            conteudo.append(geral.efdNumerico(getDT_REF(), 8)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM110.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_AJ() {
        return IND_AJ;
    }

    public void setIND_AJ(String IND_AJ) {
        this.IND_AJ = IND_AJ;
    }

    public String getVL_AJ() {
        return VL_AJ;
    }

    public void setVL_AJ(String VL_AJ) {
        this.VL_AJ = VL_AJ;
    }

    public String getCOD_AJ() {
        return COD_AJ;
    }

    public void setCOD_AJ(String COD_AJ) {
        this.COD_AJ = COD_AJ;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDESCR_AJ() {
        return DESCR_AJ;
    }

    public void setDESCR_AJ(String DESCR_AJ) {
        this.DESCR_AJ = DESCR_AJ;
    }

    public String getDT_REF() {
        return DT_REF;
    }

    public void setDT_REF(String DT_REF) {
        this.DT_REF = DT_REF;
    }
    
}


class RegistroM200 {

    //Texto fixo contendo "M200"
    private String REG;
    /*Valor Total da Contribuição Não Cumulativa do Período
    (recuperado do campo 13 do Registro M210, quando o
    campo “COD_CONT” = 01, 02, 03, 04, 32 e 71)*/
    private String VL_TOT_CONT_NC_PER;
    /*Valor do Crédito Descontado, Apurado no Próprio
    Período da Escrituração (recuperado do campo 14 do
    Registro M100)*/
    private String VL_TOT_CRED_DESC;
    /*Valor do Crédito Descontado, Apurado em Período de
    Apuração Anterior (recuperado do campo 13 do Registro
    1100)*/
    private String VL_TOT_CRED_DESC_ANT;
    //Valor Total da Contribuição Não Cumulativa Devida (02 – 03 - 04)
    private String VL_TOT_CONT_NC_DEV;
    //Valor Retido na Fonte Deduzido no Período
    private String VL_RET_NC;
    //Outras Deduções no Período
    private String VL_OUT_DED_NC;
    //Valor da Contribuição Não Cumulativa a Recolher/Pagar (05 – 06 - 07)
    private String VL_CONT_NC_REC;
    /*Valor Total da Contribuição Cumulativa do Período
    (recuperado do campo 13 do Registro M210, quando o
    campo “COD_CONT” = 31, 32, 51, 52, 53, 54 e 72)*/
    private String VL_TOT_CONT_CUM_PER;
    //Valor Retido na Fonte Deduzido no Período
    private String VL_RET_CUM;
    //Outras Deduções no Período
    private String VL_OUT_DED_CUM;
    /*Valor da Contribuição Cumulativa a Recolher/Pagar (09 -
    10 – 11)*/
    private String VL_CONT_CUM_REC;
    /*Valor Total da Contribuição a Recolher/Pagar no Período
    (08 + 12)*/
    private String VL_TOT_CONT_REC;
    private List<RegistroM210> resgistrosM210 = new ArrayList<RegistroM210>();
    
    private StringBuilder conteudo;

    RegistroM200 registroM200 = new RegistroM200();
    List<RegistroM200> registrosM200 = new ArrayList<RegistroM200>();
    
    protected List<RegistroM200> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM200 = new RegistroM200();
                registroM200.setVL_TOT_CONT_NC_PER(RS.getString(""));
                registroM200.setVL_TOT_CRED_DESC(RS.getString(""));
                registroM200.setVL_TOT_CRED_DESC_ANT(RS.getString(""));
                registroM200.setVL_TOT_CONT_NC_DEV(RS.getString(""));
                registroM200.setVL_RET_NC(RS.getString(""));
                registroM200.setVL_OUT_DED_NC(RS.getString(""));                       
                registroM200.setVL_CONT_NC_REC(RS.getString(""));
                registroM200.setVL_TOT_CONT_CUM_PER(RS.getString(""));
                registroM200.setVL_RET_CUM(RS.getString(""));
                registroM200.setVL_OUT_DED_CUM(RS.getString(""));                
                registroM200.setVL_CONT_CUM_REC(RS.getString(""));
                registroM200.setVL_TOT_CONT_REC(RS.getString(""));
                registrosM200.add(registroM200);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM200.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM200;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M200").append("|");       
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_NC_PER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CRED_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CRED_DESC_ANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_NC_DEV()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET_NC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OUT_DED_NC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_NC_REC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_CUM_PER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET_CUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OUT_DED_CUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_CUM_REC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_REC()), 2)).append("|");                                               
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM200.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_TOT_CONT_NC_PER() {
        return VL_TOT_CONT_NC_PER;
    }

    public void setVL_TOT_CONT_NC_PER(String VL_TOT_CONT_NC_PER) {
        this.VL_TOT_CONT_NC_PER = VL_TOT_CONT_NC_PER;
    }

    public String getVL_TOT_CRED_DESC() {
        return VL_TOT_CRED_DESC;
    }

    public void setVL_TOT_CRED_DESC(String VL_TOT_CRED_DESC) {
        this.VL_TOT_CRED_DESC = VL_TOT_CRED_DESC;
    }

    public String getVL_TOT_CRED_DESC_ANT() {
        return VL_TOT_CRED_DESC_ANT;
    }

    public void setVL_TOT_CRED_DESC_ANT(String VL_TOT_CRED_DESC_ANT) {
        this.VL_TOT_CRED_DESC_ANT = VL_TOT_CRED_DESC_ANT;
    }

    public String getVL_TOT_CONT_NC_DEV() {
        return VL_TOT_CONT_NC_DEV;
    }

    public void setVL_TOT_CONT_NC_DEV(String VL_TOT_CONT_NC_DEV) {
        this.VL_TOT_CONT_NC_DEV = VL_TOT_CONT_NC_DEV;
    }

    public String getVL_RET_NC() {
        return VL_RET_NC;
    }

    public void setVL_RET_NC(String VL_RET_NC) {
        this.VL_RET_NC = VL_RET_NC;
    }

    public String getVL_OUT_DED_NC() {
        return VL_OUT_DED_NC;
    }

    public void setVL_OUT_DED_NC(String VL_OUT_DED_NC) {
        this.VL_OUT_DED_NC = VL_OUT_DED_NC;
    }

    public String getVL_CONT_NC_REC() {
        return VL_CONT_NC_REC;
    }

    public void setVL_CONT_NC_REC(String VL_CONT_NC_REC) {
        this.VL_CONT_NC_REC = VL_CONT_NC_REC;
    }

    public String getVL_TOT_CONT_CUM_PER() {
        return VL_TOT_CONT_CUM_PER;
    }

    public void setVL_TOT_CONT_CUM_PER(String VL_TOT_CONT_CUM_PER) {
        this.VL_TOT_CONT_CUM_PER = VL_TOT_CONT_CUM_PER;
    }

    public String getVL_RET_CUM() {
        return VL_RET_CUM;
    }

    public void setVL_RET_CUM(String VL_RET_CUM) {
        this.VL_RET_CUM = VL_RET_CUM;
    }

    public String getVL_OUT_DED_CUM() {
        return VL_OUT_DED_CUM;
    }

    public void setVL_OUT_DED_CUM(String VL_OUT_DED_CUM) {
        this.VL_OUT_DED_CUM = VL_OUT_DED_CUM;
    }

    public String getVL_CONT_CUM_REC() {
        return VL_CONT_CUM_REC;
    }

    public void setVL_CONT_CUM_REC(String VL_CONT_CUM_REC) {
        this.VL_CONT_CUM_REC = VL_CONT_CUM_REC;
    }

    public String getVL_TOT_CONT_REC() {
        return VL_TOT_CONT_REC;
    }

    public void setVL_TOT_CONT_REC(String VL_TOT_CONT_REC) {
        this.VL_TOT_CONT_REC = VL_TOT_CONT_REC;
    }
    
}


class RegistroM210 {

    //Texto fixo contendo "M210"
    private String REG;
    /*Código da contribuição social apurada no período, conforme a Tabela 4.3.5.*/
    private String COD_CONT;
    //Valor da Receita Bruta
    private String VL_REC_BRT;
    //Valor da Base de Cálculo da Contribuição
    private String VL_BC_CONT;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Quantidade – Base de cálculo PIS
    private String QUANT_BC_PIS;
    //Alíquota do PIS (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor total da contribuição social apurada
    private String VL_CONT_APUR;
    //Valor total dos ajustes de acréscimo
    private String VL_AJUS_ACRES;
    //Valor total dos ajustes de redução
    private String VL_AJUS_REDUC;
    //Valor da contribuição a diferir no período
    private String VL_CONT_DIFER;
    //Valor da contribuição diferida em períodos anteriores
    private String VL_CONT_DIFER_ANT;
    //Valor Total da Contribuição do Período (08 + 09 – 10 – 11+12)
    private String VL_CONT_PER;
    
    private List<RegistroM211> resgistrosM211 = new ArrayList<RegistroM211>();
    private List<RegistroM220> resgistrosM220 = new ArrayList<RegistroM220>();
    private List<RegistroM230> resgistrosM230 = new ArrayList<RegistroM230>();
    
    RegistroM210 registroM210 = new RegistroM210();
    List<RegistroM210> registrosM210 = new ArrayList<RegistroM210>();
    
    protected List<RegistroM210> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM210 = new RegistroM210();
                registroM210.setCOD_CONT(RS.getString(""));
                registroM210.setVL_REC_BRT(RS.getString(""));
                registroM210.setVL_BC_CONT(RS.getString(""));
                registroM210.setALIQ_PIS(RS.getString(""));
                registroM210.setQUANT_BC_PIS(RS.getString(""));
                registroM210.setALIQ_PIS_QUANT(RS.getString(""));                       
                registroM210.setVL_CONT_APUR(RS.getString(""));
                registroM210.setVL_AJUS_ACRES(RS.getString(""));
                registroM210.setVL_AJUS_REDUC(RS.getString(""));
                registroM210.setVL_CONT_DIFER(RS.getString(""));                
                registroM210.setVL_CONT_DIFER_ANT(RS.getString(""));
                registroM210.setVL_CONT_PER(RS.getString(""));
                registrosM210.add(registroM210);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM210.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM210;
    }
    
    private StringBuilder conteudo;   

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M210").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCOD_CONT(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_BRT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_PIS(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_APUR()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_ACRES()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_REDUC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIFER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIFER_ANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_PER()), 2)).append("|");                                               
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM210.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }


    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CONT() {
        return COD_CONT;
    }

    public void setCOD_CONT(String COD_CONT) {
        this.COD_CONT = COD_CONT;
    }

    public String getVL_REC_BRT() {
        return VL_REC_BRT;
    }

    public void setVL_REC_BRT(String VL_REC_BRT) {
        this.VL_REC_BRT = VL_REC_BRT;
    }

    public String getVL_BC_CONT() {
        return VL_BC_CONT;
    }

    public void setVL_BC_CONT(String VL_BC_CONT) {
        this.VL_BC_CONT = VL_BC_CONT;
    }

    public String getALIQ_PIS() {
        return ALIQ_PIS;
    }

    public void setALIQ_PIS(String ALIQ_PIS) {
        this.ALIQ_PIS = ALIQ_PIS;
    }

    public String getQUANT_BC_PIS() {
        return QUANT_BC_PIS;
    }

    public void setQUANT_BC_PIS(String QUANT_BC_PIS) {
        this.QUANT_BC_PIS = QUANT_BC_PIS;
    }

    public String getALIQ_PIS_QUANT() {
        return ALIQ_PIS_QUANT;
    }

    public void setALIQ_PIS_QUANT(String ALIQ_PIS_QUANT) {
        this.ALIQ_PIS_QUANT = ALIQ_PIS_QUANT;
    }

    public String getVL_CONT_APUR() {
        return VL_CONT_APUR;
    }

    public void setVL_CONT_APUR(String VL_CONT_APUR) {
        this.VL_CONT_APUR = VL_CONT_APUR;
    }

    public String getVL_AJUS_ACRES() {
        return VL_AJUS_ACRES;
    }

    public void setVL_AJUS_ACRES(String VL_AJUS_ACRES) {
        this.VL_AJUS_ACRES = VL_AJUS_ACRES;
    }

    public String getVL_AJUS_REDUC() {
        return VL_AJUS_REDUC;
    }

    public void setVL_AJUS_REDUC(String VL_AJUS_REDUC) {
        this.VL_AJUS_REDUC = VL_AJUS_REDUC;
    }

    public String getVL_CONT_DIFER() {
        return VL_CONT_DIFER;
    }

    public void setVL_CONT_DIFER(String VL_CONT_DIFER) {
        this.VL_CONT_DIFER = VL_CONT_DIFER;
    }

    public String getVL_CONT_DIFER_ANT() {
        return VL_CONT_DIFER_ANT;
    }

    public void setVL_CONT_DIFER_ANT(String VL_CONT_DIFER_ANT) {
        this.VL_CONT_DIFER_ANT = VL_CONT_DIFER_ANT;
    }

    public String getVL_CONT_PER() {
        return VL_CONT_PER;
    }

    public void setVL_CONT_PER(String VL_CONT_PER) {
        this.VL_CONT_PER = VL_CONT_PER;
    }
   
}


class RegistroM211 {

    //Texto fixo contendo "M211"
    private String REG;
    /*Indicador do Tipo de Sociedade Cooperativa:
    01 – Cooperativa de Produção Agropecuária;
    02 – Cooperativa de Consumo;
    03 – Cooperativa de Crédito;
    04 – Cooperativa de Eletrificação Rural;
    05 – Cooperativa de Transporte Rodoviário de Cargas;
    06 – Cooperativa de Médicos;
    99 – Outras.*/
    private String IND_TIP_COOP;
    /*Valor da Base de Cálculo da Contribuição, conforme
    Registros escriturados nos Blocos A, C, D e F, antes
    das Exclusões das Cooperativas.*/
    private String VL_BC_CONT_ANT_EXC_COOP;
    /*Valor de Exclusão Especifica das Cooperativas em
    Geral, decorrente das Sobras Apuradas na DRE,
    destinadas a constituição do Fundo de Reserva e do
    FATES.*/
    private String VL_EXC_COOP_GER;
    /*Valor das Exclusões da Base de Cálculo Especifica do
    Tipo da Sociedade Cooperativa, conforme Campo 02
    (IND_TIP_COOP).*/
    private String VL_EXC_ESP_COOP;
    /*Valor da Base de Cálculo, Após as Exclusões
    Especificas da Sociedade Cooperativa (04 – 05 – 06) –
    Transportar para M210.*/
    private String VL_BC_CONT;
    
    private StringBuilder conteudo;

    RegistroM211 registroM211 = new RegistroM211();
    List<RegistroM211> registrosM211 = new ArrayList<RegistroM211>();
    
    protected List<RegistroM211> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM211 = new RegistroM211();
                registroM211.setIND_TIP_COOP(RS.getString(""));
                registroM211.setVL_BC_CONT_ANT_EXC_COOP(RS.getString(""));
                registroM211.setVL_EXC_COOP_GER(RS.getString(""));
                registroM211.setVL_EXC_ESP_COOP(RS.getString(""));
                registroM211.setVL_BC_CONT(RS.getString(""));                
                registrosM211.add(registroM211);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM211.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM211;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M211").append("|");       
            conteudo.append(geral.efdNumerico(getIND_TIP_COOP(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT_ANT_EXC_COOP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC_COOP_GER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC_ESP_COOP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT()), 2)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM211.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }


    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_TIP_COOP() {
        return IND_TIP_COOP;
    }

    public void setIND_TIP_COOP(String IND_TIP_COOP) {
        this.IND_TIP_COOP = IND_TIP_COOP;
    }

    public String getVL_BC_CONT_ANT_EXC_COOP() {
        return VL_BC_CONT_ANT_EXC_COOP;
    }

    public void setVL_BC_CONT_ANT_EXC_COOP(String VL_BC_CONT_ANT_EXC_COOP) {
        this.VL_BC_CONT_ANT_EXC_COOP = VL_BC_CONT_ANT_EXC_COOP;
    }

    public String getVL_EXC_COOP_GER() {
        return VL_EXC_COOP_GER;
    }

    public void setVL_EXC_COOP_GER(String VL_EXC_COOP_GER) {
        this.VL_EXC_COOP_GER = VL_EXC_COOP_GER;
    }

    public String getVL_EXC_ESP_COOP() {
        return VL_EXC_ESP_COOP;
    }

    public void setVL_EXC_ESP_COOP(String VL_EXC_ESP_COOP) {
        this.VL_EXC_ESP_COOP = VL_EXC_ESP_COOP;
    }

    public String getVL_BC_CONT() {
        return VL_BC_CONT;
    }

    public void setVL_BC_CONT(String VL_BC_CONT) {
        this.VL_BC_CONT = VL_BC_CONT;
    }
    
}


class RegistroM220 {

    //Texto fixo contendo "M220"    
    private String REG;
    /*Indicador do tipo de ajuste:
    0- Ajuste de redução;
    1- Ajuste de acréscimo.*/
    private String IND_AJ;
    //Valor do ajuste
    private String VL_AJ;
    //Código do ajuste, conforme a Tabela indicada no item 4.3.8
    private String COD_AJ;
    /*Número do processo, documento ou ato concessório ao qual o
    ajuste está vinculado, se houver.*/
    private String NUM_DOC;
    //Descrição resumida do ajuste.
    private String DESCR_AJ;
    //Data de referência do ajuste (ddmmaaaa)
    private String DT_REF;
    
    private StringBuilder conteudo;

    RegistroM220 registroM220 = new RegistroM220();
    List<RegistroM220> registrosM220 = new ArrayList<RegistroM220>();
    
    protected List<RegistroM220> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM220 = new RegistroM220();
                registroM220.setIND_AJ(RS.getString(""));
                registroM220.setVL_AJ(RS.getString(""));
                registroM220.setCOD_AJ(RS.getString(""));
                registroM220.setNUM_DOC(RS.getString(""));
                registroM220.setDESCR_AJ(RS.getString(""));
                registroM220.setDT_REF(RS.getString(""));                                      
                registrosM220.add(registroM220);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM220.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM220;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M220").append("|");       
            conteudo.append(geral.efdNumerico(getIND_AJ(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJ()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_AJ(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getNUM_DOC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getDESCR_AJ(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getDT_REF(), 8)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM220.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_AJ() {
        return IND_AJ;
    }

    public void setIND_AJ(String IND_AJ) {
        this.IND_AJ = IND_AJ;
    }

    public String getVL_AJ() {
        return VL_AJ;
    }

    public void setVL_AJ(String VL_AJ) {
        this.VL_AJ = VL_AJ;
    }

    public String getCOD_AJ() {
        return COD_AJ;
    }

    public void setCOD_AJ(String COD_AJ) {
        this.COD_AJ = COD_AJ;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDESCR_AJ() {
        return DESCR_AJ;
    }

    public void setDESCR_AJ(String DESCR_AJ) {
        this.DESCR_AJ = DESCR_AJ;
    }

    public String getDT_REF() {
        return DT_REF;
    }

    public void setDT_REF(String DT_REF) {
        this.DT_REF = DT_REF;
    }
    
}


class RegistroM230{
    //Texto fixo contendo "M230"
    private String REG;
    /*CNPJ da pessoa jurídica de direito público, empresa
    pública, sociedade de economia mista ou suas
    subsidiárias.*/
    private String CNPJ;
    //Valor Total das vendas no período
    private String VL_VEND;
    //Valor Total não recebido no período
    private String VL_NAO_RECEB;
    //Valor da Contribuição diferida no período
    private String VL_CONT_DIF;
    //Valor do Crédito diferido no período
    private String VL_CRED_DIF;
    /*Código de Tipo de Crédito diferido no período, conforme
    a Tabela 4.3.6.*/
    private String COD_CRED;
    
    private StringBuilder conteudo;

    RegistroM230 registroM230 = new RegistroM230();
    List<RegistroM230> registrosM230 = new ArrayList<RegistroM230>();
    
    protected List<RegistroM230> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM230 = new RegistroM230();
                registroM230.setCNPJ(RS.getString(""));
                registroM230.setVL_VEND(RS.getString(""));
                registroM230.setVL_NAO_RECEB(RS.getString(""));
                registroM230.setVL_CONT_DIF(RS.getString(""));
                registroM230.setVL_CRED_DIF(RS.getString(""));
                registroM230.setCOD_CRED(RS.getString(""));                                      
                registrosM230.add(registroM230);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM230.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM230;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M230").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCNPJ(), 14)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_VEND()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_NAO_RECEB()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIF()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DIF()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CRED(), 3)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM230.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getVL_VEND() {
        return VL_VEND;
    }

    public void setVL_VEND(String VL_VEND) {
        this.VL_VEND = VL_VEND;
    }

    public String getVL_NAO_RECEB() {
        return VL_NAO_RECEB;
    }

    public void setVL_NAO_RECEB(String VL_NAO_RECEB) {
        this.VL_NAO_RECEB = VL_NAO_RECEB;
    }

    public String getVL_CONT_DIF() {
        return VL_CONT_DIF;
    }

    public void setVL_CONT_DIF(String VL_CONT_DIF) {
        this.VL_CONT_DIF = VL_CONT_DIF;
    }

    public String getVL_CRED_DIF() {
        return VL_CRED_DIF;
    }

    public void setVL_CRED_DIF(String VL_CRED_DIF) {
        this.VL_CRED_DIF = VL_CRED_DIF;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }
    
}


class RegistroM300{
    //Texto fixo contendo "M300"

    private String REG;
    //Código da contribuição social diferida em períodos anteriores, conforme a Tabela 4.3.5.
    private String COD_CONT;
    /*Valor da Contribuição Apurada, diferida em períodos anteriores.*/
    private String VL_CONT_APUR_DIFER;
    /*Natureza do Crédito Diferido, vinculado à receita
    tributada no mercado interno, a descontar:
    01 – Crédito a Alíquota Básica;
    02 – Crédito a Alíquota Diferenciada;
    03 – Crédito a Alíquota por Unidade de Produto;
    04 – Crédito Presumido da Agroindústria.*/
    private String NAT_CRED_DESC;
    /*Valor do Crédito a Descontar vinculado à contribuição
    diferida.*/
    private String VL_CRED_DESC_DIFER;
    /*Valor da Contribuição a Recolher, diferida em períodos
    anteriores (Campo 03 – Campo 05)*/
    private String VL_CONT_DIFER_ANT;
    //Período de apuração da contribuição social e dos créditos
    private String PER_APUR;
    //Data de recebimento da receita, objeto de diferimento
    private String DT_RECEB;
    
    private StringBuilder conteudo;

    RegistroM300 registroM300 = new RegistroM300();
    List<RegistroM300> registrosM300 = new ArrayList<RegistroM300>();
    
    protected List<RegistroM300> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM300 = new RegistroM300();
                registroM300.setCOD_CONT(RS.getString(""));
                registroM300.setVL_CONT_APUR_DIFER(RS.getString(""));
                registroM300.setNAT_CRED_DESC(RS.getString(""));
                registroM300.setVL_CRED_DESC_DIFER(RS.getString(""));
                registroM300.setVL_CONT_DIFER_ANT(RS.getString(""));
                registroM300.setPER_APUR(RS.getString(""));   
                registroM300.setCOD_CONT(RS.getString(""));
                registroM300.setVL_CONT_APUR_DIFER(RS.getString(""));
                registroM300.setDT_RECEB(RS.getString(""));
                registrosM300.add(registroM300);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM300.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM300;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M300").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCOD_CONT(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_APUR_DIFER()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_CRED_DESC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DESC_DIFER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIFER_ANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getPER_APUR(), 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM300.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CONT() {
        return COD_CONT;
    }

    public void setCOD_CONT(String COD_CONT) {
        this.COD_CONT = COD_CONT;
    }

    public String getVL_CONT_APUR_DIFER() {
        return VL_CONT_APUR_DIFER;
    }

    public void setVL_CONT_APUR_DIFER(String VL_CONT_APUR_DIFER) {
        this.VL_CONT_APUR_DIFER = VL_CONT_APUR_DIFER;
    }

    public String getNAT_CRED_DESC() {
        return NAT_CRED_DESC;
    }

    public void setNAT_CRED_DESC(String NAT_CRED_DESC) {
        this.NAT_CRED_DESC = NAT_CRED_DESC;
    }

    public String getVL_CRED_DESC_DIFER() {
        return VL_CRED_DESC_DIFER;
    }

    public void setVL_CRED_DESC_DIFER(String VL_CRED_DESC_DIFER) {
        this.VL_CRED_DESC_DIFER = VL_CRED_DESC_DIFER;
    }

    public String getVL_CONT_DIFER_ANT() {
        return VL_CONT_DIFER_ANT;
    }

    public void setVL_CONT_DIFER_ANT(String VL_CONT_DIFER_ANT) {
        this.VL_CONT_DIFER_ANT = VL_CONT_DIFER_ANT;
    }

    public String getPER_APUR() {
        return PER_APUR;
    }

    public void setPER_APUR(String PER_APUR) {
        this.PER_APUR = PER_APUR;
    }

    public String getDT_RECEB() {
        return DT_RECEB;
    }

    public void setDT_RECEB(String DT_RECEB) {
        this.DT_RECEB = DT_RECEB;
    }
    
}


class RegistroM350{
    //Texto fixo contendo "M350"

    private String REG;
    //Valor Total da Folha de Salários
    private String VL_TOT_FOL;
    //Valor Total das Exclusões à Base de Cálculo
    private String VL_EXC_BC;
    //Valor Total da Base de Cálculo
    private String VL_TOT_BC;
    //Alíquota do PIS/PASEP – Folha de Salários
    private String ALIQ_PIS_FOL;
    /*Valor Total da Contribuição Social sobre a Folha de
    Salários*/
    private String VL_TOT_CONT_FOL;
    
    private StringBuilder conteudo;

    RegistroM350 registroM350 = new RegistroM350();
    List<RegistroM350> registrosM350 = new ArrayList<RegistroM350>();
    
    protected List<RegistroM350> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM350 = new RegistroM350();
                registroM350.setVL_TOT_FOL(RS.getString(""));
                registroM350.setVL_EXC_BC(RS.getString(""));
                registroM350.setVL_TOT_BC(RS.getString(""));
                registroM350.setALIQ_PIS_FOL(RS.getString(""));
                registroM350.setVL_TOT_CONT_FOL(RS.getString(""));                
                registrosM350.add(registroM350);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM350.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM350;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M350").append("|");       
            conteudo.append(geral.efdAlfanumerico(getVL_TOT_FOL(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC_BC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_TOT_BC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_FOL()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_FOL()), 2)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM350.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_TOT_FOL() {
        return VL_TOT_FOL;
    }

    public void setVL_TOT_FOL(String VL_TOT_FOL) {
        this.VL_TOT_FOL = VL_TOT_FOL;
    }

    public String getVL_EXC_BC() {
        return VL_EXC_BC;
    }

    public void setVL_EXC_BC(String VL_EXC_BC) {
        this.VL_EXC_BC = VL_EXC_BC;
    }

    public String getVL_TOT_BC() {
        return VL_TOT_BC;
    }

    public void setVL_TOT_BC(String VL_TOT_BC) {
        this.VL_TOT_BC = VL_TOT_BC;
    }

    public String getALIQ_PIS_FOL() {
        return ALIQ_PIS_FOL;
    }

    public void setALIQ_PIS_FOL(String ALIQ_PIS_FOL) {
        this.ALIQ_PIS_FOL = ALIQ_PIS_FOL;
    }

    public String getVL_TOT_CONT_FOL() {
        return VL_TOT_CONT_FOL;
    }

    public void setVL_TOT_CONT_FOL(String VL_TOT_CONT_FOL) {
        this.VL_TOT_CONT_FOL = VL_TOT_CONT_FOL;
    }
}


class RegistroM400{
    //Texto fixo contendo "M400”
    private String REG;
    /*Código de Situação Tributária – CST das demais receitas
    auferidas no período, sem incidência da contribuição, ou
    sem contribuição apurada a pagar, conforme a Tabela 4.3.3.*/
    private String CST_PIS;
    //Valor total da receita bruta no período
    private String VL_TOT_REC;
    //Código da conta analítica contábil debitada/creditada. C
    private String COD_CTA;
    //Descrição Complementar da Natureza da Receita
    private String DESC_COMPL;
    private List<RegistroM410> resgistrosM410 = new ArrayList<RegistroM410>();
    
    private StringBuilder conteudo;

    RegistroM400 registroM400 = new RegistroM400();
    List<RegistroM400> registrosM400 = new ArrayList<RegistroM400>();
    
    protected List<RegistroM400> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM400 = new RegistroM400();
                registroM400.setCST_PIS(RS.getString(""));
                registroM400.setVL_TOT_REC(RS.getString(""));
                registroM400.setCOD_CTA(RS.getString(""));
                registroM400.setDESC_COMPL(RS.getString(""));                      
                registrosM400.add(registroM400);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM400.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM400;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M400").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_REC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM400.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_TOT_REC() {
        return VL_TOT_REC;
    }

    public void setVL_TOT_REC(String VL_TOT_REC) {
        this.VL_TOT_REC = VL_TOT_REC;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }
}


class RegistroM410{
    //Texto fixo contendo "M410”

    private String REG;
    /*Natureza da Receita, conforme relação constante nas
    Tabelas de Detalhamento da Natureza da Receita por
    Situação Tributária abaixo:
    - Tabela 4.3.10: Produtos Sujeitos à Incidência
    Monofásica da Contribuição Social – Alíquotas
    Diferenciadas (CST 04 - Revenda);
    - Tabela 4.3.11: Produtos Sujeitos à Incidência
    Monofásica da Contribuição Social – Alíquotas por
    Unidade de Medida de Produto (CST 04 - Revenda);
    - Tabela 4.3.12: Produtos Sujeitos à Substituição
    Tributária da Contribuição Social (CST 05 - Revenda);
    - Tabela 4.3.13: Produtos Sujeitos à Alíquota Zero da
    Contribuição Social (CST 06);
    - Tabela 4.3.14: Operações com Isenção da Contribuição
    Social (CST 07);
    - Tabela 4.3.15: Operações sem Incidência da
    Contribuição Social (CST 08);
    - Tabela 4.3.16: Operações com Suspensão da
    Contribuição Social (CST 09).*/
    private String NAT_REC;
    /*Valor da receita bruta no período, relativo a natureza da
    receita (NAT_REC)*/
    private String VL_REC;
    //Código da conta analítica contábil debitada/creditada.
    private String COD_CTA;
    //Descrição Complementar da Natureza da Receita
    private String DESC_COMPL;
    private StringBuilder conteudo;
    
    RegistroM410 RegistroM410 = new RegistroM410();
    List<RegistroM410> registrosM410 = new ArrayList<RegistroM410>();
    
    protected List<RegistroM410> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroM410 = new RegistroM410();
                RegistroM410.setNAT_REC(RS.getString(""));
                RegistroM410.setVL_REC(RS.getString(""));
                RegistroM410.setCOD_CTA(RS.getString(""));
                RegistroM410.setDESC_COMPL(RS.getString(""));                      
                registrosM410.add(RegistroM410);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM410.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM410;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M410").append("|");       
            conteudo.append(geral.efdAlfanumerico(getNAT_REC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM410.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNAT_REC() {
        return NAT_REC;
    }

    public void setNAT_REC(String NAT_REC) {
        this.NAT_REC = NAT_REC;
    }

    public String getVL_REC() {
        return VL_REC;
    }

    public void setVL_REC(String VL_REC) {
        this.VL_REC = VL_REC;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }
}

class RegistroM500 {
    //Texto fixo contendo "M500"
    private String REG;
    /*Código de Tipo de Crédito apurado no período,
    conforme a Tabela 4.3.6.*/
    private String COD_CRED;
    /*Indicador de Crédito Oriundo de:
    0 – Operações próprias
    1 – Evento de incorporação, cisão ou fusão*/
    private String IND_CRED_ORI;
    //Valor da Base de Cálculo do Crédito
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Quantidade – Base de cálculo COFINS
    private String QUANT_BC_COFINS;
    //Alíquota da COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor total do crédito apurado no período
    private String VL_CRED;
    //Valor total dos ajustes de acréscimo
    private String VL_AJUS_ACRES;
    //Valor total dos ajustes de redução
    private String VL_AJUS_REDUC;
    //Valor total do crédito diferido no período
    private String VL_CRED_DIFER;
    //Valor Total do Crédito Disponível relativo ao Período (08 + 09 – 10 – 11)
    private String VL_CRED_DISP;
    /*Indicador de utilização do crédito disponível no
    período:
    0 – Utilização do valor total para desconto da
    contribuição apurada no período, no Registro
    M600;
    1 – Utilização de valor parcial para desconto da
    contribuição apurada no período, no Registro
    M600.*/
    private String IND_DESC_CRED;
    /*Valor do Crédito disponível, descontado da
    contribuição apurada no próprio período.
    Se IND_DESC_CRED=0, informar o valor total do
    Campo 12;
    Se IND_DESC_CRED=1, informar o valor parcial
    do Campo 12.*/
    private String VL_CRED_DESC;
    /*Saldo de créditos a utilizar em períodos futuros (12
    – 14)*/
    private String SLD_CRED;
    private List<RegistroM505> resgistrosM505 = new ArrayList<RegistroM505>();
    private List<RegistroM510> resgistrosM510 = new ArrayList<RegistroM510>();
    
    private StringBuilder conteudo;

    RegistroM500 RegistroM500 = new RegistroM500();
    List<RegistroM500> registrosM500 = new ArrayList<RegistroM500>();
    
    protected List<RegistroM500> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroM500 = new RegistroM500();
                RegistroM500.setCOD_CRED(RS.getString(""));
                RegistroM500.setIND_CRED_ORI(RS.getString(""));
                RegistroM500.setVL_BC_COFINS(RS.getString(""));
                RegistroM500.setALIQ_COFINS(RS.getString(""));  
                
                RegistroM500.setQUANT_BC_COFINS(RS.getString(""));
                RegistroM500.setALIQ_COFINS_QUANT(RS.getString("")); 
                RegistroM500.setVL_CRED(RS.getString(""));
                RegistroM500.setVL_AJUS_ACRES(RS.getString("")); 
                RegistroM500.setVL_AJUS_REDUC(RS.getString(""));
                RegistroM500.setVL_CRED_DIFER(RS.getString("")); 
                
                RegistroM500.setVL_CRED_DISP(RS.getString(""));
                RegistroM500.setIND_DESC_CRED(RS.getString("")); 
                RegistroM500.setVL_CRED_DESC(RS.getString(""));
                RegistroM500.setSLD_CRED(RS.getString(""));
                registrosM500.add(RegistroM500);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM500.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM500;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M500").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCOD_CRED(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_CRED_ORI(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_COFINS(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_ACRES()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_REDUC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DIFER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DISP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getIND_DESC_CRED(),1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getSLD_CRED()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM500.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getIND_CRED_ORI() {
        return IND_CRED_ORI;
    }

    public void setIND_CRED_ORI(String IND_CRED_ORI) {
        this.IND_CRED_ORI = IND_CRED_ORI;
    }

    public String getVL_BC_COFINS() {
        return VL_BC_COFINS;
    }

    public void setVL_BC_COFINS(String VL_BC_COFINS) {
        this.VL_BC_COFINS = VL_BC_COFINS;
    }

    public String getALIQ_COFINS() {
        return ALIQ_COFINS;
    }

    public void setALIQ_COFINS(String ALIQ_COFINS) {
        this.ALIQ_COFINS = ALIQ_COFINS;
    }

    public String getQUANT_BC_COFINS() {
        return QUANT_BC_COFINS;
    }

    public void setQUANT_BC_COFINS(String QUANT_BC_COFINS) {
        this.QUANT_BC_COFINS = QUANT_BC_COFINS;
    }

    public String getALIQ_COFINS_QUANT() {
        return ALIQ_COFINS_QUANT;
    }

    public void setALIQ_COFINS_QUANT(String ALIQ_COFINS_QUANT) {
        this.ALIQ_COFINS_QUANT = ALIQ_COFINS_QUANT;
    }

    public String getVL_CRED() {
        return VL_CRED;
    }

    public void setVL_CRED(String VL_CRED) {
        this.VL_CRED = VL_CRED;
    }

    public String getVL_AJUS_ACRES() {
        return VL_AJUS_ACRES;
    }

    public void setVL_AJUS_ACRES(String VL_AJUS_ACREC) {
        this.VL_AJUS_ACRES = VL_AJUS_ACREC;
    }

    public String getVL_AJUS_REDUC() {
        return VL_AJUS_REDUC;
    }

    public void setVL_AJUS_REDUC(String VL_AJUS_REDUC) {
        this.VL_AJUS_REDUC = VL_AJUS_REDUC;
    }

    public String getVL_CRED_DIFER() {
        return VL_CRED_DIFER;
    }

    public void setVL_CRED_DIFER(String VL_CRED_DIFER) {
        this.VL_CRED_DIFER = VL_CRED_DIFER;
    }

    public String getVL_CRED_DISP() {
        return VL_CRED_DISP;
    }

    public void setVL_CRED_DISP(String VL_CRED_DISP) {
        this.VL_CRED_DISP = VL_CRED_DISP;
    }

    public String getIND_DESC_CRED() {
        return IND_DESC_CRED;
    }

    public void setIND_DESC_CRED(String IND_DESC_CRED) {
        this.IND_DESC_CRED = IND_DESC_CRED;
    }

    public String getVL_CRED_DESC() {
        return VL_CRED_DESC;
    }

    public void setVL_CRED_DESC(String VL_CRED_DESC) {
        this.VL_CRED_DESC = VL_CRED_DESC;
    }

    public String getSLD_CRED() {
        return SLD_CRED;
    }

    public void setSLD_CRED(String SLD_CRED) {
        this.SLD_CRED = SLD_CRED;
    }
    
}

/*Os valores a serem escriturados nos registros filhos M505, vinculados a cada código de crédito (COD_CRED)
relacionados nos registros pais M500, com base nas informações escrituradas nos Blocos “0” e “C”, corresponderão:*/
class RegistroM505{
    //Texto fixo contendo "M505"
    private String REG;
    //Código da Base de Cálculo do Crédito apurado no período, conforme a Tabela 4.3.7.
    private String NAT_BC_CRED;
    /*Código da Situação Tributária referente ao crédito de
    COFINS (Tabela 4.3.4) vinculado ao tipo de crédito
    escriturado em M500.*/
    private String CST_COFINS;
    /*Valor Total da Base de Cálculo escriturada nos
    documentos e operações (Blocos “A”, “C”, “D” e “F”),
    referente ao CST_COFINS informado no Campo 03*/
    private String VL_BC_COFINS_TOT;
    /*Parcela do Valor Total da Base de Cálculo informada no
    Campo 04, vinculada a receitas com incidência
    cumulativa.
    Campo de preenchimento específico para a pessoa
    jurídica sujeita ao regime cumulativo e não-cumulativo da
    contribuição (COD_INC_TRIB = 3 do Registro 0110)*/
    private String VL_BC_COFINS_CUM;
    /*Valor Total da Base de Cálculo do Crédito, vinculada a
    receitas com incidência não-cumulativa (Campo 04 –
    Campo 05).*/
    private String VL_BC_COFINS_NC;
    /*Valor da Base de Cálculo do Crédito, vinculada ao tipo de
    Crédito escriturado em M500.
    - Para os CST_COFINS = “50”, “51”, “52”, “60”, “61” e
    “62”: Informar o valor do Campo 06
    (VL_BC_COFINS_NC);
    - Para os CST_COFINS = “53”, “54”, “55”, “56”, “63”,
    “64” “65” e “66” (Crédito sobre operações vinculadas a
    mais de um tipo de receita): Informar a parcela do valor
    do Campo 06 (VL_BC_COFINS_NC) vinculada
    especificamente ao tipo de crédito escriturado em M500.
    O valor deste campo será transportado para o Campo 04
    (VL_BC_COFINS) do registro M500.*/
    private String VL_BC_COFINS;
    /*Quantidade Total da Base de Cálculo do Crédito apurado
    em Unidade de Medida de Produto, escriturada nos
    documentos e operações (Blocos “A”, “C”, “D” e “F”),
    referente ao CST_COFINS informado no Campo 03*/
    private String QUANT_BC_COFINS_TOT;
    /*Parcela da base de cálculo do crédito em quantidade
    (campo 08) vinculada ao tipo de crédito escriturado em
    M500.
    - Para os CST_COFINS = “50”, “51” e “52”: Informar o
    valor do Campo 08 (QUANT_BC_COFINS);
    - Para os CST_COFINS = “53”, “54”, “55” e “56”
    (crédito vinculado a mais de um tipo de receita): Informar
    a parcela do valor do Campo 08 (QUANT_BC_COFINS)
    vinculada ao tipo de crédito escriturado em M500.
    O valor deste campo será transportado para o Campo 06
    (QUANT_BC_COFINS) do registro M500*/
    private String QUANT_BC_COFINS;
    //Descrição do crédito
    private String DESC_CRED;

    private StringBuilder conteudo;

    RegistroM505 RegistroM505 = new RegistroM505();
    List<RegistroM505> registrosM505 = new ArrayList<RegistroM505>();
    
    protected List<RegistroM505> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroM505 = new RegistroM505();
                RegistroM505.setNAT_BC_CRED(RS.getString(""));
                RegistroM505.setCST_COFINS(RS.getString(""));
                RegistroM505.setVL_BC_COFINS_TOT(RS.getString(""));
                RegistroM505.setVL_BC_COFINS_CUM(RS.getString(""));  
                
                RegistroM505.setVL_BC_COFINS_NC(RS.getString(""));
                RegistroM505.setVL_BC_COFINS(RS.getString("")); 
                RegistroM505.setQUANT_BC_COFINS_TOT(RS.getString(""));
                RegistroM505.setQUANT_BC_COFINS(RS.getString("")); 
                RegistroM505.setDESC_CRED(RS.getString(""));
               
                registrosM505.add(RegistroM505);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM505.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM505;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M505").append("|");       
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS_TOT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS_CUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS_NC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS_TOT()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_CRED(), 60)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM505.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNAT_BC_CRED() {
        return NAT_BC_CRED;
    }

    public void setNAT_BC_CRED(String NAT_BC_CRED) {
        this.NAT_BC_CRED = NAT_BC_CRED;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_BC_COFINS_TOT() {
        return VL_BC_COFINS_TOT;
    }

    public void setVL_BC_COFINS_TOT(String VL_BC_COFINS_TOT) {
        this.VL_BC_COFINS_TOT = VL_BC_COFINS_TOT;
    }

    public String getVL_BC_COFINS_CUM() {
        return VL_BC_COFINS_CUM;
    }

    public void setVL_BC_COFINS_CUM(String VL_BC_COFINS_CUM) {
        this.VL_BC_COFINS_CUM = VL_BC_COFINS_CUM;
    }

    public String getVL_BC_COFINS_NC() {
        return VL_BC_COFINS_NC;
    }

    public void setVL_BC_COFINS_NC(String VL_BC_COFINS_NC) {
        this.VL_BC_COFINS_NC = VL_BC_COFINS_NC;
    }

    public String getVL_BC_COFINS() {
        return VL_BC_COFINS;
    }

    public void setVL_BC_COFINS(String VL_BC_COFINS) {
        this.VL_BC_COFINS = VL_BC_COFINS;
    }

    public String getQUANT_BC_COFINS_TOT() {
        return QUANT_BC_COFINS_TOT;
    }

    public void setQUANT_BC_COFINS_TOT(String QUANT_BC_COFINS_TOT) {
        this.QUANT_BC_COFINS_TOT = QUANT_BC_COFINS_TOT;
    }

    public String getQUANT_BC_COFINS() {
        return QUANT_BC_COFINS;
    }

    public void setQUANT_BC_COFINS(String QUANT_BC_COFINS) {
        this.QUANT_BC_COFINS = QUANT_BC_COFINS;
    }

    public String getDESC_CRED() {
        return DESC_CRED;
    }

    public void setDESC_CRED(String DESC_CRED) {
        this.DESC_CRED = DESC_CRED;
    }
    
}

        
class RegistroM510{
    //Texto fixo contendo "M510"
    private String REG;
    /*Indicador do tipo de ajuste:
    0- Ajuste de redução;
    1- Ajuste de acréscimo.*/
    private String IND_AJ;
    //Valor do ajuste
    private String VL_AJ;
    //Código do ajuste, conforme a Tabela indicada no item 4.3.8.    
    private String COD_AJ;
    /*Número do processo, documento ou ato concessório ao qual o
    ajuste está vinculado, se houver*/
    private String NUM_DOC;
    //Descrição resumida do ajuste
    private String DESCR_AJ;
    //Data de referência do ajuste (ddmmaaaa)
    private String DT_REF;
    
    private StringBuilder conteudo;

    RegistroM510 RegistroM510 = new RegistroM510();
    List<RegistroM510> registrosM510 = new ArrayList<RegistroM510>();
    
    protected List<RegistroM510> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroM510 = new RegistroM510();
                RegistroM510.setIND_AJ(RS.getString(""));
                RegistroM510.setVL_AJ(RS.getString(""));
                RegistroM510.setCOD_AJ(RS.getString(""));
                RegistroM510.setNUM_DOC(RS.getString(""));                  
                RegistroM510.setDESCR_AJ(RS.getString(""));
                RegistroM510.setDT_REF(RS.getString(""));                 
               
                registrosM510.add(RegistroM510);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM510.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM510;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M510").append("|");       
            conteudo.append(geral.efdAlfanumerico(getIND_AJ(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJ()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_AJ(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC())).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESCR_AJ())).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_REF(), 8)).append("|");                        
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM510.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_AJ() {
        return IND_AJ;
    }

    public void setIND_AJ(String IND_AJ) {
        this.IND_AJ = IND_AJ;
    }

    public String getVL_AJ() {
        return VL_AJ;
    }

    public void setVL_AJ(String VL_AJ) {
        this.VL_AJ = VL_AJ;
    }

    public String getCOD_AJ() {
        return COD_AJ;
    }

    public void setCOD_AJ(String COD_AJ) {
        this.COD_AJ = COD_AJ;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDESCR_AJ() {
        return DESCR_AJ;
    }

    public void setDESCR_AJ(String DESCR_AJ) {
        this.DESCR_AJ = DESCR_AJ;
    }

    public String getDT_REF() {
        return DT_REF;
    }

    public void setDT_REF(String DT_REF) {
        this.DT_REF = DT_REF;
    }
}
        

class RegistroM600{
    //Texto fixo contendo "M600"
    private String REG;
    /*Valor Total da Contribuição Não Cumulativa do Período
    (recuperado do campo 13 do Registro M610, quando o
    campo “COD_CONT” = 01, 02, 03, 04, 32 e 71)*/
    private String VL_TOT_CONT_NC_PER;
    /*Valor do Crédito Descontado, Apurado no Próprio
    Período da Escrituração (recuperado do campo 14 do Registro M500)*/
    private String VL_TOT_CRED_DESC;
    /*Valor do Crédito Descontado, Apurado em Período de
    Apuração Anterior (recuperado do campo 13 do Registro
    1500)*/
    private String VL_TOT_CRED_DESC_ANT;
    /*Valor Total da Contribuição Não Cumulativa Devida (02
    - 03 - 04)*/
    private String VL_TOT_CONT_NC_DEV;
    /*Valor Retido na Fonte Deduzido no Período*/
    private String VL_RET_NC;
    //Outras Deduções no Período
    private String VL_OUT_DED_NC;
    //Valor da Contribuição Não Cumulativa a Recolher/Pagar (05 - 06 - 07)
    private String VL_CONT_NC_REC;
    /*Valor Total da Contribuição Cumulativa do Período
    (recuperado do campo 13 do Registro M610, quando o
    campo “COD_CONT” = 31, 32, 51, 52, 53, 54 e 72)*/
    private String VL_TOT_CONT_CUM_PER;
    //Valor Retido na Fonte Deduzido no Período
    private String VL_RET_CUM;
    //Outras Deduções no Período
    private String VL_OUT_DED_CUM;
    //Valor da Contribuição Cumulativa a Recolher/Pagar (09 - 10 - 11)
    private String VL_CONT_CUM_REC;
    //Valor Total da Contribuição a Recolher/Pagar no Período (08 + 12)
    private String VL_TOT_CONT_REC;
    private List<RegistroM610> resgistrosM610 = new ArrayList<RegistroM610>();
    
    private StringBuilder conteudo;

    RegistroM600 RegistroM600 = new RegistroM600();
    List<RegistroM600> registrosM600 = new ArrayList<RegistroM600>();
    
    protected List<RegistroM600> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroM600 = new RegistroM600();
                RegistroM600.setVL_TOT_CONT_NC_PER(RS.getString(""));
                RegistroM600.setVL_TOT_CRED_DESC(RS.getString(""));
                RegistroM600.setVL_TOT_CRED_DESC_ANT(RS.getString(""));
                RegistroM600.setVL_TOT_CONT_NC_DEV(RS.getString(""));                  
                RegistroM600.setVL_RET_NC(RS.getString(""));
                RegistroM600.setVL_OUT_DED_NC(RS.getString(""));                   
                RegistroM600.setVL_CONT_NC_REC(RS.getString(""));                  
                RegistroM600.setVL_TOT_CONT_CUM_PER(RS.getString(""));
                RegistroM600.setVL_RET_CUM(RS.getString(""));  
                RegistroM600.setVL_OUT_DED_CUM(RS.getString(""));
                RegistroM600.setVL_CONT_CUM_REC(RS.getString(""));                  
                RegistroM600.setVL_TOT_CONT_REC(RS.getString(""));               
               
                registrosM600.add(RegistroM600);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM600.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM600;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M600").append("|");       
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_NC_PER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CRED_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CRED_DESC_ANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_NC_DEV()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET_NC()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OUT_DED_NC()), 2)).append("|");                
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_NC_REC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_CUM_PER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET_CUM()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OUT_DED_CUM()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_CUM_REC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_REC()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM600.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_TOT_CONT_NC_PER() {
        return VL_TOT_CONT_NC_PER;
    }

    public void setVL_TOT_CONT_NC_PER(String VL_TOT_CONT_NC_PER) {
        this.VL_TOT_CONT_NC_PER = VL_TOT_CONT_NC_PER;
    }

    public String getVL_TOT_CRED_DESC() {
        return VL_TOT_CRED_DESC;
    }

    public void setVL_TOT_CRED_DESC(String VL_TOT_CRED_DESC) {
        this.VL_TOT_CRED_DESC = VL_TOT_CRED_DESC;
    }

    public String getVL_TOT_CRED_DESC_ANT() {
        return VL_TOT_CRED_DESC_ANT;
    }

    public void setVL_TOT_CRED_DESC_ANT(String VL_TOT_CRED_DESC_ANT) {
        this.VL_TOT_CRED_DESC_ANT = VL_TOT_CRED_DESC_ANT;
    }

    public String getVL_TOT_CONT_NC_DEV() {
        return VL_TOT_CONT_NC_DEV;
    }

    public void setVL_TOT_CONT_NC_DEV(String VL_TOT_CONT_NC_DEV) {
        this.VL_TOT_CONT_NC_DEV = VL_TOT_CONT_NC_DEV;
    }

    public String getVL_RET_NC() {
        return VL_RET_NC;
    }

    public void setVL_RET_NC(String VL_RET_NC) {
        this.VL_RET_NC = VL_RET_NC;
    }

    public String getVL_OUT_DED_NC() {
        return VL_OUT_DED_NC;
    }

    public void setVL_OUT_DED_NC(String VL_OUT_DED_NC) {
        this.VL_OUT_DED_NC = VL_OUT_DED_NC;
    }

    public String getVL_CONT_NC_REC() {
        return VL_CONT_NC_REC;
    }

    public void setVL_CONT_NC_REC(String VL_CONT_NC_REC) {
        this.VL_CONT_NC_REC = VL_CONT_NC_REC;
    }

    public String getVL_TOT_CONT_CUM_PER() {
        return VL_TOT_CONT_CUM_PER;
    }

    public void setVL_TOT_CONT_CUM_PER(String VL_TOT_CONT_CUM_PER) {
        this.VL_TOT_CONT_CUM_PER = VL_TOT_CONT_CUM_PER;
    }

    public String getVL_RET_CUM() {
        return VL_RET_CUM;
    }

    public void setVL_RET_CUM(String VL_RET_CUM) {
        this.VL_RET_CUM = VL_RET_CUM;
    }

    public String getVL_OUT_DED_CUM() {
        return VL_OUT_DED_CUM;
    }

    public void setVL_OUT_DED_CUM(String VL_OUT_DED_CUM) {
        this.VL_OUT_DED_CUM = VL_OUT_DED_CUM;
    }

    public String getVL_CONT_CUM_REC() {
        return VL_CONT_CUM_REC;
    }

    public void setVL_CONT_CUM_REC(String VL_CONT_CUM_REC) {
        this.VL_CONT_CUM_REC = VL_CONT_CUM_REC;
    }

    public String getVL_TOT_CONT_REC() {
        return VL_TOT_CONT_REC;
    }

    public void setVL_TOT_CONT_REC(String VL_TOT_CONT_REC) {
        this.VL_TOT_CONT_REC = VL_TOT_CONT_REC;
    }
}


class RegistroM610{
    //Texto fixo contendo "M610"
    private String REG;
    //Código da contribuição social apurada no período, conforme a Tabela 4.3.5.
    private String COD_CONT;
    //Valor da Receita Bruta
    private String VL_REC_BRT;
    //Valor da Base de Cálculo da Contribuição
    private String VL_BC_CONT;
    //Alíquota do COFINS (em percentual)
    private String ALIQ_COFINS;
    //Quantidade – Base de cálculo COFINS
    private String QUANT_BC_COFINS;
    //Alíquota do COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor total da contribuição social apurada
    private String VL_CONT_APUR;
    //Valor total dos ajustes de acréscimo
    private String VL_AJUS_ACRES;
    //Valor total dos ajustes de redução
    private String VL_AJUS_REDUC;
    //Valor da contribuição a diferir no período
    private String VL_CONT_DIFER;
    //Valor da contribuição diferida em períodos anteriores
    private String VL_CONT_DIFER_ANT;
    //Valor Total da Contribuição do Período (08 + 09 – 10 – 11 +12)
    private String VL_CONT_PER;

    private List<RegistroM611> resgistrosM611 = new ArrayList<RegistroM611>();
    private List<RegistroM620> resgistrosM620 = new ArrayList<RegistroM620>();
    private List<RegistroM630> resgistrosM630 = new ArrayList<RegistroM630>();
    
    RegistroM610 registroM610 = new RegistroM610();
    List<RegistroM610> registrosM610 = new ArrayList<RegistroM610>();
    
    protected List<RegistroM610> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM610 = new RegistroM610();
                registroM610.setCOD_CONT(RS.getString(""));
                registroM610.setVL_REC_BRT(RS.getString(""));
                registroM610.setVL_BC_CONT(RS.getString(""));
                registroM610.setALIQ_COFINS(RS.getString(""));                  
                registroM610.setQUANT_BC_COFINS(RS.getString(""));
                registroM610.setALIQ_COFINS_QUANT(RS.getString(""));                   
                registroM610.setVL_CONT_APUR(RS.getString(""));                  
                registroM610.setVL_AJUS_ACRES(RS.getString(""));
                registroM610.setVL_AJUS_REDUC(RS.getString(""));  
                registroM610.setVL_CONT_DIFER(RS.getString(""));
                registroM610.setVL_CONT_DIFER_ANT(RS.getString(""));                  
                registroM610.setVL_CONT_PER(RS.getString(""));               
               
                registrosM610.add(registroM610);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM610.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM610;
    }
    
    private StringBuilder conteudo;
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M610").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCOD_CONT(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_BRT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()),3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");                
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_APUR()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_ACRES()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJUS_REDUC()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIFER()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIFER_ANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_PER()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM610.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CONT() {
        return COD_CONT;
    }

    public void setCOD_CONT(String COD_CONT) {
        this.COD_CONT = COD_CONT;
    }

    public String getVL_REC_BRT() {
        return VL_REC_BRT;
    }

    public void setVL_REC_BRT(String VL_REC_BRT) {
        this.VL_REC_BRT = VL_REC_BRT;
    }

    public String getVL_BC_CONT() {
        return VL_BC_CONT;
    }

    public void setVL_BC_CONT(String VL_BC_CONT) {
        this.VL_BC_CONT = VL_BC_CONT;
    }

    public String getALIQ_COFINS() {
        return ALIQ_COFINS;
    }

    public void setALIQ_COFINS(String ALIQ_COFINS) {
        this.ALIQ_COFINS = ALIQ_COFINS;
    }

    public String getQUANT_BC_COFINS() {
        return QUANT_BC_COFINS;
    }

    public void setQUANT_BC_COFINS(String QUANT_BC_COFINS) {
        this.QUANT_BC_COFINS = QUANT_BC_COFINS;
    }

    public String getALIQ_COFINS_QUANT() {
        return ALIQ_COFINS_QUANT;
    }

    public void setALIQ_COFINS_QUANT(String ALIQ_COFINS_QUANT) {
        this.ALIQ_COFINS_QUANT = ALIQ_COFINS_QUANT;
    }

    public String getVL_CONT_APUR() {
        return VL_CONT_APUR;
    }

    public void setVL_CONT_APUR(String VL_CONT_APUR) {
        this.VL_CONT_APUR = VL_CONT_APUR;
    }

    public String getVL_AJUS_ACRES() {
        return VL_AJUS_ACRES;
    }

    public void setVL_AJUS_ACRES(String VL_AJUS_ACRES) {
        this.VL_AJUS_ACRES = VL_AJUS_ACRES;
    }

    public String getVL_AJUS_REDUC() {
        return VL_AJUS_REDUC;
    }

    public void setVL_AJUS_REDUC(String VL_AJUS_REDUC) {
        this.VL_AJUS_REDUC = VL_AJUS_REDUC;
    }

    public String getVL_CONT_DIFER() {
        return VL_CONT_DIFER;
    }

    public void setVL_CONT_DIFER(String VL_CONT_DIFER) {
        this.VL_CONT_DIFER = VL_CONT_DIFER;
    }

    public String getVL_CONT_DIFER_ANT() {
        return VL_CONT_DIFER_ANT;
    }

    public void setVL_CONT_DIFER_ANT(String VL_CONT_DIFER_ANT) {
        this.VL_CONT_DIFER_ANT = VL_CONT_DIFER_ANT;
    }

    public String getVL_CONT_PER() {
        return VL_CONT_PER;
    }

    public void setVL_CONT_PER(String VL_CONT_PER) {
        this.VL_CONT_PER = VL_CONT_PER;
    }
}


class RegistroM611{
    //Texto fixo contendo "M611"
    private String REG;
    /*Indicador do Tipo de Sociedade Cooperativa:
    01 – Cooperativa de Produção Agropecuária;
    02 – Cooperativa de Consumo;
    03 – Cooperativa de Crédito;
    04 – Cooperativa de Eletrificação Rural;
    05 – Cooperativa de Transporte Rodoviário de Cargas;
    06 – Cooperativa de Médicos;
    99 – Outras.*/
    private String IND_TIP_COOP;
    /*Valor da Base de Cálculo da Contribuição, conforme
    Registros escriturados nos Blocos A, C, D e F, antes das
    Exclusões das Sociedades Cooperativas.*/
    private String VL_BC_CONT_ANT_EXC_COOP;
    /*Valor de Exclusão Especifica das Cooperativas em Geral,
    decorrente das Sobras Apuradas na DRE, destinadas a
    constituição do Fundo de Reserva e do FATES.*/
    private String VL_EXC_COOP_GER;
    /*Valor das Exclusões da Base de Cálculo Especifica do
    Tipo da Sociedade Cooperativa, conforme Campo 02
    (IND_TIP_COOP).*/
    private String VL_EXC_ESP_COOP;
    /*Valor da Base de Cálculo, Após as Exclusões Especificas
    da Sociedade Cooperativa (04 – 05 – 06) – Transportar
    para M610.*/
    private String VL_BC_CONT;
    
    private StringBuilder conteudo;

    RegistroM611 registroM611 = new RegistroM611();
    List<RegistroM611> registrosM611 = new ArrayList<RegistroM611>();
    
    protected List<RegistroM611> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM611 = new RegistroM611();
                registroM611.setIND_TIP_COOP(RS.getString(""));
                registroM611.setVL_BC_CONT_ANT_EXC_COOP(RS.getString(""));
                registroM611.setVL_EXC_COOP_GER(RS.getString(""));
                registroM611.setVL_EXC_ESP_COOP(RS.getString(""));                  
                registroM611.setVL_BC_CONT(RS.getString(""));                           
               
                registrosM611.add(registroM611);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM611.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM611;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M611").append("|");       
            conteudo.append(geral.efdAlfanumerico(getIND_TIP_COOP(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT_ANT_EXC_COOP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC_COOP_GER()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC_ESP_COOP()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT()),2)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM611.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_TIP_COOP() {
        return IND_TIP_COOP;
    }

    public void setIND_TIP_COOP(String IND_TIP_COOP) {
        this.IND_TIP_COOP = IND_TIP_COOP;
    }

    public String getVL_BC_CONT_ANT_EXC_COOP() {
        return VL_BC_CONT_ANT_EXC_COOP;
    }

    public void setVL_BC_CONT_ANT_EXC_COOP(String VL_BC_CONT_ANT_EXC_COOP) {
        this.VL_BC_CONT_ANT_EXC_COOP = VL_BC_CONT_ANT_EXC_COOP;
    }

    public String getVL_EXC_COOP_GER() {
        return VL_EXC_COOP_GER;
    }

    public void setVL_EXC_COOP_GER(String VL_EXC_COOP_GER) {
        this.VL_EXC_COOP_GER = VL_EXC_COOP_GER;
    }

    public String getVL_EXC_ESP_COOP() {
        return VL_EXC_ESP_COOP;
    }

    public void setVL_EXC_ESP_COOP(String VL_EXC_ESP_COOP) {
        this.VL_EXC_ESP_COOP = VL_EXC_ESP_COOP;
    }

    public String getVL_BC_CONT() {
        return VL_BC_CONT;
    }

    public void setVL_BC_CONT(String VL_BC_CONT) {
        this.VL_BC_CONT = VL_BC_CONT;
    }
    
}


class RegistroM620{
    //Texto fixo contendo "M620"
    private String REG;
    /*Indicador do tipo de ajuste:
    0- Ajuste de redução;
    1- Ajuste de acréscimo.*/
    private String IND_AJ;
    //Valor do ajuste
    private String VL_AJ;
    //Código do ajuste, conforme a Tabela indicada no item 4.3.8
    private String COD_AJ;
    /*Número do processo, documento ou ato concessório ao qual o
    ajuste está vinculado, se houver.*/
    private String NUM_DOC;
    /*Descrição resumida do ajuste.*/
    private String DESCR_AJ;
    //Data de referência do ajuste (ddmmaaaa)
    private String DT_REF;
    
    private StringBuilder conteudo;

    RegistroM620 registroM620 = new RegistroM620();
    List<RegistroM620> registrosM620 = new ArrayList<RegistroM620>();
    
    protected List<RegistroM620> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM620 = new RegistroM620();
                registroM620.setIND_AJ(RS.getString(""));
                registroM620.setVL_AJ(RS.getString(""));
                registroM620.setCOD_AJ(RS.getString(""));
                registroM620.setNUM_DOC(RS.getString(""));                  
                registroM620.setDESCR_AJ(RS.getString(""));
                registroM620.setDT_REF(RS.getString(""));
               
                registrosM620.add(registroM620);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM620.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM620;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M620").append("|");       
            conteudo.append(geral.efdAlfanumerico(getIND_AJ(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJ()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_AJ()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getNUM_DOC()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getDESCR_AJ()),2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getDESCR_AJ()),2)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM620.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_AJ() {
        return IND_AJ;
    }

    public void setIND_AJ(String IND_AJ) {
        this.IND_AJ = IND_AJ;
    }

    public String getVL_AJ() {
        return VL_AJ;
    }

    public void setVL_AJ(String VL_AJ) {
        this.VL_AJ = VL_AJ;
    }

    public String getCOD_AJ() {
        return COD_AJ;
    }

    public void setCOD_AJ(String COD_AJ) {
        this.COD_AJ = COD_AJ;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDESCR_AJ() {
        return DESCR_AJ;
    }

    public void setDESCR_AJ(String DESCR_AJ) {
        this.DESCR_AJ = DESCR_AJ;
    }

    public String getDT_REF() {
        return DT_REF;
    }

    public void setDT_REF(String DT_REF) {
        this.DT_REF = DT_REF;
    }
}


class RegistroM630{
    //Texto fixo contendo "M630"
    private String REG;
    /*CNPJ da pessoa jurídica de direito público, empresa
    pública, sociedade de economia mista ou suas
    subsidiárias.*/
    private String CNPJ;
    //Valor Total das vendas no período
    private String VL_VEND;
    //Valor Total não recebido no período
    private String VL_NAO_RECEB;
    //Valor da Contribuição diferida no período
    private String VL_CONT_DIF;
    //Valor do Crédito diferido no período
    private String VL_CRED_DIF;
    /*Código de Tipo de Crédito diferido no período, conforme
    a Tabela 4.3.6.*/
    private String COD_CRED;

    private StringBuilder conteudo;

    RegistroM630 registroM630 = new RegistroM630();
    List<RegistroM630> registrosM630 = new ArrayList<RegistroM630>();
    
    protected List<RegistroM630> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM630 = new RegistroM630();
                registroM630.setCNPJ(RS.getString(""));
                registroM630.setVL_VEND(RS.getString(""));
                registroM630.setVL_NAO_RECEB(RS.getString(""));
                registroM630.setVL_CONT_DIF(RS.getString(""));                  
                registroM630.setVL_CRED_DIF(RS.getString(""));
                registroM630.setCOD_CRED(RS.getString(""));
               
                registrosM630.add(registroM630);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM630.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM630;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M630").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCNPJ(), 14)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_VEND()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_NAO_RECEB()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIF()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DIF()),2)).append("|");            
            conteudo.append(geral.efdAlfanumerico(getCOD_CRED(),3)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM630.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getVL_VEND() {
        return VL_VEND;
    }

    public void setVL_VEND(String VL_VEND) {
        this.VL_VEND = VL_VEND;
    }

    public String getVL_NAO_RECEB() {
        return VL_NAO_RECEB;
    }

    public void setVL_NAO_RECEB(String VL_NAO_RECEB) {
        this.VL_NAO_RECEB = VL_NAO_RECEB;
    }

    public String getVL_CONT_DIF() {
        return VL_CONT_DIF;
    }

    public void setVL_CONT_DIF(String VL_CONT_DIF) {
        this.VL_CONT_DIF = VL_CONT_DIF;
    }

    public String getVL_CRED_DIF() {
        return VL_CRED_DIF;
    }

    public void setVL_CRED_DIF(String VL_CRED_DIF) {
        this.VL_CRED_DIF = VL_CRED_DIF;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }
}


class RegistroM700{
    //Texto fixo contendo "M700"
    private String REG;
    /*Código da contribuição social diferida em períodos
    anteriores, conforme a Tabela 4.3.5.*/
    private String COD_CONT;
    //Valor da Contribuição Apurada, diferida em períodos anteriores.
    private String VL_CONT_APUR_DIFER;
    /*Natureza do Crédito Diferido, vinculado à receita
    tributada no mercado interno, a descontar:
    01 – Crédito a Alíquota Básica;
    02 – Crédito a Alíquota Diferenciada;
    03 – Crédito a Alíquota por Unidade de Produto;
    04 – Crédito Presumido da Agroindústria.*/
    private String NAT_CRED_DESC;
    /*Valor do Crédito a Descontar vinculado à contribuição
    diferida.*/
    private String VL_CRED_DESC_DIFER;
    /*Valor da Contribuição a Recolher, diferida em períodos
    anteriores (Campo 03 – Campo 05)*/
    private String VL_CONT_DIFER_ANT;
    /*Período de apuração da contribuição social e dos créditos
    diferidos (MMAAAA).*/
    private String PER_APUR;
    //Data de recebimento da receita, objeto de diferimento
    private String DT_RECEB;
    
    private StringBuilder conteudo;

    RegistroM700 registroM700 = new RegistroM700();
    List<RegistroM700> registrosM700 = new ArrayList<RegistroM700>();
    
    protected List<RegistroM700> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM700 = new RegistroM700();
                registroM700.setCOD_CONT(RS.getString(""));
                registroM700.setVL_CONT_APUR_DIFER(RS.getString(""));
                registroM700.setNAT_CRED_DESC(RS.getString(""));
                registroM700.setVL_CRED_DESC_DIFER(RS.getString(""));                  
                registroM700.setVL_CONT_DIFER_ANT(RS.getString(""));
                registroM700.setPER_APUR(RS.getString(""));
                registroM700.setDT_RECEB(RS.getString(""));
               
                registrosM700.add(registroM700);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM700.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM700;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M700").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCOD_CONT(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_APUR_DIFER()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_CRED_DESC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_DESC_DIFER()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_DIFER_ANT()),2)).append("|");            
            conteudo.append(geral.efdNumerico(getPER_APUR(),6)).append("|");
            conteudo.append(geral.efdNumerico(getDT_RECEB(),8)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM700.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CONT() {
        return COD_CONT;
    }

    public void setCOD_CONT(String COD_CONT) {
        this.COD_CONT = COD_CONT;
    }

    public String getVL_CONT_APUR_DIFER() {
        return VL_CONT_APUR_DIFER;
    }

    public void setVL_CONT_APUR_DIFER(String VL_CONT_APUR_DIFER) {
        this.VL_CONT_APUR_DIFER = VL_CONT_APUR_DIFER;
    }

    public String getNAT_CRED_DESC() {
        return NAT_CRED_DESC;
    }

    public void setNAT_CRED_DESC(String NAT_CRED_DESC) {
        this.NAT_CRED_DESC = NAT_CRED_DESC;
    }

    public String getVL_CRED_DESC_DIFER() {
        return VL_CRED_DESC_DIFER;
    }

    public void setVL_CRED_DESC_DIFER(String VL_CRED_DESC_DIFER) {
        this.VL_CRED_DESC_DIFER = VL_CRED_DESC_DIFER;
    }

    public String getVL_CONT_DIFER_ANT() {
        return VL_CONT_DIFER_ANT;
    }

    public void setVL_CONT_DIFER_ANT(String VL_CONT_DIFER_ANT) {
        this.VL_CONT_DIFER_ANT = VL_CONT_DIFER_ANT;
    }

    public String getPER_APUR() {
        return PER_APUR;
    }

    public void setPER_APUR(String PER_APUR) {
        this.PER_APUR = PER_APUR;
    }

    public String getDT_RECEB() {
        return DT_RECEB;
    }

    public void setDT_RECEB(String DT_RECEB) {
        this.DT_RECEB = DT_RECEB;
    }
    
    
}


class RegistroM800{
    //Texto fixo contendo "M800”
    private String REG;
    /*Código de Situação Tributária – CST das demais receitas
    auferidas no período, sem incidência da contribuição, ou
    sem contribuição apurada a pagar, conforme a Tabela 4.3.4.*/
    private String CST_COFINS;
    /*Valor total da receita bruta no período.*/
    private String VL_TOT_REC;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Descrição Complementar da Natureza da Receita
    private String DESC_COMPL;
    private List<RegistroM810> resgistrosM810 = new ArrayList<RegistroM810>();
    
    private StringBuilder conteudo;

    RegistroM800 registroM800 = new RegistroM800();
    List<RegistroM800> registrosM800 = new ArrayList<RegistroM800>();
    
    protected List<RegistroM800> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM800 = new RegistroM800();
                registroM800.setCST_COFINS(RS.getString(""));
                registroM800.setVL_TOT_REC(RS.getString(""));
                registroM800.setCOD_CTA(RS.getString(""));
                registroM800.setDESC_COMPL(RS.getString(""));                                 
               
                registrosM800.add(registroM800);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM800.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM800;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M800").append("|");       
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_REC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM800.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }    

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_TOT_REC() {
        return VL_TOT_REC;
    }

    public void setVL_TOT_REC(String VL_TOT_REC) {
        this.VL_TOT_REC = VL_TOT_REC;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }
}


class RegistroM810{
    //Texto fixo contendo "M810”
    private String REG;
    /*Natureza da Receita, conforme relação constante nas
    Tabelas de Detalhamento da Natureza da Receita por
    Situação Tributária abaixo:
    - Tabela 4.3.10: Produtos Sujeitos à Incidência
    Monofásica da Contribuição Social – Alíquotas
    Diferenciadas (CST 04 - Revenda);
    - Tabela 4.3.11: Produtos Sujeitos à Incidência
    Monofásica da Contribuição Social – Alíquotas por
    Unidade de Medida de Produto (CST 04 - Revenda);
    - Tabela 4.3.12: Produtos Sujeitos à Substituição
    Tributária da Contribuição Social (CST 05 - Revenda);
    - Tabela 4.3.13: Produtos Sujeitos à Alíquota Zero da
    Contribuição Social (CST 06);
    - Tabela 4.3.14: Operações com Isenção da Contribuição
    Social (CST 07);
    - Tabela 4.3.15: Operações sem Incidência da
    Contribuição Social (CST 08);
    - Tabela 4.3.16: Operações com Suspensão da
    Contribuição Social (CST 09).*/
    private String NAT_REC;
    //Valor da receita bruta no período, relativo a natureza da receita (NAT_REC)
    private String VL_REC;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Descrição Complementar da Natureza da Receita.
    private String DESC_COMPL;
    
    private StringBuilder conteudo;

    RegistroM810 registroM810 = new RegistroM810();
    List<RegistroM810> registrosM810 = new ArrayList<RegistroM810>();
    
    protected List<RegistroM810> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM810 = new RegistroM810();
                registroM810.setNAT_REC(RS.getString(""));
                registroM810.setVL_REC(RS.getString(""));
                registroM810.setCOD_CTA(RS.getString(""));
                registroM810.setDESC_COMPL(RS.getString(""));                                 
               
                registrosM810.add(registroM810);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM810.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM810;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M810").append("|");       
            conteudo.append(geral.efdAlfanumerico(getNAT_REC(), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM810.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }   

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNAT_REC() {
        return NAT_REC;
    }

    public void setNAT_REC(String NAT_REC) {
        this.NAT_REC = NAT_REC;
    }

    public String getVL_REC() {
        return VL_REC;
    }

    public void setVL_REC(String VL_REC) {
        this.VL_REC = VL_REC;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }
    
}

class RegistroM990 {

    private String REG;
    private String QTD_LIN_M;

    private StringBuilder conteudo;

    RegistroM990 registroM990 = new RegistroM990();
    List<RegistroM990> registrosM990 = new ArrayList<RegistroM990>();
    
    protected List<RegistroM990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroM990 = new RegistroM990();
                registroM990.setQTD_LIN_M(RS.getString(""));                                                
               
                registrosM990.add(registroM990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroM990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosM990;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|M990").append("|");       
            conteudo.append(geral.efdAlfanumerico(getQTD_LIN_M())).append("|");           
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroM990.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }   
    
    public String getQTD_LIN_M() {
        return QTD_LIN_M;
    }

    public void setQTD_LIN_M(String QTD_LIN_M) {
        this.QTD_LIN_M = QTD_LIN_M;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}