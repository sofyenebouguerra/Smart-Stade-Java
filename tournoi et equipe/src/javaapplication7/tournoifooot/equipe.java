/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.tournoifooot;

/**
 *
 * @author RafedDz
 */
public class equipe {
    
    private int id_equipe;
    private String nom_equipe;
    private String abbreviation_equipe;
    private int nbr_effectif;
    private int nbr_staff;
    private String nom_president_equipe;
    private String nom_entraineur_equipe;
    private String nom_capitaine_equipe;

    public equipe() {
    }

    public equipe(String nom_equipe, String abbreviation_equipe, int nbr_effectif, int nbr_staff, String nom_president_equipe, String nom_entraineur_equipe, String nom_capitaine_equipe) {
        this.nom_equipe = nom_equipe;
        this.abbreviation_equipe = abbreviation_equipe;
        this.nbr_effectif = nbr_effectif;
        this.nbr_staff = nbr_staff;
        this.nom_president_equipe = nom_president_equipe;
        this.nom_entraineur_equipe = nom_entraineur_equipe;
        this.nom_capitaine_equipe = nom_capitaine_equipe;
    }

    public equipe(int id_equipe, String nom_equipe, String abbreviation_equipe, int nbr_effectif, int nbr_staff, String nom_president_equipe, String nom_entraineur_equipe, String nom_capitaine_equipe) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.abbreviation_equipe = abbreviation_equipe;
        this.nbr_effectif = nbr_effectif;
        this.nbr_staff = nbr_staff;
        this.nom_president_equipe = nom_president_equipe;
        this.nom_entraineur_equipe = nom_entraineur_equipe;
        this.nom_capitaine_equipe = nom_capitaine_equipe;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public String getAbbreviation_equipe() {
        return abbreviation_equipe;
    }

    public void setAbbreviation_equipe(String abbreviation_equipe) {
        this.abbreviation_equipe = abbreviation_equipe;
    }

    public int getNbr_effectif() {
        return nbr_effectif;
    }

    public void setNbr_effectif(int nbr_effectif) {
        this.nbr_effectif = nbr_effectif;
    }

    public int getNbr_staff() {
        return nbr_staff;
    }

    public void setNbr_staff(int nbr_staff) {
        this.nbr_staff = nbr_staff;
    }

    public String getNom_president_equipe() {
        return nom_president_equipe;
    }

    public void setNom_president_equipe(String nom_president_equipe) {
        this.nom_president_equipe = nom_president_equipe;
    }

    public String getNom_entraineur_equipe() {
        return nom_entraineur_equipe;
    }

    public void setNom_entraineur_equipe(String nom_entraineur_equipe) {
        this.nom_entraineur_equipe = nom_entraineur_equipe;
    }

    public String getNom_capitaine_equipe() {
        return nom_capitaine_equipe;
    }

    public void setNom_capitaine_equipe(String nom_capitaine_equipe) {
        this.nom_capitaine_equipe = nom_capitaine_equipe;
    }

    @Override
    public String toString() {
        return "equipe{" + "id_equipe=" + id_equipe + ", nom_equipe=" + nom_equipe + ", abbreviation_equipe=" + abbreviation_equipe + ", nbr_effectif=" + nbr_effectif + ", nbr_staff=" + nbr_staff + ", nom_president_equipe=" + nom_president_equipe + ", nom_entraineur_equipe=" + nom_entraineur_equipe + ", nom_capitaine_equipe=" + nom_capitaine_equipe + '}';
    }
}