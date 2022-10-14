/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

/**
 *
 * @author MSI
 */
public class stade {
    private int  id_stade;
    private String nom_stade;
    private int capacite;
    
    
    public stade(String nom_stade,int capacite) {
    this.nom_stade = nom_stade;
    this.capacite = capacite;    
    }
    
    public stade(int id_stade, String nom_stade,int capacite){
    this.id_stade = id_stade;
    this.nom_stade = nom_stade;
    this.capacite = capacite;
    
    }

    public stade() {
    
    }



    public int getId_stade() {
        return id_stade;
    }

    public void setId_stade(int id_stade) {
        this.id_stade = id_stade;
    }

     public String getNom_stade() {
        return nom_stade;
    }

    public void setNom_stade(String nom_stade) {
        this.nom_stade = nom_stade;
    }
    
     public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
           @Override
            public String toString() {
        return "stade{" + "nom_stade=" + nom_stade + ", capacite_s=" + capacite +  '}';
    }   
}
