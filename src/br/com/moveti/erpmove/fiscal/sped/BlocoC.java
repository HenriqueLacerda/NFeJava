/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped;

import br.com.moveti.erpmove.fiscal.nfe._Funcoes;
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
public class BlocoC {

    private RegistroC100 registroC100 = new RegistroC100();   
    private RegistroC170 registroC170 = new RegistroC170();
    private RegistroC990 registroC990 = new RegistroC990();
    private StringBuilder conteudoGerado;

    public BlocoC() {
        conteudoGerado = gerarEFD();
    }

    public StringBuilder gerarEFD() {
        int contadorGeral = 0;
        StringBuilder conteudo = null;
        try {
            registroC100 = new RegistroC100();
            registroC990 = new RegistroC990();

            conteudo = (registroC100.gerarRegistro());

            //Formatacao dos dados para preenchimento do arquivo.

            contadorGeral = registroC100.getContador100() + registroC170.getContador170();
            System.out.println(conteudo);
            conteudo.append(registroC990.gerarRegistro(contadorGeral));
            System.out.println("--- O Bloco C possui " + contadorGeral + " linhas.");
            return conteudo;
        } catch (Exception e) {
            Logger.getLogger(Bloco0.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public StringBuilder getConteudoGerado() {
        return conteudoGerado;
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
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C001").append("|");
            conteudo.append(IND_MOV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC001.class.getName()).log(Level.SEVERE, null, e);
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
//    private RegistroC105 registroC105 = new RegistroC105();
//    private List<RegistroC110> registroC110 = new ArrayList<RegistroC110>();
//    private List<RegistroC120> registroC120 = new ArrayList<RegistroC120>();
//    private RegistroC130 registroC130 = new RegistroC130();
//    private RegistroC140 registroC140 = new RegistroC140();
//    private List<RegistroC141> registroC141 = new ArrayList<RegistroC141>();
//    private RegistroC160 registroC160 = new RegistroC160();
//    private List<RegistroC165> registroC165 = new ArrayList<RegistroC165>();
    private List<RegistroC170> registroC170 = new ArrayList<RegistroC170>();
//    private List<RegistroC190> registroc190 = new ArrayList<RegistroC190>();
//    private List<RegistroC195> registroc195 = new ArrayList<RegistroC195>();
    private int contador100 = 0;

    protected StringBuilder gerarRegistro() {
        //Variaveis de auxilio para retornar cada C170 dentro de cada C100
        int cont170 = 0;       
        RegistroC170 registC170 = new RegistroC170();
        RegistroC190 registroC190 = new RegistroC190();
        List<StringBuilder> listaConteudoC170 = new ArrayList<StringBuilder>();
        StringBuilder conteudo = new StringBuilder();
        
        //----------------------------------------------------------------------
        //Buscar todos os C170 existentes
        
        
        ResultSet RS = null;      
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");
//        String sql = "SELECT * FROM notafiscal as nf ";
        String sql = "SELECT * FROM notafiscal as nf WHERE nf.assinada = 1 AND nf.transmitida = 1 AND nf.transmitidacodigostatus = 100";        
        RS = con.executaSQL(sql);               
        try {
            while (RS.next()) {                
                conteudo.append("|C100").append("|");
                if(RS.getString("entradasaida").equals("S")){
                    conteudo.append("1").append("|");
                }else{
                    conteudo.append("0").append("|");
                }
                conteudo.append("0").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("id_clientefornecedor"), 60)).append("|");
                conteudo.append("55").append("|");
                //COD_SIT
                conteudo.append("00").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("serie"), 3)).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("idnotafiscal"), 9)).append("|");
                conteudo.append(RS.getString("chaveacesso")).append("|");
                conteudo.append(geral.efdRemoveSinais(_Funcoes.parseDataBra(RS.getString("dataemissao")))).append("|");
                conteudo.append(geral.efdRemoveSinais(_Funcoes.parseDataBra(RS.getString("datasaida")))).append("|");
                conteudo.append(RS.getString("valortotalnota").replace(".", ",")).append("|");
                conteudo.append(RS.getString("tipopagamento")).append("|");
                conteudo.append(RS.getString("valordescontototal").replace(".", ",")).append("|");
                conteudo.append("0,00").append("|");
                conteudo.append(RS.getString("valortotalprodutos").replace(".", ",")).append("|");
                conteudo.append(RS.getString("freteporconta")).append("|");
                conteudo.append(RS.getString("valorfrete").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valorseguro").replace(".", ",")).append("|");
                conteudo.append(RS.getString("outrasdespesas").replace(".", ",")).append("|");
                conteudo.append(RS.getString("baseicms").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valoricms").replace(".", ",")).append("|");
                conteudo.append(RS.getString("baseicmssubstituicao").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valoricmssubstituicao").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valoripi").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valorpis").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valorcofins").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valorpisst").replace(".", ",")).append("|");
                conteudo.append(RS.getString("valorcofinsst").replace(".", ",")).append("|");
                conteudo.append("\r\n");
                contador100++;
                //Para cada C100 listar o C170 correspondente.
          
//                listaConteudoC170 = registC170.gerarRegistro(RS.getString("idnotafiscal"));
//                for(int i = 0;i<listaConteudoC170.size();i++){
//                    conteudo.append(listaConteudoC170.get(i));
//                }
                 conteudo.append(registroC190.gerarRegistro(RS.getString("idnotafiscal")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC100.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(conteudo);
        System.out.println("--- O Registro C100 possui " + getContador100() + " linhas.");
        //Soma o contador do C170 no contador do C100 
        contador100 = contador100 + registC170.getContador170();
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

    public int getContador100() {
        return contador100;
    }
}

class RegistroC105 {
//Texto fixo contendo "C105"

    private String REG;
//Indicador do tipo de operação:
//0- Combustíveis e Lubrificantes;
//1- leasing de veículos ou faturamento direto.
    private String OPER;
//Sigla da UF de destino do ICMS_ST
    private String UF;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C105").append("|");
            conteudo.append(OPER).append("|");
            conteudo.append(UF).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC105.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getOPER() {
        return OPER;
    }

    public void setOPER(String OPER) {
        this.OPER = OPER;
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

class RegistroC110 {
//Texto fixo contendo "C110"

    private String REG;
//Código da informação complementar do documento fiscal (campo 02 do Registro 0450)
    private String COD_INF;
//Descrição complementar do código de referência.
    private String TXT_COMPL;
    private List<RegistroC111> registroC111 = new ArrayList<RegistroC111>();
    private List<RegistroC112> registroC112 = new ArrayList<RegistroC112>();
    private List<RegistroC113> registroC113 = new ArrayList<RegistroC113>();
    private List<RegistroC114> registroC114 = new ArrayList<RegistroC114>();
    private List<RegistroC115> registroC115 = new ArrayList<RegistroC115>();
    private List<RegistroC116> registroC116 = new ArrayList<RegistroC116>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C110").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_INF, 6)).append("|");
            conteudo.append(TXT_COMPL).append("|");
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

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C111").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_PROC, 15)).append("|");
            conteudo.append(IND_PROC).append("|");
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

class RegistroC112 {
//Texto fixo contendo "C112"

    private String REG;
//Código do modelo do documento de arrecadação : 0 - documento estadual de arrecadação
//1 – GNRE
    private String COD_DA;
//Unidade federada beneficiária do recolhimento
    private String UF;
//Número do documento de arrecadação
    private String NUM_DA;
//Código completo da autenticação bancária
    private String COD_AUT;
//Valor do total do documento de arrecadação (principal, atualização monetária, juros e multa)    
    private String VL_DA;
//Data de vencimento do documento de arrecadação    
    private String DT_VCTO;
//Data de pagamento do documento de arrecadação, ou data do vencimento, no caso de ICMS antecipado a recolher.    
    private String DT_PGTO;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C112").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_DA, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF, 1)).append("|");
            conteudo.append(NUM_DA).append("|");
            conteudo.append(COD_AUT).append("|");
            conteudo.append(VL_DA).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_VCTO)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_PGTO)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC112.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_AUT() {
        return COD_AUT;
    }

    public void setCOD_AUT(String COD_AUT) {
        this.COD_AUT = COD_AUT;
    }

    public String getCOD_DA() {
        return COD_DA;
    }

    public void setCOD_DA(String COD_DA) {
        this.COD_DA = COD_DA;
    }

    public String getDT_PGTO() {
        return DT_PGTO;
    }

    public void setDT_PGTO(String DT_PGTO) {
        this.DT_PGTO = DT_PGTO;
    }

    public String getDT_VCTO() {
        return DT_VCTO;
    }

    public void setDT_VCTO(String DT_VCTO) {
        this.DT_VCTO = DT_VCTO;
    }

    public String getNUM_DA() {
        return NUM_DA;
    }

    public void setNUM_DA(String NUM_DA) {
        this.NUM_DA = NUM_DA;
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

    public String getVL_DA() {
        return VL_DA;
    }

    public void setVL_DA(String VL_DA) {
        this.VL_DA = VL_DA;
    }
}

class RegistroC113 {

    private String REG;
    private String IND_OPER;
    private String IND_EMIT;
    private String COD_PART;
    private String COD_MOD;
    private String SER;
    private String SUB;
    private String NUM_DOC;
    private String DT_DOC;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C113").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_OPER, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(IND_EMIT, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC113.class.getName()).log(Level.SEVERE, null, e);
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
}

class RegistroC114 {

    private String REG;
//Texto fixo contendo "C114"
    private String COD_MOD;
//Código do modelo do documento fiscal, conforme a tabela indicada no item 4.1.1
    private String ECF_FAB;
//Número de série de fabricação do ECF
    private String ECF_CX;
//Número do caixa atribuído ao ECF
    private String NUM_DOC;
//Número do documento fiscal
    private String DT_DOC;
//Data da emissão do documento fiscal
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C114").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(ECF_FAB, 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(ECF_CX, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC114.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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
}

class RegistroC115 {

    private String REG;
//Texto fixo contendo "C115"
    private String IND_CARGA;
//Indicador do tipo de transporte: 0 – Rodoviário;
//1 – Ferroviário;
//2 – Rodo-Ferroviário;
//3 – Aquaviário; 4 – Dutoviário; 5 – Aéreo;
//9 – Outros.
    private String CNPJ_COL;
//Número do CNPJ do contribuinte do local de coleta
    private String IE_COL;
//Inscrição Estadual do contribuinte do local de coleta
    private String CPF_COL;
//CPF do contribuinte do local de coleta das mercadorias.
    private String COD_MUN_COL;
//Código do Município do local de coleta        
    private String CNPJ_ENTG;
//Número do CNPJ do contribuinte do local de entrega
    private String IE_ENTG;
//Inscrição Estadual do contribuinte do local de entrega
    private String CPF_ENTG;
//Cpf do contribuinte do local de entrega
    private String COD_MUN_ENTG;
//Código do Município do local de entreg
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C115").append("|");
            conteudo.append(geral.efdAlfanumerico(IND_CARGA, 1)).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_COL)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_COL)).append("|");
            conteudo.append(geral.efdRemoveSinais(CPF_COL)).append("|");
            conteudo.append(geral.efdRemoveSinais(COD_MUN_COL)).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_ENTG)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE_ENTG)).append("|");
            conteudo.append(geral.efdRemoveSinais(CPF_ENTG)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN_ENTG)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC115.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCNPJ_COL() {
        return CNPJ_COL;
    }

