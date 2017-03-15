
package com.cuentasporpagar.pagocontroller;

import com.cuentasporpagar.model.Conectar;
import com.cuentasporpagar.pagomodel.Pago;
import com.cuentasporpagar.pagomodel.ValidarPago;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("addpago.htm")

public class AddPagoController {
    
    ValidarPago validarpago;
    private JdbcTemplate jdbcTemplate;
    
    public AddPagoController(){
        this.validarpago = new ValidarPago();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addpago");
        mav.addObject("pago",new Pago());
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("pago") Pago p, BindingResult result,
                SessionStatus status 
        )
        { this.validarpago.validate(p, result);
        if(result.hasErrors()){
            
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addpago");
            mav.addObject("pago", new Pago());
            return mav;
        }else{
            this.jdbcTemplate.update(
             "insert into Conceptos_Pago (Descripcion, Estado) values (?,?)",
              p.getDescripcion(), p.getEstado()
                    
                    );
            return new ModelAndView("redirect:/pago.htm");
            
            }
            
        }
}
    

    