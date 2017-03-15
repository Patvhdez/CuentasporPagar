
package com.cuentasporpagar.controller;

import com.cuentasporpagar.model.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ProveedorController {
    
    private JdbcTemplate jdbcTemplate;
    
    public ProveedorController(){
        
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar()); //recibe objeto del tipo dataSource.
    }
    
    @RequestMapping("proveedores.htm")
    public ModelAndView proveedor(){
        
        ModelAndView mav = new ModelAndView ();
        String sql="select * from Proveedores";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("proveedores");
        return mav;
    }
}