    public void setCNPJ_COL(String CNPJ_COL) {
        this.CNPJ_COL = CNPJ_COL;
    }

    public String getCNPJ_ENTG() {
        return CNPJ_ENTG;
    }

    public void setCNPJ_ENTG(String CNPJ_ENTG) {
        this.CNPJ_ENTG = CNPJ_ENTG;
    }

    public String getCOD_MUN_COL() {
        return COD_MUN_COL;
    }

    public void setCOD_MUN_COL(String COD_MUN_COL) {
        this.COD_MUN_COL = COD_MUN_COL;
    }

    public String getCOD_MUN_ENTG() {
        return COD_MUN_ENTG;
    }

    public void setCOD_MUN_ENTG(String COD_MUN_ENTG) {
        this.COD_MUN_ENTG = COD_MUN_ENTG;
    }

    public String getCPF_COL() {
        return CPF_COL;
    }

    public void setCPF_COL(String CPF_COL) {
        this.CPF_COL = CPF_COL;
    }

    public String getCPF_ENTG() {
        return CPF_ENTG;
    }

    public void setCPF_ENTG(String CPF_ENTG) {
        this.CPF_ENTG = CPF_ENTG;
    }

    public String getIE_COL() {
        return IE_COL;
    }

    public void setIE_COL(String IE_COL) {
        this.IE_COL = IE_COL;
    }

    public String getIE_ENTG() {
        return IE_ENTG;
    }

    public void setIE_ENTG(String IE_ENTG) {
        this.IE_ENTG = IE_ENTG;
    }

    public String getIND_CARGA() {
        return IND_CARGA;
    }

