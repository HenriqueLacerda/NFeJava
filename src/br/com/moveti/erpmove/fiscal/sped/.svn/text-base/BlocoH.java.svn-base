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
public class BlocoH {

    private RegistroH001 registroH001 = new RegistroH001();
    private List<RegistroH005> registrosH005 = new ArrayList<RegistroH005>();
    private RegistroH990 registroH990 = new RegistroH990();
}

class RegistroH001 {

    //private String reg h001
//private String reg h005
    private String IND_MOV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|H001").append("|");
            conteudo.append(IND_MOV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroH001.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getIND_MOV() {
        return IND_MOV;
    }

    public void setIND_MOV(String IND_MOV) {
        this.IND_MOV = IND_MOV;
    }
}

class RegistroH005 {

    private String REG;
    private String DT_INV;
    private String VL_INV;
    private String MOT_INV;
    private List<RegistroH010> registrosH010 = new ArrayList<RegistroH010>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|H005").append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INV)).append("|");
            conteudo.append(VL_INV).append("|");
            conteudo.append(geral.efdAlfanumerico(MOT_INV, 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroH005.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getDT_INV() {
        return DT_INV;
    }

    public void setDT_INV(String DT_INV) {
        this.DT_INV = DT_INV;
    }

    public String getVL_INV() {
        return VL_INV;
    }

    public void setVL_INV(String VL_INV) {
        this.VL_INV = VL_INV;
    }

    public String getMOT_INV() {
        return MOT_INV;
    }

    public void setMOT_INV(String MOT_INV) {
        this.MOT_INV = MOT_INV;
    }
}

class RegistroH010 {

    private String REG;
    private String COD_ITEM;
    private String UNID;
    private String QTD;
    private String VL_UNIT;
    private String VL_ITEM;
    private String IND_PROP;
    private String COD_PART;
    private String TXT_COMP;
    private String COD_CTA;
    private List<RegistroH020> registrosH020 = new ArrayList<RegistroH020>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|H010").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(VL_UNIT).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_PROP, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(TXT_COMP).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroH010.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getIND_PROP() {
        return IND_PROP;
    }

    public void setIND_PROP(String IND_PROP) {
        this.IND_PROP = IND_PROP;
    }

    public String getQTD() {
        return QTD;
    }

    public void setQTD(String QTD) {
        this.QTD = QTD;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTXT_COMP() {
        return TXT_COMP;
    }

    public void setTXT_COMP(String TXT_COMP) {
        this.TXT_COMP = TXT_COMP;
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

    public String getVL_UNIT() {
        return VL_UNIT;
    }

    public void setVL_UNIT(String VL_UNIT) {
        this.VL_UNIT = VL_UNIT;
    }
}

class RegistroH020 {

    private String REG;
    private String CST_ICMS;
    private String BC_ICMS;
    private String VL_ICMS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|H010").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroH010.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getBC_ICMS() {
        return BC_ICMS;
    }

    public void setBC_ICMS(String BC_ICMS) {
        this.BC_ICMS = BC_ICMS;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_ICMS() {
        return VL_ICMS;
    }

    public void setVL_ICMS(String VL_ICMS) {
        this.VL_ICMS = VL_ICMS;
    }
}

class RegistroH990 {

    private String REG;
    private String QTD_LIN_H;
    
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|H990").append("|");
            conteudo.append(QTD_LIN_H).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroH990.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getQTD_LIN_H() {
        return QTD_LIN_H;
    }

    public void setQTD_LIN_H(String QTD_LIN_H) {
        this.QTD_LIN_H = QTD_LIN_H;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}
