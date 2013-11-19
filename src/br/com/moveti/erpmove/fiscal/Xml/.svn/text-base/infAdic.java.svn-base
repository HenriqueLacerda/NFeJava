/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("infAdic")
public class infAdic {

    private String infAdFisco;
    private String infCpl;
    @XStreamImplicit(itemFieldName = "obsCont")
    private List<obsCont> obsCont = new ArrayList<obsCont>();
    @XStreamImplicit(itemFieldName = "obsFisco")
    private List<obsFisco> obsFisco = new ArrayList<obsFisco>();
    @XStreamImplicit(itemFieldName = "procRef")
    private List<procRef> procRef = new ArrayList<procRef>();
    
    public String getInfAdFisco() {
        return infAdFisco;
    }

    public void setInfAdFisco(String infAdFisco) {
        this.infAdFisco = infAdFisco;
    }

    public String getInfCpl() {
        return infCpl;
    }

    public void setInfCpl(String infCpl) {
        this.infCpl = infCpl;
    }

    public List<obsCont> getObsCont() {
        return obsCont;
    }

    public void setObsCont(List<obsCont> obsCont) {
        this.obsCont = obsCont;
    }

    public List<obsFisco> getObsFisco() {
        return obsFisco;
    }

    public void setObsFisco(List<obsFisco> obsFisco) {
        this.obsFisco = obsFisco;
    }

    public List<procRef> getProcRef() {
        return procRef;
    }

    public void setProcRef(List<procRef> procRef) {
        this.procRef = procRef;
    }

   
    
}
