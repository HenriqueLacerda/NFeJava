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
class BlocoD {

    private RegistroD001 registroD001 = new RegistroD001();
    private List<RegistroD100> registroD100 = new ArrayList<RegistroD100>();
//    private List<RegistroD300> registroD300 = new ArrayList<RegistroD300>();
    private List<RegistroD400> registroD400 = new ArrayList<RegistroD400>();
    private List<RegistroD500> registroD500 = new ArrayList<RegistroD500>();
    private List<RegistroD600> registroD600 = new ArrayList<RegistroD600>();
    private List<RegistroD695> registroD695 = new ArrayList<RegistroD695>();
    private RegistroD990 registroD990 = new RegistroD990();
}

class RegistroD001 {

    private String REG;
    private String IND_MOV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D001").append("|");
            conteudo.append(IND_MOV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD001.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroD100 {

    private String REG;
    private String IND_OPER;
    private String IND_EMIT;
    private String COD_PART;
    private String COD_MOD;
    private String COD_SIT;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String CHV_CTE;
    private String DT_DOC;
    private String DT_A_P;
    private String TP_CT_E;
    private String CHV_CTE_REF;
    private String VL_DOC;
    private String VL_DESC;
    private String IND_FRT;
    private String VL_SERV;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_NT;
    private String COD_INF;
    private String COD_CTA;
    private List<RegistroD110> registroD110 = new ArrayList<RegistroD110>();
    private List<RegistroD130> registroD130 = new ArrayList<RegistroD130>();
    private List<RegistroD140> registroD140 = new ArrayList<RegistroD140>();
    private List<RegistroD150> registroD150 = new ArrayList<RegistroD150>();
    private List<RegistroD161> registroD161 = new ArrayList<RegistroD161>();
    private List<RegistroD170> registroD170 = new ArrayList<RegistroD170>();
    private List<RegistroD180> registroD180 = new ArrayList<RegistroD180>();
    private List<RegistroD190> registroD190 = new ArrayList<RegistroD190>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D100").append("|");
            conteudo.append(IND_OPER).append("|");
            conteudo.append(IND_EMIT).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(COD_MOD).append("|");
            conteudo.append(COD_SIT).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(CHV_CTE, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_A_P)).append("|");
            conteudo.append(TP_CT_E).append("|");
            conteudo.append(geral.efdAlfanumerico(CHV_CTE_REF, 44)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(IND_FRT).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_NT).append("|");
            conteudo.append(geral.efdAlfanumerico(CHV_CTE_REF, 44)).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD100.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCHV_CTE() {
        return CHV_CTE;
    }

    public void setCHV_CTE(String CHV_CTE) {
        this.CHV_CTE = CHV_CTE;
    }

    public String getCHV_CTE_REF() {
        return CHV_CTE_REF;
    }

    public void setCHV_CTE_REF(String CHV_CTE_REF) {
        this.CHV_CTE_REF = CHV_CTE_REF;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
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

    public String getIND_FRT() {
        return IND_FRT;
    }

    public void setIND_FRT(String IND_FRT) {
        this.IND_FRT = IND_FRT;
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

    public String getTP_CT_E() {
        return TP_CT_E;
    }

    public void setTP_CT_E(String TP_CT_E) {
        this.TP_CT_E = TP_CT_E;
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

    public String getVL_NT() {
        return VL_NT;
    }

    public void setVL_NT(String VL_NT) {
        this.VL_NT = VL_NT;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
    }
}

class RegistroD110 {

    private String REG;
    private String NUM_ITEM;
    private String COD_ITEM;
    private String VL_SERV;
    private String VL_OUT;
    private List<RegistroD120> registroD120 = new ArrayList<RegistroD120>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D110").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_ITEM, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_OUT).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD110.class.getName()).log(Level.SEVERE, null, e);
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

    public String getVL_OUT() {
        return VL_OUT;
    }

    public void setVL_OUT(String VL_OUT) {
        this.VL_OUT = VL_OUT;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
    }
}

class RegistroD120 {

    private String REG;
    private String COD_MUN_ORIG;
    private String COD_MUN_DEST;
    private String VEIC_ID;
    private String UF_ID;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D120").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_ORIG, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_DEST, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(VEIC_ID, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_ID, 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD120.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getUF_ID() {
        return UF_ID;
    }

    public void setUF_ID(String UF_ID) {
        this.UF_ID = UF_ID;
    }

    public String getVEIC_ID() {
        return VEIC_ID;
    }

    public void setVEIC_ID(String VEIC_ID) {
        this.VEIC_ID = VEIC_ID;
    }
}

class RegistroD130 {

    private String REG;
    private String COD_PART_CONSG;
    private String COD_PART_RED;
    private String IND_FRT_RED;
    private String COD_MUN_ORIG;
    private String COD_MUN_DEST;
    private String VEIC_ID;
    private String VL_LIQ_FRT;
    private String VL_SEC_CAT;
    private String VL_DESP;
    private String VL_PEDG;
    private String VL_OUT;
    private String VL_FRT;
    private String UF_ID;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D130").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART_CONSG, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART_RED, 60)).append("|");
            conteudo.append(IND_FRT_RED).append("|");
            conteudo.append(COD_MUN_ORIG).append("|");
            conteudo.append(COD_MUN_DEST).append("|");
            conteudo.append(geral.efdAlfanumerico(VEIC_ID, 7)).append("|");
            conteudo.append(VL_LIQ_FRT).append("|");
            conteudo.append(VL_SEC_CAT).append("|");
            conteudo.append(VL_DESP).append("|");
            conteudo.append(VL_PEDG).append("|");
            conteudo.append(VL_OUT).append("|");
            conteudo.append(VL_FRT).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_ID, 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD130.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getCOD_PART_CONSG() {
        return COD_PART_CONSG;
    }

    public void setCOD_PART_CONSG(String COD_PART_CONSG) {
        this.COD_PART_CONSG = COD_PART_CONSG;
    }

    public String getCOD_PART_RED() {
        return COD_PART_RED;
    }

    public void setCOD_PART_RED(String COD_PART_RED) {
        this.COD_PART_RED = COD_PART_RED;
    }

    public String getIND_FRT_RED() {
        return IND_FRT_RED;
    }

    public void setIND_FRT_RED(String IND_FRT_RED) {
        this.IND_FRT_RED = IND_FRT_RED;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getUF_ID() {
        return UF_ID;
    }

    public void setUF_ID(String UF_ID) {
        this.UF_ID = UF_ID;
    }

    public String getVEIC_ID() {
        return VEIC_ID;
    }

    public void setVEIC_ID(String VEI_ID) {
        this.VEIC_ID = VEI_ID;
    }

    public String getVL_DESP() {
        return VL_DESP;
    }

    public void setVL_DESP(String VL_DESP) {
        this.VL_DESP = VL_DESP;
    }

    public String getVL_FRT() {
        return VL_FRT;
    }

    public void setVL_FRT(String VL_FRT) {
        this.VL_FRT = VL_FRT;
    }

    public String getVL_LIQ_FRT() {
        return VL_LIQ_FRT;
    }

    public void setVL_LIQ_FRT(String VL_LIQ_FRT) {
        this.VL_LIQ_FRT = VL_LIQ_FRT;
    }

    public String getVL_OUT() {
        return VL_OUT;
    }

    public void setVL_OUT(String VL_OUT) {
        this.VL_OUT = VL_OUT;
    }

    public String getVL_PEDG() {
        return VL_PEDG;
    }

    public void setVL_PEDG(String VL_PEDG) {
        this.VL_PEDG = VL_PEDG;
    }

    public String getVL_SEC_CAT() {
        return VL_SEC_CAT;
    }

    public void setVL_SEC_CAT(String VL_SEC_CAT) {
        this.VL_SEC_CAT = VL_SEC_CAT;
    }
}

class RegistroD140 {

    private String REG;
    private String COD_PART_CONSG;
    private String COD_MUN_ORIG;
    private String COD_MUN_DEST;
    private String IND_VEIC;
    private String VEIC_ID;
    private String IND_NAV;
    private String VIAGEM;
    private String VL_FRT_LIQ;
    private String VL_DESP_PORT;
    private String VL_DESP_CAR_DESC;
    private String VL_OUT;
    private String VL_FRT_BRT;
    private String VL_FRT_MM;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D140").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART_CONSG, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_ORIG, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_DEST, 7)).append("|");
            conteudo.append(IND_VEIC).append("|");
            conteudo.append(VEIC_ID).append("|");
            conteudo.append(IND_NAV).append("|");
            conteudo.append(VIAGEM).append("|");
            conteudo.append(VL_FRT_LIQ).append("|");
            conteudo.append(VL_DESP_PORT).append("|");
            conteudo.append(VL_DESP_CAR_DESC).append("|");
            conteudo.append(VL_OUT).append("|");
            conteudo.append(VL_FRT_BRT).append("|");
            conteudo.append(VL_FRT_MM).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD140.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_PART_CONSG() {
        return COD_PART_CONSG;
    }

    public void setCOD_PART_CONSG(String COD_PART_CONSG) {
        this.COD_PART_CONSG = COD_PART_CONSG;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
    }

    public String getIND_VEIC() {
        return IND_VEIC;
    }

    public void setIND_VEIC(String IND_VEIC) {
        this.IND_VEIC = IND_VEIC;
    }

    public String getVEIC_ID() {
        return VEIC_ID;
    }

    public void setVEIC_ID(String VEIC_ID) {
        this.VEIC_ID = VEIC_ID;
    }

    public String getIND_NAV() {
        return IND_NAV;
    }

    public void setIND_NAV(String IND_NAV) {
        this.IND_NAV = IND_NAV;
    }

    public String getVIAGEM() {
        return VIAGEM;
    }

    public void setVIAGEM(String VIAGEM) {
        this.VIAGEM = VIAGEM;
    }

    public String getVL_FRT_LIQ() {
        return VL_FRT_LIQ;
    }

    public void setVL_FRT_LIQ(String VL_FRT_LIQ) {
        this.VL_FRT_LIQ = VL_FRT_LIQ;
    }

    public String getVL_DESP_PORT() {
        return VL_DESP_PORT;
    }

    public void setVL_DESP_PORT(String VL_DESP_PORT) {
        this.VL_DESP_PORT = VL_DESP_PORT;
    }

    public String getVL_DESP_CAR_DESC() {
        return VL_DESP_CAR_DESC;
    }

    public void setVL_DESP_CAR_DESC(String VL_DESP_CAR_DESC) {
        this.VL_DESP_CAR_DESC = VL_DESP_CAR_DESC;
    }

    public String getVL_OUT() {
        return VL_OUT;
    }

    public void setVL_OUT(String VL_OUT) {
        this.VL_OUT = VL_OUT;
    }

    public String getVL_FRT_BRT() {
        return VL_FRT_BRT;
    }

    public void setVL_FRT_BRT(String VL_FRT_BRT) {
        this.VL_FRT_BRT = VL_FRT_BRT;
    }

    public String getVL_FRT_MM() {
        return VL_FRT_MM;
    }

    public void setVL_FRT_MM(String VL_FRT_MM) {
        this.VL_FRT_MM = VL_FRT_MM;
    }
}

class RegistroD150 {

    private String REG;
    private String COD_MUN_ORIG;
    private String COD_MUN_DEST;
    private String VEIC_ID;
    private String VIAGEM;
    private String IND_TFA;
    private String VL_PESO_TX;
    private String VL_TX_TERR;
    private String VL_TX_RED;
    private String VL_OUT;
    private String VL_TX_ADV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D150").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_ORIG, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_DEST, 7)).append("|");
            conteudo.append(VEIC_ID).append("|");
            conteudo.append(VIAGEM).append("|");
            conteudo.append(IND_TFA).append("|");
            conteudo.append(VL_PESO_TX).append("|");
            conteudo.append(VL_TX_TERR).append("|");
            conteudo.append(VL_TX_RED).append("|");
            conteudo.append(VL_OUT).append("|");
            conteudo.append(VL_TX_ADV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD150.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
    }

    public String getVEIC_ID() {
        return VEIC_ID;
    }

    public void setVEIC_ID(String VEIC_ID) {
        this.VEIC_ID = VEIC_ID;
    }

    public String getVIAGEM() {
        return VIAGEM;
    }

    public void setVIAGEM(String VIAGEM) {
        this.VIAGEM = VIAGEM;
    }

    public String getIND_TFA() {
        return IND_TFA;
    }

    public void setIND_TFA(String IND_TFA) {
        this.IND_TFA = IND_TFA;
    }

    public String getVL_PESO_TX() {
        return VL_PESO_TX;
    }

    public void setVL_PESO_TX(String VL_PESO_TX) {
        this.VL_PESO_TX = VL_PESO_TX;
    }

    public String getVL_TX_TERR() {
        return VL_TX_TERR;
    }

    public void setVL_TX_TERR(String VL_TX_TERR) {
        this.VL_TX_TERR = VL_TX_TERR;
    }

    public String getVL_TX_RED() {
        return VL_TX_RED;
    }

    public void setVL_TX_RED(String VL_TX_RED) {
        this.VL_TX_RED = VL_TX_RED;
    }

    public String getVL_OUT() {
        return VL_OUT;
    }

    public void setVL_OUT(String VL_OUT) {
        this.VL_OUT = VL_OUT;
    }

    public String getVL_TX_ADV() {
        return VL_TX_ADV;
    }

    public void setVL_TX_ADV(String VL_TX_ADV) {
        this.VL_TX_ADV = VL_TX_ADV;
    }
}

class RegistroD160 {

    private String REG;
    private String DESPACHO;
    private String CNPJ_CPF_REM;
    private String IE_REM;
    private String COD_MUN_ORI;
    private String CNPJ_CPF_DEST;
    private String IE_DEST;
    private String COD_MUN_DEST;
    private List<RegistroD161> registroD161 = new ArrayList<RegistroD161>();
    private List<RegistroD162> registroD162 = new ArrayList<RegistroD162>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D160").append("|");
            conteudo.append(DESPACHO).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_REM)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_REM)).append("|");
            conteudo.append(COD_MUN_ORI).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_DEST)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_DEST)).append("|");
            conteudo.append(COD_MUN_DEST).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD160.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCNPJ_CPF_DEST() {
        return CNPJ_CPF_DEST;
    }

    public void setCNPJ_CPF_DEST(String CNPJ_CPF_DEST) {
        this.CNPJ_CPF_DEST = CNPJ_CPF_DEST;
    }

    public String getCNPJ_CPF_REM() {
        return CNPJ_CPF_REM;
    }

    public void setCNPJ_CPF_REM(String CNPJ_CPF_REM) {
        this.CNPJ_CPF_REM = CNPJ_CPF_REM;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
    }

    public String getCOD_MUN_ORI() {
        return COD_MUN_ORI;
    }

    public void setCOD_MUN_ORI(String COD_MUN_ORI) {
        this.COD_MUN_ORI = COD_MUN_ORI;
    }

    public String getDESPACHO() {
        return DESPACHO;
    }

    public void setDESPACHO(String DESPACHO) {
        this.DESPACHO = DESPACHO;
    }

    public String getIE_DEST() {
        return IE_DEST;
    }

    public void setIE_DEST(String IE_DEST) {
        this.IE_DEST = IE_DEST;
    }

    public String getIE_REM() {
        return IE_REM;
    }

    public void setIE_REM(String IE_REM) {
        this.IE_REM = IE_REM;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroD161 {

    private String REG;
    private String IND_CARGA;
    private String CNPJ_CPF_COL;
    private String IE_COL;
    private String COD_MUN_COL;
    private String CNPJ_CPF_ENTG;
    private String IE_ENTG;
    private String COD_MUN_ENTG;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D161").append("|");
            conteudo.append(IND_CARGA).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_COL)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_COL)).append("|");
            conteudo.append(COD_MUN_COL).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_ENTG)).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_ENTG)).append("|");
            conteudo.append(COD_MUN_ENTG).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD161.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_CARGA() {
        return IND_CARGA;
    }

    public void setIND_CARGA(String IND_CARGA) {
        this.IND_CARGA = IND_CARGA;
    }

    public String getCNPJ_CPF_COL() {
        return CNPJ_CPF_COL;
    }

    public void setCNPJ_CPF_COL(String CNPJ_CPF_COL) {
        this.CNPJ_CPF_COL = CNPJ_CPF_COL;
    }

    public String getIE_COL() {
        return IE_COL;
    }

    public void setIE_COL(String IE_COL) {
        this.IE_COL = IE_COL;
    }

    public String getCOD_MUN_COL() {
        return COD_MUN_COL;
    }

    public void setCOD_MUN_COL(String COD_MUN_COL) {
        this.COD_MUN_COL = COD_MUN_COL;
    }

    public String getCNPJ_CPF_ENTG() {
        return CNPJ_CPF_ENTG;
    }

    public void setCNPJ_CPF_ENTG(String CNPJ_CPF_ENTG) {
        this.CNPJ_CPF_ENTG = CNPJ_CPF_ENTG;
    }

    public String getIE_ENTG() {
        return IE_ENTG;
    }

    public void setIE_ENTG(String IE_ENTG) {
        this.IE_ENTG = IE_ENTG;
    }

    public String getCOD_MUN_ENTG() {
        return COD_MUN_ENTG;
    }

    public void setCOD_MUN_ENTG(String COD_MUN_ENTG) {
        this.COD_MUN_ENTG = COD_MUN_ENTG;
    }
}

