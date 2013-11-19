/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe.formulas;

import crncomp.fGrid;
import crncomp.geral;
import java.sql.ResultSet;
import crncomp._trataErro;
import crncomp.conexao;

/**
 *
 * @author Philippe
 */
public class _formulaImpostos {
    
//    private String idFormula;
//    private String idTributo;
//    private String formula;
//    private String nomeTributo;
//    private fGrid grid;
//    
//    public _formulaImpostos() {
//        idFormula = "0";
//        idTributo = "0";
//        formula = "";
//        nomeTributo = "";
//    }
//
//    public void montarTudo() {
//        
//        String sql;
//        ResultSet rs;
//            
//        sql = "SELECT f.*, t.id,t.nome "
//                + "FROM rh_rpa_formulas f, tributos t "
//                + "WHERE t.id=f.id_tributo ORDER BY f.id";
//        
//        conexao conn = new conexao();
//        rs = conn.executaSQL(sql);
//        
//        try {
//
//            grid.removeTudo();
//
//            while (rs.next()) {
//                
//                grid.passaConteudo(new Object[]{
//                    new geral().zeroAntes(rs.getString("f.id"), 8),
//                    rs.getString("nome"),
//                    rs.getString("formula")
//                });
//
//                grid.setIndice(rs.getString("id"));
//                
//            }
//
//            conn.close();
//            
//        } catch (Exception e) {
//            new _trataErro(e.toString());
//        }
//        
//    }
//        
//    public void montar() {
//        
//        String sql;
//        ResultSet rs;        
//
//        sql = "SELECT f.*, t.id,t.nome "
//                + "FROM rh_rpa_formulas f, tributos t "
//                + "WHERE f.id="+idFormula+" AND t.id=f.id_tributo ";
//                
//        conexao conn = new conexao();
//        rs = conn.executaSQL(sql);
//
//        try {
//
//            rs.first();
//            
//            idTributo = rs.getString("id_tributo");
//            nomeTributo = rs.getString("nome");
//            formula = rs.getString("formula");
//                        
//            conn.close();
//
//        } catch (Exception e) {
//            new _trataErro(e.toString());
//        }
//        
//    }
//    
//    public void adicionar() {
//        
//        String sql;
//        
//        sql = "INSERT INTO rh_rpa_formulas (id_tributo,formula) VALUES ('"+idTributo+"','"+formula+"')";
//        
//        conexao conn = new conexao();
//        conn.insert(sql);
//        conn.close();
//        
//    }
//    
//    public void alterar() {
//        
//        String sql;
//        
//        sql = "UPDATE rh_rpa_formulas " +
//                "SET " +
//                "id_tributo='"+idTributo+"',"+
//                "formula='"+formula+"' "+
//                "WHERE id="+idFormula;
//        
//        conexao conn = new conexao();
//        conn.insert(sql);
//        conn.close();
//        
//    }
//    
//    public void remover() {
//        
//        String sql;
//
//        sql = "DELETE FROM rh_rpa_formulas WHERE id="+idFormula;
//        conexao conn = new conexao();
//        conn.insert(sql);
//        conn.close();
//        
//    }
//
//    public void setGrid(fGrid grid) {
//        this.grid = grid;
//    }
//    
//    public String getNomeTributo() {
//        return nomeTributo;
//    }
//
//    public void setNomeTributo(String nomeTributo) {
//        this.nomeTributo = nomeTributo;
//    }
//        
//    public String getFormula() {
//        return formula;
//    }
//
//    public void setFormula(String formula) {
//        this.formula = formula;
//    }
//
//    public String getIdFormula() {
//        return idFormula;
//    }
//
//    public void setIdFormula(String idFormula) {
//        this.idFormula = idFormula;
//    }
//
//    public String getIdTributo() {
//        return idTributo;
//    }
//
//    public void setIdTributo(String idTributo) {
//        this.idTributo = idTributo;
//    }
//    
    
}
