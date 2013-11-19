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
class Bloco0 {

    private Registro0000 registro0000 = new Registro0000();
    private Registro0001 registro0001 = new Registro0001();   
    private List<Registro0100> registros0100 = new ArrayList<Registro0100>();    
    private Registro0110 registros0110 = new Registro0110();    
    private List<Registro0120> registros0120 = new ArrayList<Registro0120>();
    private List<Registro0140> registros0140 = new ArrayList<Registro0140>();    
    private List<Registro0500> registros0500 = new ArrayList<Registro0500>();
    private List<Registro0600> registros0600 = new ArrayList<Registro0600>();    
    private Registro0990 registro0990 = new Registro0990();    
    private ResultSet RS, RS_;
    private StringBuilder conteudo;
    
    public Bloco0() {        
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
            conteudo.append(registro0000.gerarRegistro());           
            
            return conteudo;
        } catch (Exception e) {
            Logger.getLogger(Bloco0.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }  
}


class Registro0000 {
//      01 REG
//      Texto fixo contendo “0000”.
    private String REG;
//      02 COD_VER
//      Código da versão do leiaute conforme a tabela 3.1.1.
    private String COD_VER;
//      03 TIPO_ESCRIT
//      Tipo de escrituração:  0 - Original 1 – Retificadora.
    private String TIPO_ESCRIT;
//      04 IND_SIT_ESP
//     Indicador de situação especial:0 - Abertura 1 - Cisão 2 - Fusão 3 - Incorporação 4 – Encerramento
    private String IND_SIT_ESP;
//      05 NUM_REC_ANTERIOR
//      Número do Recibo da Escrituração anterior a ser retificada, utilizado quando TIPO_ESCRIT for igual a 1.
    private String NUM_REC_ANTERIOR;
//      06 DT_INI
//      Data inicial das informações contidas no arquivo.
    private String DT_INI;
//      07 DT_FIN
//      Data final das informações contidas no arquivo.
    private String DT_FIN;
//      08 NOME
//      Nome empresarial da pessoa jurídica.
    private String NOME;
//      09 CNPJ
//      Número de inscrição do estabelecimento matriz da pessoa jurídica no CNPJ.
    private String CNPJ;
//      10 UF
//      Sigla da Unidade da Federação da pessoa jurídica.
    private String UF;
//      11 COD_MUN
//      Código do município do domicílio fiscal da entidade, conforme a tabela IBGE
    private String COD_MUN;
//      12 SUFRAMA
//      Inscrição da pessoa jurídica na Suframa. 
    private String SUFRAMA;
//      13 IND_NAT_PJ
//      Indicador da natureza da pessoa jurídica:
//      00 – Pessoa jurídica em geral
//      01 – Sociedade cooperativa
//      02 – Entidade sujeita ao PIS/Pasep exclusivamente com base na Folha de Salários
    private String IND_NAT_PJ;
//      14 IND_ATIV
//      Indicador de tipo de atividade:
//      0 – Industrial ou equiparado a industrial;
//      1 – Prestador de serviços;
//      2 - Atividade de comércio;
//      3 – Atividade financeira;
//      4 – Atividade imobiliária;
//      9 – Outros.
    private String IND_ATIV;
    private StringBuilder conteudo;
    Registro0000 registro0000 = new Registro0000();
    List<Registro0000> registros0000 = new ArrayList<Registro0000>();
    
    protected List<Registro0000> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0000 = new Registro0000();
                registro0000.setCOD_VER(RS.getString(""));
                registro0000.setTIPO_ESCRIT(RS.getString(""));
                registro0000.setIND_SIT_ESP(RS.getString(""));
                registro0000.setNUM_REC_ANTERIOR(RS.getString(""));
                registro0000.setDT_INI(RS.getString(""));
                registro0000.setDT_FIN(RS.getString(""));
                registro0000.setNOME(RS.getString(""));
                registro0000.setCNPJ(RS.getString(""));
                registro0000.setUF(RS.getString(""));
                registro0000.setCOD_MUN(RS.getString(""));
                registro0000.setSUFRAMA(RS.getString(""));
                registro0000.setIND_NAT_PJ(RS.getString(""));
                registro0000.setIND_ATIV(RS.getString(""));                
                
