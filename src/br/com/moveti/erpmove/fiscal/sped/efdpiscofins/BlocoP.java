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
public class BlocoP {
    private RegistroP001 resgistroP001 = new RegistroP001();
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;

    public BlocoP() {
        conexao = new conexao();
        conteudo = new StringBuilder();

        // Busca dos dados
    }
}

class RegistroP001 {
  
    private String REG;
    private String IND_MOV;
    private List<RegistroP010> resgistrosP010 = new ArrayList<RegistroP010>();
    private List<RegistroP200> resgistrosP200 = new ArrayList<RegistroP200>();
    
    private StringBuilder conteudo;

    RegistroP001 registroP001 = new RegistroP001();
    List<RegistroP001> registrosP001 = new ArrayList<RegistroP001>();
    
    protected List<RegistroP001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP001 = new RegistroP001();
                registroP001.setIND_MOV(RS.getString(""));                                               
                                                              
                registrosP001.add(registroP001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP001;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P001").append("|");
            conteudo.append(geral.efdRemoveSinais(getIND_MOV())).append("|");            
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

    public String getIND_MOV() {
        return IND_MOV;
    }

    public void setIND_MOV(String IND_MOV) {
        this.IND_MOV = IND_MOV;
    }
    
}


class RegistroP010 {

    private String REG;
    private String CNPJ;
    private List<RegistroP100> resgistrosP100 = new ArrayList<RegistroP100>();
    
    private StringBuilder conteudo;

    RegistroP010 registroP010 = new RegistroP010();
    List<RegistroP010> registrosP010 = new ArrayList<RegistroP010>();
    
    protected List<RegistroP010> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP010 = new RegistroP010();
                registroP010.setCNPJ(RS.getString(""));                                               
                                                              
                registrosP010.add(registroP010);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP010.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP010;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P010").append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");            
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
    
}


class RegistroP100 {

    //Texto fixo contendo "P100"
    private String REG;
    //Data inicial a que a apuração se refere
    private String DT_INI;
    //Data final a que a apuração se refere
    private String DT_FIN;
    /*Valor da Receita Bruta Total do Estabelecimento no
    Período*/
    private String VL_REC_TOT_EST;
    /*Código indicador correspondente à atividade sujeita a
    incidência da Contribuição Previdenciária sobre a Receita
    Bruta, conforme Tabela 5.1.1.*/
    private String COD_ATIV_ECON;
    /*Valor da Receita Bruta do Estabelecimento,
    correspondente às atividades referidas no Campo 05
    (COD_ATIV_ECON)*/
    private String VL_REC_ATIV_ESTAB;
    /*Valor das Exclusões da Receita Bruta informada no
    Campo 06*/
    private String VL_EXC;
    /*Valor da Base de Cálculo da Contribuição Previdenciária
    sobre a Receita Bruta
    (Campo 08 = Campo 06 – Campo 07)*/
    private String VL_BC_CONT;
    //Alíquota da Contribuição Previdenciária sobre a Receita Bruta
    private String ALIQ_CONT;
    //Valor da Contribuição Previdenciária Apurada sobre a Receita Bruta
    private String VL_CONT_APU;
    /*Código da conta analítica contábil referente à Contribuição
    Previdenciária sobre a Receita Bruta*/
    private String COD_CTA;
    /*Informação complementar do registro*/
    private String INFO_COMPL;
    
    private List<RegistroP110> resgistrosP110 = new ArrayList<RegistroP110>();
    private List<RegistroP199> resgistrosP199 = new ArrayList<RegistroP199>();
    
    private StringBuilder conteudo;

    RegistroP100 registroP100 = new RegistroP100();
    List<RegistroP100> registrosP100 = new ArrayList<RegistroP100>();
    
    protected List<RegistroP100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP100 = new RegistroP100();
                registroP100.setDT_INI(RS.getString(""));             
                registroP100.setDT_FIN(RS.getString(""));
                registroP100.setVL_REC_TOT_EST(RS.getString(""));
                registroP100.setCOD_ATIV_ECON(RS.getString(""));
                registroP100.setVL_REC_ATIV_ESTAB(RS.getString(""));
                registroP100.setVL_EXC(RS.getString(""));
                registroP100.setVL_BC_CONT(RS.getString(""));
                registroP100.setALIQ_CONT(RS.getString(""));
                                                              
