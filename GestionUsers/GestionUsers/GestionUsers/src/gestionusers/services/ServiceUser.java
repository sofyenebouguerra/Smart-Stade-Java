/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.services;

import gestionusers.entites.Admin;
import gestionusers.entites.Client;
import gestionusers.entites.Employer;
import gestionusers.entites.User;
import gestionusers.utils.Mysqlconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hajje
 */
public class ServiceUser implements Iservice<User>{
    Connection cnx;
    
    public ServiceUser (){
        cnx = Mysqlconnect.getInstance().getCnx();
    }
    public void ajouter(User u) {
      
        Statement st;
        try {
            st = cnx.createStatement();
            String query ="INSERT INTO `utilisateur`( `nom`, `prenom`, `mot_de_passe`,`email`) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getMotdepasse()+"','"+u.getEmail()+"')";
            st.executeUpdate(query);
            if(u instanceof Admin){
                String query1="INSERT INTO `admin`(`ref_admin`) VALUES('"+((Admin) u).getRef_admin()+"')";
                st.executeUpdate(query1);
            }
            else if(u instanceof Client){
                String query2="INSERT INTO `client`(`ref_client`, `age_client`, `abonnement`) VALUES('"+((Client) u).getRef_client()+"','"+((Client) u).getAge_client()+"','"+((Client) u).getAbonnement()+"') ";
                st.executeUpdate(query2);
            }
            else if(u instanceof Employer){
                String query3="INSERT INTO `employer`(`ref_employer`, `sexe`, `ref_magasin`) VALUES('"+((Employer) u).getRef_employer() +"','"+((Employer) u).getSexe()+"','"+((Employer) u).getRefmagasin()+"') ";
                st.executeUpdate(query3);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    
    }
    
    @Override
    public List<User> afficher() throws SQLException {
    Statement stm = cnx.createStatement();
    List<User> lp = new ArrayList<>();
    
    String query = "SELECT * FROM `utilisateur` WHERE 1";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
            User u = new User();
        u.setId_user(rs.getInt("id_user"));
        u.setNom (rs.getString("nom"));
        u.setPrenom(rs.getString("prenom"));
        u.setMotdepasse(rs.getString("mot_de_passe"));
        u.setEmail(rs.getString("email"));
        
        
        
        lp.add(u);
        }
            return lp;
    }

    @Override
    public void supprimer(int id_user) {
        Statement stm;
        try{
            stm=cnx.createStatement();
            String query="DELETE FROM `utilisateur` WHERE id_user="+id_user;
            stm.executeUpdate(query);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void modifier(int id_user, User u ) throws SQLException{
        Statement stm=cnx.createStatement();
        String query="UPDATE `utilisateur` SET `nom`='"+u.getNom()+"',`prenom`='"+u.getPrenom()+"',`mot_de_passe`='"+u.getMotdepasse()+"',`email`='"+u.getEmail()+"' WHERE `id_user`="+id_user;
        stm.executeUpdate(query);
    }
    public boolean loginverif(String nom,String mdp) throws SQLException{
        Statement stm = cnx.createStatement();
        String query = "SELECT * FROM utilisateur WHERE nom='"+nom+"' AND mot_de_passe ='"+mdp+"'" ;
        ResultSet rs= stm.executeQuery(query);
        if (rs.next() == false){
            return false;
        }
        else{
            return true;
        }
    }
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