class RegistroD162 {

    private String REG;
    private String COD_MOD;
    private String SER;
    private String NUM_DOC;
    private String DT_DOC;
    private String VL_DOC;
    private String VL_MERC;
    private String QTD_VOL;
    private String PESO_BRT;
    private String PESO_LIQ;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D162").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_MERC).append("|");
            conteudo.append(QTD_VOL).append("|");
            conteudo.append(PESO_BRT).append("|");
            conteudo.append(PESO_LIQ).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD162.class.getName()).log(Level.SEVERE, null, e);
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

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_MERC() {
        return VL_MERC;
    }

    public void setVL_MERC(String VL_MERC) {
        this.VL_MERC = VL_MERC;
    }

    public String getQTD_VOL() {
        return QTD_VOL;
    }

    public void setQTD_VOL(String QTD_VOL) {
        this.QTD_VOL = QTD_VOL;
    }

    public String getPESO_BRT() {
        return PESO_BRT;
    }

    public void setPESO_BRT(String PESO_BRT) {
        this.PESO_BRT = PESO_BRT;
    }

    public String getPESO_LIQ() {
        return PESO_LIQ;
    }

    public void setPESO_LIQ(String PESO_LIQ) {
        this.PESO_LIQ = PESO_LIQ;
    }
}

class RegistroD170 {

