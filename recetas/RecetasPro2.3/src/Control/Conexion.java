/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Cristian López
 */
public class Conexion {
    
    static Connection con;    
    
    String dbURL = "jdbc:ucanaccess://C:\\Users\\Ingenieria\\Desktop\\Nueva carpeta/Rest1.accdb";
    String username = "";
    String password = "";
            
            
    
    /**
 * Metodo para establecer la conexion a Access
 */
    public void conectar() {
      try{
         con = DriverManager.getConnection(dbURL, username, password);
         //si la conexion tuvo exito
         if (con!=null){
            System.out.println("Conexión a base de datos. Exitosa");
         }
      }catch(SQLException e){
         System.out.println(e);
      }
   }
    
    /**
 * Metodo para cerrar una conexion a Access
 */
    public void desconectar(){
        try {
            con.close();            
            System.out.println("La conexion a la base de datos a terminado");
        } catch (SQLException ex) {
            System.out.println( ex.getMessage() );
        }       
   }
}
    