                registrosP100.add(registroP100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP100;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P100").append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_FIN())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_TOT_EST()),2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_ATIV_ECON(),8)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_REC_ATIV_ESTAB()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_EXC()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_CONT()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_CONT()),4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CONT_APU()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getINFO_COMPL(),2)).append("|");
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

    public String getDT_INI() {
        return DT_INI;
    }

    public void setDT_INI(String DT_INI) {
        this.DT_INI = DT_INI;
    }

    public String getDT_FIN() {
        return DT_FIN;
    }

    public void setDT_FIN(String DT_FIN) {
        this.DT_FIN = DT_FIN;
    }

    public String getVL_REC_TOT_EST() {
        return VL_REC_TOT_EST;
    }

    public void setVL_REC_TOT_EST(String VL_REC_TOT_EST) {
        this.VL_REC_TOT_EST = VL_REC_TOT_EST;
    }

    public String getCOD_ATIV_ECON() {
        return COD_ATIV_ECON;
    }

    public void setCOD_ATIV_ECON(String COD_ATIV_ECON) {
        this.COD_ATIV_ECON = COD_ATIV_ECON;
    }

    public String getVL_REC_ATIV_ESTAB() {
        return VL_REC_ATIV_ESTAB;
    }

    public void setVL_REC_ATIV_ESTAB(String VL_REC_ATIV_ESTAB) {
        this.VL_REC_ATIV_ESTAB = VL_REC_ATIV_ESTAB;
    }

    public String getVL_EXC() {
        return VL_EXC;
    }

    public void setVL_EXC(String VL_EXC) {
        this.VL_EXC = VL_EXC;
    }

    public String getVL_BC_CONT() {
        return VL_BC_CONT;
    }

    public void setVL_BC_CONT(String VL_BC_CONT) {
        this.VL_BC_CONT = VL_BC_CONT;
    }

    public String getALIQ_CONT() {
        return ALIQ_CONT;
    }

    public void setALIQ_CONT(String ALIQ_CONT) {
        this.ALIQ_CONT = ALIQ_CONT;
    }

    public String getVL_CONT_APU() {
        return VL_CONT_APU;
    }

    public void setVL_CONT_APU(String VL_CONT_APU) {
        this.VL_CONT_APU = VL_CONT_APU;
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


class RegistroP110 {

    //Texto fixo contendo "P110"
    private String REG;
    /*Informar o número do campo do registro “P100”,objeto de detalhamento neste registro.*/
    private String NUM_CAMPO;
    /*Código do tipo de detalhamento, conforme Tabela 5.1.2*/
    private String COD_DET;
    /*Valor detalhado referente ao campo 02 deste registro*/
    private String DET_VALOR;
    //Informação complementar do detalhamento
    private String INF_COMPL;
    
    private StringBuilder conteudo;

    RegistroP110 registroP110 = new RegistroP110();
    List<RegistroP110> registrosP110 = new ArrayList<RegistroP110>();
    
    protected List<RegistroP110> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP110 = new RegistroP110();
                registroP110.setNUM_CAMPO(RS.getString(""));             
                registroP110.setCOD_DET(RS.getString(""));
                registroP110.setDET_VALOR(RS.getString(""));
                registroP110.setINF_COMPL(RS.getString(""));                               
                                                              
                registrosP110.add(registroP110);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP110;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P110").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_CAMPO(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_DET(),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getDET_VALOR()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getINF_COMPL())).append("|");            
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

    public String getNUM_CAMPO() {
        return NUM_CAMPO;
    }

    public void setNUM_CAMPO(String NUM_CAMPO) {
        this.NUM_CAMPO = NUM_CAMPO;
    }

    public String getCOD_DET() {
        return COD_DET;
    }

    public void setCOD_DET(String COD_DET) {
        this.COD_DET = COD_DET;
    }

    public String getDET_VALOR() {
        return DET_VALOR;
    }

    public void setDET_VALOR(String DET_VALOR) {
        this.DET_VALOR = DET_VALOR;
    }

    public String getINF_COMPL() {
        return INF_COMPL;
    }

    public void setINF_COMPL(String INF_COMPL) {
        this.INF_COMPL = INF_COMPL;
    }
    
}

class RegistroP199 {

    //Texto fixo contendo "P199"
    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    /*Indicador da origem do processo:
    1 - Justiça Federal;
    3 – Secretaria da Receita Federal do Brasil
    9 – Outros.*/
    private String IND_PROC;
    
    private StringBuilder conteudo;

    RegistroP199 registroP199 = new RegistroP199();
    List<RegistroP199> registrosP199 = new ArrayList<RegistroP199>();
    
    protected List<RegistroP199> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP199 = new RegistroP199();
                registroP199.setNUM_PROC(RS.getString(""));             
                registroP199.setIND_PROC(RS.getString(""));                                        
                                                              
                registrosP199.add(registroP199);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP199.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP199;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P199").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(),2)).append("|");            
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

class RegistroP200{
    //Texto fixo contendo "P200"
    private String REG;
    //Período de referencia da escrituração (MMAAAA)
    private String PER_REF;
    //Valor total apurado da Contribuição Previdenciária sobre a Receita Bruta (Somatório do Campo 10 “VL_CONT_APU“, do Registro P100)
    private String VL_TOT_CONT_APU;
    //Valor total de “Ajustes de redução” (Registro P210, Campo 03, quando Campo 02 = “0”)
    private String VL_TOT_AJ_REDUC;
    //Valor total de “Ajustes de acréscimo” (Registro P210, Campo 03, quando Campo 02 = “1”)
    private String VL_TOT_AJ_ACRES;
    //Valor total da Contribuição Previdenciária sobre a Receita Bruta a recolher (Campo 03 – Campo 04 + Campo 05)
    private String VL_TOT_CONT_DEV;
    //Código de Receita referente à Contribuição Previdenciária, conforme informado em DCTF
    private String COD_REC;
    private List<RegistroP210> resgistrosP210 = new ArrayList<RegistroP210>();

    private StringBuilder conteudo;

    RegistroP200 registroP200 = new RegistroP200();
    List<RegistroP200> registrosP200 = new ArrayList<RegistroP200>();
    
    protected List<RegistroP200> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP200 = new RegistroP200();
                registroP200.setPER_REF(RS.getString(""));             
                registroP200.setVL_TOT_CONT_APU(RS.getString(""));                
                registroP200.setVL_TOT_AJ_REDUC(RS.getString(""));
                registroP200.setVL_TOT_AJ_ACRES(RS.getString(""));
                registroP200.setVL_TOT_CONT_DEV(RS.getString(""));
                registroP200.setCOD_REC(RS.getString(""));
                                                              
                registrosP200.add(registroP200);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP200.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP200;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P200").append("|");
            conteudo.append(geral.efdAlfanumerico(getPER_REF(),6)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_TOT_CONT_APU(),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_AJ_REDUC()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_AJ_ACRES()),2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_CONT_DEV()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_REC())).append("|");            
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

    public String getPER_REF() {
        return PER_REF;
    }

    public void setPER_REF(String PER_REF) {
        this.PER_REF = PER_REF;
    }

    public String getVL_TOT_CONT_APU() {
        return VL_TOT_CONT_APU;
    }

    public void setVL_TOT_CONT_APU(String VL_TOT_CONT_APU) {
        this.VL_TOT_CONT_APU = VL_TOT_CONT_APU;
    }

    public String getVL_TOT_AJ_REDUC() {
        return VL_TOT_AJ_REDUC;
    }

    public void setVL_TOT_AJ_REDUC(String VL_TOT_AJ_REDUC) {
        this.VL_TOT_AJ_REDUC = VL_TOT_AJ_REDUC;
    }

    public String getVL_TOT_AJ_ACRES() {
        return VL_TOT_AJ_ACRES;
    }

    public void setVL_TOT_AJ_ACRES(String VL_TOT_AJ_ACRES) {
        this.VL_TOT_AJ_ACRES = VL_TOT_AJ_ACRES;
    }

    public String getVL_TOT_CONT_DEV() {
        return VL_TOT_CONT_DEV;
    }

    public void setVL_TOT_CONT_DEV(String VL_TOT_CONT_DEV) {
        this.VL_TOT_CONT_DEV = VL_TOT_CONT_DEV;
    }

    public String getCOD_REC() {
        return COD_REC;
    }

    public void setCOD_REC(String COD_REC) {
        this.COD_REC = COD_REC;
    }
        
}

class RegistroP210{
    //Texto fixo contendo "P210"
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

    RegistroP210 registroP210 = new RegistroP210();
    List<RegistroP210> registrosP210 = new ArrayList<RegistroP210>();
    
    protected List<RegistroP210> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP210 = new RegistroP210();
                registroP210.setIND_AJ(RS.getString(""));             
                registroP210.setVL_AJ(RS.getString(""));                
                registroP210.setCOD_AJ(RS.getString(""));
                registroP210.setNUM_DOC(RS.getString(""));
                registroP210.setDESCR_AJ(RS.getString(""));
                registroP210.setDT_REF(RS.getString(""));
                                                              
                registrosP210.add(registroP210);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP210.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP210;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P210").append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_AJ(),1)).append("|");            
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_AJ()),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_AJ(),2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC())).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESCR_AJ())).append("|");            
            conteudo.append(geral.efdAlfanumerico(getDT_REF(),8)).append("|");            
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

class RegistroP990{
    //Texto fixo contendo "P990"
    private String REG;
    //Quantidade total de linhas do Bloco P
    private String QTD_LIN_P;
    
    private StringBuilder conteudo;

    RegistroP990 registroP990 = new RegistroP990();
    List<RegistroP990> registrosP990 = new ArrayList<RegistroP990>();
    
    protected List<RegistroP990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroP990 = new RegistroP990();
                registroP990.setQTD_LIN_P(RS.getString(""));                            
                                                              
                registrosP990.add(registroP990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroP990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosP990;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|P990").append("|");
            conteudo.append(geral.efdAlfanumerico(getQTD_LIN_P(),1)).append("|");                       
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

    public String getQTD_LIN_P() {
        return QTD_LIN_P;
    }

    public void setQTD_LIN_P(String QTD_LIN_P) {
        this.QTD_LIN_P = QTD_LIN_P;
    }
    
}