                registros0000.add(registro0000);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0150.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0000;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|0000").append("|");
            conteudo.append(geral.efdNumerico(getCOD_VER(), 3)).append("|");
            conteudo.append(geral.efdNumerico(getTIPO_ESCRIT(), 1)).append("|");
            conteudo.append(geral.efdNumerico(getIND_SIT_ESP(), 1)).append("|");
            conteudo.append(geral.efdAlfanumerico(getNUM_REC_ANTERIOR(), 41)).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_INI())).append("|");
            conteudo.append(geral.efdRemoveSinais(getDT_FIN())).append("|");
            conteudo.append(geral.efdAlfanumerico(getNOME(), 100)).append("|");
            conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");
            conteudo.append(geral.efdAlfanumerico(getUF(), 2)).append("|");      
            conteudo.append(geral.efdRemoveSinais(getCOD_MUN())).append("|");
            conteudo.append(geral.efdAlfanumerico(getSUFRAMA(), 9)).append("|");
            conteudo.append(geral.efdRemoveSinais(getIND_NAT_PJ())).append("|");
            conteudo.append(getIND_ATIV()).append("|");
            conteudo.append("\r\n");
        } catch (Exception e) {
            Logger.getLogger(Registro0000.class.getName()).log(Level.SEVERE, null, e);
        }
        return conteudo;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }   

    public String getCOD_MUN() {
        return COD_MUN;
    }

    public void setCOD_MUN(String COD_MUN) {
        this.COD_MUN = COD_MUN;
    }

    public String getCOD_VER() {
        return COD_VER;
    }

    public void setCOD_VER(String COD_VER) {
        this.COD_VER = COD_VER;
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

    public String getIND_ATIV() {
        return IND_ATIV;
    }

    public void setIND_ATIV(String IND_ATIV) {
        this.IND_ATIV = IND_ATIV;
    }  

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getSUFRAMA() {
        return SUFRAMA;
    }

    public void setSUFRAMA(String SUFRAMA) {
        this.SUFRAMA = SUFRAMA;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getTIPO_ESCRIT() {
        return TIPO_ESCRIT;
    }

    public void setTIPO_ESCRIT(String TIPO_ESCRIT) {
        this.TIPO_ESCRIT = TIPO_ESCRIT;
    }

    public String getIND_SIT_ESP() {
        return IND_SIT_ESP;
    }

    public void setIND_SIT_ESP(String IND_SIT_ESP) {
        this.IND_SIT_ESP = IND_SIT_ESP;
    }

    public String getNUM_REC_ANTERIOR() {
        return NUM_REC_ANTERIOR;
    }

    public void setNUM_REC_ANTERIOR(String NUM_REC_ANTERIOR) {
        this.NUM_REC_ANTERIOR = NUM_REC_ANTERIOR;
    }

    public String getIND_NAT_PJ() {
        return IND_NAT_PJ;
    }

    public void setIND_NAT_PJ(String IND_NAT_PJ) {
        this.IND_NAT_PJ = IND_NAT_PJ;
    }
}

class Registro0001 {
//01    REG
//      Texto fixo contendo “0001”.

    private String REG;
//02    IND_MOV
//      Indicador de movimento:
//      0- Bloco com dados informados; 
//      1- Bloco sem dados informados.
    private String IND_MOV;
    StringBuilder conteudo;
    
    Registro0001 registro0001 = new Registro0001();
    List<Registro0001> registros0001 = new ArrayList<Registro0001>();
    
    protected List<Registro0001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0001 = new Registro0001();
                registro0001.setIND_MOV(RS.getString(""));                                
                
                registros0001.add(registro0001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0001;
    }
    
     protected StringBuilder gerarRegistro() {
        conteudo.append("|00001").append("|");
        conteudo.append(getIND_MOV()).append("|");
        conteudo.append("\r\n");
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

class Registro0100 {
//01    REG
//      Texto fixo contendo “0100”.

    private String REG;
//02    NOME
//      Nome do contabilista.
    private String NOME;
//03    CPF
//      Número de inscrição do contabilista no CPF.
    private String CPF;
//04    CRC
//      Número de inscrição do contabilista no Conselho Regional de Contabilidade.
    private String CRC;
//05    CNPJ
//      Número de inscrição do escritório de contabilidade no CNPJ, se houver.
    private String CNPJ;
//06    CEP
//      Código de Endereçamento Postal.
    private String CEP;
//07    END
//      Logradouro e endereço do imóvel.
    private String END;
//08    NUM
//      Número do imóvel.
    private String NUM;
//09    COMPL
//      Dados complementares do endereço.
    private String COMPL;
//10    BAIRRO
//      Bairro em que o imóvel está situado.
    private String BAIRRO;
//11    FONE
//      Número do telefone (DDD+FONE).
    private String FONE;
//12    FAX
//      Número do fax.
    private String FAX;
//13    EMAIL
//      Endereço do correio eletrônico.
    private String EMAIL;
//14    COD_MUN
//      Código do município, conforme tabela IBGE.
    private String COD_MUN;
    private StringBuilder conteudo;
   
    Registro0100 registro0100 = new Registro0100();
    List<Registro0100> registros0100 = new ArrayList<Registro0100>();
    
    protected List<Registro0100> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0100 = new Registro0100();
                registro0100.setNOME(RS.getString(""));
                registro0100.setCPF(RS.getString(""));
                registro0100.setCNPJ(RS.getString(""));
                registro0100.setCEP(RS.getString(""));
                registro0100.setEND(RS.getString(""));
                registro0100.setNUM(RS.getString(""));
                registro0100.setCOMPL(RS.getString(""));
                registro0100.setBAIRRO(RS.getString(""));
                registro0100.setFONE(RS.getString(""));
                registro0100.setFAX(RS.getString(""));
                registro0100.setEMAIL(RS.getString(""));
                registro0100.setCOD_MUN(RS.getString(""));                
                
                registros0100.add(registro0100);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0100.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0100;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0100").append("|");
        conteudo.append(geral.efdAlfanumerico(getNOME(), 100)).append("|");
        conteudo.append(geral.efdRemoveSinais(getCPF())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCRC())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCEP())).append("|");
        conteudo.append(geral.efdAlfanumerico(getEND(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getNUM(), 10)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOMPL(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getBAIRRO(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getFONE(), 11)).append("|");
        conteudo.append(geral.efdAlfanumerico(getFAX(), 11)).append("|");
        conteudo.append(getEMAIL()).append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_MUN())).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }

    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCOD_MUN() {
        return COD_MUN;
    }

    public void setCOD_MUN(String COD_MUN) {
        this.COD_MUN = COD_MUN;
    }

    public String getCOMPL() {
        return COMPL;
    }

    public void setCOMPL(String COMPL) {
        this.COMPL = COMPL;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCRC() {
        return CRC;
    }

    public void setCRC(String CRC) {
        this.CRC = CRC;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getEND() {
        return END;
    }

    public void setEND(String END) {
        this.END = END;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getFONE() {
        return FONE;
    }

    public void setFONE(String FONE) {
        this.FONE = FONE;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getNUM() {
        return NUM;
    }

    public void setNUM(String NUM) {
        this.NUM = NUM;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
} 

class Registro0110{
//      01  REG
//      Texto fixo contendo “0100”.
    private String REG;    
//      02  COD_INC_TRIB   
//    Código indicador da incidência tributária no período:
//    1 – Escrituração de operações com incidência exclusivamente no regime não-cumulativo;
//    2 – Escrituração de operações com incidência exclusivamente no regime cumulativo;
//    3 – Escrituração de operações com incidência nos regimes não-cumulativo e cumulativo.
    private String COD_INC_TRIB;
//      03  IND_APRO_CRED 
//    Código indicador de método de apropriação de créditos comuns, no caso de incidência no regime nãocumulativo (COD_INC_TRIB = 1 ou 3):
//    1 – Método de Apropriação Direta;
//    2 – Método de Rateio Proporcional (Receita Bruta)
    private String IND_APRO_CRED;
//      04  COD_TIPO_CONT
//    Código indicador do Tipo de Contribuição Apurada no Período
//    1 – Apuração da Contribuição Exclusivamente a Alíquota Básica
//    2 – Apuração da Contribuição a Alíquotas Específicas (Diferenciadas e/ou por Unidade de Medida de Produto)
    private String COD_TIPO_CONT;
//      05  IND_REG_CUM
//    Código indicador do critério de escrituração e apuração adotado, no caso de incidência exclusivamente 
//    no regime cumulativo (COD_INC_TRIB = 2), pela pessoa jurídica submetida ao regime de tributação com base no
//    lucro presumido:
//    1 – Regime de Caixa – Escrituração consolidada (Registro F500);
//    2 – Regime de Competência - Escrituração consolidada (Registro F550);
//    9 – Regime de Competência - Escrituração detalhada,com base nos registros dos Blocos “A”, “C”, “D” e “F”.
    private String IND_REG_CUM;  
    
    private Registro0111 regs0111 = new Registro0111();
    private StringBuilder conteudo;
    
    Registro0110 registro0110 = new Registro0110();
    List<Registro0110> registros0110 = new ArrayList<Registro0110>();
    
    protected List<Registro0110> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0110 = new Registro0110();
                registro0110.setCOD_INC_TRIB(RS.getString(""));
                registro0110.setIND_APRO_CRED(RS.getString(""));
                registro0110.setCOD_TIPO_CONT(RS.getString(""));
                registro0110.setIND_REG_CUM(RS.getString(""));                               
                
                registros0110.add(registro0110);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0110.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0110;
    }
    
    protected StringBuilder gerarRegistro() {
        conteudo.append("|0110").append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_INC_TRIB())).append("|");
        conteudo.append(geral.efdRemoveSinais(getIND_APRO_CRED())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_TIPO_CONT())).append("|");
        conteudo.append(geral.efdRemoveSinais(getIND_REG_CUM())).append("|");        
        conteudo.append("\r\n");
        return conteudo;

    }
    

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_INC_TRIB() {
        return COD_INC_TRIB;
    }

    public void setCOD_INC_TRIB(String COD_INC_TRIB) {
        this.COD_INC_TRIB = COD_INC_TRIB;
    }

    public String getIND_APRO_CRED() {
        return IND_APRO_CRED;
    }

    public void setIND_APRO_CRED(String IND_APRO_CRED) {
        this.IND_APRO_CRED = IND_APRO_CRED;
    }

    public String getCOD_TIPO_CONT() {
        return COD_TIPO_CONT;
    }

    public void setCOD_TIPO_CONT(String COD_TIPO_CONT) {
        this.COD_TIPO_CONT = COD_TIPO_CONT;
    }

    public String getIND_REG_CUM() {
        return IND_REG_CUM;
    }

    public void setIND_REG_CUM(String IND_REG_CUM) {
        this.IND_REG_CUM = IND_REG_CUM;
    }

    public Registro0111 getRegs0111() {
        return regs0111;
    }

    public void setRegs0111(Registro0111 regs0111) {
        this.regs0111 = regs0111;
    }
        
}





class Registro0111{
//      01  REG
//      Texto fixo contendo “0111”.
    private String REG; 
//      02  REC_BRU_NCUM_TRIB_MI    
//    Receita Bruta Não-Cumulativa - Tributada no Mercado Interno
    private String REC_BRU_NCUM_TRIB_MI;    
//      03  REC_BRU_NCUM_NT_MI    
//    Receita Bruta Não-Cumulativa – Não Tributada no Mercado Interno 
//    (Vendas com suspensão, alíquota zero, isenção e sem incidência das contribuições)
    private String REC_BRU_NCUM_NT_MI;
//      04  REC_BRU_NCUM_EXP
//    Receita Bruta Não-Cumulativa – Exportação
    private String REC_BRU_NCUM_EXP;
//      05  REC_BRU_CUM
//    Receita Bruta Cumulativa
    private String REC_BRU_CUM;
//      06  REC_BRU_TOTAL
//    Receita Bruta Total
    private String REC_BRU_TOTAL;    
    private StringBuilder conteudo;
    
    Registro0111 registro0111 = new Registro0111();
    List<Registro0111> registros0111 = new ArrayList<Registro0111>();
    
    protected List<Registro0111> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0111 = new Registro0111();
                registro0111.setREC_BRU_NCUM_TRIB_MI(RS.getString(""));
                registro0111.setREC_BRU_NCUM_NT_MI(RS.getString(""));
                registro0111.setREC_BRU_NCUM_EXP(RS.getString(""));
                registro0111.setREC_BRU_CUM(RS.getString(""));
                registro0111.setREC_BRU_TOTAL(RS.getString(""));                    
                
                registros0111.add(registro0111);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0111.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0111;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0111").append("|");
        conteudo.append(geral.efdRemoveSinais(getREC_BRU_NCUM_TRIB_MI())).append("|");
        conteudo.append(geral.efdRemoveSinais(getREC_BRU_NCUM_NT_MI())).append("|");
        conteudo.append(geral.efdRemoveSinais(getREC_BRU_NCUM_EXP())).append("|");
        conteudo.append(geral.efdRemoveSinais(getREC_BRU_CUM())).append("|");
        conteudo.append(geral.efdRemoveSinais(getREC_BRU_TOTAL())).append("|");        
        conteudo.append("\r\n");
        return conteudo;

    }
    
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getREC_BRU_NCUM_TRIB_MI() {
        return REC_BRU_NCUM_TRIB_MI;
    }

    public void setREC_BRU_NCUM_TRIB_MI(String REC_BRU_NCUM_TRIB_MI) {
        this.REC_BRU_NCUM_TRIB_MI = REC_BRU_NCUM_TRIB_MI;
    }

    public String getREC_BRU_NCUM_EXP() {
        return REC_BRU_NCUM_EXP;
    }

    public void setREC_BRU_NCUM_EXP(String REC_BRU_NCUM_EXP) {
        this.REC_BRU_NCUM_EXP = REC_BRU_NCUM_EXP;
    }

    public String getREC_BRU_CUM() {
        return REC_BRU_CUM;
    }

    public void setREC_BRU_CUM(String REC_BRU_CUM) {
        this.REC_BRU_CUM = REC_BRU_CUM;
    }

    public String getREC_BRU_TOTAL() {
        return REC_BRU_TOTAL;
    }

    public void setREC_BRU_TOTAL(String REC_BRU_TOTAL) {
        this.REC_BRU_TOTAL = REC_BRU_TOTAL;
    }

    public String getREC_BRU_NCUM_NT_MI() {
        return REC_BRU_NCUM_NT_MI;
    }

    public void setREC_BRU_NCUM_NT_MI(String REC_BRU_NCUM_NT_MI) {
        this.REC_BRU_NCUM_NT_MI = REC_BRU_NCUM_NT_MI;
    }
    
}

