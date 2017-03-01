package Modelo;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class ConsultaOrdenada {

    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;

    
    public ArrayList consultaReceta() {
        ArrayList result = new ArrayList<>();
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\david\\Desktop\\recetas/Rest1.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "Select nombre from recta"; //query a modificar (Select * from tabla1)
            pst = con.prepareStatement(query);
            rs = null;
            try {
                rs = pst.executeQuery();
                while (rs.next()) {
                    //result=resultSetToArrayList(rs);
                    result.add(rs.getString("nombre"));
                }
                System.out.println(result);
            } catch (SQLException sql) {
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
        }
        return result;
    
    }
    public static void main(String[] args)throws SQLException{
Scanner input = new Scanner(System.in);
         
          ConsultaOrdenada obj= new ConsultaOrdenada();
         obj.consultaReceta();
          
         /*System.out.println("¿Qué desea hacer?\n\n1. Ingresar nombre receta\n\n2. Ingresar el tiempo de cocción");
         op = input.nextInt();
         if(op==1){;
             nombreReceta();
             
         }else if(op==2){
             System.out.println("Ingrese el tiempo de cocción:");
         tC = input.nextInt();
         tiempoCocc(tC);
         }*/
  
   }
}