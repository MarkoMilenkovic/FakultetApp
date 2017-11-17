/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.konverteri;

import domen.Student;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@FacesConverter(forClass = Student.class, value = "studentCNV")
public class StudentKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!value.isEmpty()){
            String brojIndeksa = value;
            Student s  = Kontroler.getInstance().vratiStudenta(brojIndeksa);
            return s;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Student){
            
            Student s = (Student) value;
            return s.getBrInd();//m.getPtt().toString();            
        }
        
        
        return "";
    }
    
}