class Registro0120{
//      01  REG
//      Texto fixo contendo “0120”.
    private String REG; 
//      02  MES_DISPENSA
//    Mês de referência do ano-calendário da escrituração,
//    dispensada da entrega.
//    Campo a ser preenchido no formato “mmaaaa”
    private String MES_DISPENSA;
//      03  INF_COMP
//    Informação complementar do registro.
    private String INF_COMP;
    private StringBuilder conteudo;
    Registro0120 registro0120 = new Registro0120();
    List<Registro0120> registros0111 = new ArrayList<Registro0120>();
    
    protected List<Registro0120> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0120 = new Registro0120();
                registro0120.setMES_DISPENSA(RS.getString(""));
                registro0120.setINF_COMP(RS.getString(""));                                  
                
                registros0111.add(registro0120);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0120.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0111;
    }    
        
    protected StringBuilder gerarRegistro() {
        conteudo.append("|0120").append("|");
        conteudo.append(geral.efdAlfanumerico(getMES_DISPENSA(),6)).append("|");
        conteudo.append(geral.efdAlfanumerico(getINF_COMP(),90)).append("|"); 
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getMES_DISPENSA() {
        return MES_DISPENSA;
    }

    public void setMES_DISPENSA(String MES_DISPENSA) {
        this.MES_DISPENSA = MES_DISPENSA;
    }

    public String getINF_COMP() {
        return INF_COMP;
    }

    public void setINF_COMP(String INF_COMP) {
        this.INF_COMP = INF_COMP;
    }
}

