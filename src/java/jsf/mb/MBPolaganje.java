/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import db.DbBroker;
import domen.Ispit;
import domen.Polaganje;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@ManagedBean
@SessionScoped
public class MBPolaganje implements Serializable {

    /**
     * Creates a new instance of MBPolaganje
     */
    private Polaganje polaganje;
    private List<Polaganje> listaPolaganja;
    private List<Polaganje> listaNeuspesnihPolaganja;
    private List<Ispit> listaIspita;

    public MBPolaganje() {
        polaganje = new Polaganje();
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

    public List<Polaganje> getListaNeuspesnihPolaganja() {
        return listaNeuspesnihPolaganja;
    }

    public void setListaNeuspesnihPolaganja(List<Polaganje> listaNeuspesnihPolaganja) {
        this.listaNeuspesnihPolaganja = listaNeuspesnihPolaganja;
    }

//    @PostConstruct
//    public void pupuniListuPolaganja(){
//        System.out.println("11111111111111111111111111111111111*");
//        listaPolaganja = Kontroler.getInstance().vratiPolaganja();
//    }
    public void onload() {
        listaPolaganja = Kontroler.getInstance().vratiPolaganja();
        listaIspita = Kontroler.getInstance().vratiIspite();
        listaNeuspesnihPolaganja = DbBroker.getInstance().vratiNeuspesnaPolaganja();
    }

    public void obrisi(Polaganje polaganje) {
        try {
            //        try {
//            Kontroler.getInstance().obrisi(polaganje);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistem je obrisao polaganje."));
//            System.out.println("Sistem je obrisao polaganje.");
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistem ne moze da obrise polaganje."));
//        }
            URL url = new URL("http://localhost:8080/FakultetApp/webresources/polaganja/" + polaganje.getPolaganjePK().getBrInd().replace("/", "-") + "/" + polaganje.getPolaganjePK().getSifraIspita() + "/" + polaganje.getPolaganjePK().getSifraIspitnogRoka());
            System.out.println(url.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("DELETE");
            System.out.println(httpURLConnection.getResponseCode());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistem je obrisao polaganje."));
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            Flash flash = facesContext.getExternalContext().getFlash();
//            flash.setKeepMessages(true);
//            flash.setRedirect(true);
//            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sample info message", "PrimeFaces rocks!"));
        } catch (MalformedURLException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistem ne moze da obrise polaganje."));
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sistem ne moze da obrise polaganje."));
        }
    }

}
