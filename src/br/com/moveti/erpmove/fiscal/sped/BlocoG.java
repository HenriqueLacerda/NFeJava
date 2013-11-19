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
public class BlocoG {

    private RegistroG001 registroG001 = new RegistroG001();
    private List<RegistroG110> registrosG110 = new ArrayList<RegistroG110>();
    private RegistroG990 registroG990 = new RegistroG990();
}

class RegistroG001 {

    private String REG;
    private String IND_MOV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G001").append("|");
            conteudo.append(IND_MOV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG001.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroG110 {

    private String REG;
    private String DT_INI;
    private String DT_FIN;
    private String SALDO_IN_ICMS;
    private String SOM_PARC;
    private String VL_TRIB_EXP;
    private String VL_TOTAL;
    private String IND_PER_SAI;
    private String ICMS_APROP;
    private String SOM_ICMS_OC;
    private List<RegistroG125> registrosG125 = new ArrayList<RegistroG125>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G110").append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIN)).append("|");
            conteudo.append(SALDO_IN_ICMS).append("|");
            conteudo.append(SOM_PARC).append("|");
            conteudo.append(VL_TRIB_EXP).append("|");
            conteudo.append(VL_TOTAL).append("|");
            conteudo.append(IND_PER_SAI).append("|");
            conteudo.append(ICMS_APROP).append("|");
            conteudo.append(SOM_ICMS_OC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG110.class.getName()).log(Level.SEVERE, null, e);
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

    public String getICMS_APROP() {
        return ICMS_APROP;
    }

    public void setICMS_APROP(String ICMS_APROP) {
        this.ICMS_APROP = ICMS_APROP;
    }

    public String getIND_PER_SAI() {
        return IND_PER_SAI;
    }

    public void setIND_PER_SAI(String IND_PER_SAI) {
        this.IND_PER_SAI = IND_PER_SAI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getSALDO_IN_ICMS() {
        return SALDO_IN_ICMS;
    }

    public void setSALDO_IN_ICMS(String SALDO_IN_ICMS) {
        this.SALDO_IN_ICMS = SALDO_IN_ICMS;
    }

    public String getSOM_ICMS_OC() {
        return SOM_ICMS_OC;
    }

    public void setSOM_ICMS_OC(String SOM_ICMS_OC) {
        this.SOM_ICMS_OC = SOM_ICMS_OC;
    }

    public String getSOM_PARC() {
        return SOM_PARC;
    }

    public void setSOM_PARC(String SOM_PARC) {
        this.SOM_PARC = SOM_PARC;
    }

    public String getVL_TOTAL() {
        return VL_TOTAL;
    }

    public void setVL_TOTAL(String VL_TOTAL) {
        this.VL_TOTAL = VL_TOTAL;
    }

    public String getVL_TRIB_EXP() {
        return VL_TRIB_EXP;
    }

    public void setVL_TRIB_EXP(String VL_TRIB_EXP) {
        this.VL_TRIB_EXP = VL_TRIB_EXP;
    }
}

class RegistroG125 {

    private String REG;
    private String COD_IND_BEM;
    private String DT_MOV;
    private String TIPO_MOV;
    private String VL_IMOB_ICMS_OP;
    private String VL_IMOB_ICMS_ST;
    private String VL_IMOB_ICMS_FRT;
    private String VL_IMOB_ICMS_DIF;
    private String NUM_PARC;
    private String VL_PARC_PASS;
    private List<RegistroG126> registrosG126 = new ArrayList<RegistroG126>();
    private List<RegistroG130> registrosG120 = new ArrayList<RegistroG130>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G110").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_IND_BEM, 60)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_MOV)).append("|");
            conteudo.append(geral.efdAlfanumerico(TIPO_MOV, 2)).append("|");
            conteudo.append(VL_IMOB_ICMS_OP).append("|");
            conteudo.append(VL_IMOB_ICMS_ST).append("|");
            conteudo.append(VL_IMOB_ICMS_FRT).append("|");
            conteudo.append(VL_IMOB_ICMS_DIF).append("|");
            conteudo.append(NUM_PARC).append("|");
            conteudo.append(VL_PARC_PASS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG110.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_IND_BEM() {
        return COD_IND_BEM;
    }

    public void setCOD_IND_BEM(String COD_IND_BEM) {
        this.COD_IND_BEM = COD_IND_BEM;
    }

    public String getDT_MOV() {
        return DT_MOV;
    }

    public void setDT_MOV(String DT_MOV) {
        this.DT_MOV = DT_MOV;
    }

    public String getNUM_PARC() {
        return NUM_PARC;
    }

    public void setNUM_PARC(String NUM_PARC) {
        this.NUM_PARC = NUM_PARC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTIPO_MOV() {
        return TIPO_MOV;
    }

    public void setTIPO_MOV(String TIPO_MOV) {
        this.TIPO_MOV = TIPO_MOV;
    }

    public String getVL_IMOB_ICMS_DIF() {
        return VL_IMOB_ICMS_DIF;
    }

    public void setVL_IMOB_ICMS_DIF(String VL_IMOB_ICMS_DIF) {
        this.VL_IMOB_ICMS_DIF = VL_IMOB_ICMS_DIF;
    }

    public String getVL_IMOB_ICMS_FRT() {
        return VL_IMOB_ICMS_FRT;
    }

    public void setVL_IMOB_ICMS_FRT(String VL_IMOB_ICMS_FRT) {
        this.VL_IMOB_ICMS_FRT = VL_IMOB_ICMS_FRT;
    }

    public String getVL_IMOB_ICMS_OP() {
        return VL_IMOB_ICMS_OP;
    }

    public void setVL_IMOB_ICMS_OP(String VL_IMOB_ICMS_OP) {
        this.VL_IMOB_ICMS_OP = VL_IMOB_ICMS_OP;
    }

    public String getVL_IMOB_ICMS_ST() {
        return VL_IMOB_ICMS_ST;
    }

    public void setVL_IMOB_ICMS_ST(String VL_IMOB_ICMS_ST) {
        this.VL_IMOB_ICMS_ST = VL_IMOB_ICMS_ST;
    }

    public String getVL_PARC_PASS() {
        return VL_PARC_PASS;
    }

    public void setVL_PARC_PASS(String VL_PARC_PASS) {
        this.VL_PARC_PASS = VL_PARC_PASS;
    }
}

class RegistroG126 {

    private String REG;
    private String DT_INI;
    private String DT_FIM;
    private String NUM_PARC;
    private String VL_PARC_PASS;
    private String VL_TRIB_OC;
    private String VL_TOTAL;
    private String IND_PER_SAI;
    private String VL_PARC_APROP;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G126").append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIM)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_PARC, 3)).append("|");
            conteudo.append(VL_PARC_PASS).append("|");
            conteudo.append(VL_TRIB_OC).append("|");
            conteudo.append(VL_TOTAL).append("|");
            conteudo.append(IND_PER_SAI).append("|");
            conteudo.append(VL_PARC_APROP).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG126.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDT_FIM() {
        return DT_FIM;
    }

    public void setDT_FIM(String DT_FIM) {
        this.DT_FIM = DT_FIM;
    }

    public String getDT_INI() {
        return DT_INI;
    }

    public void setDT_INI(String DT_INI) {
        this.DT_INI = DT_INI;
    }

    public String getIND_PER_SAI() {
        return IND_PER_SAI;
    }

    public void setIND_PER_SAI(String IND_PER_SAI) {
        this.IND_PER_SAI = IND_PER_SAI;
    }

    public String getNUM_PARC() {
        return NUM_PARC;
    }

    public void setNUM_PARC(String NUM_PARC) {
        this.NUM_PARC = NUM_PARC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_PARC_APROP() {
        return VL_PARC_APROP;
    }

    public void setVL_PARC_APROP(String VL_PARC_APROP) {
        this.VL_PARC_APROP = VL_PARC_APROP;
    }

    public String getVL_PARC_PASS() {
        return VL_PARC_PASS;
    }

    public void setVL_PARC_PASS(String VL_PARC_PASS) {
        this.VL_PARC_PASS = VL_PARC_PASS;
    }

    public String getVL_TOTAL() {
        return VL_TOTAL;
    }

    public void setVL_TOTAL(String VL_TOTAL) {
        this.VL_TOTAL = VL_TOTAL;
    }

    public String getVL_TRIB_OC() {
        return VL_TRIB_OC;
    }

    public void setVL_TRIB_OC(String VL_TRIB_OC) {
        this.VL_TRIB_OC = VL_TRIB_OC;
    }
}

class RegistroG130 {

    private String REG;
    private String IND_EMIT;
    private String COD_PART;
    private String COD_MOD;
    private String SERIE;
    private String NUM_DOC;
    private String CHV_NFE_CTE;
    private String DT_DOC;
    private List<RegistroG140> registrosG140 = new ArrayList<RegistroG140>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G130").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_EMIT, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SERIE, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(CHV_NFE_CTE, 44)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG130.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCHV_NFE_CTE() {
        return CHV_NFE_CTE;
    }

    public void setCHV_NFE_CTE(String CHV_NFE_CTE) {
        this.CHV_NFE_CTE = CHV_NFE_CTE;
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

    public String getIND_EMIT() {
        return IND_EMIT;
    }

    public void setIND_EMIT(String IND_EMIT) {
        this.IND_EMIT = IND_EMIT;
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

    public String getSERIE() {
        return SERIE;
    }

    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }
}

class RegistroG140 {

    private String REG;
    private String NUM_ITEM;
    private String COD_ITEM;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G140").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_ITEM, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG140.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getNUM_ITEM() {
        return NUM_ITEM;
    }

    public void setNUM_ITEM(String NUM_ITEM) {
        this.NUM_ITEM = NUM_ITEM;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroG990 {

    private String REG;
    private String QTD_LIN_G;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|G990").append("|");
            conteudo.append(QTD_LIN_G).append("|");
            conteudo.append(QTD_LIN_G).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroG990.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getQTD_LIN_G() {
        return QTD_LIN_G;
    }

    public void setQTD_LIN_G(String QTD_LIN_G) {
        this.QTD_LIN_G = QTD_LIN_G;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}