/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milenkovic
 */
@Entity
@Table(name = "ispitnirok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ispitnirok.findAll", query = "SELECT i FROM Ispitnirok i"),
    @NamedQuery(name = "Ispitnirok.findBySifraIspitnogRoka", query = "SELECT i FROM Ispitnirok i WHERE i.sifraIspitnogRoka = :sifraIspitnogRoka"),
    @NamedQuery(name = "Ispitnirok.findByNazivIspitnogRoka", query = "SELECT i FROM Ispitnirok i WHERE i.nazivIspitnogRoka = :nazivIspitnogRoka")})
public class Ispitnirok implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SifraIspitnogRoka")
    private Integer sifraIspitnogRoka;
    @Size(max = 20)
    @Column(name = "NazivIspitnogRoka")
    private String nazivIspitnogRoka;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ispitnirok")
    private List<Polaganje> polaganjeList;

    public Ispitnirok() {
    }

    public Ispitnirok(Integer sifraIspitnogRoka) {
        this.sifraIspitnogRoka = sifraIspitnogRoka;
    }

    public Integer getSifraIspitnogRoka() {
        return sifraIspitnogRoka;
    }

    public void setSifraIspitnogRoka(Integer sifraIspitnogRoka) {
        this.sifraIspitnogRoka = sifraIspitnogRoka;
    }

    public String getNazivIspitnogRoka() {
        return nazivIspitnogRoka;
    }

    public void setNazivIspitnogRoka(String nazivIspitnogRoka) {
        this.nazivIspitnogRoka = nazivIspitnogRoka;
    }

    @XmlTransient
    public List<Polaganje> getPolaganjeList() {
        return polaganjeList;
    }

    public void setPolaganjeList(List<Polaganje> polaganjeList) {
        this.polaganjeList = polaganjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraIspitnogRoka != null ? sifraIspitnogRoka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ispitnirok)) {
            return false;
        }
        Ispitnirok other = (Ispitnirok) object;
        if ((this.sifraIspitnogRoka == null && other.sifraIspitnogRoka != null) || (this.sifraIspitnogRoka != null && !this.sifraIspitnogRoka.equals(other.sifraIspitnogRoka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Ispitnirok[ sifraIspitnogRoka=" + sifraIspitnogRoka + " ]";
    }
    
}
