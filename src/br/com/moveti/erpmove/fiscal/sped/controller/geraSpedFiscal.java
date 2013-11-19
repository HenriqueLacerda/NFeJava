/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.sped.controller;

import br.com.moveti.erpmove.fiscal.sped.Bloco0;
import br.com.moveti.erpmove.fiscal.sped.BlocoC;



/**
 *
 * @author Jéssica
 */
public class geraSpedFiscal {

    public static void main(String[] args) {
        StringBuilder arquivoGerado;
        Bloco0 bloco0 = new Bloco0();
        BlocoC blocoC = new BlocoC();  
        arquivoGerado = bloco0.getConteudoGerado()
                .append(blocoC.getConteudoGerado()
                );
        System.out.println("Arquivo Gerado:\n"+arquivoGerado);
    }
}
