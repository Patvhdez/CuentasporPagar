
package com.cuentasporpagar.pagocontroller;
import com.cuentasporpagar.pagomodel.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeletePagoController {
    private JdbcTemplate jdbcTemplate;
    public DeletePagoController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    
    @RequestMapping("deletepago.htm")
    public ModelAndView pago(HttpServletRequest request) 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "delete from Conceptos_Pago "
                + "where "
                + "id=? ",
        id);
        return new ModelAndView("redirect:/pago.htm");
    }
}
