
package com.cuentasporpagar.entradacontroller;

import com.cuentasporpagar.entradamodel.Conectar;
import com.cuentasporpagar.entradamodel.Entrada;
import com.cuentasporpagar.entradamodel.ValidarEntrada;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("addentrada.htm")
public class AddentradaController 
{
    ValidarEntrada validarEntrada = new ValidarEntrada();
    private JdbcTemplate jdbcTemplate;
    
    public AddentradaController()
    {
        this.validarEntrada = new ValidarEntrada();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("addentrada");
        mav.addObject("entrada", new Entrada());
        return mav;
    }
     @RequestMapping(method=RequestMethod.POST)
     public ModelAndView form(
    
        @ModelAttribute("entrada") Entrada e,
        BindingResult result ,
        SessionStatus status
      )
        
     {
        this.validarEntrada.validate(e, result);
        if (result.hasErrors()){
            
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addentrada");
            mav.addObject("entrada", new Entrada());
            return mav;
        }else
        {
            this.jdbcTemplate.update(
          "insert into Entrada_Docs (Fecha_doc, Monto, Fecha_registro, Proveedor, Estado) values(?,?,?,?,?)",
                    e.getFecha_doc(), e.getMonto(), e.getFecha_registro(), e.getProveedor(), e.getEstado());
            return new ModelAndView ("redirect:/entrada.htm");
        }
     
     }
}
