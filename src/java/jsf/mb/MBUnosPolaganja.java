/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import domen.Ispit;
import domen.Ispitnirok;
import domen.Polaganje;
import domen.PolaganjePK;
import domen.Student;
import java.io.Serializable;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@ManagedBean(name = "mbUnosPolaganja")
@ViewScoped
public class MBUnosPolaganja implements Serializable {

    /**
     * Creates a new instance of MBUnosPolaganja
     */
    private Polaganje polaganje;
    private List<Polaganje> listaPolaganja;
    private List<Ispit> listaIspita;
    private List<Ispitnirok> listaRokova;
    private List<Student> listaStudenata;

    public MBUnosPolaganja() {
        polaganje = new Polaganje();
        listaPolaganja = new LinkedList<>();
    }

    public Polaganje getPolaganje() {
        return polaganje;
    }

    public void setPolaganje(Polaganje polaganje) {
        this.polaganje = polaganje;
    }

    public List<Polaganje> getListaPolaganja() {
        return listaPolaganja;
    }

    public void setListaPolaganja(List<Polaganje> listaPolaganja) {
        this.listaPolaganja = listaPolaganja;
    }

    public List<Ispit> getListaIspita() {
        return listaIspita;
    }

    public void setListaIspita(List<Ispit> listaIspita) {
        this.listaIspita = listaIspita;
    }

    public List<Ispitnirok> getListaRokova() {
        return listaRokova;
    }

    public void setListaRokova(List<Ispitnirok> listaRokova) {
        this.listaRokova = listaRokova;
    }

    public List<Student> getListaStudenata() {
        return listaStudenata;
    }

    public void setListaStudenata(List<Student> listaStudenata) {
        this.listaStudenata = listaStudenata;
    }

//    @PostConstruct
//    public void inicijalizujPodatke() {
//        listaIspita = Kontroler.getInstance().vratiIspite();
//        listaRokova = Kontroler.getInstance().vratiRokove();
//        listaStudenata = Kontroler.getInstance().vratiStudente();
//    }
    public void onload() {
        listaIspita = Kontroler.getInstance().vratiIspite();
        listaRokova = Kontroler.getInstance().vratiRokove();
        listaStudenata = Kontroler.getInstance().vratiStudente();
    }

    public void sacuvajPolaganja() {
        try {
            System.out.println("*********** " + polaganje.getIspit().getSifraIspita() + " " + polaganje.getDatum() + " " + polaganje.getIspitnirok().getSifraIspitnogRoka() + " " + polaganje.getOcena() + " " + polaganje.getStudent().getBrInd());
            if (listaPolaganja.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Dodaj polaganja za unos!",null));
            } else {
                Kontroler.getInstance().dodajPolaganja(listaPolaganja);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistem je zapamtio polaganja"));

                listaPolaganja.clear();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne moze da zapamti polaganja", null));
            System.out.println("greska kod unosa polaganja: " + e.getMessage());
        }
    }

    public void dodajPolaganjeUListu() throws ParseException {
        Polaganje p1 = new Polaganje(new PolaganjePK(polaganje.getStudent().getBrInd(), polaganje.getIspit().getSifraIspita(), polaganje.getIspitnirok().getSifraIspitnogRoka()));

        p1.setDatum(polaganje.getDatum());
        p1.setOcena(polaganje.getOcena());
        p1.setIspit(polaganje.getIspit());
        p1.setIspitnirok(polaganje.getIspitnirok());
        p1.setStudent(polaganje.getStudent());

        System.out.println("****" + polaganje.getIspit() + " " + polaganje.getDatum() + " " + polaganje.getIspitnirok() + " " + polaganje.getOcena() + " " + polaganje.getStudent());
        if (!listaPolaganja.contains(p1)) {
            listaPolaganja.add(p1);

        }
        //        p1 = new Polaganje();
    }

    public void izbaciIzListe(Polaganje p) {
        listaPolaganja.remove(p);
    }

}
