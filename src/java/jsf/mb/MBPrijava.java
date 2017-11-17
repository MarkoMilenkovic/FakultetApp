/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import domen.User;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@ManagedBean(name = "mbPrijava")
@SessionScoped
public class MBPrijava implements Serializable {

    /**
     * Creates a new instance of MBPrijava
     */
    private User user;

    public MBPrijava() {
        user = new User();
        user.setUsername("");
        user.setPassword("");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String prijaviUsera() {
        System.out.println("asd");
        if (user.getUsername() == null || user.getPassword() == null || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return "";
        }

        try {
            System.out.println("Korinik: korisnicko ime:" + user.getUsername() + ", kosrisnicka sifra:" + user.getPassword());
            user = Kontroler.getInstance().prijaviKorisnika(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sluzbenik je uspesno prijavljen.", null));
            return "prva.xhtml";
        } catch (Exception ex) {
            Logger.getLogger(MBPrijava.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistem ne moze da nadje sluzbenika na osnovu unetih vrednosti", null));
        }

        return null;
    }

     public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
}
