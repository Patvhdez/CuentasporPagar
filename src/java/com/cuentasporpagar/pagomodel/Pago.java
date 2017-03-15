
package com.cuentasporpagar.pagomodel;


public class Pago {
    
    private int id;
    private String Descripcion;
    private String Estado;
    
    public Pago(){
        
    }

    public Pago(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    
    
    }

    public Pago(int id, String Descripcion, String Estado) {
        this.id = id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }



}
