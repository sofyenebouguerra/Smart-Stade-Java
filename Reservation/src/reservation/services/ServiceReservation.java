
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reservation.entites.DataBase;
import reservation.entites.Reservation;
import reservation.utils.Myconnexion;








/**
 *
 * @author ismail
 */
public class ServiceReservation implements IServices<Reservation> {
    
    Connection cnx;
    
    public ServiceReservation() throws SQLException{
        cnx = (Connection)DataBase.conDB();
    }
     
    
    @Override
    public void ajouter(Reservation r) {
      
        Statement st;
        try {
            st = cnx.createStatement();
       String query ="INSERT INTO `reservation`(`cin_client`,`ref_match`,`num_ticket`) VALUES ('"+r.getCin_client()+"','"+r.getRef_match()+"','"+r.getNum_ticket()+"')";
      
        st.executeUpdate(query);
        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     
    @Override
    public List<Reservation> afficher() throws SQLException {
    Statement stm = cnx.createStatement();
    List<Reservation> lr = new ArrayList<>();
    
    String query = "SELECT * FROM reservation";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
            Reservation r = new Reservation();
        r.setId_reservation(rs.getInt("id_reservation"));    
        r.setCin_client(rs.getInt("cin_client"));
        r.setRef_match(rs.getString("ref_match"));
        r.setNum_place(rs.getString("num_ticket"));
        r.setDate_reservation(rs.getDate("date_reservation"));
        
        lr.add(r);
        }
            return lr;
    }
    
    public void supprimer(int cin)  {
      
        Statement st;
        try {
            st = cnx.createStatement();
       String query = "DELETE FROM reservation WHERE cin_client='"+cin+"'";
      
        st.executeUpdate(query);
        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    public void modifier(int cin,  Reservation r) {  
        Statement st;
        try {
            st = cnx.createStatement();
         
            String query = "UPDATE `reservation` SET `ref_match`='"+r.getRef_match()+"',`num_ticket`='"+r.getNum_ticket()+"' WHERE cin_client = "+cin+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
    

    }
    
    public List<Reservation> recherche(int cin) throws SQLException {
    Statement stm = cnx.createStatement();
    List<Reservation> lr = new ArrayList<>();
    
    String query = "SELECT * FROM reservation WHERE cin_client='"+cin+"'";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
            Reservation r = new Reservation();
       
        r.setCin_client(rs.getInt("cin_client"));
        r.setRef_match(rs.getString("ref_match"));
        r.setNum_place(rs.getString("num_ticket"));
        r.setDate_reservation(rs.getDate("date_reservation"));
        
        lr.add(r);
        }
            return lr;
    }
    
    
    
    
}   