/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuentasporpagar.entradacontroller;


public class EntradaContable{

   public EntradaContable(int cuentaContable, String tipoMovimiento, double monto) {
       this.cuentaContable = cuentaContable;
       this.tipoMovimiento = tipoMovimiento;
       this.monto = monto;
   }
    int cuentaContable;
    String tipoMovimiento;
    double monto;
}
