/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reservation.entites.DataBase;
import reservation.entites.Match_foot;
import reservation.entites.Reservation;
import reservation.utils.Myconnexion;
import reservation.entites.Ticket;

/**
 *
 * @author ismail
 */
public class ServiceTicket implements IServices<Ticket>{
    
     Connection cnx;
    
    public ServiceTicket() throws SQLException{
        cnx = (Connection)DataBase.conDB();
    }
    @Override
    public void ajouter(Ticket t) {
      
        Statement st;
        try {
            st = cnx.createStatement();
       String query ="INSERT INTO `ticket`(`num_ticket`,`ref_match`,`num_place`,`disp`) VALUES ('"+t.getNum_ticket()+"','"+t.getRef_match()+"','"+t.getNum_place()+"','"+t.getDisp()+"')";
      
        st.executeUpdate(query);
        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @Override
    public List<Ticket> afficher() throws SQLException {
    Statement stm = cnx.createStatement();
    List<Ticket> lt = new ArrayList<>();
    
    String query = "SELECT * FROM Ticket";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
            Ticket t = new Ticket();
        t.setNum_ticket(rs.getString("num_ticket"));
        t.setRef_match(rs.getString("ref_match"));
        t.setNum_place(rs.getString("num_place"));
        t.setDisp(rs.getString("disp"));
        lt.add(t);
        }
            return lt;
    }
    public void supprimer(String num)  {
      
        Statement st;
        try {
            st = cnx.createStatement();
       String query = "DELETE FROM ticket WHERE num_ticket='"+num+"'";
      
        st.executeUpdate(query);
        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifier(String num, Ticket t) {  
        Statement st;
        try {
            st = cnx.createStatement();
         
            String query = "UPDATE `ticket` SET `ref_match`='"+t.getRef_match()+"',`num_place`='"+t.getNum_place()+"',`disp`='"+t.getDisp()+"' WHERE num_ticket = "+num+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public Ticket Search(String num) throws SQLException{
        Statement st = cnx.createStatement();
        Ticket ticket =new Ticket();
        String query = "select * from Ticket where num_ticket="+num;
        ResultSet rs= st.executeQuery(query);
        while (rs.next()){
            ticket.setNum_ticket(rs.getString("num_ticket"));
            ticket.setRef_match(rs.getString("ref_match"));
            ticket.setNum_place(rs.getString("num_place"));
            ticket.setDisp(rs.getString("disp")); 
        
            
        }
        return ticket;
    }
    
}
