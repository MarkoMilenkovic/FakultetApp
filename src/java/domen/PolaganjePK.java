/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Milenkovic
 */
@Embeddable
public class PolaganjePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BrInd")
    private String brInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SifraIspita")
    private int sifraIspita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SifraIspitnogRoka")
    private int sifraIspitnogRoka;

    public PolaganjePK() {
    }

    public PolaganjePK(String brInd, int sifraIspita, int sifraIspitnogRoka) {
        this.brInd = brInd;
        this.sifraIspita = sifraIspita;
        this.sifraIspitnogRoka = sifraIspitnogRoka;
    }

    public String getBrInd() {
        return brInd;
    }

    public void setBrInd(String brInd) {
        this.brInd = brInd;
    }

    public int getSifraIspita() {
        return sifraIspita;
    }

    public void setSifraIspita(int sifraIspita) {
        this.sifraIspita = sifraIspita;
    }

    public int getSifraIspitnogRoka() {
        return sifraIspitnogRoka;
    }

    public void setSifraIspitnogRoka(int sifraIspitnogRoka) {
        this.sifraIspitnogRoka = sifraIspitnogRoka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brInd != null ? brInd.hashCode() : 0);
        hash += (int) sifraIspita;
        hash += (int) sifraIspitnogRoka;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolaganjePK)) {
            return false;
        }
        PolaganjePK other = (PolaganjePK) object;
        if ((this.brInd == null && other.brInd != null) || (this.brInd != null && !this.brInd.equals(other.brInd))) {
            return false;
        }
        if (this.sifraIspita != other.sifraIspita) {
            return false;
        }
        if (this.sifraIspitnogRoka != other.sifraIspitnogRoka) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.PolaganjePK[ brInd=" + brInd + ", sifraIspita=" + sifraIspita + ", sifraIspitnogRoka=" + sifraIspitnogRoka + " ]";
    }
    
}
