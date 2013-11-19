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
class BlocoC {

    private RegistroC010 registrosC010 = new RegistroC010();
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;

    public BlocoC() {
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

            conteudo.append(registrosC010.gerarRegistro());

            return conteudo;
        } catch (Exception e) {
            Logger.getLogger(Bloco0.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}

/*
 * @author
 *
 * @param
 *
 * @version
 * Registro de Abertura do arquivo
 * Obrigatorio a todos
 */
class RegistroC001 {
//Texto fixo contendo "C001"

    private String REG;
//Indicador de movimento:
//0- Bloco com dados informados;
//1- Bloco sem dados informa
    private String IND_MOV;
    private List<RegistroC010> registroC010 = new ArrayList<RegistroC010>();
    
    RegistroC001 registroC001 = new RegistroC001();
    List<RegistroC001> registrosC001 = new ArrayList<RegistroC001>();
    
    protected List<RegistroC001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC001 = new RegistroC001();                
                registroC001.setIND_MOV(RS.getString(""));
                
                registrosC001.add(registroC001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC001;
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
class RegistroC010 {
    //Texto fixo contendo “C010”.

    private String REG;
    //Número de inscrição do estabelecimento no CNPJ.
    private String CNPJ;
    //Indicador da apuração das contribuições e créditos, na
//    escrituração das operações por NF-e e ECF, no período:
//    1 – Apuração com base nos registros de consolidação das operações por NF-e (C180 e C190) e por ECF (C490);
//    2 – Apuração com base no registro individualizado de NF-e (C100 e C170) e de ECF (C400)
    private String IND_ESCRI;
    private List<RegistroC100> registroC100 = new ArrayList<RegistroC100>();
    private StringBuilder conteudo;

    RegistroC010 registroC010 = new RegistroC010();
    List<RegistroC010> registrosC010 = new ArrayList<RegistroC010>();
    
    protected List<RegistroC010> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC010 = new RegistroC010();
                registroC010.setCNPJ(RS.getString(""));
                registroC010.setIND_ESCRI(RS.getString(""));
                
                registrosC010.add(registroC010);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC010.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC010;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C010").append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_ESCRI(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC010.class.getName()).log(Level.SEVERE, null, e);
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

    public String getIND_ESCRI() {
        return IND_ESCRI;
    }

    public void setIND_ESCRI(String IND_ESCRI) {
        this.IND_ESCRI = IND_ESCRI;
    }
}

class RegistroC100 {

    private String REG;
    private String IND_OPER;
    private String IND_EMIT;
    private String COD_PART;
    private String COD_MOD;
    private String COD_SIT;
    private String SER;
    private String NUM_DOC;
    private String CHV_NFE;
    private String DT_DOC;
    private String DT_E_S;
    private String VL_DOC;
    private String IND_PGTO;
    private String VL_DESC;
    private String VL_ABAT_NT;
    private String VL_MERC;
    private String IND_FRT;
    private String VL_FRT;
    private String VL_SEG;
    private String VL_OUT_DA;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String VL_IPI;
    private String VL_PIS;
    private String VL_COFINS;
    private String VL_PIS_ST;
    private String VL_COFINS_ST;
    private List<RegistroC110> registroC110 = new ArrayList<RegistroC110>();
    private List<RegistroC111> registroC111 = new ArrayList<RegistroC111>();
    private List<RegistroC120> registroC120 = new ArrayList<RegistroC120>();
    private List<RegistroC170> registroC170 = new ArrayList<RegistroC170>();
    private StringBuilder conteudo;

    RegistroC100 registroC100 = new RegistroC100();
    List<RegistroC100> registrosC100 = new ArrayList<RegistroC100>();
    
    protected List<RegistroC100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC100 = new RegistroC100();                
                registroC100.setIND_OPER(RS.getString(""));
                registroC100.setIND_EMIT(RS.getString(""));
                registroC100.setCOD_PART(RS.getString(""));
                registroC100.setCOD_MOD(RS.getString(""));
                registroC100.setCOD_SIT(RS.getString(""));
                registroC100.setSER(RS.getString(""));                
                registroC100.setNUM_DOC(RS.getString(""));
                registroC100.setCHV_NFE(RS.getString(""));
                registroC100.setDT_DOC(RS.getString(""));
                registroC100.setDT_E_S(RS.getString(""));
                registroC100.setVL_DOC(RS.getString(""));                
                registroC100.setIND_PGTO(RS.getString(""));
                registroC100.setVL_DESC(RS.getString(""));                
                registroC100.setVL_ABAT_NT(RS.getString(""));
                registroC100.setVL_MERC(RS.getString(""));
                registroC100.setIND_FRT(RS.getString(""));
                registroC100.setVL_FRT(RS.getString(""));                
                registroC100.setVL_SEG(RS.getString(""));
                registroC100.setVL_OUT_DA(RS.getString(""));
                registroC100.setVL_BC_ICMS(RS.getString(""));
                registroC100.setVL_ICMS(RS.getString(""));                
                registroC100.setVL_BC_ICMS_ST(RS.getString(""));
                registroC100.setVL_ICMS_ST(RS.getString(""));
                registroC100.setVL_IPI(RS.getString(""));
                registroC100.setVL_PIS(RS.getString(""));                
                registroC100.setVL_COFINS(RS.getString(""));
                registroC100.setVL_PIS_ST(RS.getString(""));
                registroC100.setVL_COFINS_ST(RS.getString(""));               
                
                
                registrosC100.add(registroC100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC100;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C100").append("|");
            conteudo.append(geral.efdNumerico(getIND_OPER(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_EMIT(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_SIT(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC(), 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCHV_NFE(), 44)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_E_S())).append("|");
            conteudo.append(geral.efdNumerico(getVL_DOC(), 10)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PGTO(), 1)).append("|");
            conteudo.append(geral.efdNumerico(getVL_DESC(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_ABAT_NT(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_MERC(), 10)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_FRT(), 1)).append("|");
            conteudo.append(geral.efdNumerico(getVL_FRT(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_SEG(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_OUT_DA(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_BC_ICMS(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_ICMS(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_BC_ICMS_ST(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_ICMS_ST(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_IPI(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_PIS(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_PIS_ST(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS_ST(), 10)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC100.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

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

    public String getIND_PGTO() {
        return IND_PGTO;
    }

    public void setIND_PGTO(String IND_PGTO) {
        this.IND_PGTO = IND_PGTO;
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

    public String getVL_ABAT_NT() {
        return VL_ABAT_NT;
    }

    public void setVL_ABAT_NT(String VL_ABAT_NT) {
        this.VL_ABAT_NT = VL_ABAT_NT;
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

    public String getVL_COFINS_ST() {
        return VL_COFINS_ST;
    }

    public void setVL_COFINS_ST(String VL_COFINS_ST) {
        this.VL_COFINS_ST = VL_COFINS_ST;
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

    public String getVL_FRT() {
        return VL_FRT;
    }

    public void setVL_FRT(String VL_FRT) {
        this.VL_FRT = VL_FRT;
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

    public String getVL_IPI() {
        return VL_IPI;
    }

    public void setVL_IPI(String VL_IPI) {
        this.VL_IPI = VL_IPI;
    }

    public String getVL_MERC() {
        return VL_MERC;
    }

    public void setVL_MERC(String VL_MERC) {
        this.VL_MERC = VL_MERC;
    }

    public String getVL_OUT_DA() {
        return VL_OUT_DA;
    }

    public void setVL_OUT_DA(String VL_OUT_DA) {
        this.VL_OUT_DA = VL_OUT_DA;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getVL_PIS_ST() {
        return VL_PIS_ST;
    }

    public void setVL_PIS_ST(String VL_PIS_ST) {
        this.VL_PIS_ST = VL_PIS_ST;
    }

    public String getVL_SEG() {
        return VL_SEG;
    }

    public void setVL_SEG(String VL_SEG) {
        this.VL_SEG = VL_SEG;
    }
}

class RegistroC110 {
//Texto fixo contendo "C110"

    private String REG;
//Código da informação complementar do documento fiscal (campo 02 do Registro 0450)
    private String COD_INF;
//Descrição complementar do código de referência.
    private String TXT_COMPL;
    private List<RegistroC111> registroC111 = new ArrayList<RegistroC111>();
    private StringBuilder conteudo;

    RegistroC110 registroC110 = new RegistroC110();
    List<RegistroC110> registrosC110 = new ArrayList<RegistroC110>();
    
    protected List<RegistroC110> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC110 = new RegistroC110();                
                registroC110.setCOD_INF(RS.getString(""));    
                registroC110.setTXT_COMPL(RS.getString(""));
                
                
                registrosC110.add(registroC110);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC110.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC110;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C110").append("|");
            conteudo.append(geral.efdNumerico(getCOD_INF(), 6)).append("|");
            conteudo.append(geral.efdAlfanumerico(getTXT_COMPL())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC110.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_INF() {
        return COD_INF;
    }

    public void setCOD_INF(String COD_INF) {
        this.COD_INF = COD_INF;
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

class RegistroC111 {
//Texto fixo contendo "C111"

    private String REG;
//Identificação do processo ou ato concessório.
    private String NUM_PROC;
//Indicador da origem do processo: 0 - SEFAZ;
//1 - Justiça Federal;
//2 - Justiça Estadual;
//3 - SECEX/SRF 
//9 - Outros.    
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC111 registroC111 = new RegistroC111();
    List<RegistroC111> registrosC111 = new ArrayList<RegistroC111>();
    
    protected List<RegistroC111> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC111 = new RegistroC111();                
                registroC111.setNUM_PROC(RS.getString(""));    
                registroC111.setIND_PROC(RS.getString(""));
                
                
                registrosC111.add(registroC111);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC111.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC111;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C111").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC111.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getIND_PROC() {
        return IND_PROC;
    }

    public void setIND_PROC(String IND_PROC) {
        this.IND_PROC = IND_PROC;
    }

    public String getNUM_PROC() {
        return NUM_PROC;
    }

    public void setNUM_PROC(String NUM_PROC) {
        this.NUM_PROC = NUM_PROC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC120 {

    private String REG;
    private String COD_DOC_IMP;
    private String NUM_DOC_IMP;
    private String VL_PIS_IMP;
    private String VL_COFINS_IMP;
    private String NUM_ACDRAW;
    private StringBuilder conteudo;

    RegistroC120 registroC120 = new RegistroC120();
    List<RegistroC120> registrosC120 = new ArrayList<RegistroC120>();
    
    protected List<RegistroC120> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC120 = new RegistroC120();                
                registroC120.setCOD_DOC_IMP(RS.getString(""));    
                registroC120.setNUM_DOC_IMP(RS.getString(""));
                
                registroC120.setVL_PIS_IMP(RS.getString(""));    
                registroC120.setVL_COFINS_IMP(RS.getString(""));
                registroC120.setNUM_ACDRAW(RS.getString(""));
                
                registrosC120.add(registroC120);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC120.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC120;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C120").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_DOC_IMP(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC_IMP(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_PIS_IMP(), 10)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS_IMP(), 10)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_ACDRAW(), 20)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC120.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_DOC_IMP() {
        return COD_DOC_IMP;
    }

    public void setCOD_DOC_IMP(String COD_DOC_IMP) {
        this.COD_DOC_IMP = COD_DOC_IMP;
    }

    public String getNUM_ACDRAW() {
        return NUM_ACDRAW;
    }

    public void setNUM_ACDRAW(String NUM_ACDRAW) {
        this.NUM_ACDRAW = NUM_ACDRAW;
    }

    public String getNUM_DOC_IMP() {
        return NUM_DOC_IMP;
    }

    public void setNUM_DOC_IMP(String NUM_DOC__IMP) {
        this.NUM_DOC_IMP = NUM_DOC__IMP;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_PIS_IMP() {
        return VL_PIS_IMP;
    }

    public void setVL_PIS_IMP(String VL_PIS_IMP) {
        this.VL_PIS_IMP = VL_PIS_IMP;
    }

    public String getVL_COFINS_IMP() {
        return VL_COFINS_IMP;
    }

    public void setVL_COFINS_IMP(String VL_COFINS_IMP) {
        this.VL_COFINS_IMP = VL_COFINS_IMP;
    }
}

class RegistroC170 {

    //Texto fixo contendo "C170"
    private String REG;
    //Número seqüencial do item no documento fiscal
    private String NUM_ITEM;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Descrição complementar do item como adotado no documento fiscal
    private String DESCR_COMPL;
    //Quantidade do item
    private String QTD;
    //Unidade do item (Campo 02 do registro 0190)
    private String UNID;
    //Valor total do item (mercadorias ou serviços)
    private String VL_ITEM;
    //Valor do desconto comercial
    private String VL_DESC;
    /*Movimentação física do ITEM/PRODUTO:
    0. SIM
    1. NÃO*/
    private String IND_MOV;
    /*Código da Situação Tributária referente ao ICMS, conforme a
    Tabela indicada no item 4.3.1*/
    private String CST_ICMS;
    //Código Fiscal de Operação e Prestação
    private String CFOP;
    //Código da natureza da operação (campo 02 do Registro 0400)
    private String COD_NAT;
    //Valor da base de cálculo do ICMS
    private String VL_BC_ICMS;
    //Alíquota do ICMS
    private String ALIQ_ICMS;
    //Valor do ICMS creditado/debitado
    private String VL_ICMS;
    //Valor da base de cálculo referente à substituição tributária
    private String VL_BC_ICMS_ST;
    //Alíquota do ICMS da substituição tributária na unidade da federação de destino
    private String ALIQ_ST;
    //Valor do ICMS referente à substituição tributária
    private String VL_ICMS_ST;
    /*Indicador de período de apuração do IPI:
    0 - Mensal;
    1 Decendial*/
    private String IND_APUR;
    //Código da Situação Tributária referente ao IPI, conforme a Tabela indicada no item 4.3.2.
    private String CST_IPI;
    /*Código de enquadramento legal do IPI, conforme tabela indicada
    no item 4.5.3.*/
    private String COD_ENQ;
    //Valor da base de cálculo do IPI
    private String VL_BC_IPI;
    //Alíquota do IPI
    private String ALIQ_IPI;
    //Valor do IPI creditado/debitado
    private String VL_IPI;
    //Código da Situação Tributária referente ao PIS.
    private String CST_PIS;
    //Valor da base de cálculo do PIS
    private String VL_BC_PIS;
    //Alíquota do PIS (em percentual)
    private String ALIQ_PIS;
    //Quantidade – Base de cálculo PIS/PASEP
    private String QUANT_BC_PIS;
    //Alíquota do PIS (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor do PIS
    private String VL_PIS;
    //Código da Situação Tributária referente ao COFINS
    private String CST_COFINS;
    //Valor da base de cálculo da COFINS
    private String VL_BC_COFINS;
    //Alíquota do COFINS (em percentual)
    private String ALIQ_COFINS;
    //Quantidade – Base de cálculo COFINS
    private String QUANT_BC_COFINS;
    //Alíquota da COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC170 registroC170 = new RegistroC170();
    List<RegistroC170> registrosC170 = new ArrayList<RegistroC170>();
    
    protected List<RegistroC170> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC170 = new RegistroC170();                
                registroC170.setNUM_ITEM(RS.getString(""));    
                registroC170.setCOD_ITEM(RS.getString(""));                
                registroC170.setDESCR_COMPL(RS.getString(""));    
                registroC170.setQTD(RS.getString(""));                
                registroC170.setUNID(RS.getString(""));    
                registroC170.setVL_ITEM(RS.getString(""));                
                registroC170.setVL_DESC(RS.getString(""));    
                registroC170.setIND_MOV(RS.getString(""));                
                registroC170.setCST_ICMS(RS.getString(""));                
                registroC170.setCFOP(RS.getString(""));    
                registroC170.setCOD_NAT(RS.getString(""));
                registroC170.setVL_BC_ICMS(RS.getString(""));                
                registroC170.setALIQ_ICMS(RS.getString(""));    
                registroC170.setVL_ICMS(RS.getString(""));                
                registroC170.setVL_BC_ICMS_ST(RS.getString(""));                
                registroC170.setALIQ_ST(RS.getString(""));    
                registroC170.setVL_ICMS_ST(RS.getString(""));
                registroC170.setIND_APUR(RS.getString(""));                
                registroC170.setCST_IPI(RS.getString(""));    
                registroC170.setCOD_ENQ(RS.getString(""));                
                registroC170.setVL_BC_IPI(RS.getString(""));                
                registroC170.setALIQ_IPI(RS.getString(""));    
                registroC170.setVL_IPI(RS.getString(""));
                registroC170.setCST_PIS(RS.getString(""));                
                registroC170.setVL_BC_PIS(RS.getString(""));    
                registroC170.setALIQ_PIS(RS.getString(""));                
                registroC170.setQUANT_BC_PIS(RS.getString(""));               
                registroC170.setALIQ_PIS_QUANT(RS.getString(""));    
                registroC170.setVL_PIS(RS.getString(""));
                registroC170.setCST_COFINS(RS.getString(""));                
                registroC170.setVL_BC_COFINS(RS.getString(""));    
                registroC170.setALIQ_COFINS(RS.getString(""));                
                registroC170.setQUANT_BC_COFINS(RS.getString(""));                
                registroC170.setALIQ_COFINS_QUANT(RS.getString(""));    
                registroC170.setVL_COFINS(RS.getString(""));
                registroC170.setCOD_CTA(RS.getString(""));
                                
                registrosC170.add(registroC170);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC170.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC170;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C170").append("|");
            conteudo.append(geral.efdNumerico(getNUM_ITEM(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDESCR_COMPL())).append("|");
            conteudo.append(geral.efdRemoveSinais(getQTD())).append("|");
            conteudo.append(geral.efdNumerico(getUNID(), 6)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_MOV(), 1)).append("|");

            conteudo.append(geral.efdNumerico(getCST_ICMS(), 3)).append("|");
            conteudo.append(geral.efdNumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_NAT(), 10)).append("|");

            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_ICMS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_ICMS_ST()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_ST(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS_ST()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getIND_APUR(), 1)).append("|");
            conteudo.append(geral.efdNumerico(getCST_IPI(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_ENQ(), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_IPI()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_IPI(), 6)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_IPI()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_PIS(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getQUANT_BC_PIS(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_PIS_QUANT(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_COFINS(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getQUANT_BC_COFINS(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_COFINS_QUANT(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_COFINS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");


            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC170.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getALIQ_IPI() {
        return ALIQ_IPI;
    }

    public void setALIQ_IPI(String ALIQ_IPI) {
        this.ALIQ_IPI = ALIQ_IPI;
    }

    public String getALIQ_PIS() {
        return ALIQ_PIS;
    }

    public void setALIQ_PIS(String ALIQ_PIS) {
        this.ALIQ_PIS = ALIQ_PIS;
    }

    public String getALIQ_ST() {
        return ALIQ_ST;
    }

    public void setALIQ_ST(String ALIQ_ST) {
        this.ALIQ_ST = ALIQ_ST;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_ENQ() {
        return COD_ENQ;
    }

    public void setCOD_ENQ(String COD_ENQ) {
        this.COD_ENQ = COD_ENQ;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_NAT() {
        return COD_NAT;
    }

    public void setCOD_NAT(String COD_NAT) {
        this.COD_NAT = COD_NAT;
    }

    public String getCST_COFINS() {
        return CST_COFINS;
    }

    public void setCST_COFINS(String CST_COFINS) {
        this.CST_COFINS = CST_COFINS;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getCST_IPI() {
        return CST_IPI;
    }

    public void setCST_IPI(String CST_IPI) {
        this.CST_IPI = CST_IPI;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getDESCR_COMPL() {
        return DESCR_COMPL;
    }

    public void setDESCR_COMPL(String DESCR_COMPL) {
        this.DESCR_COMPL = DESCR_COMPL;
    }

    public String getIND_APUR() {
        return IND_APUR;
    }

    public void setIND_APUR(String IND_APUR) {
        this.IND_APUR = IND_APUR;
    }

    public String getIND_MOV() {
        return IND_MOV;
    }

    public void setIND_MOV(String IND_MOV) {
        this.IND_MOV = IND_MOV;
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

    public String getQUANT_BC_PIS() {
        return QUANT_BC_PIS;
    }

    public void setQUANT_BC_PIS(String QUANT_BC_PIS) {
        this.QUANT_BC_PIS = QUANT_BC_PIS;
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

    public String getVL_BC_COFINS() {
        return VL_BC_COFINS;
    }

    public void setVL_BC_COFINS(String VL_BC_COFINS) {
        this.VL_BC_COFINS = VL_BC_COFINS;
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

    public String getVL_BC_IPI() {
        return VL_BC_IPI;
    }

    public void setVL_BC_IPI(String VL_BC_IPI) {
        this.VL_BC_IPI = VL_BC_IPI;
    }

    public String getVL_BC_PIS() {
        return VL_BC_PIS;
    }

    public void setVL_BC_PIS(String VL_BC_PIS) {
        this.VL_BC_PIS = VL_BC_PIS;
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

    public String getVL_IPI() {
        return VL_IPI;
    }

    public void setVL_IPI(String VL_IPI) {
        this.VL_IPI = VL_IPI;
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

    public String getALIQ_PIS_QUANT() {
        return ALIQ_PIS_QUANT;
    }

    public void setALIQ_PIS_QUANT(String ALIQ_PIS_QUANT) {
        this.ALIQ_PIS_QUANT = ALIQ_PIS_QUANT;
    }
}

class RegistroC180 {
    //Texto fixo contendo "C180”

    private String REG;
    //Texto fixo contendo "55" (Código da Nota Fiscal Eletrônica,modelo 55, conforme a Tabela 4.1.1)
    private String COD_MOD;
    //Data de Emissão Inicial dos Documentos
    private String DT_DOC_INI;
    //Data de Emissão Final dos Documentos
    private String DT_DOC_FIN;
    //Código do Item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código da Nomenclatura Comum do Mercosul
    private String COD_NCM;
    //Código EX, conforme a TIPI
    private String EX_IPI;
    //Valor Total do Item
    private String VL_TOT_ITEM;
    private List<RegistroC181> registroC181 = new ArrayList<RegistroC181>();
    private List<RegistroC185> registroC185 = new ArrayList<RegistroC185>();
    private List<RegistroC188> registroC188 = new ArrayList<RegistroC188>();
    private StringBuilder conteudo;

    RegistroC180 registroC180 = new RegistroC180();
    List<RegistroC180> registrosC180 = new ArrayList<RegistroC180>();
    
    protected List<RegistroC180> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC180 = new RegistroC180();                
                registroC180.setCOD_MOD(RS.getString(""));    
                registroC180.setCOD_ITEM(RS.getString(""));                
                registroC180.setDT_DOC_INI(RS.getString(""));    
                registroC180.setDT_DOC_FIN(RS.getString(""));                
                registroC180.setCOD_ITEM(RS.getString(""));    
                registroC180.setCOD_NCM(RS.getString(""));                
                registroC180.setEX_IPI(RS.getString(""));    
                registroC180.setVL_TOT_ITEM(RS.getString(""));                                             
                                
                registrosC180.add(registroC180);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC180.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC180;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C180").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC_FIN())).append("|");
            conteudo.append(geral.efdNumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_NCM(), 8)).append("|");
            conteudo.append(geral.efdNumerico(getEX_IPI(), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_ITEM()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC180.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_NCM() {
        return COD_NCM;
    }

    public void setCOD_NCM(String COD_NCM) {
        this.COD_NCM = COD_NCM;
    }

    public String getEX_IPI() {
        return EX_IPI;
    }

    public void setEX_IPI(String EX_IPI) {
        this.EX_IPI = EX_IPI;
    }

    public String getVL_TOT_ITEM() {
        return VL_TOT_ITEM;
    }

    public void setVL_TOT_ITEM(String VL_TOT_ITEM) {
        this.VL_TOT_ITEM = VL_TOT_ITEM;
    }
}
//DETALHAMENTO DA CONSOLIDAÇÃO – OPERAÇÕES DE VENDAS– PIS/PASEP
class RegistroC181 {
    //Texto fixo contendo "C181”

    private String REG;
    //Código da Situação Tributária referente ao PIS/PASEP, conforme a Tabela indicada no item 4.3.3.
    private String CST_PIS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor do item
    private String VL_ITEM;
    //Valor do desconto comercial / Exclusão
    private String VL_DESC;
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
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC181 registroC181 = new RegistroC181();
    List<RegistroC181> registrosC181 = new ArrayList<RegistroC181>();
    
    protected List<RegistroC181> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC181 = new RegistroC181();                
                registroC181.setCST_PIS(RS.getString(""));    
                registroC181.setCFOP(RS.getString(""));                
                registroC181.setVL_ITEM(RS.getString(""));    
                registroC181.setVL_DESC(RS.getString(""));                
                registroC181.setVL_BC_PIS(RS.getString(""));    
                registroC181.setALIQ_PIS(RS.getString(""));                
                registroC181.setQUANT_BC_PIS(RS.getString(""));    
                registroC181.setALIQ_PIS_QUANT(RS.getString(""));                                             
                registroC181.setVL_PIS(RS.getString(""));                                             
                registroC181.setCOD_CTA(RS.getString(""));
                                
                registrosC181.add(registroC181);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC181.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC181;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C181").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCFOP())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC181.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

//DETALHAMENTO DA CONSOLIDAÇÃO – OPERAÇÕES DE VENDAS– COFINS
class RegistroC185 {
    //Texto fixo contendo "C185”

    private String REG;
    //Código da Situação Tributária referente a COFINS, conforme a Tabela indicada no item 4.3.4.
    private String CST_COFINS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor do item
    private String VL_ITEM;
    //Valor do desconto comercial / Exclusão N -
    private String VL_DESC;
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

    RegistroC185 registroC185 = new RegistroC185();
    List<RegistroC185> registrosC185 = new ArrayList<RegistroC185>();
    
    protected List<RegistroC185> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC185 = new RegistroC185();                
                registroC185.setCST_COFINS(RS.getString(""));    
                registroC185.setCFOP(RS.getString(""));                
                registroC185.setVL_ITEM(RS.getString(""));    
                registroC185.setVL_DESC(RS.getString(""));                
                registroC185.setVL_BC_COFINS(RS.getString(""));    
                registroC185.setALIQ_COFINS(RS.getString(""));                
                registroC185.setQUANT_BC_COFINS(RS.getString(""));    
                registroC185.setALIQ_COFINS_QUANT(RS.getString(""));                                             
                registroC185.setVL_COFINS(RS.getString(""));                                             
                registroC185.setCOD_CTA(RS.getString(""));
                                
                registrosC185.add(registroC185);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC181.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC185;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C185").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCFOP())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC185.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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
//PROCESSO REFERENCIADO
class RegistroC188 {
    //Texto fixo contendo "C188"

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
//    1 - Justiça Federal;
//    3 - Secretaria da Receita Federal do Brasil;
//    9 – Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC188 registroC188 = new RegistroC188();
    List<RegistroC188> registrosC188 = new ArrayList<RegistroC188>();
    
    protected List<RegistroC188> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC188 = new RegistroC188();                
                registroC188.setNUM_PROC(RS.getString(""));    
                registroC188.setIND_PROC(RS.getString(""));                                
                                
                registrosC188.add(registroC188);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC188.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC188;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C188").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC188.class.getName()).log(Level.SEVERE, null, e);
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
//CONSOLIDAÇÃO DE NOTAS FISCAIS ELETRÔNICAS (CÓDIGO 55) – OPERAÇÕES DE AQUISIÇÃO COM DIREITO A CRÉDITO, E OPERAÇÕES DE DEVOLUÇÃO DE COMPRAS E VENDAS.
class RegistroC190 {
    //Texto fixo contendo "C190”

    private String REG;
    //Texto fixo contendo "55" (Código da Nota Fiscal Eletrônica,modelo 55, conforme a Tabela 4.1.1)
    private String COD_MOD;
    //Data Inicial de Referência da Consolidação
    private String DT_REF_INI;
    //Data Final de Referência da Consolidação
    private String DT_REF_FIN;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código da Nomenclatura Comum do Mercosul
    private String COD_NCM;
    //Código EX, conforme a TIPI
    private String EX_IPI;
    //Valor Total do Item
    private String VL_TOT_ITEM;
    private List<RegistroC191> registroC191 = new ArrayList<RegistroC191>();
    private List<RegistroC195> registroC195 = new ArrayList<RegistroC195>();
    private List<RegistroC198> registroC198 = new ArrayList<RegistroC198>();
    private List<RegistroC199> registroC199 = new ArrayList<RegistroC199>();
    private StringBuilder conteudo;

    RegistroC190 registroC190 = new RegistroC190();
    List<RegistroC190> registrosC190 = new ArrayList<RegistroC190>();
    
    protected List<RegistroC190> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC190 = new RegistroC190();                
                registroC190.setCOD_MOD(RS.getString(""));    
                registroC190.setDT_REF_INI(RS.getString(""));
                registroC190.setDT_REF_FIN(RS.getString(""));
                registroC190.setCOD_ITEM(RS.getString(""));
                registroC190.setCOD_NCM(RS.getString(""));
                registroC190.setEX_IPI(RS.getString(""));
                registroC190.setVL_TOT_ITEM(RS.getString(""));
                                
                registrosC190.add(registroC190);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC190.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC190;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C190").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_REF_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_REF_FIN())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_NCM(), 8)).append("|");
            conteudo.append(geral.efdAlfanumerico(getEX_IPI(), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_TOT_ITEM()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC190.class.getName()).log(Level.SEVERE, null, e);
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

    public String getDT_REF_INI() {
        return DT_REF_INI;
    }

    public void setDT_REF_INI(String DT_REF_INI) {
        this.DT_REF_INI = DT_REF_INI;
    }

    public String getDT_REF_FIN() {
        return DT_REF_FIN;
    }

    public void setDT_REF_FIN(String DT_REF_FIN) {
        this.DT_REF_FIN = DT_REF_FIN;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_NCM() {
        return COD_NCM;
    }

    public void setCOD_NCM(String COD_NCM) {
        this.COD_NCM = COD_NCM;
    }

    public String getEX_IPI() {
        return EX_IPI;
    }

    public void setEX_IPI(String EX_IPI) {
        this.EX_IPI = EX_IPI;
    }

    public String getVL_TOT_ITEM() {
        return VL_TOT_ITEM;
    }

    public void setVL_TOT_ITEM(String VL_TOT_ITEM) {
        this.VL_TOT_ITEM = VL_TOT_ITEM;
    }
}

class RegistroC191 {
    //Texto fixo contendo "C191”

    private String REG;
    //CNPJ/CPF do Participante a que se referem as operações consolidadas neste registro (pessoa jurídica ou pessoa física vendedora/remetente)
    private String CNPJ_CPF_PART;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor do item
    private String VL_ITEM;
    //Valor do desconto comercial / Exclusão
    private String VL_DESC;
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
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC191 registroC191 = new RegistroC191();
    List<RegistroC191> registrosC191 = new ArrayList<RegistroC191>();
    
    protected List<RegistroC191> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registroC191 = new RegistroC191();                
                registroC191.setCNPJ_CPF_PART(RS.getString(""));    
                registroC191.setCST_PIS(RS.getString(""));
                registroC191.setCFOP(RS.getString(""));
                registroC191.setVL_ITEM(RS.getString(""));
                registroC191.setVL_DESC(RS.getString(""));
                registroC191.setVL_BC_PIS(RS.getString(""));
                registroC191.setALIQ_PIS(RS.getString(""));
                registroC191.setQUANT_BC_PIS(RS.getString(""));
                registroC191.setALIQ_PIS_QUANT(RS.getString(""));
                registroC191.setVL_PIS(RS.getString(""));
                registroC191.setCOD_CTA(RS.getString(""));                
                                
                registrosC191.add(registroC191);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC191.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC191;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C191").append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ_CPF_PART())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_PIS())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCFOP())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC191.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCNPJ_CPF_PART() {
        return CNPJ_CPF_PART;
    }

    public void setCNPJ_CPF_PART(String CNPJ_CPF_PART) {
        this.CNPJ_CPF_PART = CNPJ_CPF_PART;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

//DETALHAMENTO DA CONSOLIDAÇÃO - OPERAÇÕES DE AQUISIÇÃO COM DIREITO A CRÉDITO, E OPERAÇÕES DE DEVOLUÇÃO DE COMPRAS E VENDAS – COFINS
class RegistroC195 {

    //Texto fixo contendo "C195”
    private String REG;
    //CNPJ/CPF do Participante a que se referem as operações consolidadas neste registro (pessoa jurídica ou pessoa física vendedora/remetente)
    private String CNPJ_CPF_PART;
    //Código da Situação Tributária referente a COFINS.
    private String CST_COFINS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor do item
    private String VL_ITEM;
    //Valor do desconto comercial / Exclusão
    private String VL_DESC;
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

    RegistroC195 registroC195 = new RegistroC195();
    List<RegistroC195> registrosC195 = new ArrayList<RegistroC195>();
    
    protected List<RegistroC195> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC195 = new RegistroC195();                
                registroC195.setCNPJ_CPF_PART(RS.getString(""));    
                registroC195.setCST_COFINS(RS.getString(""));
                registroC195.setCFOP(RS.getString(""));
                registroC195.setVL_ITEM(RS.getString(""));
                registroC195.setVL_DESC(RS.getString(""));
                registroC195.setVL_BC_COFINS(RS.getString(""));
                registroC195.setALIQ_COFINS(RS.getString(""));
                registroC195.setQUANT_BC_COFINS(RS.getString(""));
                registroC195.setVL_BC_COFINS(RS.getString(""));
                
                                
                registrosC195.add(registroC195);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC195.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC195;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C195").append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ_CPF_PART())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_COFINS())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCFOP())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCOD_CTA()), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC195.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCNPJ_CPF_PART() {
        return CNPJ_CPF_PART;
    }

    public void setCNPJ_CPF_PART(String CNPJ_CPF_PART) {
        this.CNPJ_CPF_PART = CNPJ_CPF_PART;
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

class RegistroC198 {
    //Texto fixo contendo "C198"

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 – Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC198 registroC198 = new RegistroC198();
    List<RegistroC198> registrosC198 = new ArrayList<RegistroC198>();
    
    protected List<RegistroC198> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC198 = new RegistroC198();                
                registroC198.setNUM_PROC(RS.getString(""));    
                registroC198.setIND_PROC(RS.getString(""));                                
                                
                registrosC198.add(registroC198);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC198.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC198;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C198").append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_PROC())).append("|");
            conteudo.append(geral.efdRemoveSinais(getIND_PROC())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC198.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC199 {
    //Texto fixo contendo "C199"

    private String REG;
    //Documento de importação:
    //0 – Declaração de Importação;
    //1 – Declaração Simplificada de Importação.
    private String COD_DOC_IMP;
    //Número do documento de Importação. C 010
    private String NUM_DOC_IMP;
    //Valor pago de PIS na importação
    private String VL_PIS_IMP;
    //Valor pago de COFINS na importação
    private String VL_COFINS_IMP;
    //Número do Ato Concessório do regime Drawback
    private String NUM_ACDRAW;
    private StringBuilder conteudo;

    RegistroC199 registroC199 = new RegistroC199();
    List<RegistroC199> registrosC199 = new ArrayList<RegistroC199>();
    
    protected List<RegistroC199> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC199 = new RegistroC199();                
                registroC199.setCOD_DOC_IMP(RS.getString(""));    
                registroC199.setNUM_DOC_IMP(RS.getString(""));
                registroC199.setVL_PIS_IMP(RS.getString(""));
                registroC199.setVL_COFINS_IMP(RS.getString(""));
                registroC199.setNUM_ACDRAW(RS.getString(""));
                                
                registrosC199.add(registroC199);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC199.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC199;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C199").append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_DOC_IMP())).append("|");
            conteudo.append(geral.efdNumerico(getNUM_DOC_IMP(), 10)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS_IMP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS_IMP()), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_ACDRAW())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC199.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_DOC_IMP() {
        return COD_DOC_IMP;
    }

    public void setCOD_DOC_IMP(String COD_DOC_IMP) {
        this.COD_DOC_IMP = COD_DOC_IMP;
    }

    public String getNUM_DOC_IMP() {
        return NUM_DOC_IMP;
    }

    public void setNUM_DOC_IMP(String NUM_DOC_IMP) {
        this.NUM_DOC_IMP = NUM_DOC_IMP;
    }

    public String getVL_PIS_IMP() {
        return VL_PIS_IMP;
    }

    public void setVL_PIS_IMP(String VL_PIS_IMP) {
        this.VL_PIS_IMP = VL_PIS_IMP;
    }

    public String getVL_COFINS_IMP() {
        return VL_COFINS_IMP;
    }

    public void setVL_COFINS_IMP(String VL_COFINS_IMP) {
        this.VL_COFINS_IMP = VL_COFINS_IMP;
    }

    public String getNUM_ACDRAW() {
        return NUM_ACDRAW;
    }

    public void setNUM_ACDRAW(String NUM_ACDRAW) {
        this.NUM_ACDRAW = NUM_ACDRAW;
    }
}

class RegistroC380 {
    //Texto fixo contendo "C380”

    private String REG;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1 (Código 02 – Nota Fiscal de Venda a Consumidor)
    private String COD_MOD;
    //Data de Emissão Inicial dos Documentos
    private String DT_DOC_INI;
    //Data de Emissão Final dos Documentos
    private String DT_DOC_FIN;
    //Número do documento fiscal inicial
    private String NUM_DOC_INI;
    //Número do documento fiscal final
    private String NUM_DOC_FIN;
    //Valor total dos documentos emitidos
    private String VL_DOC;
    //Valor total dos documentos cancelados
    private String VL_DOC_CANC;
    private List<RegistroC381> registroC381 = new ArrayList<RegistroC381>();
    private List<RegistroC385> registroC385 = new ArrayList<RegistroC385>();
    private StringBuilder conteudo;

    RegistroC380 registroC380 = new RegistroC380();
    List<RegistroC380> registrosC380 = new ArrayList<RegistroC380>();
    
    protected List<RegistroC380> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC380 = new RegistroC380();                
                registroC380.setCOD_MOD(RS.getString(""));    
                registroC380.setDT_DOC_INI(RS.getString(""));
                registroC380.setDT_DOC_FIN(RS.getString(""));
                registroC380.setNUM_DOC_INI(RS.getString(""));
                registroC380.setNUM_DOC_FIN(RS.getString(""));                
                registroC380.setVL_DOC(RS.getString(""));
                registroC380.setVL_DOC_CANC(RS.getString(""));                
                                
                registrosC380.add(registroC380);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC380.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC380;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C380").append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_MOD())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC_FIN())).append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_DOC_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_DOC_FIN())).append("|");
            conteudo.append(geral.efdNumerico(getVL_DOC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_DOC_CANC(), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC380.class.getName()).log(Level.SEVERE, null, e);
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

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_DOC_CANC() {
        return VL_DOC_CANC;
    }

    public void setVL_DOC_CANC(String VL_DOC_CANC) {
        this.VL_DOC_CANC = VL_DOC_CANC;
    }
}

class RegistroC381 {
    //Texto fixo contendo "C381”

    private String REG;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Valor total dos itens
    private String VL_ITEM;
    //Valor da base de cálculo do PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Quantidade – Base de cálculo do PIS/PASEP
    private String QUANT_BC_PIS;
    //Alíquota do PIS/PASEP (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC381 registroC381 = new RegistroC381();
    List<RegistroC381> registrosC381 = new ArrayList<RegistroC381>();
    
    protected List<RegistroC381> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC381 = new RegistroC381();                
                registroC381.setCST_PIS(RS.getString(""));    
                registroC381.setCOD_ITEM(RS.getString(""));
                registroC381.setVL_ITEM(RS.getString(""));
                registroC381.setVL_BC_PIS(RS.getString(""));
                registroC381.setALIQ_PIS(RS.getString(""));                
                registroC381.setQUANT_BC_PIS(RS.getString(""));
                registroC381.setALIQ_PIS_QUANT(RS.getString(""));                    
                registroC381.setVL_PIS(RS.getString(""));
                registroC381.setCOD_CTA(RS.getString("")); 
                                
                registrosC381.add(registroC381);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC381.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC381;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C381").append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_PIS())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC381.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class RegistroC385 {
    //Texto fixo contendo "C385”

    private String REG;
    //Código da Situação Tributária referente a COFINS. N
    private String CST_COFINS;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Valor total dos itens
    private String VL_ITEM;
    //Valor da base de cálculo da COFINS N
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

    RegistroC385 registroC385 = new RegistroC385();
    List<RegistroC385> registrosC385 = new ArrayList<RegistroC385>();
    
    protected List<RegistroC385> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC385 = new RegistroC385();                
                registroC385.setCST_COFINS(RS.getString(""));    
                registroC385.setCOD_ITEM(RS.getString(""));
                registroC385.setVL_ITEM(RS.getString(""));
                registroC385.setVL_BC_COFINS(RS.getString(""));
                registroC385.setALIQ_COFINS(RS.getString(""));                
                registroC385.setQUANT_BC_COFINS(RS.getString(""));
                registroC385.setALIQ_COFINS_QUANT(RS.getString(""));                    
                registroC385.setVL_COFINS(RS.getString(""));
                registroC385.setCOD_CTA(RS.getString("")); 
                                
                registrosC385.add(registroC385);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC385.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC385;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C385").append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_COFINS())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC385.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

class RegistroC395 {
    //Texto fixo contendo "C395"

    private String REG;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1
    private String COD_MOD;
    //Código do participante emitente do documento (campo 02 do Registro 0150).
    private String COD_PART;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB_SER;
    //Número do documento fiscal
    private String NUM_DOC;
    //Data da emissão do documento fiscal N 008
    private String DT_DOC;
    //Valor total do documento fiscal
    private String VL_DOC;
    private List<RegistroC396> registroC396 = new ArrayList<RegistroC396>();
    private StringBuilder conteudo;

    RegistroC395 registroC395 = new RegistroC395();
    List<RegistroC395> registrosC395 = new ArrayList<RegistroC395>();
    
    protected List<RegistroC395> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC395 = new RegistroC395();                
                registroC395.setCOD_MOD(RS.getString(""));    
                registroC395.setCOD_PART(RS.getString(""));
                registroC395.setSER(RS.getString(""));
                registroC395.setSUB_SER(RS.getString(""));
                registroC395.setNUM_DOC(RS.getString(""));                
                registroC395.setDT_DOC(RS.getString(""));
                registroC395.setVL_DOC(RS.getString(""));                                    
                                
                registrosC395.add(registroC395);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC395.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC395;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C395").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(), 60)).append("|");
            conteudo.append(geral.efdNumerico(getSER(), 3)).append("|");
            conteudo.append(geral.efdNumerico(getSUB_SER(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC(), 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC395.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
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

class RegistroC396 {
    //Texto fixo contendo "C396"

    private String REG;
    //Código do item (campo 02 do Registro 0200) C 060
    private String COD_ITEM;
    //Valor total do item (mercadorias ou serviços)
    private String VL_ITEM;
    //Valor do desconto comercial do item
    private String VL_DESC;
    //Código da Base de Cálculo do Crédito, conforme a Tabela indicada no item 4.3.7.
    private String NAT_BC_CRED;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor da base de cálculo do crédito de PIS/PASEP
    private String VL_BC_PIS;
    //Alíquota do PIS/PASEP (em percentual)
    private String ALIQ_PIS;
    //Valor do crédito de PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor da base de cálculo do crédito de COFINS
    private String VL_BC_COFINS;
    //Alíquota da COFINS (em percentual)
    private String ALIQ_COFINS;
    //Valor do crédito de COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC396 registroC396 = new RegistroC396();
    List<RegistroC396> registrosC396 = new ArrayList<RegistroC396>();
    
    protected List<RegistroC396> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC396 = new RegistroC396();                
                registroC396.setCOD_ITEM(RS.getString(""));    
                registroC396.setVL_ITEM(RS.getString(""));
                registroC396.setVL_DESC(RS.getString(""));
                registroC396.setNAT_BC_CRED(RS.getString(""));
                registroC396.setCST_PIS(RS.getString(""));                
                registroC396.setVL_BC_PIS(RS.getString(""));
                registroC396.setALIQ_PIS(RS.getString(""));                     
                registroC396.setVL_PIS(RS.getString(""));                
                registroC396.setCST_COFINS(RS.getString(""));
                registroC396.setVL_BC_COFINS(RS.getString(""));                 
                registroC396.setALIQ_COFINS(RS.getString(""));                
                registroC396.setVL_COFINS(RS.getString(""));
                registroC396.setCOD_CTA(RS.getString("")); 
                                
                registrosC396.add(registroC396);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC396.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC396;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C396").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_COFINS())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_COFINS(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_CTA(), 60)).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC396.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getVL_BC_PIS() {
        return VL_BC_PIS;
    }

    public void setVL_BC_PIS(String VL_BC_PIS) {
        this.VL_BC_PIS = VL_BC_PIS;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

class RegistroC400 {

    private String REG;
    private String COD_MOD;
    private String ECF_MOD;
    private String ECF_FAB;
    private String ECF_CX;
    private List<RegistroC405> registroC405 = new ArrayList<RegistroC405>();
    private List<RegistroC489> registroC489 = new ArrayList<RegistroC489>();
    private StringBuilder conteudo;

    RegistroC400 registroC400 = new RegistroC400();
    List<RegistroC400> registrosC400 = new ArrayList<RegistroC400>();
    
    protected List<RegistroC400> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC400 = new RegistroC400();                
                registroC400.setCOD_MOD(RS.getString(""));    
                registroC400.setECF_MOD(RS.getString(""));
                registroC400.setECF_FAB(RS.getString(""));
                registroC400.setECF_CX(RS.getString(""));                
                                
                registrosC400.add(registroC400);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC400.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC400;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C400").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getECF_MOD(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getECF_FAB(), 20)).append("|");
            conteudo.append(geral.efdNumerico(getECF_CX(), 3)).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC400.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getECF_CX() {
        return ECF_CX;
    }

    public void setECF_CX(String ECF_CX) {
        this.ECF_CX = ECF_CX;
    }

    public String getECF_FAB() {
        return ECF_FAB;
    }

    public void setECF_FAB(String ECF_FAB) {
        this.ECF_FAB = ECF_FAB;
    }

    public String getECF_MOD() {
        return ECF_MOD;
    }

    public void setECF_MOD(String ECF_MOD) {
        this.ECF_MOD = ECF_MOD;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC405 {

    private String REG;
    private String DT_DOC;
    private String CRO;
    private String CRZ;
    private String NUM_COO_FIN;
    private String GT_FIN;
    private String VL_BRT;
    private List<RegistroC481> registroC481 = new ArrayList<RegistroC481>();
    private List<RegistroC485> registroC485 = new ArrayList<RegistroC485>();
    private StringBuilder conteudo;

    RegistroC405 registroC405 = new RegistroC405();
    List<RegistroC405> registrosC405 = new ArrayList<RegistroC405>();
    
    protected List<RegistroC405> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC405 = new RegistroC405();                
                registroC405.setDT_DOC(RS.getString(""));    
                registroC405.setCRO(RS.getString(""));
                registroC405.setCRZ(RS.getString(""));
                registroC405.setNUM_COO_FIN(RS.getString(""));                
                registroC405.setGT_FIN(RS.getString(""));
                registroC405.setVL_BRT(RS.getString(""));              
                                
                registrosC405.add(registroC405);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC405.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC405;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C405").append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC())).append("|");
            conteudo.append(geral.efdAlfanumerico(getCRO(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCRZ(), 6)).append("|");
            conteudo.append(geral.efdNumerico(getNUM_COO_FIN(), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getGT_FIN()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BRT()), 2)).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC405.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getGT_FIN() {
        return GT_FIN;
    }

    public void setGT_FIN(String GT_FIN) {
        this.GT_FIN = GT_FIN;
    }

    public String getNUM_COO_FIN() {
        return NUM_COO_FIN;
    }

    public void setNUM_COO_FIN(String NUM_COO_FIN) {
        this.NUM_COO_FIN = NUM_COO_FIN;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_BRT() {
        return VL_BRT;
    }

    public void setVL_BRT(String VL_BRT) {
        this.VL_BRT = VL_BRT;
    }
}

class RegistroC481 {
    //Texto fixo contendo "C481”

    private String REG;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Valor total dos itens
    private String VL_ITEM;
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
    //Código do item (campo 02 do Registro 0200) 
    private String COD_ITEM;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC481 registroC481 = new RegistroC481();
    List<RegistroC481> registrosC481 = new ArrayList<RegistroC481>();
    
    protected List<RegistroC481> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC481 = new RegistroC481();                
                registroC481.setCST_PIS(RS.getString(""));    
                registroC481.setVL_ITEM(RS.getString(""));
                registroC481.setVL_BC_PIS(RS.getString(""));
                registroC481.setALIQ_PIS(RS.getString(""));                
                registroC481.setQUANT_BC_PIS(RS.getString(""));
                registroC481.setALIQ_PIS_QUANT(RS.getString(""));
                registroC481.setVL_PIS(RS.getString(""));
                registroC481.setCOD_ITEM(RS.getString(""));
                registroC481.setCOD_CTA(RS.getString(""));
                                
                registrosC481.add(registroC481);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC481.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC481;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C481").append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_PIS())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_PIS(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC481.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class RegistroC485 {
    //Texto fixo contendo "C485”

    private String REG;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor total dos itens
    private String VL_ITEM;
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
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC485 registroC485 = new RegistroC485();
    List<RegistroC485> registrosC485 = new ArrayList<RegistroC485>();
    
    protected List<RegistroC485> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC485 = new RegistroC485();                
                registroC485.setCST_COFINS(RS.getString(""));    
                registroC485.setVL_ITEM(RS.getString(""));
                registroC485.setVL_BC_COFINS(RS.getString(""));
                registroC485.setALIQ_COFINS(RS.getString(""));                
                registroC485.setQUANT_BC_COFINS(RS.getString(""));
                registroC485.setALIQ_COFINS_QUANT(RS.getString(""));
                registroC485.setVL_COFINS(RS.getString(""));
                registroC485.setCOD_ITEM(RS.getString(""));
                registroC485.setCOD_CTA(RS.getString(""));
                                
                registrosC485.add(registroC485);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC485.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC485;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C485").append("|");
            conteudo.append(geral.efdRemoveSinais(getCST_COFINS())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getALIQ_COFINS(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC485.class.getName()).log(Level.SEVERE, null, e);
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

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class RegistroC489 {
    //Texto fixo contendo "C489"

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 - Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC489 registroC489 = new RegistroC489();
    List<RegistroC489> registrosC489 = new ArrayList<RegistroC489>();
    
    protected List<RegistroC489> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC489 = new RegistroC489();                
                registroC489.setNUM_PROC(RS.getString(""));    
                registroC489.setIND_PROC(RS.getString(""));                
                                
                registrosC489.add(registroC489);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC489.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC489;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C489").append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_PROC())).append("|");
            conteudo.append(geral.efdRemoveSinais(getIND_PROC())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC489.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC490 {

    private String REG;
    private String DT_DOC_INI;
    private String DT_DOC_FIN;
    private String COD_MOD;
    private List<RegistroC491> registroC491 = new ArrayList<RegistroC491>();
    private List<RegistroC495> registroC495 = new ArrayList<RegistroC495>();
    private List<RegistroC499> registroC499 = new ArrayList<RegistroC499>();
    private StringBuilder conteudo;

    RegistroC490 registroC490 = new RegistroC490();
    List<RegistroC490> registrosC490 = new ArrayList<RegistroC490>();
    
    protected List<RegistroC490> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC490 = new RegistroC490();                
                registroC490.setDT_DOC_INI(RS.getString(""));    
                registroC490.setDT_DOC_FIN(RS.getString(""));
                registroC490.setCOD_MOD(RS.getString(""));
                                
                registrosC490.add(registroC490);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC490.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC490;
    }


    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C490").append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC_FIN())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_MOD())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC490.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
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

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }
}

class RegistroC491 {
    //Texto fixo contendo "C491”

    private String REG;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor total dos itens
    private String VL_ITEM;
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
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC491 registroC491 = new RegistroC491();
    List<RegistroC491> registrosC491 = new ArrayList<RegistroC491>();
    
    protected List<RegistroC491> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC491 = new RegistroC491();                
                registroC491.setCOD_ITEM(RS.getString(""));    
                registroC491.setCST_PIS(RS.getString(""));
                registroC491.setCFOP(RS.getString(""));
                registroC491.setVL_ITEM(RS.getString(""));
                registroC491.setVL_BC_PIS(RS.getString(""));                
                registroC491.setALIQ_PIS(RS.getString(""));
                registroC491.setQUANT_BC_PIS(RS.getString(""));                
                registroC491.setALIQ_PIS_QUANT(RS.getString(""));
                registroC491.setVL_PIS(RS.getString(""));
                registroC491.setCOD_CTA(RS.getString(""));
                                
                registrosC491.add(registroC491);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC491.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC491;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C491").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_CTA())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC491.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }
}

class RegistroC495 {

    //Texto fixo contendo "C495”
    private String REG;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor total dos itens
    private String VL_ITEM;
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

    RegistroC495 registroC495 = new RegistroC495();
    List<RegistroC495> registrosC495 = new ArrayList<RegistroC495>();
    
    protected List<RegistroC495> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC495 = new RegistroC495();                
                registroC495.setCOD_ITEM(RS.getString(""));    
                registroC495.setCST_COFINS(RS.getString(""));
                registroC495.setCFOP(RS.getString(""));
                registroC495.setVL_ITEM(RS.getString(""));
                registroC495.setVL_BC_COFINS(RS.getString(""));                
                registroC495.setALIQ_COFINS(RS.getString(""));
                registroC495.setQUANT_BC_COFINS(RS.getString(""));                
                registroC495.setALIQ_COFINS_QUANT(RS.getString(""));
                registroC495.setVL_COFINS(RS.getString(""));
                registroC495.setCOD_CTA(RS.getString(""));
                                
                registrosC495.add(registroC495);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC495.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC495;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C495").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_CTA())).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC495.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

class RegistroC499 {
    //Texto fixo contendo "C499"

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 - Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC499 registroC499 = new RegistroC499();
    List<RegistroC499> registrosC499 = new ArrayList<RegistroC499>();
    
    protected List<RegistroC499> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC499 = new RegistroC499();                
                registroC499.setNUM_PROC(RS.getString(""));    
                registroC499.setIND_PROC(RS.getString(""));               
                                
                registrosC499.add(registroC499);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC499.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC499;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C499").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC499.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC500 {

    //Texto fixo contendo "C500"
    private String REG;
    //Código do participante do fornecedor (campo 02 do Registro 0150).
    private String COD_PART;
    //Código do modelo do documento fiscal, conforme a Tabela 4.1.1
    private String COD_MOD;
    //Código da situação do documento fiscal, conforme a Tabela 4.1.2
    private String COD_SIT;
    //Série do documento fiscal
    private String SER;
    //Subsérie do documento fiscal
    private String SUB;
    //Número do documento fiscal
    private String NUM_DOC;
    //Data da emissão do documento fiscal
    private String DT_DOC;
    //Data da entrada
    private String DT_ENT;
    //Valor total do documento fiscal
    private String VL_DOC;
    //Valor acumulado do ICMS
    private String VL_ICMS;
    //Código da informação complementar do documento fiscal (campo 02 do Registro 0450)
    private String COD_INF;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Valor da COFINS
    private String VL_COFINS;
    private List<RegistroC501> registroC501 = new ArrayList<RegistroC501>();
    private List<RegistroC505> registroC505 = new ArrayList<RegistroC505>();
    private List<RegistroC509> registroC509 = new ArrayList<RegistroC509>();
    private StringBuilder conteudo;

    RegistroC500 registroC500 = new RegistroC500();
    List<RegistroC500> registrosC500 = new ArrayList<RegistroC500>();
    
    protected List<RegistroC500> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC500 = new RegistroC500();                
                registroC500.setCOD_PART(RS.getString(""));    
                registroC500.setCOD_MOD(RS.getString("")); 
                registroC500.setCOD_SIT(RS.getString(""));    
                registroC500.setSER(RS.getString(""));
                registroC500.setSUB(RS.getString(""));
                registroC500.setNUM_DOC(RS.getString(""));
                registroC500.setDT_DOC(RS.getString(""));
                registroC500.setDT_ENT(RS.getString(""));
                registroC500.setVL_DOC(RS.getString(""));                
                registroC500.setVL_ICMS(RS.getString(""));
                registroC500.setCOD_INF(RS.getString(""));
                registroC500.setVL_PIS(RS.getString(""));
                registroC500.setVL_COFINS(RS.getString(""));               
                
                registrosC500.add(registroC500);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC500.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC500;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C500").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_PART(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_SIT(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_DOC(), 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_ENT())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_INF(), 6)).append("|");
            conteudo.append(geral.efdNumerico(getVL_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS(), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC500.class.getName()).log(Level.SEVERE, null, e);
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

    public String getDT_ENT() {
        return DT_ENT;
    }

    public void setDT_ENT(String DT_ENT) {
        this.DT_ENT = DT_ENT;
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

    public String getCOD_INF() {
        return COD_INF;
    }

    public void setCOD_INF(String COD_INF) {
        this.COD_INF = COD_INF;
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
}

class RegistroC501 {

    private String REG;
    private String CST_PIS;
    private String VL_ITEM;
    private String NAT_BC_CRED;
    private String VL_BC_PIS;
    private String ALIQ_PIS;
    private String VL_PIS;
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC501 registroC501 = new RegistroC501();
    List<RegistroC501> registrosC501 = new ArrayList<RegistroC501>();
    
    protected List<RegistroC501> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC501 = new RegistroC501();                
                registroC501.setCST_PIS(RS.getString(""));    
                registroC501.setVL_ITEM(RS.getString("")); 
                registroC501.setNAT_BC_CRED(RS.getString(""));    
                registroC501.setVL_BC_PIS(RS.getString(""));
                registroC501.setALIQ_PIS(RS.getString(""));
                registroC501.setVL_PIS(RS.getString(""));
                registroC501.setCOD_CTA(RS.getString(""));                           
                
                registrosC501.add(registroC501);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC501.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC501;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C501").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(getVL_PIS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC501.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC505 {
    //Texto fixo contendo "C505”

    private String REG;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Valor total dos itens
    private String VL_ITEM;
    //Código da Base de Cálculo do Crédito, conforme a Tabela indicada no item 4.3.7
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

    RegistroC505 registroC505 = new RegistroC505();
    List<RegistroC505> registrosC501 = new ArrayList<RegistroC505>();
    
    protected List<RegistroC505> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC505 = new RegistroC505();                
                registroC505.setCST_COFINS(RS.getString(""));    
                registroC505.setVL_ITEM(RS.getString("")); 
                registroC505.setNAT_BC_CRED(RS.getString(""));    
                registroC505.setVL_BC_COFINS(RS.getString(""));
                registroC505.setALIQ_COFINS(RS.getString(""));
                registroC505.setVL_COFINS(RS.getString(""));
                registroC505.setCOD_CTA(RS.getString(""));                           
                
                registrosC501.add(registroC505);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC505.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC501;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C505").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNAT_BC_CRED(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(getVL_COFINS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC505.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC509 {
    //Texto fixo contendo "C509"

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 – Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC505 registroC505 = new RegistroC505();
    List<RegistroC505> registrosC505 = new ArrayList<RegistroC505>();
    
    protected List<RegistroC505> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC505 = new RegistroC505();                
                registroC505.setCST_COFINS(RS.getString(""));    
                registroC505.setVL_ITEM(RS.getString("")); 
                registroC505.setNAT_BC_CRED(RS.getString(""));    
                registroC505.setVL_BC_COFINS(RS.getString(""));
                registroC505.setALIQ_COFINS(RS.getString(""));
                registroC505.setVL_COFINS(RS.getString(""));
                registroC505.setCOD_CTA(RS.getString(""));                           
                
                registrosC505.add(registroC505);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC505.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC505;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C509").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC509.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC600 {

    private String REG;
    private String COD_MOD;
    private String COD_MUN;
    private String SER;
    private String SUB;
    private String COD_CONS;
    private String QTD_CONS;
    private String QTD_CANC;
    private String DT_DOC;
    private String VL_DOC;
    private String VL_DESC;
    private String CONS;
    private String VL_FORN;
    private String VL_SERV_NT;
    private String VL_TERC;
    private String VL_DA;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String VL_PIS;
    private String VL_COFINS;
    private List<RegistroC601> registroC601 = new ArrayList<RegistroC601>();
    private List<RegistroC605> registroC605 = new ArrayList<RegistroC605>();
    private List<RegistroC609> registroC609 = new ArrayList<RegistroC609>();
    private StringBuilder conteudo;

    RegistroC600 registroC600 = new RegistroC600();
    List<RegistroC600> registrosC600 = new ArrayList<RegistroC600>();
    
    protected List<RegistroC600> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC600 = new RegistroC600();                
                registroC600.setCOD_MOD(RS.getString(""));    
                registroC600.setCOD_MUN(RS.getString("")); 
                registroC600.setSER(RS.getString(""));    
                registroC600.setSUB(RS.getString(""));
                registroC600.setCOD_CONS(RS.getString(""));
                registroC600.setQTD_CONS(RS.getString(""));
                registroC600.setQTD_CANC(RS.getString(""));                
                registroC600.setDT_DOC(RS.getString(""));
                registroC600.setVL_DOC(RS.getString(""));
                registroC600.setVL_DESC(RS.getString(""));
                registroC600.setCONS(RS.getString(""));
                registroC600.setVL_FORN(RS.getString(""));
                registroC600.setVL_SERV_NT(RS.getString(""));                
                registroC600.setVL_TERC(RS.getString(""));
                registroC600.setVL_DA(RS.getString(""));
                registroC600.setVL_BC_ICMS(RS.getString(""));
                registroC600.setVL_ICMS(RS.getString(""));                
                registroC600.setVL_BC_ICMS_ST(RS.getString(""));
                registroC600.setVL_ICMS_ST(RS.getString(""));
                registroC600.setVL_PIS(RS.getString(""));
                registroC600.setVL_COFINS(RS.getString(""));
                
                registrosC600.add(registroC600);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC600.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC600;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C600").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MUN(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSER(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUB(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CONS(), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getQTD_CONS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQTD_CANC()), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getDT_DOC(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DOC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCONS(), 10)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_FORN(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_SERV_NT(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC600.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_CONS() {
        return COD_CONS;
    }

    public void setCOD_CONS(String COD_CONS) {
        this.COD_CONS = COD_CONS;
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

    public String getCONS() {
        return CONS;
    }

    public void setCONS(String CONS) {
        this.CONS = CONS;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getQTD_CANC() {
        return QTD_CANC;
    }

    public void setQTD_CANC(String QTD_CANC) {
        this.QTD_CANC = QTD_CANC;
    }

    public String getQTD_CONS() {
        return QTD_CONS;
    }

    public void setQTD_CONS(String QTD_CONS) {
        this.QTD_CONS = QTD_CONS;
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

    public String getVL_TERC() {
        return VL_TERC;
    }

    public void setVL_TERC(String VL_TERC) {
        this.VL_TERC = VL_TERC;
    }
}

class RegistroC601 {

    //Texto fixo contendo "C601”
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

    RegistroC601 registroC601 = new RegistroC601();
    List<RegistroC601> registrosC601 = new ArrayList<RegistroC601>();
    
    protected List<RegistroC601> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC601 = new RegistroC601();                
                registroC601.setCST_PIS(RS.getString(""));    
                registroC601.setVL_ITEM(RS.getString("")); 
                registroC601.setVL_BC_PIS(RS.getString(""));    
                registroC601.setALIQ_PIS(RS.getString(""));
                registroC601.setVL_PIS(RS.getString(""));
                registroC601.setCOD_CTA(RS.getString(""));  
                
                registrosC601.add(registroC601);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC601.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC601;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C601").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC601.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC605 {
    //Texto fixo contendo "C605”

    private String REG;
    //Código da Situação Tributária referente a COFINS
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

    RegistroC605 registroC605 = new RegistroC605();
    List<RegistroC605> registrosC605 = new ArrayList<RegistroC605>();
    
    protected List<RegistroC605> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC605 = new RegistroC605();                
                registroC605.setCST_COFINS(RS.getString(""));    
                registroC605.setVL_ITEM(RS.getString("")); 
                registroC605.setVL_BC_COFINS(RS.getString(""));    
                registroC605.setALIQ_COFINS(RS.getString(""));
                registroC605.setVL_COFINS(RS.getString(""));
                registroC605.setCOD_CTA(RS.getString(""));  
                
                registrosC605.add(registroC605);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC605.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC605;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C605").append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_BC_COFINS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC605.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC609 {
    //Texto fixo contendo "C609"

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 – Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC609 registroC609 = new RegistroC609();
    List<RegistroC609> registrosC609 = new ArrayList<RegistroC609>();
    
    protected List<RegistroC609> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC609 = new RegistroC609();                
                registroC609.setNUM_PROC(RS.getString(""));    
                registroC609.setIND_PROC(RS.getString(""));                   
                
                registrosC609.add(registroC609);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC609.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC609;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C609").append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_PROC(), 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(getIND_PROC(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC609.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC800 {

    private String REG;
    private String COD_MOD;
    private String COD_SIT;
    private String NUM_CFE;
    private String DT_DOC;
    private String VL_CFE;
    private String VL_PIS;
    private String VL_COFINS;
    private String CNPJ_CPF;
    private String NR_SAT;
    private String CHV_CFE;
    private String VL_DESC;
    private String VL_MERC;
    private String VL_OUT_DA;
    private String VL_ICMS;
    private String VL_PIS_ST;
    private String VL_COFINS_ST;
    private List<RegistroC810> registroC810 = new ArrayList<RegistroC810>();
    private List<RegistroC820> registroC820 = new ArrayList<RegistroC820>();
    private List<RegistroC830> registroC830 = new ArrayList<RegistroC830>();
    private StringBuilder conteudo;

    RegistroC800 registroC800 = new RegistroC800();
    List<RegistroC800> registrosC800 = new ArrayList<RegistroC800>();
    
    protected List<RegistroC800> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC800 = new RegistroC800();                
                registroC800.setCOD_MOD(RS.getString(""));    
                registroC800.setCOD_SIT(RS.getString(""));                
                registroC800.setNUM_CFE(RS.getString(""));    
                registroC800.setDT_DOC(RS.getString(""));
                registroC800.setVL_CFE(RS.getString(""));    
                registroC800.setVL_PIS(RS.getString(""));
                registroC800.setVL_COFINS(RS.getString(""));    
                registroC800.setCNPJ_CPF(RS.getString(""));
                registroC800.setNR_SAT(RS.getString(""));    
                registroC800.setCHV_CFE(RS.getString(""));
                registroC800.setVL_DESC(RS.getString(""));    
                registroC800.setVL_MERC(RS.getString(""));
                registroC800.setVL_OUT_DA(RS.getString(""));    
                registroC800.setVL_ICMS(RS.getString(""));
                registroC800.setVL_PIS_ST(RS.getString(""));    
                registroC800.setVL_COFINS_ST(RS.getString(""));
                
                registrosC800.add(registroC800);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC800.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC800;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C800").append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_MOD(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_SIT(), 2)).append("|");
            conteudo.append(geral.efdNumerico(getNUM_CFE(), 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_DOC())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_CFE()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ_CPF())).append("|");
            conteudo.append(geral.efdRemoveSinais(getNR_SAT())).append("|");
            conteudo.append(geral.efdRemoveSinais(getCHV_CFE())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_DESC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_MERC()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_OUT_DA()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ICMS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS_ST()), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS_ST()), 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC800.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCHV_CFE() {
        return CHV_CFE;
    }

    public void setCHV_CFE(String CHV_CFE) {
        this.CHV_CFE = CHV_CFE;
    }

    public String getCNPJ_CPF() {
        return CNPJ_CPF;
    }

    public void setCNPJ_CPF(String CNPJ_CPF) {
        this.CNPJ_CPF = CNPJ_CPF;
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

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getNR_SAT() {
        return NR_SAT;
    }

    public void setNR_SAT(String NR_SAT) {
        this.NR_SAT = NR_SAT;
    }

    public String getNUM_CFE() {
        return NUM_CFE;
    }

    public void setNUM_CFE(String NUM_CFE) {
        this.NUM_CFE = NUM_CFE;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_CFE() {
        return VL_CFE;
    }

    public void setVL_CFE(String VL_CFE) {
        this.VL_CFE = VL_CFE;
    }

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getVL_COFINS_ST() {
        return VL_COFINS_ST;
    }

    public void setVL_COFINS_ST(String VL_COFINS_ST) {
        this.VL_COFINS_ST = VL_COFINS_ST;
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

    public String getVL_MERC() {
        return VL_MERC;
    }

    public void setVL_MERC(String VL_MERC) {
        this.VL_MERC = VL_MERC;
    }

    public String getVL_OUT_DA() {
        return VL_OUT_DA;
    }

    public void setVL_OUT_DA(String VL_OUT_DA) {
        this.VL_OUT_DA = VL_OUT_DA;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getVL_PIS_ST() {
        return VL_PIS_ST;
    }

    public void setVL_PIS_ST(String VL_PIS_ST) {
        this.VL_PIS_ST = VL_PIS_ST;
    }
}

class RegistroC810 {
    //Texto fixo contendo "C810"

    private String REG;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor total dos itens
    private String VL_ITEM;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
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

    RegistroC810 registroC810 = new RegistroC810();
    List<RegistroC810> registrosC810 = new ArrayList<RegistroC810>();
    
    protected List<RegistroC810> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC810 = new RegistroC810();                
                registroC810.setCFOP(RS.getString(""));    
                registroC810.setVL_ITEM(RS.getString(""));                
                registroC810.setCOD_ITEM(RS.getString(""));    
                registroC810.setCST_PIS(RS.getString(""));
                registroC810.setVL_BC_PIS(RS.getString(""));    
                registroC810.setALIQ_PIS(RS.getString(""));
                registroC810.setVL_PIS(RS.getString(""));    
                registroC810.setCST_COFINS(RS.getString(""));
                registroC810.setVL_BC_COFINS(RS.getString(""));    
                registroC810.setALIQ_COFINS(RS.getString(""));
                registroC810.setVL_COFINS(RS.getString(""));    
                registroC810.setCOD_CTA(RS.getString(""));
                
                registrosC810.add(registroC810);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC810.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC810;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C810").append("|");
            conteudo.append(geral.efdAlfanumerico(getCFOP(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");
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
            Logger.getLogger(RegistroC810.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

class RegistroC820 {
    //Texto fixo contendo "C820"

    private String REG;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor total dos itens
    private String VL_ITEM;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Base de cálculo em quantidade - PIS/PASEP
    private String QUANT_BC_PIS;
    //Alíquota do PIS/PASEP (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Base de cálculo em quantidade – COFINS
    private String QUANT_BC_COFINS;
    //Alíquota da COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC820 registroC820 = new RegistroC820();
    List<RegistroC820> registrosC820 = new ArrayList<RegistroC820>();
    
    protected List<RegistroC820> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC820 = new RegistroC820();                
                registroC820.setCFOP(RS.getString(""));    
                registroC820.setVL_ITEM(RS.getString(""));                
                registroC820.setCOD_ITEM(RS.getString(""));    
                registroC820.setCST_PIS(RS.getString(""));
                registroC820.setQUANT_BC_PIS(RS.getString(""));    
                registroC820.setALIQ_PIS_QUANT(RS.getString(""));
                registroC820.setVL_PIS(RS.getString(""));    
                registroC820.setCST_COFINS(RS.getString(""));
                registroC820.setQUANT_BC_COFINS(RS.getString(""));    
                registroC820.setALIQ_COFINS_QUANT(RS.getString(""));
                registroC820.setVL_COFINS(RS.getString(""));    
                registroC820.setCOD_CTA(RS.getString(""));
                
                registrosC820.add(registroC820);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC820.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC820;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C820").append("|");
            conteudo.append(geral.efdRemoveSinais(getCFOP())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_PIS_QUANT(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_PIS(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCST_COFINS(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getQUANT_BC_COFINS(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getALIQ_COFINS_QUANT(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(getVL_COFINS(), 10)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");


            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC820.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCST_PIS() {
        return CST_PIS;
    }

    public void setCST_PIS(String CST_PIS) {
        this.CST_PIS = CST_PIS;
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

class RegistroC830 {
    //Texto fixo contendo "C830”

    private String REG;
    //Identificação do processo ou ato concessório
    private String NUM_PROC;
    //Indicador da origem do processo:
    //1 - Justiça Federal;
    //3 – Secretaria da Receita Federal do Brasil
    //9 - Outros.
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC830 registroC830 = new RegistroC830();
    List<RegistroC830> registrosC830 = new ArrayList<RegistroC830>();
    
    protected List<RegistroC830> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC830 = new RegistroC830();                
                registroC830.setNUM_PROC(RS.getString(""));    
                registroC830.setIND_PROC(RS.getString(""));                                
                
                registrosC830.add(registroC830);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC830.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC830;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C830").append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_PROC())).append("|");
            conteudo.append(geral.efdNumerico(getIND_PROC(), 1)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC830.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC860 {

    private String REG;
    private String COD_MOD;
    private String NR_SAT;
    private String DT_DOC;
    private String DOC_INI;
    private String DOC_FIM;
    private List<RegistroC870> registroC870 = new ArrayList<RegistroC870>();
    private List<RegistroC880> registroC880 = new ArrayList<RegistroC880>();
    private List<RegistroC890> registroC890 = new ArrayList<RegistroC890>();
    private StringBuilder conteudo;

    RegistroC860 registroC860 = new RegistroC860();
    List<RegistroC860> registrosC860 = new ArrayList<RegistroC860>();
    
    protected List<RegistroC860> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC860 = new RegistroC860();                
                registroC860.setCOD_MOD(RS.getString(""));    
                registroC860.setNR_SAT(RS.getString(""));  
                registroC860.setDT_DOC(RS.getString(""));    
                registroC860.setDOC_INI(RS.getString(""));
                registroC860.setDOC_FIM(RS.getString(""));    
                
                registrosC860.add(registroC860);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC860.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC860;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C860").append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_MOD())).append("|");
            conteudo.append(geral.efdAlfanumerico(getNR_SAT(), 9)).append("|");
            conteudo.append(geral.efdNumerico(getDT_DOC(), 9)).append("|");
            conteudo.append(geral.efdNumerico(getDOC_FIM(), 9)).append("|");
            conteudo.append(geral.efdNumerico(getDOC_FIM(), 9)).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC860.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getDOC_FIM() {
        return DOC_FIM;
    }

    public void setDOC_FIM(String DOC_FIM) {
        this.DOC_FIM = DOC_FIM;
    }

    public String getDOC_INI() {
        return DOC_INI;
    }

    public void setDOC_INI(String DOC_INI) {
        this.DOC_INI = DOC_INI;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getNR_SAT() {
        return NR_SAT;
    }

    public void setNR_SAT(String NR_SAT) {
        this.NR_SAT = NR_SAT;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC870 {
    //Texto fixo contendo "C870"

    private String REG;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor total dos itens
    private String VL_ITEM;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
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

    RegistroC870 registroC870 = new RegistroC870();
    List<RegistroC870> registrosC870 = new ArrayList<RegistroC870>();
    
    protected List<RegistroC870> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC870 = new RegistroC870();                
                registroC870.setCFOP(RS.getString(""));    
                registroC870.setVL_ITEM(RS.getString(""));  
                registroC870.setCOD_ITEM(RS.getString(""));    
                registroC870.setCST_PIS(RS.getString(""));
                registroC870.setVL_BC_PIS(RS.getString(""));                 
                registroC870.setALIQ_PIS(RS.getString(""));    
                registroC870.setVL_PIS(RS.getString(""));  
                registroC870.setCST_COFINS(RS.getString(""));    
                registroC870.setVL_BC_COFINS(RS.getString(""));
                registroC870.setALIQ_COFINS(RS.getString(""));                  
                registroC870.setVL_COFINS(RS.getString(""));    
                registroC870.setCOD_CTA(RS.getString(""));                    
                
                registrosC870.add(registroC870);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC870.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC870;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C870").append("|");
            conteudo.append(geral.efdRemoveSinais(getCFOP())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_ITEM()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCOD_ITEM(), 9)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 9)).append("|");
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
            Logger.getLogger(RegistroC870.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
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

class RegistroC880 {
    //Texto fixo contendo "C880"

    private String REG;
    //Código do item (campo 02 do Registro 0200)
    private String COD_ITEM;
    //Código fiscal de operação e prestação
    private String CFOP;
    //Valor total dos itens
    private String VL_ITEM;
    //Código da Situação Tributária referente ao PIS/PASEP
    private String CST_PIS;
    //Base de cálculo em quantidade - PIS/PASEP
    private String QUANT_BC_PIS;
    //Alíquota do PIS/PASEP (em reais)
    private String ALIQ_PIS_QUANT;
    //Valor do PIS/PASEP
    private String VL_PIS;
    //Código da Situação Tributária referente a COFINS
    private String CST_COFINS;
    //Base de cálculo em quantidade – COFINS
    private String QUANT_BC_COFINS;
    //Alíquota da COFINS (em reais)
    private String ALIQ_COFINS_QUANT;
    //Valor da COFINS
    private String VL_COFINS;
    //Código da conta analítica contábil debitada/creditada C
    private String COD_CTA;
    private StringBuilder conteudo;

    RegistroC880 registroC880 = new RegistroC880();
    List<RegistroC880> registrosC880 = new ArrayList<RegistroC880>();
    
    protected List<RegistroC880> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC880 = new RegistroC880();                
                registroC880.setCOD_ITEM(RS.getString(""));    
                registroC880.setCFOP(RS.getString(""));  
                registroC880.setVL_ITEM(RS.getString(""));    
                registroC880.setCST_PIS(RS.getString(""));
                registroC880.setQUANT_BC_PIS(RS.getString(""));                 
                registroC880.setALIQ_PIS_QUANT(RS.getString(""));    
                registroC880.setVL_PIS(RS.getString(""));  
                registroC880.setCST_COFINS(RS.getString(""));    
                registroC880.setQUANT_BC_COFINS(RS.getString(""));
                registroC880.setALIQ_COFINS_QUANT(RS.getString(""));                  
                registroC880.setVL_COFINS(RS.getString(""));    
                registroC880.setCOD_CTA(RS.getString(""));                    
                
                registrosC880.add(registroC880);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC880.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC880;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C880").append("|");
            conteudo.append(geral.efdRemoveSinais(getCOD_ITEM())).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getCFOP()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getVL_ITEM(), 9)).append("|");
            conteudo.append(geral.efdNumerico(getCST_PIS(), 9)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_PIS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_PIS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_PIS()), 2)).append("|");
            conteudo.append(geral.efdNumerico(getCST_COFINS(), 2)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getQUANT_BC_COFINS()), 3)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getALIQ_COFINS_QUANT()), 4)).append("|");
            conteudo.append(geral.efdNumerico(Float.parseFloat(getVL_COFINS()), 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC880.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
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

class RegistroC890 {

    private String REG;
    private String NUM_PROC;
    private String IND_PROC;
    private StringBuilder conteudo;

    RegistroC890 registroC890 = new RegistroC890();
    List<RegistroC890> registrosC890 = new ArrayList<RegistroC890>();
    
    protected List<RegistroC890> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC890 = new RegistroC890();                
                registroC890.setNUM_PROC(RS.getString(""));    
                registroC890.setIND_PROC(RS.getString(""));                               
                
                registrosC890.add(registroC890);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC890.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC890;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C890").append("|");
            conteudo.append(geral.efdRemoveSinais(getNUM_PROC())).append("|");
            conteudo.append(geral.efdNumerico(getIND_PROC(), 1)).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC890.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC990 {

    private String REG;
    private String QTD_LIN_C;
    private StringBuilder conteudo;

    RegistroC990 registroC990 = new RegistroC990();
    List<RegistroC990> registrosC990 = new ArrayList<RegistroC990>();
    
    protected List<RegistroC990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registroC990 = new RegistroC990();                
                registroC990.setQTD_LIN_C(RS.getString(""));                                               
                
                registrosC990.add(registroC990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC890.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registrosC990;
    }

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|C990").append("|");
            conteudo.append(geral.efdRemoveSinais(getQTD_LIN_C())).append("|");

            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC990.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getQTD_LIN_C() {
        return QTD_LIN_C;
    }

    public void setQTD_LIN_C(String QTD_LIN_C) {
        this.QTD_LIN_C = QTD_LIN_C;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}
