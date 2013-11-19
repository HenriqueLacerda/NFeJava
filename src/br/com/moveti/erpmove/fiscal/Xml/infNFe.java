/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.det;
import br.com.moveti.erpmove.fiscal.Xml.retirada;
import br.com.moveti.erpmove.fiscal.Xml.emit;
import br.com.moveti.erpmove.fiscal.Xml.dest;
import br.com.moveti.erpmove.fiscal.Xml.cobr;
import br.com.moveti.erpmove.fiscal.Xml.total;
import br.com.moveti.erpmove.fiscal.Xml.exporta;
import br.com.moveti.erpmove.fiscal.Xml.entrega;
import br.com.moveti.erpmove.fiscal.Xml.ide;
import br.com.moveti.erpmove.fiscal.Xml.transp;
import br.com.moveti.erpmove.fiscal.Xml.infAdic;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jéssica
 */
public class infNFe {
    @XStreamAlias("versao")
    private String versao;
    @XStreamAlias("Id")
    private String Id;

    private ide ide;
    private emit emit;
    private dest dest;
    @XStreamImplicit(itemFieldName = "det")
    private List<det> det = new ArrayList<det>();
    private total total;
    private transp transp ;
    private infAdic infAdic;
    private exporta exporta ;
    private entrega entrega;
    private retirada retirada;
    private cobr cobr ;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public ide getIde() {
        return ide;
    }

    public void setIde(ide ide) {
        this.ide = ide;
    }

    public emit getEmit() {
        return emit;
    }

    public void setEmit(emit emit) {
        this.emit = emit;
    }

    public dest getDest() {
        return dest;
    }

    public void setDest(dest dest) {
        this.dest = dest;
    }

    public List<det> getDet() {
        return det;
    }

    public void setDet(List<det> det) {
        this.det = det;
    }

    public total getTotal() {
        return total;
    }

    public void setTotal(total total) {
        this.total = total;
    }

    public transp getTransp() {
        return transp;
    }

    public void setTransp(transp transp) {
        this.transp = transp;
    }

    public infAdic getInfAdic() {
        return infAdic;
    }

    public void setInfAdic(infAdic infAdic) {
        this.infAdic = infAdic;
    }

    public exporta getExporta() {
        return exporta;
    }

    public void setExporta(exporta exporta) {
        this.exporta = exporta;
    }

    public entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(entrega entrega) {
        this.entrega = entrega;
    }

    public retirada getRetirada() {
        return retirada;
    }

    public void setRetirada(retirada retirada) {
        this.retirada = retirada;
    }

    public cobr getCobr() {
        return cobr;
    }

    public void setCobr(cobr cobr) {
        this.cobr = cobr;
    }
}
