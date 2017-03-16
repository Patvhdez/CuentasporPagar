
package com.cuentasporpagar.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
    
    public DriverManagerDataSource conectar(){
        
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_9ee598636de48da");
        dataSource.setUsername("bed5e0f367d4fa");
        dataSource.setPassword("8c9fdf2b");
        return dataSource;
    }
    
}
