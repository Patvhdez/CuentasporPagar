
package com.cuentasporpagar.pagomodel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ValidarPago implements Validator{
     private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
   
     private Pattern pattern;
     private Matcher matcher;
    
    @Override
    public boolean supports(Class<?> type) 
    {
        return Pago.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pago pago=(Pago)o;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Descripcion",
        "required.Descripcion", "El campo Descricion es Obligatorio!");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Estado",
        "required.Estado", "El campo Estado  es Obligatorio!");
         
    }
}
