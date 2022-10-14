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
public class User {
     private int id_user;
     private String nom, prenom,mot_de_passe,email;
      public User() {
    }

    public User(String nom, String prenom, String mot_de_passe, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
    }
      
       public User(int id_user, String nom, String prenom, String mot_de_passe, String email) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        
       
    }

    

    

    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotdepasse() {
        return mot_de_passe;
    }
     public String getEmail() {
        return email;
    }
     

    
    

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMotdepasse(String mot_de_passe) {
        this.mot_de_passe =  mot_de_passe ;
    }
    public void setEmail(String email) {
        this.email= email ;
        
    }
    
  
       
  

    @Override
    public String toString() {
        return "Utilisateur{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom+ ", mot_de_passe=" + mot_de_passe + ", email=" + email  +"\n"+ '}';
    }
   
 
    
}
