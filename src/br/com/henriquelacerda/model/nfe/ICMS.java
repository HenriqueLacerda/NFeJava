/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.Xml;

import br.com.moveti.erpmove.fiscal.Xml.ICMS40;
import br.com.moveti.erpmove.fiscal.Xml.ICMSSN201;
import br.com.moveti.erpmove.fiscal.Xml.ICMS20;
import br.com.moveti.erpmove.fiscal.Xml.ICMSSN202;
import br.com.moveti.erpmove.fiscal.Xml.ICMS51;
import br.com.moveti.erpmove.fiscal.Xml.ICMS60;
import br.com.moveti.erpmove.fiscal.Xml.ICMS30;
import br.com.moveti.erpmove.fiscal.Xml.ICMS00;
import br.com.moveti.erpmove.fiscal.Xml.ICMS10;
import br.com.moveti.erpmove.fiscal.Xml.ICMSSN102;
import br.com.moveti.erpmove.fiscal.Xml.ICMSSN900;
import br.com.moveti.erpmove.fiscal.Xml.ICMSSN101;
import br.com.moveti.erpmove.fiscal.Xml.ICMS70;
import br.com.moveti.erpmove.fiscal.Xml.ICMSSN500;
import br.com.moveti.erpmove.fiscal.Xml.ICMS90;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Jéssica
 */
@XStreamAlias("ICMS")
public class ICMS {

    private ICMS00 ICMS00 = new ICMS00();
    private ICMS10 ICMS10 = new ICMS10();
    private ICMS20 ICMS20 = new ICMS20();
    private ICMS30 ICMS30 = new ICMS30();
    private ICMS40 ICMS40 = new ICMS40();
    private ICMS51 ICMS51 = new ICMS51();
    private ICMS60 ICMS60 = new ICMS60();
    private ICMS70 ICMS70 = new ICMS70();
    private ICMS90 ICMS90 = new ICMS90();
    private ICMSPart ICMSPart = new ICMSPart();
    private ICMSST ICMSST = new ICMSST();
    private ICMSSN101 ICMSSN101 = new ICMSSN101();
    private ICMSSN102 ICMSSN102 = new ICMSSN102();
    private ICMSSN201 ICMSSN201 = new ICMSSN201();
    private ICMSSN202 ICMSSN202 = new ICMSSN202();
    private ICMSSN900 ICMSSN900 = new ICMSSN900();
    private ICMSSN500 ICMSSN500 = new ICMSSN500();

    public ICMSPart getICMSPart() {
        return ICMSPart;
    }

    public void setICMSPart(ICMSPart ICMSPart) {
        this.ICMSPart = ICMSPart;
    }

    public ICMSST getICMSST() {
        return ICMSST;
    }

    public void setICMSST(ICMSST ICMSST) {
        this.ICMSST = ICMSST;
    }

    public ICMS00 getICMS00() {
        return ICMS00;
    }

    public void setICMS00(ICMS00 ICMS00) {
        this.ICMS00 = ICMS00;
    }

    public ICMS10 getICMS10() {
        return ICMS10;
    }

    public void setICMS10(ICMS10 ICMS10) {
        this.ICMS10 = ICMS10;
    }

    public ICMS20 getICMS20() {
        return ICMS20;
    }

    public void setICMS20(ICMS20 ICMS20) {
        this.ICMS20 = ICMS20;
    }

    public ICMS30 getICMS30() {
        return ICMS30;
    }

    public void setICMS30(ICMS30 ICMS30) {
        this.ICMS30 = ICMS30;
    }

    public ICMS40 getICMS40() {
        return ICMS40;
    }

    public void setICMS40(ICMS40 ICMS40) {
        this.ICMS40 = ICMS40;
    }

    public ICMS51 getICMS51() {
        return ICMS51;
    }

    public void setICMS51(ICMS51 ICMS51) {
        this.ICMS51 = ICMS51;
    }

    public ICMS60 getICMS60() {
        return ICMS60;
    }

    public void setICMS60(ICMS60 ICMS60) {
        this.ICMS60 = ICMS60;
    }

    public ICMS70 getICMS70() {
        return ICMS70;
    }

    public void setICMS70(ICMS70 ICMS70) {
        this.ICMS70 = ICMS70;
    }

    public ICMS90 getICMS90() {
        return ICMS90;
    }

    public void setICMS90(ICMS90 ICMS90) {
        this.ICMS90 = ICMS90;
    }

    public ICMSSN101 getICMSSN101() {
        return ICMSSN101;
    }

    public void setICMSSN101(ICMSSN101 ICMSSN101) {
        this.ICMSSN101 = ICMSSN101;
    }

    public ICMSSN102 getICMSSN102() {
        return ICMSSN102;
    }

    public void setICMSSN102(ICMSSN102 ICMSSN102) {
        this.ICMSSN102 = ICMSSN102;
    }

    public ICMSSN201 getICMSSN201() {
        return ICMSSN201;
    }

    public void setICMSSN201(ICMSSN201 ICMSSN201) {
        this.ICMSSN201 = ICMSSN201;
    }

    public ICMSSN202 getICMSSN202() {
        return ICMSSN202;
    }

    public void setICMSSN202(ICMSSN202 ICMSSN202) {
        this.ICMSSN202 = ICMSSN202;
    }

    public ICMSSN900 getICMSSN900() {
        return ICMSSN900;
    }

    public void setICMSSN900(ICMSSN900 ICMSSN900) {
        this.ICMSSN900 = ICMSSN900;
    }

    public ICMSSN500 getICMSSN500() {
        return ICMSSN500;
    }

    public void setICMSSN500(ICMSSN500 ICMSSN500) {
        this.ICMSSN500 = ICMSSN500;
    }
}