class Registro0140{
//      01  REG
//      Texto fixo contendo “0140”.
    private String REG;
//      02  COD_EST
//    Código de identificação do estabelecimento
    private String COD_EST;
//      03  NOME
//    Nome empresarial do estabelecimento
    private String NOME;
//      04  CNPJ
//    Número de inscrição do estabelecimento no CNPJ.
    private String CNPJ;
//      05  UF
//    Sigla da unidade da federação do estabelecimento.
    private String UF;
//      06  IE
//    Inscrição Estadual do estabelecimento, se contribuinte de ICMS.
    private String IE;
//      07  COD_MUN   
//    Código do município do domicílio fiscal do estabelecimento,
//    conforme a tabela IBGE
    private String COD_MUN;
//      08  IM
//    Inscrição Municipal do estabelecimento, se contribuinte do ISS.
    private String IM;
//      09  SUFRAMA   
//    Inscrição do estabelecimento na Suframa
    private String SUFRAMA;
    
    private List<Registro0145> registros0145 = new ArrayList<Registro0145>();
    private List<Registro0150> registros0150 = new ArrayList<Registro0150>();
    private List<Registro0190> registros0190 = new ArrayList<Registro0190>();
    private List<Registro0200> registros0200 = new ArrayList<Registro0200>();
    private List<Registro0400> registros0400 = new ArrayList<Registro0400>();
    private List<Registro0450> registros0450 = new ArrayList<Registro0450>();

    private StringBuilder conteudo;
    
    Registro0140 registro0140 = new Registro0140();
    List<Registro0140> registros0140 = new ArrayList<Registro0140>();
    
    protected List<Registro0140> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0140 = new Registro0140();
                registro0140.setCOD_EST(RS.getString(""));
                registro0140.setNOME(RS.getString(""));
                registro0140.setCNPJ(RS.getString(""));
                registro0140.setUF(RS.getString(""));
                registro0140.setIE(RS.getString(""));
                registro0140.setCOD_MUN(RS.getString(""));
                registro0140.setIM(RS.getString(""));
                registro0140.setSUFRAMA(RS.getString(""));
                                
