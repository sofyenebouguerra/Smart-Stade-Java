/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import reservation.entites.Reservation;
import reservation.services.ServiceReservation;
import reservation.utils.Myconnexion;
import reservation.entites.Match_foot;
import reservation.entites.Ticket;
import reservation.services.ServiceMatch_foot;
import reservation.services.ServiceTicket;


/**
 *
 * @author ismail
 */
public class test {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
       Reservation r = new Reservation(18, "farouk","33");
        ServiceReservation sr = new ServiceReservation();
        sr.ajouter(r);
        try {
            //affichage
            System.out.println(sr.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
     // sr.supprimer("44");

       // sr.modifier("18",r);
       
        
       // Match_foot m = new Match_foot("zzz", "555","555");
        ServiceMatch_foot sm = new ServiceMatch_foot();
      // sm.ajouter(m);
        try {
            //affichage
            System.out.println(sm.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
      // sr.supprimer(2);

       //sm.modifier("zzz",m);
        
        Ticket t = new Ticket("11", "666","666","666");
        ServiceTicket st = new ServiceTicket();
       st.ajouter(t);
        try {
            //affichage
            System.out.println(st.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
      // sr.supprimer(2);

       // st.modifier("11",t);
        
        st.Search("11");
        
        
    }
    
   
        
    }
    
    
    
    
    
    
    
    
    
    

