/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped;

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
public class Bloco0 {

//    private Registro0000 registro0000;
//    private Registro0001 registro0001;
//    private Registro0005 registro0005;
//    private Registro0015 registro0015;
//    private List<Registro0015> registros0015;
//    private Registro0100 registro0100;
    private Registro0150 registro0150;
//    private List<Registro0150> registros0150;
    private Registro0190 registro0190;
//    private List<Registro0190> registros0190;
    private Registro0200 registro0200;
//    private List<Registro0200> registros0200;
//    private Registro0300 registro0300;
//    private List<Registro0300> registros0300;
    private Registro0400 registro0400;
//    private List<Registro0400> registros0400;
//    private Registro0450 registro0450;
//    private List<Registro0450> registros0450;
    private Registro0460 registro0460;
//    private List<Registro0460> registros0460;
//    private Registro0500 registro0500;
//    private List<Registro0500> registros0500;
//    private Registro0600 registro0600;
//    private List<Registro0600> registros0600;
    private Registro0990 registro0990;     
    private StringBuilder conteudoGerado;

    /**
     * As informações do registro0000, registro0005 devem ser setadas manualmente.
     */
    public Bloco0() {
       conteudoGerado = gerarEFD();        
    }
        

    public StringBuilder gerarEFD() {
        StringBuilder conteudo;
        int contadorGeral = 0;
        try {          
            registro0150 = new Registro0150();
            registro0190 = new Registro0190();
//            registro0200 = new Registro0200();       
//            registro0400 = new Registro0400(); 
            registro0460 = new Registro0460();  
            registro0990 = new Registro0990();
//         
            //Formatacao dos dados para preenchimento do arquivo.
            
            conteudo = (registro0150.gerarRegistro()
                     .append(registro0190.gerarRegistro())                  
                     .append(registro0460.gerarRegistro()) 
                     );
             
            contadorGeral = registro0150.getContador0150() + registro0190.getContador0190() ;
            conteudo.append(registro0990.gerarRegistro(contadorGeral));                                    
            System.out.println(conteudo);

            contadorGeral = registro0150.getContador0150() + registro0190.getContador0190()+ registro0990.getContador0990();
            System.out.println("--- O Bloco 0 possui " + contadorGeral + " linhas.");
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
class Registro0000 {
//      01 REG
//      Texto fixo contendo “0000”.

    private String REG;
//      02 COD_VER
//      Código da versão do leiaute conforme a tabela indicada no Ato COTEPE .
    private String COD_VER;
//      03 COD_FIN
//      Código da finalidade do arquivo: 0 - Remessa do arquivo original; 1 - Remessa do arquivo substituto.
    private String COD_FIN;
//      04 DT_INI
//      Data inicial das informações contidas no arquivo.
    private String DT_INI;
//      05 DT_FIN
//      Data final das informações contidas no arquivo.
    private String DT_FIN;
//      06 NOME
//      Nome empresarial da entidade.
    private String NOME;
//      07 CNPJ
//      Número de inscrição da entidade no CNPJ.
    private String CNPJ;
//      08 CPF
//      Número de inscrição da entidade no CPF.
    private String CPF;
//      09 UF
//      Sigla da unidade da federação da entidade.
    private String UF;
//10    IE
//      Inscrição Estadual da entidade.
    private String IE;
//11    COD_MUN
//      Código do município do domicílio fiscal da entidade, conforme a tabela IBGE
    private String COD_MUN;
//12    IM
//      Inscrição Municipal da entidade.
    private String IM;
//13    SUFRAMA
//      Inscrição da entidade na SUFRAMA
    private String SUFRAMA;
//14    IND_PERFIL
//      Perfil de apresentação do arquivo fiscal; 
//      A – Perfil A;
//      B – Perfil B.;
//      C – Perfil C.
    private String IND_PERFIL;
//15    IND_ATIV
//      Indicador de tipo de atividade:
//      0 – Industrial ou equiparado a industrial; 
//      1 – Outros.
    private String IND_ATIV;
    private StringBuilder conteudo;

    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|0000").append("|");
            conteudo.append(geral.efdNumerico(COD_VER, 3)).append("|");
            conteudo.append(geral.efdNumerico(COD_FIN, 1)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
            conteudo.append(geral.efdRemoveSinais(DT_FIN)).append("|");
            conteudo.append(geral.efdAlfanumerico(NOME, 100)).append("|");
            conteudo.append(geral.efdRemoveSinais(CNPJ)).append("|");
            conteudo.append(geral.efdRemoveSinais(CPF)).append("|");
            conteudo.append(geral.efdAlfanumerico(UF, 2)).append("|");
            conteudo.append(geral.efdRemoveSinais(IE)).append("|");
            conteudo.append(geral.efdRemoveSinais(COD_MUN)).append("|");
            conteudo.append(geral.efdAlfanumerico(IM)).append("|");
            conteudo.append(geral.efdAlfanumerico(SUFRAMA, 9)).append("|");
            conteudo.append(IND_PERFIL).append("|");
            conteudo.append(IND_ATIV).append("|");
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

    public String getCOD_FIN() {
        return COD_FIN;
    }

    public void setCOD_FIN(String COD_FIN) {
        this.COD_FIN = COD_FIN;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public String getIND_ATIV() {
        return IND_ATIV;
    }

    public void setIND_ATIV(String IND_ATIV) {
        this.IND_ATIV = IND_ATIV;
    }

    public String getIND_PERFIL() {
        return IND_PERFIL;
    }

    public void setIND_PERFIL(String IND_PERFIL) {
        this.IND_PERFIL = IND_PERFIL;
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
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|00001").append("|");
        conteudo.append(IND_MOV).append("|");
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

class Registro0005 {
//01    REG
//      Texto fixo contendo “0005”

    private String REG;
//02    FANTASIA
//      Nome de fantasia associado ao nome empresarial.
    private String FANTASIA;
//03    CEP
//      Código de Endereçamento Postal.
    private String CEP;
//04    END
//      Logradouro e endereço do imóvel.
    private String END;
//05    NUM
//      Número do imóvel.
    private String NUM;
//06    COMPL
//      Dados complementares do endereço.
    private String COMPL;
//07    BAIRRO
//      Bairro em que o imóvel está situado.
    private String BAIRRO;
//08    FONE
//      Número do telefone (DDD+FONE).
    private String FONE;
//09    FAX
//      Número do fax.
    private String FAX;
//10    EMAIL
//      Endereço do correio eletrônico.
    private String EMAIL;
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0005").append("|");
        conteudo.append(geral.efdAlfanumerico(FANTASIA, 60)).append("|");
        conteudo.append(geral.efdRemoveSinais(CEP)).append("|");
        conteudo.append(geral.efdAlfanumerico(END, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(NUM, 10)).append("|");
        conteudo.append(geral.efdAlfanumerico(COMPL, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(BAIRRO, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(FONE, 11)).append("|");
        conteudo.append(geral.efdAlfanumerico(FAX, 11)).append("|");
        conteudo.append(EMAIL).append("|");
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

    public String getCOMPL() {
        return COMPL;
    }

    public void setCOMPL(String COMPL) {
        this.COMPL = COMPL;
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

    public String getFANTASIA() {
        return FANTASIA;
    }

    public void setFANTASIA(String FANTASIA) {
        this.FANTASIA = FANTASIA;
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

class Registro0015 {
//01    REG
//      Texto fixo contendo "0015"

    private String REG;
//02    UF_ST
//      Sigla da unidade da federação substituído. do contribuinte
    private String UF_ST;
//03    IE_ST
//      Inscrição Estadual do contribuinte substituto na unidade da federação do contribuinte substituído.
    private String IE_ST;
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0015").append("|");
        conteudo.append(UF_ST).append("|");
        conteudo.append(geral.efdRemoveSinais(REG)).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }

    public String getIE_ST() {
        return IE_ST;
    }

    public void setIE_ST(String IE_ST) {
        this.IE_ST = IE_ST;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getUF_ST() {
        return UF_ST;
    }

    public void setUF_ST(String UF_ST) {
        this.UF_ST = UF_ST;
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

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0100").append("|");
        conteudo.append(geral.efdAlfanumerico(NOME, 100)).append("|");
        conteudo.append(geral.efdRemoveSinais(CPF)).append("|");
        conteudo.append(geral.efdRemoveSinais(CRC)).append("|");
        conteudo.append(geral.efdRemoveSinais(CNPJ)).append("|");
        conteudo.append(geral.efdRemoveSinais(CEP)).append("|");
        conteudo.append(geral.efdAlfanumerico(END, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(NUM, 10)).append("|");
        conteudo.append(geral.efdAlfanumerico(COMPL, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(BAIRRO, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(FONE, 11)).append("|");
        conteudo.append(geral.efdAlfanumerico(FAX, 11)).append("|");
        conteudo.append(EMAIL).append("|");
        conteudo.append(geral.efdRemoveSinais(COD_MUN)).append("|");
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


class Registro0150 {
//01    REG
//      Texto fixo contendo “0150”.

    private String REG;
//02    COD_P ART
//      Código de identificação do participante no arquivo.
    private String COD_PART;
//03    NOME
//      Nome pessoal ou empresarial do participante.
    private String NOME;
//04    COD_PAIS
//      Código do país do participante, conforme a tabela indicada no item 3.2.1
    private String COD_PAIS;
//05    CNPJ
//      CNPJ do participante.
    private String CNPJ;
//06    CPF
//      CPF do participante.
    private String CPF;
//07    IE
//      Inscrição Estadual do participante.
    private String IE;
//08    COD_MUN
//      Código do município, conforme a tabela IBGE
    private String COD_MUN;
//09    SUFRAMA
//      Número de inscrição do participante na SUFRAMA.
    private String SUFRAMA;
//10    END
//      Logradouro e endereço do imóvel
    private String END;
//11    NUM
//      Número do imóvel
    private String NUM;
//12    COMPL
//      Dados complementares do endereço
    private String COMPL;
//13    BAIRRO
//      Bairro em que o imóvel está situado
    private String BAIRRO;
//    private List<Registro0175> registros0175 = new ArrayList<Registro0175>();
    private StringBuilder conteudo;
    //Variaveis para armazenar valores temporários de geração dos registros.
    private int contador0150 = 0;

    protected StringBuilder gerarRegistro() {
        Registro0150 Registro0150 = new Registro0150();
        List<Registro0150> Registros0150 = new ArrayList<Registro0150>();
        conteudo = new StringBuilder();        
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");
        ResultSet RS = con.executaSQL("SELECT DISTINCT NF.id_clientefornecedor as COD_PART,"
                + " NF.nomeclientefornecedor as NOME,"
                + " NF.codigoibgepaisclientefornecedor as COD_PAIS,"
                + " NF.cnpjclientefornecedor as CNPJ,"
                + " NF.cpfclientefornecedor as CPF,"
                + " NF.inscricaoestadualclientefornecedor as IE,"
                + " NF.codigomunicipioclientefornecedor as COD_MUN,"
                + " NF.inscricaosuframaclientefornecedor as SUFRAMA,"
                + " NF.enderecoclientefornecedor as END,"
                + " NF.numeroclientefornecedor as NUM,"
                + " NF.complementoclientefornecedor as COMPL,"
                + " NF.bairroclientefornecedor as BAIRRO "
                + "FROM notafiscal as NF GROUP BY NF.id_clientefornecedor");
        try {
            while (RS.next()) {
                Registro0150 = new Registro0150();
                Registro0150.setCOD_PART(RS.getString("COD_PART"));
                Registro0150.setNOME(RS.getString("NOME"));
                Registro0150.setCOD_PAIS(RS.getString("COD_PAIS"));
                Registro0150.setCNPJ(RS.getString("CNPJ"));
                Registro0150.setCPF(RS.getString("CPF"));
                Registro0150.setIE(RS.getString("IE"));
                Registro0150.setCOD_MUN(RS.getString("COD_MUN"));
                Registro0150.setSUFRAMA(RS.getString("SUFRAMA"));
                Registro0150.setEND(RS.getString("END"));
                Registro0150.setNUM(RS.getString("NUM"));
                Registro0150.setCOMPL(RS.getString("COMPL"));
                Registro0150.setBAIRRO(RS.getString("BAIRRO"));

                Registros0150.add(Registro0150);
                //Registros0150               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0150.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i=0;i<Registros0150.size();i++) {
            conteudo.append("|0150").append("|");
            conteudo.append(geral.efdAlfanumerico(Registro0150.getCOD_PART(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(Registro0150.getNOME(), 100)).append("|");
            conteudo.append(geral.efdRemoveSinais(Registro0150.getCOD_PAIS())).append("|");
            conteudo.append(geral.efdRemoveSinais(Registro0150.getCNPJ())).append("|");
            conteudo.append(geral.efdRemoveSinais(Registro0150.getCPF())).append("|");
            conteudo.append(geral.efdRemoveSinais(Registro0150.getIE())).append("|");
            conteudo.append(geral.efdRemoveSinais(Registro0150.getCOD_MUN())).append("|");
            conteudo.append(Registro0150.getSUFRAMA()).append("|");
            conteudo.append(geral.efdAlfanumerico(Registro0150.getEND(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(Registro0150.getNUM(), 10)).append("|");
            conteudo.append(geral.efdAlfanumerico(Registro0150.getCOMPL(), 60)).append("|");
            conteudo.append(geral.efdAlfanumerico(Registro0150.getBAIRRO(), 60)).append("|");
            conteudo.append("\r\n");
             contador0150++;
        }
        System.out.println(conteudo);   
        System.out.println("--- O Registro 0150 possui "+getContador0150()+" linhas.");
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

    public int getContador0150() {
        return contador0150;
    }
}

class Registro0175 {
//01    REG
//      Texto fixo contendo “0175”

    private String REG;
//02    DT_ALT
//      Data de alteração do cadastro
    private String DT_ALT;
//03    NR_CAMPO
//      Número do campo alterado (Somente campos 03 a 13)
    private String NR_CAMPO;
//04    CONT_ANT 
//      Conteúdo anterior do campo
    private String CONT_ANT;
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0175").append("|");
        conteudo.append(geral.efdRemoveSinais(DT_ALT)).append("|");
        conteudo.append(geral.efdAlfanumerico(NR_CAMPO, 2)).append("|");
        conteudo.append(geral.efdAlfanumerico(CONT_ANT, 100)).append("|");
        conteudo.append("\r\n").append("|");
        return conteudo;

    }

    public String getCONT_ANT() {
        return CONT_ANT;
    }

    public void setCONT_ANT(String CONT_ANT) {
        this.CONT_ANT = CONT_ANT;
    }

    public String getDT_ALT() {
        return DT_ALT;
    }

    public void setDT_ALT(String DT_ALT) {
        this.DT_ALT = DT_ALT;
    }

    public String getNR_CAMPO() {
        return NR_CAMPO;
    }

    public void setNR_CAMPO(String NR_CAMPO) {
        this.NR_CAMPO = NR_CAMPO;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
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
    private int contador0190 = 0;
    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        //produtos_unidade

        StringBuilder conteudo = new StringBuilder();
        
        ResultSet RS = null;
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");

        String sql = "SELECT u.abreviado,u.nome FROM unidade as u,produtos as p,notafiscal_produto as nfp WHERE nfp.idproduto = p.id  AND p.unidade = u.id GROUP BY u.id";
        RS = con.executaSQL(sql);
        try {
            while (RS.next()) {
                conteudo.append("|0190").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("abreviado"), 6)).append("|");
                conteudo.append(RS.getString("nome")).append("|");
                conteudo.append("\r\n");
                contador0190++;
            }            

        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(conteudo);
        System.out.println("--- O Registro 0190 possui "+getContador0190()+" linhas.");
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

    public int getContador0190() {
        return contador0190;
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
//    private List<Registro0205> registros0205 = new ArrayList<Registro0205>();
//    private Registro0206 registro0206 = new Registro0206();
//    private List<Registro0220> registro0220 = new ArrayList<Registro0220>();    
    private int contador0200 = 0;
    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        
        StringBuilder conteudo = new StringBuilder();        
        ResultSet RS = null;
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");

        String sql = "SELECT DISTINCT p.id,p.nome,p.codigobarras,p.id_alteracao,u.abreviado,p.tipo,p.icms,cncm.codigo FROM unidade as u,produtos as p,notafiscal_produto as nfp,codigosncm as cncm WHERE nfp.idproduto = p.id AND u.id = p.unidade AND cncm.id= p.id_ncm GROUP BY p.id";
        RS = con.executaSQL(sql);
        try {
            while (RS.next()){
                conteudo.append("|0200").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("id"), 60)).append("|");
                conteudo.append(RS.getString("nome")).append("|");
                conteudo.append(RS.getString("codigobarras")).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("id_alteracao"), 60)).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("abreviado"), 6)).append("|");
                conteudo.append(geral.efdAlfanumerico("0"+RS.getString("tipo"), 2)).append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("codigo"), 8)).append("|");
                //EX_IPI : Código EX, conforme a TIPI
                conteudo.append("000").append("|");
                //COD_GEN : Gênero do Item de Mercadoria/Serviço : 36 Pólvoras e explosivos; artigos de pirotecnia; fósforos; ligas pirofóricas; matérias inflamáveis
                conteudo.append("36").append("|");
                //COD_LST : Código do serviço conforme lista do Anexo I da Lei Complementar Federal nº 116/03.
                conteudo.append("0001").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("icms").replace(".",","), 6)).append("|");
                conteudo.append("\r\n");
                contador0200++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0200.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(conteudo);
        System.out.println("--- O Registro 0200 possui "+getContador0200()+" linhas.");
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

    public int getContador0200() {
        return contador0200;
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

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0205").append("|");
        conteudo.append(DESCR_ANT_ITEM).append("|");
        conteudo.append(geral.efdRemoveSinais(DT_INI)).append("|");
        conteudo.append(geral.efdRemoveSinais(DT_FIM)).append("|");
        conteudo.append(geral.efdAlfanumerico(COD_ANT_ITEM, 60)).append("|");
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

    protected boolean buscarInformacoes() {

        return true;
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

class Registro0220 {
//Texto fixo contendo "0220"

    private String REG;
//Unidade comercial a ser convertida na unidade de estoque, referida no registro 0200.
    private String UNID_CONV;
//Fator de conversão: fator utilizado para converter N - 6 O (multiplicar) a unidade a ser convertida na unidade adotada no inventário.
    private String FAT_CONV;
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0220").append("|");
        conteudo.append(geral.efdAlfanumerico(UNID_CONV, 6)).append("|");
        conteudo.append(FAT_CONV).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }

    public String getFAT_CONV() {
        return FAT_CONV;
    }

    public void setFAT_CONV(String FAT_CONV) {
        this.FAT_CONV = FAT_CONV;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getUNID_CONV() {
        return UNID_CONV;
    }

    public void setUNID_CONV(String UNID_CONV) {
        this.UNID_CONV = UNID_CONV;
    }
}

class Registro0300 {
//Texto fixo contendo "0300"

    private String REG;
//Código individualizado do bem ou componente adotado no controle patrimonial do estabelecimento informante
    private String COD_IND_BEM;
//Identificação do tipo de mercadoria:
//1 = bem;
//2 = componente.
    private String IDENT_MERC;
//Descrição do bem ou componente (modelo, marca e outras características necessárias a sua individualização)
    private String DESCR_ITEM;
//Código de cadastro do bem principal nos casos em que o bem ou componente ( campo 02) esteja vinculado a um bem principal.
    private String COD_PRNC;
//Código da conta analítica de contabilização do bem ou componente (campo 06 do Registro 0500) 
    private String COD_CTA;
//Número total de parcelas a serem apropriadas, segundo a legislação de cada unidade federada
    private String NR_PARC;
    private Registro0305 registro0305 = new Registro0305();
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0300").append("|");
        conteudo.append(geral.efdAlfanumerico(COD_IND_BEM, 60)).append("|");
        conteudo.append(IDENT_MERC).append("|");
        conteudo.append(DESCR_ITEM).append("|");
        conteudo.append(geral.efdAlfanumerico(COD_PRNC, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(COD_CTA, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(NR_PARC, 60)).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }

    public String getCOD_CTA() {
        return COD_CTA;
    }

    public void setCOD_CTA(String COD_CTA) {
        this.COD_CTA = COD_CTA;
    }

    public String getCOD_IND_BEM() {
        return COD_IND_BEM;
    }

    public void setCOD_IND_BEM(String COD_IND_BEM) {
        this.COD_IND_BEM = COD_IND_BEM;
    }

    public String getCOD_PRNC() {
        return COD_PRNC;
    }

    public void setCOD_PRNC(String COD_PRNC) {
        this.COD_PRNC = COD_PRNC;
    }

    public String getDESCR_ITEM() {
        return DESCR_ITEM;
    }

    public void setDESCR_ITEM(String DESCR_ITEM) {
        this.DESCR_ITEM = DESCR_ITEM;
    }

    public String getIDENT_MERC() {
        return IDENT_MERC;
    }

    public void setIDENT_MERC(String IDENT_MERC) {
        this.IDENT_MERC = IDENT_MERC;
    }

    public String getNR_PARC() {
        return NR_PARC;
    }

    public void setNR_PARC(String NR_PARC) {
        this.NR_PARC = NR_PARC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }
}

class Registro0305 {
//Texto fixo contendo "0305"

    private String REG;
//Código do centro de custo onde o bem está sendo ou será utilizado (campo 03 do Registro 0600)
    private String COD_CCUS;
//Descrição sucinta da função do bem na atividade do estabelecimento
    private String FUNC;
//Vida útil estimada do bem, em número de meses
    private String VIDA_UTIL;
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0305").append("|");
        conteudo.append(geral.efdAlfanumerico(COD_CCUS, 60)).append("|");
        conteudo.append(FUNC).append("|");
        conteudo.append(geral.efdAlfanumerico(VIDA_UTIL, 3)).append("|");
        conteudo.append("\r\n");
        return conteudo;

    }

    public String getCOD_CCUS() {
        return COD_CCUS;
    }

    public void setCOD_CCUS(String COD_CCUS) {
        this.COD_CCUS = COD_CCUS;
    }

    public String getFUNC() {
        return FUNC;
    }

    public void setFUNC(String FUNC) {
        this.FUNC = FUNC;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getVIDA_UTIL() {
        return VIDA_UTIL;
    }

    public void setVIDA_UTIL(String VIDA_UTIL) {
        this.VIDA_UTIL = VIDA_UTIL;
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
    private int contador0400 = 0;
    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        StringBuilder conteudo = new StringBuilder();
        
        ResultSet RS = null;
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");

        String sql = "SELECT DISTINCT cf.codigo,cf.descricao FROM cfop as cf,notafiscal_produto as nfp WHERE nfp.cfop = cf.codigo GROUP BY cf.id";
        RS = con.executaSQL(sql);
        try {
            while (RS.next()) {

                conteudo.append("|0400").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("codigo"), 10)).append("|");
                conteudo.append(RS.getString("descricao")).append("|");
                conteudo.append("\r\n");
                contador0400++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(conteudo);
        System.out.println("--- O Registro 0400 possui "+contador0400+1+" linhas.");
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

    public int getContador0400() {
        return contador0400;
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

    protected boolean buscarInformacoes() {
        conteudo.append("|0450").append("|");
        conteudo.append(geral.efdAlfanumerico(COD_INF, 6)).append("|");
        conteudo.append(TXT).append("|");
        conteudo.append("\r\n");
        return true;
    }

    protected StringBuilder gerarRegistro() {

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

class Registro0460 {
//Texto fixo contendo "0460"

    private String REG;
//Código da Observação do lançamento fiscal.
    private String COD_OBS;
//Descrição da observação vinculada ao lançamento fiscal
    private String TXT;
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo = new StringBuilder();
        ResultSet RS = null;
        conexao con = new conexao("montepacell", "192.168.0.14", "3306", "root", "");
        String sql = "SELECT idconfiguracaomensagem,mensagem FROM configuracaomensagem ,notafiscal WHERE idconfiguracaomensagem = observacao AND assinada = 1 AND transmitida = 1 AND transmitidacodigostatus = 100 GROUP BY idconfiguracaomensagem";
        System.out.println("SQL C460:" + sql);
        RS = con.executaSQL(sql);
        try {
            while (RS.next()) {
                conteudo.append("|0460").append("|");
                conteudo.append(geral.efdAlfanumerico(RS.getString("idconfiguracaomensagem"), 6)).append("|");
                conteudo.append(RS.getString("mensagem")).append("|");
                conteudo.append("\r\n");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro0460.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getTXT() {
        return TXT;
    }

    public void setTXT(String TXT) {
        this.TXT = TXT;
    }
}

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
    private StringBuilder conteudo;

    protected boolean buscarInformacoes() {

        return true;
    }

    protected StringBuilder gerarRegistro() {
        conteudo.append("|0500").append("|");
        conteudo.append(geral.efdRemoveSinais(DT_ALT)).append("|");
        conteudo.append(COD_NAT_CC).append("|");
        conteudo.append(IND_CTA).append("|");
        conteudo.append(geral.efdAlfanumerico(NIVEL, 5)).append("|");
        conteudo.append(geral.efdAlfanumerico(COD_CTA, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(NOME_CTA, 60)).append("|");
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

    protected boolean buscarInformacoes() {
        conteudo.append("|0600").append("|");
        conteudo.append(geral.efdRemoveSinais(DT_ALT)).append("|");
        conteudo.append(geral.efdAlfanumerico(COD_CCUS, 60)).append("|");
        conteudo.append(geral.efdAlfanumerico(CCUS, 60)).append("|");
        conteudo.append("\r\n");
        return true;
    }

    protected StringBuilder gerarRegistro() {

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
    private int contador0990 = 1;
    Registro0150 reg0150 = new Registro0150();
    Registro0190 reg0190 = new Registro0190();
    Registro0200 reg0200 = new Registro0200();
    Registro0400 reg0400 = new Registro0400();
        

    protected StringBuilder gerarRegistro(int cont) {
        conteudo = new StringBuilder();
        try {
            conteudo.append("|0990").append("|");
            conteudo.append(cont+1).append("|");
            conteudo.append("\r\n");           
        } catch (Exception e) {
            Logger.getLogger(RegistroC990.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println(conteudo);
        System.out.println("--- O Registro C990 possui " + getContador0990() + " linhas.");
        System.out.println("--- O Bloco C possui " + reg0190.getContador0190() + reg0200.getContador0200() + reg0400.getContador0400() + getContador0990() + " linhas.");

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

    public int getContador0990() {
        return contador0990;
    }
}