                registros0140.add(registro0140);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0140.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0140;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0140").append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_EST()));
        conteudo.append(geral.efdAlfanumerico(getNOME(),100)).append("|");
        conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");
        conteudo.append(geral.efdAlfanumerico(getUF(),2)).append("|");
        conteudo.append(geral.efdAlfanumerico(getIE())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_MUN())).append("|");        
        conteudo.append(geral.efdAlfanumerico(getIM()));
        conteudo.append(geral.efdAlfanumerico(getSUFRAMA(),9));
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_EST() {
        return COD_EST;
    }

    public void setCOD_EST(String COD_EST) {
        this.COD_EST = COD_EST;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getCOD_MUN() {
        return COD_MUN;
    }

    public void setCOD_MUN(String COD_MUN) {
        this.COD_MUN = COD_MUN;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getSUFRAMA() {
        return SUFRAMA;
    }

    public void setSUFRAMA(String SUFRAMA) {
        this.SUFRAMA = SUFRAMA;
    }

    public List<Registro0145> getRegistros0145() {
        return registros0145;
    }

    public void setRegistros0145(List<Registro0145> registros0145) {
        this.registros0145 = registros0145;
    }

    public List<Registro0150> getRegistros0150() {
        return registros0150;
    }

    public void setRegistros0150(List<Registro0150> registros0150) {
        this.registros0150 = registros0150;
    }

    public List<Registro0190> getRegistros0190() {
        return registros0190;
    }

    public void setRegistros0190(List<Registro0190> registros0190) {
        this.registros0190 = registros0190;
    }

    public List<Registro0200> getRegistros0200() {
        return registros0200;
    }

    public void setRegistros0200(List<Registro0200> registros0200) {
        this.registros0200 = registros0200;
    }

    public List<Registro0400> getRegistros0400() {
        return registros0400;
    }

    public void setRegistros0400(List<Registro0400> registros0400) {
        this.registros0400 = registros0400;
    }

    public List<Registro0450> getRegistros0450() {
        return registros0450;
    }

    public void setRegistros0450(List<Registro0450> registros0450) {
        this.registros0450 = registros0450;
    }
    
}


class Registro0145{
//      01  REG
//    Texto fixo contendo “0145”.
    private String REG;   
//      02  COD_INC_TRIB    
//    Código indicador da incidência tributária no período:
//    1 – Contribuição Previdenciária apurada no período,exclusivamente com base na Receita Bruta;
//    2 – Contribuição Previdenciária apurada no período, com base na Receita Bruta e com base nas Remunerações pagas, na forma dos nos incisos I e III do art. 22 da Lei no 8.212, de 1991.
    private String COD_INC_TRIB;
//      03  VL_REC_TOT  
//   Valor da Receita Bruta Total da Pessoa Jurídica no Período
    private String VL_REC_TOT;
//      04  VL_REC_ATIV   
//    Valor da Receita Bruta da(s) Atividade(s) Sujeita(s) à Contribuição Previdenciária sobre a Receita Bruta
    private String VL_REC_ATIV;
//      05  VL_REC_DEMAIS_ATIV    
//    Valor da Receita Bruta da(s) Atividade(s) Sujeita(s) à
//    Contribuição Previdenciária sobre a Remuneração (Incisos I e
//    III do art. 22 da Lei nº 8.212, de 1991)  
    private String VL_REC_DEMAIS_ATIV;
//      06  INFO_COMPL  
//    Informação complementar
    private String INFO_COMPL;

    private StringBuilder conteudo;
    
    Registro0145 registro0145 = new Registro0145();
    List<Registro0145> registros0145 = new ArrayList<Registro0145>();
    
    protected List<Registro0145> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0145 = new Registro0145();
                registro0145.setCOD_INC_TRIB(RS.getString(""));
                registro0145.setVL_REC_TOT(RS.getString(""));
                registro0145.setVL_REC_ATIV(RS.getString(""));
                registro0145.setVL_REC_DEMAIS_ATIV(RS.getString(""));
                registro0145.setINFO_COMPL(RS.getString(""));                
                                
                registros0145.add(registro0145);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0145.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0145;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0145").append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_INC_TRIB()));
        conteudo.append(geral.efdRemoveSinais(getVL_REC_TOT())).append("|");
        conteudo.append(geral.efdRemoveSinais(getVL_REC_ATIV())).append("|");
        conteudo.append(geral.efdRemoveSinais(getVL_REC_DEMAIS_ATIV())).append("|");
        conteudo.append(geral.efdRemoveSinais(getINFO_COMPL())).append("|");        
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_INC_TRIB() {
        return COD_INC_TRIB;
    }

    public void setCOD_INC_TRIB(String COD_INC_TRIB) {
        this.COD_INC_TRIB = COD_INC_TRIB;
    }

    public String getVL_REC_TOT() {
        return VL_REC_TOT;
    }

    public void setVL_REC_TOT(String VL_REC_TOT) {
        this.VL_REC_TOT = VL_REC_TOT;
    }

    public String getVL_REC_ATIV() {
        return VL_REC_ATIV;
    }

    public void setVL_REC_ATIV(String VL_REC_ATIV) {
        this.VL_REC_ATIV = VL_REC_ATIV;
    }

    public String getVL_REC_DEMAIS_ATIV() {
        return VL_REC_DEMAIS_ATIV;
    }

    public void setVL_REC_DEMAIS_ATIV(String VL_REC_DEMAIS_ATIV) {
        this.VL_REC_DEMAIS_ATIV = VL_REC_DEMAIS_ATIV;
    }

    public String getINFO_COMPL() {
        return INFO_COMPL;
    }

    public void setINFO_COMPL(String INFO_COMPL) {
        this.INFO_COMPL = INFO_COMPL;
    }
}

class Registro0150 {
//      01    REG
//      Texto fixo contendo “0150”.
    private String REG;
//      02    COD_P ART
//      Código de identificação do participante no arquivo.
    private String COD_PART;
//      03    NOME
//      Nome pessoal ou empresarial do participante.
    private String NOME;
//      04    COD_PAIS
//      Código do país do participante, conforme a tabela indicada no item 3.2.1
    private String COD_PAIS;
//      05    CNPJ
//      CNPJ do participante.
    private String CNPJ;
//      06    CPF
//      CPF do participante.
    private String CPF;
//      07    IE
//      Inscrição Estadual do participante.
    private String IE;
//      08    COD_MUN
//      Código do município, conforme a tabela IBGE
    private String COD_MUN;
//      09    SUFRAMA
//      Número de inscrição do participante na SUFRAMA.
    private String SUFRAMA;
//      10    END
//      Logradouro e endereço do imóvel
    private String END;
//      11    NUM
//      Número do imóvel
    private String NUM;
//      12    COMPL
//      Dados complementares do endereço
    private String COMPL;
//      13    BAIRRO
//      Bairro em que o imóvel está situado
    private String BAIRRO;

    private StringBuilder conteudo;
    
    Registro0150 registro0150 = new Registro0150();
    List<Registro0150> registros0150 = new ArrayList<Registro0150>();
    
    protected List<Registro0150> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0150 = new Registro0150();
                registro0150.setCOD_PART(RS.getString(""));
                registro0150.setNOME(RS.getString(""));
                registro0150.setCOD_PAIS(RS.getString(""));
                registro0150.setCNPJ(RS.getString(""));
                registro0150.setCPF(RS.getString(""));
                registro0150.setIE(RS.getString(""));
                registro0150.setCOD_MUN(RS.getString(""));
                registro0150.setSUFRAMA(RS.getString(""));
                registro0150.setEND(RS.getString(""));
                registro0150.setNUM(RS.getString(""));
                registro0150.setCOMPL(RS.getString(""));
                registro0150.setBAIRRO(RS.getString(""));                
                                
                registros0150.add(registro0150);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0150.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0150;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0150").append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_PART(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getNOME(), 100)).append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_PAIS())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCNPJ())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCPF())).append("|");
        conteudo.append(geral.efdRemoveSinais(getIE())).append("|");
        conteudo.append(geral.efdRemoveSinais(getCOD_MUN())).append("|");
        conteudo.append(geral.efdAlfanumerico(getSUFRAMA(), 9)).append("|");
        conteudo.append(geral.efdAlfanumerico(getEND(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getNUM(), 10)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOMPL(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getBAIRRO(), 60)).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCOD_MUN() {
        return COD_MUN;
    }

    public void setCOD_MUN(String COD_MUN) {
        this.COD_MUN = COD_MUN;
    }

    public String getCOD_PAIS() {
        return COD_PAIS;
    }

    public void setCOD_PAIS(String COD_PAIS) {
        this.COD_PAIS = COD_PAIS;
    }

    public String getCOD_PART() {
        return COD_PART;
    }

    public void setCOD_PART(String COD_PART) {
        this.COD_PART = COD_PART;
    }

    public String getCOMPL() {
        return COMPL;
    }

    public void setCOMPL(String COMPL) {
        this.COMPL = COMPL;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEND() {
        return END;
    }

    public void setEND(String END) {
        this.END = END;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getNUM() {
        return NUM;
    }

    public void setNUM(String NUM) {
        this.NUM = NUM;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getSUFRAMA() {
        return SUFRAMA;
    }

    public void setSUFRAMA(String SUFRAMA) {
        this.SUFRAMA = SUFRAMA;
    }
}

class Registro0190 {
//01    REG
//      Texto fixo contendo "0190"

    private String REG;
//02    UNID
//      Código da unidade de medida
    private String UNID;
//03    DESCR
//      Descrição da unidade de medida
    private String DESCR;
    
    private StringBuilder conteudo;
        
    Registro0190 registro0190 = new Registro0190();
    List<Registro0190> registros0190 = new ArrayList<Registro0190>();
    
    protected List<Registro0190> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0190 = new Registro0190();
                registro0190.setUNID(RS.getString(""));
                registro0190.setDESCR(RS.getString(""));                             
                                
                registros0190.add(registro0190);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0190.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0190;
    }
    
    protected StringBuilder gerarRegistro() {
        conteudo.append("|0190").append("|");
        conteudo.append(geral.efdAlfanumerico(getUNID(), 6)).append("|");
        conteudo.append(getDESCR()).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }
    

    public String getDESCR() {
        return DESCR;
    }

    public void setDESCR(String DESCR) {
        this.DESCR = DESCR;
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
}


class Registro0200 {
//Texto fixo contendo "0200"

    private String REG;
    //Código do item
    private String COD_ITEM;
    //Descrição do item
    private String DESCR_ITEM;
    //Representação alfanumérico do código de barra do produto, se houver
    private String COD_BARRA;
    //Código anterior do item com relação à última informação apresentada.
    private String COD_ANT_ITEM;
    //Unidade de medida utilizada na quantificação de estoques.
    private String UNID_INV;
    //Tipo do item – Atividades Industriais, Comerciais e Serviços:
//00 – Mercadoria para Revenda;
//01 – Matéria-Prima;
//02 – Embalagem;
//03 – Produto em Processo;
//04 – Produto Acabado;
//05 – Subproduto;
//06 – Produto Intermediário;
//07 – Material de Uso e Consumo; 08 – Ativo Imobilizado;
//09 – Serviços;
//10 – Outros insumos;
//99 – Outras
    private String TIPO_ITEM;
//Código da Nomenclatura Comum do Mercosul
    private String COD_NCM;
//Código EX, conforme a TIPI
    private String EX_IPI;
//Código do gênero do item, conforme a Tabela 4.2.1
    private String COD_GEN;
//Código do serviço conforme lista do Anexo I da Lei Complementar Federal no 116/03.
    private String COD_LST;
//Alíquota de ICMS aplicável ao item nas operações internas
    private String ALIQ_ICMS;
    private List<Registro0205> registros0205 = new ArrayList<Registro0205>();
    private Registro0206 registro0206 = new Registro0206();    
    private Registro0208 registro0208 = new Registro0208();

    private StringBuilder conteudo;
    
    Registro0200 registro0200 = new Registro0200();
    List<Registro0200> registros0200 = new ArrayList<Registro0200>();
    
    protected List<Registro0200> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0200 = new Registro0200();
                registro0200.setCOD_ITEM(RS.getString(""));
                registro0200.setDESCR_ITEM(RS.getString(""));
                registro0200.setCOD_BARRA(RS.getString(""));
                registro0200.setCOD_ANT_ITEM(RS.getString(""));
                registro0200.setUNID_INV(RS.getString(""));
                registro0200.setTIPO_ITEM(RS.getString(""));                
                                
                registros0200.add(registro0200);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0200.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0200;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0200").append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_ITEM(), 60)).append("|");
        conteudo.append(getDESCR_ITEM()).append("|");
        conteudo.append(getCOD_BARRA()).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_ANT_ITEM(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getUNID_INV(), 6)).append("|");
        conteudo.append(geral.efdAlfanumerico(getTIPO_ITEM(), 2)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_NCM(), 8)).append("|");
        conteudo.append(geral.efdAlfanumerico(getEX_IPI(), 8)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_GEN(), 2)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_LST(), 4)).append("|");
        conteudo.append(geral.efdAlfanumerico(getALIQ_ICMS(), 6)).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getALIQ_ICMS() {
        return ALIQ_ICMS;
    }

    public void setALIQ_ICMS(String ALIQ_ICMS) {
        this.ALIQ_ICMS = ALIQ_ICMS;
    }

    public String getCOD_ANT_ITEM() {
        return COD_ANT_ITEM;
    }

    public void setCOD_ANT_ITEM(String COD_ANT_ITEM) {
        this.COD_ANT_ITEM = COD_ANT_ITEM;
    }

    public String getCOD_BARRA() {
        return COD_BARRA;
    }

    public void setCOD_BARRA(String COD_BARRA) {
        this.COD_BARRA = COD_BARRA;
    }

    public String getCOD_GEN() {
        return COD_GEN;
    }

    public void setCOD_GEN(String COD_GEN) {
        this.COD_GEN = COD_GEN;
    }

    public String getCOD_ITEM() {
        return COD_ITEM;
    }

    public void setCOD_ITEM(String COD_ITEM) {
        this.COD_ITEM = COD_ITEM;
    }

    public String getCOD_LST() {
        return COD_LST;
    }

    public void setCOD_LST(String COD_LST) {
        this.COD_LST = COD_LST;
    }

    public String getCOD_NCM() {
        return COD_NCM;
    }

    public void setCOD_NCM(String COD_NCM) {
        this.COD_NCM = COD_NCM;
    }

    public String getDESCR_ITEM() {
        return DESCR_ITEM;
    }

    public void setDESCR_ITEM(String DESCR_ITEM) {
        this.DESCR_ITEM = DESCR_ITEM;
    }

    public String getEX_IPI() {
        return EX_IPI;
    }

    public void setEX_IPI(String EX_IPI) {
        this.EX_IPI = EX_IPI;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getTIPO_ITEM() {
        return TIPO_ITEM;
    }

    public void setTIPO_ITEM(String TIPO_ITEM) {
        this.TIPO_ITEM = TIPO_ITEM;
    }

    public String getUNID_INV() {
        return UNID_INV;
    }

    public void setUNID_INV(String UNID_INV) {
        this.UNID_INV = UNID_INV;
    }

    public List<Registro0205> getRegistros0205() {
        return registros0205;
    }

    public void setRegistros0205(List<Registro0205> registros0205) {
        this.registros0205 = registros0205;
    }

    public Registro0206 getRegistro0206() {
        return registro0206;
    }

    public void setRegistro0206(Registro0206 registro0206) {
        this.registro0206 = registro0206;
    }

    public Registro0208 getRegistro0208() {
        return registro0208;
    }

    public void setRegistro0208(Registro0208 registro0208) {
        this.registro0208 = registro0208;
    }
}

class Registro0205 {
//Texto fixo contendo "0205"
    private String REG;
//Descrição anterior do item
    private String DESCR_ANT_ITEM;
//Data inicial de utilização da descrição do item
    private String DT_INI;
//Data final de utilização da descrição do item
    private String DT_FIM;
//Código anterior do item com relação à última informação apresentada.
    private String COD_ANT_ITEM;

    private StringBuilder conteudo;

   Registro0205 registro0205 = new Registro0205();
   List<Registro0205> registros0205 = new ArrayList<Registro0205>();
    
    protected List<Registro0205> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0205 = new Registro0205();
                registro0205.setDESCR_ANT_ITEM(RS.getString(""));
                registro0205.setDT_INI(RS.getString(""));
                registro0205.setDT_FIM(RS.getString(""));
                registro0205.setCOD_ANT_ITEM(RS.getString(""));                
                                
                registros0205.add(registro0205);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0205.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0205;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0205").append("|");
        conteudo.append(getDESCR_ANT_ITEM()).append("|");
        conteudo.append(geral.efdRemoveSinais(getDT_INI())).append("|");
        conteudo.append(geral.efdRemoveSinais(getDT_FIM())).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_ANT_ITEM(), 60)).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getCOD_ANT_ITEM() {
        return COD_ANT_ITEM;
    }

    public void setCOD_ANT_ITEM(String COD_ANT_ITEM) {
        this.COD_ANT_ITEM = COD_ANT_ITEM;
    }

    public String getDESCR_ANT_ITEM() {
        return DESCR_ANT_ITEM;
    }

    public void setDESCR_ANT_ITEM(String DESCR_ANT_ITEM) {
        this.DESCR_ANT_ITEM = DESCR_ANT_ITEM;
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

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class Registro0206 {
//Texto fixo contendo "0206"

    private String REG;
//Código do combustível, conforme tabela publicada pela ANP
    private String COD_COMB;

    private StringBuilder conteudo;

   Registro0206 registro0206 = new Registro0206();
   List<Registro0206> registros0206 = new ArrayList<Registro0206>();
    
    protected List<Registro0206> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0206 = new Registro0206();
                registro0206.setCOD_COMB(RS.getString(""));                               
                                
                registros0206.add(registro0206);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0206.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0206;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0206").append("|");
        conteudo.append(COD_COMB).append("|");        
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getCOD_COMB() {
        return COD_COMB;
    }

    public void setCOD_COMB(String COD_COMB) {
        this.COD_COMB = COD_COMB;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}


class Registro0208{
//      01  REG
//    Texto fixo contendo "0208"
    private String REG;
//      02  COD_TAB
//    Código indicador da Tabela de Incidência, conforme Anexo III    do Decreto nº 6.707/08:
//        01 – Tabela I
//        02 – Tabela II
//        03 – Tabela III
//        04 – Tabela IV
//        05 – Tabela V
//        06 – Tabela VI
//        07 – Tabela VII
//        08– Tabela VIII
//        09 – Tabela IX
//        10 – Tabela X
//        11 – Tabela XI
//        12 – Tabela XII
    private String COD_TAB;
//      03  COD_GRU
//    Código do grupo, conforme Anexo III do Decreto nº 6.707/08.
    private String COD_GRU;
//      04  MARCA_COM
//    Marca Comercial
    private String MARCA_COM;

    private StringBuilder conteudo;

   Registro0208 registro0208 = new Registro0208();
   List<Registro0208> registros0208 = new ArrayList<Registro0208>();
    
    protected List<Registro0208> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0208 = new Registro0208();
                registro0208.setCOD_TAB(RS.getString(""));
                registro0208.setCOD_GRU(RS.getString(""));
                registro0208.setMARCA_COM(RS.getString(""));                
                                
                registros0208.add(registro0208);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0208.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0208;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0208").append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_TAB(),2)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_GRU(),2)).append("|");
        conteudo.append(geral.efdAlfanumerico(getMARCA_COM(),60)).append("|");       
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_TAB() {
        return COD_TAB;
    }

    public void setCOD_TAB(String COD_TAB) {
        this.COD_TAB = COD_TAB;
    }

    public String getCOD_GRU() {
        return COD_GRU;
    }

    public void setCOD_GRU(String COD_GRU) {
        this.COD_GRU = COD_GRU;
    }

    public String getMARCA_COM() {
        return MARCA_COM;
    }

    public void setMARCA_COM(String MARCA_COM) {
        this.MARCA_COM = MARCA_COM;
    }
}

class Registro0400 {
//Texto fixo contendo "0400"

    private String REG;
//Código da natureza da operação/prestação
    private String COD_NAT;
//Descrição da natureza da operação/prestação
    private String DESCR_NAT;

    private StringBuilder conteudo;

   Registro0400 registro0400 = new Registro0400();
   List<Registro0400> registros0400 = new ArrayList<Registro0400>();
    
    protected List<Registro0400> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0400 = new Registro0400();
                registro0400.setCOD_NAT(RS.getString(""));
                registro0400.setDESCR_NAT(RS.getString(""));                             
                                
                registros0400.add(registro0400);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0400.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0400;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0400").append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_NAT(), 10)).append("|");
        conteudo.append(getDESCR_NAT()).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getCOD_NAT() {
        return COD_NAT;
    }

    public void setCOD_NAT(String COD_NAT) {
        this.COD_NAT = COD_NAT;
    }

    public String getDESCR_NAT() {
        return DESCR_NAT;
    }

    public void setDESCR_NAT(String DESCR_NAT) {
        this.DESCR_NAT = DESCR_NAT;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class Registro0450 {
//Texto fixo contendo "0450"

    private String REG;
//Código da informação complementar do documento fiscal.
    private String COD_INF;
//Texto livre da informação complementar existente no documento fiscal, inclusive espécie de normas legais, poder normativo, número, capitulação, data e demais referências pertinentes com indicação referentes ao tributo.
    private String TXT;

    private StringBuilder conteudo;

   Registro0450 registro0450 = new Registro0450();
   List<Registro0450> registros0450 = new ArrayList<Registro0450>();
    
    protected List<Registro0450> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0450 = new Registro0450();
                registro0450.setCOD_INF(RS.getString(""));
                registro0450.setTXT(RS.getString(""));                               
                                
                registros0450.add(registro0450);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0450.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0450;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0450").append("|");
        conteudo.append(geral.efdAlfanumerico(COD_INF, 6)).append("|");
        conteudo.append(TXT).append("|");
        conteudo.append("\r\n");
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

    public String getTXT() {
        return TXT;
    }

    public void setTXT(String TXT) {
        this.TXT = TXT;
    }
}
//

class Registro0500 {
//Texto fixo contendo “0500”

    private String REG;
//Data da inclusão/alteração
    private String DT_ALT;
//Código da natureza da conta/grupo de contas: 01 - Contas de ativo;
//02 - Contas de passivo;
//03 - Patrimônio líquido;
//04 - Contas de resultado;
//05 - Contas de compensação; 
//09 - Outras.
    private String COD_NAT_CC;
//Indicador do tipo de conta:
//S - Sintética (grupo de contas); A - Analítica (conta).
    private String IND_CTA;
//Nível da conta analítica/grupo de contas.
    private String NIVEL;
//Código da conta analítica/grupo de contas.
    private String COD_CTA;
//Nome da conta analítica/grupo de contas.
    private String NOME_CTA;
//    Código da conta correlacionada no Plano de Contas Referenciado, publicado pela RFB.
    private String COD_CTA_REF;
//    CNPJ do estabelecimento, no caso da conta informada no campo COD_CTA ser específica de um estabelecimento.
    private String CNPJ_EST;
    
    private StringBuilder conteudo;

   Registro0500 registro0500 = new Registro0500();
   List<Registro0500> registros0500 = new ArrayList<Registro0500>();
    
    protected List<Registro0500> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0500 = new Registro0500();
                registro0500.setDT_ALT(RS.getString(""));
                registro0500.setCOD_NAT_CC(RS.getString(""));
                registro0500.setIND_CTA(RS.getString(""));
                registro0500.setNIVEL(RS.getString(""));  
                registro0500.setCOD_CTA(RS.getString(""));
                registro0500.setNOME_CTA(RS.getString(""));
                registro0500.setCOD_CTA_REF(RS.getString(""));
                registro0500.setCNPJ_EST(RS.getString("")); 
                                
                registros0500.add(registro0500);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0500.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0500;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0500").append("|");
        conteudo.append(geral.efdRemoveSinais(getDT_ALT())).append("|");
        conteudo.append(getCOD_NAT_CC()).append("|");
        conteudo.append(getIND_CTA()).append("|");
        conteudo.append(geral.efdAlfanumerico(getNIVEL(), 5)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_CTA(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getNOME_CTA(), 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(getCOD_CTA_REF(), 60)).append("|");
        conteudo.append(geral.efdRemoveSinais(getCNPJ_EST())).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }
    
    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getCOD_NAT_CC() {
        return COD_NAT_CC;
    }

    public void setCOD_NAT_CC(String COD_NAT_CC) {
        this.COD_NAT_CC = COD_NAT_CC;
    }

    public String getDT_ALT() {
        return DT_ALT;
    }

    public void setDT_ALT(String DT_ALT) {
        this.DT_ALT = DT_ALT;
    }

    public String getIND_CTA() {
        return IND_CTA;
    }

    public void setIND_CTA(String IND_CTA) {
        this.IND_CTA = IND_CTA;
    }

    public String getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(String NIVEL) {
        this.NIVEL = NIVEL;
    }

    public String getNOME_CTA() {
        return NOME_CTA;
    }

    public void setNOME_CTA(String NOME_CTA) {
        this.NOME_CTA = NOME_CTA;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getCOD_CTA_REF() {
        return COD_CTA_REF;
    }

    public void setCOD_CTA_REF(String COD_CTA_REF) {
        this.COD_CTA_REF = COD_CTA_REF;
    }

    public String getCNPJ_EST() {
        return CNPJ_EST;
    }

    public void setCNPJ_EST(String CNPJ_EST) {
        this.CNPJ_EST = CNPJ_EST;
    }
}

class Registro0600 {
//Texto fixo contendo “0600”.

    private String REG;
//Data da inclusão/alteração.
    private String DT_ALT;
//Código do centro de custos.
    private String COD_CCUS;
//Nome do centro de custos.
    private String CCUS;
    
    private StringBuilder conteudo;

   Registro0600 registro0600 = new Registro0600();
   List<Registro0600> registros0600 = new ArrayList<Registro0600>();
    
    protected List<Registro0600> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0600 = new Registro0600();
                registro0600.setDT_ALT(RS.getString(""));
                registro0600.setCOD_CCUS(RS.getString(""));
                registro0600.setCCUS(RS.getString(""));                
                                
                registros0600.add(registro0600);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0600.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0600;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0600").append("|");
        conteudo.append(geral.efdRemoveSinais(DT_ALT)).append("|");
        conteudo.append(geral.efdAlfanumerico(COD_CCUS, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(CCUS, 60)).append("|");
        conteudo.append("\r\n");
        return conteudo;
    }             
    
    public String getCCUS() {
        return CCUS;
    }

    public void setCCUS(String CCUS) {
        this.CCUS = CCUS;
    }

    public String getCOD_CCUS() {
        return COD_CCUS;
    }

    public void setCOD_CCUS(String COD_CCUS) {
        this.COD_CCUS = COD_CCUS;
    }

    public String getDT_ALT() {
        return DT_ALT;
    }

    public void setDT_ALT(String DT_ALT) {
        this.DT_ALT = DT_ALT;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class Registro0990 {
    //Texto fixo contendo "0990"
    private String REG;
    //Quantidade total de linhas do Bloco 0
    private String QTD_LIN_0;

    private StringBuilder conteudo;

    Registro0990 registro0990 = new Registro0990();
    List<Registro0990> registros0990 = new ArrayList<Registro0990>();
    
    protected List<Registro0990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("SELECT NF.id_clientefornecedor as COD_PART, NF.nomeclientefornecedor as NOME, NF.codigoibgepaisclientefornecedor as COD_PAIS,  NF.cnpjclientefornecedor as CNPJ, NF.cpfclientefornecedor as CPF, NF.inscricaoestadualclientefornecedor as IE, NF.codigomunicipioclientefornecedor as COD_MUN, NF.inscricaosuframaclientefornecedor as SUFRAMA, NF.enderecoclientefornecedor as END, NF.numeroclientefornecedor as NUM, NF.complementoclientefornecedor as COMPL, NF.bairroclientefornecedor as BAIRRO FROM notafiscal as NF");

        try {
            while (RS.next()) {
                registro0990 = new Registro0990();                 
                                
                registros0990.add(registro0990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros0990;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0990").append("|");
        conteudo.append(QTD_LIN_0).append("|");
        conteudo.append("\r\n");
        return conteudo;
    }
    
    public String getQTD_LIN_0() {
        return QTD_LIN_0;
    }

    public void setQTD_LIN_0(String QTD_LIN_0) {
        this.QTD_LIN_0 = QTD_LIN_0;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}
