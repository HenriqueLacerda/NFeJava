/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped;

import crncomp.geral;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev - Breno
 */
class BlocoE {

    private RegistroE001 registroE001 = new RegistroE001();
    private List<RegistroE100> registrosE100 = new ArrayList<RegistroE100>();
    private List<RegistroE200> registrosE200 = new ArrayList<RegistroE200>();
    private List<RegistroE500> registrosE500 = new ArrayList<RegistroE500>();
    private RegistroE990 registroE990 = new RegistroE990();
}

class RegistroE001 {

    private String REG;
    private String IND_MOV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E001").append("|");
            conteudo.append(IND_MOV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE100.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroE100 {

    private String REG;
    private String DT_INI;
    private String DT_FIN;
    private RegistroE110 registroE110 = new RegistroE110();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E100").append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIN)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE100.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDT_FIN() {
        return DT_FIN;
    }

    public void setDT_FIN(String DT_FIN) {
        this.DT_FIN = DT_FIN;
    }

    public String getDT_INI() {
        return DT_INI;
    }

    public void setDT_INI(String DT_INI) {
        this.DT_INI = DT_INI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroE110 {

    private String REG;
    private String VL_TOT_DEBITOS;
    private String VL_AJ_DEBITOS;
    private String VL_TOT_AJ_DEBITOS;
    private String VL_ESTORNOS_CRED;
    private String VL_TOT_CREDITOS;
    private String VL_AJ_CREDITOS;
    private String VL_TOT_AJ_CREDITOS;
    private String VL_ESTORNOS_DEB;
    private String VL_SLD_CREDOR_ANT;
    private String VL_SLD_APURADO;
    private String VL_TOT_DED;
    private String VL_ICMS_RECOLHER;
    private String VL_SLD_CREDOR;
    private String DEB_ESP;
    private List<RegistroE111> registroE111 = new ArrayList<RegistroE111>();
    private List<RegistroE115> registroE115 = new ArrayList<RegistroE115>();
    private List<RegistroE116> registroE116 = new ArrayList<RegistroE116>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E110").append("|");
            conteudo.append(VL_TOT_DEBITOS).append("|");
            conteudo.append(VL_AJ_DEBITOS).append("|");
            conteudo.append(VL_TOT_AJ_DEBITOS).append("|");
            conteudo.append(VL_ESTORNOS_CRED).append("|");
            conteudo.append(VL_TOT_CREDITOS).append("|");
            conteudo.append(VL_AJ_CREDITOS).append("|");
            conteudo.append(VL_TOT_AJ_CREDITOS).append("|");
            conteudo.append(VL_ESTORNOS_DEB).append("|");
            conteudo.append(VL_SLD_CREDOR_ANT).append("|");
            conteudo.append(VL_SLD_APURADO).append("|");
            conteudo.append(VL_TOT_DED).append("|");
            conteudo.append(VL_ICMS_RECOLHER).append("|");
            conteudo.append(VL_SLD_CREDOR).append("|");
            conteudo.append(DEB_ESP).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE110.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDEB_ESP() {
        return DEB_ESP;
    }

    public void setDEB_ESP(String DEB_ESP) {
        this.DEB_ESP = DEB_ESP;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_AJ_CREDITOS() {
        return VL_AJ_CREDITOS;
    }

    public void setVL_AJ_CREDITOS(String VL_AJ_CREDITOS) {
        this.VL_AJ_CREDITOS = VL_AJ_CREDITOS;
    }

    public String getVL_AJ_DEBITOS() {
        return VL_AJ_DEBITOS;
    }

    public void setVL_AJ_DEBITOS(String VL_AJ_DEBITOS) {
        this.VL_AJ_DEBITOS = VL_AJ_DEBITOS;
    }

    public String getVL_ESTORNOS_CRED() {
        return VL_ESTORNOS_CRED;
    }

    public void setVL_ESTORNOS_CRED(String VL_ESTORNOS_CRED) {
        this.VL_ESTORNOS_CRED = VL_ESTORNOS_CRED;
    }

    public String getVL_ESTORNOS_DEB() {
        return VL_ESTORNOS_DEB;
    }

    public void setVL_ESTORNOS_DEB(String VL_ESTORNOS_DEB) {
        this.VL_ESTORNOS_DEB = VL_ESTORNOS_DEB;
    }

    public String getVL_ICMS_RECOLHER() {
        return VL_ICMS_RECOLHER;
    }

    public void setVL_ICMS_RECOLHER(String VL_ICMS_RECOLHER) {
        this.VL_ICMS_RECOLHER = VL_ICMS_RECOLHER;
    }

    public String getVL_SLD_APURADO() {
        return VL_SLD_APURADO;
    }

    public void setVL_SLD_APURADO(String VL_SLD_APURADO) {
        this.VL_SLD_APURADO = VL_SLD_APURADO;
    }

    public String getVL_SLD_CREDOR() {
        return VL_SLD_CREDOR;
    }

    public void setVL_SLD_CREDOR(String VL_SLD_CREDOR) {
        this.VL_SLD_CREDOR = VL_SLD_CREDOR;
    }

    public String getVL_SLD_CREDOR_ANT() {
        return VL_SLD_CREDOR_ANT;
    }

    public void setVL_SLD_CREDOR_ANT(String VL_SLD_CREDOR_ANT) {
        this.VL_SLD_CREDOR_ANT = VL_SLD_CREDOR_ANT;
    }

    public String getVL_TOT_AJ_CREDITOS() {
        return VL_TOT_AJ_CREDITOS;
    }

    public void setVL_TOT_AJ_CREDITOS(String VL_TOT_AJ_CREDITOS) {
        this.VL_TOT_AJ_CREDITOS = VL_TOT_AJ_CREDITOS;
    }

    public String getVL_TOT_AJ_DEBITOS() {
        return VL_TOT_AJ_DEBITOS;
    }

    public void setVL_TOT_AJ_DEBITOS(String VL_TOT_AJ_DEBITOS) {
        this.VL_TOT_AJ_DEBITOS = VL_TOT_AJ_DEBITOS;
    }

    public String getVL_TOT_CREDITOS() {
        return VL_TOT_CREDITOS;
    }

    public void setVL_TOT_CREDITOS(String VL_TOT_CREDITOS) {
        this.VL_TOT_CREDITOS = VL_TOT_CREDITOS;
    }

    public String getVL_TOT_DEBITOS() {
        return VL_TOT_DEBITOS;
    }

    public void setVL_TOT_DEBITOS(String VL_TOT_DEBITOS) {
        this.VL_TOT_DEBITOS = VL_TOT_DEBITOS;
    }

    public String getVL_TOT_DED() {
        return VL_TOT_DED;
    }

    public void setVL_TOT_DED(String VL_TOT_DED) {
        this.VL_TOT_DED = VL_TOT_DED;
    }
}

class RegistroE111 {

    private String REG;
    private String COD_AJ_APUR;
    private String DESCR_COMPL_AJ;
    private String VL_AJ_APUR;
    private List<RegistroE112> registroE112 = new ArrayList<RegistroE112>();
    private List<RegistroE113> registroE113 = new ArrayList<RegistroE113>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E111").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_AJ_APUR, 8)).append("|");
            conteudo.append(DESCR_COMPL_AJ).append("|");
            conteudo.append(VL_AJ_APUR).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE111.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_AJ_APUR() {
        return COD_AJ_APUR;
    }

    public void setCOD_AJ_APUR(String COD_AJ_APUR) {
        this.COD_AJ_APUR = COD_AJ_APUR;
    }

    public String getDESCR_COMPL_AJ() {
        return DESCR_COMPL_AJ;
    }

    public void setDESCR_COMPL_AJ(String DESCR_COMPL_AJ) {
        this.DESCR_COMPL_AJ = DESCR_COMPL_AJ;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_AJ_APUR() {
        return VL_AJ_APUR;
    }

    public void setVL_AJ_APUR(String VL_AJ_APUR) {
        this.VL_AJ_APUR = VL_AJ_APUR;
    }
}

class RegistroE112 {

    private String REG;
    private String NUM_DA;
    private String NUM_PROC;
    private String IND_PROC;
    private String PROC;
    private String TXT_COMPL;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E112").append("|");
            conteudo.append(NUM_DA).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_PROC, 15)).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_PROC, 1)).append("|");
            conteudo.append(PROC).append("|");
            conteudo.append(TXT_COMPL).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE112.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }

