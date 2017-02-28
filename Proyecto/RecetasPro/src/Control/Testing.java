package Control;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;




public class Testing {

    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;

public static void main(String[] args)throws SQLException{
Scanner input = new Scanner(System.in);
//          try{
//
//            String dbURL = "jdbc:ucanaccess://C:\\Users\\Ingenieria\\Downloads\\Pre\\Nueva carpeta/Rest1.accdb";
//            String username = "";
//            String password = "";
//            
//            con = DriverManager.getConnection(dbURL, username, password);
//            String query = "select * from Ingrediente";
//            pst = con.prepareStatement(query);
//            rs = null;
//            
//            try{
//                rs = pst.executeQuery();
//                while(rs.next())
//                {
//                    System.out.println(rs.getString("nombre_ingrediente"));
//                }
//            }catch(SQLException sql){}
//            pst.close();
//            con.close();
//            
//        }
//        catch(SQLException e)
//        {} 

try{

            String dbURL = "jdbc:ucanaccess://C:\\Users\\Ingenieria\\Downloads\\Pre\\Nueva carpeta\\Rest1.accdb";
            String username = "";
            String password = "";
            
            con = DriverManager.getConnection(dbURL, username, password);
            
           
            try{


                String query = "INSERT INTO Tabla1 VALUES (NULL, 'Laconchade tu madre')";

                
                pst = con.prepareStatement(query);
                pst.executeUpdate();
                System.out.println("Inserted");
            }catch(SQLException sql){}
            con.close();
            
        }
        catch(SQLException e)
        {} 

    }
}