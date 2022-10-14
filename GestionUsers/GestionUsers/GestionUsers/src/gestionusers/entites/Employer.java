/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.entites;

/**
 *
 * @author hajje
 */
public class Employer extends User{
    
    private String ref_employer,sexe,ref_magasin;

    public Employer() {
    }

    public Employer(String ref_employer,String sexe,String ref_magasin ,String nom, String prenom, String mot_de_passe, String email) {
        super(nom, prenom, mot_de_passe, email);
        this.ref_employer = ref_employer;
        
        this.sexe=sexe;
        
        this.ref_magasin=ref_magasin;
    }

    public Employer(String ref_employer,String sexe,String ref_magasin, int id_user, String nom, String prenom, String mot_de_passe, String email) {
        super(id_user, nom, prenom, mot_de_passe, email);
        this.ref_employer = ref_employer;
        
        this.sexe=sexe;
        
        this.ref_magasin=ref_magasin;
        
    }

    public String getRef_employer() {
        return ref_employer;
    }

    public void setRef_employer(String ref_employer) {
        this.ref_employer = ref_employer;
    }
   
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
        
    }
    
     public String getRefmagasin() {
        return ref_magasin;
    }

    public void setRefmagasin(String ref_magasin) {
        this.ref_magasin = ref_magasin;
        
    }
    
}
