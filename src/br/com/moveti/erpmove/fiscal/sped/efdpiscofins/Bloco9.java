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
public class Bloco9 {
    private Registro9001 registros9001 = new Registro9001();
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;
    
    public Bloco9() {
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
            
            conteudo.append(registros9001.gerarRegistro());                 
            
            return conteudo;
        } catch (Exception e) {
            Logger.getLogger(Bloco0.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }  
}
class Registro9001 {
  
    private String REG;
    private String IND_MOV;      
    private List<Registro9900> registros9900 = new ArrayList<Registro9900>();
    
    private conexao conexao;
    private ResultSet RS, RS_;
    private StringBuilder conteudo;              
    
    Registro9001 registro9001 = new Registro9001();
    List<Registro9001> registros9001 = new ArrayList<Registro9001>();
    
    protected List<Registro9001> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro9001 = new Registro9001();
                registro9001.setIND_MOV("");               
                                                              
                registros9001.add(registro9001);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro9001.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros9001;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|9001").append("|");
            conteudo.append(geral.efdNumerico(getIND_MOV(), 1)).append("|");            
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




class Registro9900 {

    //Texto fixo contendo “9900”.
    private String REG;
    //Registro que será totalizado no próximo campo.
    private String REG_BLC;
    //Total de registros do tipo informado no campo anterio
    private String QTD_REG_BLC;

    private StringBuilder conteudo;              
    
    Registro9900 registro9900 = new Registro9900();
    List<Registro9900> registros9900 = new ArrayList<Registro9900>();
    
    protected List<Registro9900> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro9900 = new Registro9900();
                registro9900.setREG_BLC("");               
                registro9900.setQTD_REG_BLC("");  
                                                              
                registros9900.add(registro9900);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro9900.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros9900;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|9001").append("|");
            conteudo.append(geral.efdNumerico(getREG_BLC(), 4)).append("|");            
            conteudo.append(geral.efdRemoveSinais(getQTD_REG_BLC())).append("|"); 
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

    public String getREG_BLC() {
        return REG_BLC;
    }

    public void setREG_BLC(String REG_BLC) {
        this.REG_BLC = REG_BLC;
    }

    public String getQTD_REG_BLC() {
        return QTD_REG_BLC;
    }

    public void setQTD_REG_BLC(String QTD_REG_BLC) {
        this.QTD_REG_BLC = QTD_REG_BLC;
    }
    
}




class Registro9990 {

    //Texto fixo contendo "P100"
    private String REG;
    //Quantidade total de linhas do Bloco 9.
    private String QTD_LIN_9;

    private StringBuilder conteudo;              
    
    Registro9990 registro9990 = new Registro9990();
    List<Registro9990> registros9900 = new ArrayList<Registro9990>();
    
    protected List<Registro9990> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro9990 = new Registro9990();
                registro9990.setREG("");               
                registro9990.setQTD_LIN_9("");  
                                                              
                registros9900.add(registro9990);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro9990.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros9900;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|9990").append("|");
            conteudo.append(geral.efdRemoveSinais(getQTD_LIN_9())).append("|");                      
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

    public String getQTD_LIN_9() {
        return QTD_LIN_9;
    }

    public void setQTD_LIN_9(String QTD_LIN_9) {
        this.QTD_LIN_9 = QTD_LIN_9;
    }
}

//ENCERRAMENTO DO ARQUIVO DIGITAL
class Registro9999 {

    //Texto fixo contendo "P110"
    private String REG;
    //Quantidade total de linhas do arquivo digital.
    private String QTD_LIN;
    
    private StringBuilder conteudo;              
    
    Registro9999 registro9999 = new Registro9999();
    List<Registro9999> registros9999 = new ArrayList<Registro9999>();
    
    protected List<Registro9999> buscarInformacoes() {    
        conexao con = new conexao();
        ResultSet RS = con.executaSQL("");

        try {
            while (RS.next()) {
                registro9999 = new Registro9999();                          
                registro9999.setQTD_LIN("");  
                                                              
                registros9999.add(registro9999);               

            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro9999.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return registros9999;
    }
    
    protected StringBuilder gerarRegistro() {
        try {
            conteudo.append("|9999").append("|");
            conteudo.append(geral.efdRemoveSinais(getQTD_LIN())).append("|");                      
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

    public String getQTD_LIN() {
        return QTD_LIN;
    }

    public void setQTD_LIN(String QTD_LIN) {
        this.QTD_LIN = QTD_LIN;
    }
}