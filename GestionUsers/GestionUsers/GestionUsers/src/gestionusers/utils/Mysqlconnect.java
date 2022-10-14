/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.utils;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static javafx.css.StyleOrigin.USER;
import javax.swing.JOptionPane;

/**
 *
 * @author hajje
 */
public class Mysqlconnect {
    final String URL="jdbc:mysql://127.0.0.1:3306/freeways_stade";
    final String USER ="root";
    final String PWD ="";
    private static Connection cnx ;
    private static Mysqlconnect instance ;
  

    private  Mysqlconnect() {
        try {
            cnx = DriverManager.getConnection(URL, USER, PWD);
             JOptionPane.showMessageDialog(null, "connexion etablie ^_^ ");
             //System.out.println("connexion etablie ^_^ ");
        } catch (Exception e) {
        
           JOptionPane.showMessageDialog(null, e);
           //System.out.println(ex.getMessage());
           }
    }
  public static Mysqlconnect getInstance(){
      
      if (instance == null){
          instance = new Mysqlconnect();
      }
      
      return instance;
  }
         public static Connection getCnx (){
             return cnx;
         }
          
    
    
}