    private String REG;
    private String COD_PART_CONSG;
    private String COD_PART_RED;
    private String COD_MUN_ORIG;
    private String COD_MUN_DEST;
    private String OTM;
    private String IND_NAT_FRT;
    private String VL_LIQ_FRT;
    private String VL_GRIS;
    private String VL_PDG;
    private String VL_OUT;
    private String VL_FRT;
    private String VEIC_ID;
    private String UF_ID;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D170").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART_CONSG, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART_RED, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_ORIG, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_DEST, 7)).append("|");
            conteudo.append(OTM).append("|");
            conteudo.append(IND_NAT_FRT).append("|");
            conteudo.append(VL_LIQ_FRT).append("|");
            conteudo.append(VL_GRIS).append("|");
            conteudo.append(VL_PDG).append("|");
            conteudo.append(VL_OUT).append("|");
            conteudo.append(VL_FRT).append("|");
            conteudo.append(geral.efdAlfanumerico(VEIC_ID, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_ID, 7)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD170.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_PART_CONSG() {
        return COD_PART_CONSG;
    }

    public void setCOD_PART_CONSG(String COD_PART_CONSG) {
        this.COD_PART_CONSG = COD_PART_CONSG;
    }

    public String getCOD_PART_RED() {
        return COD_PART_RED;
    }

    public void setCOD_PART_RED(String COD_PART_RED) {
        this.COD_PART_RED = COD_PART_RED;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
    }

    public String getOTM() {
        return OTM;
    }

    public void setOTM(String OTM) {
        this.OTM = OTM;
    }

    public String getIND_NAT_FRT() {
        return IND_NAT_FRT;
    }

    public void setIND_NAT_FRT(String IND_NAT_FRT) {
        this.IND_NAT_FRT = IND_NAT_FRT;
    }

    public String getVL_LIQ_FRT() {
        return VL_LIQ_FRT;
    }

    public void setVL_LIQ_FRT(String VL_LIQ_FRT) {
        this.VL_LIQ_FRT = VL_LIQ_FRT;
    }

    public String getVL_GRIS() {
        return VL_GRIS;
    }

    public void setVL_GRIS(String VL_GRIS) {
        this.VL_GRIS = VL_GRIS;
    }

    public String getVL_PDG() {
        return VL_PDG;
    }

    public void setVL_PDG(String VL_PDG) {
        this.VL_PDG = VL_PDG;
    }

    public String getVL_OUT() {
        return VL_OUT;
    }

    public void setVL_OUT(String VL_OUT) {
        this.VL_OUT = VL_OUT;
    }

    public String getVL_FRT() {
        return VL_FRT;
    }

    public void setVL_FRT(String VL_FRT) {
        this.VL_FRT = VL_FRT;
    }

    public String getVEIC_ID() {
        return VEIC_ID;
    }

    public void setVEIC_ID(String VEIC_ID) {
        this.VEIC_ID = VEIC_ID;
    }

    public String getUF_ID() {
        return UF_ID;
    }

    public void setUF_ID(String UF_ID) {
        this.UF_ID = UF_ID;
    }
}

class RegistroD180 {

