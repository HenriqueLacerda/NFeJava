/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped.efdpiscofins;

import crncomp.conexao;
import java.sql.ResultSet;
import crncomp.geral;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev - Breno
 */
class BlocoD {

    private RegistroD001 registroD001 = new RegistroD001();
    private List<RegistroD100> registroD100 = new ArrayList<RegistroD100>();
//    private List<RegistroD300> registroD300 = new ArrayList<RegistroD300>();    
    private List<RegistroD500> registroD500 = new ArrayList<RegistroD500>();   
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;
    
      public BlocoD() {
        conexao = new conexao();
        conteudo = new StringBuilder();

        // Busca dos dados

    }

    /**
     * Chama todos os métodos e faz todas as consultas para a montagem do EFD
     * @return StringBuilder
     */
    public StringBuilder gerarEFD() {
        //Primeiro deverão ser chamados todos os metodos para buscar os registros nos bancos de dados.                   

        try {
            

            conteudo.append(registroD001.gerarRegistro());

            return conteudo;
        } catch (Exception e) {
            Logger.getLogger(Bloco0.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}

class RegistroD001 {

    private String REG;
    private String IND_MOV;
    
    private StringBuilder conteudo;

    RegistroD001 registroD001 = new RegistroD001();
    List<RegistroD001> registrosD001 = new ArrayList<RegistroD001>();
    
    protected List<RegistroD001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD001 = new RegistroD001();
                registroD001.setIND_MOV(RS.getString(""));                         
                
                registrosD001.add(registroD001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD001;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D001").append("|");
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

class RegistroD010{
    //Texto fixo contendo “D010”.
    private String REG;
    //Número de inscrição do estabelecimento no CNPJ.
    private String CNPJ;
    
    private StringBuilder conteudo;

    RegistroD010 registroD010 = new RegistroD010();
    List<RegistroD010> registrosD010 = new ArrayList<RegistroD010>();
    
    protected List<RegistroD010> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD010 = new RegistroD010();
                registroD010.setCNPJ(RS.getString(""));                         
                
                registrosD010.add(registroD010);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroF001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD010;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D010").append("|");
            conteudo.append(geral.efdAlfanumerico(getCNPJ(), 14)).append("|");            
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

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
    List<RegistroD100> registrosD100 = new ArrayList<RegistroD100>();
    List<RegistroD200> registrosD200 = new ArrayList<RegistroD200>();  
    List<RegistroD300> registrosD300 = new ArrayList<RegistroD300>();    
    List<RegistroD350> registrosD350 = new ArrayList<RegistroD350>();   
    List<RegistroD500> registrosD500 = new ArrayList<RegistroD500>();        
    
    
}


class RegistroD100 {

//    Texto fixo contendo "C100"
    private String REG;
//    Indicador do tipo de operação:
//    0- Entrada;
//    1- Saída
    private String IND_OPER;
//    Indicador do emitente do documento fiscal:
//    0- Emissão própria;
//    1- Terceiros
    private String IND_EMIT;
//    Código do participante (campo 02 do Registro 0150):
//    - do emitente do documento ou do remetente das mercadorias, no caso de entradas;
//    - do adquirente, no caso de saídas
    private String COD_PART;
//    Código do modelo do documento fiscal, conforme a Tabela 4.1.1
    private String COD_MOD;
//    Código da situação do documento fiscal, conforme a Tabela 4.1.2
    private String COD_SIT;
//    Série do documento fiscal
    private String SER;
//    Subsérie do documento fiscal
    private String SUB;
//    Número do documento fiscal
    private String NUM_DOC;
//    Chave do Conhecimento de Transporte Eletrônico
    private String CHV_CTE;
//    Data da emissão do documento fiscal
    private String DT_DOC;
//    Data da aquisição ou da prestação do serviço
    private String DT_A_P;
//    Tipo de Conhecimento de Transporte Eletrônico conforme definido no Manual de Integração do CT-e N 001* - N
//    14 CHV_CTE_REF Chave do CT-e de referência cujos
    private String TP_CTE;
//    Chave do CT-e de referência cujos valores foram complementados (opção “1” do campo anterior) ou cujo débito foi anulado (opção “2” do campo anterior).
    private String CHV_CTE_REF;
//    Valor total do documento fiscal        
    private String VL_DOC;
//    Valor total do desconto
    private String VL_DESC;
//    Indicador do tipo do frete:
//    0- Por conta de terceiros;
//    1- Por conta do emitente;
//    2- Por conta do destinatário;
//    9- Sem cobrança de frete.    
    private String IND_FRT;
//    Valor total da prestação de serviço
    private String VL_SERV;
//    Valor da base de cálculo do ICMS
    private String VL_BC_ICMS;
//    Valor do ICMS
    private String VL_ICMS;
//    Valor não-tributado do ICMS
    private String VL_NT;
//    Código da informação complementar do documento fiscal (campo 02 do Registro 0450)
    private String COD_INF;
//    Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    
    List<RegistroD101> registrosD101 = new ArrayList<RegistroD101>();
    List<RegistroD105> registrosD105 = new ArrayList<RegistroD105>();
    List<RegistroD111> registrosD111 = new ArrayList<RegistroD111>();
    
    private StringBuilder conteudo;

    RegistroD100 registroD100 = new RegistroD100();
    List<RegistroD100> registrosD100 = new ArrayList<RegistroD100>();
    
    protected List<RegistroD100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD100 = new RegistroD100();
                registroD100.setIND_OPER(RS.getString(""));
                registroD100.setIND_EMIT(RS.getString(""));
                registroD100.setCOD_PART(RS.getString(""));
                registroD100.setCOD_MOD(RS.getString(""));
                registroD100.setCOD_SIT(RS.getString(""));
                registroD100.setSER(RS.getString(""));
                registroD100.setSUB(RS.getString(""));
                registroD100.setNUM_DOC(RS.getString(""));
                registroD100.setCHV_CTE(RS.getString(""));
                registroD100.setDT_DOC(RS.getString(""));
                registroD100.setDT_A_P(RS.getString(""));
                registroD100.setTP_CTE(RS.getString(""));
                registroD100.setCHV_CTE_REF(RS.getString(""));
                registroD100.setVL_DOC(RS.getString(""));
                registroD100.setVL_DESC(RS.getString(""));
                registroD100.setIND_FRT(RS.getString(""));
                registroD100.setVL_SERV(RS.getString(""));
                registroD100.setVL_BC_ICMS(RS.getString(""));                
                registroD100.setVL_ICMS(RS.getString(""));
                registroD100.setVL_NT(RS.getString(""));
                registroD100.setCOD_INF(RS.getString(""));
                registroD100.setCOD_CTA(RS.getString(""));                                
                
                registrosD100.add(registroD100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD100;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D100").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_OPER(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_EMIT(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_SIT(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC(), 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCHV_CTE(),44)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_DOC(), 8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_A_P(), 8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getTP_CTE(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCHV_CTE_REF(), 44)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_FRT(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_SERV()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_NT()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_INF(), 6)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
              

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getCOD_SIT() {
        return COD_SIT;
    }

    public void setCOD_SIT(String COD_SIT) {
        this.COD_SIT = COD_SIT;
    }    

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getIND_EMIT() {
        return IND_EMIT;
    }

    public void setIND_EMIT(String IND_EMIT) {
        this.IND_EMIT = IND_EMIT;
    }

    public String getIND_FRT() {
        return IND_FRT;
    }

    public void setIND_FRT(String IND_FRT) {
        this.IND_FRT = IND_FRT;
    }

    public String getIND_OPR() {
        return getIND_OPER();
    }

    public void setIND_OPR(String IND_OPR) {
        this.setIND_OPER(IND_OPR);
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }    

    public String getVL_BC_ICMS() {
        return VL_BC_ICMS;
    }

    public void setVL_BC_ICMS(String VL_BC_ICMS) {
        this.VL_BC_ICMS = VL_BC_ICMS;
    }

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_ICMS() {
        return VL_ICMS;
    }

    public void setVL_ICMS(String VL_ICMS) {
        this.VL_ICMS = VL_ICMS;
    }

    public String getIND_OPER() {
        return IND_OPER;
    }

    public void setIND_OPER(String IND_OPER) {
        this.IND_OPER = IND_OPER;
    }

    public String getSUB() {
        return SUB;
    }

    public void setSUB(String SUB) {
        this.SUB = SUB;
    }

    public String getCHV_CTE() {
        return CHV_CTE;
    }

    public void setCHV_CTE(String CHV_CTE) {
        this.CHV_CTE = CHV_CTE;
    }

    public String getDT_A_P() {
        return DT_A_P;
    }

    public void setDT_A_P(String DT_A_P) {
        this.DT_A_P = DT_A_P;
    }

    public String getTP_CTE() {
        return TP_CTE;
    }

    public void setTP_CTE(String TP_CTE) {
        this.TP_CTE = TP_CTE;
    }

    public String getCHV_CTE_REF() {
        return CHV_CTE_REF;
    }

    public void setCHV_CTE_REF(String CHV_CTE_REF) {
        this.CHV_CTE_REF = CHV_CTE_REF;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
    }

    public String getVL_NT() {
        return VL_NT;
    }

    public void setVL_NT(String VL_NT) {
        this.VL_NT = VL_NT;
    }

    public String getCOD_INF() {
        return COD_INF;
    }

    public void setCOD_INF(String COD_INF) {
        this.COD_INF = COD_INF;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}


class RegistroD101{
    //Texto fixo contendo "D101”
    private String REG;
//    Indicador da Natureza do Frete Contratado, referente a:
//    0 – Operações de vendas, com ônus suportado pelo
//    estabelecimento vendedor;
//    1 – Operações de vendas, com ônus suportado peloadquirente;
//    2 – Operações de compras (bens para revenda, matériasprima e outros produtos, geradores de crédito);
//    3 – Operações de compras (bens para revenda, matériasprima e outros produtos, não geradores de crédito);
//    4 – Transferência de produtos acabados entre estabelecimentos da pessoa jurídica;
//    5 – Transferência de produtos em elaboração entre estabelecimentos da pessoa jurídica
//    9 – Outras.
    private String IND_NAT_FRT;
//    Valor total dos itens
    private String VL_ITEM;
//    Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
//    Código da Base de Cálculo do Crédito, conforme a Tabela indicada no item 4.3.7.
    private String NAT_BC_CRED;
//    Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
//    Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
//    Valor do PIS/PASEP
    private String VL_PIS;
//    Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD101 registroD101 = new RegistroD101();
    List<RegistroD101> registrosD101 = new ArrayList<RegistroD101>();
    
    protected List<RegistroD101> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD101 = new RegistroD101();
                registroD101.setIND_NAT_FRT(RS.getString(""));
                registroD101.setVL_ITEM(RS.getString(""));
                registroD101.setCST_PIS(RS.getString(""));
                registroD101.setNAT_BC_CRED(RS.getString(""));
                registroD101.setVL_BC_PIS(RS.getString(""));
                registroD101.setALIQ_PIS(RS.getString(""));
                registroD101.setVL_PIS(RS.getString(""));                                             
                
                registrosD101.add(registroD101);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD101.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD101;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D101").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_NAT_FRT(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            
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

    public String getIND_NAT_FRT() {
        return IND_NAT_FRT;
    }

    public void setIND_NAT_FRT(String IND_NAT_FRT) {
        this.IND_NAT_FRT = IND_NAT_FRT;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getNAT_BC_CRED() {
        return NAT_BC_CRED;
    }

    public void setNAT_BC_CRED(String NAT_BC_CRED) {
        this.NAT_BC_CRED = NAT_BC_CRED;
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
    
    
}


class RegistroD105{
    //Texto fixo contendo "D105”
    private String REG;
    //Indicador da Natureza do Frete Contratado, referente a:
    //    0 – Operações de vendas, com ônus suportado pelo estabelecimento vendedor;
    //    1 – Operações de vendas, com ônus suportado pelo adquirente;
    //    2 – Operações de compras (bens para revenda, matériasprima e outros produtos, geradores de crédito);
    //    3 – Operações de compras (bens para revenda, matériasprima e outros produtos, não geradores de crédito);
    //    4 – Transferência de produtos acabados entre estabelecimentos da pessoa jurídica
    //    5 – Transferência de produtos em elaboração entre estabelecimentos da pessoa jurídica
    //    9 – Outras.
    private String IND_NAT_FRT;
    //Valor total dos itens
    private String VL_ITEM;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Código da base de Cálculo do Crédito, conforme a Tabela indicada no item 4.3.7
    private String NAT_BC_CRED;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD105 registroD105 = new RegistroD105();
    List<RegistroD105> registrosD105 = new ArrayList<RegistroD105>();
    
    protected List<RegistroD105> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD105 = new RegistroD105();
                registroD105.setIND_NAT_FRT(RS.getString(""));
                registroD105.setVL_ITEM(RS.getString(""));
                registroD105.setCST_COFINS(RS.getString(""));
                registroD105.setNAT_BC_CRED(RS.getString(""));
                registroD105.setVL_BC_COFINS(RS.getString(""));
                registroD105.setALIQ_COFINS(RS.getString(""));
                registroD105.setVL_COFINS(RS.getString(""));
                registroD105.setCOD_CTA(RS.getString(""));
                
                registrosD105.add(registroD105);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD105.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD105;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D105").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_NAT_FRT(), 1)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            
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

    public String getIND_NAT_FRT() {
        return IND_NAT_FRT;
    }

    public void setIND_NAT_FRT(String IND_NAT_FRT) {
        this.IND_NAT_FRT = IND_NAT_FRT;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getNAT_BC_CRED() {
        return NAT_BC_CRED;
    }

    public void setNAT_BC_CRED(String NAT_BC_CRED) {
        this.NAT_BC_CRED = NAT_BC_CRED;
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
    
}


class RegistroD111{
    //Texto fixo contendo "D111"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //    1 - Justiça Federal;
    //    3 – Secretaria da Receita Federal do Brasil
    //    9 – Outros.
    
    private StringBuilder conteudo;

    RegistroD111 registroD111 = new RegistroD111();
    List<RegistroD111> registrosD111 = new ArrayList<RegistroD111>();
    
    protected List<RegistroD111> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD111 = new RegistroD111();
                registroD111.setNUM_PROC(RS.getString(""));
                registroD111.setIND_PROC(RS.getString(""));               
                
                registrosD111.add(registroD111);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD111.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD111;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D111").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    private String IND_PROC;

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


class RegistroD200{
    //Texto fixo contendo "D111"
    private String REG;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1
    private String COD_MOD;
    //Código da situação do documento fiscal, conforme a Tabela 4.1.2
    private String COD_SIT;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB;
    //Número do documento fiscal inicial emitido no período (mesmo modelo, série e subsérie).
    private String NUM_DOC_INI;
    //Número do documento fiscal final emitido no período (mesmo modelo, série e subsérie).
    private String NUM_DOC_FIN;
    //Código Fiscal de Operação e Prestação conforme tabela indicada no item 4.2.2
    private String CFOP;
    //Data do dia de referência do resumo diário
    private String DT_REF;
    //Valor total dos documentos fiscais
    private String VL_DOC;
    //Valor total dos descontos
    private String VL_DESC;
    
    private StringBuilder conteudo;

    RegistroD200 registroD200 = new RegistroD200();
    List<RegistroD200> registrosD200 = new ArrayList<RegistroD200>();
    
    protected List<RegistroD200> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD200 = new RegistroD200();
                registroD200.setCOD_MOD(RS.getString(""));
                registroD200.setCOD_SIT(RS.getString(""));               
                registroD200.setSER(RS.getString(""));
                registroD200.setSUB(RS.getString(""));
                registroD200.setNUM_DOC_INI(RS.getString(""));
                registroD200.setNUM_DOC_FIN(RS.getString(""));
                registroD200.setCFOP(RS.getString(""));
                registroD200.setDT_REF(RS.getString(""));
                registroD200.setVL_DOC(RS.getString(""));
                registroD200.setVL_DESC(RS.getString(""));
                
                registrosD200.add(registroD200);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD200.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD200;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D200").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");            
            conteudo.append(geral.efdAlfanumerico(getCOD_SIT(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC_INI(), 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC_FIN(), 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_REF(), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    List<RegistroD201> registrosD201 = new ArrayList<RegistroD201>();
    List<RegistroD205> registrosD205 = new ArrayList<RegistroD205>();
    List<RegistroD209> registrosD209 = new ArrayList<RegistroD209>();

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCOD_SIT() {
        return COD_SIT;
    }

    public void setCOD_SIT(String COD_SIT) {
        this.COD_SIT = COD_SIT;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getSUB() {
        return SUB;
    }

    public void setSUB(String SUB) {
        this.SUB = SUB;
    }

    public String getNUM_DOC_INI() {
        return NUM_DOC_INI;
    }

    public void setNUM_DOC_INI(String NUM_DOC_INI) {
        this.NUM_DOC_INI = NUM_DOC_INI;
    }

    public String getNUM_DOC_FIN() {
        return NUM_DOC_FIN;
    }

    public void setNUM_DOC_FIN(String NUM_DOC_FIN) {
        this.NUM_DOC_FIN = NUM_DOC_FIN;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getDT_REF() {
        return DT_REF;
    }

    public void setDT_REF(String DT_REF) {
        this.DT_REF = DT_REF;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
    }
    
}


class RegistroD201{
    //Texto fixo contendo "D201"
    private String REG;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor total dos itens
    private String VL_ITEM;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD201 registroD201 = new RegistroD201();
    List<RegistroD201> registrosD201 = new ArrayList<RegistroD201>();
    
    protected List<RegistroD201> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD201 = new RegistroD201();
                registroD201.setCST_PIS(RS.getString(""));
                registroD201.setVL_ITEM(RS.getString(""));               
                registroD201.setVL_BC_PIS(RS.getString(""));
                registroD201.setALIQ_PIS(RS.getString(""));
                registroD201.setVL_PIS(RS.getString(""));
                registroD201.setCOD_CTA(RS.getString(""));                
                
                registrosD201.add(registroD201);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD201.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD201;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D201").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");                        
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");                        
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            
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

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
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
    
}


class RegistroD205{
     //Texto fixo contendo "D205"
     private String REG;
     //Código da Situação Tributária referente a COFINS.
     private String CST_COFINS;
     //Valor total dos itens
     private String VL_ITEM;
     //Valor da base de cálculo da COFINS
     private String VL_BC_COFINS;
     //Alíquota da COFINS (em percentual)
     private String ALIQ_COFINS;
     //Valor da COFINS
     private String VL_COFINS;
     //Código da conta analítica contábil debitada/creditada
     private String COD_CTA;

    private StringBuilder conteudo;

    RegistroD205 registroD205 = new RegistroD205();
    List<RegistroD205> registrosD205 = new ArrayList<RegistroD205>();
    
    protected List<RegistroD205> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD205 = new RegistroD205();
                registroD205.setCST_COFINS(RS.getString(""));
                registroD205.setVL_ITEM(RS.getString(""));               
                registroD205.setVL_BC_COFINS(RS.getString(""));
                registroD205.setALIQ_COFINS(RS.getString(""));
                registroD205.setVL_COFINS(RS.getString(""));
                registroD205.setCOD_CTA(RS.getString(""));                
                
                registrosD205.add(registroD205);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD205.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD205;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D205").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");                        
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");                        
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            
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

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
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
}


class RegistroD209{
    //Texto fixo contendo "D209"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
//    1 - Justiça Federal;
//    3 – Secretaria da Receita Federal do Brasil
//    9 – Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroD209 registroD209 = new RegistroD209();
    List<RegistroD209> registrosD209 = new ArrayList<RegistroD209>();
    
    protected List<RegistroD209> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD209 = new RegistroD209();
                registroD209.setNUM_PROC(RS.getString(""));
                registroD209.setIND_PROC(RS.getString(""));                                             
                
                registrosD209.add(registroD209);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD209.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD209;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D209").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 2)).append("|");                                    
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 60)).append("|");                        
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


class RegistroD300{
    //Texto fixo contendo "D300"
    private String REG;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1.
    private String COD_MOD;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB;
    //Número do primeiro documento fiscal emitido no período (mesmo modelo, série e subsérie)
    private String NUM_DOC_INI;
    //Número do último documento fiscal emitido no período (mesmo modelo, série e subsérie)
    private String NUM_DOC_FIN;
    //Código Fiscal de Operação e Prestação conforme tabela indicada no item 4.2.2
    private String CFOP;
    //Data do dia de referência do resumo diário
    private String DT_REF;
    //Valor total dos documentos fiscais emitidos
    private String VL_DOC;
    //Valor total dos descontos
    private String VL_DESC;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD300 registroD300 = new RegistroD300();
    List<RegistroD300> registrosD300 = new ArrayList<RegistroD300>();
    
    protected List<RegistroD300> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD300 = new RegistroD300();
                registroD300.setCOD_MOD(RS.getString(""));
                registroD300.setSER(RS.getString(""));               
                registroD300.setSUB(RS.getString(""));
                registroD300.setNUM_DOC_INI(RS.getString(""));
                registroD300.setNUM_DOC_FIN(RS.getString(""));
                registroD300.setCFOP(RS.getString(""));
                
                registroD300.setDT_REF(RS.getString(""));
                registroD300.setVL_DOC(RS.getString(""));
                registroD300.setVL_DESC(RS.getString(""));
                registroD300.setCST_PIS(RS.getString(""));
                registroD300.setVL_BC_PIS(RS.getString(""));
                registroD300.setALIQ_PIS(RS.getString(""));
                registroD300.setVL_PIS(RS.getString(""));
                registroD300.setCST_COFINS(RS.getString(""));
                registroD300.setVL_BC_COFINS(RS.getString(""));
                
                registroD300.setALIQ_COFINS(RS.getString(""));
                registroD300.setVL_COFINS(RS.getString(""));
                registroD300.setVL_BC_COFINS(RS.getString(""));
                                                              
                registrosD300.add(registroD300);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD300.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD300;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D300").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC_INI())).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC_FIN())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_REF(), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|"); 
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    List<RegistroD309> registrosD309 = new ArrayList<RegistroD309>();      

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
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

    public String getSUB() {
        return SUB;
    }

    public void setSUB(String SUB) {
        this.SUB = SUB;
    }

    public String getNUM_DOC_INI() {
        return NUM_DOC_INI;
    }

    public void setNUM_DOC_INI(String NUM_DOC_INI) {
        this.NUM_DOC_INI = NUM_DOC_INI;
    }

    public String getNUM_DOC_FIN() {
        return NUM_DOC_FIN;
    }

    public void setNUM_DOC_FIN(String NUM_DOC_FIN) {
        this.NUM_DOC_FIN = NUM_DOC_FIN;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getDT_REF() {
        return DT_REF;
    }

    public void setDT_REF(String DT_REF) {
        this.DT_REF = DT_REF;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
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
}


class RegistroD309{
    //Texto fixo contendo "D309"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //    1 - Justiça Federal;
    //    3 – Secretaria da Receita Federal do Brasil
    private String IND_PROC;

    private StringBuilder conteudo;

    RegistroD309 registroD309 = new RegistroD309();
    List<RegistroD309> registrosD309 = new ArrayList<RegistroD309>();
    
    protected List<RegistroD309> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD309 = new RegistroD309();
                registroD309.setNUM_PROC(RS.getString(""));
                registroD309.setIND_PROC(RS.getString(""));                               
                                                              
                registrosD309.add(registroD309);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD309.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD309;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D309").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 4)).append("|");            
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

class RegistroD350{
    //Texto fixo contendo "D350"
    private String REG;   
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1
    private String COD_MOD;
    //Modelo do equipamento
    private String ECF_MOD;
    //Número de série de fabricação do ECF
    private String ECF_FAB;
    //Data do movimento a que se refere a Redução Z
    private String DT_DOC;
    //Posição do Contador de Reinício de Operação
    private String CRO;
    //Posição do Contador de Redução Z
    private String CRZ;
    //Número do Contador de Ordem de Operação do último documento emitido no dia. (Número do COO na Redução Z)
    private String NUM_COO_FIN;
    //Valor do Grande Total final
    private String GT_FIN;
    //Valor da venda bruta
    private String VL_BRT;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Quantidade – Base de cálculo PIS/PASEP
    private String QUANT_BC_PIS;
    //Alíquota do PIS/PASEP (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Quantidade – Base de cálculo da COFINS
    private String QUANT_BC_COFINS;
    //Alíquota da COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroD350 registroD350 = new RegistroD350();
    List<RegistroD350> registrosD350 = new ArrayList<RegistroD350>();
    
    protected List<RegistroD350> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD350 = new RegistroD350();
                registroD350.setCOD_MOD(RS.getString(""));
                registroD350.setECF_MOD(RS.getString(""));                
                registroD350.setECF_FAB(RS.getString(""));
                registroD350.setDT_DOC(RS.getString(""));
                registroD350.setCRO(RS.getString(""));
                registroD350.setCRZ(RS.getString(""));
                registroD350.setNUM_COO_FIN(RS.getString(""));
                registroD350.setGT_FIN(RS.getString(""));
                registroD350.setVL_BRT(RS.getString(""));
                registroD350.setCST_PIS(RS.getString(""));
                registroD350.setVL_BC_PIS(RS.getString(""));
                registroD350.setALIQ_PIS(RS.getString(""));                
                registroD350.setQUANT_BC_PIS(RS.getString(""));
                registroD350.setALIQ_PIS_QUANT(RS.getString(""));
                registroD350.setVL_PIS(RS.getString(""));
                registroD350.setCST_COFINS(RS.getString(""));
                registroD350.setVL_BC_COFINS(RS.getString(""));                
                registroD350.setALIQ_COFINS(RS.getString(""));
                registroD350.setQUANT_BC_COFINS(RS.getString(""));
                registroD350.setALIQ_COFINS_QUANT(RS.getString(""));
                registroD350.setVL_COFINS(RS.getString(""));
                registroD350.setCOD_CTA(RS.getString(""));
                
                                                              
                registrosD350.add(registroD350);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD350.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD350;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D350").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getECF_MOD(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getECF_FAB(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_DOC(),8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCRO(),3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCRZ(),4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_COO_FIN(), 6)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getGT_FIN()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BRT()), 2)).append("|"); 
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }
    
    
    List<RegistroD359> registrosD359 = new ArrayList<RegistroD359>();

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getECF_MOD() {
        return ECF_MOD;
    }

    public void setECF_MOD(String ECF_MOD) {
        this.ECF_MOD = ECF_MOD;
    }

    public String getECF_FAB() {
        return ECF_FAB;
    }

    public void setECF_FAB(String ECF_FAB) {
        this.ECF_FAB = ECF_FAB;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getCRO() {
        return CRO;
    }

    public void setCRO(String CRO) {
        this.CRO = CRO;
    }

    public String getCRZ() {
        return CRZ;
    }

    public void setCRZ(String CRZ) {
        this.CRZ = CRZ;
    }

    public String getNUM_COO_FIN() {
        return NUM_COO_FIN;
    }

    public void setNUM_COO_FIN(String NUM_COO_FIN) {
        this.NUM_COO_FIN = NUM_COO_FIN;
    }

    public String getGT_FIN() {
        return GT_FIN;
    }

    public void setGT_FIN(String GT_FIN) {
        this.GT_FIN = GT_FIN;
    }

    public String getVL_BRT() {
        return VL_BRT;
    }

    public void setVL_BRT(String VL_BRT) {
        this.VL_BRT = VL_BRT;
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
}

class RegistroD359{
    //Texto fixo contendo "D359"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //        1 - Justiça Federal;
    //        3 – Secretaria da Receita Federal do Brasil
    //        9 – Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroD359 registroD359 = new RegistroD359();
    List<RegistroD359> registrosD359 = new ArrayList<RegistroD359>();
    
    protected List<RegistroD359> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD359 = new RegistroD359();
                registroD359.setNUM_PROC(RS.getString(""));
                registroD359.setIND_PROC(RS.getString(""));                               
                                                              
                registrosD359.add(registroD359);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD359.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD359;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D359").append("|");
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


class RegistroD500 {

    //Texto fixo contendo "D500"
    private String REG;
    //Indicador do tipo de operação: 0- Aquisição
    private String IND_OPER;
    //Indicador do emitente do documento fiscal:
    //0- Emissão própria;
    //1- Terceiros
    private String IND_EMIT;
    //Código do participante prestador do serviço (campo 02 do Registro 0150).
    private String COD_PART;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1.
    private String COD_MOD;
    //Código da situação do documento fiscal, conforme a Tabela 4.1.2.
    private String COD_SIT;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB;
    //Número do documento fiscal
    private String NUM_DOC;
    //Data da emissão do documento fiscal
    private String DT_DOC;
    //Data da entrada (aquisição)
    private String DT_A_P;
    //Valor total do documento fiscal
    private String VL_DOC;
    //Valor total do desconto
    private String VL_DESC;
    //Valor da prestação de serviços
    private String VL_SERV;
    //Valor total dos serviços não-tributados pelo ICMS
    private String VL_SERV_NT;
    //Valores cobrados em nome de terceiros
    private String VL_TERC;
    //Valor de outras despesas indicadas no documento fiscal
    private String VL_DA;
    //Valor da base de cálculo do ICMS
    private String VL_BC_ICMS;
    //Valor do ICMS
    private String VL_ICMS;
    //Código da informação complementar (campo 02 do Registro 0450)    
    private String COD_INF;    
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Valor da COFINS
    private String VL_COFINS;
    
    List<RegistroD501> registrosD501 = new ArrayList<RegistroD501>();
    List<RegistroD505> registrosD505 = new ArrayList<RegistroD505>();
    List<RegistroD509> registrosD509 = new ArrayList<RegistroD509>();
    
    private StringBuilder conteudo;

    RegistroD500 registroD500 = new RegistroD500();
    List<RegistroD500> registrosD500 = new ArrayList<RegistroD500>();
    
    protected List<RegistroD500> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD500 = new RegistroD500();
                registroD500.setIND_OPER(RS.getString(""));
                registroD500.setIND_EMIT(RS.getString(""));                
                registroD500.setCOD_PART(RS.getString(""));
                registroD500.setCOD_MOD(RS.getString(""));
                registroD500.setCOD_SIT(RS.getString(""));
                registroD500.setSER(RS.getString(""));
                registroD500.setSUB(RS.getString(""));
                registroD500.setNUM_DOC(RS.getString(""));                
                registroD500.setDT_DOC(RS.getString(""));
                registroD500.setDT_A_P(RS.getString(""));
                registroD500.setVL_DOC(RS.getString(""));                
                registroD500.setVL_DESC(RS.getString(""));
                registroD500.setVL_SERV(RS.getString(""));
                registroD500.setVL_SERV_NT(RS.getString(""));                
                registroD500.setVL_TERC(RS.getString(""));
                registroD500.setVL_DA(RS.getString(""));
                registroD500.setVL_BC_ICMS(RS.getString(""));
                registroD500.setVL_ICMS(RS.getString(""));
                registroD500.setCOD_INF(RS.getString(""));
                registroD500.setVL_PIS(RS.getString(""));
                registroD500.setVL_COFINS(RS.getString(""));
                                                              
                registrosD500.add(registroD500);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD500.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD500;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D500").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_OPER(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_EMIT(), 1)).append("|");                        
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_SIT(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC(), 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_DOC(), 8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_A_P(), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_SERV()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_SERV_NT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TERC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DA()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_INF(), 6)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");            
            
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_INF() {
        return COD_INF;
    }

    public void setCOD_INF(String COD_INF) {
        this.COD_INF = COD_INF;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getCOD_SIT() {
        return COD_SIT;
    }

    public void setCOD_SIT(String COD_SIT) {
        this.COD_SIT = COD_SIT;
    }

    public String getDT_A_P() {
        return DT_A_P;
    }

    public void setDT_A_P(String DT_A_P) {
        this.DT_A_P = DT_A_P;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getIND_EMIT() {
        return IND_EMIT;
    }

    public void setIND_EMIT(String IND_EMIT) {
        this.IND_EMIT = IND_EMIT;
    }

    public String getIND_OPER() {
        return IND_OPER;
    }

    public void setIND_OPER(String IND_OPER) {
        this.IND_OPER = IND_OPER;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getSUB() {
        return SUB;
    }

    public void setSUB(String SUB) {
        this.SUB = SUB;
    }

    public String getVL_BC_ICMS() {
        return VL_BC_ICMS;
    }

    public void setVL_BC_ICMS(String VL_BC_ICMS) {
        this.VL_BC_ICMS = VL_BC_ICMS;
    }

    public String getVL_DA() {
        return VL_DA;
    }

    public void setVL_DA(String VL_DA) {
        this.VL_DA = VL_DA;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_ICMS() {
        return VL_ICMS;
    }

    public void setVL_ICMS(String VL_ICMS) {
        this.VL_ICMS = VL_ICMS;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
    }

    public String getVL_SERV_NT() {
        return VL_SERV_NT;
    }

    public void setVL_SERV_NT(String VL_SERV_NT) {
        this.VL_SERV_NT = VL_SERV_NT;
    }

    public String getVL_TERC() {
        return VL_TERC;
    }

    public void setVL_TERC(String VL_TERC) {
        this.VL_TERC = VL_TERC;
    }

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    
class RegistroD501{
    //Texto fixo contendo "D501"
    private String REG;
    private String CST_PIS;
    private String VL_ITEM;
    private String NAT_BC_CRED;
    private String VL_BC_PIS;
    private String ALIQ_PIS;
    private String VL_PIS;
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD501 registroD501 = new RegistroD501();
    List<RegistroD501> registrosD501 = new ArrayList<RegistroD501>();
    
    protected List<RegistroD501> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD501 = new RegistroD501();
                registroD501.setCST_PIS(RS.getString(""));
                registroD501.setVL_ITEM(RS.getString(""));                
                registroD501.setNAT_BC_CRED(RS.getString(""));
                registroD501.setVL_BC_PIS(RS.getString(""));
                registroD501.setALIQ_PIS(RS.getString(""));
                registroD501.setVL_PIS(RS.getString(""));
                registroD501.setCOD_CTA(RS.getString(""));                
                                                              
                registrosD501.add(registroD501);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD501.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD501;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D501").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_ITEM(), 1)).append("|");                        
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(),60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_BC_PIS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_PIS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_PIS(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 3)).append("|");            
            
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

        public String getCST_PIS() {
            return CST_PIS;
        }

        public void setCST_PIS(String CST_PIS) {
            this.CST_PIS = CST_PIS;
        }

        public String getVL_ITEM() {
            return VL_ITEM;
        }

        public void setVL_ITEM(String VL_ITEM) {
            this.VL_ITEM = VL_ITEM;
        }

        public String getNAT_BC_CRED() {
            return NAT_BC_CRED;
        }

        public void setNAT_BC_CRED(String NAT_BC_CRED) {
            this.NAT_BC_CRED = NAT_BC_CRED;
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
    }    
    
class RegistroD505{
    //Texto fixo contendo "D505"
    private String REG;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor Total dos Itens
    private String VL_ITEM;
    //Código da Base de Cálculo do Crédito, conforme a Tabela indicada no item 4.3.7.
    private String NAT_BC_CRED;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;    
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD505 registroD505 = new RegistroD505();
    List<RegistroD505> registrosD505 = new ArrayList<RegistroD505>();
    
    protected List<RegistroD505> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD505 = new RegistroD505();
                registroD505.setCST_COFINS(RS.getString(""));
                registroD505.setVL_ITEM(RS.getString(""));                
                registroD505.setNAT_BC_CRED(RS.getString(""));
                registroD505.setVL_BC_COFINS(RS.getString(""));
                registroD505.setALIQ_COFINS(RS.getString(""));
                registroD505.setVL_COFINS(RS.getString(""));
                registroD505.setCOD_CTA(RS.getString(""));                
                                                              
                registrosD505.add(registroD505);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD505.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD505;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D505").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");            
            
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

        public String getCST_COFINS() {
            return CST_COFINS;
        }

        public void setCST_COFINS(String CST_COFINS) {
            this.CST_COFINS = CST_COFINS;
        }

        public String getVL_ITEM() {
            return VL_ITEM;
        }

        public void setVL_ITEM(String VL_ITEM) {
            this.VL_ITEM = VL_ITEM;
        }

        public String getNAT_BC_CRED() {
            return NAT_BC_CRED;
        }

        public void setNAT_BC_CRED(String NAT_BC_CRED) {
            this.NAT_BC_CRED = NAT_BC_CRED;
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
    }
        
class RegistroD509{
    //Texto fixo contendo "D509"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
//    Indicador da origem do processo:
//    1 - Justiça Federal;
//    3 – Secretaria da Receita Federal do Brasil
//    9 – Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroD509 registroD509 = new RegistroD509();
    List<RegistroD509> registrosD509 = new ArrayList<RegistroD509>();
    
    protected List<RegistroD509> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD509 = new RegistroD509();
                registroD509.setNUM_PROC(RS.getString(""));
                registroD509.setIND_PROC(RS.getString(""));                                           
                                                              
                registrosD509.add(registroD509);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD509.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD509;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D509").append("|");
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
        
class RegistroD600 {
    //Texto fixo contendo "D600"
    private String REG;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1.
    private String COD_MOD;
    //Código do município dos terminais faturados, conforme a tabela IBGE
    private String COD_MUN;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB;
//    Indicador do tipo de receita:
//    0- Receita própria - serviços prestados;
//    1- Receita própria - cobrança de débitos;
//    2- Receita própria - venda de serviço pré-pago – faturamento de períodos anteriores;
//    3- Receita própria - venda de serviço pré-pago – faturamento no período;
//    4- Outras receitas próprias de serviços de comunicação e telecomunicação;
//    5- Receita própria - co-faturamento;
//    6- Receita própria – serviços a faturar em período futuro;
//    7– Outras receitas próprias de natureza não-cumulativa;
//    8 - Outras receitas de terceiros
//    9 – Outras receitas
    private String IND_REC;
    //Quantidade de documentos consolidados neste registro
    private String QTD_CONS;
    //Data Inicial dos documentos consolidados no período
    private String DT_DOC_INI;
    //Data Final dos documentos consolidados no período
    private String DT_DOC_FIN;
    //Valor total acumulado dos documentos fiscais
    private String VL_DOC;
    //Valor acumulado dos descontos
    private String VL_DESC;
    //Valor acumulado das prestações de serviços tributados pelo ICMS
    private String VL_SERV;
    //Valor acumulado dos serviços não-tributados pelo ICMS
    private String VL_SERV_NT;
    //Valores cobrados em nome de terceiros
    private String VL_TERC;
    //Valores cobrados em nome de terceiros
    private String VL_DA;
    //Valor acumulado da base de cálculo do ICMS
    private String VL_BC_ICMS;
    //Valor acumulado do ICMS
    private String VL_ICMS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Valor da COFINS
    private String VL_COFINS;  
    
    List<RegistroD601> registrosD601 = new ArrayList<RegistroD601>();
    List<RegistroD605> registrosD605 = new ArrayList<RegistroD605>();
    List<RegistroD609> registrosD609 = new ArrayList<RegistroD609>();
    
    private StringBuilder conteudo;

    RegistroD600 registroD600 = new RegistroD600();
    List<RegistroD600> registrosD600 = new ArrayList<RegistroD600>();
    
    protected List<RegistroD600> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD600 = new RegistroD600();
                registroD600.setCOD_MOD(RS.getString(""));
                registroD600.setCOD_MUN(RS.getString(""));                
                registroD600.setSER(RS.getString(""));
                registroD600.setSUB(RS.getString(""));
                registroD600.setIND_REC(RS.getString(""));
                registroD600.setQTD_CONS(RS.getString(""));
                registroD600.setDT_DOC_INI(RS.getString(""));
                registroD600.setDT_DOC_FIN(RS.getString(""));
                registroD600.setVL_DOC(RS.getString(""));
                registroD600.setVL_DESC(RS.getString(""));                
                registroD600.setVL_SERV(RS.getString(""));
                registroD600.setVL_SERV_NT(RS.getString(""));
                registroD600.setVL_TERC(RS.getString(""));                
                registroD600.setVL_DA(RS.getString(""));
                registroD600.setVL_BC_ICMS(RS.getString(""));
                registroD600.setVL_ICMS(RS.getString(""));                
                registroD600.setVL_PIS(RS.getString(""));
                registroD600.setVL_COFINS(RS.getString(""));
                                                              
                registrosD600.add(registroD600);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD600.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD600;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|D600").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_MUN()), 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_REC(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getQTD_CONS())).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_DOC_INI(), 8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_DOC_FIN(), 8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_SERV()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_SERV_NT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TERC()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DA()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_ICMS()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            
            
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

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getCOD_MUN() {
        return COD_MUN;
    }

    public void setCOD_MUN(String COD_MUN) {
        this.COD_MUN = COD_MUN;
    }

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getSUB() {
        return SUB;
    }

    public void setSUB(String SUB) {
        this.SUB = SUB;
    }
    
    public String getQTD_CONS() {
        return QTD_CONS;
    }

    public void setQTD_CONS(String QTD_CONS) {
        this.QTD_CONS = QTD_CONS;
    }   

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
    }

    public String getVL_SERV_NT() {
        return VL_SERV_NT;
    }

    public void setVL_SERV_NT(String VL_SERV_NT) {
        this.VL_SERV_NT = VL_SERV_NT;
    }

    public String getVL_TERC() {
        return VL_TERC;
    }

    public void setVL_TERC(String VL_TERC) {
        this.VL_TERC = VL_TERC;
    }

    public String getVL_DA() {
        return VL_DA;
    }

    public void setVL_DA(String VL_DA) {
        this.VL_DA = VL_DA;
    }

    public String getVL_BC_ICMS() {
        return VL_BC_ICMS;
    }

    public void setVL_BC_ICMS(String VL_BC_ICMS) {
        this.VL_BC_ICMS = VL_BC_ICMS;
    }

    public String getVL_ICMS() {
        return VL_ICMS;
    }

    public void setVL_ICMS(String VL_ICMS) {
        this.VL_ICMS = VL_ICMS;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }   

    public String getIND_REC() {
        return IND_REC;
    }

    public void setIND_REC(String IND_REC) {
        this.IND_REC = IND_REC;
    }

    public String getDT_DOC_INI() {
        return DT_DOC_INI;
    }

    public void setDT_DOC_INI(String DT_DOC_INI) {
        this.DT_DOC_INI = DT_DOC_INI;
    }

    public String getDT_DOC_FIN() {
        return DT_DOC_FIN;
    }

    public void setDT_DOC_FIN(String DT_DOC_FIN) {
        this.DT_DOC_FIN = DT_DOC_FIN;
    }
}

class RegistroD601{
    //Texto fixo contendo "D601”
    private String REG;
    //Código de classificação do item do serviço de comunicação ou de telecomunicação, conforme a Tabela 4.4.1
    private String COD_CLASS;
    //Valor acumulado do item
    private String VL_ITEM;
    //Valor acumulado dos descontos/exclusões da base de cálculo
    private String VL_DESC;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da conta contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD601 registroD601 = new RegistroD601();
    List<RegistroD601> registrosD601 = new ArrayList<RegistroD601>();
    
    protected List<RegistroD601> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD601 = new RegistroD601();
                registroD601.setCOD_CLASS(RS.getString(""));
                registroD601.setVL_ITEM(RS.getString(""));                
                registroD601.setVL_DESC(RS.getString(""));
                registroD601.setCST_PIS(RS.getString(""));
                registroD601.setVL_BC_PIS(RS.getString(""));
                registroD601.setALIQ_PIS(RS.getString(""));
                registroD601.setVL_PIS(RS.getString(""));
                registroD601.setCOD_CTA(RS.getString(""));
                
                                                              
                registrosD601.add(registroD601);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD601.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD601;
    }

    protected StringBuilder gerarRegistro() {
        try {
                getConteudo().append("|D601").append("|");
                getConteudo().append(geral.efdAlfanumerico(getCOD_CLASS(), 4)).append("|");                            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
                getConteudo().append(geral.efdNumerico(getCST_PIS(), 2)).append("|");            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
                getConteudo().append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");                            
                        
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

        public String getCOD_CLASS() {
            return COD_CLASS;
        }

        public void setCOD_CLASS(String COD_CLASS) {
            this.COD_CLASS = COD_CLASS;
        }

        public String getVL_ITEM() {
            return VL_ITEM;
        }

        public void setVL_ITEM(String VL_ITEM) {
            this.VL_ITEM = VL_ITEM;
        }

        public String getVL_DESC() {
            return VL_DESC;
        }

        public void setVL_DESC(String VL_DESC) {
            this.VL_DESC = VL_DESC;
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

        public StringBuilder getConteudo() {
            return conteudo;
        }

        public void setConteudo(StringBuilder conteudo) {
            this.conteudo = conteudo;
        }
    }

class RegistroD605{
    //Texto fixo contendo "D605”
    private String REG;
    //Código de classificação do item do serviço de comunicação ou de telecomunicação, conforme a Tabela 4.4.1
    private String COD_CLASS;
    //Valor acumulado do item
    private String VL_ITEM;
    //Valor acumulado dos descontos/exclusões da base de cálculo
    private String VL_DESC;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta contábil debitada/creditada
    private String COD_CTA;
    
    private StringBuilder conteudo;

    RegistroD605 registroD605 = new RegistroD605();
    List<RegistroD605> registrosD605 = new ArrayList<RegistroD605>();
    
    protected List<RegistroD605> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD605 = new RegistroD605();
                registroD605.setCOD_CLASS(RS.getString(""));
                registroD605.setVL_ITEM(RS.getString(""));                
                registroD605.setVL_DESC(RS.getString(""));
                registroD605.setCST_COFINS(RS.getString(""));
                registroD605.setVL_BC_COFINS(RS.getString(""));
                registroD605.setALIQ_COFINS(RS.getString(""));
                registroD605.setVL_COFINS(RS.getString(""));
                registroD605.setCOD_CTA(RS.getString(""));
                
                                                              
                registrosD605.add(registroD605);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD605.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD605;
    }

    protected StringBuilder gerarRegistro() {
        try {
                getConteudo().append("|D605").append("|");
                getConteudo().append(geral.efdAlfanumerico(getCOD_CLASS(), 4)).append("|");                            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
                getConteudo().append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");            
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
                getConteudo().append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");                            
                getConteudo().append(geral.efdNumerico(getCOD_CTA(), 60)).append("|");                            
                        
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

    public String getCOD_CLASS() {
        return COD_CLASS;
    }

    public void setCOD_CLASS(String COD_CLASS) {
        this.COD_CLASS = COD_CLASS;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
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

        public StringBuilder getConteudo() {
            return conteudo;
        }

        public void setConteudo(StringBuilder conteudo) {
            this.conteudo = conteudo;
        }
    }

class RegistroD609{
    //Texto fixo contendo "D609"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:1 - Justiça Federal 3 – Secretaria da Receita Federal do Brasil 9 – Outros.
    private String IND_PROC;
    
    private StringBuilder conteudo;

   RegistroD609 registroD609 = new RegistroD609();
   List<RegistroD609> registrosD609 = new ArrayList<RegistroD609>();
    
    protected List<RegistroD609> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD609 = new RegistroD609();
                registroD609.setNUM_PROC(RS.getString(""));
                registroD609.setIND_PROC(RS.getString(""));                                               
                                                              
                registrosD609.add(registroD609);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD609.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD609;
    }

    protected StringBuilder gerarRegistro() {
        try {
                getConteudo().append("|D609").append("|");
                getConteudo().append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");                            
                getConteudo().append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");                            
                        
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

        public StringBuilder getConteudo() {
            return conteudo;
        }

        public void setConteudo(StringBuilder conteudo) {
            this.conteudo = conteudo;
        }
    }

class RegistroD990 {

    private String REG;
    private String QTD_LIN_D;
    
    private StringBuilder conteudo;

    RegistroD990 registroD990 = new RegistroD990();
    List<RegistroD990> registrosD990 = new ArrayList<RegistroD990>();
    
    protected List<RegistroD990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroD990 = new RegistroD990();
                registroD990.setQTD_LIN_D(RS.getString(""));                                               
                                                              
                registrosD990.add(registroD990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroD990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosD990;
    }

    protected StringBuilder gerarRegistro() {
        try {
                getConteudo().append("|D990").append("|");
                getConteudo().append(geral.efdAlfanumerico(getQTD_LIN_D(), 2)).append("|");                
                        
                getConteudo().append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return getConteudo();
    }

    public String getQTD_LIN_D() {
        return QTD_LIN_D;
    }

    public void setQTD_LIN_D(String QTD_LIN_D) {
        this.QTD_LIN_D = QTD_LIN_D;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

        public StringBuilder getConteudo() {
            return conteudo;
        }

        public void setConteudo(StringBuilder conteudo) {
            this.conteudo = conteudo;
        }
  }
}
