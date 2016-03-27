/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author welli
 */
public class ConexaoMySql {
    
    String serverName = "";
    String mydatabase = "sys";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "admin";
    String password = "admin";
    Connection conexao;
   
   ConexaoMySql() throws SQLException{ 
       conexao = DriverManager.getConnection(url, username, password);
   }
    
}
