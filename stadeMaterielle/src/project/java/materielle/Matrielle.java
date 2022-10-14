/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

/**
 *
 * @author BAZINFO
 */
public class Matrielle {
    
    private int id_m ;
    
    private String nom_m;
    
    private String ref_m ;
    
    private String achat_m ;
    
    private String etat_m;
    
    private String disponibilite_m ;
    
    private int prix_m ;
    
   
    

    public Matrielle() {
    }

    public Matrielle(String nom_m, String ref_m, String achat_m, String etat_m, String disponibilite_m, int prix_m) {
        this.nom_m = nom_m;
        this.ref_m = ref_m;
        this.achat_m = achat_m;
        this.etat_m = etat_m;
        this.disponibilite_m = disponibilite_m;
        this.prix_m = prix_m;
      
        
    }

    public Matrielle(int id_m, String nom_m, String ref_m, String achat_m, String etat_m, String disponibilite_m, int prix_m) {
        this.id_m = id_m;
        this.nom_m = nom_m;
        this.ref_m = ref_m;
        this.achat_m = achat_m;
        this.etat_m = etat_m;
        this.disponibilite_m = disponibilite_m;
        this.prix_m = prix_m;
        
        
    }

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public String getNom_m() {
        return nom_m;
    }

    public void setNom_m(String nom_m) {
        this.nom_m = nom_m;
    }

    public String getRef_m() {
        return ref_m;
    }

    public void setRef_m(String ref_m) {
        this.ref_m = ref_m;
    }

    public String getAchat_m() {
        return achat_m;
    }

    public void setAchat_m(String achat_m) {
        this.achat_m = achat_m;
    }

    public String getEtat_m() {
        return etat_m;
    }

    public void setEtat_m(String etat_m) {
        this.etat_m = etat_m;
    }

    public String getDisponibilite_m() {
        return disponibilite_m;
    }

    public void setDisponibilite_m(String disponibilite_m) {
        this.disponibilite_m = disponibilite_m;
    }
    
    public int getPrix_m() {
        return prix_m;
    }

    public void setPrix_m(int prix_m) {
        this.prix_m = prix_m;
    }

    @Override
    public String toString() {
        return "Matrielle{" + "id_m=" + id_m + ", nom_m=" + nom_m + ", ref_m=" + ref_m + ", achat_m=" + achat_m + ", etat_m=" + etat_m + ", disponibilite_m=" + disponibilite_m + ", prix_m=" + prix_m + '}';
    }

   
    



  
    


    
}
