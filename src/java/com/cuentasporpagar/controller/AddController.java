
package com.cuentasporpagar.controller;

import com.cuentasporpagar.model.Conectar;
import com.cuentasporpagar.model.Proveedor;
import com.cuentasporpagar.model.ValidarProveedor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("add.htm")

public class AddController {
    
    ValidarProveedor validarProveedor;
    private JdbcTemplate jdbcTemplate;
    
    public AddController(){
        this.validarProveedor = new ValidarProveedor();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");
        mav.addObject("proveedor",new Proveedor());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("proveedor") Proveedor p, BindingResult result,
                SessionStatus status 
        )
        { this.validarProveedor.validate(p, result);
        if(result.hasErrors()){
            
            ModelAndView mav = new ModelAndView();
            mav.setViewName("add");
            mav.addObject("proveedor", new Proveedor());
            return mav;
        }else{
            this.jdbcTemplate.update(
             "insert into Proveedores (Nombre, Tipo_Persona, Cedula_Rnc, Balance, Estado) values (?,?,?,?,?)",
              p.getNombre(), p.getTipo_Persona(), p.getCedula(), p.getBalance(), p.getEstado()
                    
                    );
            return new ModelAndView("redirect:/proveedores.htm");
            
            }
            
        }
}
    

    

