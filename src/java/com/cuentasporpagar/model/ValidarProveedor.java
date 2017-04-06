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

    public boolean supports(Class<?> type) {
        return Proveedor.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Proveedor proveedor = (Proveedor) o;
        boolean cedula = validarCedula(proveedor.getCedula());
        boolean rnc = validarRnc(proveedor.getCedula().toCharArray());

        if (!cedula && !rnc) {
            errors.reject("Cedula", "Cedula o RNC inválido");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "required.Nombre", "El Campo Nombre es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Tipo_Persona", "required.Tipo_Persona", "El Campo Tipo Persona es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Cedula", "required.Cedula", "El Campo Cedula es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Balance", "required.Balance", "El Campo Balance es obligatorio!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Estado", "required.Estado", "El Campo Estado es obligatorio!");
    }

    public static boolean validarCedula(String cedula) {
        int suma = 0;
        final char[] peso = {'1', '2', '1', '2', '1', '2', '1', '2', '1', '2'};
        if ((cedula == null) || (cedula.length() != 11)) {
            return false;
        }
        try {
            Long.parseLong(cedula);
        } catch (Exception e) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
            int a = Character.getNumericValue(cedula.charAt(i));
            int b = Character.getNumericValue(peso[i]);
            char[] mult = Integer.toString(a * b).toCharArray();
            if (mult.length > 1) {
                a = Character.getNumericValue(mult[0]);
                b = Character.getNumericValue(mult[1]);
            } else {
                a = 0;
                b = Character.getNumericValue(mult[0]);
            }
            suma = suma + a + b;
        }
        int digito = (10 - (suma % 10)) % 10;
        if (digito != Character.getNumericValue(cedula.charAt(10))) {
            return false;
        }
        return true;
    }

    static public boolean validarRnc(char[] rnc) {
        final char[] peso = {'7', '9', '8', '6', '5', '4', '3', '2'};
        int suma = 0;
        int division = 0;

        if (rnc.length != 9) {
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                //para verificar si es un dígito o no
                if (!Character.isDigit(rnc[i])) {
                    return false;
                }

                suma = suma + (Character.getNumericValue(rnc[i]) * Character.getNumericValue(peso[i]));
            }

            division = suma / 11;
            int resto = suma - (division * 11);
            int digito = 0;

            if (resto == 0) {
                digito = 2;
            } else if (resto == 1) {
                digito = 1;
            } else {
                digito = 11 - resto;
            }

            if (digito != Character.getNumericValue(rnc[8])) {
                return false;
            }
        }
        return true;
    }

}
