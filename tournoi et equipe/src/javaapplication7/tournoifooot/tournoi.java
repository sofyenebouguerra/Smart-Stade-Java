/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.tournoifooot;

import java.sql.Date;

/**
 *
 * @author RafedDz
 */
public class tournoi {
    
    private int id_tournoi ;
    
    private String nom_tournoi ;
    
    private int nbr_equipes;
    
    private String date_debut_tournoi;
    
    private String date_fin_tournoi;
    
    private int heure_match_tournoi ;
    
    private int nbr_poules ;


    public tournoi() {
    }

    public tournoi(String nom_tournoi, int nbr_equipes, String date_debut_tournoi, String date_fin_tournoi, int heure_match_tournoi, int nbr_poules) {
        this.nom_tournoi = nom_tournoi;
        this.nbr_equipes = nbr_equipes;
        this.date_debut_tournoi = date_debut_tournoi;
        this.date_fin_tournoi = date_fin_tournoi;
        this.heure_match_tournoi = heure_match_tournoi;
        this.nbr_poules = nbr_poules;
    }

    public tournoi(int id_tournoi, String nom_tournoi, int nbr_equipes, String date_debut_tournoi, String date_fin_tournoi, int heure_match_tournoi, int nbr_poules) {
        this.id_tournoi = id_tournoi;
        this.nom_tournoi = nom_tournoi;
        this.nbr_equipes = nbr_equipes;
        this.date_debut_tournoi = date_debut_tournoi;
        this.date_fin_tournoi = date_fin_tournoi;
        this.heure_match_tournoi = heure_match_tournoi;
        this.nbr_poules = nbr_poules;
    }

    public tournoi(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public String getNom_tournoi() {
        return nom_tournoi;
    }

    public void setNom_tournoi(String nom_tournoi) {
        this.nom_tournoi = nom_tournoi;
    }

    public int getNbr_equipes() {
        return nbr_equipes;
    }

    public void setNbr_equipes(int nbr_equipes) {
        this.nbr_equipes = nbr_equipes;
    }

    public String getDate_debut_tournoi() {
        return date_debut_tournoi;
    }

    public void setDate_debut_tournoi(String date_debut_tournoi) {
        this.date_debut_tournoi = date_debut_tournoi;
    }

    public String getDate_fin_tournoi() {
        return date_fin_tournoi;
    }

    public void setDate_fin_tournoi(String date_fin_tournoi) {
        this.date_fin_tournoi = date_fin_tournoi;
    }

    public int getHeure_match_tournoi() {
        return heure_match_tournoi;
    }

    public void setHeure_match_tournoi(int heure_match_tournoi) {
        this.heure_match_tournoi = heure_match_tournoi;
    }

    public int getNbr_poules() {
        return nbr_poules;
    }

    public void setNbr_poules(int nbr_poules) {
        this.nbr_poules = nbr_poules;
    }

    @Override
    public String toString() {
        return "tournoi{" + "id_tournoi=" + id_tournoi + ", nom_tournoi=" + nom_tournoi + ", nbr_equipes=" + nbr_equipes + ", date_debut_tournoi=" + date_debut_tournoi + ", date_fin_tournoi=" + date_fin_tournoi + ", heure_match_tournoi=" + heure_match_tournoi + ", nbr_poules=" + nbr_poules + '}'+"\n";
    }
}