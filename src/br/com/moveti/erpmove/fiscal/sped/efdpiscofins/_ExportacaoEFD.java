/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped.efdpiscofins;

import crncomp.conexao;
import java.sql.ResultSet;

/**
 *
 * @author Henrique
 */
public class _ExportacaoEFD {

    private conexao conexao = new conexao();
    private ResultSet RS, RS_;
    //Bloco 0
    private Registro0000 Registro0000 = new Registro0000();
    private Registro0001 Registro0001 = new Registro0001();   
    private Registro0100 Registro0100 = new Registro0100();
    private Registro0110 Registro0110 = new Registro0110();
    private Registro0120 Registro0120 = new Registro0120();
    private Registro0140 Registro0140 = new Registro0140();    
    private Registro0500 Registro0500 = new Registro0500();
    private Registro0600 Registro0600 = new Registro0600();
    private Registro0990 Registro0990 = new Registro0990();   
    
      

    public void ExportaEFD(String Diretorio, String DataInicial, String DataFinal, String Tipo, boolean Inventario, String DataInventario) {
        // Realiza Consulta buscando dados 
        //Bloco 0
        Registro0000.setREG("0000");
        Registro0000.setCOD_VER("002");
        Registro0000.setTIPO_ESCRIT("");
        Registro0000.setDT_INI("");
        Registro0000.setDT_FIN("");
        Registro0000.setNUM_REC_ANTERIOR("");
        Registro0000.setNOME("NOME");
        Registro0000.setCNPJ("NOME");
        Registro0000.setUF("NOME");       
        Registro0000.setCOD_MUN("NOME");       
        Registro0000.setSUFRAMA("NOME");
        Registro0000.setIND_NAT_PJ("NOME");
        Registro0000.setIND_SIT_ESP("NOME");
        Registro0000.setIND_ATIV("NOME");
//
        
        Registro0001.setREG("0001");
        Registro0001.setIND_MOV("NOME");             
        
        Registro0100.setREG("0100");
        Registro0100.setNOME("NOME");
        Registro0100.setCPF("NOME");
        Registro0100.setCRC("NOME");
        Registro0100.setCNPJ("NOME");
        Registro0100.setCEP("NOME");
        Registro0100.setEND("NOME");
        Registro0100.setNUM("NOME");
        Registro0100.setCOMPL("NOME");
        Registro0100.setBAIRRO("NOME");
        Registro0100.setFONE("NOME");
        Registro0100.setFAX("NOME");
        Registro0100.setEMAIL("NOME");
        Registro0100.setCOD_MUN("NOME");
        //
        Registro0120.setINF_COMP("");
        Registro0120.setMES_DISPENSA("");
        Registro0120.setREG(Tipo);
        
        Registro0140.setCNPJ(Tipo);
        Registro0140.setCOD_EST(Tipo);
        Registro0140.setCNPJ(Tipo);
        Registro0140.setCOD_EST(Tipo);
        Registro0140.setCOD_MUN(Tipo);
        Registro0140.setIE(Tipo);
        Registro0140.setIM(Tipo);
        Registro0140.setNOME(Tipo);
        Registro0140.setREG(Tipo);
        Registro0140.setSUFRAMA(Tipo);
        Registro0140.setUF(Tipo);
       
        //        
//
       
    }

    

    

    

    class Registro1001 {

        private String REG;
        private String IND_MOV;

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

    class Registro1010 {

        private String REG;
        private String IND_EXP;
        private String IND_CCRF;
        private String IND_COMB;
        private String IND_USINA;
        private String IND_VA;
        private String IND_EE;
        private String IND_CART;
        private String IND_FORM;
        private String IND_AER;

        public String getIND_AER() {
            return IND_AER;
        }

        public void setIND_AER(String IND_AER) {
            this.IND_AER = IND_AER;
        }

        public String getIND_CART() {
            return IND_CART;
        }

        public void setIND_CART(String IND_CART) {
            this.IND_CART = IND_CART;
        }

        public String getIND_CCRF() {
            return IND_CCRF;
        }

        public void setIND_CCRF(String IND_CCRF) {
            this.IND_CCRF = IND_CCRF;
        }

        public String getIND_COMB() {
            return IND_COMB;
        }

        public void setIND_COMB(String IND_COMB) {
            this.IND_COMB = IND_COMB;
        }

        public String getIND_EE() {
            return IND_EE;
        }

        public void setIND_EE(String IND_EE) {
            this.IND_EE = IND_EE;
        }

