/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milenkovic
 */
@Entity
@Table(name = "polaganje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polaganje.findAll", query = "SELECT p FROM Polaganje p"),
    @NamedQuery(name = "Polaganje.findByBrInd", query = "SELECT p FROM Polaganje p WHERE p.polaganjePK.brInd = :brInd"),
    @NamedQuery(name = "Polaganje.findBySifraIspita", query = "SELECT p FROM Polaganje p WHERE p.polaganjePK.sifraIspita = :sifraIspita"),
    @NamedQuery(name = "Polaganje.findBySifraIspitnogRoka", query = "SELECT p FROM Polaganje p WHERE p.polaganjePK.sifraIspitnogRoka = :sifraIspitnogRoka"),
    @NamedQuery(name = "Polaganje.findByOcena", query = "SELECT p FROM Polaganje p WHERE p.ocena = :ocena"),
    @NamedQuery(name = "Polaganje.findByDatum", query = "SELECT p FROM Polaganje p WHERE p.datum = :datum")})
public class Polaganje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PolaganjePK polaganjePK;
    @Column(name = "Ocena")
    private Integer ocena;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @JoinColumn(name = "BrInd", referencedColumnName = "BrInd", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "SifraIspita", referencedColumnName = "SifraIspita", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ispit ispit;
    @JoinColumn(name = "SifraIspitnogRoka", referencedColumnName = "SifraIspitnogRoka", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ispitnirok ispitnirok;

    public Polaganje() {
    }

    public Polaganje(PolaganjePK polaganjePK) {
        this.polaganjePK = polaganjePK;
    }

    public Polaganje(PolaganjePK polaganjePK, Date datum) {
        this.polaganjePK = polaganjePK;
        this.datum = datum;
    }

    public Polaganje(String brInd, int sifraIspita, int sifraIspitnogRoka) {
        this.polaganjePK = new PolaganjePK(brInd, sifraIspita, sifraIspitnogRoka);
    }

    public PolaganjePK getPolaganjePK() {
        return polaganjePK;
    }

    public void setPolaganjePK(PolaganjePK polaganjePK) {
        this.polaganjePK = polaganjePK;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public Ispitnirok getIspitnirok() {
        return ispitnirok;
    }

    public void setIspitnirok(Ispitnirok ispitnirok) {
        this.ispitnirok = ispitnirok;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polaganjePK != null ? polaganjePK.hashCode() : 0);
        return hash;
    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Polaganje)) {
//            return false;
//        }
//        Polaganje other = (Polaganje) object;
//        if ((this.polaganjePK == null && other.polaganjePK != null) || (this.polaganjePK != null && !this.polaganjePK.equals(other.polaganjePK))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polaganje other = (Polaganje) obj;
        return Objects.equals(this.polaganjePK, other.polaganjePK);
    }

    @Override
    public String toString() {
        return "domen.Polaganje[ polaganjePK=" + polaganjePK + " ]";
    }
    
}
