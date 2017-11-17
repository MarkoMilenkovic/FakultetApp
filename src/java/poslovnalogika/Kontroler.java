/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import db.DbBroker;
import domen.Ispit;
import domen.Ispitnirok;
import domen.Mesto;
import domen.Polaganje;
import domen.Student;
import domen.User;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Milenkovic
 */
public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public User prijaviKorisnika(User korisnikZaPrijavu) throws Exception {

        return DbBroker.getInstance().prijaviKorisnika(korisnikZaPrijavu);
    }

    public List<Student> vratiStudente() {

        return DbBroker.getInstance().vratiStudente();
    }

    public List<Ispit> vratiIspite() {

        return DbBroker.getInstance().vratiIspite();
    }

    public List<Polaganje> vratiPolaganja() {

        return DbBroker.getInstance().vratiPolaganja();
    }

    public List<Mesto> vratiMesta() {

        return DbBroker.getInstance().vratiMesta();
    }

    public List<Ispitnirok> vratiRokove() {

        return DbBroker.getInstance().vratiRokove();
    }

    public Mesto vratiMesto(int ptt) {

        return DbBroker.getInstance().vratiMesto(ptt);
    }

    public Student vratiStudenta(String brojIndeksa) {

        return DbBroker.getInstance().vratiStudenta(brojIndeksa);
    }

    public Ispit vratiIspit(int sifraIspita) {

        return DbBroker.getInstance().vratiIspit(sifraIspita);
    }

    public Ispitnirok vratiIspitnirok(int sifraIspitnogRoka) {

        return DbBroker.getInstance().vratiIspitnirok(sifraIspitnogRoka);
    }

    public void dodajStudenta(Student s) {

        DbBroker.getInstance().dodajStudenta(s);
    }

    public void dodajPolaganje(Polaganje p) {

        DbBroker.getInstance().dodajPolaganje(p);
    }

    public void dodajPolaganja(List<Polaganje> lista) {
        DbBroker.getInstance().dodajPolaganja(lista);
    }

    public void obrisi(Polaganje polaganje) {
        DbBroker.getInstance().obrisi(polaganje);
    }
}
