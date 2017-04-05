
package com.cuentasporpagar.entradamodel;

import org.springframework.format.annotation.DateTimeFormat;


public class Entrada {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String Fecha_doc;
    private Float Monto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String Fecha_registro;
    private String Proveedor;
    private String Estado;

    public Entrada() {
    }

    public Entrada(String Fecha_doc, Float Monto, String Fecha_registro, String Proveedor, String Estado) {
        this.Fecha_doc = Fecha_doc;
        this.Monto = Monto;
        this.Fecha_registro = Fecha_registro;
        this.Proveedor = Proveedor;
        this.Estado = Estado;
    }

    public Entrada(int id, String Fecha_doc, Float Monto, String Fecha_registro, String Proveedor, String Estado) {
        this.id = id;
        this.Fecha_doc = Fecha_doc;
        this.Monto = Monto;
        this.Fecha_registro = Fecha_registro;
        this.Proveedor = Proveedor;
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_doc() {
        return Fecha_doc;
    }

    public void setFecha_doc(String Fecha_doc) {
        this.Fecha_doc = Fecha_doc;
    }

    public Float getMonto() {
        return Monto;
    }

    public void setMonto(Float Monto) {
        this.Monto = Monto;
    }

    public String getFecha_registro() {
        return Fecha_registro;
    }

    public void setFecha_registro(String Fecha_registro) {
        this.Fecha_registro = Fecha_registro;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }
    
    

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
            
}