    public void setIND_CARGA(String IND_CARGA) {
        this.IND_CARGA = IND_CARGA;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

//Observações:
//Nível hierárquico - 4 Ocorrência - 1:N
//Descrição
//Texto fixo contendo "C116"
//Código do modelo do documento fiscal, conforme a Tabela 4.1.1
//Número de Série do equipamento SAT
//Chave do Cupom Fiscal Eletrônico
//Número do cupom fiscal eletrônico
//Data da emissão do documento fiscal
class RegistroC116 {

    private String REG;
    private String COD_MOD;
    private String NR_SAT;
    private String CHV_CFE;
    private String NUM_CFE;
    private String DT_DOC;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C116").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(NR_SAT).append("|");
            conteudo.append(CHV_CFE).append("|");
            conteudo.append(NUM_CFE).append("|");
            conteudo.append(DT_DOC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC116.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCHV_CFE() {
        return CHV_CFE;
    }

    public void setCHV_CFE(String CHV_CFE) {
        this.CHV_CFE = CHV_CFE;
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
}
//Observações:
//Nível hierárquico - 4 Ocorrência - 1:N
//Descrição
//Texto fixo contendo "C116"
//Código do modelo do documento fiscal, conforme a Tabela 4.1.1
//Número de Série do equipamento SAT
//Chave do Cupom Fiscal Eletrônico
//Número do cupom fiscal eletrônico
//Data da emissão do documento fiscal

class RegistroC120 {

    private String REG;
//C 004 - O Não
//C 001* - O apresent ar
//C 010 - O
//N -02 OC
//N -02 OC
//C 020 - OC
    private String COD_DOC_IMP;
    private String NUM_DOC__IMP;
    private String PIS_IMP;
    private String COFINS_IMP;
    private String NUM_ACDRAW;
//Documento de importação:
//0 – Declaração de Importação;
//1 – Declaração Simplificada de Importação.
//Número do documento de Importação.
//Valor pago de PIS na importação
//Valor pago de COFINS na importação
//Número do Ato Concessório do regime Drawback
//    private String VL_SERV_NT;
//    private String VL_BC_ISSQN;
//    private String VL_ISSQN;
//    private String VL_BC_IRRF;
//    private String VL_IRRF;
//Valor dos serviços sob não-incidência ou não- N - 02 tributados pelo ICMS
//Valor da base de cálculo do ISSQN N - 02
//V alor do ISSQN N - 02
//Valor da base de cálculo do Imposto de Renda N - 02 Retido na Fonte
//Valor do Imposto de Renda - Retido na Fonte
//    
//    private String VL_BC_PREV;
//Valor da base de cálculo de retenção da N Previdência Social
//Guia Prático EFD – Versão 2.0.4 Atualização: 11 de março de 2011
//- 02 OC
//- 02 OC
//08 VL_PREV
//Valor destacado para retenção da Previdência N Social
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C120").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_DOC_IMP, 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC__IMP, 10)).append("|");
            conteudo.append(PIS_IMP).append("|");
            conteudo.append(COFINS_IMP).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_ACDRAW, 20)).append("|");
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

    public String getCOFINS_IMP() {
        return COFINS_IMP;
    }

    public void setCOFINS_IMP(String COFINS_IMP) {
        this.COFINS_IMP = COFINS_IMP;
    }

    public String getNUM_ACDRAW() {
        return NUM_ACDRAW;
    }

    public void setNUM_ACDRAW(String NUM_ACDRAW) {
        this.NUM_ACDRAW = NUM_ACDRAW;
    }

    public String getNUM_DOC__IMP() {
        return NUM_DOC__IMP;
    }

    public void setNUM_DOC__IMP(String NUM_DOC__IMP) {
        this.NUM_DOC__IMP = NUM_DOC__IMP;
    }

    public String getPIS_IMP() {
        return PIS_IMP;
    }

    public void setPIS_IMP(String PIS_IMP) {
        this.PIS_IMP = PIS_IMP;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
//    public String getVL_BC_IRRF() {
//        return VL_BC_IRRF;
//    }
//
//    public void setVL_BC_IRRF(String VL_BC_IRRF) {
//        this.VL_BC_IRRF = VL_BC_IRRF;
//    }
//
//    public String getVL_BC_ISSQN() {
//        return VL_BC_ISSQN;
//    }
//
//    public void setVL_BC_ISSQN(String VL_BC_ISSQN) {
//        this.VL_BC_ISSQN = VL_BC_ISSQN;
//    }
//
//    public String getVL_BC_PREV() {
//        return VL_BC_PREV;
//    }
//
//    public void setVL_BC_PREV(String VL_BC_PREV) {
//        this.VL_BC_PREV = VL_BC_PREV;
//    }
//
//    public String getVL_IRRF() {
//        return VL_IRRF;
//    }
//
//    public void setVL_IRRF(String VL_IRRF) {
//        this.VL_IRRF = VL_IRRF;
//    }
//
//    public String getVL_ISSQN() {
//        return VL_ISSQN;
//    }
//
//    public void setVL_ISSQN(String VL_ISSQN) {
//        this.VL_ISSQN = VL_ISSQN;
//    }
//
//    public String getVL_SERV_NT() {
//        return VL_SERV_NT;
//    }
//
//    public void setVL_SERV_NT(String VL_SERV_NT) {
//        this.VL_SERV_NT = VL_SERV_NT;
//    }
}

class RegistroC130 {

    private String REG;
    private String VL_SERV_NT;
    private String VL_BC_ISSQN;
    private String VL_ISSQN;
    private String VL_BC_IRRF;
    private String VL_IRRF;
    private String VL_BC_PREV;
    private String VL_PREV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C130").append("|");
            conteudo.append(VL_SERV_NT).append("|");
            conteudo.append(VL_BC_ISSQN).append("|");
            conteudo.append(VL_BC_IRRF).append("|");
            conteudo.append(VL_IRRF).append("|");
            conteudo.append(VL_BC_PREV).append("|");
            conteudo.append(VL_PREV).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC130.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_BC_IRRF() {
        return VL_BC_IRRF;
    }

    public void setVL_BC_IRRF(String VL_BC_IRRF) {
        this.VL_BC_IRRF = VL_BC_IRRF;
    }

    public String getVL_BC_ISSQN() {
        return VL_BC_ISSQN;
    }

    public void setVL_BC_ISSQN(String VL_BC_ISSQN) {
        this.VL_BC_ISSQN = VL_BC_ISSQN;
    }

    public String getVL_BC_PREV() {
        return VL_BC_PREV;
    }

    public void setVL_BC_PREV(String VL_BC_PREV) {
        this.VL_BC_PREV = VL_BC_PREV;
    }

    public String getVL_IRRF() {
        return VL_IRRF;
    }

    public void setVL_IRRF(String VL_IRRF) {
        this.VL_IRRF = VL_IRRF;
    }

    public String getVL_ISSQN() {
        return VL_ISSQN;
    }

    public void setVL_ISSQN(String VL_ISSQN) {
        this.VL_ISSQN = VL_ISSQN;
    }

    public String getVL_PREV() {
        return VL_PREV;
    }

    public void setVL_PREV(String VL_PREV) {
        this.VL_PREV = VL_PREV;
    }

    public String getVL_SERV_NT() {
        return VL_SERV_NT;
    }

    public void setVL_SERV_NT(String VL_SERV_NT) {
        this.VL_SERV_NT = VL_SERV_NT;
    }
}

class RegistroC140 {

    private String REG;
    private String IND_EMIT;
    private String IND_TIT;
    private String DESC_TIT;
    private String NUM_TIT;
    private String QTD_PARC;
    private String VL_TIT;
//Texto fixo contendo "C140"
//Indicador do emitente do título: 0- Emissão própria;
//1- Terceiros
//Indicador do tipo de título de crédito: 00- Duplicata;
//01- Cheque;
//02- Promissória;
//03- Recibo;
//99- Outros (descrever)
//Descrição complementar do título de crédito
//Número ou código identificador do título de crédito
//Quantidade de parcelas a receber/pagar
//V alor total dos títulos de créditos
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C140").append("|");
            conteudo.append(IND_EMIT).append("|");
            conteudo.append(IND_TIT).append("|");
            conteudo.append(DESC_TIT).append("|");
            conteudo.append(NUM_TIT).append("|");
            conteudo.append(QTD_PARC).append("|");
            conteudo.append(VL_TIT).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC140.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDESC_TIT() {
        return DESC_TIT;
    }

    public void setDESC_TIT(String DESC_TIT) {
        this.DESC_TIT = DESC_TIT;
    }

    public String getIND_EMIT() {
        return IND_EMIT;
    }

    public void setIND_EMIT(String IND_EMIT) {
        this.IND_EMIT = IND_EMIT;
    }

    public String getIND_TIT() {
        return IND_TIT;
    }

    public void setIND_TIT(String IND_TIT) {
        this.IND_TIT = IND_TIT;
    }

    public String getNUM_TIT() {
        return NUM_TIT;
    }

    public void setNUM_TIT(String NUM_TIT) {
        this.NUM_TIT = NUM_TIT;
    }

    public String getQTD_PARC() {
        return QTD_PARC;
    }

    public void setQTD_PARC(String QTD_PARC) {
        this.QTD_PARC = QTD_PARC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_TIT() {
        return VL_TIT;
    }

    public void setVL_TIT(String VL_TIT) {
        this.VL_TIT = VL_TIT;
    }
}

class RegistroC141 {

    private String REG;
//Texto fixo contendo "C141"
    private String NUM_PARC;
//Número da parcela a receber/pagar
    private String DT_VCTO;
//Data de vencimento da parcela
    private String VL_PARC;
//Valor da parcela a receber/pagar
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C141").append("|");
            conteudo.append(NUM_PARC).append("|");
            conteudo.append(DT_VCTO).append("|");
            conteudo.append(VL_PARC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC141.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDT_VCTO() {
        return DT_VCTO;
    }

    public void setDT_VCTO(String DT_VCTO) {
        this.DT_VCTO = DT_VCTO;
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

    public String getVL_PARC() {
        return VL_PARC;
    }

    public void setVL_PARC(String VL_PARC) {
        this.VL_PARC = VL_PARC;
    }
}

class RegistroC160 {

    private String REG;
//Texto fixo contendo "C160"
    private String COD_PART;
//Código do participante (campo 02 do Registro 0150): r - transportador, se houver
    private String VEIC_ID;
//Placa de identificação do veículo automotor
    private String QTD_VOL;
//Quantidade de volumes transportados
    private String PESO_BRT;
//Peso bruto dos volumes transportados (em Kg)
    private String PESO_LIQ;
//Peso líquido dos volumes transportados (em Kg)
    private String UF_ID;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C160").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(VEIC_ID, 7)).append("|");
            conteudo.append(QTD_VOL).append("|");
            conteudo.append(PESO_BRT).append("|");
            conteudo.append(PESO_LIQ).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_ID, 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC160.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
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

    public String getQTD_VOL() {
        return QTD_VOL;
    }

    public void setQTD_VOL(String QTD_VOL) {
        this.QTD_VOL = QTD_VOL;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
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

class RegistroC165 {

    private String REG;
    private String COD_PART;
//02
    private String VEIC_ID;
    private String COD_AUT;
    private String NR_PASSE;
    private String HORA;
    private String TEMPER;
    private String QTD_VOL;
    private String PESO_BRT;
    private String PESO_LIQ;
    private String NOM_MOT;
    private String CPF;
    private String UF_ID;
//Texto fixo contendo "C165”
//Código do participante (campo 02 do Registro 0150):
//- transportador, se houver
//Placa de identificação do veículo
//Código da autorização fornecido pela SEFAZ (combustíveis)
//Número do Passe Fiscal
//Hora da saída das mercadorias    
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C165").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(VEIC_ID, 7)).append("|");
            conteudo.append(COD_AUT).append("|");
            conteudo.append(NR_PASSE).append("|");
            conteudo.append(geral.efdRemoveSinais(HORA)).append("|");
            conteudo.append(TEMPER).append("|");
            conteudo.append(QTD_VOL).append("|");
            conteudo.append(PESO_BRT).append("|");
            conteudo.append(PESO_LIQ).append("|");
            conteudo.append(geral.efdAlfanumerico(NOM_MOT, 60)).append("|");
            conteudo.append(geral.efdRemoveSinais(CPF)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF_ID, 2)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC165.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_AUT() {
        return COD_AUT;
    }

    public void setCOD_AUT(String COD_AUT) {
        this.COD_AUT = COD_AUT;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    public String getNR_PASSE() {
        return NR_PASSE;
    }

    public void setNR_PASSE(String NR_PASSE) {
        this.NR_PASSE = NR_PASSE;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTEMPER() {
        return TEMPER;
    }

    public void setTEMPER(String TEMPER) {
        this.TEMPER = TEMPER;
    }

    public String getVEIC_ID() {
        return VEIC_ID;
    }

    public void setVEIC_ID(String VEIC_ID) {
        this.VEIC_ID = VEIC_ID;
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

    public String getNOM_MOT() {
        return NOM_MOT;
    }

    public void setNOM_MOT(String NOM_MOT) {
        this.NOM_MOT = NOM_MOT;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getUF_ID() {
        return UF_ID;
    }

    public void setUF_ID(String UF_ID) {
        this.UF_ID = UF_ID;
    }

    public String getQTD_VOL() {
        return QTD_VOL;
    }

    public void setQTD_VOL(String QTD_VOL) {
        this.QTD_VOL = QTD_VOL;
    }
}

class RegistroC170 {

    private String REG;
    private String NUM_ITEM;
    private String COD_ITEM;
    private String DESCR_COMPL;
    private String QTD;
    private String UNID;
    private String VL_ITEM;
    private String VL_DESC;
    private String IND_MOV;
    private String CST_ICMS;
    private String CFOP;
    private String COD_NAT;
    private String VL_BC_ICMS;
    private String ALIQ_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String ALIQ_ST;
    private String VL_ICMS_ST;
//Descrição
//Texto fixo contendo "C170"
//Número sequencial do item no documento fiscal Código do item (campo 02 do Registro 0200) Descrição complementar do item como adotado no documento fiscal
//Quantidade do item
//Unidade do item (Campo 02 do registro 0190) Valor total do item (mercadorias ou serviços) Valor do desconto comercial
//Movimentação física do ITEM/PRODUTO:
//0. SIM
//1. NÃO
//Código da Situação Tributária referente ao ICMS, conforme a Tabela indicada no item 4.3.1 Código Fiscal de Operação e Prestação
//Código da natureza da operação (campo 02 do Registro 0400)
//V alor da base de cálculo do ICMS
//Alíquota do ICMS
//V alor do ICMS creditado/debitado
//V alor da base de cálculo referente à substituição tributária
//Alíquota do ICMS da substituição tributária na unidade da federação de destino
//Valor do ICMS referente à substituição tributária
    private String IND_APUR;
    private String CST_IPI;
    private String COD_ENQ;
    private String VL_BC_IPI;
    private String ALIQ_IPI;
    private String VL_IPI;
    private String CST_PIS;
    private String VL_BC_PIS;
    private String ALIQ_PIS;
    private String QUANT_BC_PIS;
    private String ALIQ_PIS_REAIS;
    private String VL_PIS;
    private String CST_COFINS;
    private String VL_BC_COFINS;
    private String ALIQ_COFINS_PERCENTUAL;
    private String ALIQ_COFINS_VALOR;
    private String QUANT_BC_COFINS;
    private String VL_COFINS;
    private String COD_CTA;
//    private List<RegistroC171> registroC171 = new ArrayList<RegistroC171>();
//    private RegistroC172 registroC172 = new RegistroC172();
//    private List<RegistroC173> registroC173 = new ArrayList<RegistroC173>();
//    private List<RegistroC174> registroC174 = new ArrayList<RegistroC174>();
//    private List<RegistroC175> registroC175 = new ArrayList<RegistroC175>();
//    private List<RegistroC176> registroC176 = new ArrayList<RegistroC176>();
//    private RegistroC177 registroC177 = new RegistroC177();
//    private RegistroC178 registroC178 = new RegistroC178();
//    private RegistroC179 registroC179 = new RegistroC179();
//Indicador de período de apuração do IPI: C 0 - Mensal;
//1 - Decendial
//Código da Situação Tributária referente ao IPI, C conforme a Tabela indicada no item 4.3.2.
//Código de enquadramento legal do IPI, conforme C tabela indicada no item 4.5.3.
//Valor da base de cálculo do IPI N
//001* - OC OC
//002* - OC OC
//003* - OC OC
//-02 OC OC
//Alíquota do IPI N 006 02 ￼ OC OC
//Valor do IPI creditado/debitado N
//Código da Situação Tributária referente ao PIS. N
//Valor da base de cálculo do PIS N
//Alíquota do PIS (em percentual) N
//Quantidade – Base de cálculo PIS N
//Alíquota do PIS (em reais) N
//Valor do PIS N
//Código da Situação Tributária referente ao N COFINS.
//Valor da base de cálculo da COFINS
    private int contador170 = 0;

    protected List<StringBuilder> gerarRegistro(String nota) {
        StringBuilder conteudo = new StringBuilder();
        List<StringBuilder> listaConteudo = new ArrayList<StringBuilder>();
        int codnumerico = 1;
        ResultSet RS = null;
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");
        ////SELECT nf.*,cst.codigo FROM notafiscal as nf ,notafiscal_produto as nfp, codigoscstpiscofins as cst WHERE cst.id = nfp.cstpis OR cst.id = nfp.cstcofins AND nf.idnotafiscal = nfp.idnotafiscal";
        String sql = "SELECT DISTINCT nfp.idproduto,p.nome,p.unidade,p.origem_mercadoria,nfp.quantidade,nfp.valorunitario,nfp.valordesconto,nfp.cfop,"
                + "nfp.csticms,nfp.valorbcicms,nfp.icms,nfp.valoricms,nfp.valoricms,nfp.valorbcicmsst,nfp.valoricmsst,"
                + "nfp.cstipi,nfp.ipi,nfp.valoripi,"
                + "nfp.valorbcpis,nfp.cstpis,nfp.valorbcpis,nfp.aliquotapis,nfp.valorpis,"
                + "nfp.cstcofins,nfp.valorbccofins,nfp.aliquotacofins,nfp.valorcofins, "
                + "cst.codigo "
                + "FROM notafiscal_produto as nfp ,produtos as p,codigoscstpiscofins as cst,notafiscal as nf WHERE nfp.idproduto = p.id AND (cst.id = nfp.cstpis OR cst.id = nfp.cstcofins) AND nfp.idnotafiscal = "+nota+" GROUP BY nfp.idproduto";
        RS = con.executaSQL(sql);
        System.out.println("SQL 170 :"+sql);
        try {
            while (RS.next()) {
                conteudo = new StringBuilder();
                conteudo.append("|C170").append("|");
                conteudo.append(geral.efdAlfanumerico(String.valueOf(codnumerico), 3)).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("idproduto"), 60)).append("|");
                conteudo.append(RS.getString("nome")).append("|");
                conteudo.append(RS.getString("quantidade").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("unidade"), 6)).append("|");
                conteudo.append(RS.getString("valorunitario").replace(".",",")).append("|");
                conteudo.append(RS.getString("valordesconto").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico("1", 1)).append("|");
                conteudo.append(RS.getString("origem_mercadoria").concat(RS.getString("csticms"))).append("|");
                conteudo.append(geral.efdRemoveSinais(RS.getString("cfop"))).append("|");
                //COD_NAT :Código da natureza da operação (campo 02 do Registro 0400)
                conteudo.append(geral.efdAlfanumerico(RS.getString("cfop"), 10)).append("|");
                conteudo.append(RS.getString("valorbcicms").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("icms").replace(".",","), 6)).append("|");
                conteudo.append(RS.getString("valoricms").replace(".",",")).append("|");
                conteudo.append(RS.getString("valorbcicmsst").replace(".",",")).append("|");
                conteudo.append(RS.getString("icms").replace(".",",")).append("|");
                conteudo.append(RS.getString("valoricmsst").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico("0", 1)).append("|");
                conteudo.append(RS.getString("cstipi")).append("|");
                //Não preencher
                conteudo.append("").append("|");
                conteudo.append(RS.getString("valorbcpis").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("ipi").replace(".",","), 6)).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("valoripi").replace(".",","), 60)).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("codigo"), 2)).append("|");
                conteudo.append(RS.getString("valorbcpis").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("aliquotapis").replace(".",","), 8)).append("|");
                //QUANT_BC_PIS
                conteudo.append("0").append("|");
                conteudo.append(RS.getString("valorpis").replace(".",",")).append("|");
                conteudo.append(RS.getString("valorpis").replace(".",",")).append("|");
                conteudo.append(RS.getString("codigo").replace(".",",")).append("|");
                conteudo.append(RS.getString("valorbccofins").replace(".",",")).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("aliquotacofins").replace(".",","), 8)).append("|");
                //QUANT_BC_COFINS()
                conteudo.append("0").append("|");
                conteudo.append(RS.getString("aliquotacofins").replace(".",",")).append("|");
                conteudo.append(RS.getString("valorcofins").replace(".",",")).append("|");
                conteudo.append("0").append("|");
                conteudo.append("\r\n");
                contador170++;
                codnumerico++;
                listaConteudo.add(conteudo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroC170.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        System.out.println(conteudo);
        System.out.println("--- O Registro C170 possui " + getContador170() + " linhas.");
        return listaConteudo;
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

    public String getALIQ_PIS_REAIS() {
        return ALIQ_PIS_REAIS;
    }

    public void setALIQ_PIS_REAIS(String ALIQ_PIS_REAIS) {
        this.ALIQ_PIS_REAIS = ALIQ_PIS_REAIS;
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

    public String getALIQ_COFINS_PERCENTUAL() {
        return ALIQ_COFINS_PERCENTUAL;
    }

    public void setALIQ_COFINS_PERCENTUAL(String ALIQ_COFINS_PERCENTUAL) {
        this.ALIQ_COFINS_PERCENTUAL = ALIQ_COFINS_PERCENTUAL;
    }

    public String getALIQ_COFINS_VALOR() {
        return ALIQ_COFINS_VALOR;
    }

    public void setALIQ_COFINS_VALOR(String ALIQ_COFINS_VALOR) {
        this.ALIQ_COFINS_VALOR = ALIQ_COFINS_VALOR;
    }

    public String getQUANT_BC_COFINS() {
        return QUANT_BC_COFINS;
    }

    public void setQUANT_BC_COFINS(String QUANT_BC_COFINS) {
        this.QUANT_BC_COFINS = QUANT_BC_COFINS;
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

    public int getContador170() {
        return contador170;
    }
}

class RegistroC171 {

    private String REG;
    private String NUM_TANQUE;
    private String QTDE;
//Observações:
//Nível hierárquico - 4 Ocorrência - 1:N
//Texto fixo contendo "C171"
//Tanque onde foi armazenado o combustível
//Quantidade ou volume armazenado
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C171").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_TANQUE, 3)).append("|");
            conteudo.append(QTDE).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC171.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getNUM_TANQUE() {
        return NUM_TANQUE;
    }

    public void setNUM_TANQUE(String NUM_TANQUE) {
        this.NUM_TANQUE = NUM_TANQUE;
    }

    public String getQTDE() {
        return QTDE;
    }

    public void setQTDE(String QTDE) {
        this.QTDE = QTDE;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC172 {

    private String REG;
    private String VL_BC_ISSQN;
    private String ALIQ_ISSQN;
    private String VL_ISSQN;
//Texto fixo contendo "C172"
//Valor da base de cálculo do ISSQN
//Alíquota do ISSQN
//Valor do ISSQN
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C172").append("|");
            conteudo.append(VL_BC_ISSQN).append("|");
            conteudo.append(ALIQ_ISSQN).append("|");
            conteudo.append(VL_ISSQN).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC172.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ISSQN() {
        return ALIQ_ISSQN;
    }

    public void setALIQ_ISSQN(String ALIQ_ISSQN) {
        this.ALIQ_ISSQN = ALIQ_ISSQN;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_BC_ISSQN() {
        return VL_BC_ISSQN;
    }

    public void setVL_BC_ISSQN(String VL_BC_ISSQN) {
        this.VL_BC_ISSQN = VL_BC_ISSQN;
    }

    public String getVL_ISSQN() {
        return VL_ISSQN;
    }

    public void setVL_ISSQN(String VL_ISSQN) {
        this.VL_ISSQN = VL_ISSQN;
    }
}

class RegistroC173 {

    private String REG;
    private String LOTE_MED;
    private String QTD_ITEM;
//Texto fixo contendo "C173"
//Número do lote de fabricação do medicamento
//Quantidade de item por lote
    private String DT_FAB;
    private String DT_VAL;
//Data de fabricação do medicamento
    private String IND_MED;
//Indicador de tipo de referência da base de cálculo do ICMS (ST) do produto farmacêutico:
//0- Base de cálculo referente ao preço tabelado ou preço máximo sugerido;
//1- Base cálculo – Margem
//3- Base de cálculo referente à Lista Positiva; 4- Base de cálculo referente à Lista Neutra
    private String TP_PROD;
//        Tipo de produto:
//0- Similar;
//1- Genérico;
//2- Ético ou de marca;
    private String VL_TAB_MAX;
//Valor do preço tabelado ou valor do preço N - 02 O O máximo
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C173").append("|");
            conteudo.append(LOTE_MED).append("|");
            conteudo.append(QTD_ITEM).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FAB)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_VAL)).append("|");
            conteudo.append(IND_MED).append("|");
            conteudo.append(TP_PROD).append("|");
            conteudo.append(VL_TAB_MAX).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC173.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDT_FAB() {
        return DT_FAB;
    }

    public void setDT_FAB(String DT_FAB) {
        this.DT_FAB = DT_FAB;
    }

    public String getIND_MED() {
        return IND_MED;
    }

    public void setIND_MED(String IND_MED) {
        this.IND_MED = IND_MED;
    }

    public String getLOTE_MED() {
        return LOTE_MED;
    }

    public void setLOTE_MED(String LOTE_MED) {
        this.LOTE_MED = LOTE_MED;
    }

    public String getQTD_ITEM() {
        return QTD_ITEM;
    }

    public void setQTD_ITEM(String QTD_ITEM) {
        this.QTD_ITEM = QTD_ITEM;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTP_PROD() {
        return TP_PROD;
    }

    public void setTP_PROD(String TP_PROD) {
        this.TP_PROD = TP_PROD;
    }

    public String getVL_TAB_MAX() {
        return VL_TAB_MAX;
    }

    public void setVL_TAB_MAX(String VL_TAB_MAX) {
        this.VL_TAB_MAX = VL_TAB_MAX;
    }
}

class RegistroC174 {

    private String REG;
    private String IND_ARM;
    private String NUM_ARM;
    private String DESCR_COMPL;
//Texto fixo contendo "C174"
//Indicador do tipo da arma de fogo: 0- Uso permitido;
//1- Uso restrito
//Numeração de série de fabricação da arma
//Descrição da arma, compreendendo: número do cano, calibre, marca, capacidade de cartuchos, tipo de funcionamento, quantidade de canos, comprimento, tipo de alma, quantidade e sentido das raias e demais elementos que permitam sua perfeita identificação
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C174").append("|");
            conteudo.append(IND_ARM).append("|");
            conteudo.append(NUM_ARM).append("|");
            conteudo.append(DESCR_COMPL).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC174.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getDESCR_COMPL() {
        return DESCR_COMPL;
    }

    public void setDESCR_COMPL(String DESCR_COMPL) {
        this.DESCR_COMPL = DESCR_COMPL;
    }

    public String getIND_ARM() {
        return IND_ARM;
    }

    public void setIND_ARM(String IND_ARM) {
        this.IND_ARM = IND_ARM;
    }

    public String getNUM_ARM() {
        return NUM_ARM;
    }

    public void setNUM_ARM(String NUM_ARM) {
        this.NUM_ARM = NUM_ARM;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC175 {

    private String REG;
    private String IND_VEIC_OPER;
    private String CNPJ;
    private String UF;
    private String CHASSI_VEIC;
//Texto fixo contendo "C175"
//Indicador do tipo de operação com veículo: 0- Venda para concessionária;
//1- Faturamento direto;
//2- Venda direta;
//3- Venda da concessionária; 9- Outros
//CNPJ da Concessionária
//Sigla da unidade da federação da Concessionária
//Chassi do veículo
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C175").append("|");
            conteudo.append(IND_VEIC_OPER).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(CHASSI_VEIC, 17)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC175.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCHASSI_VEIC() {
        return CHASSI_VEIC;
    }

    public void setCHASSI_VEIC(String CHASSI_VEIC) {
        this.CHASSI_VEIC = CHASSI_VEIC;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getIND_VEIC_OPER() {
        return IND_VEIC_OPER;
    }

    public void setIND_VEIC_OPER(String IND_VEIC_OPER) {
        this.IND_VEIC_OPER = IND_VEIC_OPER;
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

class RegistroC176 {

    private String REG;
    private String COD_MOD_ULT_E;
    private String NUM_DOC_ULT_E;
    private String SER_ULT_E;
    private String DT_ULT_E;
    private String COD_PART_ULT_E;
//Texto fixo contendo "C176”
//Código do modelo do documento fiscal relativa a última entrada
//Número do documento fiscal relativa a última entrada
//Série do documento fiscal relativa a última entrada
//Data relativa a última entrada da mercadoria
//Código do participante (do emitente do documento relativa a última entrada)
    private String QUANT_ULT_E;
    //￼ Quantidade do item relativa a última entrada
//N - 03 O O
    private String VL_UNIT_ULT_E;
    private String VL_UNIT_BC_ST;
//Observações:
//Nível hierárquico - 4 Ocorrência - 1:N
//Valor unitário da mercadoria constante na NF relativa a última entrada inclusive despesas acessórias.
//Valor unitário da base de cálculo do imposto pago por substituição.
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C176").append("|");
            conteudo.append(COD_MOD_ULT_E).append("|");
            conteudo.append(NUM_DOC_ULT_E).append("|");
            conteudo.append(geral.efdAlfanumerico(SER_ULT_E, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(DT_ULT_E, 8)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART_ULT_E, 60)).append("|");
            conteudo.append(QUANT_ULT_E).append("|");
            conteudo.append(VL_UNIT_ULT_E).append("|");
            conteudo.append(VL_UNIT_BC_ST).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC176.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_MOD_ULT_E() {
        return COD_MOD_ULT_E;
    }

    public void setCOD_MOD_ULT_E(String COD_MOD_ULT_E) {
        this.COD_MOD_ULT_E = COD_MOD_ULT_E;
    }

    public String getCOD_PART_ULT_E() {
        return COD_PART_ULT_E;
    }

    public void setCOD_PART_ULT_E(String COD_PART_ULT_E) {
        this.COD_PART_ULT_E = COD_PART_ULT_E;
    }

    public String getDT_ULT_E() {
        return DT_ULT_E;
    }

    public void setDT_ULT_E(String DT_ULT_E) {
        this.DT_ULT_E = DT_ULT_E;
    }

    public String getNUM_DOC_ULT_E() {
        return NUM_DOC_ULT_E;
    }

    public void setNUM_DOC_ULT_E(String NUM_DOC_ULT_E) {
        this.NUM_DOC_ULT_E = NUM_DOC_ULT_E;
    }

    public String getQUANT_ULT_E() {
        return QUANT_ULT_E;
    }

    public void setQUANT_ULT_E(String QUANT_ULT_E) {
        this.QUANT_ULT_E = QUANT_ULT_E;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getSER_ULT_E() {
        return SER_ULT_E;
    }

    public void setSER_ULT_E(String SER_ULT_E) {
        this.SER_ULT_E = SER_ULT_E;
    }

    public String getVL_UNIT_BC_ST() {
        return VL_UNIT_BC_ST;
    }

    public void setVL_UNIT_BC_ST(String VL_UNIT_BC_ST) {
        this.VL_UNIT_BC_ST = VL_UNIT_BC_ST;
    }

    public String getVL_UNIT_ULT_E() {
        return VL_UNIT_ULT_E;
    }

    public void setVL_UNIT_ULT_E(String VL_UNIT_ULT_E) {
        this.VL_UNIT_ULT_E = VL_UNIT_ULT_E;
    }
}

class RegistroC177 {

    private String REG;
    //Texto fixo contendo "C177" C 004 - Não O
    private String COD_SELO_IPI;
    //Código do selo de controle do IPI, conforme
    private String QT_SELO_IPI;
    //Quantidade de selo de controle do IPI aplicada
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C177").append("|");
            conteudo.append(COD_SELO_IPI).append("|");
            conteudo.append(geral.efdAlfanumerico(QT_SELO_IPI, 12)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC177.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_SELO_IPI() {
        return COD_SELO_IPI;
    }

    public void setCOD_SELO_IPI(String COD_SELO_IPI) {
        this.COD_SELO_IPI = COD_SELO_IPI;
    }

    public String getQT_SELO_IPI() {
        return QT_SELO_IPI;
    }

    public void setQT_SELO_IPI(String QT_SELO_IPI) {
        this.QT_SELO_IPI = QT_SELO_IPI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC178 {

    private String REG;
    private String CL_ENQ;
    private String VL_UNID;
    private String QUANT_PAD;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C178").append("|");
            conteudo.append(geral.efdAlfanumerico(CL_ENQ, 5)).append("|");
            conteudo.append(VL_UNID).append("|");
            conteudo.append(QUANT_PAD).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC178.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCL_ENQ() {
        return CL_ENQ;
    }

    public void setCL_ENQ(String CL_ENQ) {
        this.CL_ENQ = CL_ENQ;
    }

    public String getQUANT_PAD() {
        return QUANT_PAD;
    }

    public void setQUANT_PAD(String QUANT_PAD) {
        this.QUANT_PAD = QUANT_PAD;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_UNID() {
        return VL_UNID;
    }

    public void setVL_UNID(String VL_UNID) {
        this.VL_UNID = VL_UNID;
    }
}

class RegistroC179 {

    private String REG;
    private String BC_ST_ORIG_DEST;
    private String ICMS_ST_REP;
    private String ICMS_ST_COMPL;
//Texto fixo contendo "C179”
//Valor da base de cálculo ST na origem/destino em operações interestaduais.
//C 004 - Não O
//N - 02
//apresent O ar
//O
//OC
//Valor do ICMS-ST a repassar/deduzir em N - 02 operações interestaduais
//Valor do ICMS-ST a complementar à UF de N - 02 destino
    private String BC_RET;
    private String ICMS_RET;
//Valor da BC de retenção em remessa promovida por Substituído intermediário
//Valor da parcela do imposto retido em remessa promovida por substituído intermediário
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C179").append("|");
            conteudo.append(BC_ST_ORIG_DEST).append("|");
            conteudo.append(ICMS_ST_REP).append("|");
            conteudo.append(ICMS_ST_COMPL).append("|");
            conteudo.append(BC_RET).append("|");
            conteudo.append(ICMS_RET).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC179.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getBC_RET() {
        return BC_RET;
    }

    public void setBC_RET(String BC_RET) {
        this.BC_RET = BC_RET;
    }

    public String getBC_ST_ORIG_DEST() {
        return BC_ST_ORIG_DEST;
    }

    public void setBC_ST_ORIG_DEST(String BC_ST_ORIG_DEST) {
        this.BC_ST_ORIG_DEST = BC_ST_ORIG_DEST;
    }

    public String getICMS_RET() {
        return ICMS_RET;
    }

    public void setICMS_RET(String ICMS_RET) {
        this.ICMS_RET = ICMS_RET;
    }

    public String getICMS_ST_COMPL() {
        return ICMS_ST_COMPL;
    }

    public void setICMS_ST_COMPL(String ICMS_ST_COMPL) {
        this.ICMS_ST_COMPL = ICMS_ST_COMPL;
    }

    public String getICMS_ST_REP() {
        return ICMS_ST_REP;
    }

    public void setICMS_ST_REP(String ICMS_ST_REP) {
        this.ICMS_ST_REP = ICMS_ST_REP;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC190 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String VL_RED_BC;
    private String VL_IPI;
    private String COD_OBS;
//Observações:
//Nível hierárquico - 3 Ocorrência - 1:N
//Texto fixo contendo "C190"
//Código da Situação Tributária, conforme a Tabela indicada no item 4.3.1
//Código Fiscal de Operação e Prestação do agrupamento de itens
//Alíquota do ICMS
//Valor da operação na combinação de CST_ICMS, CFOP e alíquota do ICMS, correspondente ao somatório do valor das mercadorias, despesas acessórias (frete, seguros e outras despesas acessórias),ICMS_ST eIPI.
//Parcela correspondente ao "Valor da base de cálculo do ICMS" referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
//Parcela correspondente ao "Valor do ICMS" referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
//Parcela correspondente ao "Valor da base de cálculo do ICMS" da substituição tributária referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
//Parcela correspondente ao valor creditado/debitado do ICMS da substituição tributária, referente à combinação de CST_ICMS, CFOP, e alíquota do ICMS.
//Valor não tributado em função da redução da base de cálculo do ICMS, referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
//Parcela correspondente ao "Valor do IPI" referente à combinação CST_ICMS, CFOP e alíquota do ICMS.
//Código da observação do lançamento fiscal (campo 02 do Registro 0460)
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro(String nota) {
        conteudo = new StringBuilder();
        try {
            ResultSet RS = null;
            conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");       
            String sql = "SELECT SUM(nfp.valortotal) as VALORTOTAL,"
                    + "SUM(nfp.valorbcicms) as VALORBCICMS,"
                    + "SUM(nfp.valoricms) as VALORICMS,"
                    + "SUM(nfp.valorbcicmsst) as VALORBCICMSST,"
                    + "SUM(nfp.valoricmsst) as VALORICMSST,"
                    + "SUM(nfp.valoripi) as VALORIPI,nfp.cfop,nfp.icms,nfp.csticms,nf.observacao FROM notafiscal_produto as nfp,notafiscal as nf WHERE nfp.idnotafiscal = "+nota+" AND nfp.idnotafiscal = nf.idnotafiscal GROUP BY nfp.csticms,nfp.cfop,nfp.icms";
            System.out.println("SQL C190:"+sql);
             RS = con.executaSQL(sql);       
             while (RS.next()){
            conteudo.append("|C190").append("|");
            conteudo.append("0"+RS.getString("csticms")).append("|");
            conteudo.append(RS.getString("cfop").replace(".", "")).append("|");
            conteudo.append(RS.getString("icms").replace(".", ",")).append("|");
            conteudo.append(RS.getString("VALORTOTAL").replace(".", ",")).append("|");
            conteudo.append(RS.getString("VALORBCICMS").replace(".", ",")).append("|");
            conteudo.append(RS.getString("VALORICMS").replace(".", ",")).append("|");
            conteudo.append(RS.getString("VALORBCICMSST").replace(".", ",")).append("|");
            conteudo.append(RS.getString("VALORICMSST").replace(".", ",")).append("|");
            conteudo.append("0000,00").append("|");
            conteudo.append(RS.getString("VALORIPI").replace(".", ",")).append("|");
            conteudo.append(geral.efdAlfanumerico(RS.getString("observacao"), 6)).append("|");
            conteudo.append("\r\n");
             }
            
        } catch (Exception e) {
            Logger.getLogger(RegistroC190.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }
}

class RegistroC195 {

    private String REG;
    private String COD_OBS;
    private String TXT_COMPL;
//Observações:
//Nível hierárquico - 3 Ocorrência - 1:N
//Texto fixo contendo "C195"
//Código da observação do lançamento fiscal (campo 02 do Registro 0460)
//Descrição complementar do código de observação.
    private List<RegistroC197> registroC197 = new ArrayList<RegistroC197>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C195").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append(TXT_COMPL).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC195.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC197 {

    private String REG;
    private String COD_AJ;
//Texto fixo contendo "C197"
//Código do ajustes/benefício/incentivo, conforme tabela indicada no item 5.3.
    private String DESCR_COMPL_AJ;
//Descrição complementar do ajuste da apuração
    private String COD_ITEM;
//Código do item (campo 02 do Registro 0200)
    private String VL_BC_ICMS;
//Base de cálculo do ICMS ou do ICMS ST
    private String ALIQ_ICMS;
//Alíquota do ICMS
    private String VL_ICMS;
//Valor do ICMS ou do ICMS ST
    private String VL_OUTROS;
//Outros valores
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C197").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_AJ, 10)).append("|");
            conteudo.append(DESCR_COMPL_AJ).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_OUTROS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC197.class.getName()).log(Level.SEVERE, null, e);
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

class RegistroC300 {

    private String REG;
    private String COD_MOD;
    private String SER;
    private String SUB;
//Texto fixo contendo "C300"
//Código do modelo do documento fiscal, conforme a Tabela 4.1.1
//Série do documento fiscal
//Subsérie do documento fiscal
    private String NUM_DOC_INI;
//Número do documento fiscal inicial
    private String NUM_DOC_FIN;
//￼ Número do documento fiscal final
    private String DT_DOC;
//￼ Data da emissão dos documentos fiscais
    private String VL_DOC;
//￼ Valor total dos documentos ￼ N-02 O
    private String VL_PIS;
//￼ Valor total do PIS ￼ N-02 OC
    private String VL_COFINS;
    //Valor total da COFINS        
    private String COD_CTA;
//Código da conta analítica contábil debitada/creditada
    private List<RegistroC310> registroC310 = new ArrayList<RegistroC310>();
    private List<RegistroC320> registroC320 = new ArrayList<RegistroC320>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C300").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC_INI, 6)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC_FIN, 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdRemoveSinais(VL_DOC)).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC300.class.getName()).log(Level.SEVERE, null, e);
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

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }
}

class RegistroC310 {

    private String REG;
//Texto fixo contendo "C310"
    private String NUM_DOC_CANC;
//Número do documento fiscal cancelado
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C310").append("|");
            conteudo.append(NUM_DOC_CANC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC310.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getNUM_DOC_CANC() {
        return NUM_DOC_CANC;
    }

    public void setNUM_DOC_CANC(String NUM_DOC_CANC) {
        this.NUM_DOC_CANC = NUM_DOC_CANC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC320 {

    private String REG;
//￼ Texto fixo contendo "C320"
    private String CST_ICMS;
//Código da Situação Tributária, conforme
    private String CFOP;
    //￼ Código Fiscal de Operação e Prestação
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_RED_BC;
    private String COD_OBS;
//Observações:
//Nível hierárquico - 3 Ocorrência – 1:N
//Alíquota do ICMS
//V alor total acumulado das correspondentes à combinação de CST_ICMS, CFOP e alíquota do ICMS, incluídas as despesas acessórias e acréscimos.
//Valor acumulado da base de cálculo do ICMS, referente à combinação de CST_ICMS, CFOP, e alíquota do ICMS.
//V alor acumulado do ICMS, referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
//Valor não tributado em função da redução da base de cálculo do ICMS, referente à combinação de CST_ICMS, CFOP, e alíquota do ICMS.
//Código da observação do lançamento fiscal (campo 02 do Registro 0460)
    private List<RegistroC321> registroC321 = new ArrayList<RegistroC321>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C320").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC320.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }
}

class RegistroC321 {

    private String REG;
    private String COD_ITEM;
    private String QTD;
    private String UNID;
    private String VL_ITEM;
    private String VL_DESC;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_PIS;
    private String VL_COFINS;
//Observações:
//Nível hierárquico - 4 Ocorrência - 1:N
//Texto fixo contendo "C321"
//Código do item (campo 02 do Registro 0200)
//Quantidade acumulada do item
//Unidade do item (Campo 02 do registro 0190)
//Valor acumulado do item
//Valor do desconto acumulado
//Valor acumulado da base de cálculo do ICMS
//Valor acumulado do ICMS debitado
//Valor acumulado do PIS
//Valor acumulado da COFINS
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C321").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC321.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

class RegistroC350 {

    private String REG;
    private String SER;
    private String SUB_SER;
    private String NUM_DOC;
    private String DT_DOC;
    private String CNPJ_CPF;
    private String VL_MERC;
    private String VL_DOC;
    private String VL_DESC;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private List<RegistroC370> registroC370 = new ArrayList<RegistroC370>();
    private List<RegistroC390> registroC390 = new ArrayList<RegistroC390>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C350").append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB_SER, 6)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF)).append("|");
            conteudo.append(VL_MERC).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC350.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCNPJ_CPF() {
        return CNPJ_CPF;
    }

    public void setCNPJ_CPF(String CNPJ_CPF) {
        this.CNPJ_CPF = CNPJ_CPF;
    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
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

    public String getSUB_SER() {
        return SUB_SER;
    }

    public void setSUB_SER(String SUB_SER) {
        this.SUB_SER = SUB_SER;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
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

    public String getVL_MERC() {
        return VL_MERC;
    }

    public void setVL_MERC(String VL_MERC) {
        this.VL_MERC = VL_MERC;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }
}

class RegistroC370 {

    private String REG;
    private String NUM_ITEM;
    private String COD_ITEM;
    private String QTD;
    private String UNID;
    private String VL_ITEM;
    private String VL_DESC;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C370").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_ITEM, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(VL_ITEM)).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC370.class.getName()).log(Level.SEVERE, null, e);
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

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }
}

class RegistroC390 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_RED_BC;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C390").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 4)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC390.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }
}

class RegistroC400 {

    private String REG;
    private String COD_MOD;
    private String ECF_MOD;
    private String ECF_FAB;
    private String ECF_CX;
    private List<RegistroC405> registroC405 = new ArrayList<RegistroC405>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C400").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(ECF_MOD, 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(ECF_FAB, 20)).append("|");
            conteudo.append(geral.efdAlfanumerico(ECF_CX, 3)).append("|");
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
    private RegistroC410 registroC410 = new RegistroC410();
    private List<RegistroC420> registroC420 = new ArrayList<RegistroC420>();
    private List<RegistroC460> registroC460 = new ArrayList<RegistroC460>();
    private List<RegistroC490> registroC490 = new ArrayList<RegistroC490>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C405").append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdAlfanumerico(CRO, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CRZ, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_COO_FIN, 6)).append("|");
            conteudo.append(GT_FIN).append("|");
            conteudo.append(VL_BRT).append("|");
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

class RegistroC410 {

    private String REG;
    private String VL_PIS;
    private String VL_COFINS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C410").append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC410.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }
}

class RegistroC420 {

    private String REG;
    private String COD_TOT_PAR;
    private String VLR_ACUM_TOT;
    private String RN_TOT;
    private String DESCR_NR_TOT;
    private List<RegistroC425> registroC425 = new ArrayList<RegistroC425>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C420").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_TOT_PAR, 7)).append("|");
            conteudo.append(VLR_ACUM_TOT).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC420.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCOD_TOT_PAR() {
        return COD_TOT_PAR;
    }

    public void setCOD_TOT_PAR(String COD_TOT_PAR) {
        this.COD_TOT_PAR = COD_TOT_PAR;
    }

    public String getDESCR_NR_TOT() {
        return DESCR_NR_TOT;
    }

    public void setDESCR_NR_TOT(String DESCR_NR_TOT) {
        this.DESCR_NR_TOT = DESCR_NR_TOT;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getRN_TOT() {
        return RN_TOT;
    }

    public void setRN_TOT(String RN_TOT) {
        this.RN_TOT = RN_TOT;
    }

    public String getVLR_ACUM_TOT() {
        return VLR_ACUM_TOT;
    }

    public void setVLR_ACUM_TOT(String VLR_ACUM_TOT) {
        this.VLR_ACUM_TOT = VLR_ACUM_TOT;
    }
}

class RegistroC425 {

    private String REG;
    private String COD_ITEM;
    private String QTD;
    private String UNID;
    private String VL_ITEM;
    private String VL_PIS;
    private String VL_COFINS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C425").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC425.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
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

class RegistroC460 {

    private String REG;
    private String COD_MOD;
    private String COD_SIT;
    private String NUM_DOC;
    private String DT_DOC;
    private String VL_DOC;
    private String VL_PIS;
    private String VL_COFINS;
    private String CPF_CNPJ;
    private String NOM_ADQ;
    private List<RegistroC470> registroC470 = new ArrayList<RegistroC470>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C460").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_SIT, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(geral.efdRemoveSinais(CPF_CNPJ)).append("|");
            conteudo.append(geral.efdAlfanumerico(NOM_ADQ, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC460.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
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

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getDT_DOC() {
        return DT_DOC;
    }

    public void setDT_DOC(String DT_DOC) {
        this.DT_DOC = DT_DOC;
    }

    public String getNOM_ADQ() {
        return NOM_ADQ;
    }

    public void setNOM_ADQ(String NOM_ADQ) {
        this.NOM_ADQ = NOM_ADQ;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
    }

    public String getVL_PIS() {
        return VL_PIS;
    }

    public void setVL_PIS(String VL_PIS) {
        this.VL_PIS = VL_PIS;
    }

    public String getVL_DOC() {
        return VL_DOC;
    }

    public void setVL_DOC(String VL_DOC) {
        this.VL_DOC = VL_DOC;
    }
}

class RegistroC470 {

    private String REG;
    private String COD_ITEM;
    private String QTD;
    private String QTD_CANC;
    private String UNID;
    private String VL_ITEM;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_PIS;
    private String VL_COFINS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C460").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(QTD_CANC).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS)).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC460.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
    }

    public String getQTD() {
        return QTD;
    }

    public void setQTD(String QTD) {
        this.QTD = QTD;
    }

    public String getQTD_CANC() {
        return QTD_CANC;
    }

    public void setQTD_CANC(String QTD_CANC) {
        this.QTD_CANC = QTD_CANC;
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

    public String getVL_COFINS() {
        return VL_COFINS;
    }

    public void setVL_COFINS(String VL_COFINS) {
        this.VL_COFINS = VL_COFINS;
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

class RegistroC490 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C490").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 4)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(COD_OBS).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC490.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }
}

class RegistroC495 {

    private String REG;
    private String ALIQ_ICMS;
    private String COD_ITEM;
    private String QTD;
    private String QTD_CANC;
    private String UNID;
    private String VL_ITEM;
    private String VL_DESC;
    private String VL_CANC;
    private String VL_ACMO;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_ISEN;
    private String VL_NT;
    private String VL_ICMS_ST;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C495").append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(QTD_CANC).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_CANC).append("|");
            conteudo.append(VL_ACMO).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_ISEN).append("|");
            conteudo.append(VL_NT).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC495.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
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

    public String getQTD_CANC() {
        return QTD_CANC;
    }

    public void setQTD_CANC(String QTD_CANC) {
        this.QTD_CANC = QTD_CANC;
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

    public String getVL_ACMO() {
        return VL_ACMO;
    }

    public void setVL_ACMO(String VL_ACMO) {
        this.VL_ACMO = VL_ACMO;
    }

    public String getVL_BC_ICMS() {
        return VL_BC_ICMS;
    }

    public void setVL_BC_ICMS(String VL_BC_ICMS) {
        this.VL_BC_ICMS = VL_BC_ICMS;
    }

    public String getVL_CANC() {
        return VL_CANC;
    }

    public void setVL_CANC(String VL_CANC) {
        this.VL_CANC = VL_CANC;
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

    public String getVL_ISEN() {
        return VL_ISEN;
    }

    public void setVL_ISEN(String VL_ISEN) {
        this.VL_ISEN = VL_ISEN;
    }

    public String getVL_ITEM() {
        return VL_ITEM;
    }

    public void setVL_ITEM(String VL_ITEM) {
        this.VL_ITEM = VL_ITEM;
    }

    public String getVL_NT() {
        return VL_NT;
    }

    public void setVL_NT(String VL_NT) {
        this.VL_NT = VL_NT;
    }
}

class RegistroC500 {

    private String REG;
    private String IND_OPER;
    private String IND_EMIT;
    private String COD_PART;
    private String COD_MOD;
    private String COD_SIT;
    private String SER;
    private String SUB;
    private String COD_CONS;
    private String NUM_DOC;
    private String DT_DOC;
    private String DT_E_S;
    private String VL_DOC;
    private String VL_DESC;
    private String VL_FORN;
    private String VL_SERV_NT;
    private String VL_TERC;
    private String VL_DA;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String COD_INF;
    private String VL_PIS;
    private String VL_COFINS;
    private String TP_LIGACAO;
    private String COD_GRUPO_TENSAO;
    private List<RegistroC510> registroC510 = new ArrayList<RegistroC510>();
    private List<RegistroC590> registroC590 = new ArrayList<RegistroC590>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C500").append("|");
            conteudo.append(IND_OPER).append("|");
            conteudo.append(IND_EMIT).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(COD_MOD).append("|");
            conteudo.append(COD_SIT).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC, 8)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_E_S)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(getVL_DESC()).append("|");
            conteudo.append(VL_FORN).append("|");
            conteudo.append(VL_SERV_NT).append("|");
            conteudo.append(VL_TERC).append("|");
            conteudo.append(VL_DA).append("|");

            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_INF, 6)).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(TP_LIGACAO).append("|");
            conteudo.append(COD_GRUPO_TENSAO).append("|");


            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC500.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

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

    public String getTP_LIGACAO() {
        return TP_LIGACAO;
    }

    public void setTP_LIGACAO(String TP_LIGACAO) {
        this.TP_LIGACAO = TP_LIGACAO;
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

    public String getVL_DESC() {
        return VL_DESC;
    }

    public void setVL_DESC(String VL_DESC) {
        this.VL_DESC = VL_DESC;
    }
}

class RegistroC510 {

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
    private String ALIQ_ST;
    private String VL_ICMS_ST;
    private String IND_REC;
    private String COD_PART;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C510").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_ITEM, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_ITEM, 60)).append("|");
            conteudo.append(COD_CLASS).append("|");
            conteudo.append(QTD).append("|");
            conteudo.append(geral.efdAlfanumerico(UNID, 6)).append("|");
            conteudo.append(VL_ITEM).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP)).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ST, 6)).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(IND_REC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_PART, 60)).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC510.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
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

class RegistroC590 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String VL_RED_BC;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C590").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC590.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
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
    private List<RegistroC610> registroC610 = new ArrayList<RegistroC610>();
    private List<RegistroC690> registroC690 = new ArrayList<RegistroC690>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C600").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MUN, 7)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUB, 3)).append("|");
            conteudo.append(COD_CONS).append("|");
            conteudo.append(QTD_CONS).append("|");
            conteudo.append(QTD_CANC).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_DOC).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(CONS).append("|");
            conteudo.append(VL_FORN).append("|");
            conteudo.append(VL_SERV_NT).append("|");
            conteudo.append(VL_TERC).append("|");
            conteudo.append(VL_DA).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
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

    private String REG;
    private String NUM_DOC_CANC;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C601").append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_DOC_CANC, 9)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC601.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getNUM_DOC_CANC() {
        return NUM_DOC_CANC;
    }

    public void setNUM_DOC_CANC(String NUM_DOC_CANC) {
        this.NUM_DOC_CANC = NUM_DOC_CANC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class RegistroC610 {

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
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String VL_PIS;
    private String VL_COFINS;
    private String COD_CTA;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C610").append("|");
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
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(COD_CTA).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC610.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
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

    public String getCST_ICMS() {
        return CST_ICMS;
    }

    public void setCST_ICMS(String CST_ICMS) {
        this.CST_ICMS = CST_ICMS;
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

class RegistroC690 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_RED_BC;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C690").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC690.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }
}

class RegistroC700 {

    private String REG;
    private String COD_MOD;
    private String SER;
    private String NRO_ORD_INI;
    private String NRO_ORD_FIN;
    private String DT_DOC_INI;
    private String DT_DOC_FIN;
    private String NOM_MEST;
    private String CHV_COD_DIG;
    private List<RegistroC790> registroC790 = new ArrayList<RegistroC790>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C700").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(SER, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(NRO_ORD_INI, 9)).append("|");
            conteudo.append(geral.efdAlfanumerico(NRO_ORD_FIN, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC_FIN)).append("|");
            conteudo.append(geral.efdAlfanumerico(NOM_MEST, 15)).append("|");
            conteudo.append(geral.efdAlfanumerico(CHV_COD_DIG, 15)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC700.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCHV_COD_DIG() {
        return CHV_COD_DIG;
    }

    public void setCHV_COD_DIG(String CHV_COD_DIG) {
        this.CHV_COD_DIG = CHV_COD_DIG;
    }

    public String getCOD_MOD() {
        return COD_MOD;
    }

    public void setCOD_MOD(String COD_MOD) {
        this.COD_MOD = COD_MOD;
    }

    public String getDT_COD_FIN() {
        return DT_DOC_FIN;
    }

    public void setDT_DOC_FIN(String DT_DOC_FIN) {
        this.DT_DOC_FIN = DT_DOC_FIN;
    }

    public String getDT_DOC_INI() {
        return DT_DOC_INI;
    }

    public void setDT_DOC_INI(String DT_DOC_INI) {
        this.DT_DOC_INI = DT_DOC_INI;
    }

    public String getNOM_MEST() {
        return NOM_MEST;
    }

    public void setNOM_MEST(String NOM_MEST) {
        this.NOM_MEST = NOM_MEST;
    }

    public String getNRO_ORD_FIN() {
        return NRO_ORD_FIN;
    }

    public void setNRO_ORD_FIN(String NRO_ORD_FIN) {
        this.NRO_ORD_FIN = NRO_ORD_FIN;
    }

    public String getNRO_ORD_INI() {
        return NRO_ORD_INI;
    }

    public void setNRO_ORD_INI(String NRO_ORD_INI) {
        this.NRO_ORD_INI = NRO_ORD_INI;
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
}

class RegistroC790 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private String VL_RED_BC;
    private String COD_OBS;
    private List<RegistroC791> registroC791 = new ArrayList<RegistroC791>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C790").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append(VL_RED_BC).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC790.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getVL_RED_BC() {
        return VL_RED_BC;
    }

    public void setVL_RED_BC(String VL_RED_BC) {
        this.VL_RED_BC = VL_RED_BC;
    }
}

class RegistroC791 {

    private String REG;
    private String UF;
    private String VL_BC_ICMS_ST;
    private String VL_ICMS_ST;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C791").append("|");
            conteudo.append(geral.efdAlfanumerico(UF, 2)).append("|");
            conteudo.append(VL_BC_ICMS_ST).append("|");
            conteudo.append(VL_ICMS_ST).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC791.class.getName()).log(Level.SEVERE, null, e);
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

    public String getVL_BC_ICMS_ST() {
        return VL_BC_ICMS_ST;
    }

    public void setVL_BC_ICMS_ST(String VL_BC_ICMS_ST) {
        this.VL_BC_ICMS_ST = VL_BC_ICMS_ST;
    }

    public String getVL_ICMS_ST() {
        return VL_ICMS_ST;
    }

    public void setVL_ICMS_ST(String VL_ICMS_ST) {
        this.VL_ICMS_ST = VL_ICMS_ST;
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
    private List<RegistroC850> registroC850 = new ArrayList<RegistroC850>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C800").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(COD_SIT).append("|");
            conteudo.append(geral.efdAlfanumerico(NUM_CFE, 6)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(VL_CFE).append("|");
            conteudo.append(VL_PIS).append("|");
            conteudo.append(VL_COFINS).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ_CPF)).append("|");
            conteudo.append(NR_SAT).append("|");
            conteudo.append(CHV_CFE).append("|");
            conteudo.append(VL_DESC).append("|");
            conteudo.append(VL_MERC).append("|");
            conteudo.append(VL_OUT_DA).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(VL_PIS_ST).append("|");
            conteudo.append(VL_COFINS_ST).append("|");
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

class RegistroC850 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C850").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC850.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

class RegistroC860 {

    private String REG;
    private String COD_MOD;
    private String NR_SAT;
    private String DT_DOC;
    private String DOC_INI;
    private String DOC_FIM;
    private List<RegistroC890> registroC890 = new ArrayList<RegistroC890>();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C860").append("|");
            conteudo.append(geral.efdAlfanumerico(COD_MOD, 2)).append("|");
            conteudo.append(geral.efdAlfanumerico(NR_SAT, 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_DOC)).append("|");
            conteudo.append(geral.efdAlfanumerico(DOC_INI, 6)).append("|");
            conteudo.append(geral.efdAlfanumerico(DOC_FIM, 6)).append("|");
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

class RegistroC890 {

    private String REG;
    private String CST_ICMS;
    private String CFOP;
    private String ALIQ_ICMS;
    private String VL_OPR;
    private String VL_BC_ICMS;
    private String VL_ICMS;
    private String COD_OBS;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C890").append("|");
            conteudo.append(geral.efdAlfanumerico(CST_ICMS, 3)).append("|");
            conteudo.append(geral.efdAlfanumerico(CFOP, 4)).append("|");
            conteudo.append(geral.efdAlfanumerico(ALIQ_ICMS, 6)).append("|");
            conteudo.append(VL_OPR).append("|");
            conteudo.append(VL_BC_ICMS).append("|");
            conteudo.append(VL_ICMS).append("|");
            conteudo.append(geral.efdAlfanumerico(COD_OBS, 6)).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC890.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getCOD_OBS() {
        return COD_OBS;
    }

    public void setCOD_OBS(String COD_OBS) {
        this.COD_OBS = COD_OBS;
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

    public String getVL_OPR() {
        return VL_OPR;
    }

    public void setVL_OPR(String VL_OPR) {
        this.VL_OPR = VL_OPR;
    }
}

class RegistroC990 {

    private String REG;
    private String QTD_LIN_C;
    private int contadorC990 = 1;
    RegistroC100 regC100 = new RegistroC100();
    RegistroC170 regC170 = new RegistroC170();
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro(int contador) {//        
        conteudo = new StringBuilder();
        try {
            conteudo.append("|C990").append("|");
            conteudo.append(contador + 1).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(RegistroC990.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println(conteudo);
        System.out.println("--- O Registro C990 possui " + contadorC990 + " linhas.");
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

    public int getContadorC990() {
        return contadorC990;
    }
}
