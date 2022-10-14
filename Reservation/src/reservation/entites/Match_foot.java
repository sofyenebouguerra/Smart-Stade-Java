/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entites;

/**
 *
 * @author ismail
 */
public class Match_foot {
  
  private String ref_match ;
  private String date_match;
  private String nom_stade;
  private int nbr_spectateur;

    public Match_foot() {
    }

    public Match_foot(String ref_match, String date_match, String nom_stade,int nbr_spectateur) {
        this.ref_match = ref_match;
        this.date_match = date_match;
        this.nom_stade = nom_stade;
        this.nbr_spectateur=nbr_spectateur;
    }

    public int getNbr_spectateur() {
        return nbr_spectateur;
    }

    public void setNbr_spectateur(int nbr_spectateur) {
        this.nbr_spectateur = nbr_spectateur;
    }

    public String getRef_match() {
        return ref_match;
    }

    public void setRef_match(String ref_match) {
        this.ref_match = ref_match;
    }

    public String getDate_match() {
        return date_match;
    }

    public void setDate_match(String date_match) {
        this.date_match = date_match;
    }

    public String getNom_stade() {
        return nom_stade;
    }

    public void setNom_stade(String nom_stade) {
        this.nom_stade = nom_stade;
    }

    @Override
    public String toString() {
        return "Match_foot{" + "ref_match=" + ref_match + ", date_match=" + date_match + ", nom_stade=" + nom_stade + ", nbr_spectateur=" + nbr_spectateur + '}';
    }

    
    
}