    private String REG;
    private String NUM_SEQ;
    private String IND_EMIT;
    private String CNPJ_CPF_EMIT;
    private String UF_EMIT;
    private String IE_EMIT;
    private String COD_MUN_ORIG;
    private String CNPJ_CPF_TOM;
    private String UF_TOM;
    private String IE_TOM;
    private String COD_MUN_DEST;
    private String COD_MOD;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String DT_DOC;
    private String VL_DOC;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D180").append("|");
            conteudo.append(NUM_SEQ).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_EMIT, 1)).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_EMIT)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_EMIT, 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_EMIT)).append("|");
            conteudo.append(COD_MUN_ORIG).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF_TOM)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_TOM, 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_TOM)).append("|");
            conteudo.append(COD_MUN_DEST).append("|");
            conteudo.append(COD_MOD).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(NUM_DOC).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD180.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_SEQ() {
        return NUM_SEQ;
    }

    public void setNUM_SEQ(String NUM_SEQ) {
        this.NUM_SEQ = NUM_SEQ;
    }

    public String getIND_EMIT() {
        return IND_EMIT;
    }

    public void setIND_EMIT(String IND_EMIT) {
        this.IND_EMIT = IND_EMIT;
    }

    public String getCNPJ_CPF_EMIT() {
        return CNPJ_CPF_EMIT;
    }

    public void setCNPJ_CPF_EMIT(String CNPJ_CPF_EMIT) {
        this.CNPJ_CPF_EMIT = CNPJ_CPF_EMIT;
    }

    public String getUF_EMIT() {
        return UF_EMIT;
    }

    public void setUF_EMIT(String UF_EMIT) {
        this.UF_EMIT = UF_EMIT;
    }

    public String getIE_EMIT() {
        return IE_EMIT;
    }

    public void setIE_EMIT(String IE_EMIT) {
        this.IE_EMIT = IE_EMIT;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getCNPJ_CPF_TOM() {
        return CNPJ_CPF_TOM;
    }

    public void setCNPJ_CPF_TOM(String CNPJ_CPF_TOM) {
        this.CNPJ_CPF_TOM = CNPJ_CPF_TOM;
    }

    public String getUF_TOM() {
        return UF_TOM;
    }

    public void setUF_TOM(String UF_TOM) {
        this.UF_TOM = UF_TOM;
    }

    public String getIE_TOM() {
        return IE_TOM;
    }

    public void setIE_TOM(String IE_TOM) {
        this.IE_TOM = IE_TOM;
    }

    public String getCOD_MUN_DEST() {
        return COD_MUN_DEST;
    }

    public void setCOD_MUN_DEST(String COD_MUN_DEST) {
        this.COD_MUN_DEST = COD_MUN_DEST;
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

    public String getNUM_DOC() {
        return NUM_DOC;
    }

    public void setNUM_DOC(String NUM_DOC) {
        this.NUM_DOC = NUM_DOC;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }
}

class RegistroD190 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_RED_BC;
    private String COD_OBS;
    private List<RegistroD195> registroD195 = new ArrayList<RegistroD195>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D190").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD190.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
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

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
    }
}

