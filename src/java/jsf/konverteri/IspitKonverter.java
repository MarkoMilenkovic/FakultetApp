/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.konverteri;

import domen.Ispit;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import poslovnalogika.Kontroler;

/**
 *
 * @author student1
 */

@FacesConverter(forClass = Ispit.class, value = "ispitCNV")
public class IspitKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (!value.isEmpty()){
            int sifraIspita = Integer.parseInt(value);
            Ispit i  = Kontroler.getInstance().vratiIspit(sifraIspita);
            return i;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if (value instanceof Ispit){
            
            Ispit i = (Ispit) value;
            return i.getSifraIspita().toString();            
        }
        
        
        return "";
    }
    
}
