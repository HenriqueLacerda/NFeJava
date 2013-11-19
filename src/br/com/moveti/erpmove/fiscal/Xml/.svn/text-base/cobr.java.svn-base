/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("cobr")
public class cobr {

    private fat fat = new fat();
    @XStreamImplicit(itemFieldName = "dup")
    private List<dup> dup = new ArrayList<dup>();

    public fat getFat() {
        return fat;
    }

    public void setFat(fat fat) {
        this.fat = fat;
    }

    public List<dup> getDup() {
        return dup;
    }

    public void setDup(List<dup> dup) {
        this.dup = dup;
    }
}