class RegistroD195 {

    private String REG;
    private String COD_OBS;
    private String TXT_COMPL;
    private List<RegistroD197> registroD197 = new ArrayList<RegistroD197>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D195").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append(TXT_COMPL).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD195.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

class RegistroD197 {

    private String REG;
    private String COD_AJ;
    private String DESCR_COMPL_AJ;
    private String COD_ITEM;
    private String VL_BC_ICMS;
    private String ALIQ_ICMS;
    private String VL_ICMS;
    private String VL_OUTROS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D197").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_AJ, 7)).append("|");
            conteudo.append(DESCR_COMPL_AJ).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_OUTROS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD197.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCOD_AJ() {
        return COD_AJ;
    }

    public void setCOD_AJ(String COD_AJ) {
        this.COD_AJ = COD_AJ;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

    public String getVL_OUTROS() {
        return VL_OUTROS;
    }

    public void setVL_OUTROS(String VL_OUTROS) {
        this.VL_OUTROS = VL_OUTROS;
    }
}

class RegistroD400 {

    private String REG;
    private String COD_PART;
    private String COD_MOD;
    private String COD_SIT;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String DT_DOC;
    private String VL_DOC;
    private String VL_DESC;
    private String VL_SERV;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private List<RegistroD410> registroD410 = new ArrayList<RegistroD410>();
    private List<RegistroD420> registroD420 = new ArrayList<RegistroD420>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D400").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_SIT, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD400.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
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

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
    }
}

class RegistroD410 {