        public String getIND_EXP() {
            return IND_EXP;
        }

        public void setIND_EXP(String IND_EXP) {
            this.IND_EXP = IND_EXP;
        }

        public String getIND_FORM() {
            return IND_FORM;
        }

        public void setIND_FORM(String IND_FORM) {
            this.IND_FORM = IND_FORM;
        }

        public String getIND_USINA() {
            return IND_USINA;
        }

        public void setIND_USINA(String IND_USINA) {
            this.IND_USINA = IND_USINA;
        }

        public String getIND_VA() {
            return IND_VA;
        }

        public void setIND_VA(String IND_VA) {
            this.IND_VA = IND_VA;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }
    }

    class Registro1100 {

        private String REG;
        private String IND_DOC;
        private String NRO_DE;
        private String DT_DE;
        private String NAT_EXP;
        private String NRO_RE;
        private String DT_RE;
        private String CHC_EMB;
        private String DT_CHC;
        private String DT_AVB;
        private String TP_CHC;
        private String PAIS;

        public String getCHC_EMB() {
            return CHC_EMB;
        }

        public void setCHC_EMB(String CHC_EMB) {
            this.CHC_EMB = CHC_EMB;
        }

        public String getDT_AVB() {
            return DT_AVB;
        }

        public void setDT_AVB(String DT_AVB) {
            this.DT_AVB = DT_AVB;
        }

        public String getDT_CHC() {
            return DT_CHC;
        }

        public void setDT_CHC(String DT_CHC) {
            this.DT_CHC = DT_CHC;
        }

        public String getDT_DE() {
            return DT_DE;
        }

        public void setDT_DE(String DT_DE) {
            this.DT_DE = DT_DE;
        }

        public String getDT_RE() {
            return DT_RE;
        }

        public void setDT_RE(String DT_RE) {
            this.DT_RE = DT_RE;
        }

        public String getIND_DOC() {
            return IND_DOC;
        }

        public void setIND_DOC(String IND_DOC) {
            this.IND_DOC = IND_DOC;
        }

        public String getNAT_EXP() {
            return NAT_EXP;
        }

        public void setNAT_EXP(String NAT_EXP) {
            this.NAT_EXP = NAT_EXP;
        }

        public String getNRO_DE() {
            return NRO_DE;
        }

        public void setNRO_DE(String NRO_DE) {
            this.NRO_DE = NRO_DE;
        }

        public String getNRO_RE() {
            return NRO_RE;
        }

        public void setNRO_RE(String NRO_RE) {
            this.NRO_RE = NRO_RE;
        }

        public String getPAIS() {
            return PAIS;
        }

        public void setPAIS(String PAIS) {
            this.PAIS = PAIS;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getTP_CHC() {
            return TP_CHC;
        }

        public void setTP_CHC(String TP_CHC) {
            this.TP_CHC = TP_CHC;
        }
    }

    class Registro1105 {

        private String REG;
        private String COD_MOD;
        private String SERIE;
        private String NUM_DOC;
        private String CHV_NFE;
        private String DT_DOC;
        private String COD_ITEM;

        public String getCHV_NFE() {
            return CHV_NFE;
        }

        public void setCHV_NFE(String CHV_NFE) {
            this.CHV_NFE = CHV_NFE;
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

        public String getSERIE() {
            return SERIE;
        }

        public void setSERIE(String SERIE) {
            this.SERIE = SERIE;
        }
    }

    class Registro1110 {

        private String REG;
        private String COD_PART;
        private String COD_MOD;
        private String SER;
        private String NUM_DOC;
        private String DT_DOC;
        private String CHV_NFE;
        private String NR_MEMO;
        private String QTD;
        private String UNID;

        public String getCHV_NFE() {
            return CHV_NFE;
        }

