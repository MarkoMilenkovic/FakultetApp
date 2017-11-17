/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.validatori;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Milenkovic
 */
@FacesValidator(value = "ocenaVal")
public class OcenaValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        System.out.println("usao u validator: " + value);
        if (value != null) {

            String ocena = value.toString();
            //if (pib.length())
            for (int i = 0; i < ocena.length(); i++) {
                if (!Character.isDigit(ocena.charAt(i))) {
                    System.out.println("loguje gresku");
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocena mora sadrzati samo cifre", "PORUKA "));
                }

            }
            int o = Integer.parseInt(ocena);
            if (o > 10 || o < 5) {
                System.out.println("loguje gresku");
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocena moze biti od 5 do 10", "PORUKA "));
            }
        }

    }

}
