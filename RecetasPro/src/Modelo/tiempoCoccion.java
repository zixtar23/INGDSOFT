package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Scanner;


public class tiempoCoccion {
   
    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static PreparedStatement pst2;
    static ResultSet rs;
    static ResultSet rs2;

public static void main(String[] args)throws SQLException{
Scanner input = new Scanner(System.in);

          int tC=0, op=0;
         System.out.println(nombreRecetaItem()); 
          //String n = tiempoCocc(20);
          //System.out.println(n);
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
    
    public static String tiempoCocc(int t){
          String a = "";
       Scanner input = new Scanner(System.in);
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";
            String username = "";
            String password = "";
           
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT * FROM Receta WHERE tiempo = '"+t+"'";
            pst = con.prepareStatement(query);
            rs = null;
            
            try{
                rs = pst.executeQuery();
                while(rs.next())
                {                
                    a+=rs.getString("nombre")+"\n";    
                }
                
            }catch(SQLException sql){}
            pst.close();
            con.close();
            
        }
        catch(SQLException e)
        {}
return a;
    }
    
    public static String nombreReceta(String q){
         ArrayList<String> ar = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String m="";
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";
            String username = "";
            String password = "";
            
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT nombre FROM Receta WHERE  nombre like \""+q+"*\";";
            
            pst = con.prepareStatement(query);
            rs = null;
            rs2 = null;
         
            try{
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                    m+=rs.getString("nombre")+"\n";
                }
            
                 
               
            }catch(SQLException sql){}
            pst.close();
        
            con.close();
             
        }
        catch(SQLException e)
        {}
          return m;
    }
    
    public static ArrayList nombreRecetaItem(){
         ArrayList<String> ar = new ArrayList<>();
        Scanner input = new Scanner(System.in);

          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";
            String username = "";
            String password = "";
            
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT nombre FROM Receta";
            
            pst = con.prepareStatement(query);
            rs = null;
            rs2 = null;
         
            try{
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                    ar.add(rs.getString("nombre"));
                }
         
            }catch(SQLException sql){}
            pst.close();
            con.close();
        }
        catch(SQLException e)
        {}
          return ar;
    }
    
   
}