    private String REG;
    private String COD_MOD;
    private String SER;
    private String SUB;
    private String NUM_DOC_INI;
    private String NUM_DOC_FIN;
    private String DT_DOC;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_DESC;
    private String VL_SERV;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private List<RegistroD411> registroD411 = new ArrayList<RegistroD411>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D410").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC_INI, 6)).append("|");
            conteudo.append(NUM_DOC_FIN).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD410.class.getName()).log(Level.SEVERE, null, e);
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

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
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
}

class RegistroD411 {

    private String REG;
    private String NUM_DOC_CANC;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D411").append("|");
            conteudo.append(NUM_DOC_CANC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD411.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_DOC_CANC() {
        return NUM_DOC_CANC;
    }

    public void setNUM_DOC_CANC(String NUM_DOC_CANC) {
        this.NUM_DOC_CANC = NUM_DOC_CANC;
    }
}

class RegistroD420 {

    private String REG;
    private String COD_MUN_ORIG;
    private String VL_SERV;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D420").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_ORIG, 7)).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD420.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_MUN_ORIG() {
        return COD_MUN_ORIG;
    }

    public void setCOD_MUN_ORIG(String COD_MUN_ORIG) {
        this.COD_MUN_ORIG = COD_MUN_ORIG;
    }

    public String getVL_SERV() {
        return VL_SERV;
    }

    public void setVL_SERV(String VL_SERV) {
        this.VL_SERV = VL_SERV;
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
}

class RegistroD500 {

    private String REG;
    private String IND_OPER;
    private String IND_EMIT;
    private String COD_PART;
    private String COD_MOD;
    private String COD_SIT;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String DT_DOC;
    private String DT_A_P;
    private String VL_DOC;
    private String VL_DESC;
    private String VL_SERV;
    private String VL_SERV_NT;
    private String VL_TERC;
    private String VL_DA;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String COD_INF;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private String TP_ASSINANTE;
    private List<RegistroD510> registroD510 = new ArrayList<RegistroD510>();
    private List<RegistroD530> registroD530 = new ArrayList<RegistroD530>();
    private List<RegistroD590> registroD590 = new ArrayList<RegistroD590>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D500").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_OPER, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_EMIT, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_SIT, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_A_P)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_SERV_NT).append("|");
            conteudo.append(VL_TERC).append("|");
            conteudo.append(VL_DA).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_INF, 6)).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append(TP_ASSINANTE).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD500.class.getName()).log(Level.SEVERE, null, e);
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
}

class RegistroD510 {

