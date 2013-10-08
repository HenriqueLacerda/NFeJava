/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.henriquelacerda;

import mvtcomp._trataErro;
import mvtcomp.conexao;
import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author Henrique Lacerda
 * 
 * @version 0.01
 * 
 * @since 27/03/2012
 * 
 */
public class calculoImpostos {

    // Configuracoes gerais da nota
    private String tipoEmitente = "";
    private String ufEmitente = "";
    private String ufDestinatario = "";
    private String inscricaoEstadualDestinatario = "";
    private Double valorProdutos = 0D;
    private Double aliquotaIcms = 0D;
    private Double aliquotaIcmsIsento = 0D;
    private Double aliquotaIcmsInterna = 0D;
    private Double aliquotaIpi = 0D;
    private Double aliquotaPISBasica = 0D;
    private Double aliquotaPISDiferenciada = 0D;
    private Double aliquotaCOFINSBasica = 0D;
    private Double aliquotaCOFINSDiferenciada = 0D;
    private Double aliquotaMVA = 0D;
    private String CstPis = "";
    private String CstCofins = "";

    
    public calculoImpostos() {
    }
    
    public calculoImpostos(Double valorProdutos, Double aliquotaIcms, Double aliquotaIpi, Double aliquotaPISBasica, Double aliquotaPISDiferenciada, Double aliquotaCOFINSBasica, Double aliquotaCOFINSDiferenciada, Double aliquotaMVA, Double aliquotaIcmsInterna, String CstPis, String CstCofins) {
        this.valorProdutos = valorProdutos;
        this.aliquotaIcms = aliquotaIcms;
        this.aliquotaIpi = aliquotaIpi;
        this.aliquotaPISBasica = aliquotaPISBasica;
        this.aliquotaPISDiferenciada = aliquotaPISDiferenciada;
        this.aliquotaCOFINSBasica = aliquotaCOFINSBasica;
        this.aliquotaCOFINSDiferenciada = aliquotaCOFINSDiferenciada;
        this.aliquotaMVA = aliquotaMVA;
        this.aliquotaIcmsInterna = aliquotaIcmsInterna;
        this.CstPis = CstPis;
        this.CstCofins = CstCofins;
    }
    
    public String getTipoEmitente() {
        return tipoEmitente;
    }
    /*
     * @param 
     */
    public void setTipoEmitente(String tipoEmitente) {
        this.tipoEmitente = tipoEmitente;
    }

    public String getUfDestinatario() {
        return ufDestinatario;
    }

    public void setUfDestinatario(String ufDestinatario) {
        this.ufDestinatario = ufDestinatario;
    }

    public String getUfEmitente() {
        return ufEmitente;
    }

    public void setUfEmitente(String ufEmitente) {
        this.ufEmitente = ufEmitente;
    }

    public Double getAliquotaCOFINSBasica() {
        return aliquotaCOFINSBasica;
    }

    public void setAliquotaCOFINSBasica(Double aliquotaCOFINSBasica) {
        this.aliquotaCOFINSBasica = aliquotaCOFINSBasica;
    }

    public Double getAliquotaCOFINSDiferenciada() {
        return aliquotaCOFINSDiferenciada;
    }

    public void setAliquotaCOFINSDiferenciada(Double aliquotaCOFINSDiferenciada) {
        this.aliquotaCOFINSDiferenciada = aliquotaCOFINSDiferenciada;
    }

