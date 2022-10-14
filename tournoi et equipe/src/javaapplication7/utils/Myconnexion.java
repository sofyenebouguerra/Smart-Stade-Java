/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javaapplication7.tournoifooot.tournoi;

/**
 *
 * @author RafedDz
 */
public class Myconnexion {
    

    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/freeways_stade", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
            return null;
        }
    }
    
    public static ObservableList<tournoi> getDatatournoi_foot() throws SQLException
    {
        Connection conn = conDB();
        ObservableList<tournoi> list = FXCollections.observableArrayList();
       return null;

    }

}
