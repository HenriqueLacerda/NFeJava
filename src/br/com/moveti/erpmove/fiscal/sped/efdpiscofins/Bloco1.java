/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped.efdpiscofins;

import crncomp.conexao;
import crncomp.geral;
import java.math.BigDecimal;
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
public class Bloco1 {  
    private Registro1001 registro1001 = new Registro1001();
    private Registro1990 registro1990 = new Registro1990();
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;
    
    public Bloco1() {
        conexao = new conexao();
        conteudo = new StringBuilder();

        // Busca dos dados

    }
    
     public StringBuilder gerarEFD() {
     //Primeiro deverão ser chamados todos os metodos para buscar os registros nos bancos de dados.                   
        
        try {                                                          
            
            conteudo.append(registro1001.gerarRegistro());
            conteudo.append(registro1990.gerarRegistro());           
            
            return conteudo;
        } catch (Exception e) {
            Logger.getLogger(Bloco0.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }  
}
class Registro1001 {
  
    private String REG;
    private String IND_MOV;    
    private List<Registro1010> resgistros1010 = new ArrayList<Registro1010>();
    private List<Registro1020> resgistros1020 = new ArrayList<Registro1020>();
    private List<Registro1100> resgistros1100 = new ArrayList<Registro1100>();
    private List<Registro1200> resgistros1200 = new ArrayList<Registro1200>();
    private List<Registro1300> resgistros1300 = new ArrayList<Registro1300>();
    private List<Registro1500> resgistros1500 = new ArrayList<Registro1500>();
    private List<Registro1600> resgistros1600 = new ArrayList<Registro1600>();
    private List<Registro1700> resgistros1700 = new ArrayList<Registro1700>();
    private List<Registro1800> resgistros1800 = new ArrayList<Registro1800>();
    private List<Registro1900> resgistros1900 = new ArrayList<Registro1900>();
    
    private StringBuilder conteudo;
    
    Registro1001 registro1001 = new Registro1001();
    List<Registro1001> registros1001 = new ArrayList<Registro1001>();
    
    protected List<Registro1001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1001 = new Registro1001();
                registro1001.setIND_MOV(RS.getString(""));                            
                                                              
                registros1001.add(registro1001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1001;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1001").append("|");
            conteudo.append(geral.efdNumerico(getIND_MOV(), 1)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1001.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_MOV() {
        return IND_MOV;
    }

    public void setIND_MOV(String IND_MOV) {
        this.IND_MOV = IND_MOV;
    }
    
}


class Registro1010 {

    //Texto fixo contendo "1010"
    private String REG;
    //Identificação do Número do Processo Judicial
    private String NUM_PROC;
    //Identificação da Seção Judiciária
    private String ID_SEC_JUD;
    //Identificação da Vara
    private String ID_VARA;
    /*Indicador da Natureza da Ação Judicial, impetrada na Justiça
    Federal:
    01 – Decisão Judicial Transitada em Julgado, a favor da Pessoa
    Jurídica.
    02 – Decisão Judicial Não Transitada em Julgado, a favor da
    Pessoa Jurídica.
    03 – Decisão Judicial oriunda de Liminar em Mandado de
    Segurança.
    04 – Decisão Judicial oriunda de Liminar em Medida Cautelar.
    05 – Decisão Judicial oriunda de Antecipação de Tutela.
    06 - Decisão Judicial Vinculada a Depósito Administrativo ou
    Judicial em Montante Integral.
    07 – Medida Judicial em que a Pessoa Jurídica não é o autor.
    08 – Súmula Vinculante aprovada pelo STF.
    99 - Outros.*/
    private String IND_NAT_ACAO;
    /*Descrição Resumida dos Efeitos Tributários abrangidos pela
    Decisão Judicial proferida*/
    private String DESC_DEC_JUD;
    /*Data da Sentença/Decisão Judicial*/
    private String DT_SENT_JUD;
    
    private StringBuilder conteudo;
    
    Registro1010 registro1010 = new Registro1010();
    List<Registro1010> registros1010 = new ArrayList<Registro1010>();
    
    protected List<Registro1010> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1010 = new Registro1010();
                registro1010.setNUM_PROC(RS.getString(""));
                registro1010.setID_SEC_JUD(RS.getString(""));
                registro1010.setID_VARA(RS.getString(""));
                registro1010.setIND_NAT_ACAO(RS.getString(""));
                registro1010.setDESC_DEC_JUD(RS.getString(""));
                registro1010.setDT_SENT_JUD(RS.getString(""));
                                                              
                registros1010.add(registro1010);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1010.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1010;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1010").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(),20)).append("|");            
            conteudo.append(geral.efdAlfanumerico(getID_SEC_JUD())).append("|");
            conteudo.append(geral.efdAlfanumerico(getID_VARA(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_NAT_ACAO(),2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1010.class.getName()).log(Level.SEVERE, null, e);
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

    public String getID_SEC_JUD() {
        return ID_SEC_JUD;
    }

    public void setID_SEC_JUD(String ID_SEC_JUD) {
        this.ID_SEC_JUD = ID_SEC_JUD;
    }

    public String getID_VARA() {
        return ID_VARA;
    }

    public void setID_VARA(String ID_VARA) {
        this.ID_VARA = ID_VARA;
    }

    public String getIND_NAT_ACAO() {
        return IND_NAT_ACAO;
    }

    public void setIND_NAT_ACAO(String IND_NAT_ACAO) {
        this.IND_NAT_ACAO = IND_NAT_ACAO;
    }

    public String getDESC_DEC_JUD() {
        return DESC_DEC_JUD;
    }

    public void setDESC_DEC_JUD(String DESC_DEC_JUD) {
        this.DESC_DEC_JUD = DESC_DEC_JUD;
    }

    public String getDT_SENT_JUD() {
        return DT_SENT_JUD;
    }

    public void setDT_SENT_JUD(String DT_SENT_JUD) {
        this.DT_SENT_JUD = DT_SENT_JUD;
    }
    
}



class Registro1020 {

    //Texto fixo contendo "1020"
    private String REG;
    /*Identificação do Processo Administrativo ou da Decisão
    Administrativa*/
    private String NUM_PROC;
    /*Indicador da Natureza da Ação, decorrente de Processo
    Administrativo na Secretaria da Receita Federal do Brasil:
    01 – Processo Administrativo de Consulta
    02 – Despacho Decisório
    03 – Ato Declaratório Executivo
    04 – Ato Declaratório Interpretativo
    05 – Decisão Administrativa de DRJ ou do CARF
    06 – Auto de Infração
    99 – Outros*/
    private String IND_NAT_ACAO;
    //Data do Despacho/Decisão Administrativa
    private String DT_DEC_ADM;
    
    private StringBuilder conteudo;
    
    Registro1020 registro1020 = new Registro1020();
    List<Registro1020> registros1020 = new ArrayList<Registro1020>();
    
    protected List<Registro1020> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1020 = new Registro1020();
                registro1020.setNUM_PROC(RS.getString(""));              
                registro1020.setIND_NAT_ACAO(RS.getString(""));     
                registro1020.setDT_DEC_ADM(RS.getString(""));
                                                              
                registros1020.add(registro1020);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1020.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1020;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1020").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(),20)).append("|");                       
            conteudo.append(geral.efdAlfanumerico(getIND_NAT_ACAO(),2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DEC_ADM())).append("|");      
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1020.class.getName()).log(Level.SEVERE, null, e);
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

    public String getIND_NAT_ACAO() {
        return IND_NAT_ACAO;
    }

    public void setIND_NAT_ACAO(String IND_NAT_ACAO) {
        this.IND_NAT_ACAO = IND_NAT_ACAO;
    }

    public String getDT_DEC_ADM() {
        return DT_DEC_ADM;
    }

    public void setDT_DEC_ADM(String DT_DEC_ADM) {
        this.DT_DEC_ADM = DT_DEC_ADM;
    }
}


class Registro1100 {

    //Texto fixo contendo "1100"
    private String REG;
    //Período de Apuração do Crédito (MM/AAAA)
    private String PER_APU_CRED;
    /*Indicador da origem do crédito:
    01 – Crédito decorrente de operações próprias;
    02 – Crédito transferido por pessoa jurídica sucedida.*/
    private String ORIG_CRED;
    /*CNPJ da pessoa jurídica cedente do crédito (se ORIG_CRED =
    02).*/
    private String CNPJ_SUC;
    /*Código do Tipo do Crédito, conforme Tabela 4.3.6.*/
    private String COD_CRED;
    /*Valor do Crédito apurado na Escrituração Fiscal Digital ou em
    demonstrativo DACON de períodos anteriores.*/
    private String VL_CRED_APU;
    /*Valor de Crédito Extemporâneo Apurado (Registro 1101),
    referente a Período Anterior, Informado no Campo 02 –
    PER_APU_CRED*/
    private String VL_CRED_EXT_APU;
    /*Valor Total do Crédito Apurado (06 + 07)*/
    private String VL_TOT_CRED_APU;
    /*Valor do Crédito utilizado mediante Desconto, em Período(s)
    Anterior(es).*/
    private String VL_CRED_DESC_PA_ANT;
    //Valor do Crédito utilizado mediante Pedido de Ressarcimento, em Período(s) Anterior(es).
    private String VL_CRED_PER_PA_ANT;
    /*Valor do Crédito utilizado mediante Declaração de
    Compensação Intermediária (Crédito de Exportação), em
    Período(s) Anterior(es).*/
    private String VL_CRED_DCOMP_PA_ANT;
    /*Saldo do Crédito Disponível para Utilização neste Período de
    Escrituração (08 – 09 – 10 - 11).*/
    private String SD_CRED_DISP_EFD;
    //Valor do Crédito descontado neste período de escrituração.
    private String VL_CRED_DESC_EFD;
    /*Valor do Crédito objeto de Pedido de Ressarcimento (PER)
    neste período de escrituração.*/
    private String VL_CRED_PER_EFD;
    /*Valor do Crédito utilizado mediante Declaração de
    Compensação Intermediária neste período de escrituração*/
    private String VL_CRED_DCOMP_EFD;
    /*Valor do crédito transferido em evento de cisão, fusão ou
    incorporação.*/
    private String VL_CRED_TRANS;
    /*Valor do crédito utilizado por outras formas.*/
    private String VL_CRED_OUT;
    /*Saldo de créditos a utilizar em período de apuração futuro (12 –
    13 – 14 – 15 – 16 - 17)*/
    private String SLD_CRED_FIM;
    private List<Registro1101> resgistro1101 = new ArrayList<Registro1101>();        

    private StringBuilder conteudo;
    
    Registro1100 registro1100 = new Registro1100();
    List<Registro1100> registros1100 = new ArrayList<Registro1100>();
    
    protected List<Registro1100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1100 = new Registro1100();
                registro1100.setPER_APU_CRED(RS.getString(""));              
                registro1100.setORIG_CRED(RS.getString(""));     
                registro1100.setCNPJ_SUC(RS.getString(""));                
                registro1100.setCOD_CRED(RS.getString(""));
                registro1100.setVL_CRED_APU(RS.getString(""));
                registro1100.setVL_CRED_EXT_APU(RS.getString(""));                
                registro1100.setVL_TOT_CRED_APU(RS.getString(""));                
                registro1100.setVL_CRED_DESC_PA_ANT(RS.getString(""));
                registro1100.setVL_CRED_PER_PA_ANT(RS.getString(""));                
                registro1100.setVL_CRED_DCOMP_PA_ANT(RS.getString(""));
                registro1100.setSD_CRED_DISP_EFD(RS.getString(""));
                registro1100.setVL_CRED_DESC_EFD(RS.getString(""));
                registro1100.setVL_CRED_PER_EFD(RS.getString(""));                
                registro1100.setVL_CRED_DCOMP_EFD(RS.getString(""));
                registro1100.setVL_CRED_TRANS(RS.getString(""));
                registro1100.setVL_CRED_OUT(RS.getString(""));
                registro1100.setSLD_CRED_FIM(RS.getString(""));
                                                              
                registros1100.add(registro1100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1100;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1100").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getPER_APU_CRED())).append("|");
            conteudo.append(geral.efdRemoveSinais(getORIG_CRED())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ_SUC())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_CRED())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_APU())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_EXT_APU())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_TOT_CRED_APU())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_DESC_PA_ANT())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_DCOMP_PA_ANT())).append("|");
            conteudo.append(geral.efdRemoveSinais(getSD_CRED_DISP_EFD())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_DESC_EFD())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_PER_EFD())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_DCOMP_EFD())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_TRANS())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_OUT())).append("|");
            conteudo.append(geral.efdRemoveSinais(getSLD_CRED_FIM())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1100.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getPER_APU_CRED() {
        return PER_APU_CRED;
    }

    public void setPER_APU_CRED(String PER_APU_CRED) {
        this.PER_APU_CRED = PER_APU_CRED;
    }

    public String getORIG_CRED() {
        return ORIG_CRED;
    }

    public void setORIG_CRED(String ORIG_CRED) {
        this.ORIG_CRED = ORIG_CRED;
    }

    public String getCNPJ_SUC() {
        return CNPJ_SUC;
    }

    public void setCNPJ_SUC(String CNPJ_SUC) {
        this.CNPJ_SUC = CNPJ_SUC;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getVL_CRED_APU() {
        return VL_CRED_APU;
    }

    public void setVL_CRED_APU(String VL_CRED_APU) {
        this.VL_CRED_APU = VL_CRED_APU;
    }

    public String getVL_CRED_EXT_APU() {
        return VL_CRED_EXT_APU;
    }

    public void setVL_CRED_EXT_APU(String VL_CRED_EXT_APU) {
        this.VL_CRED_EXT_APU = VL_CRED_EXT_APU;
    }

    public String getVL_TOT_CRED_APU() {
        return VL_TOT_CRED_APU;
    }

    public void setVL_TOT_CRED_APU(String VL_TOT_CRED_APU) {
        this.VL_TOT_CRED_APU = VL_TOT_CRED_APU;
    }

    public String getVL_CRED_DESC_PA_ANT() {
        return VL_CRED_DESC_PA_ANT;
    }

    public void setVL_CRED_DESC_PA_ANT(String VL_CRED_DESC_PA_ANT) {
        this.VL_CRED_DESC_PA_ANT = VL_CRED_DESC_PA_ANT;
    }

    public String getVL_CRED_PER_PA_ANT() {
        return VL_CRED_PER_PA_ANT;
    }

    public void setVL_CRED_PER_PA_ANT(String VL_CRED_PER_PA_ANT) {
        this.VL_CRED_PER_PA_ANT = VL_CRED_PER_PA_ANT;
    }

    public String getVL_CRED_DCOMP_PA_ANT() {
        return VL_CRED_DCOMP_PA_ANT;
    }

    public void setVL_CRED_DCOMP_PA_ANT(String VL_CRED_DCOMP_PA_ANT) {
        this.VL_CRED_DCOMP_PA_ANT = VL_CRED_DCOMP_PA_ANT;
    }

    public String getSD_CRED_DISP_EFD() {
        return SD_CRED_DISP_EFD;
    }

    public void setSD_CRED_DISP_EFD(String SD_CRED_DISP_EFD) {
        this.SD_CRED_DISP_EFD = SD_CRED_DISP_EFD;
    }

    public String getVL_CRED_DESC_EFD() {
        return VL_CRED_DESC_EFD;
    }

    public void setVL_CRED_DESC_EFD(String VL_CRED_DESC_EFD) {
        this.VL_CRED_DESC_EFD = VL_CRED_DESC_EFD;
    }

    public String getVL_CRED_PER_EFD() {
        return VL_CRED_PER_EFD;
    }

    public void setVL_CRED_PER_EFD(String VL_CRED_PER_EFD) {
        this.VL_CRED_PER_EFD = VL_CRED_PER_EFD;
    }

    public String getVL_CRED_DCOMP_EFD() {
        return VL_CRED_DCOMP_EFD;
    }

    public void setVL_CRED_DCOMP_EFD(String VL_CRED_DCOMP_EFD) {
        this.VL_CRED_DCOMP_EFD = VL_CRED_DCOMP_EFD;
    }

    public String getVL_CRED_TRANS() {
        return VL_CRED_TRANS;
    }

    public void setVL_CRED_TRANS(String VL_CRED_TRANS) {
        this.VL_CRED_TRANS = VL_CRED_TRANS;
    }

    public String getVL_CRED_OUT() {
        return VL_CRED_OUT;
    }

    public void setVL_CRED_OUT(String VL_CRED_OUT) {
        this.VL_CRED_OUT = VL_CRED_OUT;
    }

    public String getSLD_CRED_FIM() {
        return SLD_CRED_FIM;
    }

    public void setSLD_CRED_FIM(String SLD_CRED_FIM) {
        this.SLD_CRED_FIM = SLD_CRED_FIM;
    }
        
}


class Registro1101{
    //Texto fixo contendo "P200"

    private String REG;
    //Código do participante (Campo 02 do Registro 0150)
    private String COD_PART;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1.
    private String COD_MOD;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB_SER;
    //Número do documento fiscal
    private String NUM_DOC;
    //Data da Operação (ddmmaaaa)
    private String DT_OPER;
    //Chave da Nota Fiscal Eletrônica
    private String CHV_NFE;
    //Valor da Operação
    private String VL_OPER;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Código da Base de Cálculo do Crédito, conforme a Tabela indicada no item 4.3.7.
    private String NAT_BC_CRED;
    //Indicador da origem do crédito: 0 – Operação no Mercado Interno 1 – Operação de Importação
    private String IND_ORIG_CRED;
    /*Código da Situação Tributária referente ao PIS/PASEP, conforme a
    Tabela indicada no item 4.3.3.*/
    private String CST_PIS;
    /*Base de Cálculo do Crédito de PIS/PASEP (em valor ou em quantidade)*/
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual ou em reais).
    private String ALIQ_PIS;
    //Valor do Crédito de PIS/PASEP.
    private String VL_PIS;
    //Código da conta analítica contábil debitada/creditada.
    private String COD_CTA;
    //Código do Centro de Custos.
    private String COD_CCUS;
    //Descrição complementar do Documento/Operação.
    private String DESC_COMPL;
    //Mês/Ano da Escrituração em que foi registrado o documento/operação (Crédito pelo método da Apropriação Direta).
    private String PER_ESCRIT;
    //CNPJ do estabelecimento gerador do crédito extemporâneo (Campo 04 do Registro 0140)
    private String CNPJ;
    private Registro1102 resgistro1102 = new Registro1102();
    
    private StringBuilder conteudo;
    
    Registro1101 registro1101 = new Registro1101();
    List<Registro1101> registros1101 = new ArrayList<Registro1101>();
    
    protected List<Registro1101> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1101 = new Registro1101();
                registro1101.setCOD_PART(RS.getString(""));              
                registro1101.setCOD_ITEM(RS.getString(""));     
                registro1101.setCOD_MOD(RS.getString(""));                
                registro1101.setSER(RS.getString(""));
                registro1101.setSUB_SER(RS.getString(""));
                registro1101.setNUM_DOC(RS.getString(""));                
                registro1101.setDT_OPER(RS.getString(""));                
                registro1101.setCHV_NFE(RS.getString(""));
                registro1101.setVL_OPER(RS.getString(""));                
                registro1101.setCFOP(RS.getString(""));
                registro1101.setNAT_BC_CRED(RS.getString(""));
                registro1101.setIND_ORIG_CRED(RS.getString(""));
                registro1101.setCST_PIS(RS.getString(""));                
                registro1101.setVL_BC_PIS(RS.getString(""));                                                                       
                registro1101.setALIQ_PIS(RS.getString(""));
                registro1101.setVL_PIS(RS.getString(""));                
                registro1101.setCOD_CTA(RS.getString(""));                
                registro1101.setCOD_CCUS(RS.getString(""));
                registro1101.setDESC_COMPL(RS.getString(""));                
                registro1101.setPER_ESCRIT(RS.getString(""));
                registro1101.setCNPJ(RS.getString(""));                
                
                registros1101.add(registro1101);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1101.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1101;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1101").append("|"); 
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(),4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(),4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB_SER(),3)).append("|");
            conteudo.append(geral.efdNumerico(getNUM_DOC(),9)).append("|");
            conteudo.append(geral.efdNumerico(getDT_OPER(),8)).append("|");
            conteudo.append(geral.efdNumerico(getCHV_NFE(),44)).append("|");
            conteudo.append(geral.efdNumerico(getVL_OPER(),8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP())).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_ORIG_CRED(),1)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_PIS())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_BC_PIS())).append("|");
            conteudo.append(geral.efdRemoveSinais(getALIQ_PIS())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_PIS())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CCUS(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");
            conteudo.append(geral.efdNumerico(getPER_ESCRIT(),6)).append("|");
            conteudo.append(geral.efdNumerico(getCNPJ(),14)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1101.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
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

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getSUB_SER() {
        return SUB_SER;
    }

    public void setSUB_SER(String SUB_SER) {
        this.SUB_SER = SUB_SER;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDT_OPER() {
        return DT_OPER;
    }

    public void setDT_OPER(String DT_OPER) {
        this.DT_OPER = DT_OPER;
    }

    public String getCHV_NFE() {
        return CHV_NFE;
    }

    public void setCHV_NFE(String CHV_NFE) {
        this.CHV_NFE = CHV_NFE;
    }

    public String getVL_OPER() {
        return VL_OPER;
    }

    public void setVL_OPER(String VL_OPER) {
        this.VL_OPER = VL_OPER;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }

    public String getPER_ESCRIT() {
        return PER_ESCRIT;
    }

    public void setPER_ESCRIT(String PER_ESCRIT) {
        this.PER_ESCRIT = PER_ESCRIT;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
}



class Registro1102{
    //Texto fixo contendo "P210"
    private String REG;
    /*Parcela do Crédito de PIS/PASEP, vinculada a Receita
    Tributada no Mercado Interno*/
    private String VL_CRED_PIS_TRIB_MI;
    /*Parcela do Crédito de PIS/PASEP, vinculada a Receita
    Não Tributada no Mercado Interno*/
    private String VL_CRED_PIS_NT_MI;
    /*Parcela do Crédito de PIS/PASEP, vinculada a Receita
    de Exportação*/
    private String VL_CRED_PIS_EXP;
    
    private StringBuilder conteudo;
    
    Registro1102 registro1102 = new Registro1102();
    List<Registro1102> registros1102 = new ArrayList<Registro1102>();
    
    protected List<Registro1102> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1102 = new Registro1102();
                registro1102.setVL_CRED_PIS_TRIB_MI(RS.getString(""));              
                registro1102.setVL_CRED_PIS_NT_MI(RS.getString(""));     
                registro1102.setVL_CRED_PIS_EXP(RS.getString(""));                                               
                                                              
                registros1102.add(registro1102);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1102.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1102;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1102").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_PIS_TRIB_MI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_PIS_NT_MI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getVL_CRED_PIS_EXP())).append("|");                     
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1102.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getVL_CRED_PIS_TRIB_MI() {
        return VL_CRED_PIS_TRIB_MI;
    }

    public void setVL_CRED_PIS_TRIB_MI(String VL_CRED_PIS_TRIB_MI) {
        this.VL_CRED_PIS_TRIB_MI = VL_CRED_PIS_TRIB_MI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_CRED_PIS_NT_MI() {
        return VL_CRED_PIS_NT_MI;
    }

    public void setVL_CRED_PIS_NT_MI(String VL_CRED_PIS_NT_MI) {
        this.VL_CRED_PIS_NT_MI = VL_CRED_PIS_NT_MI;
    }

    public String getVL_CRED_PIS_EXP() {
        return VL_CRED_PIS_EXP;
    }

    public void setVL_CRED_PIS_EXP(String VL_CRED_PIS_EXP) {
        this.VL_CRED_PIS_EXP = VL_CRED_PIS_EXP;
    }
}


class Registro1200{
    //Texto fixo contendo "1200"
    private String REG;
    /*Período de Apuração da Contribuição Social Extemporânea
    (MMAAAA).*/
    private String PER_APUR_ANT;
    //Natureza da Contribuição a Recolher, conforme Tabela 4.3.5
    private String NAT_CONT_REC;
    //Valor da Contribuição Apurada.
    private String VL_CONT_APUR;
    /*Valor do Crédito de PIS/PASEP a Descontar, da Contribuição
    Social Extemporânea*/
    private String VL_CRED_PIS_DESC;
    //Valor da Contribuição Social Extemporânea Devida.
    private String VL_CONT_DEV;
    //Valor de Outras Deduções.
    private String VL_OUT_DED;
    //Valor da Contribuição Social Extemporânea a pagar.
    private String VL_CONT_EXT;
    //Valor da Multa.
    private String VL_MUL;
    //Valor dos Juros.
    private String VL_JUR;
    //Data do Recolhimento.
    private String DT_RECOL;
    
    private List<Registro1210> registros1210 = new ArrayList<Registro1210>();
    private List<Registro1220> registros1220 = new ArrayList<Registro1220>();
    
    private StringBuilder conteudo;
    
    Registro1200 registro1200 = new Registro1200();
    List<Registro1200> registros1200 = new ArrayList<Registro1200>();
    
    protected List<Registro1200> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1200 = new Registro1200();
                registro1200.setPER_APUR_ANT("");
                registro1200.setNAT_CONT_REC(RS.getString(""));     
                registro1200.setVL_CONT_APUR(RS.getString(""));      
                registro1200.setVL_CRED_PIS_DESC(RS.getString(""));
                registro1200.setVL_CONT_DEV(RS.getString(""));                
                registro1200.setVL_OUT_DED(RS.getString(""));
                registro1200.setVL_CONT_EXT(RS.getString(""));
                registro1200.setVL_MUL(RS.getString(""));
                registro1200.setVL_JUR(RS.getString(""));
                registro1200.setDT_RECOL(RS.getString(""));
                                                              
                registros1200.add(registro1200);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1200.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1200;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1200").append("|"); 
            conteudo.append(geral.efdNumerico(getPER_APUR_ANT(),6)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_CONT_REC(),2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CONT_APUR(),8)).append("|");  
            conteudo.append(geral.efdNumerico(getVL_CRED_PIS_DESC(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_CONT_DEV(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_OUT_DED(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_CONT_EXT(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_MUL(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_JUR(),8)).append("|");       
            conteudo.append(geral.efdRemoveSinais(getDT_RECOL())).append("|");                     
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1200.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getPER_APUR_ANT() {
        return PER_APUR_ANT;
    }

    public void setPER_APUR_ANT(String PER_APUR_ANT) {
        this.PER_APUR_ANT = PER_APUR_ANT;
    }

    public String getNAT_CONT_REC() {
        return NAT_CONT_REC;
    }

    public void setNAT_CONT_REC(String NAT_CONT_REC) {
        this.NAT_CONT_REC = NAT_CONT_REC;
    }

    public String getVL_CONT_APUR() {
        return VL_CONT_APUR;
    }

    public void setVL_CONT_APUR(String VL_CONT_APUR) {
        this.VL_CONT_APUR = VL_CONT_APUR;
    }

    public String getVL_CRED_PIS_DESC() {
        return VL_CRED_PIS_DESC;
    }

    public void setVL_CRED_PIS_DESC(String VL_CRED_PIS_DESC) {
        this.VL_CRED_PIS_DESC = VL_CRED_PIS_DESC;
    }

    public String getVL_CONT_DEV() {
        return VL_CONT_DEV;
    }

    public void setVL_CONT_DEV(String VL_CONT_DEV) {
        this.VL_CONT_DEV = VL_CONT_DEV;
    }

    public String getVL_OUT_DED() {
        return VL_OUT_DED;
    }

    public void setVL_OUT_DED(String VL_OUT_DED) {
        this.VL_OUT_DED = VL_OUT_DED;
    }

    public String getVL_CONT_EXT() {
        return VL_CONT_EXT;
    }

    public void setVL_CONT_EXT(String VL_CONT_EXT) {
        this.VL_CONT_EXT = VL_CONT_EXT;
    }

    public String getVL_MUL() {
        return VL_MUL;
    }

    public void setVL_MUL(String VL_MUL) {
        this.VL_MUL = VL_MUL;
    }

    public String getVL_JUR() {
        return VL_JUR;
    }

    public void setVL_JUR(String VL_JUR) {
        this.VL_JUR = VL_JUR;
    }

    public String getDT_RECOL() {
        return DT_RECOL;
    }

    public void setDT_RECOL(String DT_RECOL) {
        this.DT_RECOL = DT_RECOL;
    }
}


class Registro1210{
    //Texto fixo contendo “1210”
    private String REG;
    //Número de inscrição do estabelecimento no CNPJ (Campo 04 do Registro 0140).
    private String CNPJ;
    //Código da Situação Tributária referente ao PIS/PASEP, conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Código do participante (Campo 02 do Registro 0150)
    private String COD_PART;
    //Data da Operação (ddmmaaaa)
    private String DT_OPER;
    //Valor da Operação
    private String VL_OPER;
    //Base de cálculo do PIS/PASEP (em valor ou em quantidade)
    private String VL_BC_PIS;
    //Alíquota da PIS (em percentual ou em reais)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Descrição complementar do Documento/Operação
    private String DESC_COMPL;
    

    private StringBuilder conteudo;
    
    Registro1210 registro1210 = new Registro1210();
    List<Registro1210> registros1210 = new ArrayList<Registro1210>();
    
    protected List<Registro1210> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1210 = new Registro1210();
                registro1210.setCNPJ("");
                registro1210.setCST_PIS(RS.getString(""));     
                registro1210.setCOD_PART(RS.getString(""));      
                registro1210.setDT_OPER(RS.getString(""));
                registro1210.setVL_OPER(RS.getString(""));                
                registro1210.setVL_BC_PIS(RS.getString(""));
                registro1210.setALIQ_PIS(RS.getString(""));
                registro1210.setVL_PIS(RS.getString(""));
                registro1210.setCOD_CTA(RS.getString(""));
                registro1210.setDESC_COMPL(RS.getString(""));
                                                              
                registros1210.add(registro1210);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1210.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1210;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1210").append("|"); 
            conteudo.append(geral.efdNumerico(getCNPJ(),6)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_PART(),60)).append("|");  
            conteudo.append(geral.efdNumerico(getDT_OPER(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_OPER(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_BC_PIS(),8)).append("|");                     
            conteudo.append(geral.efdNumerico(getALIQ_PIS(),5)).append("|");                     
            conteudo.append(geral.efdNumerico(getVL_PIS(),8)).append("|");                     
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(),60)).append("|");       
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");                     
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1210.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
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

class Registro1220{
    //Texto fixo contendo "P990"
    private String REG;
    //Período de Apuração do Crédito (MM/AAAA)
    private String PER_APU_CRED;
    /*Indicador da origem do crédito:
    01 – Crédito decorrente de operações próprias;
    02 – Crédito transferido por pessoa jurídica sucedida.*/
    private String ORIG_CRED;
    //Código do Tipo do Crédito, conforme Tabela 4.3.6.
    private String COD_CRED;
    //Valor do Crédito a Descontar
    private String VL_CRED;

    private StringBuilder conteudo;
    
    Registro1220 registro1220 = new Registro1220();
    List<Registro1220> registros1220 = new ArrayList<Registro1220>();
    
    protected List<Registro1220> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1220 = new Registro1220();
                registro1220.setPER_APU_CRED("");
                registro1220.setORIG_CRED(RS.getString(""));     
                registro1220.setCOD_CRED(RS.getString(""));      
                registro1220.setVL_CRED(RS.getString(""));                
                                                              
                registros1220.add(registro1220);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1220.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1220;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1220").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getPER_APU_CRED())).append("|");
            conteudo.append(geral.efdNumerico(getORIG_CRED(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CRED(),3)).append("|");  
            conteudo.append(geral.efdNumerico(getVL_CRED(),8)).append("|");                                 
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1220.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getPER_APU_CRED() {
        return PER_APU_CRED;
    }

    public void setPER_APU_CRED(String PER_APU_CRED) {
        this.PER_APU_CRED = PER_APU_CRED;
    }

    public String getORIG_CRED() {
        return ORIG_CRED;
    }

    public void setORIG_CRED(String ORIG_CRED) {
        this.ORIG_CRED = ORIG_CRED;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getVL_CRED() {
        return VL_CRED;
    }

    public void setVL_CRED(String VL_CRED) {
        this.VL_CRED = VL_CRED;
    }
}

class Registro1300{
    //Texto fixo contendo "1300"
    private String REG;
    /*Indicador de Natureza da Retenção na Fonte:
    01 - Retenção por Órgãos, Autarquias e Fundações Federais
    02 - Retenção por outras Entidades da Administração Pública Federal
    03 - Retenção por Pessoas Jurídicas de Direito Privado
    04 - Recolhimento por Sociedade Cooperativa
    05 - Retenção por Fabricante de Máquinas e Veículos
    99 - Outras Retenções*/
    private String IND_NAT_RET;
    /*Período do Recebimento e da Retenção (MM/AAAA)*/
    private String PR_REC_RET;
    //Valor Total da Retenção
    private String VL_RET_APU;
    //Valor da Retenção deduzida da Contribuição devida no período da escrituração e em períodos anteriores.
    private String VL_RET_DED;
    //Valor da Retenção utilizada mediante Pedido de Restituição.
    private String VL_RET_PER;
    //Valor da Retenção utilizada mediante Declaração de Compensação.
    private String VL_RET_DCOMP;
    //Saldo de Retenção a utilizar em períodos de apuração futuros (04 – 05 - 06 - 07).
    private String SLD_RET;
    
    private StringBuilder conteudo;
    
    Registro1300 registro1300 = new Registro1300();
    List<Registro1300> registros1300 = new ArrayList<Registro1300>();
    
    protected List<Registro1300> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1300 = new Registro1300();
                registro1300.setIND_NAT_RET("");
                registro1300.setPR_REC_RET(RS.getString(""));     
                registro1300.setVL_RET_APU(RS.getString(""));      
                registro1300.setVL_RET_DED(RS.getString(""));
                
                registro1300.setVL_RET_PER(RS.getString(""));
                registro1300.setVL_RET_DCOMP(RS.getString(""));
                registro1300.setSLD_RET(RS.getString(""));                
                                                              
                registros1300.add(registro1300);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1300.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1300;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1300").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getIND_NAT_RET())).append("|");
            conteudo.append(geral.efdNumerico(getIND_NAT_RET(),2)).append("|");
            conteudo.append(geral.efdNumerico(getPR_REC_RET(),6)).append("|");  
            conteudo.append(geral.efdNumerico(getVL_RET_APU(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getVL_RET_DED(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getVL_RET_PER(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getVL_RET_DCOMP(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getSLD_RET(),8)).append("|");                                 
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1300.class.getName()).log(Level.SEVERE, null, e);
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

    public String getPR_REC_RET() {
        return PR_REC_RET;
    }

    public void setPR_REC_RET(String PR_REC_RET) {
        this.PR_REC_RET = PR_REC_RET;
    }

    public String getVL_RET_APU() {
        return VL_RET_APU;
    }

    public void setVL_RET_APU(String VL_RET_APU) {
        this.VL_RET_APU = VL_RET_APU;
    }

    public String getVL_RET_DED() {
        return VL_RET_DED;
    }

    public void setVL_RET_DED(String VL_RET_DED) {
        this.VL_RET_DED = VL_RET_DED;
    }

    public String getVL_RET_PER() {
        return VL_RET_PER;
    }

    public void setVL_RET_PER(String VL_RET_PER) {
        this.VL_RET_PER = VL_RET_PER;
    }

    public String getVL_RET_DCOMP() {
        return VL_RET_DCOMP;
    }

    public void setVL_RET_DCOMP(String VL_RET_DCOMP) {
        this.VL_RET_DCOMP = VL_RET_DCOMP;
    }

    public String getSLD_RET() {
        return SLD_RET;
    }

    public void setSLD_RET(String SLD_RET) {
        this.SLD_RET = SLD_RET;
    }
}

class Registro1500{
    //Texto fixo contendo "1500"
    private String REG;
    //Período de Apuração do Crédito (MM/AAAA)
    private String PER_APU_CRED;
    //Indicador da origem do crédito:
    //01 – Crédito decorrente de operações próprias;
    //02 – Crédito transferido por pessoa jurídica sucedida.
    private String ORIG_CRED;
    //CNPJ da pessoa jurídica cedente do crédito (se ORIG_CRED = 02).
    private String CNPJ_SUC;
    //Código do Tipo do Crédito, conforme Tabela 4.3.6.
    private String COD_CRED;
    //Valor do Crédito apurado na Escrituração Fiscal Digital ou em demonstrativo DACON de períodos anteriores.
    private String VL_CRED_APU;
    /*Valor de Crédito Extemporâneo Apurado (Registro 1501),
    referente a Período Anterior, Informado no Campo 02 –
    PER_APU_CRED*/
    private String VL_CRED_EXT_APU;
    //Valor Total do Crédito Apurado (06 + 07)
    private String VL_TOT_CRED_APU;
    //Valor do Crédito utilizado mediante Desconto, em Período(s) Anterior(es)
    private String VL_CRED_DESC_PA_ANT;
    /*Valor do Crédito utilizado mediante Pedido de
    Ressarcimento, em Período(s) Anterior(es).*/
    private String VL_CRED_PER_PA_ANT;
    /*Valor do Crédito utilizado mediante Declaração de
    Compensação Intermediária (Crédito de Exportação), em
    Período(s) Anterior(es)*/
    private String VL_CRED_DCOMP_PA_ANT;
    //Saldo do Crédito Disponível para Utilização neste Período de Escrituração (08-09-10-11)
    private String SD_CRED_DISP_EFD;
    //Valor do Crédito descontado neste período de escrituração
    private String VL_CRED_DESC_EFD;
    //Valor do Crédito objeto de Pedido de Ressarcimento (PER) neste período de escrituração
    private String VL_CRED_PER_EFD;
    /*Valor do Crédito utilizado mediante Declaração de
    Compensação Intermediária neste período de escrituração*/
    private String VL_CRED_DCOMP_EFD;
    /*Valor do crédito transferido em evento de cisão, fusão ou
    incorporação*/
    private String VL_CRED_TRANS;
    //Valor do crédito utilizado por outras formas
    private String VL_CRED_OUT;
    /*Saldo de créditos a utilizar em período de apuração futuro
    (12-13-14-15-16-17).*/
    private String SLD_CRED_FIM;
    
    private List<Registro1501> registros1501 = new ArrayList<Registro1501>();
    
    private StringBuilder conteudo;
    
    Registro1500 registro1500 = new Registro1500();
    List<Registro1500> registros1500 = new ArrayList<Registro1500>();
    
    protected List<Registro1500> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1500 = new Registro1500();
                registro1500.setPER_APU_CRED("");
                registro1500.setORIG_CRED(RS.getString(""));     
                registro1500.setCNPJ_SUC(RS.getString(""));      
                registro1500.setCOD_CRED(RS.getString(""));                
                registro1500.setVL_CRED_APU(RS.getString(""));
                registro1500.setVL_CRED_EXT_APU(RS.getString(""));
                registro1500.setVL_TOT_CRED_APU(RS.getString(""));                
                registro1500.setVL_CRED_APU(RS.getString(""));
                registro1500.setVL_CRED_EXT_APU(RS.getString(""));
                registro1500.setVL_TOT_CRED_APU(RS.getString(""));
                registro1500.setVL_CRED_DESC_PA_ANT(RS.getString(""));
                registro1500.setVL_CRED_PER_PA_ANT(RS.getString(""));
                registro1500.setVL_CRED_DCOMP_PA_ANT(RS.getString(""));                
                registro1500.setSD_CRED_DISP_EFD(RS.getString(""));
                registro1500.setVL_CRED_DESC_EFD(RS.getString(""));
                registro1500.setVL_CRED_PER_EFD(RS.getString(""));
                registro1500.setVL_CRED_DCOMP_EFD(RS.getString(""));                
                registro1500.setVL_CRED_TRANS(RS.getString(""));
                registro1500.setVL_CRED_OUT(RS.getString(""));
                registro1500.setSLD_CRED_FIM(RS.getString(""));
                                                              
                registros1500.add(registro1500);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1500.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1500;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1500").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getPER_APU_CRED())).append("|");
            conteudo.append(geral.efdNumerico(getORIG_CRED(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCNPJ_SUC(),6)).append("|");  
            conteudo.append(geral.efdNumerico(getCOD_CRED(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getVL_CRED_APU(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getVL_CRED_EXT_APU(),8)).append("|");                                 
            conteudo.append(geral.efdNumerico(getVL_TOT_CRED_APU(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_DESC_PA_ANT(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_PER_PA_ANT(),8)).append("|");
            
            conteudo.append(geral.efdNumerico(getVL_CRED_DCOMP_PA_ANT(),8)).append("|");
            conteudo.append(geral.efdNumerico(getSD_CRED_DISP_EFD(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_DESC_EFD(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_DCOMP_EFD(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_TRANS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_OUT(),8)).append("|");
            conteudo.append(geral.efdNumerico(getSLD_CRED_FIM(),8)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1500.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getPER_APU_CRED() {
        return PER_APU_CRED;
    }

    public void setPER_APU_CRED(String PER_APU_CRED) {
        this.PER_APU_CRED = PER_APU_CRED;
    }

    public String getORIG_CRED() {
        return ORIG_CRED;
    }

    public void setORIG_CRED(String ORIG_CRED) {
        this.ORIG_CRED = ORIG_CRED;
    }

    public String getCNPJ_SUC() {
        return CNPJ_SUC;
    }

    public void setCNPJ_SUC(String CNPJ_SUC) {
        this.CNPJ_SUC = CNPJ_SUC;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getVL_CRED_APU() {
        return VL_CRED_APU;
    }

    public void setVL_CRED_APU(String VL_CRED_APU) {
        this.VL_CRED_APU = VL_CRED_APU;
    }

    public String getVL_CRED_EXT_APU() {
        return VL_CRED_EXT_APU;
    }

    public void setVL_CRED_EXT_APU(String VL_CRED_EXT_APU) {
        this.VL_CRED_EXT_APU = VL_CRED_EXT_APU;
    }

    public String getVL_TOT_CRED_APU() {
        return VL_TOT_CRED_APU;
    }

    public void setVL_TOT_CRED_APU(String VL_TOT_CRED_APU) {
        this.VL_TOT_CRED_APU = VL_TOT_CRED_APU;
    }

    public String getVL_CRED_DESC_PA_ANT() {
        return VL_CRED_DESC_PA_ANT;
    }

    public void setVL_CRED_DESC_PA_ANT(String VL_CRED_DESC_PA_ANT) {
        this.VL_CRED_DESC_PA_ANT = VL_CRED_DESC_PA_ANT;
    }

    public String getVL_CRED_PER_PA_ANT() {
        return VL_CRED_PER_PA_ANT;
    }

    public void setVL_CRED_PER_PA_ANT(String VL_CRED_PER_PA_ANT) {
        this.VL_CRED_PER_PA_ANT = VL_CRED_PER_PA_ANT;
    }

    public String getVL_CRED_DCOMP_PA_ANT() {
        return VL_CRED_DCOMP_PA_ANT;
    }

    public void setVL_CRED_DCOMP_PA_ANT(String VL_CRED_DCOMP_PA_ANT) {
        this.VL_CRED_DCOMP_PA_ANT = VL_CRED_DCOMP_PA_ANT;
    }

    public String getSD_CRED_DISP_EFD() {
        return SD_CRED_DISP_EFD;
    }

    public void setSD_CRED_DISP_EFD(String SD_CRED_DISP_EFD) {
        this.SD_CRED_DISP_EFD = SD_CRED_DISP_EFD;
    }

    public String getVL_CRED_DESC_EFD() {
        return VL_CRED_DESC_EFD;
    }

    public void setVL_CRED_DESC_EFD(String VL_CRED_DESC_EFD) {
        this.VL_CRED_DESC_EFD = VL_CRED_DESC_EFD;
    }

    public String getVL_CRED_PER_EFD() {
        return VL_CRED_PER_EFD;
    }

    public void setVL_CRED_PER_EFD(String VL_CRED_PER_EFD) {
        this.VL_CRED_PER_EFD = VL_CRED_PER_EFD;
    }

    public String getVL_CRED_DCOMP_EFD() {
        return VL_CRED_DCOMP_EFD;
    }

    public void setVL_CRED_DCOMP_EFD(String VL_CRED_DCOMP_EFD) {
        this.VL_CRED_DCOMP_EFD = VL_CRED_DCOMP_EFD;
    }

    public String getVL_CRED_TRANS() {
        return VL_CRED_TRANS;
    }

    public void setVL_CRED_TRANS(String VL_CRED_TRANS) {
        this.VL_CRED_TRANS = VL_CRED_TRANS;
    }

    public String getVL_CRED_OUT() {
        return VL_CRED_OUT;
    }

    public void setVL_CRED_OUT(String VL_CRED_OUT) {
        this.VL_CRED_OUT = VL_CRED_OUT;
    }

    public String getSLD_CRED_FIM() {
        return SLD_CRED_FIM;
    }

    public void setSLD_CRED_FIM(String SLD_CRED_FIM) {
        this.SLD_CRED_FIM = SLD_CRED_FIM;
    }
        
}

class Registro1501{
    //Texto fixo contendo "1501"
    private String REG;
    //Código do participante (Campo 02 do Registro 0150)
    private String COD_PART;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1
    private String COD_MOD;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB_SER;
    //Número do documento fiscal
    private String NUM_DOC;
    //Data da Operação (ddmmaaaa)
    private String DT_OPER;
    //Chave da Nota Fiscal Eletrônica
    private String CHV_NFE;
    //Valor da Operação
    private String VL_OPER;
    //Código fiscal de operação e prestação
    private String CFOP;
    /*Código da Base de Cálculo do Crédito, conforme a Tabela
    indicada no item 4.3.7.*/
    private String NAT_BC_CRED;
    /*Indicador da origem do crédito:
    0 – Operação no Mercado Interno
    1 – Operação de Importação*/
    private String IND_ORIG_CRED;
    /*Código da Situação Tributária referente ao COFINS, conforme a
    Tabela indicada no item 4.3.4.*/
    private String CST_COFINS;
    /*Base de Cálculo do Crédito de COFINS (em valor ou em quantidade)*/
    private String VL_BC_COFINS;
    //Alíquota do COFINS (em percentual ou em reais)
    private String ALIQ_COFINS;
    //Valor do Crédito de COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Código do Centro de Custos
    private String COD_CCUS;
    //Descrição complementar do Documento/Operação
    private String DESC_COMPL;
    /*Mês/Ano da Escrituração em que foi registrado o
    documento/operação (Crédito pelo método da Apropriação
    Direta).*/
    private String PER_ESCRIT;
    /*CNPJ do estabelecimento gerador do crédito extemporâneo
    (Campo 04 do Registro 0140)*/
    private String CNPJ;
    
    private Registro1502 registro1502 = new Registro1502();
    
    private StringBuilder conteudo;
    
    Registro1501 Registro1501 = new Registro1501();
    List<Registro1501> registros1501 = new ArrayList<Registro1501>();
    
    protected List<Registro1501> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                Registro1501 = new Registro1501();
                Registro1501.setCOD_PART("");
                Registro1501.setCOD_ITEM(RS.getString(""));     
                Registro1501.setCOD_MOD(RS.getString(""));      
                Registro1501.setSER(RS.getString(""));                
                Registro1501.setSUB_SER(RS.getString(""));
                Registro1501.setNUM_DOC(RS.getString(""));
                Registro1501.setDT_OPER(RS.getString(""));                
                Registro1501.setCHV_NFE(RS.getString(""));
                Registro1501.setVL_OPER(RS.getString(""));
                Registro1501.setCFOP(RS.getString(""));
                Registro1501.setNAT_BC_CRED(RS.getString(""));
                Registro1501.setIND_ORIG_CRED(RS.getString(""));
                Registro1501.setCST_COFINS(RS.getString(""));                
                Registro1501.setVL_BC_COFINS(RS.getString(""));
                Registro1501.setALIQ_COFINS(RS.getString(""));
                Registro1501.setVL_COFINS(RS.getString(""));
                Registro1501.setCOD_CTA(RS.getString(""));                
                Registro1501.setCOD_CCUS(RS.getString(""));
                Registro1501.setDESC_COMPL(RS.getString(""));
                Registro1501.setPER_ESCRIT(RS.getString(""));
                Registro1501.setCNPJ(RS.getString(""));
                                                              
                registros1501.add(Registro1501);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1501.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1501;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1501").append("|"); 
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(),2)).append("|");  
            conteudo.append(geral.efdAlfanumerico(getSER(),4)).append("|");                                 
            conteudo.append(geral.efdAlfanumerico(getSUB_SER(),3)).append("|");                                 
            conteudo.append(geral.efdNumerico(getNUM_DOC(),9)).append("|");                                 
            conteudo.append(geral.efdRemoveSinais(getDT_OPER())).append("|");
            conteudo.append(geral.efdNumerico(getCHV_NFE(),44)).append("|");
            conteudo.append(geral.efdNumerico(getVL_OPER(),8)).append("|");            
            conteudo.append(geral.efdNumerico(getCFOP(),4)).append("|");
            conteudo.append(geral.efdNumerico(getNAT_BC_CRED(),8)).append("|");
            conteudo.append(geral.efdNumerico(getIND_ORIG_CRED(),1)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(),2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_BC_COFINS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_COFINS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(),60)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CCUS(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESC_COMPL())).append("|");
            conteudo.append(geral.efdNumerico(getPER_ESCRIT(),6)).append("|");
            conteudo.append(geral.efdNumerico(getCNPJ(),14)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1501.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
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

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getSUB_SER() {
        return SUB_SER;
    }

    public void setSUB_SER(String SUB_SER) {
        this.SUB_SER = SUB_SER;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDT_OPER() {
        return DT_OPER;
    }

    public void setDT_OPER(String DT_OPER) {
        this.DT_OPER = DT_OPER;
    }

    public String getCHV_NFE() {
        return CHV_NFE;
    }

    public void setCHV_NFE(String CHV_NFE) {
        this.CHV_NFE = CHV_NFE;
    }

    public String getVL_OPER() {
        return VL_OPER;
    }

    public void setVL_OPER(String VL_OPER) {
        this.VL_OPER = VL_OPER;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }

    public String getPER_ESCRIT() {
        return PER_ESCRIT;
    }

    public void setPER_ESCRIT(String PER_ESCRIT) {
        this.PER_ESCRIT = PER_ESCRIT;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}

class Registro1502{
    private String REG;
    private String VL_CRED_COFINS_TRIB_MI;
    private String VL_CRED_COFINS_NT_MI;
    private String VL_CRED_COFINS_EXP;
    
    private StringBuilder conteudo;
    
    Registro1502 registro1502 = new Registro1502();
    List<Registro1502> registros1502 = new ArrayList<Registro1502>();
    
    protected List<Registro1502> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1502 = new Registro1502();
                registro1502.setVL_CRED_COFINS_TRIB_MI("");
                registro1502.setVL_CRED_COFINS_NT_MI(RS.getString(""));     
                registro1502.setVL_CRED_COFINS_EXP(RS.getString(""));                                
                                                              
                registros1502.add(registro1502);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1502.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1502;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1502").append("|"); 
            conteudo.append(geral.efdNumerico(getVL_CRED_COFINS_TRIB_MI(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_COFINS_NT_MI(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CRED_COFINS_EXP(),8)).append("|");                   
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1502.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_CRED_COFINS_TRIB_MI() {
        return VL_CRED_COFINS_TRIB_MI;
    }

    public void setVL_CRED_COFINS_TRIB_MI(String VL_CRED_COFINS_TRIB_MI) {
        this.VL_CRED_COFINS_TRIB_MI = VL_CRED_COFINS_TRIB_MI;
    }

    public String getVL_CRED_COFINS_NT_MI() {
        return VL_CRED_COFINS_NT_MI;
    }

    public void setVL_CRED_COFINS_NT_MI(String VL_CRED_COFINS_NT_MI) {
        this.VL_CRED_COFINS_NT_MI = VL_CRED_COFINS_NT_MI;
    }

    public String getVL_CRED_COFINS_EXP() {
        return VL_CRED_COFINS_EXP;
    }

    public void setVL_CRED_COFINS_EXP(String VL_CRED_COFINS_EXP) {
        this.VL_CRED_COFINS_EXP = VL_CRED_COFINS_EXP;
    }
    
}


class Registro1600{
    //Texto fixo contendo "1600"
    private String REG;
    //Período de Apuração da Contribuição Social Extemporânea (MMAAAA)
    private String PER_APUR_ANT;
    //Natureza da Contribuição a Recolher, conforme Tabela 4.3.5.
    private String NAT_CONT_REC;
    //Valor da Contribuição Apurada
    private String VL_CONT_APUR;
    //Valor do Crédito de COFINS a Descontar, da Contribuição Social Extemporânea.    
    private String VL_CRED_COFINS_DESC;
    //Valor da Contribuição Social Extemporânea Devida.
    private String VL_CONT_DEV;
    //Valor de Outras Deduções.
    private String VL_OUT_DED;
    //Valor da Contribuição Social Extemporânea a pagar.
    private String VL_CONT_EXT;
    //Valor da Multa.
    private String VL_MUL;
    //Valor dos Juros.
    private String VL_JUR;
    //Data do Recolhimento.
    private String DT_RECOL;
    private List<Registro1610> registros1610 = new ArrayList<Registro1610>();
    private List<Registro1620> registros1620 = new ArrayList<Registro1620>();
    
    private StringBuilder conteudo;
    
    Registro1600 registro1600 = new Registro1600();
    List<Registro1600> registros1600 = new ArrayList<Registro1600>();
    
    protected List<Registro1600> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1600 = new Registro1600();
                registro1600.setPER_APUR_ANT("");
                registro1600.setNAT_CONT_REC(RS.getString(""));     
                registro1600.setVL_CONT_APUR(RS.getString(""));                  
                registro1600.setVL_CRED_COFINS_DESC("");
                registro1600.setVL_CONT_DEV(RS.getString(""));     
                registro1600.setVL_OUT_DED(RS.getString(""));                
                registro1600.setVL_CONT_EXT("");
                registro1600.setVL_MUL(RS.getString(""));     
                registro1600.setVL_JUR(RS.getString(""));
                registro1600.setDT_RECOL(RS.getString(""));
                                                              
                registros1600.add(registro1600);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1600.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1600;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1600").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getPER_APUR_ANT())).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_CONT_REC(),2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CONT_APUR(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_CRED_COFINS_DESC(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_CONT_DEV(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_OUT_DED(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_CONT_EXT(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_MUL(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_JUR(),8)).append("|");
            conteudo.append(geral.efdNumerico(getDT_RECOL(),8)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1600.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getPER_APUR_ANT() {
        return PER_APUR_ANT;
    }

    public void setPER_APUR_ANT(String PER_APUR_ANT) {
        this.PER_APUR_ANT = PER_APUR_ANT;
    }

    public String getNAT_CONT_REC() {
        return NAT_CONT_REC;
    }

    public void setNAT_CONT_REC(String NAT_CONT_REC) {
        this.NAT_CONT_REC = NAT_CONT_REC;
    }

    public String getVL_CONT_APUR() {
        return VL_CONT_APUR;
    }

    public void setVL_CONT_APUR(String VL_CONT_APUR) {
        this.VL_CONT_APUR = VL_CONT_APUR;
    }

    public String getVL_CRED_COFINS_DESC() {
        return VL_CRED_COFINS_DESC;
    }

    public void setVL_CRED_COFINS_DESC(String VL_CRED_COFINS_DESC) {
        this.VL_CRED_COFINS_DESC = VL_CRED_COFINS_DESC;
    }

    public String getVL_CONT_DEV() {
        return VL_CONT_DEV;
    }

    public void setVL_CONT_DEV(String VL_CONT_DEV) {
        this.VL_CONT_DEV = VL_CONT_DEV;
    }

    public String getVL_OUT_DED() {
        return VL_OUT_DED;
    }

    public void setVL_OUT_DED(String VL_OUT_DED) {
        this.VL_OUT_DED = VL_OUT_DED;
    }

    public String getVL_CONT_EXT() {
        return VL_CONT_EXT;
    }

    public void setVL_CONT_EXT(String VL_CONT_EXT) {
        this.VL_CONT_EXT = VL_CONT_EXT;
    }

    public String getVL_MUL() {
        return VL_MUL;
    }

    public void setVL_MUL(String VL_MUL) {
        this.VL_MUL = VL_MUL;
    }

    public String getVL_JUR() {
        return VL_JUR;
    }

    public void setVL_JUR(String VL_JUR) {
        this.VL_JUR = VL_JUR;
    }

    public String getDT_RECOL() {
        return DT_RECOL;
    }

    public void setDT_RECOL(String DT_RECOL) {
        this.DT_RECOL = DT_RECOL;
    }
}

class Registro1610{
    //Texto fixo contendo “1610”
    private String REG;
    /*Número de inscrição do estabelecimento no CNPJ
    (Campo 04 do Registro 0140).*/
    private String CNPJ;
    /*Código da Situação Tributária referente a COFINS,
    conforme a Tabela indicada no item 4.3.4.*/
    private String CST_COFINS;
    /*Código do participante (Campo 02 do Registro 0150)*/
    private String COD_PART;
    //Data da Operação (ddmmaaaa)
    private String DT_OPER;
    //Valor da Operação
    private String VL_OPER;
    //Base de cálculo da COFINS (em valor ou em quantidade)
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual ou em reais)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    //Descrição complementar do Documento/Operação
    private String DESC_COMPL;

    private StringBuilder conteudo;
    
    Registro1610 registro1610 = new Registro1610();
    List<Registro1610> registros1610 = new ArrayList<Registro1610>();
    
    protected List<Registro1610> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1610 = new Registro1610();
                registro1610.setCNPJ("");
                registro1610.setCST_COFINS(RS.getString(""));     
                registro1610.setCOD_PART(RS.getString(""));                  
                registro1610.setDT_OPER("");
                registro1610.setVL_OPER(RS.getString(""));     
                registro1610.setVL_BC_COFINS(RS.getString(""));                
                registro1610.setALIQ_COFINS("");
                registro1610.setVL_COFINS(RS.getString(""));     
                registro1610.setCOD_CTA(RS.getString(""));
                registro1610.setDESC_COMPL(RS.getString(""));
                                                              
                registros1610.add(registro1610);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1610.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1610;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1610").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_PART(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getDT_OPER(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_OPER(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_BC_COFINS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_COFINS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS(),8)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(),8)).append("|");
            conteudo.append(geral.efdNumerico(getDESC_COMPL(),8)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1610.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
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

    public String getDESC_COMPL() {
        return DESC_COMPL;
    }

    public void setDESC_COMPL(String DESC_COMPL) {
        this.DESC_COMPL = DESC_COMPL;
    }
    
}

class Registro1620{
    //Texto fixo contendo "1620"
    private String REG;
    //Período de Apuração do Crédito (MM/AAAA)
    private String PER_APU_CRED;
    /*Indicador da origem do crédito:
    01 – Crédito decorrente de operações próprias;
    02 – Crédito transferido por pessoa jurídica sucedida.*/
    private String ORIG_CRED;
    //Código do Tipo do Crédito, conforme Tabela 4.3.6.
    private String COD_CRED;
    //Valor do Crédito a Descontar
    private String VL_CRED;
    
    private StringBuilder conteudo;
    
    Registro1620 registro1620 = new Registro1620();
    List<Registro1620> registros1620 = new ArrayList<Registro1620>();
    
    protected List<Registro1620> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1620 = new Registro1620();
                registro1620.setPER_APU_CRED("");
                registro1620.setORIG_CRED(RS.getString(""));     
                registro1620.setCOD_CRED(RS.getString(""));                  
                registro1620.setVL_CRED("");                
                                                              
                registros1620.add(registro1620);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1620.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1620;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1620").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getPER_APU_CRED())).append("|");
            conteudo.append(geral.efdAlfanumerico(getORIG_CRED(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CRED(),3)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_CRED(),8)).append("|");                   
            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1620.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getPER_APU_CRED() {
        return PER_APU_CRED;
    }

    public void setPER_APU_CRED(String PER_APU_CRED) {
        this.PER_APU_CRED = PER_APU_CRED;
    }

    public String getORIG_CRED() {
        return ORIG_CRED;
    }

    public void setORIG_CRED(String ORIG_CRED) {
        this.ORIG_CRED = ORIG_CRED;
    }

    public String getCOD_CRED() {
        return COD_CRED;
    }

    public void setCOD_CRED(String COD_CRED) {
        this.COD_CRED = COD_CRED;
    }

    public String getVL_CRED() {
        return VL_CRED;
    }

    public void setVL_CRED(String VL_CRED) {
        this.VL_CRED = VL_CRED;
    }
}



class Registro1700{
    //Texto fixo contendo "1700"
    private String REG;
    /*Indicador de Natureza da Retenção na Fonte:
    01 - Retenção por Órgãos, Autarquias e Fundações Federais
    02 - Retenção por outras Entidades da Administração Pública
    Federal
    03 - Retenção por Pessoas Jurídicas de Direito Privado
    04 - Recolhimento por Sociedade Cooperativa
    05 - Retenção por Fabricante de Máquinas e Veículos
    99 - Outras Retenções*/
    private String IND_NAT_RET;
    //Período do Recebimento e da Retenção (MM/AAAA)        
    private String PR_REC_RET;
    //Valor Total da Retenção
    private String VL_RET_APU;
    //Valor da Retenção deduzida da Contribuição devida no período da escrituração e em períodos anteriores.
    private String VL_RET_DED;
    //Valor da Retenção utilizada mediante Pedido de Restituição
    private String VL_RET_PER;
    //Valor da Retenção utilizada mediante Declaração de Compensação.
    private String VL_RET_DCOMP;
    /*Saldo de Retenção a utilizar em períodos de apuração futuros
(04 - 05 - 06 - 07).*/
    private String SLD_RET;
    
    private StringBuilder conteudo;
    
    Registro1700 registro1700 = new Registro1700();
    List<Registro1700> registros1700 = new ArrayList<Registro1700>();
    
    protected List<Registro1700> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1700 = new Registro1700();
                registro1700.setIND_NAT_RET("");
                registro1700.setPR_REC_RET(RS.getString(""));     
                registro1700.setVL_RET_APU(RS.getString(""));                  
                registro1700.setVL_RET_DED("");                                                                                 
                registro1700.setVL_RET_PER(RS.getString(""));     
                registro1700.setVL_RET_DCOMP(RS.getString(""));                  
                registro1700.setSLD_RET(""); 
                
                registros1700.add(registro1700);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1700.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1700;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1700").append("|"); 
            conteudo.append(geral.efdNumerico(getIND_NAT_RET(),2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getPR_REC_RET())).append("|");
            conteudo.append(geral.efdNumerico(getVL_RET_APU(),8)).append("|");
            conteudo.append(geral.efdNumerico(getVL_RET_DED(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_RET_PER(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_RET_DCOMP(),8)).append("|");
            conteudo.append(geral.efdNumerico(getSLD_RET(),8)).append("|");            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1700.class.getName()).log(Level.SEVERE, null, e);
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

    public String getPR_REC_RET() {
        return PR_REC_RET;
    }

    public void setPR_REC_RET(String PR_REC_RET) {
        this.PR_REC_RET = PR_REC_RET;
    }

    public String getVL_RET_DED() {
        return VL_RET_DED;
    }

    public void setVL_RET_DED(String VL_RET_DED) {
        this.VL_RET_DED = VL_RET_DED;
    }

    public String getVL_RET_PER() {
        return VL_RET_PER;
    }

    public void setVL_RET_PER(String VL_RET_PER) {
        this.VL_RET_PER = VL_RET_PER;
    }   

    public String getSLD_RET() {
        return SLD_RET;
    }

    public void setSLD_RET(String SLD_RET) {
        this.SLD_RET = SLD_RET;
    }

    public String getVL_RET_APU() {
        return VL_RET_APU;
    }

    public void setVL_RET_APU(String VL_RET_APU) {
        this.VL_RET_APU = VL_RET_APU;
    }

    public String getVL_RET_DCOMP() {
        return VL_RET_DCOMP;
    }

    public void setVL_RET_DCOMP(String VL_RET_DCOMP) {
        this.VL_RET_DCOMP = VL_RET_DCOMP;
    }
}

class Registro1800{
    //Texto fixo contendo "1800"
    private String REG;
    //Empreendimento objeto de Incorporação Imobiliária, optante pelo RET.
    private String INC_IMOB;
    //Receitas recebidas pela incorporadora na venda das unidades imobiliárias que compõem a incorporação.
    private String REC_RECEB_RET;
    //Receitas Financeiras e Variações Monetárias decorrentes das vendas submetidas ao RET
    private String REC_FIN_RET;
    //Base de Cálculo do Recolhimento Unificado
    private String BC_RET;
    //Alíquota do Recolhimento Unificado.
    private String ALIQ_RET;
    //Valor do Recolhimento Unificado
    private String VL_REC_UNI;
    //Data do recolhimento unificado
    private String DT_REC_UNI;
    //Código da Receita
    private String COD_REC;
    private List<Registro1809> registros1809 = new ArrayList<Registro1809>();

    private StringBuilder conteudo;
    
    Registro1800 registro1800 = new Registro1800();
    List<Registro1800> registros1800 = new ArrayList<Registro1800>();
    
    protected List<Registro1800> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1800 = new Registro1800();
                registro1800.setINC_IMOB("");
                registro1800.setREC_RECEB_RET(RS.getString(""));     
                registro1800.setREC_FIN_RET(RS.getString(""));                  
                registro1800.setBC_RET("");                                                                                 
                registro1800.setALIQ_RET(RS.getString(""));     
                registro1800.setVL_REC_UNI(RS.getString(""));                  
                registro1800.setDT_REC_UNI(""); 
                registro1800.setCOD_REC("");             
                
                registros1800.add(registro1800);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1800.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1800;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1800").append("|"); 
            conteudo.append(geral.efdAlfanumerico(getINC_IMOB(),90)).append("|");
            conteudo.append(geral.efdNumerico(getREC_RECEB_RET(),8)).append("|");
            conteudo.append(geral.efdNumerico(getREC_FIN_RET(),8)).append("|");
            conteudo.append(geral.efdNumerico(getBC_RET(),8)).append("|");                   
            conteudo.append(geral.efdNumerico(getALIQ_RET(),6)).append("|");                   
            conteudo.append(geral.efdNumerico(getVL_REC_UNI(),8)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_REC_UNI())).append("|");
            conteudo.append(geral.efdNumerico(getCOD_REC(),4)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1800.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getINC_IMOB() {
        return INC_IMOB;
    }

    public void setINC_IMOB(String INC_IMOB) {
        this.INC_IMOB = INC_IMOB;
    }

    public String getREC_RECEB_RET() {
        return REC_RECEB_RET;
    }

    public void setREC_RECEB_RET(String REC_RECEB_RET) {
        this.REC_RECEB_RET = REC_RECEB_RET;
    }

    public String getREC_FIN_RET() {
        return REC_FIN_RET;
    }

    public void setREC_FIN_RET(String REC_FIN_RET) {
        this.REC_FIN_RET = REC_FIN_RET;
    }

    public String getBC_RET() {
        return BC_RET;
    }

    public void setBC_RET(String BC_RET) {
        this.BC_RET = BC_RET;
    }

    public String getALIQ_RET() {
        return ALIQ_RET;
    }

    public void setALIQ_RET(String ALIQ_RET) {
        this.ALIQ_RET = ALIQ_RET;
    }

    public String getVL_REC_UNI() {
        return VL_REC_UNI;
    }

    public void setVL_REC_UNI(String VL_REC_UNI) {
        this.VL_REC_UNI = VL_REC_UNI;
    }

    public String getDT_REC_UNI() {
        return DT_REC_UNI;
    }

    public void setDT_REC_UNI(String DT_REC_UNI) {
        this.DT_REC_UNI = DT_REC_UNI;
    }

    public String getCOD_REC() {
        return COD_REC;
    }

    public void setCOD_REC(String COD_REC) {
        this.COD_REC = COD_REC;
    }
}

class Registro1809{
    //Texto fixo contendo "1809"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    /*Indicador da origem do processo:
    1 - Justiça Federal;
    3 – Secretaria da Receita Federal do Brasil
    9 – Outros.*/
    private String IND_PROC;
    
    private StringBuilder conteudo;
    
    Registro1809 registro1809 = new Registro1809();
    List<Registro1809> registros1809 = new ArrayList<Registro1809>();
    
    protected List<Registro1809> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1809 = new Registro1809();
                registro1809.setNUM_PROC("");
                registro1809.setIND_PROC(RS.getString(""));                                
                
                registros1809.add(registro1809);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1809.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1809;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1809").append("|"); 
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(),20)).append("|");            
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(),1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1809.class.getName()).log(Level.SEVERE, null, e);
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

class Registro1900{
    //Texto fixo contendo "1900”
    private String REG;
    //CNPJ do estabelecimento da pessoa jurídica, emitente dos documentos geradores de receita
    private String CNPJ;
    //Código do modelo do documento fiscal conforme a Tabela 4.1.1, ou: 
    //98 – Nota Fiscal de Prestação de Serviços (ISSQN) 
    //99 – Outros Documentos
    private String COD_MOD;
    //Série do documento fiscal
    private String SER;
    //Subserie do documento fiscal
    private String SUB_SER;
    /*Código da situação do documento fiscal:
00 – Documento regular
02 – Documento cancelado
99 – Outros*/
    private String COD_SIT;
    //Valor total da receita, conforme os documentos emitidos no período, representativos da venda de bens e serviços
    private String VL_TOT_REC;
    //Quantidade total de documentos emitidos no período
    private String QUANT_DOC;
    //Código da Situação Tributária do PIS/Pasep
    private String CST_PIS;
    //Código da Situação Tributária da Cofins
    private String CST_COFINS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Informações complementares
    private String INF_COMPL;
    //Código da conta analítica contábil representativa da receita
    private String COD_CTA;
    
    private StringBuilder conteudo;
    
    Registro1900 registro1900 = new Registro1900();
    List<Registro1900> registros1900 = new ArrayList<Registro1900>();
    
    protected List<Registro1900> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1900 = new Registro1900();
                registro1900.setCNPJ("");
                registro1900.setCOD_MOD(RS.getString(""));     
                registro1900.setSER(RS.getString(""));
                registro1900.setSUB_SER(RS.getString(""));
                registro1900.setCOD_SIT(RS.getString(""));
                registro1900.setVL_TOT_REC(RS.getString(""));
                registro1900.setQUANT_DOC(RS.getString(""));
                registro1900.setCST_PIS(RS.getString(""));
                
                registro1900.setCST_COFINS(RS.getString(""));
                registro1900.setCFOP(RS.getString(""));
                registro1900.setINF_COMPL(RS.getString(""));
                registro1900.setCOD_CTA(RS.getString(""));
                                                              
                registros1900.add(registro1900);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1900.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1900;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1900").append("|"); 
            conteudo.append(geral.efdNumerico(getCNPJ(),14)).append("|");    
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(),4)).append("|");
            conteudo.append(geral.efdNumerico(getSUB_SER(),20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_SIT(),2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_TOT_REC(),8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getQUANT_DOC(),1)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(),2)).append("|");
            conteudo.append(geral.efdNumerico(getCFOP(),4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getINF_COMPL())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(),60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1900.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getSUB_SER() {
        return SUB_SER;
    }

    public void setSUB_SER(String SUB_SER) {
        this.SUB_SER = SUB_SER;
    }

    public String getCOD_SIT() {
        return COD_SIT;
    }

    public void setCOD_SIT(String COD_SIT) {
        this.COD_SIT = COD_SIT;
    }

    public String getVL_TOT_REC() {
        return VL_TOT_REC;
    }

    public void setVL_TOT_REC(String VL_TOT_REC) {
        this.VL_TOT_REC = VL_TOT_REC;
    }

    public String getQUANT_DOC() {
        return QUANT_DOC;
    }

    public void setQUANT_DOC(String QUANT_DOC) {
        this.QUANT_DOC = QUANT_DOC;
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

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getINF_COMPL() {
        return INF_COMPL;
    }

    public void setINF_COMPL(String INF_COMPL) {
        this.INF_COMPL = INF_COMPL;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class Registro1990{
    //Texto fixo contendo "1990"
    private String REG;
    //Quantidade total de linhas do Bloco 1
    private String QTD_LIN_1;
    
    private StringBuilder conteudo;
    
    Registro1990 registro1990 = new Registro1990();
    List<Registro1990> registros1990 = new ArrayList<Registro1990>();
    
    protected List<Registro1990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro1990 = new Registro1990();
                registro1990.setQTD_LIN_1("");                
                                                              
                registros1990.add(registro1990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro1990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros1990;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|1990").append("|"); 
            conteudo.append(geral.efdRemoveSinais(getQTD_LIN_1())).append("|");                
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro1900.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getQTD_LIN_1() {
        return QTD_LIN_1;
    }

    public void setQTD_LIN_1(String QTD_LIN_1) {
        this.QTD_LIN_1 = QTD_LIN_1;
    }
}