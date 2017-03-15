
package com.cuentasporpagar.pagocontroller;
import com.cuentasporpagar.pagomodel.Conectar;
import com.cuentasporpagar.pagomodel.Pago;
import com.cuentasporpagar.pagomodel.ValidarPago;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("editpago.htm")
public class EditPagoController 
{
    ValidarPago validarPago;
    private JdbcTemplate jdbcTemplate;
     
    
    public EditPagoController() 
    {
        this.validarPago=new ValidarPago();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Pago datos=this.selectPago(id);
        mav.setViewName("editpago");
        mav.addObject("pago",
     new Pago (id,datos.getDescripcion(),datos.getEstado()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("pago") Pago p,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.validarPago.validate(p, result);
        if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id=Integer.parseInt(request.getParameter("id"));
            Pago datos=this.selectPago(id);
            mav.setViewName("editpago");
            mav.addObject("pago",new Pago(id,datos.getDescripcion(),datos.getEstado()));
            return mav;
        }else
        {
            int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update Conceptos_Pago "
                + "set Descripcion=?, "
                + "Estado=? "
                + "where "
                + "id=? ",
         p.getDescripcion(),p.getEstado(), id);
         return new ModelAndView("redirect:/pago.htm");
        }
       
    }
    public Pago selectPago(int id) 
    {
        final Pago pago = new Pago();
        String quer = "SELECT * FROM Conceptos_Pago WHERE id='" + id+"'";
        return (Pago) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Pago>() 
            {
                public Pago extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        pago.setDescripcion(rs.getString("Descripcion"));
                        pago.setEstado(rs.getString("Estado"));
                    }
                    return pago;
                }


            }
        );
    }
}

