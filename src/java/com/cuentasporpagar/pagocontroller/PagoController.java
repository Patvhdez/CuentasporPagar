
package com.cuentasporpagar.pagocontroller;

import com.cuentasporpagar.model.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class PagoController {
     private JdbcTemplate jdbcTemplate;
    
   public PagoController(){
       Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
   }
   
    @RequestMapping("pago.htm")
public ModelAndView pago()   
{
    ModelAndView mav=new ModelAndView();
        String sql="select * from Conceptos_Pago";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("pago");
        return mav;
    
}
}
