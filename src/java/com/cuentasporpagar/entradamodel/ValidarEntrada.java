
package com.cuentasporpagar.entradamodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ValidarEntrada implements Validator {
    
     private Pattern pattern;
     private Matcher matcher;
    
    @Override
    public boolean supports(Class<?> type) 
    {
        return Entrada.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Entrada entrada=(Entrada)o;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Fecha_doc",
        "required.Fecha_doc", "El campo Fecha Documento es Obligatorio!");
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Monto",
        "required.Monto", "El campo Monto es Obligatorio!");
           ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Fecha_registro",
        "required.Fecha_registro", "El campo Fecha Registro es Obligatorio!");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Proveedor",
        "required.Proveedor", "El campo Proveedor es Obligatorio!");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Estado",
        "required.Estado", "El campo Estado  es Obligatorio!");
         
    }
}


