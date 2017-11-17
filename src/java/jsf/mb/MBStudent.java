/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import domen.Student;
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
@ManagedBean(name="mbStudent")
@SessionScoped
public class MBStudent implements Serializable{

    /**
     * Creates a new instance of MBStudent
     */
    private Student student;
    private List<Student> listaStudenata;
    public MBStudent() {
        student = new Student();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public List<Student> getListaStudenata() {
        return listaStudenata;
    }

    public void setListaStudenata(List<Student> listaStudenata) {
        this.listaStudenata = listaStudenata;
    }
    
    
//    @PostConstruct
//    public void popuniListuStudenata(){
//        listaStudenata = Kontroler.getInstance().vratiStudente();
//    }
    
    public String vratiPolaganja(Student s){
        student = s;
        return "prikazPolaganja.xhtml";
    }
    public void onload(){
        listaStudenata = Kontroler.getInstance().vratiStudente();
    }
    
    
}
