/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import domen.Mesto;
import domen.Student;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@ManagedBean(name = "mbUnosStudenta")
@SessionScoped
public class MBUnosStudenta implements Serializable {

    /**
     * Creates a new instance of MBUnosStudenta
     */
    private Student student;
    private List<Mesto> listaMesta;

    public MBUnosStudenta() {
        student = new Student();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Mesto> getListaMesta() {
        return listaMesta;
    }

    public void setListaMesta(List<Mesto> listaMesta) {
        this.listaMesta = listaMesta;
    }

//    @PostConstruct
//    public void inicijalizujPodatke(){
//        listaMesta = Kontroler.getInstance().vratiMesta();
//    }
    public void onload() {
        listaMesta = Kontroler.getInstance().vratiMesta();
    }

    public void sacuvajStudenta() {

        try {
            Kontroler.getInstance().dodajStudenta(student);
            student = new Student();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je zapamtio studenta", null));
            student.setBrInd("");student.setIme("");student.setPrezime("");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sistem ne moze da zapamti novog studenta", null));
        }
    }
}
