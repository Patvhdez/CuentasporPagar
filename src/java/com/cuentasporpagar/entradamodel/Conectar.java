
package com.cuentasporpagar.entradamodel;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
    
    public DriverManagerDataSource conectar()
    {
        
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/CuentasDB");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    
    }
}
