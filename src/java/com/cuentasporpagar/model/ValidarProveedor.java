
package com.cuentasporpagar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class ValidarProveedor implements Validator {
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@"
            + "^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    
    private Pattern pattern;
    private Matcher matcher;

@Override    

public boolean supports(Class<?> type){
    return Proveedor.class.isAssignableFrom(type);
}

    @Override
    public void validate(Object o, Errors errors) {
        
        Proveedor proveedor = (Proveedor)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "El Campo Nombre es obligatorio!");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Tipo_Persona", "required.Tipo_Persona", "El Campo Tipo Persona es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Cedula", "required.Cedula", "El Campo Cedula es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Balance", "required.Balance", "El Campo Balance es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Estado", "required.Estado", "El Campo Estado es obligatorio!");   
    }
    
    
    
}
