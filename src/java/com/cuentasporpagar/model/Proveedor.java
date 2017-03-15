
package com.cuentasporpagar.model;


public class Proveedor {
    private int id;
    private String Nombre, Tipo_Persona, Cedula,Estado;
    private float Balance;
    

    public Proveedor() {
    }

    public Proveedor(String Nombre, String Tipo_Persona, String Cedula, float Balance, String Estado) {
        this.Nombre = Nombre;
        this.Tipo_Persona = Tipo_Persona;
        this.Cedula = Cedula;
        this.Balance = Balance;
        this.Estado = Estado;
    }

    public Proveedor(int id, String Nombre, String Tipo_Persona, String Cedula, float Balance, String Estado) {
        this.id = id;
        this.Nombre = Nombre;
        this.Tipo_Persona = Tipo_Persona;
        this.Cedula = Cedula;
        this.Balance = Balance;
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo_Persona() {
        return Tipo_Persona;
    }

    public void setTipo_Persona(String Tipo_Persona) {
        this.Tipo_Persona = Tipo_Persona;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float Balance) {
        this.Balance = Balance;
    }

    
    }


    