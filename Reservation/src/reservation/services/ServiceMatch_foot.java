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
import reservation.entites.Reservation;
import reservation.entites.Match_foot;
/**
 *
 * @author ismail
 */
public  class ServiceMatch_foot implements IServices<Match_foot> {
    
    Connection cnx;
    
    public ServiceMatch_foot() throws SQLException{
        cnx = (Connection)DataBase.conDB();
    }
    
    
    @Override
    public void ajouter(Match_foot m) {
      
        Statement stm;
        try {
            stm = cnx.createStatement();
       String query ="INSERT INTO `Match_foot`(`ref_match`,`date_match`,`nom_stade`,`nbr_spectateur`) VALUES ('"+m.getRef_match()+"','"+m.getDate_match()+"','"+m.getNom_stade()+"','"+m.getNbr_spectateur()+"')";
      
        stm.executeUpdate(query);
        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    public List<Match_foot> afficher() throws SQLException {
    Statement stm = cnx.createStatement();
    List<Match_foot> lm = new ArrayList<>();
    
    String query = "SELECT * FROM match_foot";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
            Match_foot m = new Match_foot();
        m.setRef_match(rs.getString("ref_match"));
        m.setDate_match(rs.getString("date_match"));
        m.setNom_stade(rs.getString("Nom_stade"));
         m.setNbr_spectateur(rs.getInt("nbr_spectateur"));
        lm.add(m);
        }
            return lm;
    }
    
     public void supprimer(String ref)  {
      
        Statement st;
        try {
            st = cnx.createStatement();
       String query = "DELETE FROM match_foot WHERE ref_match='"+ref+"'";
      
        st.executeUpdate(query);
        
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public void modifier(String ref,  Match_foot m) {  
        Statement st;
        try {
            st = cnx.createStatement();
         
            String query = "UPDATE `match_foot` SET `date_match`='"+m.getDate_match()+"',`nom_stade`='"+m.getNom_stade()+"',`nbr_spectateur`='"+m.getNbr_spectateur()+"' WHERE ref_match = "+ref+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
        
        public Match_foot Search(String ref) throws SQLException{
        Statement st = cnx.createStatement();
        Match_foot match_foot =new Match_foot();
        String query = "select * from match_foot where ref_match="+ref;
        ResultSet rs= st.executeQuery(query);
        while (rs.next()){
            match_foot.setRef_match(rs.getString("ref_match"));
            match_foot.setDate_match(rs.getString("date_match"));
            match_foot.setNom_stade(rs.getString("nom_stade"));
            
        
            
        }
        return match_foot;
    }
    
    
    
    }
    
    
    
    

