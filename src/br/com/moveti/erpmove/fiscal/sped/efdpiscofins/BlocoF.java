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
class BlocoF {
   RegistroF001 registroF001 = new RegistroF001();
   List<RegistroF010> resgistrosF010 = new ArrayList<RegistroF010>();
   private conexao conexao;
   private ResultSet RS, RS_;
   private StringBuilder conteudo;
    
      public BlocoF() {
        conexao = new conexao();
        conteudo = new StringBuilder();

        // Busca dos dados
    }
}

//ABERTURA
class RegistroF001 {

    private String REG;
    private String IND_MOV;
    
    private StringBuilder conteudo;

    RegistroF001 registroF001 = new RegistroF001();
    List<RegistroF001> registrosF001 = new ArrayList<RegistroF001>();
    
    protected List<RegistroF001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroF001 = new RegistroF001();
                registroF001.setIND_MOV(RS.getString(""));                         
                
                registrosF001.add(registroF001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF001;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F001").append("|");
            conteudo.append(geral.efdRemoveSinais(getIND_MOV())).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
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

//IDENTIFICAÇÃO DO ESTABELECIMENTO


class RegistroF010 {
    
    //Texto fixo contendo “F010”.
    private String REG;
    //Número de inscrição do estabelecimento no CNPJ.
    private String CNPJ;  
    
    private StringBuilder conteudo;

    RegistroF010 registroF010 = new RegistroF010();
    List<RegistroF010> registrosF010 = new ArrayList<RegistroF010>();
    
    protected List<RegistroF010> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroF010 = new RegistroF010();
                registroF010.setCNPJ(RS.getString(""));                         
                
                registrosF010.add(registroF010);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF010.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF010;
    }

    protected StringBuilder gerarRegistro() {
        try {
            getConteudo().append("|F010").append("|");
            getConteudo().append(geral.efdRemoveSinais(getCNPJ())).append("|");            
            getConteudo().append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return getConteudo();
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

    public StringBuilder getConteudo() {
        return conteudo;
    }

    public void setConteudo(StringBuilder conteudo) {
        this.conteudo = conteudo;
    }
}


class RegistroF100 {

    //Texto fixo contendo "F100"
    private String REG;
    //Indicador do Tipo da Operação:
    //0 – Operação Representativa de Aquisição, Custos,Despesa ou Encargos, ou Receitas, Sujeita à Incidência de Crédito de PIS/Pasep ou Cofins (CST 50 a 66).
    //1 – Operação Representativa de Receita Auferida Sujeita ao Pagamento da Contribuição para o PIS/Pasep e da Cofins (CST 01, 02, 03 ou 05).
    //2 - Operação Representativa de Receita Auferida Não Sujeita ao Pagamento da Contribuição para o PIS/Pasep e da Cofins (CST 04, 06, 07, 08, 09, 49 ou 99).
    private String IND_OPER;
    //Código do participante (Campo 02 do Registro 0150) C
    private String COD_PART;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Data da Operação (ddmmaaaa)
    private String DT_OPER;
    //Valor da Operação/Item
    private String VL_OPER;
    //Código da Situação Tributária referente ao PIS/PASEP,conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da Base de Cálculo dos Créditos, conforme a tabela indicada no item 4.3.7, caso seja informado
    //código representativo de crédito nos Campos 07 (CST_PIS) e 11 (CST_COFINS).
    private String NAT_BC_CRED;
    //Indicador da origem do crédito:
    //0 – Operação no Mercado Interno
    //1 – Operação de Importação
    private String IND_ORIG_CRED;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Código do Centro de Custos
    private String COD_CCUS;
    //Descrição do Documento/Operação
    private String DESC_DOC_OPER;
    
    List<RegistroF111> registrosF111 = new ArrayList<RegistroF111>();
    
    private StringBuilder conteudo;

    RegistroF100 RegistroF100 = new RegistroF100();
    List<RegistroF100> registrosF100 = new ArrayList<RegistroF100>();
    
    protected List<RegistroF100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroF100 = new RegistroF100();
                RegistroF100.setIND_OPER(RS.getString(""));
                RegistroF100.setCOD_PART(RS.getString(""));
                RegistroF100.setCOD_ITEM(RS.getString(""));
                RegistroF100.setDT_OPER(RS.getString(""));
                RegistroF100.setVL_OPER(RS.getString(""));
                RegistroF100.setCST_PIS(RS.getString(""));
                RegistroF100.setVL_BC_PIS(RS.getString(""));
                RegistroF100.setALIQ_PIS(RS.getString(""));
                RegistroF100.setVL_PIS(RS.getString(""));
                RegistroF100.setCST_COFINS(RS.getString(""));
                RegistroF100.setVL_BC_COFINS(RS.getString(""));
                RegistroF100.setALIQ_COFINS(RS.getString(""));
                RegistroF100.setVL_COFINS(RS.getString(""));
                RegistroF100.setNAT_BC_CRED(RS.getString(""));
                RegistroF100.setIND_ORIG_CRED(RS.getString(""));
                RegistroF100.setCOD_CTA(RS.getString(""));
                RegistroF100.setCOD_CCUS(RS.getString(""));
                RegistroF100.setDESC_DOC_OPER(RS.getString(""));                
                                
                registrosF100.add(RegistroF100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF100;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F100").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_OPER(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_OPER(), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OPER()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_ORIG_CRED(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CCUS(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_DOC_OPER())).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF100.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_OPER() {
        return IND_OPER;
    }

    public void setIND_OPER(String IND_OPER) {
        this.IND_OPER = IND_OPER;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getDT_OPER() {
        return DT_OPER;
    }

    public void setDT_OPER(String DT_OPER) {
        this.DT_OPER = DT_OPER;
    }

    public String getVL_OPER() {
        return VL_OPER;
    }

    public void setVL_OPER(String VL_OPER) {
        this.VL_OPER = VL_OPER;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getNAT_BC_CRED() {
        return NAT_BC_CRED;
    }

    public void setNAT_BC_CRED(String NAT_BC_CRED) {
        this.NAT_BC_CRED = NAT_BC_CRED;
    }

    public String getIND_ORIG_CRED() {
        return IND_ORIG_CRED;
    }

    public void setIND_ORIG_CRED(String IND_ORIG_CRED) {
        this.IND_ORIG_CRED = IND_ORIG_CRED;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getCOD_CCUS() {
        return COD_CCUS;
    }

    public void setCOD_CCUS(String COD_CCUS) {
        this.COD_CCUS = COD_CCUS;
    }

    public String getDESC_DOC_OPER() {
        return DESC_DOC_OPER;
    }

    public void setDESC_DOC_OPER(String DESC_DOC_OPER) {
        this.DESC_DOC_OPER = DESC_DOC_OPER;
    }
   
    
}


class RegistroF111 {

    private String REG;
    private String NUM_PROC;
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroF111 registroF111 = new RegistroF111();
    List<RegistroF111> registrosF111 = new ArrayList<RegistroF111>();
    
    protected List<RegistroF111> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroF111 = new RegistroF111();
                registroF111.setNUM_PROC(RS.getString(""));
                registroF111.setIND_PROC(RS.getString(""));                              
                                
                registrosF111.add(registroF111);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF111;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F111").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 60)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF111.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
    
}



class RegistroF120{

    //Texto fixo contendo "F120"
    private String REG;
    /*Código da Base de Cálculo do Crédito sobre Bens
    Incorporados ao Ativo Imobilizado, conforme a Tabela indicada no item 4.3.7:
    09 = Crédito com Base nos Encargos de Depreciação;
    11 = Crédito com Base nos Encargos de Amortização*/
    private String NAT_BC_CRED;
    /*Identificação dos Bens/Grupo de Bens
    Incorporados ao Ativo Imobilizado:
    01 = Edificações e Benfeitorias em Imóveis Próprios;
    02 = Edificações e Benfeitorias em Imóveis de Terceiros;
    03 = Instalações;
    04 = Máquinas;
    05 = Equipamentos;
    06 = Veículos;
    99 = Outros .*/
    private String IDENT_BEM_IMOB;
//    Indicador da origem do bem incorporado ao ativo imobilizado, gerador de crédito:
//    0 – Aquisição no Mercado Interno 
//    1 – Aquisição no Mercado Externo (Importação)
    private String IND_ORIG_CRED;
//    Indicador da Utilização dos Bens Incorporados ao Ativo Imobilizado:
//    1 – Produção de Bens Destinados a Venda;
//    2 – Prestação de Serviços;
//    3 – Locação a Terceiros;
//    9 – Outros.
    private String IND_UTIL_BEM_IMOB;
    //Valor do Encargo de Depreciação/Amortização Incorrido no Período
    private String VL_OPER_DEP;
    //Parcela do Valor do Encargo de Depreciação/Amortização a excluir da base de cálculo de Crédito
    private String PARC_OPER_NAO_BC_CRED;
    //Código da Situação Tributária referente ao PIS/PASEP, conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Base de cálculo do Crédito de PIS/PASEP no período (06 – 07)
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do Crédito de PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Base de Cálculo do Crédito da COFINS no período (06 – 07)
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor do crédito da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Código do Centro de Custos
    private String COD_CCUS;
    //Descrição complementar do bem ou grupo de bens,com crédito apurado com base nos encargos de depreciação ou amortização.
    private String DESC_BEM_IMOB;
    
    List<RegistroF129> registrosF129 = new ArrayList<RegistroF129>();
    
    private StringBuilder conteudo;

    RegistroF120 RegistroF120 = new RegistroF120();
    List<RegistroF120> registrosF120 = new ArrayList<RegistroF120>();
    
    protected List<RegistroF120> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                RegistroF120 = new RegistroF120();
                RegistroF120.setNAT_BC_CRED(RS.getString(""));
                RegistroF120.setIDENT_BEM_IMOB(RS.getString(""));
                RegistroF120.setIND_ORIG_CRED(RS.getString(""));
                RegistroF120.setIND_UTIL_BEM_IMOB(RS.getString(""));
                RegistroF120.setVL_OPER_DEP(RS.getString(""));
                RegistroF120.setPARC_OPER_NAO_BC_CRED(RS.getString(""));
                RegistroF120.setCST_PIS(RS.getString(""));                
                RegistroF120.setVL_BC_PIS(RS.getString(""));
                RegistroF120.setALIQ_PIS(RS.getString(""));
                RegistroF120.setVL_PIS(RS.getString(""));
                RegistroF120.setCST_COFINS(RS.getString(""));                
                RegistroF120.setVL_BC_COFINS(RS.getString(""));
                RegistroF120.setALIQ_COFINS(RS.getString(""));
                RegistroF120.setVL_COFINS(RS.getString(""));
                RegistroF120.setCOD_CTA(RS.getString(""));
                RegistroF120.setCOD_CCUS(RS.getString(""));
                RegistroF120.setDESC_BEM_IMOB(RS.getString(""));
                                
                registrosF120.add(RegistroF120);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF120.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF120;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F120").append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIDENT_BEM_IMOB(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_ORIG_CRED(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_UTIL_BEM_IMOB(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OPER_DEP()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getPARC_OPER_NAO_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");  
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CCUS(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_BEM_IMOB())).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF120.class.getName()).log(Level.SEVERE, null, e);
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

    public String getIDENT_BEM_IMOB() {
        return IDENT_BEM_IMOB;
    }

    public void setIDENT_BEM_IMOB(String IDENT_BEM_IMOB) {
        this.IDENT_BEM_IMOB = IDENT_BEM_IMOB;
    }

    public String getIND_ORIG_CRED() {
        return IND_ORIG_CRED;
    }

    public void setIND_ORIG_CRED(String IND_ORIG_CRED) {
        this.IND_ORIG_CRED = IND_ORIG_CRED;
    }

    public String getIND_UTIL_BEM_IMOB() {
        return IND_UTIL_BEM_IMOB;
    }

    public void setIND_UTIL_BEM_IMOB(String IND_UTIL_BEM_IMOB) {
        this.IND_UTIL_BEM_IMOB = IND_UTIL_BEM_IMOB;
    }

    public String getVL_OPER_DEP() {
        return VL_OPER_DEP;
    }

    public void setVL_OPER_DEP(String VL_OPER_DEP) {
        this.VL_OPER_DEP = VL_OPER_DEP;
    }

    public String getPARC_OPER_NAO_BC_CRED() {
        return PARC_OPER_NAO_BC_CRED;
    }

    public void setPARC_OPER_NAO_BC_CRED(String PARC_OPER_NAO_BC_CRED) {
        this.PARC_OPER_NAO_BC_CRED = PARC_OPER_NAO_BC_CRED;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getCOD_CCUS() {
        return COD_CCUS;
    }

    public void setCOD_CCUS(String COD_CCUS) {
        this.COD_CCUS = COD_CCUS;
    }

    public String getDESC_BEM_IMOB() {
        return DESC_BEM_IMOB;
    }

    public void setDESC_BEM_IMOB(String DESC_BEM_IMOB) {
        this.DESC_BEM_IMOB = DESC_BEM_IMOB;
    }
        
}


class RegistroF129 {

    //Texto fixo contendo "F129"
    private String REG;
    //Identificação do processo ou ato concessório. C
    private String NUM_PROC;
    /*Indicador da origem do processo:
    1 - Justiça Federal;
    3 – Secretaria da Receita Federal do Brasil
    9 – Outros.*/
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroF129 registroF129 = new RegistroF129();
    List<RegistroF129> registrosF129 = new ArrayList<RegistroF129>();
    
    protected List<RegistroF129> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroF129 = new RegistroF129();
                registroF129.setNUM_PROC(RS.getString(""));
                registroF129.setIND_PROC(RS.getString(""));                
                                
                registrosF129.add(registroF129);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF129.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF129;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F129").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");           
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
}


class RegistroF130 {
    //Texto fixo contendo "F130"
    private String REG;
    /*Texto fixo contendo "10" (Código da Base de Cálculo do Crédito sobre Bens Incorporados ao Ativo Imobilizado, conforme a Tabela indicada no item 4.3.7)*/
    private String NAT_BC_CRED;
    /*Identificação dos Bens/Grupo de Bens Incorporados ao Ativo Imobilizado:
    01 = Edificações e Benfeitorias;
    03 = Instalações;
    04 = Máquinas;
    05 = Equipamentos;
    06 = Veículos;
    99 = Outros Bens Incorporados ao Ativo Imobilizado.*/
    private String IDENT_BEM_IMOB;
    /*Indicador da origem do bem incorporado ao ativo imobilizado, gerador de crédito:
    0 – Aquisição no Mercado Interno
    1 – Aquisição no Mercado Externo (Importação)*/
    private String IND_ORIG_CRED;
    //Indicador da Utilização dos Bens Incorporados ao Ativo Imobilizado:
//    1 – Produção de Bens Destinados a Venda;
//    2 – Prestação de Serviços;
//    3 – Locação a Terceiros;
//    9 – Outros
    private String IND_UTIL_BEM_IMOB;
    //Mês/Ano de Aquisição dos Bens Incorporados ao Ativo Imobilizado, com apuração de crédito com base no valor de aquisição.
    private String MES_OPER_AQUIS;
    //Valor de Aquisição dos Bens Incorporados ao Ativo Imobilizado – Crédito com base no valor de aquisição.
    private String VL_OPER_AQUIS;
    //Parcela do Valor de Aquisição a excluir da base de cálculo de Crédito
    private String PARC_OPER_NAO_BC_CRED;
    /*Valor da Base de Cálculo do Crédito sobre Bens
    Incorporados ao Ativo Imobilizado (07 – 08)*/
    private String VL_BC_CRED;
    /*Indicador do Número de Parcelas a serem
    apropriadas (Crédito sobre Valor de Aquisição):
    1 – Integral (Mês de Aquisição);
    2 – 12 Meses;
    3 – 24 Meses;
    4 – 48 Meses;
    5 – 6 Meses (Embalagens de bebidas frias)
    9 – Outra periodicidade definida em Lei.*/
    private String IND_NR_PARC;
    //Código da Situação Tributária referente ao PIS/PASEP, conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Base de cálculo Mensal do Crédito de PIS/PASEP,conforme indicador informado no campo 10.
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP
    private String ALIQ_PIS;
    //Valor do Crédito de PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Base de Cálculo Mensal do Crédito da COFINS,conforme indicador informado no campo 10.
    private String VL_BC_COFINS;
    //Alíquota da COFINS
    private String ALIQ_COFINS;
    //Valor do crédito da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Código do Centro de Custos
    private String COD_CCUS;
    //Descrição complementar do bem ou grupo de bens,com crédito apurado com base no valor de aquisição.
    private String DESC_BEM_IMOB;

    List<RegistroF139> registrosF139 = new ArrayList<RegistroF139>();
    
    private StringBuilder conteudo;

    RegistroF130 registroF130 = new RegistroF130();
    List<RegistroF130> registrosF130 = new ArrayList<RegistroF130>();
    
    protected List<RegistroF130> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF130 = new RegistroF130();
                registroF130.setNAT_BC_CRED(RS.getString(""));
                registroF130.setIDENT_BEM_IMOB(RS.getString(""));
                registroF130.setIND_ORIG_CRED(RS.getString(""));
                registroF130.setIND_UTIL_BEM_IMOB(RS.getString(""));
                registroF130.setMES_OPER_AQUIS(RS.getString(""));
                registroF130.setVL_OPER_AQUIS(RS.getString(""));
                registroF130.setPARC_OPER_NAO_BC_CRED(RS.getString(""));
                registroF130.setVL_BC_CRED(RS.getString(""));
                registroF130.setIND_NR_PARC(RS.getString(""));
                registroF130.setCST_PIS(RS.getString(""));
                registroF130.setVL_BC_PIS(RS.getString(""));
                registroF130.setALIQ_PIS(RS.getString(""));                
                registroF130.setVL_PIS(RS.getString(""));
                registroF130.setCST_COFINS(RS.getString(""));
                registroF130.setVL_BC_COFINS(RS.getString(""));
                registroF130.setALIQ_COFINS(RS.getString(""));                
                registroF130.setVL_COFINS(RS.getString(""));
                registroF130.setCOD_CTA(RS.getString(""));
                registroF130.setCOD_CCUS(RS.getString(""));
                registroF130.setDESC_BEM_IMOB(RS.getString(""));
                                
                registrosF130.add(registroF130);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF130.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF130;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F130").append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIDENT_BEM_IMOB(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_ORIG_CRED(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_UTIL_BEM_IMOB(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getMES_OPER_AQUIS(), 6)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OPER_AQUIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getPARC_OPER_NAO_BC_CRED()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CRED()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getIND_NR_PARC(), 1)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");  
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CCUS(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_BEM_IMOB())).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
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

    public String getIDENT_BEM_IMOB() {
        return IDENT_BEM_IMOB;
    }

    public void setIDENT_BEM_IMOB(String IDENT_BEM_IMOB) {
        this.IDENT_BEM_IMOB = IDENT_BEM_IMOB;
    }

    public String getIND_ORIG_CRED() {
        return IND_ORIG_CRED;
    }

    public void setIND_ORIG_CRED(String IND_ORIG_CRED) {
        this.IND_ORIG_CRED = IND_ORIG_CRED;
    }

    public String getIND_UTIL_BEM_IMOB() {
        return IND_UTIL_BEM_IMOB;
    }

    public void setIND_UTIL_BEM_IMOB(String IND_UTIL_BEM_IMOB) {
        this.IND_UTIL_BEM_IMOB = IND_UTIL_BEM_IMOB;
    }

    public String getMES_OPER_AQUIS() {
        return MES_OPER_AQUIS;
    }

    public void setMES_OPER_AQUIS(String MES_OPER_AQUIS) {
        this.MES_OPER_AQUIS = MES_OPER_AQUIS;
    }

    public String getVL_OPER_AQUIS() {
        return VL_OPER_AQUIS;
    }

    public void setVL_OPER_AQUIS(String VL_OPER_AQUIS) {
        this.VL_OPER_AQUIS = VL_OPER_AQUIS;
    }

    public String getPARC_OPER_NAO_BC_CRED() {
        return PARC_OPER_NAO_BC_CRED;
    }

    public void setPARC_OPER_NAO_BC_CRED(String PARC_OPER_NAO_BC_CRED) {
        this.PARC_OPER_NAO_BC_CRED = PARC_OPER_NAO_BC_CRED;
    }

    public String getVL_BC_CRED() {
        return VL_BC_CRED;
    }

    public void setVL_BC_CRED(String VL_BC_CRED) {
        this.VL_BC_CRED = VL_BC_CRED;
    }

    public String getIND_NR_PARC() {
        return IND_NR_PARC;
    }

    public void setIND_NR_PARC(String IND_NR_PARC) {
        this.IND_NR_PARC = IND_NR_PARC;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getCOD_CCUS() {
        return COD_CCUS;
    }

    public void setCOD_CCUS(String COD_CCUS) {
        this.COD_CCUS = COD_CCUS;
    }

    public String getDESC_BEM_IMOB() {
        return DESC_BEM_IMOB;
    }

    public void setDESC_BEM_IMOB(String DESC_BEM_IMOB) {
        this.DESC_BEM_IMOB = DESC_BEM_IMOB;
    }
    
}


class RegistroF139 {
    //Texto fixo contendo "F139"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 – Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroF139 registroF139 = new RegistroF139();
    List<RegistroF139> registrosF139 = new ArrayList<RegistroF139>();
    
    protected List<RegistroF139> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF139 = new RegistroF139();
                registroF139.setNUM_PROC(RS.getString(""));
                registroF139.setIND_PROC(RS.getString(""));                
                                
                registrosF139.add(registroF139);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF139.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF139;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F139").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF139.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
   
}



class RegistroF150 {

    private String REG;
    private String NAT_BC_CRED;
    private String VL_TOT_EST;
    private String EST_IMP;    
    private String VL_BC_EST;
    private String VL_BC_MEN_EST;
    private String CST_PIS;
    private String ALIQ_PIS;
    private String VL_CRED_PIS;
    private String CST_COFINS;
    private String ALIQ_COFINS;
    private String VL_CRED_COFINS;
    private String DESC_EST;
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroF150 registroF150 = new RegistroF150();
    List<RegistroF150> registrosF150 = new ArrayList<RegistroF150>();
    
    protected List<RegistroF150> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF150 = new RegistroF150();
                registroF150.setNAT_BC_CRED(RS.getString(""));
                registroF150.setVL_TOT_EST(RS.getString(""));
                registroF150.setEST_IMP(RS.getString(""));
                registroF150.setVL_BC_EST(RS.getString(""));
                registroF150.setVL_BC_MEN_EST(RS.getString(""));
                registroF150.setCST_PIS(RS.getString(""));
                registroF150.setALIQ_PIS(RS.getString(""));
                registroF150.setVL_CRED_PIS(RS.getString(""));                
                registroF150.setCST_COFINS(RS.getString(""));
                registroF150.setALIQ_COFINS(RS.getString(""));
                registroF150.setVL_CRED_COFINS(RS.getString(""));
                registroF150.setDESC_EST(RS.getString(""));
                registroF150.setCOD_CTA(RS.getString(""));
                registrosF150.add(registroF150);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF150.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF150;
    }

    protected StringBuilder gerarRegistro() {
        try {
            getConteudo().append("|F150").append("|");
            getConteudo().append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_TOT_EST()), 2)).append("|");
            getConteudo().append(geral.efdAlfanumerico(getEST_IMP(), 2)).append("|");
            getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_BC_EST()), 2)).append("|");
            getConteudo().append(geral.efdAlfanumerico(getVL_BC_MEN_EST(), 2)).append("|");
            getConteudo().append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            getConteudo().append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS()), 2)).append("|");
            getConteudo().append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            getConteudo().append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS()),2)).append("|");
            getConteudo().append(geral.efdAlfanumerico(getDESC_EST(),100)).append("|");
            getConteudo().append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            getConteudo().append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF150.class.getName()).log(Level.SEVERE, null, e);
        }
        return getConteudo();
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

    public String getVL_TOT_EST() {
        return VL_TOT_EST;
    }

    public void setVL_TOT_EST(String VL_TOT_EST) {
        this.VL_TOT_EST = VL_TOT_EST;
    }

    public String getEST_IMP() {
        return EST_IMP;
    }

    public void setEST_IMP(String EST_IMP) {
        this.EST_IMP = EST_IMP;
    }

    public String getVL_BC_EST() {
        return VL_BC_EST;
    }

    public void setVL_BC_EST(String VL_BC_EST) {
        this.VL_BC_EST = VL_BC_EST;
    }

    public String getVL_BC_MEN_EST() {
        return VL_BC_MEN_EST;
    }

    public void setVL_BC_MEN_EST(String VL_BC_MEN_EST) {
        this.VL_BC_MEN_EST = VL_BC_MEN_EST;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getALIQ_PIS() {
        return ALIQ_PIS;
    }

    public void setALIQ_PIS(String ALIQ_PIS) {
        this.ALIQ_PIS = ALIQ_PIS;
    }

    public String getVL_CRED_PIS() {
        return VL_CRED_PIS;
    }

    public void setVL_CRED_PIS(String VL_CRED_PIS) {
        this.VL_CRED_PIS = VL_CRED_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getALIQ_COFINS() {
        return ALIQ_COFINS;
    }

    public void setALIQ_COFINS(String ALIQ_COFINS) {
        this.ALIQ_COFINS = ALIQ_COFINS;
    }

    public String getVL_CRED_COFINS() {
        return VL_CRED_COFINS;
    }

    public void setVL_CRED_COFINS(String VL_CRED_COFINS) {
        this.VL_CRED_COFINS = VL_CRED_COFINS;
    }

    public String getDESC_EST() {
        return DESC_EST;
    }

    public void setDESC_EST(String DESC_EST) {
        this.DESC_EST = DESC_EST;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public StringBuilder getConteudo() {
        return conteudo;
    }

    public void setConteudo(StringBuilder conteudo) {
        this.conteudo = conteudo;
    }
        
}




class RegistroF200 {

    //Texto fixo contendo "F200"
    private String REG;
    /*Indicador do Tipo da Operação:
    01 – Venda a Vista de Unidade Concluída;
    02 – Venda a Prazo de Unidade Concluída;
    03 – Venda a Vista de Unidade em Construção;
    04 – Venda a Prazo de Unidade em Construção;
    05 – Outras.*/
    private String IND_OPER;
    /*Indicador do tipo de unidade imobiliária Vendida:
    01 – Terreno adquirido para venda;
    02 – Terreno decorrente de loteamento;
    03 – Lote oriundo de desmembramento de terreno;
    04 – Unidade resultante de incorporação imobiliária;
    05 – Prédio construído/em construção para venda;
    06 – Outras.*/
    private String UNID_IMOB;
    //Identificação/Nome do Empreendimento
    private String IDENT_EMP;
    //Descrição resumida da unidade imobiliária vendida
    private String DESC_UNID_IMOB;
    //Número do Contrato/Documento que formaliza a Venda da Unidade Imobiliária
    private String NUM_CONT;
    //Identificação da pessoa física (CPF) ou da pessoa jurídica (CNPJ) adquirente da unidade imobiliária
    private String CPF_CNPJ_ADQU;
    //Data da operação de venda da unidade imobiliária
    private String DT_OPER;
    //Valor total da unidade imobiliária vendida atualizado até o período da escrituração
    private String VL_TOT_VEND;
    //Valor recebido acumulado até o mês anterior ao da escrituração.
    private String VL_REC_ACUM;
    //Valor total recebido no mês da escrituração
    private String VL_TOT_REC;
    //Código da Situação Tributária referente ao PIS/PASEP,conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Base de Cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Base de Cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    /*Percentual da receita total recebida até o mês, da unidade imobiliária vendida ((Campo 10 + Campo 11) / Campo 09)*/
    private String PERC_REC_RECEB;
    /*Indicador da Natureza Específica do Empreendimento:
    1 - Consórcio
    2 - SCP
    3 – Incorporação em Condomínio
    4 - Outras*/
    private String IND_NAT_EMP;
    //Informações Complementares
    private String INF_COMP;
    
    RegistroF205 registroF205 = new RegistroF205();
    List<RegistroF210> registrosF210 = new ArrayList<RegistroF210>();
    List<RegistroF211> registrosF211 = new ArrayList<RegistroF211>();
    
    private StringBuilder conteudo;

    RegistroF200 registroF200 = new RegistroF200();
    List<RegistroF200> registrosF200 = new ArrayList<RegistroF200>();
    
    protected List<RegistroF200> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF200 = new RegistroF200();
                registroF200.setIND_OPER(RS.getString(""));
                registroF200.setUNID_IMOB(RS.getString(""));
                registroF200.setIDENT_EMP(RS.getString(""));
                registroF200.setDESC_UNID_IMOB(RS.getString(""));
                registroF200.setNUM_CONT(RS.getString(""));
                registroF200.setCPF_CNPJ_ADQU(RS.getString(""));
                registroF200.setDT_OPER(RS.getString(""));
                registroF200.setVL_TOT_VEND(RS.getString(""));                
                registroF200.setVL_REC_ACUM(RS.getString(""));
                registroF200.setVL_TOT_REC(RS.getString(""));
                registroF200.setCST_PIS(RS.getString(""));
                registroF200.setVL_BC_PIS(RS.getString(""));
                registroF200.setALIQ_PIS(RS.getString(""));                
                registroF200.setVL_PIS(RS.getString(""));
                registroF200.setCST_COFINS(RS.getString(""));
                registroF200.setVL_BC_COFINS(RS.getString(""));
                registroF200.setALIQ_COFINS(RS.getString(""));
                registroF200.setVL_COFINS(RS.getString(""));                
                registroF200.setPERC_REC_RECEB(RS.getString(""));
                registroF200.setIND_NAT_EMP(RS.getString(""));
                registroF200.setINF_COMP(RS.getString(""));               
                registrosF200.add(registroF200);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF200.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF200;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F200").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_OPER(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getUNID_IMOB(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIDENT_EMP())).append("|");
            conteudo.append(geral.efdNumerico(getDESC_UNID_IMOB(), 90)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_CONT(),90)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCPF_CNPJ_ADQU(),14)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_OPER(), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_VEND()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_REC_ACUM(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_REC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF200.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getUNID_IMOB() {
        return UNID_IMOB;
    }

    public void setUNID_IMOB(String UNID_IMOB) {
        this.UNID_IMOB = UNID_IMOB;
    }

    public String getIDENT_EMP() {
        return IDENT_EMP;
    }

    public void setIDENT_EMP(String IDENT_EMP) {
        this.IDENT_EMP = IDENT_EMP;
    }

    public String getDESC_UNID_IMOB() {
        return DESC_UNID_IMOB;
    }

    public void setDESC_UNID_IMOB(String DESC_UNID_IMOB) {
        this.DESC_UNID_IMOB = DESC_UNID_IMOB;
    }

    public String getNUM_CONT() {
        return NUM_CONT;
    }

    public void setNUM_CONT(String NUM_CONT) {
        this.NUM_CONT = NUM_CONT;
    }

    public String getCPF_CNPJ_ADQU() {
        return CPF_CNPJ_ADQU;
    }

    public void setCPF_CNPJ_ADQU(String CPF_CNPJ_ADQU) {
        this.CPF_CNPJ_ADQU = CPF_CNPJ_ADQU;
    }

    public String getDT_OPER() {
        return DT_OPER;
    }

    public void setDT_OPER(String DT_OPER) {
        this.DT_OPER = DT_OPER;
    }

    public String getVL_TOT_VEND() {
        return VL_TOT_VEND;
    }

    public void setVL_TOT_VEND(String VL_TOT_VEND) {
        this.VL_TOT_VEND = VL_TOT_VEND;
    }

    public String getVL_REC_ACUM() {
        return VL_REC_ACUM;
    }

    public void setVL_REC_ACUM(String VL_REC_ACUM) {
        this.VL_REC_ACUM = VL_REC_ACUM;
    }

    public String getVL_TOT_REC() {
        return VL_TOT_REC;
    }

    public void setVL_TOT_REC(String VL_TOT_REC) {
        this.VL_TOT_REC = VL_TOT_REC;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getPERC_REC_RECEB() {
        return PERC_REC_RECEB;
    }

    public void setPERC_REC_RECEB(String PERC_REC_RECEB) {
        this.PERC_REC_RECEB = PERC_REC_RECEB;
    }

    public String getIND_NAT_EMP() {
        return IND_NAT_EMP;
    }

    public void setIND_NAT_EMP(String IND_NAT_EMP) {
        this.IND_NAT_EMP = IND_NAT_EMP;
    }

    public String getINF_COMP() {
        return INF_COMP;
    }

    public void setINF_COMP(String INF_COMP) {
        this.INF_COMP = INF_COMP;
    }

    public String getIND_OPER() {
        return IND_OPER;
    }

    public void setIND_OPER(String IND_OPER) {
        this.IND_OPER = IND_OPER;
    }
      
}


class RegistroF205 {
    //Texto fixo contendo "F205"
    private String REG;
    //Valor Total do Custo Incorrido da unidade imobiliária acumulado até o mês anterior ao da escrituração
    private String VL_CUS_INC_ACUM_ANT;
    //Valor Total do Custo Incorrido da unidade imobiliária no mês da escrituração
    private String VL_CUS_INC_PER_ESC;
    //Valor Total do Custo Incorrido da unidade imobiliária acumulado até o mês da escrituração (Campo 02 + 03)
    private String VL_CUS_INC_ACUM;
    //Parcela do Custo Incorrido sem direito ao crédito da atividade imobiliária, acumulado até o período.
    private String VL_EXC_BC_CUS_INC_ACUM;
    //Valor da Base de Cálculo do Crédito sobre o Custo Incorrido, acumulado até o período da escrituração (Campo 04 – 05)
    private String VL_BC_CUS_INC;
    //Código da Situação Tributária referente ao PIS/PASEP,conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor Total do Crédito Acumulado sobre o custo incorrido – PIS/PASEP (Campo 06 x 08)
    private String VL_CRED_PIS_ACUM;
    //Parcela do crédito descontada até o período anterior da escrituração – PIS/PASEP (proporcional à receita recebida até o mês anterior).
    private String VL_CRED_PIS_DESC_ANT;
    //Parcela a descontar no período da escrituração – PIS/PASEP (proporcional à receita recebida no mês)
    private String VL_CRED_PIS_DESC;
    //Parcela a descontar em períodos futuros – PIS/PASEP (Campo 09 – 10 – 11).
    private String VL_CRED_PIS_DESC_FUT;
    //Código da Situação Tributária referente ao COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Alíquota do COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor Total do Crédito Acumulado sobre o custo incorrido - COFINS (Campo 06 x 14)
    private String VL_CRED_COFINS_ACUM;
    //Parcela do crédito descontada até o período anterior da escrituração – COFINS (proporcional à receita recebida até o mês anterior).
    private String VL_CRED_COFINS_DESC_ANT;
    //Parcela a descontar no período da escrituração –COFINS (proporcional à receita recebida no mês).
    private String VL_CRED_COFINS_DESC;
    //Parcela a descontar em períodos futuros – COFINS(Campo 15 – 16 – 17).
    private String VL_CRED_COFINS_DESC_FUT;

    private StringBuilder conteudo;

    RegistroF205 registroF205 = new RegistroF205();
    List<RegistroF205> registrosF205 = new ArrayList<RegistroF205>();
    
    protected List<RegistroF205> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF205 = new RegistroF205();
                registroF205.setVL_CUS_INC_ACUM_ANT(RS.getString(""));
                registroF205.setVL_CUS_INC_PER_ESC(RS.getString(""));
                registroF205.setVL_CUS_INC_ACUM(RS.getString(""));
                registroF205.setVL_EXC_BC_CUS_INC_ACUM(RS.getString(""));
                registroF205.setVL_BC_CUS_INC(RS.getString(""));
                registroF205.setCST_PIS(RS.getString(""));
                registroF205.setALIQ_PIS(RS.getString(""));
                registroF205.setVL_CRED_PIS_ACUM(RS.getString(""));                
                registroF205.setVL_CRED_PIS_DESC_ANT(RS.getString(""));
                registroF205.setVL_CRED_PIS_DESC(RS.getString(""));
                registroF205.setVL_CRED_PIS_DESC_FUT(RS.getString(""));
                registroF205.setCST_COFINS(RS.getString(""));
                registroF205.setALIQ_COFINS(RS.getString(""));                
                registroF205.setVL_CRED_COFINS_ACUM(RS.getString(""));
                registroF205.setVL_CRED_COFINS_DESC_ANT(RS.getString(""));
                registroF205.setVL_CRED_COFINS_DESC(RS.getString(""));
                registroF205.setVL_CRED_COFINS_DESC_FUT(RS.getString(""));                               
                registrosF205.add(registroF205);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF205.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF205;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F205").append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CUS_INC_ACUM_ANT()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CUS_INC_PER_ESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CUS_INC_ACUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC_BC_CUS_INC_ACUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CUS_INC()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS_ACUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS_DESC_ANT()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS_DESC_FUT()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS_ACUM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS_DESC_ANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS_DESC_FUT()), 2)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF205.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_CUS_INC_ACUM_ANT() {
        return VL_CUS_INC_ACUM_ANT;
    }

    public void setVL_CUS_INC_ACUM_ANT(String VL_CUS_INC_ACUM_ANT) {
        this.VL_CUS_INC_ACUM_ANT = VL_CUS_INC_ACUM_ANT;
    }

    public String getVL_CUS_INC_PER_ESC() {
        return VL_CUS_INC_PER_ESC;
    }

    public void setVL_CUS_INC_PER_ESC(String VL_CUS_INC_PER_ESC) {
        this.VL_CUS_INC_PER_ESC = VL_CUS_INC_PER_ESC;
    }

    public String getVL_CUS_INC_ACUM() {
        return VL_CUS_INC_ACUM;
    }

    public void setVL_CUS_INC_ACUM(String VL_CUS_INC_ACUM) {
        this.VL_CUS_INC_ACUM = VL_CUS_INC_ACUM;
    }

    public String getVL_EXC_BC_CUS_INC_ACUM() {
        return VL_EXC_BC_CUS_INC_ACUM;
    }

    public void setVL_EXC_BC_CUS_INC_ACUM(String VL_EXC_BC_CUS_INC_ACUM) {
        this.VL_EXC_BC_CUS_INC_ACUM = VL_EXC_BC_CUS_INC_ACUM;
    }

    public String getVL_BC_CUS_INC() {
        return VL_BC_CUS_INC;
    }

    public void setVL_BC_CUS_INC(String VL_BC_CUS_INC) {
        this.VL_BC_CUS_INC = VL_BC_CUS_INC;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getALIQ_PIS() {
        return ALIQ_PIS;
    }

    public void setALIQ_PIS(String ALIQ_PIS) {
        this.ALIQ_PIS = ALIQ_PIS;
    }

    public String getVL_CRED_PIS_ACUM() {
        return VL_CRED_PIS_ACUM;
    }

    public void setVL_CRED_PIS_ACUM(String VL_CRED_PIS_ACUM) {
        this.VL_CRED_PIS_ACUM = VL_CRED_PIS_ACUM;
    }

    public String getVL_CRED_PIS_DESC_ANT() {
        return VL_CRED_PIS_DESC_ANT;
    }

    public void setVL_CRED_PIS_DESC_ANT(String VL_CRED_PIS_DESC_ANT) {
        this.VL_CRED_PIS_DESC_ANT = VL_CRED_PIS_DESC_ANT;
    }

    public String getVL_CRED_PIS_DESC() {
        return VL_CRED_PIS_DESC;
    }

    public void setVL_CRED_PIS_DESC(String VL_CRED_PIS_ESC) {
        this.VL_CRED_PIS_DESC = VL_CRED_PIS_ESC;
    }

    public String getVL_CRED_PIS_DESC_FUT() {
        return VL_CRED_PIS_DESC_FUT;
    }

    public void setVL_CRED_PIS_DESC_FUT(String VL_CRED_PIS_DESC_FUT) {
        this.VL_CRED_PIS_DESC_FUT = VL_CRED_PIS_DESC_FUT;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getALIQ_COFINS() {
        return ALIQ_COFINS;
    }

    public void setALIQ_COFINS(String ALIQ_COFINS) {
        this.ALIQ_COFINS = ALIQ_COFINS;
    }

    public String getVL_CRED_COFINS_ACUM() {
        return VL_CRED_COFINS_ACUM;
    }

    public void setVL_CRED_COFINS_ACUM(String VL_CRED_COFINS_ACUM) {
        this.VL_CRED_COFINS_ACUM = VL_CRED_COFINS_ACUM;
    }

    public String getVL_CRED_COFINS_DESC_ANT() {
        return VL_CRED_COFINS_DESC_ANT;
    }

    public void setVL_CRED_COFINS_DESC_ANT(String VL_CRED_COFINS_DESC_ANT) {
        this.VL_CRED_COFINS_DESC_ANT = VL_CRED_COFINS_DESC_ANT;
    }

    public String getVL_CRED_COFINS_DESC() {
        return VL_CRED_COFINS_DESC;
    }

    public void setVL_CRED_COFINS_DESC(String VL_CRED_COFINS_DESC) {
        this.VL_CRED_COFINS_DESC = VL_CRED_COFINS_DESC;
    }

    public String getVL_CRED_COFINS_DESC_FUT() {
        return VL_CRED_COFINS_DESC_FUT;
    }

    public void setVL_CRED_COFINS_DESC_FUT(String VL_CRED_COFINS_DESC_FUT) {
        this.VL_CRED_COFINS_DESC_FUT = VL_CRED_COFINS_DESC_FUT;
    }
   }


class RegistroF210 {

    //Texto fixo contendo "F210"
    private String REG;
    //Valor Total do Custo Orçado para Conclusão da Unidade Vendida
    private String VL_CUS_ORC;
    //Valores Referentes a Pagamentos a Pessoas Físicas, Encargos Trabalhistas, Sociais e Previdenciários e à aquisição de bens e serviços não sujeitos ao pagamento das contribuições
    private String VL_EXC;
    //Valor da Base de Calculo do Crédito sobre o Custo Orçado Ajustado (Campo 02 – 03).
    private String VL_CUS_ORC_AJU;
    //Valor da Base de Cálculo do Crédito sobre o Custo Orçado referente ao mês da escrituração, proporcionalizada em função da receita recebida no mês.
    private String VL_BC_CRED;
    //Código da Situação Tributária referente ao PIS/PASEP, conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do Crédito sobre o custo orçado a ser utilizado no período da escrituração - PIS/PASEP (Campo 05 x 07)
    private String VL_CRED_PIS_UTIL;
    //Código da Situação Tributária referente a COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor do Crédito sobre o custo orçado a ser utilizado no período da escrituração - COFINS (Campo 05 x 10)
    private String VL_CRED_COFINS_UTIL;
    
    private StringBuilder conteudo;

    RegistroF210 registroF210 = new RegistroF210();
    List<RegistroF210> registrosF210 = new ArrayList<RegistroF210>();
    
    protected List<RegistroF210> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF210 = new RegistroF210();
                registroF210.setVL_CUS_ORC(RS.getString(""));
                registroF210.setVL_EXC(RS.getString(""));
                registroF210.setVL_CUS_ORC_AJU(RS.getString(""));
                registroF210.setVL_BC_CRED(RS.getString(""));
                registroF210.setCST_PIS(RS.getString(""));
                registroF210.setCST_PIS(RS.getString(""));
                registroF210.setALIQ_PIS(RS.getString(""));
                registroF210.setVL_CRED_PIS_UTIL(RS.getString(""));                
                registroF210.setCST_COFINS(RS.getString(""));
                registroF210.setALIQ_COFINS(RS.getString(""));
                registroF210.setVL_CRED_COFINS_UTIL(RS.getString(""));                                             
                registrosF210.add(registroF210);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF210.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF210;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F210").append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CUS_ORC()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CUS_ORC_AJU()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CRED()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS_UTIL()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS_UTIL()), 2)).append("|");                                 
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF210.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_CUS_ORC() {
        return VL_CUS_ORC;
    }

    public void setVL_CUS_ORC(String VL_CUS_ORC) {
        this.VL_CUS_ORC = VL_CUS_ORC;
    }

    public String getVL_EXC() {
        return VL_EXC;
    }

    public void setVL_EXC(String VL_EXC) {
        this.VL_EXC = VL_EXC;
    }

    public String getVL_CUS_ORC_AJU() {
        return VL_CUS_ORC_AJU;
    }

    public void setVL_CUS_ORC_AJU(String VL_CUS_ORC_AJU) {
        this.VL_CUS_ORC_AJU = VL_CUS_ORC_AJU;
    }

    public String getVL_BC_CRED() {
        return VL_BC_CRED;
    }

    public void setVL_BC_CRED(String VL_BC_CRED) {
        this.VL_BC_CRED = VL_BC_CRED;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getALIQ_PIS() {
        return ALIQ_PIS;
    }

    public void setALIQ_PIS(String ALIQ_PIS) {
        this.ALIQ_PIS = ALIQ_PIS;
    }

    public String getVL_CRED_PIS_UTIL() {
        return VL_CRED_PIS_UTIL;
    }

    public void setVL_CRED_PIS_UTIL(String VL_CRED_PIS_UTIL) {
        this.VL_CRED_PIS_UTIL = VL_CRED_PIS_UTIL;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getALIQ_COFINS() {
        return ALIQ_COFINS;
    }

    public void setALIQ_COFINS(String ALIQ_COFINS) {
        this.ALIQ_COFINS = ALIQ_COFINS;
    }

    public String getVL_CRED_COFINS_UTIL() {
        return VL_CRED_COFINS_UTIL;
    }

    public void setVL_CRED_COFINS_UTIL(String VL_CRED_COFINS_UTIL) {
        this.VL_CRED_COFINS_UTIL = VL_CRED_COFINS_UTIL;
    }
       
}


class RegistroF211{
    //Texto fixo contendo "F211"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 - Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroF211 registroF211 = new RegistroF211();
    List<RegistroF211> registrosF211 = new ArrayList<RegistroF211>();
    
    protected List<RegistroF211> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF211 = new RegistroF211();
                registroF211.setNUM_PROC(RS.getString(""));
                registroF211.setIND_PROC(RS.getString(""));                                                            
                registrosF211.add(registroF211);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF211.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF211;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F211").append("|");           
            conteudo.append(geral.efdNumerico(getNUM_PROC(),20)).append("|");
            conteudo.append(geral.efdNumerico(getIND_PROC(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
}


class RegistroF500 {

    //Texto fixo contendo "F500"
    private String REG;
    //Valor total da receita recebida, referente à combinação de CST e Alíquota.
    private String VL_REC_CAIXA;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor do desconto / exclusão da base de cálculo
    private String VL_DESC_PIS;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor do desconto / exclusão da base de cálculo
    private String VL_DESC_COFINS;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    //Código do modelo do documento fiscal conforme a Tabela 4.1.1
    private String COD_MOD;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Informação complementar
    private String INFO_COMPL;
    
    List<RegistroF509> registrosF509 = new ArrayList<RegistroF509>();
    private StringBuilder conteudo;   

    RegistroF500 registroF500 = new RegistroF500();
    List<RegistroF500> registrosF500 = new ArrayList<RegistroF500>();
    
    protected List<RegistroF500> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF500 = new RegistroF500();
                registroF500.setVL_REC_CAIXA(RS.getString(""));
                registroF500.setCST_PIS(RS.getString(""));                 
                registroF500.setVL_DESC_PIS(RS.getString(""));
                registroF500.setVL_BC_PIS(RS.getString(""));
                registroF500.setALIQ_PIS(RS.getString(""));
                registroF500.setVL_PIS(RS.getString(""));
                registroF500.setCST_COFINS(RS.getString(""));
                registroF500.setVL_DESC_COFINS(RS.getString(""));                
                registroF500.setVL_BC_COFINS(RS.getString(""));
                registroF500.setALIQ_COFINS(RS.getString(""));
                registroF500.setVL_COFINS(RS.getString(""));
                registroF500.setCOD_MOD(RS.getString(""));                
                registroF500.setCFOP(RS.getString(""));
                registroF500.setCOD_CTA(RS.getString(""));
                registroF500.setINFO_COMPL(RS.getString(""));               
                
                registrosF500.add(registroF500);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF500.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF500;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F500").append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_CAIXA()),2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getINFO_COMPL())).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF500.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_REC_CAIXA() {
        return VL_REC_CAIXA;
    }

    public void setVL_REC_CAIXA(String VL_REC_CAIXA) {
        this.VL_REC_CAIXA = VL_REC_CAIXA;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_DESC_PIS() {
        return VL_DESC_PIS;
    }

    public void setVL_DESC_PIS(String VL_DESC_PIS) {
        this.VL_DESC_PIS = VL_DESC_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_DESC_COFINS() {
        return VL_DESC_COFINS;
    }

    public void setVL_DESC_COFINS(String VL_DESC_COFINS) {
        this.VL_DESC_COFINS = VL_DESC_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getINFO_COMPL() {
        return INFO_COMPL;
    }

    public void setINFO_COMPL(String INFO_COMPL) {
        this.INFO_COMPL = INFO_COMPL;
    }
}


class RegistroF509 {

    //Texto fixo contendo "F509”
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
//    Indicador da origem do processo:
//    1 - Justiça Federal;
//    3 – Secretaria da Receita Federal do Brasil
//    9 - Outros.
    private String IND_PROC;

    private StringBuilder conteudo;   

    RegistroF509 registroF509 = new RegistroF509();
    List<RegistroF509> registrosF509 = new ArrayList<RegistroF509>();
    
    protected List<RegistroF509> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF509 = new RegistroF509();
                registroF509.setNUM_PROC(RS.getString(""));
                registroF509.setIND_PROC(RS.getString(""));                                                
                
                registrosF509.add(registroF509);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF509.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF509;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F509").append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getNUM_PROC()),20)).append("|");
            conteudo.append(geral.efdNumerico(getIND_PROC(), 1)).append("|");            

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
    
}


//PROCESSO REFERENCIADO
/*CONSOLIDAÇÃO DAS OPERAÇÕES DA PESSOA JURÍDICA
SUBMETIDA AO REGIME DE TRIBUTAÇÃO COM BASE NO LUCRO PRESUMIDO –
INCIDÊNCIA DO PIS/PASEP E DA COFINS PELO REGIME DE CAIXA (APURAÇÃO DA
CONTRIBUIÇÃO POR UNIDADE DE MEDIDA DE PRODUTO – ALÍQUOTA EM REAIS)*/
class RegistroF510 {

    private String REG;
    private String VL_REC_CAIXA;
    private String CST_PIS;
    private String VL_DESC_PIS;
    private String QUANT_BC_PIS;
    private String ALIQ_PIS_QUANT;
    private String VL_PIS;
    private String CST_COFINS;
    private String VL_DESC_COFINS;
    private String QUANT_BC_COFINS;
    private String ALIQ_COFINS_QUANT;
    private String VL_COFINS;
    private String COD_MOD;
    private String CFOP;
    private String COD_CTA;
    private String INFO_COMPL;
    
    List<RegistroF519> registrosF519 = new ArrayList<RegistroF519>();
    
    private StringBuilder conteudo;   

    RegistroF510 registroF510 = new RegistroF510();
    List<RegistroF510> registrosF510 = new ArrayList<RegistroF510>();
    
    protected List<RegistroF510> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF510 = new RegistroF510();
                registroF510.setVL_REC_CAIXA(RS.getString(""));
                registroF510.setCST_PIS(RS.getString(""));                 
                registroF510.setVL_DESC_PIS(RS.getString(""));
                registroF510.setQUANT_BC_PIS(RS.getString(""));
                registroF510.setALIQ_PIS_QUANT(RS.getString(""));
                registroF510.setVL_PIS(RS.getString(""));
                registroF510.setCST_COFINS(RS.getString(""));
                registroF510.setVL_DESC_COFINS(RS.getString(""));                
                registroF510.setQUANT_BC_COFINS(RS.getString(""));
                registroF510.setALIQ_COFINS_QUANT(RS.getString(""));
                registroF510.setVL_COFINS(RS.getString(""));
                registroF510.setCOD_MOD(RS.getString(""));                
                registroF510.setCFOP(RS.getString(""));
                registroF510.setCOD_CTA(RS.getString(""));
                registroF510.setINFO_COMPL(RS.getString(""));               
                
                registrosF510.add(registroF510);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF510.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF510;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F510").append("|");           
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_CAIXA()),2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getINFO_COMPL())).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF510.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_REC_CAIXA() {
        return VL_REC_CAIXA;
    }

    public void setVL_REC_CAIXA(String VL_REC_CAIXA) {
        this.VL_REC_CAIXA = VL_REC_CAIXA;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_DESC_PIS() {
        return VL_DESC_PIS;
    }

    public void setVL_DESC_PIS(String VL_DESC_PIS) {
        this.VL_DESC_PIS = VL_DESC_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_DESC_COFINS() {
        return VL_DESC_COFINS;
    }

    public void setVL_DESC_COFINS(String VL_DESC_COFINS) {
        this.VL_DESC_COFINS = VL_DESC_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getINFO_COMPL() {
        return INFO_COMPL;
    }

    public void setINFO_COMPL(String INFO_COMPL) {
        this.INFO_COMPL = INFO_COMPL;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }
    
}

//PROCESSO REFERENCIADO
class RegistroF519 {

    private String REG;
    private String NUM_PROC;
    private String IND_PROC;
    
    private StringBuilder conteudo;   

    RegistroF519 registroF519 = new RegistroF519();
    List<RegistroF519> registrosF519 = new ArrayList<RegistroF519>();
    
    protected List<RegistroF519> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF519 = new RegistroF519();
                registroF519.setNUM_PROC(RS.getString(""));
                registroF519.setIND_PROC(RS.getString(""));                                                
                
                registrosF519.add(registroF519);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF519.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF519;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F519").append("|");           
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 2)).append("|");            

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF519.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
   
}

/*COMPOSIÇÃO DA RECEITA ESCRITURADA NO PERÍODO –
DETALHAMENTO DA RECEITA RECEBIDA PELO REGIME DE CAIXA*/
class RegistroF525 {

    private String REG;
    private String VL_REC;
    private String IND_REC;
    private String CNPJ_CPF;
    private String NUM_DOC;
    private String COD_ITEM;
    private String VL_REC_DET;
    private String CST_PIS;
    private String CST_COFINS;
    private String INFO_COMPL;
    private String COD_CTA;
    
    private StringBuilder conteudo;   

    RegistroF525 registroF525 = new RegistroF525();
    List<RegistroF525> registrosF525 = new ArrayList<RegistroF525>();
    
    protected List<RegistroF525> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF525 = new RegistroF525();
                registroF525.setVL_REC(RS.getString(""));
                registroF525.setIND_REC(RS.getString(""));
                registroF525.setCNPJ_CPF(RS.getString(""));
                registroF525.setNUM_DOC(RS.getString(""));
                registroF525.setCOD_ITEM(RS.getString(""));
                registroF525.setVL_REC_DET(RS.getString(""));
                registroF525.setCST_PIS(RS.getString(""));
                registroF525.setCST_COFINS(RS.getString(""));
                registroF525.setINFO_COMPL(RS.getString(""));
                registroF525.setCOD_CTA(RS.getString(""));
                
                registrosF525.add(registroF525);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF525.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF525;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F525").append("|");           
            conteudo.append(geral.efdAlfanumerico(getIND_REC(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCNPJ_CPF(), 14)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_DET()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");            
            conteudo.append(geral.efdAlfanumerico(getINFO_COMPL())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF525.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_REC() {
        return VL_REC;
    }

    public void setVL_REC(String VL_REC) {
        this.VL_REC = VL_REC;
    }

    public String getIND_REC() {
        return IND_REC;
    }

    public void setIND_REC(String IND_REC) {
        this.IND_REC = IND_REC;
    }

    public String getCNPJ_CPF() {
        return CNPJ_CPF;
    }

    public void setCNPJ_CPF(String CNPJ_CPF) {
        this.CNPJ_CPF = CNPJ_CPF;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getVL_REC_DET() {
        return VL_REC_DET;
    }

    public void setVL_REC_DET(String VL_REC_DET) {
        this.VL_REC_DET = VL_REC_DET;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getINFO_COMPL() {
        return INFO_COMPL;
    }

    public void setINFO_COMPL(String INFO_COMPL) {
        this.INFO_COMPL = INFO_COMPL;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
    
      
}



//PROCESSO REFERENCIADO
/*CONSOLIDAÇÃO DAS OPERAÇÕES DA PESSOA JURÍDICA
SUBMETIDA AO REGIME DE TRIBUTAÇÃO COM BASE NO LUCRO PRESUMIDO –
INCIDÊNCIA DO PIS/PASEP E DA COFINS PELO REGIME DE COMPETÊNCIA*/
class RegistroF550 {

    //Texto fixo contendo "F550"
    private String REG;
    //Valor total da receita auferida, referente à combinação de CST e Alíquota.
    private String VL_REC_COMP;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;    
    //Valor do desconto / exclusão da base de cálculo
    private String VL_DESC_PIS;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor do desconto / exclusão da base de cálculo
    private String VL_DESC_COFINS;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    /*Código do modelo do documento fiscal conforme a Tabela 4.1.1*/
    private String COD_MOD;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Informação complementar
    private String INFO_COMPL;
    
    private StringBuilder conteudo;   

    RegistroF550 registroF550 = new RegistroF550();
    List<RegistroF550> registrosF550 = new ArrayList<RegistroF550>();
    
    protected List<RegistroF550> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF550 = new RegistroF550();
                registroF550.setVL_REC_COMP(RS.getString(""));
                registroF550.setCST_PIS(RS.getString(""));
                registroF550.setVL_DESC_PIS(RS.getString(""));
                registroF550.setVL_BC_PIS(RS.getString(""));
                registroF550.setALIQ_PIS(RS.getString(""));
                registroF550.setVL_PIS(RS.getString(""));
                registroF550.setCST_COFINS(RS.getString(""));
                registroF550.setVL_DESC_COFINS(RS.getString(""));
                registroF550.setVL_BC_COFINS(RS.getString(""));
                registroF550.setALIQ_COFINS(RS.getString(""));
                
                registroF550.setVL_COFINS(RS.getString(""));
                registroF550.setCOD_MOD(RS.getString(""));
                registroF550.setCFOP(RS.getString(""));
                registroF550.setCOD_CTA(RS.getString(""));
                registroF550.setINFO_COMPL(RS.getString(""));
                
                registrosF550.add(registroF550);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF550.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF550;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F550").append("|");                      
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_COMP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_COFINS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_MOD()),4)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF550.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    List<RegistroF559> registrosF559 = new ArrayList<RegistroF559>();

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_REC_COMP() {
        return VL_REC_COMP;
    }

    public void setVL_REC_COMP(String VL_REC_COMP) {
        this.VL_REC_COMP = VL_REC_COMP;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_DESC_PIS() {
        return VL_DESC_PIS;
    }

    public void setVL_DESC_PIS(String VL_DESC_PIS) {
        this.VL_DESC_PIS = VL_DESC_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_DESC_COFINS() {
        return VL_DESC_COFINS;
    }

    public void setVL_DESC_COFINS(String VL_DESC_COFINS) {
        this.VL_DESC_COFINS = VL_DESC_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getINFO_COMPL() {
        return INFO_COMPL;
    }

    public void setINFO_COMPL(String INFO_COMPL) {
        this.INFO_COMPL = INFO_COMPL;
    }
   
}

//PROCESSO REFERENCIADO
class RegistroF559 {
    //Texto fixo contendo "F559”
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    /*Indicador da origem do processo:
    1 - Justiça Federal;
    3 – Secretaria da Receita Federal do Brasil
    9 - Outros.*/
    private String IND_PROC;
    
    private StringBuilder conteudo;   

    RegistroF559 registroF559 = new RegistroF559();
    List<RegistroF559> registrosF559 = new ArrayList<RegistroF559>();
    
    protected List<RegistroF559> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF559 = new RegistroF559();
                registroF559.setNUM_PROC(RS.getString(""));
                registroF559.setIND_PROC(RS.getString(""));                
                
                registrosF559.add(registroF559);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF559.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF559;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F559").append("|");                      
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");                        
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF559.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
}

/*CONSOLIDAÇÃO DAS OPERAÇÕES DA PESSOA JURÍDICA
SUBMETIDA AO REGIME DE TRIBUTAÇÃO COM BASE NO LUCRO PRESUMIDO –
INCIDÊNCIA DO PIS/PASEP E DA COFINS PELO REGIME DE COMPETÊNCIA
(APURAÇÃO DA CONTRIBUIÇÃO POR UNIDADE DE MEDIDA DE PRODUTO –
ALÍQUOTA EM REAIS)*/
class RegistroF560{
    //Texto fixo contendo "F560"
    private String REG;
    //Valor total da receita auferida, referente à combinação de CST e Aliquota
    private String VL_REC_COM;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor do desconto / exclusão
    private String VL_DESC_PIS;
    //Base de cálculo em quantidade - PIS/PASEP
    private String QUANT_BC_PIS;
    //Alíquota do PIS/PASEP (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor do desconto / exclusão
    private String VL_DESC_COFINS;
    //Base de cálculo em quantidade - COFINS
    private String QUANT_BC_COFINS;
    //Alíquota da COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor da COFINS
    private String VL_COFINS;
    //Código do modelo do documento fiscal conforme a Tabela 4.1.1
    private String COD_MOD;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Informação complementar
    private String INFO_COMPL;
    
    List<RegistroF569> registrosF569 = new ArrayList<RegistroF569>();
    
    private StringBuilder conteudo;   

    RegistroF560 registroF560 = new RegistroF560();
    List<RegistroF560> registrosF560 = new ArrayList<RegistroF560>();
    
    protected List<RegistroF560> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF560 = new RegistroF560();
                registroF560.setVL_REC_COM(RS.getString(""));
                registroF560.setCST_PIS(RS.getString(""));
                registroF560.setVL_DESC_PIS(RS.getString(""));
                registroF560.setQUANT_BC_PIS(RS.getString(""));
                registroF560.setALIQ_PIS_QUANT(RS.getString(""));
                registroF560.setVL_PIS(RS.getString(""));                
                registroF560.setCST_COFINS(RS.getString(""));
                registroF560.setVL_DESC_COFINS(RS.getString(""));
                registroF560.setQUANT_BC_COFINS(RS.getString(""));
                registroF560.setALIQ_COFINS_QUANT(RS.getString(""));
                registroF560.setVL_COFINS(RS.getString(""));
                registroF560.setCOD_MOD(RS.getString(""));
                registroF560.setCFOP(RS.getString(""));
                registroF560.setCOD_CTA(RS.getString(""));
                registroF560.setINFO_COMPL(RS.getString(""));
                
                registrosF560.add(registroF560);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF560.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF560;
    }

     protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F560").append("|");                      
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_COM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()),2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC_COFINS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()),3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_MOD()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCFOP()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_CTA()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getINFO_COMPL()),4)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroF560.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_REC_COM() {
        return VL_REC_COM;
    }

    public void setVL_REC_COM(String VL_REC_COM) {
        this.VL_REC_COM = VL_REC_COM;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_DESC_PIS() {
        return VL_DESC_PIS;
    }

    public void setVL_DESC_PIS(String VL_DESC_PIS) {
        this.VL_DESC_PIS = VL_DESC_PIS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_DESC_COFINS() {
        return VL_DESC_COFINS;
    }

    public void setVL_DESC_COFINS(String VL_DESC_COFINS) {
        this.VL_DESC_COFINS = VL_DESC_COFINS;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getINFO_COMPL() {
        return INFO_COMPL;
    }

    public void setINFO_COMPL(String INFO_COMPL) {
        this.INFO_COMPL = INFO_COMPL;
    }
    
}

//PROCESSO REFERENCIADO
class RegistroF569{
    //Texto fixo contendo "F569”
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 - Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;   

    RegistroF569 registroF569 = new RegistroF569();
    List<RegistroF569> registrosF569 = new ArrayList<RegistroF569>();
    
    protected List<RegistroF569> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroF569 = new RegistroF569();
                registroF569.setNUM_PROC(RS.getString(""));
                registroF569.setIND_PROC(RS.getString(""));                
                
                registrosF569.add(registroF569);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF569.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF569;
    }

     protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F569").append("|");                      
            conteudo.append(geral.efdNumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdNumerico(getIND_PROC(), 1)).append("|");                       
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }
}

//CONTRIBUIÇÃO RETIDA NA FONTE
class RegistroF600{
    //Texto fixo contendo "F600"

    private String REG;
    /*Indicador de Natureza da Retenção na Fonte:
    01 - Retenção por Órgãos, Autarquias e Fundações
    Federais
    02 - Retenção por outras Entidades da Administração
    Pública Federal
    03 - Retenção por Pessoas Jurídicas de Direito Privado
    04 - Recolhimento por Sociedade Cooperativa
    05 - Retenção por Fabricante de Máquinas e Veículos
    99 - Outras Retenções*/
    private String IND_NAT_RET;
    //Data da Retenção
    private String DT_RET;
    //Base de calculo da retenção ou do recolhimento (sociedade cooperativa)
    private String VL_BC_RET;
    //Valor Total Retido na Fonte / Recolhido (sociedade cooperativa)
    private String VL_RET;
    //Código da Receita
    private String COD_REC;
    /*Indicador da Natureza da Receita:
    0 – Receita de Natureza Não Cumulativa
    1 – Receita de Natureza Cumulativa*/
    private String IND_NAT_REC;
    /*CNPJ referente a:
    - Fonte Pagadora Responsável pela Retenção /
    Recolhimento (no caso de o registro ser escriturado
    pela pessoa jurídica beneficiária da retenção); ou
    - Pessoa Jurídica Beneficiária da Retenção /
    Recolhimento (no caso de o registro ser escriturado pela pessoa jurídica responsável pela retenção).*/
    private String CNPJ;
    //Valor Retido na Fonte – Parcela Referente ao PIS/Pasep
    private String VL_RET_PIS;
    //Valor Retido na Fonte – Parcela Referente a COFINS
    private String VL_RET_COFINS;
    /*Indicador da condição da pessoa jurídica declarante:
    0 – Beneficiária da Retenção / Recolhimento
    1- Responsável pelo Recolhimento*/
    private String IND_DEC;
    
    private StringBuilder conteudo;   

    RegistroF600 RegistroF600 = new RegistroF600();
    List<RegistroF600> registrosF600 = new ArrayList<RegistroF600>();
    
    protected List<RegistroF600> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                RegistroF600 = new RegistroF600();
                RegistroF600.setIND_NAT_RET(RS.getString(""));
                RegistroF600.setDT_RET(RS.getString(""));
                RegistroF600.setVL_BC_RET(RS.getString(""));
                RegistroF600.setVL_RET(RS.getString(""));
                RegistroF600.setCOD_REC(RS.getString(""));
                RegistroF600.setIND_NAT_REC(RS.getString(""));
                
                RegistroF600.setCNPJ(RS.getString(""));
                RegistroF600.setVL_RET_PIS(RS.getString(""));
                RegistroF600.setVL_RET_COFINS(RS.getString(""));
                RegistroF600.setIND_DEC(RS.getString(""));
                
                registrosF600.add(RegistroF600);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF600.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF600;
    }

     protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F600").append("|");                      
            conteudo.append(geral.efdNumerico(getIND_NAT_RET(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getDT_RET(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_RET()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_REC(),4)).append("|");
            conteudo.append(geral.efdNumerico(getIND_NAT_REC(),1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCNPJ())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET_PIS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_RET_COFINS()),2)).append("|");            
            conteudo.append(geral.efdNumerico(getIND_DEC(),1)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_NAT_RET() {
        return IND_NAT_RET;
    }

    public void setIND_NAT_RET(String IND_NAT_RET) {
        this.IND_NAT_RET = IND_NAT_RET;
    }

    public String getDT_RET() {
        return DT_RET;
    }

    public void setDT_RET(String DT_RET) {
        this.DT_RET = DT_RET;
    }

    public String getVL_BC_RET() {
        return VL_BC_RET;
    }

    public void setVL_BC_RET(String VL_BC_RET) {
        this.VL_BC_RET = VL_BC_RET;
    }

    public String getVL_RET() {
        return VL_RET;
    }

    public void setVL_RET(String VL_RET) {
        this.VL_RET = VL_RET;
    }

    public String getCOD_REC() {
        return COD_REC;
    }

    public void setCOD_REC(String COD_REC) {
        this.COD_REC = COD_REC;
    }

    public String getIND_NAT_REC() {
        return IND_NAT_REC;
    }

    public void setIND_NAT_REC(String IND_NAT_REC) {
        this.IND_NAT_REC = IND_NAT_REC;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getVL_RET_PIS() {
        return VL_RET_PIS;
    }

    public void setVL_RET_PIS(String VL_RET_PIS) {
        this.VL_RET_PIS = VL_RET_PIS;
    }

    public String getVL_RET_COFINS() {
        return VL_RET_COFINS;
    }

    public void setVL_RET_COFINS(String VL_RET_COFINS) {
        this.VL_RET_COFINS = VL_RET_COFINS;
    }

    public String getIND_DEC() {
        return IND_DEC;
    }

    public void setIND_DEC(String IND_DEC) {
        this.IND_DEC = IND_DEC;
    }
}

//DEDUÇÕES DIVERSAS
class RegistroF700{
    //Texto fixo contendo "F700"

    private String REG;
    /*Indicador de Origem de Deduções Diversas:
    01 – Créditos Presumidos - Medicamentos
    02 – Créditos Admitidos no Regime Cumulativo –
    Bebidas Frias
    03 – Contribuição Paga pelo Substituto Tributário -
    ZFM
    04 – Substituição Tributária – Não Ocorrência do Fato
    Gerador Presumido
    99 - Outras Deduções*/
    private String IND_ORI_DED;
    /*Indicador da Natureza da Dedução:
    0 – Dedução de Natureza Não Cumulativa
    1 – Dedução de Natureza Cumulativa*/
    private String IND_NAT_DED;
    //Valor a Deduzir - PIS/PASEP
    private String VL_DED_PIS;
    //Valor a Deduzir – Cofins
    private String VL_DED_COFINS;
    //Valor da Base de Cálculo da Operação que ensejou o Valor a Deduzir informado nos Campos 04 e 05
    private String VL_BC_OPER;
    /*CNPJ da Pessoa Jurídica relacionada à Operação que
    ensejou o Valor a Deduzir informado nos Campos 04 e
    05.*/
    private String CNPJ;
    /*Informações Complementares do Documento/Operação
    que ensejou o Valor a Deduzir informado nos Campos
    04 e 05.*/
    private String INF_COMP;
    
    private StringBuilder conteudo;   

    RegistroF700 RegistroF700 = new RegistroF700();
    List<RegistroF700> registrosF700 = new ArrayList<RegistroF700>();
    
    protected List<RegistroF700> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                RegistroF700 = new RegistroF700();
                RegistroF700.setIND_ORI_DED(RS.getString(""));
                RegistroF700.setIND_NAT_DED(RS.getString(""));
                RegistroF700.setVL_DED_PIS(RS.getString(""));
                RegistroF700.setVL_DED_COFINS(RS.getString(""));
                RegistroF700.setVL_BC_OPER(RS.getString(""));
                RegistroF700.setCNPJ(RS.getString(""));                
                RegistroF700.setINF_COMP(RS.getString(""));               
                
                registrosF700.add(RegistroF700);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF700.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF700;
    }

     protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F700").append("|");                      
            conteudo.append(geral.efdNumerico(getIND_ORI_DED(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getIND_NAT_DED(), 1)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DED_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DED_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_OPER()),2)).append("|");
            conteudo.append(geral.efdNumerico(getCNPJ(),14)).append("|");
            conteudo.append(geral.efdNumerico(getINF_COMP(), 90)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_ORI_DED() {
        return IND_ORI_DED;
    }

    public void setIND_ORI_DED(String IND_ORI_DED) {
        this.IND_ORI_DED = IND_ORI_DED;
    }

    public String getIND_NAT_DED() {
        return IND_NAT_DED;
    }

    public void setIND_NAT_DED(String IND_NAT_DED) {
        this.IND_NAT_DED = IND_NAT_DED;
    }

    public String getVL_DED_PIS() {
        return VL_DED_PIS;
    }

    public void setVL_DED_PIS(String VL_DED_PIS) {
        this.VL_DED_PIS = VL_DED_PIS;
    }

    public String getVL_DED_COFINS() {
        return VL_DED_COFINS;
    }

    public void setVL_DED_COFINS(String VL_DED_COFINS) {
        this.VL_DED_COFINS = VL_DED_COFINS;
    }

    public String getVL_BC_OPER() {
        return VL_BC_OPER;
    }

    public void setVL_BC_OPER(String VL_BC_OPER) {
        this.VL_BC_OPER = VL_BC_OPER;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getINF_COMP() {
        return INF_COMP;
    }

    public void setINF_COMP(String INF_COMP) {
        this.INF_COMP = INF_COMP;
    }
}

//CRÉDITOS DECORRENTES DE EVENTOS DE INCORPORAÇÃO, FUSÃO E CISÃO
class RegistroF800{
    //Texto fixo contendo "F800"
    private String REG;
    /*Indicador da Natureza do Evento de Sucessão:
    01 – Incorporação
    02 – Fusão
    03 – Cisão Total
    04 – Cisão Parcial
    99 – Outros*/
    private String IND_NAT_EVEN;
    //Data do Evento
    private String DT_EVEN;
    //CNPJ da Pessoa Jurídica Sucedida
    private String CNPJ_SUCED;
    /*Período de Apuração do Crédito – Mês/Ano (MM/AAAA)*/
    private String PA_CONT_CRED;
    //Código do crédito transferido, conforme Tabela 4.3.6
    private String COD_CRED;
    //Valor do Crédito Transferido de PIS/Pasep
    private String VL_CRED_PIS;
    //Valor do Crédito Transferido de Cofins
    private String VL_CRED_COFINS;
    /*Percentual do crédito original transferido, no caso de evento de Cisão.*/
    private String PER_CRED_CIS;
    
    private StringBuilder conteudo;   

    RegistroF700 RegistroF700 = new RegistroF700();
    List<RegistroF700> registrosF700 = new ArrayList<RegistroF700>();
    
    protected List<RegistroF700> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");
        
        try {
            while (RS.next()) {
                RegistroF700 = new RegistroF700();
                RegistroF700.setIND_ORI_DED(RS.getString(""));
                RegistroF700.setIND_NAT_DED(RS.getString(""));
                RegistroF700.setVL_DED_PIS(RS.getString(""));
                RegistroF700.setVL_DED_COFINS(RS.getString(""));
                RegistroF700.setVL_BC_OPER(RS.getString(""));
                RegistroF700.setCNPJ(RS.getString(""));                
                RegistroF700.setINF_COMP(RS.getString(""));               
                
                registrosF700.add(RegistroF700);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF700.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF700;
    }

     protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F800").append("|");                      
            conteudo.append(geral.efdNumerico(Float.parseFloat(getIND_NAT_EVEN()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getDT_EVEN(), 8)).append("|");            
            conteudo.append(geral.efdAlfanumerico(getCNPJ_SUCED())).append("|");
            conteudo.append(geral.efdAlfanumerico(getPA_CONT_CRED(), 6)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_CRED()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_PIS()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CRED_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getPER_CRED_CIS()),2)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_NAT_EVEN() {
        return IND_NAT_EVEN;
    }

    public void setIND_NAT_EVEN(String IND_NAT_EVEN) {
        this.IND_NAT_EVEN = IND_NAT_EVEN;
    }

    public String getDT_EVEN() {
        return DT_EVEN;
    }

    public void setDT_EVEN(String DT_EVEN) {
        this.DT_EVEN = DT_EVEN;
    }

    public String getCNPJ_SUCED() {
        return CNPJ_SUCED;
    }

    public void setCNPJ_SUCED(String CNPJ_SUCED) {
        this.CNPJ_SUCED = CNPJ_SUCED;
    }

    public String getPA_CONT_CRED() {
        return PA_CONT_CRED;
    }

    public void setPA_CONT_CRED(String PA_CONT_CRED) {
        this.PA_CONT_CRED = PA_CONT_CRED;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getVL_CRED_PIS() {
        return VL_CRED_PIS;
    }

    public void setVL_CRED_PIS(String VL_CRED_PIS) {
        this.VL_CRED_PIS = VL_CRED_PIS;
    }

    public String getVL_CRED_COFINS() {
        return VL_CRED_COFINS;
    }

    public void setVL_CRED_COFINS(String VL_CRED_COFINS) {
        this.VL_CRED_COFINS = VL_CRED_COFINS;
    }

    public String getPER_CRED_CIS() {
        return PER_CRED_CIS;
    }

    public void setPER_CRED_CIS(String PER_CRED_CIS) {
        this.PER_CRED_CIS = PER_CRED_CIS;
    }
}
class RegistroF990 {

    private String REG;
    private String QTD_LIN_F;
    
    private StringBuilder conteudo;   

    RegistroF990 RegistroF990 = new RegistroF990();
    List<RegistroF990> registrosF990 = new ArrayList<RegistroF990>();
    
    protected List<RegistroF990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");
        
        try {
            while (RS.next()) {
                RegistroF990 = new RegistroF990();
                RegistroF990.setQTD_LIN_F(RS.getString(""));                         
                
                registrosF990.add(RegistroF990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosF990;
    }

     protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|F990").append("|");                      
            conteudo.append(geral.efdAlfanumerico(getQTD_LIN_F())).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getQTD_LIN_F() {
        return QTD_LIN_F;
    }

    public void setQTD_LIN_F(String QTD_LIN_F) {
        this.QTD_LIN_F = QTD_LIN_F;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}
