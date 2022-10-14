/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaapplication7.tournoifooot.tournoi;
import javaapplication7.utils.Myconnexion;

/**
 *
 * @author RafedDz
 */
public class Servicetournoi implements IServicetournoi<tournoi>{
    Connection cnx;
    
    public Servicetournoi (){
        cnx = Myconnexion.conDB();
    }
    
    @Override
    public void ajouter(tournoi t) {
        Statement st;
        try {
            st = cnx.createStatement();
            String query ="INSERT INTO `tournoi`( `nom_tournoi`, `nbr_equipes`, `date_debut_tournoi`, `date_fin_tournoi`, `heure_match_tournoi`, `nbr_poules`) VALUES ('"+t.getNom_tournoi()+"',"+t.getNbr_equipes()+",'"+t.getDate_debut_tournoi()+"','"+t.getDate_fin_tournoi()+"',"+t.getHeure_match_tournoi()+","+t.getNbr_poules()+")";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(int id , tournoi t) {  
        Statement st;
        try {
            st = cnx.createStatement();
            //String query = "UPDATE tournoi SET  nom_tournoi='"+t.getNom_tournoi()+"',nbr_equipes="+t.getNbr_equipes()+",date_debut_tournoi='"+t.getDate_debut_tournoi()+"',date_fin_tournoi='"+t.getDate_fin_tournoi()+"',heure_match_tournoi"+t.getHeure_match_tournoi()+"nbr_poules="+t.getNbr_poules()+" WHERE id_tournoi = "+id+" ";
            String query = "UPDATE `tournoi` SET `nom_tournoi`='"+t.getNom_tournoi()+"',`nbr_equipes`="+t.getNbr_equipes()+",`date_debut_tournoi`='"+t.getDate_debut_tournoi()+"',`date_fin_tournoi`='"+t.getDate_fin_tournoi()+"',`heure_match_tournoi`="+t.getHeure_match_tournoi()+",`nbr_poules`="+t.getNbr_poules()+" WHERE id_tournoi = "+id+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(int id) {  
        Statement st;
        try {
            st = cnx.createStatement();
            String query ="DELETE FROM `tournoi` where `id_tournoi` = "+id+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void recherche(int id) {
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_tournoi FROM tournoi WHERE id_tournoi = "+id+"");
            while (rs.next()){
            String nom_tournoi = rs.getString("nom_tournoi");
            System.out.println(nom_tournoi + "\n");
            }
            //String query ="SELECT nom_tournoi = '"+c+"' FROM `tournoi` WHERE `id_tournoi` = "+id+"";
            //st.executeUpdate(query); 
            //System.out.println(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<tournoi> afficher() throws SQLException {
        Statement stm = cnx.createStatement();
        List<tournoi> lp = new ArrayList<>();
        String query = "SELECT * FROM tournoi";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
        tournoi p = new tournoi();
        p.setId_tournoi(rs.getInt("id_tournoi"));
        p.setNom_tournoi(rs.getString("nom_tournoi"));
        p.setNbr_equipes(rs.getInt("nbr_equipes"));
        p.setDate_debut_tournoi(rs.getString("date_debut_tournoi"));
        p.setDate_fin_tournoi(rs.getString("date_fin_tournoi"));
        p.setHeure_match_tournoi(rs.getInt("heure_match_tournoi"));
        p.setNbr_poules(rs.getInt("nbr_poules"));
        lp.add(p);
        }
            return lp;
    }
}

 