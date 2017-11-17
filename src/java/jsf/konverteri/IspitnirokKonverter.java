/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.konverteri;

import domen.Ispitnirok;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import poslovnalogika.Kontroler;

/**
 *
 * @author student1
 */

@FacesConverter(forClass = Ispitnirok.class, value = "ispitnirokCNV")
public class IspitnirokKonverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (!value.isEmpty()){
            int sifraIspitnogRoka = Integer.parseInt(value);
            Ispitnirok i  = Kontroler.getInstance().vratiIspitnirok(sifraIspitnogRoka);
            return i;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if (value instanceof Ispitnirok){
            
            Ispitnirok i = (Ispitnirok) value;
            return i.getSifraIspitnogRoka().toString();            
        }
        
        
        return "";
    }
    
}
