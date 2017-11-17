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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    ,
    @NamedQuery(name = "Student.findByBrInd", query = "SELECT s FROM Student s WHERE s.brInd = :brInd")
    ,
    @NamedQuery(name = "Student.findByIme", query = "SELECT s FROM Student s WHERE s.ime = :ime")
    ,
    @NamedQuery(name = "Student.findByPrezime", query = "SELECT s FROM Student s WHERE s.prezime = :prezime")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BrInd")
    private String brInd;
    @Size(max = 10)
    @Column(name = "Ime")
    private String ime;
    @Size(max = 30)
    @Column(name = "Prezime")
    private String prezime;
    @JoinColumn(name = "Ptt", referencedColumnName = "Ptt")
    @ManyToOne
    private Mesto ptt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Polaganje> polaganjeList;

    public Student() {
    }

    public Student(String brInd) {
        this.brInd = brInd;
    }

    public String getBrInd() {
        return brInd;
    }

    public void setBrInd(String brInd) {
        this.brInd = brInd;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Mesto getPtt() {
        return ptt;
    }

    public void setPtt(Mesto ptt) {
        this.ptt = ptt;
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
        hash += (brInd != null ? brInd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.brInd == null && other.brInd != null) || (this.brInd != null && !this.brInd.equals(other.brInd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Student[ brInd=" + brInd + " ]";
    }

    public double vratiProsek() {
        double zbirOcenaa = 0;
        double brojPolozenihIspita = 0;
        
        if(polaganjeList.isEmpty()){
            return 0;
        }
        
        for (Polaganje polaganje : polaganjeList) {
            if (polaganje.getOcena() != 5) {
                zbirOcenaa += polaganje.getOcena();
                brojPolozenihIspita++;
            }
        }

        return zbirOcenaa / brojPolozenihIspita;
    }

    public int brojPolIspita() {
        int brojPolozenihIspita = 0;
        brojPolozenihIspita = polaganjeList.stream().filter((polaganje) -> (polaganje.getOcena() != 5)).map((_item) -> 1).reduce(brojPolozenihIspita, Integer::sum);
        return brojPolozenihIspita;
    }
}