    private String REG;
    private String NUM_ITEM;
    private String COD_ITEM;
    private String COD_CLASS;
    private String QTD;
    private String UNID;
    private String VL_ITEM;
    private String VL_DESC;
    private String CST_ICMS;
    private String CFOP;
    private String VL_BC_ICMS;
    private String ALIQ_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_UF;
    private String VL_ICMS_UF;
    private String IND_REC;
    private String COD_PART;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D510").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_ITEM, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_UF).append("|");
            conteudo.append(VL_ICMS_UF).append("|");
            conteudo.append(IND_REC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD510.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getNUM_ITEM() {
        return NUM_ITEM;
    }

    public void setNUM_ITEM(String NUM_ITEM) {
        this.NUM_ITEM = NUM_ITEM;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_CLASS() {
        return COD_CLASS;
    }

    public void setCOD_CLASS(String COD_CLASS) {
        this.COD_CLASS = COD_CLASS;
    }

    public String getQTD() {
        return QTD;
    }

    public void setQTD(String QTD) {
        this.QTD = QTD;
    }

    public String getUNID() {
        return UNID;
    }

    public void setUNID(String UNID) {
        this.UNID = UNID;
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

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getVL_BC_ICMS() {
        return VL_BC_ICMS;
    }

    public void setVL_BC_ICMS(String VL_BC_ICMS) {
        this.VL_BC_ICMS = VL_BC_ICMS;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getVL_ICMS() {
        return VL_ICMS;
    }

    public void setVL_ICMS(String VL_ICMS) {
        this.VL_ICMS = VL_ICMS;
    }

    public String getVL_BC_ICMS_UF() {
        return VL_BC_ICMS_UF;
    }

    public void setVL_BC_ICMS_UF(String VL_BC_ICMS_UF) {
        this.VL_BC_ICMS_UF = VL_BC_ICMS_UF;
    }

    public String getVL_ICMS_UF() {
        return VL_ICMS_UF;
    }

    public void setVL_ICMS_UF(String VL_ICMS_UF) {
        this.VL_ICMS_UF = VL_ICMS_UF;
    }

    public String getIND_REC() {
        return IND_REC;
    }

    public void setIND_REC(String IND_REC) {
        this.IND_REC = IND_REC;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
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

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class RegistroD530 {

    private String REG;
    private String IND_SERV;
    private String DT_INI_SERV;
    private String DT_FIN_SERV;
    private String PER_FISCAL;
    private String COD_AREA;
    private String TERMINAL;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D530").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_SERV, 1)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI_SERV)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIN_SERV)).append("|");
            conteudo.append(geral.efdAlfanumerico(PER_FISCAL, 6)).append("|");
            conteudo.append(COD_AREA).append("|");
            conteudo.append(TERMINAL).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD530.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getIND_SERV() {
        return IND_SERV;
    }

    public void setIND_SERV(String IND_SERV) {
        this.IND_SERV = IND_SERV;
    }

    public String getDT_INI_SERV() {
        return DT_INI_SERV;
    }

    public void setDT_INI_SERV(String DT_INI_SERV) {
        this.DT_INI_SERV = DT_INI_SERV;
    }

    public String getDT_FIN_SERV() {
        return DT_FIN_SERV;
    }

    public void setDT_FIN_SERV(String DT_FIN_SERV) {
        this.DT_FIN_SERV = DT_FIN_SERV;
    }

    public String getPER_FISCAL() {
        return PER_FISCAL;
    }

    public void setPER_FISCAL(String PER_FISCAL) {
        this.PER_FISCAL = PER_FISCAL;
    }

    public String getCOD_AREA() {
        return COD_AREA;
    }

    public void setCOD_AREA(String COD_AREA) {
        this.COD_AREA = COD_AREA;
    }

    public String getTERMINAL() {
        return TERMINAL;
    }

    public void setTERMINAL(String TERMINAL) {
        this.TERMINAL = TERMINAL;
    }
}

class RegistroD590 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_UF;
    private String VL_ICMS_UF;
    private String VL_RED_BC;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D590").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 4)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_UF).append("|");
            conteudo.append(VL_ICMS_UF).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD590.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
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

    public String getVL_BC_ICMS_UF() {
        return VL_BC_ICMS_UF;
    }

    public void setVL_BC_ICMS_UF(String VL_BC_ICMS_UF) {
        this.VL_BC_ICMS_UF = VL_BC_ICMS_UF;
    }

    public String getVL_ICMS_UF() {
        return VL_ICMS_UF;
    }

    public void setVL_ICMS_UF(String VL_ICMS_UF) {
        this.VL_ICMS_UF = VL_ICMS_UF;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
    }
}

class RegistroD600 {

    private String REG;
    private String COD_MOD;
    private String COD_MUN;
    private String SER;
    private String SUB;
    private String COD_CONS;
    private String QTD_CONS;
    private String DT_DOC;
    private String VL_DOC;
    private String VL_DESC;
    private String VL_SERV;
    private String VL_SERV_NT;
    private String VL_TERC;
    private String VL_DA;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_PIS;
    private String VL_COFINS;
    private List<RegistroD610> registroD610 = new ArrayList<RegistroD610>();
    private List<RegistroD690> registroD690 = new ArrayList<RegistroD690>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D600").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_CONS, 2)).append("|");
            conteudo.append(QTD_CONS).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_SERV).append("|");
            conteudo.append(VL_SERV_NT).append("|");
            conteudo.append(VL_TERC).append("|");
            conteudo.append(VL_DA).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD600.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_CONS() {
        return COD_CONS;
    }

    public void setCOD_CONS(String COD_CONS) {
        this.COD_CONS = COD_CONS;
    }

    public String getQTD_CONS() {
        return QTD_CONS;
    }

    public void setQTD_CONS(String QTD_CONS) {
        this.QTD_CONS = QTD_CONS;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
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

    public List<RegistroD610> getRegistroD610() {
        return registroD610;
    }

    public void setRegistroD610(List<RegistroD610> registroD610) {
        this.registroD610 = registroD610;
    }

    public List<RegistroD690> getRegistroD690() {
        return registroD690;
    }

    public void setRegistroD690(List<RegistroD690> registroD690) {
        this.registroD690 = registroD690;
    }
}

class RegistroD610 {

    private String REG;
    private String COD_CLASS;
    private String COD_ITEM;
    private String QTD;
    private String UNID;
    private String VL_ITEM;
    private String VL_DESC;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_UF;
    private String VL_ICMS_UF;
    private String VL_RED_BC;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D610").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_CLASS, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_UF).append("|");
            conteudo.append(VL_ICMS_UF).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD610.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getQTD() {
        return QTD;
    }

    public void setQTD(String QTD) {
        this.QTD = QTD;
    }

    public String getUNID() {
        return UNID;
    }

    public void setUNID(String UNID) {
        this.UNID = UNID;
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

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
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

    public String getVL_BC_ICMS_UF() {
        return VL_BC_ICMS_UF;
    }

    public void setVL_BC_ICMS_UF(String VL_BC_ICMS_UF) {
        this.VL_BC_ICMS_UF = VL_BC_ICMS_UF;
    }

    public String getVL_ICMS_UF() {
        return VL_ICMS_UF;
    }

    public void setVL_ICMS_UF(String VL_ICMS_UF) {
        this.VL_ICMS_UF = VL_ICMS_UF;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
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

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class RegistroD690 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_UF;
    private String VL_ICMS_UF;
    private String VL_RED_BC;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D690").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_UF).append("|");
            conteudo.append(VL_ICMS_UF).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD690.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
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

    public String getVL_BC_ICMS_UF() {
        return VL_BC_ICMS_UF;
    }

    public void setVL_BC_ICMS_UF(String VL_BC_ICMS_UF) {
        this.VL_BC_ICMS_UF = VL_BC_ICMS_UF;
    }

    public String getVL_ICMS_UF() {
        return VL_ICMS_UF;
    }

    public void setVL_ICMS_UF(String VL_ICMS_UF) {
        this.VL_ICMS_UF = VL_ICMS_UF;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
    }
}

class RegistroD695 {

    private String REG;
    private String COD_MOD;
    private String SER;
    private String NRO_ORD_INI;
    private String NRO_ORD_FIN;
    private String DT_DOC_INI;
    private String DT_DOC_FIN;
    private String NOM_MEST;
    private String CHV_COD_DIG;
    private List<RegistroD696> registroD696 = new ArrayList<RegistroD696>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D695").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(NRO_ORD_INI, 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(NRO_ORD_FIN, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC_FIN)).append("|");
            conteudo.append(geral.efdAlfanumerico(NOM_MEST, 15)).append("|");
            conteudo.append(geral.efdAlfanumerico(CHV_COD_DIG, 32)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD695.class.getName()).log(Level.SEVERE, null, e);
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

    public String getSER() {
        return SER;
    }

    public void setSER(String SER) {
        this.SER = SER;
    }

    public String getNRO_ORD_INI() {
        return NRO_ORD_INI;
    }

    public void setNRO_ORD_INI(String NRO_ORD_INI) {
        this.NRO_ORD_INI = NRO_ORD_INI;
    }

    public String getNRO_ORD_FIN() {
        return NRO_ORD_FIN;
    }

    public void setNRO_ORD_FIN(String NRO_ORD_FIN) {
        this.NRO_ORD_FIN = NRO_ORD_FIN;
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

    public String getNOM_MEST() {
        return NOM_MEST;
    }

    public void setNOM_MEST(String NOM_MEST) {
        this.NOM_MEST = NOM_MEST;
    }

    public String getCHV_COD_DIG() {
        return CHV_COD_DIG;
    }

    public void setCHV_COD_DIG(String CHV_COD_DIG) {
        this.CHV_COD_DIG = CHV_COD_DIG;
    }

    public List<RegistroD696> getRegistroD696() {
        return registroD696;
    }

    public void setRegistroD696(List<RegistroD696> registroD696) {
        this.registroD696 = registroD696;
    }
}

class RegistroD696 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_UF;
    private String VL_ICMS_UF;
    private String VL_RED_BC;
    private String COD_OBS;
    private List<RegistroD697> registroD697 = new ArrayList<RegistroD697>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D696").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_UF).append("|");
            conteudo.append(VL_ICMS_UF).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD696.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
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

    public String getVL_BC_ICMS_UF() {
        return VL_BC_ICMS_UF;
    }

    public void setVL_BC_ICMS_UF(String VL_BC_ICMS_UF) {
        this.VL_BC_ICMS_UF = VL_BC_ICMS_UF;
    }

    public String getVL_ICMS_UF() {
        return VL_ICMS_UF;
    }

    public void setVL_ICMS_UF(String VL_ICMS_UF) {
        this.VL_ICMS_UF = VL_ICMS_UF;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
    }

    public List<RegistroD697> getRegistroD697() {
        return registroD697;
    }

    public void setRegistroD697(List<RegistroD697> registroD697) {
        this.registroD697 = registroD697;
    }
}

class RegistroD697 {

    private String REG;
    private String UF;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D697").append("|");
            conteudo.append(geral.efdAlfanumerico(UF, 2)).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD697.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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
}

class RegistroD990 {

    private String REG;
    private String QTD_LIN_D;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|D990").append("|");
            conteudo.append(QTD_LIN_D).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroD990.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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
}
