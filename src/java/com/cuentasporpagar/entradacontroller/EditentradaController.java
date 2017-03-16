
package com.cuentasporpagar.entradacontroller;

import com.cuentasporpagar.entradamodel.Conectar;
import com.cuentasporpagar.entradamodel.Entrada;
import com.cuentasporpagar.entradamodel.ValidarEntrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("editentrada.htm")
public class EditentradaController
{
    Date FechaDoc;
    Date FechaRegistro;
    ValidarEntrada validarEntrada;
    private JdbcTemplate jdbcTemplate;
    
    public EditentradaController()
    {
        this.validarEntrada = new ValidarEntrada();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());       
    }
    
   @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Entrada datos=this.selectEntrada(id);
        mav.setViewName("editentrada");
        mav.addObject("entrada",
     new Entrada (id,datos.getFecha_doc(), datos.getMonto(), datos.getFecha_registro(), 
          datos.getProveedor(), datos.getEstado()));
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("entrada") Entrada e,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        
        ) throws ParseException
    {
        
        this.validarEntrada.validate(e, result);
        if (result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Entrada datos=this.selectEntrada(id);
        mav.setViewName("editentrada");
        mav.addObject("entrada",
     new Entrada (id,datos.getFecha_doc(), datos.getMonto(), datos.getFecha_registro(), 
          datos.getProveedor(), datos.getEstado()));
        return mav;
        }else
        {
            int id = Integer.parseInt(request.getParameter("id"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");           
            this.jdbcTemplate.update
        (
          "update Entrada_Docs" 
           + "set Fecha_doc=?,"
           + "Monto=?,"
           + "Fecha_registro=?,"
           + "Proveedor=?,"
           + "Estado=? "
           +"where "
           + "id=? ",
                new java.sql.Date(dateFormat.parse(e.getFecha_doc()).getTime()) , e.getMonto(), new java.sql.Date(dateFormat.parse(e.getFecha_registro()).getTime()), e.getProveedor(),
                e.getEstado(), id);
            return new ModelAndView("redirect:/entrada.htm");
          
        }
            
    }
        public Entrada selectEntrada(int id) 
    {
        final Entrada entrada = new Entrada();
        String quer = "SELECT * FROM Entrada_Docs WHERE id='" + id+"'";
        return (Entrada) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Entrada>() 
            {
                public Entrada extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        entrada.setFecha_doc(rs.getString("Fecha_doc"));
                        entrada.setMonto(rs.getFloat("Monto"));
                        entrada.setFecha_registro(rs.getString("Fecha_registro"));
                        entrada.setProveedor(rs.getString("Proveedor")); 
                        entrada.setEstado(rs.getString("Estado"));
                    }
                    return entrada;
                }


            }
        );
    }
}  

