
package com.cuentasporpagar.entradacontroller;

import com.cuentasporpagar.entradamodel.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



public class EntradaController 
{
    private JdbcTemplate jdbcTemplate;
    
    public EntradaController()
    {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    
    }
    
    
    @RequestMapping("entrada.htm")
    public ModelAndView entrada()
    {
        ModelAndView mav = new ModelAndView();
        String sql="select * from Entrada_Docs";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("entrada");
        return mav;
        
    }
    
}
