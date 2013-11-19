/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jéssica
 */
public class transmissoesNotaFiscalTest {
    
//    public transmissoesNotaFiscalTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of assinarNotaFiscal method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testAssinarNotaFiscal() throws Exception {
//        System.out.println("assinarNotaFiscal");
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        boolean expResult = false;
//        boolean result = instance.assinarNotaFiscal();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of validarXMLNotasFiscais method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testValidarXMLNotasFiscais() {
//        System.out.println("validarXMLNotasFiscais");
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.validarXMLNotasFiscais();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of enviarNotasFiscais method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testEnviarNotasFiscais() {
//        System.out.println("enviarNotasFiscais");
//        int numeracaoLote = 0;
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.enviarNotasFiscais(numeracaoLote);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of assinarEnviNFe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testAssinarEnviNFe() throws Exception {
//        System.out.println("assinarEnviNFe");
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        boolean expResult = false;
//        boolean result = instance.assinarEnviNFe();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of retornoEnviaNFe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testRetornoEnviaNFe() {
//        System.out.println("retornoEnviaNFe");
//        String transmitidaNumeroRecibo = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.retornoEnviaNFe(transmitidaNumeroRecibo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of consultarNFe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testConsultarNFe() {
//        System.out.println("consultarNFe");
//        String chaveAcesso = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.consultarNFe(chaveAcesso);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of assinarCancNFe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testAssinarCancNFe() throws Exception {
//        System.out.println("assinarCancNFe");
//        String TipoCertificado = "";
//        String Senha = "";
//        String XML = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.assinarCancNFe(TipoCertificado, Senha, XML);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of cancelarNFe method, of class transmissoesNotaFiscal.
//     */
    @Test
    public void testCancelarNFe() {
        System.out.println("cancelarNFe");
        String chaveAcesso = "31120508387320000158550010000004261733815530";
        String transmitidaProtocoloAutorizacao = "131120735843436";
        String motivoCancelamento = "TEEEEEEEEEEEEEEEEEEEEEEEEEESTE";
        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
        instance.setConfiguracaoAmbienteEmissaoNf("2");
        instance.setTipoCertificado("A1");
        instance.setSenhaCertificado("GERALDO DIAS");
        String expResult = "";
        String result = instance.cancelarNFe(chaveAcesso, transmitidaProtocoloAutorizacao, motivoCancelamento);
        System.out.println("RESULT:"+result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
//
//    /**
//     * Test of assinarInutNFe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testAssinarInutNFe_3args() throws Exception {
//        System.out.println("assinarInutNFe");
//        String TipoCertificado = "";
//        String Senha = "";
//        String XML = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.assinarInutNFe(TipoCertificado, Senha, XML);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of inutilizaNFE method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testInutilizaNFE() {
//        System.out.println("inutilizaNFE");
//        String numeracaoInicial = "";
//        String numeracaoFinal = "";
//        String motivoInutilizacao = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.inutilizaNFE(numeracaoInicial, numeracaoFinal, motivoInutilizacao);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of assinarInutNFe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testAssinarInutNFe_0args() throws Exception {
//        System.out.println("assinarInutNFe");
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.assinarInutNFe();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of assinarRaiz_CartaCorrecao method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testAssinarRaiz_CartaCorrecao() throws Exception {
//        System.out.println("assinarRaiz_CartaCorrecao");
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.assinarRaiz_CartaCorrecao();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of buscarDadosCertificado method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testBuscarDadosCertificado() {
//        System.out.println("buscarDadosCertificado");
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        instance.buscarDadosCertificado();
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of enviaCCe method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testEnviaCCe() {
//        System.out.println("enviaCCe");
//        int idLote = 0;
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.enviaCCe(idLote);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of consultaCadastro method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testConsultaCadastro() {
//        System.out.println("consultaCadastro");
//        String clienteCpf = "";
//        String clienteCnpj = "";
//        String clienteInscricaoEstadual = "";
//        String clienteEstado = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.consultaCadastro(clienteCpf, clienteCnpj, clienteInscricaoEstadual, clienteEstado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of statusServico method, of class transmissoesNotaFiscal.
//     */
//    @Test
//    public void testStatusServico() {
//        System.out.println("statusServico");
//        String TipoCertificado = "";
//        String senhaCertificado = "";
//        transmissoesNotaFiscal instance = new transmissoesNotaFiscal();
//        String expResult = "";
//        String result = instance.statusServico(TipoCertificado, senhaCertificado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
}
