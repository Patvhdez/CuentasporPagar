
package com.cuentasporpagar.controller;

import com.cuentasporpagar.model.Conectar;
import com.cuentasporpagar.model.Proveedor;
import com.cuentasporpagar.model.ValidarProveedor;
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
@RequestMapping("edit.htm")
public class EditController 
{
    ValidarProveedor validarProveedor;
    private JdbcTemplate jdbcTemplate;
     
    
    public EditController() 
    {
        this.validarProveedor=new ValidarProveedor();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Proveedor datos=this.selectProveedor(id);
        mav.setViewName("edit");
        mav.addObject("proveedor",
     new Proveedor (id,datos.getNombre(),datos.getTipo_Persona(),datos.getCedula(), datos.getBalance(), datos.getEstado()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("proveedor") Proveedor p,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.validarProveedor.validate(p, result);
        if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id=Integer.parseInt(request.getParameter("id"));
            Proveedor datos=this.selectProveedor(id);
            mav.setViewName("edit");
            mav.addObject("proveedor",new Proveedor(id,datos.getNombre(),datos.getTipo_Persona(),datos.getCedula(), datos.getBalance(), datos.getEstado()));
            return mav;
        }else
        {
            int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update Proveedores "
                + "set Nombre=?, "
                + "Tipo_Persona=?, "
                + "Cedula_Rnc=?, "
                + "Balance=?, "
                + "Estado=? "
                + "where "
                + "id=? ",
         p.getNombre(),p.getTipo_Persona(),p.getCedula(), p.getBalance(), p.getEstado(), id);
         return new ModelAndView("redirect:/proveedores.htm");
        }
       
    }
    public Proveedor selectProveedor(int id) 
    {
        final Proveedor proveedor = new Proveedor();
        String quer = "SELECT * FROM Proveedores WHERE id='" + id+"'";
        return (Proveedor) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Proveedor>() 
            {
                public Proveedor extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        proveedor.setNombre(rs.getString("Nombre"));
                        proveedor.setTipo_Persona(rs.getString("Tipo_Persona"));
                        proveedor.setCedula(rs.getString("Cedula_Rnc"));
                        proveedor.setBalance(rs.getFloat("Balance")); 
                        proveedor.setEstado(rs.getString("Estado"));
                    }
                    return proveedor;
                }


            }
        );
    }
}