    public String getNUM_DA() {
        return NUM_DA;
    }

    public void setNUM_DA(String NUM_DA) {
        this.NUM_DA = NUM_DA;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getPROC() {
        return PROC;
    }

    public void setPROC(String PROC) {
        this.PROC = PROC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTXT_COMPL() {
        return TXT_COMPL;
    }

    public void setTXT_COMPL(String TXT_COMPL) {
        this.TXT_COMPL = TXT_COMPL;
    }
}

class RegistroE113 {

    private String REG;
    private String COD_PART;
    private String COD_MOD;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String DT_DOC;
    private String COD_ITEM;
    private String VL_AJ_ITEM;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E112").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(VL_AJ_ITEM).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE112.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
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

    public String getVL_AJ_ITEM() {
        return VL_AJ_ITEM;
    }

    public void setVL_AJ_ITEM(String VL_AJ_ITEM) {
        this.VL_AJ_ITEM = VL_AJ_ITEM;
    }
}

class RegistroE115 {

    private String REG;
    private String COD_INF_ADIC;
    private String VL_INF_ADIC;
    private String DESCR_COMPL_AJ;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E115").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_INF_ADIC, 8)).append("|");
            conteudo.append(VL_INF_ADIC).append("|");
            conteudo.append(DESCR_COMPL_AJ).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE115.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_INF_ADIC() {
        return COD_INF_ADIC;
    }

    public void setCOD_INF_ADIC(String COD_INF_ADIC) {
        this.COD_INF_ADIC = COD_INF_ADIC;
    }

    public String getDESCR_COMPL_AJ() {
        return DESCR_COMPL_AJ;
    }

    public void setDESCR_COMPL_AJ(String DESCR_COMPL_AJ) {
        this.DESCR_COMPL_AJ = DESCR_COMPL_AJ;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_INF_ADIC() {
        return VL_INF_ADIC;
    }

    public void setVL_INF_ADIC(String VL_INF_ADIC) {
        this.VL_INF_ADIC = VL_INF_ADIC;
    }
}

class RegistroE116 {

    private String REG;
    private String COD_OR;
    private String VL_OR;
    private String DT_VCTO;
    private String COD_REC;
    private String NUM_PROC;
    private String IND_PROC;
    private String PROC;
    private String TXT_COMPL;
    private String MES_REF;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E116").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OR, 3)).append("|");
            conteudo.append(VL_OR).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_VCTO)).append("|");
            conteudo.append(COD_REC).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_PROC, 15)).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_PROC, 1)).append("|");
            conteudo.append(PROC).append("|");
            conteudo.append(TXT_COMPL).append("|");
            conteudo.append(geral.efdAlfanumerico(MES_REF, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE116.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_REC() {
        return COD_REC;
    }

    public void setCOD_REC(String COD_REC) {
        this.COD_REC = COD_REC;
    }

    public String getCOD_OR() {
        return COD_OR;
    }

    public void setCOD_OR(String COD_OR) {
        this.COD_OR = COD_OR;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }

    public String getMES_REF() {
        return MES_REF;
    }

    public void setMES_REF(String MES_REF) {
        this.MES_REF = MES_REF;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getPROC() {
        return PROC;
    }

    public void setPROC(String PROC) {
        this.PROC = PROC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTXT_COMPL() {
        return TXT_COMPL;
    }

    public void setTXT_COMPL(String TXT_COMPL) {
        this.TXT_COMPL = TXT_COMPL;
    }

    public String getVL_OR() {
        return VL_OR;
    }

    public void setVL_OR(String VL_OR) {
        this.VL_OR = VL_OR;
    }
}

class RegistroE200 {

    private String REG;
    private String UF;
    private String DT_INI;
    private String DT_FIN;
    private RegistroE210 registroE120 = new RegistroE210();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E200").append("|");
            conteudo.append(geral.efdAlfanumerico(UF, 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIN)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE200.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDT_FIN() {
        return DT_FIN;
    }

    public void setDT_FIN(String DT_FIN) {
        this.DT_FIN = DT_FIN;
    }

    public String getDT_INI() {
        return DT_INI;
    }

    public void setDT_INI(String DT_INI) {
        this.DT_INI = DT_INI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}

class RegistroE210 {

    private String REG;
    private String IND_MOV_ST;
    private String VL_SLD_CRED_ANT_ST;
    private String VL_DEVOL_ST;
    private String VL_RESSARC_ST;
    private String VL_OUT_CRED_ST;
    private String VL_AJ_CREDITOS_ST;
    private String VL_RETENCAO_ST;
    private String VL_OUT_DEB_ST;
    private String VL_AJ_DEBITOS_ST;
    private String VL_SLD_DEV_ANT_ST;
    private String VL_DEDUCOES_ST;
    private String VL_ICMS_RECOL_ST;
    private String VL_SLD_CRED_ST_TRANSPORTAR;
    private String DEB_ESP_ST;
    private List<RegistroE220> registroE220 = new ArrayList<RegistroE220>();
    private List<RegistroE250> registroE250 = new ArrayList<RegistroE250>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E200").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_MOV_ST, 1)).append("|");
            conteudo.append(VL_SLD_CRED_ANT_ST).append("|");
            conteudo.append(VL_DEVOL_ST).append("|");
            conteudo.append(VL_RESSARC_ST).append("|");
            conteudo.append(VL_OUT_CRED_ST).append("|");
            conteudo.append(VL_AJ_CREDITOS_ST).append("|");
            conteudo.append(VL_RETENCAO_ST).append("|");
            conteudo.append(VL_OUT_DEB_ST).append("|");
            conteudo.append(VL_AJ_DEBITOS_ST).append("|");
            conteudo.append(VL_SLD_DEV_ANT_ST).append("|");
            conteudo.append(VL_DEDUCOES_ST).append("|");
            conteudo.append(VL_ICMS_RECOL_ST).append("|");
            conteudo.append(VL_SLD_CRED_ST_TRANSPORTAR).append("|");
            conteudo.append(DEB_ESP_ST).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE200.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDEB_ESP_ST() {
        return DEB_ESP_ST;
    }

    public void setDEB_ESP_ST(String DEB_ESP_ST) {
        this.DEB_ESP_ST = DEB_ESP_ST;
    }

    public String getIND_MOV_ST() {
        return IND_MOV_ST;
    }

    public void setIND_MOV_ST(String IND_MOV_ST) {
        this.IND_MOV_ST = IND_MOV_ST;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_AJ_CREDITOS_ST() {
        return VL_AJ_CREDITOS_ST;
    }

    public void setVL_AJ_CREDITOS_ST(String VL_AJ_CREDITOS_ST) {
        this.VL_AJ_CREDITOS_ST = VL_AJ_CREDITOS_ST;
    }

    public String getVL_DEDUCOES_ST() {
        return VL_DEDUCOES_ST;
    }

    public void setVL_DEDUCOES_ST(String VL_DEDUCOES_ST) {
        this.VL_DEDUCOES_ST = VL_DEDUCOES_ST;
    }

    public String getVL_DEVOL_ST() {
        return VL_DEVOL_ST;
    }

    public void setVL_DEVOL_ST(String VL_DEVOL_ST) {
        this.VL_DEVOL_ST = VL_DEVOL_ST;
    }

    public String getVL_ICMS_RECOL_ST() {
        return VL_ICMS_RECOL_ST;
    }

    public void setVL_ICMS_RECOL_ST(String VL_ICMS_RECOL_ST) {
        this.VL_ICMS_RECOL_ST = VL_ICMS_RECOL_ST;
    }

    public String getVL_OUT_CRED_ST() {
        return VL_OUT_CRED_ST;
    }

    public void setVL_OUT_CRED_ST(String VL_OUT_CRED_ST) {
        this.VL_OUT_CRED_ST = VL_OUT_CRED_ST;
    }

    public String getVL_OUT_DEB_ST() {
        return VL_OUT_DEB_ST;
    }

    public void setVL_OUT_DEB_ST(String VL_OUT_DEB_ST) {
        this.VL_OUT_DEB_ST = VL_OUT_DEB_ST;
    }

    public String getVL_RESSARC_ST() {
        return VL_RESSARC_ST;
    }

    public void setVL_RESSARC_ST(String VL_RESSARC_ST) {
        this.VL_RESSARC_ST = VL_RESSARC_ST;
    }

    public String getVL_RETENCAO_ST() {
        return VL_RETENCAO_ST;
    }

    public void setVL_RETENCAO_ST(String VL_RETENCAO_ST) {
        this.VL_RETENCAO_ST = VL_RETENCAO_ST;
    }

    public String getVL_SLD_CRED_ANT_ST() {
        return VL_SLD_CRED_ANT_ST;
    }

    public void setVL_SLD_CRED_ANT_ST(String VL_SLD_CRED_ANT_ST) {
        this.VL_SLD_CRED_ANT_ST = VL_SLD_CRED_ANT_ST;
    }

    public String getVL_SLD_CRED_ST_TRANSPORTAR() {
        return VL_SLD_CRED_ST_TRANSPORTAR;
    }

    public void setVL_SLD_CRED_ST_TRANSPORTAR(String VL_SLD_CRED_ST_TRANSPORTAR) {
        this.VL_SLD_CRED_ST_TRANSPORTAR = VL_SLD_CRED_ST_TRANSPORTAR;
    }

    public String getVL_SLD_DEV_ANT_ST() {
        return VL_SLD_DEV_ANT_ST;
    }

    public void setVL_SLD_DEV_ANT_ST(String VL_SLD_DEV_ANT_ST) {
        this.VL_SLD_DEV_ANT_ST = VL_SLD_DEV_ANT_ST;
    }
}

class RegistroE220 {

    private String REG;
    private String COD_AJ_APUR;
    private String DESCR_COMPL_AJ;
    private String VL_AJ_APUR;
    private List<RegistroE230> registroE230 = new ArrayList<RegistroE230>();
    private List<RegistroE240> registroE240 = new ArrayList<RegistroE240>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E220").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_AJ_APUR, 8)).append("|");
            conteudo.append(DESCR_COMPL_AJ).append("|");
            conteudo.append(VL_AJ_APUR).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE220.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_AJ_APUR() {
        return COD_AJ_APUR;
    }

    public void setCOD_AJ_APUR(String COD_AJ_APUR) {
        this.COD_AJ_APUR = COD_AJ_APUR;
    }

    public String getDESCR_COMPL_AJ() {
        return DESCR_COMPL_AJ;
    }

    public void setDESCR_COMPL_AJ(String DESCR_COMPL_AJ) {
        this.DESCR_COMPL_AJ = DESCR_COMPL_AJ;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_AJ_APUR() {
        return VL_AJ_APUR;
    }

    public void setVL_AJ_APUR(String VL_AJ_APUR) {
        this.VL_AJ_APUR = VL_AJ_APUR;
    }
}

class RegistroE230 {

    private String REG;
    private String NUM_DA;
    private String NUM_PROC;
    private String IND_PROC;
    private String PROC;
    private String TXT_COMPL;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E230").append("|");
            conteudo.append(NUM_DA).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_PROC, 15)).append("|");
            conteudo.append(IND_PROC).append("|");
            conteudo.append(PROC).append("|");
            conteudo.append(TXT_COMPL).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE230.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }

    public String getNUM_DA() {
        return NUM_DA;
    }

    public void setNUM_DA(String NUM_DA) {
        this.NUM_DA = NUM_DA;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getPROC() {
        return PROC;
    }

    public void setPROC(String PROC) {
        this.PROC = PROC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTXT_COMPL() {
        return TXT_COMPL;
    }

    public void setTXT_COMPL(String TXT_COMPL) {
        this.TXT_COMPL = TXT_COMPL;
    }
}

class RegistroE240 {

    private String REG;
    private String COD_PART;
    private String COD_MOD;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String DT_DOC;
    private String COD_ITEM;
    private String VL_AJ_ITEM;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E240").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(VL_AJ_ITEM).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE240.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
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

    public String getVL_AJ_ITEM() {
        return VL_AJ_ITEM;
    }

    public void setVL_AJ_ITEM(String VL_AJ_ITEM) {
        this.VL_AJ_ITEM = VL_AJ_ITEM;
    }
}

class RegistroE250 {

    private String REG;
    private String COD_OR;
    private String VL_OR;
    private String DT_VCTO;
    private String COD_REC;
    private String NUM_PROC;
    private String IND_PROC;
    private String PROC;
    private String TXT_COMPL;
    private String MES_REF;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E250").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OR, 3)).append("|");
            conteudo.append(VL_OR).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_VCTO)).append("|");
            conteudo.append(COD_REC).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_PROC, 15)).append("|");
            conteudo.append(IND_PROC).append("|");
            conteudo.append(PROC).append("|");
            conteudo.append(TXT_COMPL).append("|");
            conteudo.append(geral.efdAlfanumerico(MES_REF, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE250.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_OR() {
        return COD_OR;
    }

    public void setCOD_OR(String COD_OR) {
        this.COD_OR = COD_OR;
    }

    public String getCOD_REC() {
        return COD_REC;
    }

    public void setCOD_REC(String COD_REC) {
        this.COD_REC = COD_REC;
    }

    public String getDT_VCTO() {
        return DT_VCTO;
    }

    public void setDT_VCTO(String DT_VCTO) {
        this.DT_VCTO = DT_VCTO;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }

    public String getMES_REF() {
        return MES_REF;
    }

    public void setMES_REF(String MES_REF) {
        this.MES_REF = MES_REF;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getPROC() {
        return PROC;
    }

    public void setPROC(String PROC) {
        this.PROC = PROC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTXT_COMPL() {
        return TXT_COMPL;
    }

    public void setTXT_COMPL(String TXT_COMPL) {
        this.TXT_COMPL = TXT_COMPL;
    }

    public String getVL_OR() {
        return VL_OR;
    }

    public void setVL_OR(String VL_OR) {
        this.VL_OR = VL_OR;
    }
}

class RegistroE500 {

    private String REG;
    private String IND_APUR;
    private String DT_INI;
    private String DT_FIN;
    private List<RegistroE510> registroE510 = new ArrayList<RegistroE510>();
    private List<RegistroE520> registroE520 = new ArrayList<RegistroE520>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E500").append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIN)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE500.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDT_FIN() {
        return DT_FIN;
    }

    public void setDT_FIN(String DT_FIN) {
        this.DT_FIN = DT_FIN;
    }

    public String getDT_INI() {
        return DT_INI;
    }

    public void setDT_INI(String DT_INI) {
        this.DT_INI = DT_INI;
    }

    public String getIND_APUR() {
        return IND_APUR;
    }

    public void setIND_APUR(String IND_APUR) {
        this.IND_APUR = IND_APUR;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroE510 {

    private String REG;
    private String CFOP;
    private String CST_IPI;
    private String VL_CONT_IPI;
    private String VL_BC_IPI;
    private String VL_IPI;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E510").append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(CST_IPI, 2)).append("|");
            conteudo.append(VL_CONT_IPI).append("|");
            conteudo.append(VL_BC_IPI).append("|");
            conteudo.append(VL_IPI).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE510.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCST_IPI() {
        return CST_IPI;
    }

    public void setCST_IPI(String CST_IPI) {
        this.CST_IPI = CST_IPI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_BC_IPI() {
        return VL_BC_IPI;
    }

    public void setVL_BC_IPI(String VL_BC_IPI) {
        this.VL_BC_IPI = VL_BC_IPI;
    }

    public String getVL_CONT_IPI() {
        return VL_CONT_IPI;
    }

    public void setVL_CONT_IPI(String VL_CONT_IPI) {
        this.VL_CONT_IPI = VL_CONT_IPI;
    }

    public String getVL_IPI() {
        return VL_IPI;
    }

    public void setVL_IPI(String VL_IPI) {
        this.VL_IPI = VL_IPI;
    }
}

class RegistroE520 {

    private String REG;
    private String VL_SD_ANT_IPI;
    private String VL_DEB_IPI;
    private String VL_CRED_IPI;
    private String VL_OD_IPI;
    private String VL_OC_IPI;
    private String VL_SC_IPI;
    private String VL_SD_IPI;
    private List<RegistroE530> registroE530 = new ArrayList<RegistroE530>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E520").append("|");
            conteudo.append(VL_SD_ANT_IPI).append("|");
            conteudo.append(VL_DEB_IPI).append("|");
            conteudo.append(VL_CRED_IPI).append("|");
            conteudo.append(VL_OD_IPI).append("|");
            conteudo.append(VL_OC_IPI).append("|");
            conteudo.append(VL_SC_IPI).append("|");
            conteudo.append(VL_SD_IPI).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE520.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_CRED_IPI() {
        return VL_CRED_IPI;
    }

    public void setVL_CRED_IPI(String VL_CRED_IPI) {
        this.VL_CRED_IPI = VL_CRED_IPI;
    }

    public String getVL_DEB_IPI() {
        return VL_DEB_IPI;
    }

    public void setVL_DEB_IPI(String VL_DEB_IPI) {
        this.VL_DEB_IPI = VL_DEB_IPI;
    }

    public String getVL_OC_IPI() {
        return VL_OC_IPI;
    }

    public void setVL_OC_IPI(String VL_OC_IPI) {
        this.VL_OC_IPI = VL_OC_IPI;
    }

    public String getVL_OD_IPI() {
        return VL_OD_IPI;
    }

    public void setVL_OD_IPI(String VL_OD_IPI) {
        this.VL_OD_IPI = VL_OD_IPI;
    }

    public String getVL_SC_IPI() {
        return VL_SC_IPI;
    }

    public void setVL_SC_IPI(String VL_SC_IPI) {
        this.VL_SC_IPI = VL_SC_IPI;
    }

    public String getVL_SD_ANT_IPI() {
        return VL_SD_ANT_IPI;
    }

    public void setVL_SD_ANT_IPI(String VL_SD_ANT_IPI) {
        this.VL_SD_ANT_IPI = VL_SD_ANT_IPI;
    }

    public String getVL_SD_IPI() {
        return VL_SD_IPI;
    }

    public void setVL_SD_IPI(String VL_SD_IPI) {
        this.VL_SD_IPI = VL_SD_IPI;
    }
}

class RegistroE530 {

    private String REG;
    private String IND_AJ;
    private String VL_AJ;
    private String COD_AJ;
    private String IND_DOC;
    private String NUM_DOC;
    private String DESCR_AJ;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E530").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_AJ, 1)).append("|");
            conteudo.append(VL_AJ).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_AJ, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_DOC, 1)).append("|");
            conteudo.append(NUM_DOC).append("|");
            conteudo.append(DESCR_AJ).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE530.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_AJ() {
        return COD_AJ;
    }

    public void setCOD_AJ(String COD_AJ) {
        this.COD_AJ = COD_AJ;
    }

    public String getDESCR_AJ() {
        return DESCR_AJ;
    }

    public void setDESCR_AJ(String DESCR_AJ) {
        this.DESCR_AJ = DESCR_AJ;
    }

    public String getIND_AJ() {
        return IND_AJ;
    }

    public void setIND_AJ(String IND_AJ) {
        this.IND_AJ = IND_AJ;
    }

    public String getIND_DOC() {
        return IND_DOC;
    }

    public void setIND_DOC(String IND_DOC) {
        this.IND_DOC = IND_DOC;
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

    public String getVL_AJ() {
        return VL_AJ;
    }

    public void setVL_AJ(String VL_AJ) {
        this.VL_AJ = VL_AJ;
    }
}

class RegistroE990 {

    private String REG;
    private String QTD_LIN_E;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|E990").append("|");
            conteudo.append(QTD_LIN_E).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroE990.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getQTD_LIN_E() {
        return QTD_LIN_E;
    }

    public void setQTD_LIN_E(String QTD_LIN_E) {
        this.QTD_LIN_E = QTD_LIN_E;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}
