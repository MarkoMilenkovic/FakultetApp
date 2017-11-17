/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.konverteri;

import domen.Mesto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import poslovnalogika.Kontroler;

/**
 *
 * @author student1
 */

@FacesConverter(forClass = Mesto.class, value = "mestoCNV")
public class MestoKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (!value.isEmpty()){
            int ptt = Integer.parseInt(value);
            Mesto m  = Kontroler.getInstance().vratiMesto(ptt);
            return m;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if (value instanceof Mesto){
            
            Mesto m = (Mesto) value;
            return m.getPtt().toString();            
        }
        
        
        return "";
    }
    
}
