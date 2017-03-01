/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
import Control.Conexion;

public class CrearReceta {

    static Connection con;   
    static Statement st;
    static PreparedStatement pst;
//    static ResultSet rs;

    Scanner input = new Scanner(System.in);

    public void insertarDatos() {
        try {

            System.out.println("Enter the name which you want to insert");
            String name = input.nextLine();
            String query = "insert into tb values('" + name + "')";
            pst =  con.prepareStatement(query);
//            rs = null;

            try {
                st = con.createStatement();
                st.execute(query);

            } catch (SQLException sql) {
            }
            st.close();

        } catch (SQLException e) {
        }
    }

}
