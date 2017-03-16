
package com.cuentasporpagar.entradacontroller;

import com.cuentasporpagar.entradamodel.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteentradaController {
    private JdbcTemplate jdbcTemplate;
    public DeleteentradaController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    
    @RequestMapping("deleteentrada.htm")
    public ModelAndView entrada(HttpServletRequest request) 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "delete from Entrada_Docs "
                + "where "
                + "id=? ",
        id);
        return new ModelAndView("redirect:/entrada.htm");
    }
}
