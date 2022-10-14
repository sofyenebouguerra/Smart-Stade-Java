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
import javaapplication7.tournoifooot.equipe;
import javaapplication7.service.IServicetournoi;
import javaapplication7.utils.Myconnexion;

/**
 *
 * @author RafedDz
 */
public class Serviceequipe implements IServicetournoi<equipe> {
    
    Connection cnx;
    
    public Serviceequipe (){
        cnx = Myconnexion.conDB();
    }
    
    @Override
    public void ajouter(equipe t) {
        Statement st;
        try {
            st = cnx.createStatement();
            String query ="INSERT INTO `equipe` ( `nom_equipe`,`abbreviation_equipe`,`nbr_effectif`,`nbr_staff`,`nom_president_equipe`,`nom_entraineur_equipe`,`nom_capitaine_equipe` ) VALUES ('"+t.getNom_equipe()+"','"+t.getAbbreviation_equipe()+"',"+t.getNbr_effectif()+","+t.getNbr_staff()+",'"+t.getNom_president_equipe()+"','"+t.getNom_entraineur_equipe()+"','"+t.getNom_capitaine_equipe()+"')";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(int id , equipe t) {  
        Statement st;
        try {
            st = cnx.createStatement();
            //String query = "UPDATE tournoi SET  nom_tournoi='"+t.getNom_tournoi()+"',nbr_equipes="+t.getNbr_equipes()+",date_debut_tournoi='"+t.getDate_debut_tournoi()+"',date_fin_tournoi='"+t.getDate_fin_tournoi()+"',heure_match_tournoi"+t.getHeure_match_tournoi()+"nbr_poules="+t.getNbr_poules()+" WHERE id_tournoi = "+id+" ";
            String query = "UPDATE `equipe` SET `nom_equipe`='"+t.getNom_equipe()+"',`abbreviation_equipe`='"+t.getAbbreviation_equipe()+"',`nbr_effectif`="+t.getNbr_effectif()+",`nbr_staff`="+t.getNbr_effectif()+",`nom_president_equipe`='"+t.getNom_president_equipe()+"',`nom_entraineur_equipe`='"+t.getNom_entraineur_equipe()+"',`nom_capitaine_equipe`='"+t.getNom_capitaine_equipe()+"' WHERE id_equipe = "+id+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(int id) {  
        Statement st;
        try {
            st = cnx.createStatement();
            String query ="DELETE FROM `equipe` where `id_equipe` = "+id+"";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void recherche(int id) {
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_equipe FROM equipe WHERE id_equipe = "+id+"");
            while (rs.next()){
            String nom_equipe = rs.getString("nom_equipe");
            System.out.println(nom_equipe + "\n");
            }
            //String query ="SELECT nom_tournoi = '"+c+"' FROM `tournoi` WHERE `id_tournoi` = "+id+"";
            //st.executeUpdate(query); 
            //System.out.println(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<equipe> afficher() throws SQLException {
        Statement stm = cnx.createStatement();
        List<equipe> lp = new ArrayList<>();
        String query = "SELECT * FROM equipe";
        ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
        equipe p = new equipe();
        p.setId_equipe(rs.getInt("id_equipe"));
        p.setNom_equipe(rs.getString("nom_equipe"));
        p.setAbbreviation_equipe(rs.getString("abbreviation_equipe"));
        p.setNbr_effectif(rs.getInt("nbr_effectif"));
        p.setNbr_staff(rs.getInt("nbr_staff"));
        p.setNom_president_equipe(rs.getString("nom_president_equipe"));
        p.setNom_entraineur_equipe(rs.getString("nom_entraineur_equipe"));
        p.setNom_capitaine_equipe(rs.getString("nom_capitaine_equipe"));
        lp.add(p);
        }
            return lp;
    }
    
}