    public Double getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(Double aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public Double getAliquotaIcmsInterna() {
        return aliquotaIcmsInterna;
    }

    public void setAliquotaIcmsInterna(Double aliquotaIcmsInterna) {
        this.aliquotaIcmsInterna = aliquotaIcmsInterna;
    }

    public Double getAliquotaIpi() {
        return aliquotaIpi;
    }

    public void setAliquotaIpi(Double aliquotaIpi) {
        this.aliquotaIpi = aliquotaIpi;
    }

    public Double getAliquotaMVAInterno() {
        return aliquotaMVA;
    }

    public void setAliquotaMVAInterno(Double aliquotaMVAInterno) {
        this.aliquotaMVA = aliquotaMVAInterno;
    }

    public Double getAliquotaPISBasica() {
        return aliquotaPISBasica;
    }

    public void setAliquotaPISBasica(Double aliquotaPISBasica) {
        this.aliquotaPISBasica = aliquotaPISBasica;
    }

    public Double getAliquotaPISDiferenciada() {
        return aliquotaPISDiferenciada;
    }

    public void setAliquotaPISDiferenciada(Double aliquotaPISDiferenciada) {
        this.aliquotaPISDiferenciada = aliquotaPISDiferenciada;
    }

    public String getInscricaoEstadualDestinatario() {
        return inscricaoEstadualDestinatario;
    }

    public void setInscricaoEstadualDestinatario(String inscricaoEstadualDestinatario) {
        this.inscricaoEstadualDestinatario = inscricaoEstadualDestinatario;
    }

    public Double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public String getCstCofins() {
        return CstCofins;
    }

    public void setCstCofins(String CstCofins) {
        this.CstCofins = CstCofins;
    }

    public String getCstPis() {
        return CstPis;
    }

    public void setCstPis(String CstPis) {
        this.CstPis = CstPis;
    }

    /*
     * @param valor Double - Valor a ser arredondado
     * @param decimais int - Quantidade de casas decimais
     * 
     * @return Double - Valor arredondado
     */
    private Double arredonda(Double valor, int decimais) {
        BigDecimal teste = new BigDecimal(valor);
        teste = teste.setScale(decimais, BigDecimal.ROUND_HALF_UP);
        return teste.doubleValue();
    }
    
    private void buscarAliquotaIcms()
    {
        Float aliquota = 0F;
        Float aliquotaIsento = 0F;
        Float aliquotaInterna = 0F;
        Float mvaProduto = 0F;

        // Busca os valores de aliquotas
        conexao conn = new conexao();
        conexao conn1 = new conexao();
        try {
            String sql = "Select * from aliquotasicms where estadoorigem = '" + ufEmitente + "' and estadodestino = '" + ufDestinatario + "'";
            ResultSet RS = conn.executaSQL(sql);
            while (RS.next()) {
                aliquota = Float.parseFloat(RS.getString("aliquota"));
                aliquotaIsento = Float.parseFloat(RS.getString("isento"));
            }
            String sql1 = "Select * from aliquotasicms where estadoorigem = '" + ufEmitente + "' and estadodestino = '" + ufEmitente + "'";
            ResultSet RS1 = conn1.executaSQL(sql1);
            while (RS1.next()) {
                aliquotaInterna = Float.parseFloat(RS1.getString("aliquota"));
            }
        } catch (Exception ex) {
            new _trataErro(ex.toString());
        }
        conn.close();
        conn1.close();
        
        this.aliquotaIcms = new Double(aliquota);
        this.aliquotaIcmsIsento = new Double(aliquotaIsento);
        this.aliquotaIcmsInterna = new Double(aliquotaInterna);
    }
    /*
     * @return Double - Valor da BC Icms
     */
    public Double calculaBCIcms() {
        Double valorBCIcms = 0D;
        if (tipoEmitente.equals("simples")) {
            valorBCIcms = 0D;
        } else {
            if (!inscricaoEstadualDestinatario.toLowerCase().equals("isento")) {
                valorBCIcms = valorProdutos;
            } else {
                valorBCIcms = valorProdutos + this.calculaIpi();
            }
        }
        return this.arredonda(valorBCIcms, 2);
    }

    public Double calculaBCIpi() {
        Double valorBCIpi = 0D;
        if (tipoEmitente.equals("simples")) {
            valorBCIpi = 0D;
        } else {
            valorBCIpi = valorProdutos;
        }
        return this.arredonda(valorBCIpi, 2);
    }

    public Double calculaBCPis() {
        Double valorBCIpi = 0D;
        if (tipoEmitente.equals("simples")) {
            valorBCIpi = 0D;
        } else {
            valorBCIpi = valorProdutos;
        }
        return this.arredonda(valorBCIpi, 2);
    }

    public Double calculaBCCofins() {
        Double valorBCIpi = 0D;
        if (tipoEmitente.equals("simples")) {
            valorBCIpi = 0D;
        } else {
            valorBCIpi = valorProdutos;
        }
        return this.arredonda(valorBCIpi, 2);
    }

    /*
     * @return Double - Valor da BC Icms St
     */
    public Double calculaBCIcmsSt() {
        Double valorBCIcmsSt = 0D;
        // Buscar a aliquota da tabela
        if (aliquotaIcms == 0)
        {
            this.buscarAliquotaIcms();
        }
        if (tipoEmitente.equals("simples") || ufEmitente.equals(ufDestinatario)) {
            valorBCIcmsSt = (valorProdutos + this.calculaIpi()) * (aliquotaMVA / 100) + (valorProdutos + this.calculaIpi());
        } else {
            //Caso a Aliquota ICMS Interna seja maior que a interestadual a MVA deve ser ajustada
            if (aliquotaIcmsInterna > aliquotaIcms) {
                Double mvaAjustada = ((1 + aliquotaMVA) * (((1 - aliquotaIcms) / (1 - aliquotaIcms)) - 1)) * 100;
                valorBCIcmsSt = ((valorProdutos + this.calculaIpi()) * (mvaAjustada / 100)) + (valorProdutos + this.calculaIpi());
            } //Caso contrario usa-se a Aliquota ICMS Interestadual e o MVA não ajustado
            else {
                valorBCIcmsSt = ((valorProdutos + this.calculaIpi()) * (aliquotaMVA / 100)) + (valorProdutos + this.calculaIpi());
            }
        }
        return this.arredonda(valorBCIcmsSt, 2);
    }
    
    /*
     * @return Double - Valor do Icms
     */
    public Double calculaIcms() {
        Double valorIcms = 0D;
        // Buscar a aliquota da tabela
        if (aliquotaIcms == 0)
        {
            this.buscarAliquotaIcms();
        }
        if (tipoEmitente.equals("simples")) {
            valorIcms = 0D;
        } else {
            valorIcms = this.calculaBCIcms() * (aliquotaIcms / 100);
        }
        return this.arredonda(valorIcms, 2);
    }
    
    /*
     * @return Double - Valor do Icms St
     */
    public Double calculaIcmsSt() {
        Double valorIcmsSt = 0D;
        // Buscar a aliquota da tabela
        if (aliquotaIcms == 0)
        {
            this.buscarAliquotaIcms();
        }
        valorIcmsSt = this.calculaBCIcmsSt() * (aliquotaIcms / 100);
        return this.arredonda(valorIcmsSt, 2);
    }
    
    /*
     * @return Double - Valor do Ipi
     */
    public Double calculaIpi() {
        Double valorIpi = 0D;
        if (tipoEmitente.equals("simples")) {
            valorIpi = 0D;
        } else {
            valorIpi = this.calculaBCIpi() * (aliquotaIpi / 100);
        }

        return this.arredonda(valorIpi, 2);
    }
    
    /*
     * @return Double - Valor do Pis
     */
    public Double calculaPis() {
        Double valorPis = 0D;
        if (CstPis.equals("01")) {
            valorPis = this.calculaBCPis() * (aliquotaPISBasica / 100);
        } else {
            valorPis = this.calculaBCPis() * (aliquotaPISDiferenciada / 100);
        }
        return this.arredonda(valorPis, 2);
    }
    
    /*
     * @return Double - Valor do Cofins
     */
    public Double calculaCofins() {
        Double valorCofins = 0D;
        if (CstCofins.equals("01")) {
            valorCofins = this.calculaBCCofins() * (aliquotaCOFINSBasica / 100);
        } else {
            valorCofins = this.calculaBCCofins() * (aliquotaCOFINSDiferenciada / 100);
        }
        return this.arredonda(valorCofins, 2);
    }
}