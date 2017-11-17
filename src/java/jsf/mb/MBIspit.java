/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import domen.Ispit;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@ManagedBean(name = "mbIspit")
@SessionScoped
public class MBIspit implements Serializable{

    /**
     * Creates a new instance of MBIspit
     */
    private Ispit ispit;
    private List<Ispit> listaIspita;

    public MBIspit() {
        ispit = new Ispit();
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public List<Ispit> getListaIspita() {
        return listaIspita;
    }

    public void setListaIspita(List<Ispit> listaIspita) {
        this.listaIspita = listaIspita;
    }
//    @PostConstruct
//    public void popuniListuIspita(){
//        listaIspita = Kontroler.getInstance().vratiIspite();
//    }
      public void onload(){
       listaIspita = Kontroler.getInstance().vratiIspite();
    }
    public String vratiPolaganja(Ispit i){
        ispit = i;
        return "prikazPolaganjaPoIspitima.xhtml";
    }
        
}