        public void setCHV_NFE(String CHV_NFE) {
            this.CHV_NFE = CHV_NFE;
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

        public String getNR_MEMO() {
            return NR_MEMO;
        }

        public void setNR_MEMO(String NR_MEMO) {
            this.NR_MEMO = NR_MEMO;
        }

        public String getNUM_DOC() {
            return NUM_DOC;
        }

        public void setNUM_DOC(String NUM_DOC) {
            this.NUM_DOC = NUM_DOC;
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

        public String getSER() {
            return SER;
        }

        public void setSER(String SER) {
            this.SER = SER;
        }

        public String getUNID() {
            return UNID;
        }

        public void setUNID(String UNID) {
            this.UNID = UNID;
        }
    }

    class Registro1200 {

        private String REG;
        private String SLD_CRED;
        private String CRED_APR;
        private String CRED_RECEB;
        private String CRED_UTIL;
        private String SLD_CRED_FIM;

        public String getCRED_APR() {
            return CRED_APR;
        }

        public void setCRED_APR(String CRED_APR) {
            this.CRED_APR = CRED_APR;
        }

        public String getCRED_RECEB() {
            return CRED_RECEB;
        }

        public void setCRED_RECEB(String CRED_RECEB) {
            this.CRED_RECEB = CRED_RECEB;
        }

        public String getCRED_UTIL() {
            return CRED_UTIL;
        }

        public void setCRED_UTIL(String CRED_UTIL) {
            this.CRED_UTIL = CRED_UTIL;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getSLD_CRED() {
            return SLD_CRED;
        }

        public void setSLD_CRED(String SLD_CRED) {
            this.SLD_CRED = SLD_CRED;
        }

        public String getSLD_CRED_FIM() {
            return SLD_CRED_FIM;
        }

        public void setSLD_CRED_FIM(String SLD_CRED_FIM) {
            this.SLD_CRED_FIM = SLD_CRED_FIM;
        }
    }

    class Registro1210 {

        private String REG;
        private String TIPO_UTIL;
        private String NR_DOC;
        private String VL_CRED_UTIL;

        public String getNR_DOC() {
            return NR_DOC;
        }

        public void setNR_DOC(String NR_DOC) {
            this.NR_DOC = NR_DOC;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getTIPO_UTIL() {
            return TIPO_UTIL;
        }

        public void setTIPO_UTIL(String TIPO_UTIL) {
            this.TIPO_UTIL = TIPO_UTIL;
        }

        public String getVL_CRED_UTIL() {
            return VL_CRED_UTIL;
        }

        public void setVL_CRED_UTIL(String VL_CRED_UTIL) {
            this.VL_CRED_UTIL = VL_CRED_UTIL;
        }
    }

    class Registro1300 {

        private String REG;
        private String COD_ITEM;
        private String DT_FECH;
        private String ESTQ_ABERT;
        private String VOL_ENTR;
        private String VOL_DISP;
        private String VOL_SAIDAS;
        private String ESTQ_ESCR;
        private String VAL_AJ_PERDA;
        private String VAL_AJ_GANHO;
        private String FECH_FISICO;

        public String getCOD_ITEM() {
            return COD_ITEM;
        }

        public void setCOD_ITEM(String COD_ITEM) {
            this.COD_ITEM = COD_ITEM;
        }

        public String getDT_FECH() {
            return DT_FECH;
        }

        public void setDT_FECH(String DT_FECH) {
            this.DT_FECH = DT_FECH;
        }

        public String getESTQ_ABERT() {
            return ESTQ_ABERT;
        }

        public void setESTQ_ABERT(String ESTQ_ABERT) {
            this.ESTQ_ABERT = ESTQ_ABERT;
        }

        public String getESTQ_ESCR() {
            return ESTQ_ESCR;
        }

        public void setESTQ_ESCR(String ESTQ_ESCR) {
            this.ESTQ_ESCR = ESTQ_ESCR;
        }

        public String getFECH_FISICO() {
            return FECH_FISICO;
        }

        public void setFECH_FISICO(String FECH_FISICO) {
            this.FECH_FISICO = FECH_FISICO;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getVAL_AJ_GANHO() {
            return VAL_AJ_GANHO;
        }

        public void setVAL_AJ_GANHO(String VAL_AJ_GANHO) {
            this.VAL_AJ_GANHO = VAL_AJ_GANHO;
        }

        public String getVAL_AJ_PERDA() {
            return VAL_AJ_PERDA;
        }

        public void setVAL_AJ_PERDA(String VAL_AJ_PERDA) {
            this.VAL_AJ_PERDA = VAL_AJ_PERDA;
        }

        public String getVOL_DISP() {
            return VOL_DISP;
        }

        public void setVOL_DISP(String VOL_DISP) {
            this.VOL_DISP = VOL_DISP;
        }

        public String getVOL_ENTR() {
            return VOL_ENTR;
        }

        public void setVOL_ENTR(String VOL_ENTR) {
            this.VOL_ENTR = VOL_ENTR;
        }

        public String getVOL_SAIDAS() {
            return VOL_SAIDAS;
        }

        public void setVOL_SAIDAS(String VOL_SAIDAS) {
            this.VOL_SAIDAS = VOL_SAIDAS;
        }
    }

    class Registro1310 {

        private String REG;
        private String NUM_TANQUE;
        private String ESTQ_ABERT;
        private String VOL_ENTR;
        private String VOL_DISP;
        private String VOL_SAIDAS;
        private String ESTQ_ESCR;
        private String VA_AJ_PERDA;
        private String VAL_AJ_GANHO;
        private String FECH_FISICO;

        public String getESTQ_ABERT() {
            return ESTQ_ABERT;
        }

        public void setESTQ_ABERT(String ESTQ_ABERT) {
            this.ESTQ_ABERT = ESTQ_ABERT;
        }

        public String getESTQ_ESCR() {
            return ESTQ_ESCR;
        }

        public void setESTQ_ESCR(String ESTQ_ESCR) {
            this.ESTQ_ESCR = ESTQ_ESCR;
        }

        public String getFECH_FISICO() {
            return FECH_FISICO;
        }

        public void setFECH_FISICO(String FECH_FISICO) {
            this.FECH_FISICO = FECH_FISICO;
        }

        public String getNUM_TANQUE() {
            return NUM_TANQUE;
        }

        public void setNUM_TANQUE(String NUM_TANQUE) {
            this.NUM_TANQUE = NUM_TANQUE;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getVAL_AJ_GANHO() {
            return VAL_AJ_GANHO;
        }

        public void setVAL_AJ_GANHO(String VAL_AJ_GANHO) {
            this.VAL_AJ_GANHO = VAL_AJ_GANHO;
        }

        public String getVA_AJ_PERDA() {
            return VA_AJ_PERDA;
        }

        public void setVA_AJ_PERDA(String VA_AJ_PERDA) {
            this.VA_AJ_PERDA = VA_AJ_PERDA;
        }

        public String getVOL_DISP() {
            return VOL_DISP;
        }

        public void setVOL_DISP(String VOL_DISP) {
            this.VOL_DISP = VOL_DISP;
        }

        public String getVOL_ENTR() {
            return VOL_ENTR;
        }

        public void setVOL_ENTR(String VOL_ENTR) {
            this.VOL_ENTR = VOL_ENTR;
        }

        public String getVOL_SAIDAS() {
            return VOL_SAIDAS;
        }

        public void setVOL_SAIDAS(String VOL_SAIDAS) {
            this.VOL_SAIDAS = VOL_SAIDAS;
        }
    }

    class Registro1400 {

        private String REG;
        private String COD_ITEM;
        private String MUN;
        private String VALOR;

        public String getCOD_ITEM() {
            return COD_ITEM;
        }

        public void setCOD_ITEM(String COD_ITEM) {
            this.COD_ITEM = COD_ITEM;
        }

        public String getMUN() {
            return MUN;
        }

        public void setMUN(String MUN) {
            this.MUN = MUN;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getVALOR() {
            return VALOR;
        }

        public void setVALOR(String VALOR) {
            this.VALOR = VALOR;
        }
    }

    class Registro1500 {

        private String REG;
        private String IND_OPER;
        private String IND_EMIT;
        private String COD_PART;
        private String COD_MOD;
        private String COD_SIT;
        private String SER;
        private String SUB;
        private String COD_CONS;
        private String MUN_DOC;
        private String DT_DOC;
        private String DT_E_S;
        private String VL_DOC;
        private String VL_DESC;
        private String VL_FORN;
        private String VL_SERV_NT;
        private String VLR_TERC;
        private String VL_DA;
        private String VL_BC_ICMS;
        private String VL_ICMS;
        private String VL_BC_ICMS_ST;
        private String VL_ICMS_ST;
        private String VOD_INF;
        private String VL_PIS;
        private String VL_COFINS;
        private String TP_LIGACAO;
        private String COD_GRUPO_TENSAO;

        public String getCOD_CONS() {
            return COD_CONS;
        }

        public void setCOD_CONS(String COD_CONS) {
            this.COD_CONS = COD_CONS;
        }

        public String getCOD_GRUPO_TENSAO() {
            return COD_GRUPO_TENSAO;
        }

        public void setCOD_GRUPO_TENSAO(String COD_GRUPO_TENSAO) {
            this.COD_GRUPO_TENSAO = COD_GRUPO_TENSAO;
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

        public String getDT_E_S() {
            return DT_E_S;
        }

        public void setDT_E_S(String DT_E_S) {
            this.DT_E_S = DT_E_S;
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

        public String getMUN_DOC() {
            return MUN_DOC;
        }

        public void setMUN_DOC(String MUN_DOC) {
            this.MUN_DOC = MUN_DOC;
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

        public String getTP_LIGACAO() {
            return TP_LIGACAO;
        }

        public void setTP_LIGACAO(String TP_LIGACAO) {
            this.TP_LIGACAO = TP_LIGACAO;
        }

        public String getVLR_TERC() {
            return VLR_TERC;
        }

        public void setVLR_TERC(String VLR_TERC) {
            this.VLR_TERC = VLR_TERC;
        }

        public String getVL_BC_ICMS() {
            return VL_BC_ICMS;
        }

        public void setVL_BC_ICMS(String VL_BC_ICMS) {
            this.VL_BC_ICMS = VL_BC_ICMS;
        }

        public String getVL_BC_ICMS_ST() {
            return VL_BC_ICMS_ST;
        }

        public void setVL_BC_ICMS_ST(String VL_BC_ICMS_ST) {
            this.VL_BC_ICMS_ST = VL_BC_ICMS_ST;
        }

        public String getVL_COFINS() {
            return VL_COFINS;
        }

        public void setVL_COFINS(String VL_COFINS) {
            this.VL_COFINS = VL_COFINS;
        }

        public String getVL_DA() {
            return VL_DA;
        }

        public void setVL_DA(String VL_DA) {
            this.VL_DA = VL_DA;
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

        public String getVL_FORN() {
            return VL_FORN;
        }

        public void setVL_FORN(String VL_FORN) {
            this.VL_FORN = VL_FORN;
        }

        public String getVL_ICMS() {
            return VL_ICMS;
        }

        public void setVL_ICMS(String VL_ICMS) {
            this.VL_ICMS = VL_ICMS;
        }

        public String getVL_ICMS_ST() {
            return VL_ICMS_ST;
        }

        public void setVL_ICMS_ST(String VL_ICMS_ST) {
            this.VL_ICMS_ST = VL_ICMS_ST;
        }

        public String getVL_PIS() {
            return VL_PIS;
        }

        public void setVL_PIS(String VL_PIS) {
            this.VL_PIS = VL_PIS;
        }

        public String getVL_SERV_NT() {
            return VL_SERV_NT;
        }

        public void setVL_SERV_NT(String VL_SERV_NT) {
            this.VL_SERV_NT = VL_SERV_NT;
        }

        public String getVOD_INF() {
            return VOD_INF;
        }

        public void setVOD_INF(String VOD_INF) {
            this.VOD_INF = VOD_INF;
        }
    }

    class Registro1510 {

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
        private String VL_BC_ICMS_ST;
        private String ALIQ_ICMS_ST;
        private String VL_ICMS_ST;
        private String IND_REC;
        private String COD_PART;
        private String VL_PIS;
        private String VL_COFINS;
        private String COD_CTA;

        public String getALIQ_ICMS() {
            return ALIQ_ICMS;
        }

        public void setALIQ_ICMS(String ALIQ_ICMS) {
            this.ALIQ_ICMS = ALIQ_ICMS;
        }

        public String getALIQ_ICMS_ST() {
            return ALIQ_ICMS_ST;
        }

        public void setALIQ_ICMS_ST(String ALIQ_ICMS_ST) {
            this.ALIQ_ICMS_ST = ALIQ_ICMS_ST;
        }

        public String getCFOP() {
            return CFOP;
        }

        public void setCFOP(String CFOP) {
            this.CFOP = CFOP;
        }

        public String getCOD_CLASS() {
            return COD_CLASS;
        }

        public void setCOD_CLASS(String COD_CLASS) {
            this.COD_CLASS = COD_CLASS;
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

        public String getCST_ICMS() {
            return CST_ICMS;
        }

        public void setCST_ICMS(String CST_ICMS) {
            this.CST_ICMS = CST_ICMS;
        }

        public String getIND_REC() {
            return IND_REC;
        }

        public void setIND_REC(String IND_REC) {
            this.IND_REC = IND_REC;
        }

        public String getNUM_ITEM() {
            return NUM_ITEM;
        }

        public void setNUM_ITEM(String NUM_ITEM) {
            this.NUM_ITEM = NUM_ITEM;
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

        public String getUNID() {
            return UNID;
        }

        public void setUNID(String UNID) {
            this.UNID = UNID;
        }

        public String getVL_BC_ICMS() {
            return VL_BC_ICMS;
        }

        public void setVL_BC_ICMS(String VL_BC_ICMS) {
            this.VL_BC_ICMS = VL_BC_ICMS;
        }

        public String getVL_BC_ICMS_ST() {
            return VL_BC_ICMS_ST;
        }

        public void setVL_BC_ICMS_ST(String VL_BC_ICMS_ST) {
            this.VL_BC_ICMS_ST = VL_BC_ICMS_ST;
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

        public String getVL_ICMS() {
            return VL_ICMS;
        }

        public void setVL_ICMS(String VL_ICMS) {
            this.VL_ICMS = VL_ICMS;
        }

        public String getVL_ICMS_ST() {
            return VL_ICMS_ST;
        }

        public void setVL_ICMS_ST(String VL_ICMS_ST) {
            this.VL_ICMS_ST = VL_ICMS_ST;
        }

        public String getVL_ITEM() {
            return VL_ITEM;
        }

        public void setVL_ITEM(String VL_ITEM) {
            this.VL_ITEM = VL_ITEM;
        }

        public String getVL_PIS() {
            return VL_PIS;
        }

        public void setVL_PIS(String VL_PIS) {
            this.VL_PIS = VL_PIS;
        }
    }

    class Registro1600 {

        private String REG;
        private String COD_PART;
        private String TOT_CREDITO;
        private String TOT_DEBITO;

        public String getCOD_PART() {
            return COD_PART;
        }

        public void setCOD_PART(String COD_PART) {
            this.COD_PART = COD_PART;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getTOT_CREDITO() {
            return TOT_CREDITO;
        }

        public void setTOT_CREDITO(String TOT_CREDITO) {
            this.TOT_CREDITO = TOT_CREDITO;
        }

        public String getTOT_DEBITO() {
            return TOT_DEBITO;
        }

        public void setTOT_DEBITO(String TOT_DEBITO) {
            this.TOT_DEBITO = TOT_DEBITO;
        }
    }

    class Registro1700 {

        private String REG;
        private String COD_DISP;
        private String COD_MOD;
        private String SER;
        private String SUB;
        private String NUM_DOC_INI;
        private String NUM_DOC_FIN;
        private String NUM_AUT;

        public String getCOD_DISP() {
            return COD_DISP;
        }

        public void setCOD_DISP(String COD_DISP) {
            this.COD_DISP = COD_DISP;
        }

        public String getCOD_MOD() {
            return COD_MOD;
        }

        public void setCOD_MOD(String COD_MOD) {
            this.COD_MOD = COD_MOD;
        }

        public String getNUM_AUT() {
            return NUM_AUT;
        }

        public void setNUM_AUT(String NUM_AUT) {
            this.NUM_AUT = NUM_AUT;
        }

        public String getNUM_DOC_FIN() {
            return NUM_DOC_FIN;
        }

        public void setNUM_DOC_FIN(String NUM_DOC_FIN) {
            this.NUM_DOC_FIN = NUM_DOC_FIN;
        }

        public String getNUM_DOC_INI() {
            return NUM_DOC_INI;
        }

        public void setNUM_DOC_INI(String NUM_DOC_INI) {
            this.NUM_DOC_INI = NUM_DOC_INI;
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
    }

    class Registro1710 {

        private String REG;
        private String NUM_DOC_INI;
        private String NUM_DOC_FIN;

        public String getNUM_DOC_FIN() {
            return NUM_DOC_FIN;
        }

        public void setNUM_DOC_FIN(String NUM_DOC_FIN) {
            this.NUM_DOC_FIN = NUM_DOC_FIN;
        }

        public String getNUM_DOC_INI() {
            return NUM_DOC_INI;
        }

        public void setNUM_DOC_INI(String NUM_DOC_INI) {
            this.NUM_DOC_INI = NUM_DOC_INI;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }
    }

    class Registro1800 {

        private String REG;
        private String VL_CARGA;
        private String VL_PASS;
        private String VL_FAT;
        private String INT_RAT;
        private String VL_ICMS_ANT;
        private String VL_BC_ICMS;
        private String VL_ICMS_APUR;
        private String VL_BC_ICMS_APUR;
        private String VL_DIF;

        public String getINT_RAT() {
            return INT_RAT;
        }

        public void setINT_RAT(String INT_RAT) {
            this.INT_RAT = INT_RAT;
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

        public String getVL_BC_ICMS_APUR() {
            return VL_BC_ICMS_APUR;
        }

        public void setVL_BC_ICMS_APUR(String VL_BC_ICMS_APUR) {
            this.VL_BC_ICMS_APUR = VL_BC_ICMS_APUR;
        }

        public String getVL_CARGA() {
            return VL_CARGA;
        }

        public void setVL_CARGA(String VL_CARGA) {
            this.VL_CARGA = VL_CARGA;
        }

        public String getVL_DIF() {
            return VL_DIF;
        }

        public void setVL_DIF(String VL_DIF) {
            this.VL_DIF = VL_DIF;
        }

        public String getVL_FAT() {
            return VL_FAT;
        }

        public void setVL_FAT(String VL_FAT) {
            this.VL_FAT = VL_FAT;
        }

        public String getVL_ICMS_ANT() {
            return VL_ICMS_ANT;
        }

        public void setVL_ICMS_ANT(String VL_ICMS_ANT) {
            this.VL_ICMS_ANT = VL_ICMS_ANT;
        }

        public String getVL_ICMS_APUR() {
            return VL_ICMS_APUR;
        }

        public void setVL_ICMS_APUR(String VL_ICMS_APUR) {
            this.VL_ICMS_APUR = VL_ICMS_APUR;
        }

        public String getVL_PASS() {
            return VL_PASS;
        }

        public void setVL_PASS(String VL_PASS) {
            this.VL_PASS = VL_PASS;
        }
    }

    class Registro1900 {

        private String REG;
        private String IND_APUR_ICMS;
        private String DESCR_COMPL_OUT_APUR;
//

        public String getDESCR_COMPL_OUT_APUR() {
            return DESCR_COMPL_OUT_APUR;
        }

        public void setDESCR_COMPL_OUT_APUR(String DESCR_COMPL_OUT_APUR) {
            this.DESCR_COMPL_OUT_APUR = DESCR_COMPL_OUT_APUR;
        }

        public String getIND_APUR_ICMS() {
            return IND_APUR_ICMS;
        }

        public void setIND_APUR_ICMS(String IND_APUR_ICMS) {
            this.IND_APUR_ICMS = IND_APUR_ICMS;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }
    }

    class Registro1910 {

        private String REG;
        private String DT_INI;
        private String DT_FIN;
//

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

    class Registro1920 {

        private String REG;
        private String VL_TOT_TRANSF_DEBITOS_OA;
        private String VL_TOT_AJ_DEBITOS_OA;
        private String VL_ESTORNOS_CRED_OA;
        private String VL_TOT_AJ_CREDITOS_OA;
        private String VL_SLD_CREDOR_ANT_OA;
        private String VL_SLD_APURADO_OA;
        private String VL_TOT_DED;
        private String VL_ICMS_RECOLHER_OA;
        private String VL_SLD_CREDOR_TRANSP_OA;
        private String DEB_ESP_OA;
//

        public String getDEB_ESP_OA() {
            return DEB_ESP_OA;
        }

        public void setDEB_ESP_OA(String DEB_ESP_OA) {
            this.DEB_ESP_OA = DEB_ESP_OA;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getVL_ESTORNOS_CRED_OA() {
            return VL_ESTORNOS_CRED_OA;
        }

        public void setVL_ESTORNOS_CRED_OA(String VL_ESTORNOS_CRED_OA) {
            this.VL_ESTORNOS_CRED_OA = VL_ESTORNOS_CRED_OA;
        }

        public String getVL_ICMS_RECOLHER_OA() {
            return VL_ICMS_RECOLHER_OA;
        }

        public void setVL_ICMS_RECOLHER_OA(String VL_ICMS_RECOLHER_OA) {
            this.VL_ICMS_RECOLHER_OA = VL_ICMS_RECOLHER_OA;
        }

        public String getVL_SLD_APURADO_OA() {
            return VL_SLD_APURADO_OA;
        }

        public void setVL_SLD_APURADO_OA(String VL_SLD_APURADO_OA) {
            this.VL_SLD_APURADO_OA = VL_SLD_APURADO_OA;
        }

        public String getVL_SLD_CREDOR_ANT_OA() {
            return VL_SLD_CREDOR_ANT_OA;
        }

        public void setVL_SLD_CREDOR_ANT_OA(String VL_SLD_CREDOR_ANT_OA) {
            this.VL_SLD_CREDOR_ANT_OA = VL_SLD_CREDOR_ANT_OA;
        }

        public String getVL_SLD_CREDOR_TRANSP_OA() {
            return VL_SLD_CREDOR_TRANSP_OA;
        }

        public void setVL_SLD_CREDOR_TRANSP_OA(String VL_SLD_CREDOR_TRANSP_OA) {
            this.VL_SLD_CREDOR_TRANSP_OA = VL_SLD_CREDOR_TRANSP_OA;
        }

        public String getVL_TOT_AJ_CREDITOS_OA() {
            return VL_TOT_AJ_CREDITOS_OA;
        }

        public void setVL_TOT_AJ_CREDITOS_OA(String VL_TOT_AJ_CREDITOS_OA) {
            this.VL_TOT_AJ_CREDITOS_OA = VL_TOT_AJ_CREDITOS_OA;
        }

        public String getVL_TOT_AJ_DEBITOS_OA() {
            return VL_TOT_AJ_DEBITOS_OA;
        }

        public void setVL_TOT_AJ_DEBITOS_OA(String VL_TOT_AJ_DEBITOS_OA) {
            this.VL_TOT_AJ_DEBITOS_OA = VL_TOT_AJ_DEBITOS_OA;
        }

        public String getVL_TOT_DED() {
            return VL_TOT_DED;
        }

        public void setVL_TOT_DED(String VL_TOT_DED) {
            this.VL_TOT_DED = VL_TOT_DED;
        }

        public String getVL_TOT_TRANSF_DEBITOS_OA() {
            return VL_TOT_TRANSF_DEBITOS_OA;
        }

        public void setVL_TOT_TRANSF_DEBITOS_OA(String VL_TOT_TRANSF_DEBITOS_OA) {
            this.VL_TOT_TRANSF_DEBITOS_OA = VL_TOT_TRANSF_DEBITOS_OA;
        }
    }

    class Registro1921 {

        private String REG;
        private String COD_AJ_APUR;
        private String DESCR_COMPL_AJ;
        private String VL_AJ_APUR;
//

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

    class Registro1922 {

        private String REG;
        private String NUM_DA;
        private String NUM_PROC;
        private String IND_PROC;
        private String PROC;
        private String TXT_COMPL;

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

    class Registro1923 {

        private String REG;
        private String COD_PART;
        private String COD_MOD;
        private String SER;
        private String SUB;
        private String NUM_DOC;
        private String DT_DOC;
        private String COD_ITEM;
        private String VL_AJ_ITEM;

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

    class Registro1925 {

        private String REG;
        private String COD_INF_ADIC;
        private String VL_INF_ADIC;
        private String DESCR_COMPL_AJ;

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

    class Registro1926 {

        private String REG;
        private String COD_OR;
        private String VL_OR;
        private String DT_VCTO;
        private String COD_REC;
        private String NUM_PROC;
        private String IND_PROC;
        private String PROC;
        private String TCT_COMPL;
        private String MES_REF;

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

        public String getTCT_COMPL() {
            return TCT_COMPL;
        }

        public void setTCT_COMPL(String TCT_COMPL) {
            this.TCT_COMPL = TCT_COMPL;
        }

        public String getVL_OR() {
            return VL_OR;
        }

        public void setVL_OR(String VL_OR) {
            this.VL_OR = VL_OR;
        }
    }

    class Registro1990 {

        private String REG;
        private String QTD_LIN_1;

        public String getQTD_LIN_1() {
            return QTD_LIN_1;
        }

        public void setQTD_LIN_1(String QTD_LIN_1) {
            this.QTD_LIN_1 = QTD_LIN_1;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }
    }

    class Registro9001 {

        private String REG;
        private String IND_MOV;

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

    class Registro9900 {

        private String REG;
        private String REG_BLC;
        private String QTD_REG_BLC;

        public String getQTD_REG_BLC() {
            return QTD_REG_BLC;
        }

        public void setQTD_REG_BLC(String QTD_REG_BLC) {
            this.QTD_REG_BLC = QTD_REG_BLC;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }

        public String getREG_BLC() {
            return REG_BLC;
        }

        public void setREG_BLC(String REG_BLC) {
            this.REG_BLC = REG_BLC;
        }
    }

    class Registro9990 {

        private String REG;
        private String QTD_LIN_9;

        public String getQTD_LIN_9() {
            return QTD_LIN_9;
        }

        public void setQTD_LIN_9(String QTD_LIN_9) {
            this.QTD_LIN_9 = QTD_LIN_9;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }
    }

    class Registro9999 {

        private String REG;
        private String QTD_LIN;

        public String getQTD_LIN() {
            return QTD_LIN;
        }

        public void setQTD_LIN(String QTD_LIN) {
            this.QTD_LIN = QTD_LIN;
        }

        public String getREG() {
            return REG;
        }

        public void setREG(String REG) {
            this.REG = REG;
        }
    }
}